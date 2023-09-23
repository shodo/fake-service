package com.github.shodo.fakeservice.webapp.api.request

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming
import java.time.ZonedDateTime
import java.util.*

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class GenericRequestT1(
    val param1: GenericSubRequest1T1,
    val param2: GenericSubRequest1T1
)

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
@JsonIgnoreProperties(ignoreUnknown = true)
data class GenericSubRequest1T1(
    val param1: Int,
    val param2: Int?,
    val param3: ZonedDateTime?,
    val param4: String?,
    val param5: UUID,
    val param6: List<GenericSubRequest2T1>?,
    val param7: List<GenericSubRequest3T1>?,
)

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class GenericSubRequest2T1(
    val name: String,
    val targetId: String,
)

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class GenericSubRequest3T1(
    val name: String,
    val targetId: String,
)