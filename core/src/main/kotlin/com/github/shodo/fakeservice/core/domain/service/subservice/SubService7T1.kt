package com.github.shodo.fakeservice.core.domain.service.subservice

import com.github.shodo.fakeservice.core.domain.repository.Entity7Repository
import java.util.*

class SubService7T1(
    val repository: Entity7Repository
) {
    fun execute() = repository.findAllById(UUID.randomUUID())
}