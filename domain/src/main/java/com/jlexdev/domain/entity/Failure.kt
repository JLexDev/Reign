package com.jlexdev.domain.entity

/**
 * @author Joe Ramírez (@JLexDev) on 16/09/2021.
 * 1jlex3@gmail.com
 * ·
 * Trujillo - Perú
 **/

sealed class Failure {

    /** When service return 401 or 403 this will force the client to log out of the app.*/
    object UnauthorizedOrForbidden : Failure()

    /** When service return 206, it's not an error we have to send the client to register*/
    object PartialContent : Failure()

    /** Weird and strange error that we don´t know the cause.*/
    object None : Failure()

    /** When suddenly the connection is lost.*/
    object NetworkConnectionLostSuddenly : Failure()

    /** When there is no internet network detected.*/
    object NoNetworkDetected : Failure()

    /** When SSL (Secure Socket Layer) fail.*/
    object SSLError: Failure()

    /** When service is taking to long on return the response.*/
    object TimeOut: Failure()

    /** This class is for feature specific failures.*/
    data class ServiceUncaughtFailure(val uncaughtFailureMessage: String) : Failure()

    /** This class is for feature specific SERVICE ERROR BODY RESPONSE.*/
    data class ServerBodyError(val code: Int, val message: String) : Failure()

    /** This class is for feature specific DATA -> DOMAIN MAPPERS exceptions.*/
    data class DataToDomainMapperFailure(val mapperException: String?) : Failure()
}