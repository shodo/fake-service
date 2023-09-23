package com.github.shodo.fakeservice.webapp.api

import com.github.shodo.fakeservice.webapp.api.response.GenericErrorResponse
import com.github.shodo.fakeservice.webapp.api.response.ValidationErrorResponse
import com.fasterxml.jackson.module.kotlin.MissingKotlinParameterException
import com.github.shodo.fakeservice.core.*
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.security.authentication.InsufficientAuthenticationException
import org.springframework.security.oauth2.core.OAuth2AuthenticationException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
class ExceptionHandler() : ResponseEntityExceptionHandler() {

    @ExceptionHandler(value = [Exception::class])
    protected fun handleInternalServerError(
        ex: RuntimeException?, request: WebRequest?
    ): ResponseEntity<Any>? {
        logger.error("Error, returning 500", ex)
        val response = GenericErrorResponse(ErrorCode.GENERIC_ERROR.value, "A generic error occurred")
        return handleExceptionInternal(
            ex!!, response,
            HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request!!
        )
    }

    @ExceptionHandler(value = [RequestAlreadyAcceptedException::class])
    protected fun requestAlreadyAccepted(ex: RequestAlreadyAcceptedException, request: WebRequest?)
            : ResponseEntity<Unit> {
        return ResponseEntity<Unit>(HttpStatus.ACCEPTED)
    }

    @ExceptionHandler(value = [NeededEntityNotFoundException::class])
    protected fun handleEntityNotFound(ex: NeededEntityNotFoundException, request: WebRequest?)
            : ResponseEntity<GenericErrorResponse> {
        return ResponseEntity(GenericErrorResponse.fromException(ex), HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler(value = [ConflictedDomainStateException::class])
    protected fun handleConflict(ex: ConflictedDomainStateException, request: WebRequest?)
            : ResponseEntity<GenericErrorResponse> {
        return ResponseEntity(GenericErrorResponse.fromException(ex), HttpStatus.CONFLICT)
    }

    @ExceptionHandler(value = [InvalidDomainRequestException::class])
    protected fun handleInvalidDomainRequest(ex: InvalidDomainRequestException, request: WebRequest?)
            : ResponseEntity<GenericErrorResponse> {
        return ResponseEntity(GenericErrorResponse.fromException(ex), HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(value = [UnauthorizedException::class])
    protected fun handleUnauthorizedException(ex: UnauthorizedException, request: WebRequest?)
            : ResponseEntity<GenericErrorResponse> {
        return ResponseEntity(GenericErrorResponse.fromException(ex), HttpStatus.FORBIDDEN)
    }

    @ExceptionHandler(value = [UnauthenticatedException::class])
    protected fun handleUnauthenticatedException(ex: UnauthenticatedException, request: WebRequest?)
            : ResponseEntity<GenericErrorResponse> {
        return ResponseEntity(GenericErrorResponse.fromException(ex), HttpStatus.UNAUTHORIZED)
    }

    @ExceptionHandler(value = [InsufficientAuthenticationException::class])
    protected fun handleInsufficientAuthenticationException(ex: InsufficientAuthenticationException, request: WebRequest?)
            : ResponseEntity<GenericErrorResponse> {
        return ResponseEntity(GenericErrorResponse(ErrorCode.UNAUTHENTICATED_ERROR.value, ex.message!!), HttpStatus.UNAUTHORIZED)
    }

    @ExceptionHandler(value = [OAuth2AuthenticationException::class])
    protected fun handleOAuth2AuthenticationException(ex: OAuth2AuthenticationException, request: WebRequest?)
            : ResponseEntity<GenericErrorResponse> {
        return ResponseEntity(GenericErrorResponse(ErrorCode.UNAUTHENTICATED_ERROR.value, ex.message!!), HttpStatus.UNAUTHORIZED)
    }

    @ExceptionHandler(value = [CorruptedDomainStateException::class])
    protected fun handleCorruptedDomainException(ex: CorruptedDomainStateException, request: WebRequest?)
            : ResponseEntity<GenericErrorResponse> {
        return ResponseEntity(GenericErrorResponse.fromException(ex), HttpStatus.INTERNAL_SERVER_ERROR)
    }

    open class DomainException(val errorCode: ErrorCode = ErrorCode.GENERIC_ERROR, message: String? = null) :
        RuntimeException(message) {
        override val message = message ?: super.message
    }


    override fun handleHttpMessageNotReadable(
        ex: HttpMessageNotReadableException,
        headers: HttpHeaders,
        status: HttpStatusCode,
        request: WebRequest
    ): ResponseEntity<Any> =
        when (val cause = ex.cause) {
            is MissingKotlinParameterException -> ResponseEntity(
                ValidationErrorResponse.fromException(cause),
                HttpStatus.BAD_REQUEST,
            )
            else -> ResponseEntity(
                GenericErrorResponse.fromException(
                    InvalidDomainRequestException(
                        errorCode = ErrorCode.GENERIC_ERROR,
                        message = ex.message,
                    )
                ),
                HttpStatus.BAD_REQUEST,
            )
        }
}
