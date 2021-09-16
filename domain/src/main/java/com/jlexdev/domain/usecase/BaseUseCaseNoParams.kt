package com.jlexdev.domain.usecase

import com.jlexdev.domain.entity.Either
import com.jlexdev.domain.entity.Failure
import kotlinx.coroutines.*

/**
 * @author Joe Ramírez (@JLexDev) on 16/09/2021.
 * 1jlex3@gmail.com
 * ·
 * Trujillo - Perú
 **/

abstract class BaseUseCaseNoParams<out Result> where Result : Any {

    abstract suspend fun run(): Either<Failure, Result>

    open operator fun invoke(
        scope: CoroutineScope,
        onResult: (Either<Failure, Result>) -> Unit = {}
    ) {
        val exceptionHandler = CoroutineExceptionHandler { _, throwable -> onResult(
            Either.Left(
                Failure.DataToDomainMapperFailure(throwable.message))) }
        val backgroundJob = scope.async(Dispatchers.IO) { run() }
        scope.launch(exceptionHandler) { onResult(backgroundJob.await()) }
    }
}