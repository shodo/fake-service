package com.github.shodo.fakeservice.core.domain.repository

import com.github.shodo.fakeservice.core.domain.entity.Entity1
import java.util.*

interface Entity1Repository {
    fun findAllById(id: UUID) : List<Entity1>
}