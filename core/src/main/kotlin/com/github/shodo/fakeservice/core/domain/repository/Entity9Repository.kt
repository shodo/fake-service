package com.github.shodo.fakeservice.core.domain.repository

import com.github.shodo.fakeservice.core.domain.entity.Entity9
import java.util.*

interface Entity9Repository {
    fun findAllById(id: UUID) : List<Entity9>
}