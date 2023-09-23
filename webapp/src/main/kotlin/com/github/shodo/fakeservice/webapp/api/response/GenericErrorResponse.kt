package com.github.shodo.fakeservice.webapp.api.response

import com.github.shodo.fakeservice.core.DomainException
import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming


@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class GenericErrorResponse(
    var errorCode: String,
    var detail: String,
) {
    companion object {
        fun fromException(exc: DomainException) : GenericErrorResponse {

            return GenericErrorResponse(exc.errorCode.value, exc.message ?:"")
        }
    }
}
