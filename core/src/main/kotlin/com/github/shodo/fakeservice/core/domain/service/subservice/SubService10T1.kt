package com.github.shodo.fakeservice.core.domain.service.subservice

import com.github.shodo.fakeservice.core.domain.repository.Entity10Repository
import java.util.*

class SubService10T1(
    val repository: Entity10Repository
) {
    fun execute() = repository.findAllById(UUID.randomUUID())
}