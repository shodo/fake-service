package com.github.shodo.fakeservice.core.domain.service.subservice

import com.github.shodo.fakeservice.core.domain.repository.Entity3Repository
import java.util.*

class SubService3T1(
    val repository: Entity3Repository
) {
    fun execute() = repository.findAllById(UUID.randomUUID())
}