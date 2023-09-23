package com.github.shodo.fakeservice.core.domain.repository

import com.github.shodo.fakeservice.core.domain.entity.Entity5
import java.util.*

interface Entity5Repository {
    fun findAllById(id: UUID) : List<Entity5>
}