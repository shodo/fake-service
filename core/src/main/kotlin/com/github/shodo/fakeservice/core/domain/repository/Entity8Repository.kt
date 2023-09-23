package com.github.shodo.fakeservice.core.domain.repository

import com.github.shodo.fakeservice.core.domain.entity.Entity8
import java.util.*

interface Entity8Repository {
    fun findAllById(id: UUID) : List<Entity8>
}