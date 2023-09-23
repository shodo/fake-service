package com.github.shodo.fakeservice.core.domain.repository

import com.github.shodo.fakeservice.core.domain.entity.Entity2
import java.util.*

interface Entity2Repository {
    fun findAllById(id: UUID) : List<Entity2>
}