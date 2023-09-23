package com.github.shodo.fakeservice.webapp.api.response

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming
import java.util.*

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class FakeResponseT1(
    val param1: String,
    val param2: Int,
    val param3: UUID,
    val param4: String?,
    val param5: Int?,
    val param6: UUID?,
    val param7: SubFakeResponseT1
)

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
data class SubFakeResponseT1(
    val param1: String,
    val param2: Int,
    val param3: UUID,
    val param4: String?,
    val param5: Int?,
    val param6: UUID?,
)