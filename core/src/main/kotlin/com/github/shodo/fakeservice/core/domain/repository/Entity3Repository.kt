package com.github.shodo.fakeservice.core.domain.repository

import com.github.shodo.fakeservice.core.domain.entity.Entity3
import java.util.*

interface Entity3Repository {
    fun findAllById(id: UUID) : List<Entity3>
}