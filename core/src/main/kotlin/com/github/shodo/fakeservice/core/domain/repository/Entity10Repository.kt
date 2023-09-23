package com.github.shodo.fakeservice.core.domain.repository

import com.github.shodo.fakeservice.core.domain.entity.Entity10
import java.util.*

interface Entity10Repository {
    fun findAllById(id: UUID) : List<Entity10>
}