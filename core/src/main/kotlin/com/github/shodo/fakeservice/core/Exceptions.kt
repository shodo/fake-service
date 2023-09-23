package com.github.shodo.fakeservice.core

import com.github.shodo.fakeservice.core.ErrorCode.*


open class DomainException(val errorCode: ErrorCode = GENERIC_ERROR, message: String? = null) :
    RuntimeException(message) {
    override val message = message ?: super.message
}

class RequestAlreadyAcceptedException : RuntimeException()

class InvalidDomainRequestException(errorCode: ErrorCode = GENERIC_ERROR, message: String? = null) :
    DomainException(errorCode, message)

class ConflictedDomainStateException(errorCode: ErrorCode = GENERIC_ERROR, message: String? = null) :
    DomainException(errorCode, message)

class CorruptedDomainStateException(errorCode: ErrorCode = GENERIC_ERROR, message: String? = null) :
    DomainException(errorCode, message)

class TechnicalException(errorCode: ErrorCode = GENERIC_ERROR, message: String? = null) :
    DomainException(errorCode, message)

class NeededEntityNotFoundException(errorCode: ErrorCode = GENERIC_ERROR, message: String? = null) :
    DomainException(errorCode, message)

class UnauthorizedException(message: String? = null) :
    DomainException(UNAUTHORIZED_ERROR, message)

class UnauthenticatedException(message: String? = null) :
    DomainException(UNAUTHENTICATED_ERROR, message)

enum class ErrorCode(var value: String) {
    GENERIC_ERROR("generic-error"),

    //region Authentication/Authorization
    UNAUTHORIZED_ERROR("user-is-not-authorized"),
    UNAUTHENTICATED_ERROR("user-is-not-authenticated");
    //endregion

    override fun toString(): String {
        return value
    }
}
