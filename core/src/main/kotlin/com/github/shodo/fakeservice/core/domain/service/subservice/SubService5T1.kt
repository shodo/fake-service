package com.github.shodo.fakeservice.core.domain.service.subservice

import com.github.shodo.fakeservice.core.domain.repository.Entity5Repository
import java.util.*

class SubService5T1(
    val repository: Entity5Repository
) {
    fun execute() = repository.findAllById(UUID.randomUUID())
}