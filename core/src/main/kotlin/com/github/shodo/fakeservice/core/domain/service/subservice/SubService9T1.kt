package com.github.shodo.fakeservice.core.domain.service.subservice

import com.github.shodo.fakeservice.core.domain.repository.Entity9Repository
import java.util.*

class SubService9T1(
    val repository: Entity9Repository
) {
    fun execute() = repository.findAllById(UUID.randomUUID())
}