package com.jlexdev.data.network.endpoints

import com.jlexdev.data.network.response.ReignResponse
import com.jlexdev.data.network.utils.NetworkUtils
import com.jlexdev.domain.entity.Either
import com.jlexdev.domain.entity.Failure
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONObject
import retrofit2.Response
import java.net.SocketTimeoutException
import javax.net.ssl.SSLException
import javax.net.ssl.SSLHandshakeException

/**
 * @author Joe Ramírez (@JLexDev) on 16/09/2021.
 * 1jlex3@gmail.com
 * ·
 * Trujillo - Perú
 **/

class EndPointsImpl(private val apiService: ApiService,
                    private val networkUtils: NetworkUtils) : EndPoints {

    companion object {
        private const val KEY_CODE = "code"
        private const val KEY_MESSAGE = "message"
    }

    // Get Hits
    override suspend fun getHits(query: String): Either<Failure, ReignResponse>
        = callService { apiService.getHits(query) }


    /**
     * Invoke the retrofit endpoint service in IO Context and after the response has been invoked
     * verify if its successful and if has a valid body.
     */
    private suspend inline fun <T> callService(crossinline retrofitCall: suspend ()-> Response<T>) : Either<Failure, T> {
        return when(networkUtils.isNetworkAvailable()) {
            true -> {
                try {
                    withContext(Dispatchers.IO) {
                        val response = retrofitCall.invoke()
                        if(response.isSuccessful && response.body() != null) {
                            if(response.code() == 206){
                                return@withContext Either.Left(Failure.PartialContent)
                            }
                            return@withContext Either.Right(response.body()!!)
                        } else {
                            return@withContext Either.Left(getErrorMessageFromServer(response.errorBody()?.string()
                            )
                            )
                        }
                    }
                } catch (e: Exception) {
                    return Either.Left(parseException(e))
                }
            }
            else -> Either.Left(Failure.NoNetworkDetected)
        }
    }

    /**
     * Parse Server Error to [Failure.ServerBodyError] if [errorBody] [isServerErrorValid].
     * @return [Failure] object.
     */
    private suspend fun getErrorMessageFromServer(errorBody: String?) : Failure {
        return if (errorBody != null) {
            return withContext(Dispatchers.IO) {
                val serverErrorJson = JSONObject(errorBody)
                when {
                    isServerErrorValid(serverErrorJson.toString()) -> {
                        val code = serverErrorJson[KEY_CODE].toString().toInt()
                        if (code == 401 || code == 403) {
                            return@withContext Failure.UnauthorizedOrForbidden
                        } else {
                            return@withContext Failure.ServerBodyError(code, serverErrorJson[KEY_MESSAGE].toString())
                        }
                    }
                    serverErrorJson.toString().contains("\"$KEY_MESSAGE\"") -> {
                        return@withContext Failure.ServiceUncaughtFailure(serverErrorJson[KEY_MESSAGE].toString())
                    }
                    else -> return@withContext Failure.None
                }
            }
        } else {
            Failure.None
        }
    }

    private fun isServerErrorValid(error: String) : Boolean{
        return error.contains("\"$KEY_CODE\"") && error.contains("\"$KEY_MESSAGE\"")
    }

    private fun parseException(throwable: Throwable) : Failure {
        return when(throwable) {
            is SocketTimeoutException -> Failure.TimeOut
            is SSLException -> Failure.NetworkConnectionLostSuddenly
            is SSLHandshakeException -> Failure.SSLError
            else -> Failure.ServiceUncaughtFailure(throwable.message?:"Service response doesn't match with response object.")
        }
    }
}