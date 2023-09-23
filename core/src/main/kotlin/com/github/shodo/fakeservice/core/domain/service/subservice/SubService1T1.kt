package com.github.shodo.fakeservice.core.domain.service.subservice

import com.github.shodo.fakeservice.core.domain.repository.Entity1Repository
import java.util.*

class SubService1T1(
    val repository: Entity1Repository
) {
    fun execute() = repository.findAllById(UUID.randomUUID())
}