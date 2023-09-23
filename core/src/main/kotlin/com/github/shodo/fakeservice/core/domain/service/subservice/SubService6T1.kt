package com.github.shodo.fakeservice.core.domain.service.subservice

import com.github.shodo.fakeservice.core.domain.repository.Entity6Repository
import java.util.*

class SubService6T1(
    val repository: Entity6Repository
) {
    fun execute() = repository.findAllById(UUID.randomUUID())
}