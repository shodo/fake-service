package com.github.shodo.fakeservice.core.domain.repository

import com.github.shodo.fakeservice.core.domain.entity.Entity4
import java.util.*

interface Entity4Repository {
    fun findAllById(id: UUID) : List<Entity4>
}