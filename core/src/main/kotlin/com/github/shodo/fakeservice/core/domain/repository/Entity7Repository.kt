package com.github.shodo.fakeservice.core.domain.repository

import com.github.shodo.fakeservice.core.domain.entity.Entity7
import java.util.*

interface Entity7Repository {
    fun findAllById(id: UUID) : List<Entity7>
}