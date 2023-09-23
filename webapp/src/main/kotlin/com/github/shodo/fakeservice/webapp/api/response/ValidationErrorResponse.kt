package com.github.shodo.fakeservice.webapp.api.response

import com.github.shodo.fakeservice.core.utils.camelToSnakeCase
import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming
import com.fasterxml.jackson.module.kotlin.MissingKotlinParameterException

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class ValidationErrorResponse(
    var errorCode: String,
    @kotlinx.serialization.Serializable
    var fields: Map<String, String> = mapOf()
) {
    companion object {
        fun fromException(exc: MissingKotlinParameterException): ValidationErrorResponse {
            val fields = mapOf(
                exc.parameter.name!!.camelToSnakeCase() to "Field is missing"
            )

            return ValidationErrorResponse("INVALID_DATA", fields)
        }
    }
}