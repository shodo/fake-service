package com.github.shodo.fakeservice.core.domain.service.subservice

import com.github.shodo.fakeservice.core.domain.repository.Entity8Repository
import java.util.*

class SubService8T1(
    val repository: Entity8Repository
) {
    fun execute() = repository.findAllById(UUID.randomUUID())
}