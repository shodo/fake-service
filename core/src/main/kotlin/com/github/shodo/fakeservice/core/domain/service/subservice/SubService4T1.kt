package com.github.shodo.fakeservice.core.domain.service.subservice

import com.github.shodo.fakeservice.core.domain.repository.Entity4Repository
import java.util.*

class SubService4T1(
    val repository: Entity4Repository
) {
    fun execute() = repository.findAllById(UUID.randomUUID())
}