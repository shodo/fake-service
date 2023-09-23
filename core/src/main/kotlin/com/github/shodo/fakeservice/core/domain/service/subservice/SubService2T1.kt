package com.github.shodo.fakeservice.core.domain.service.subservice

import com.github.shodo.fakeservice.core.domain.repository.Entity2Repository
import java.util.*

class SubService2T1(
    val repository: Entity2Repository
) {
    fun execute() = repository.findAllById(UUID.randomUUID())
}