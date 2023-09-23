package com.github.shodo.fakeservice.core.domain.repository

import com.github.shodo.fakeservice.core.domain.entity.Entity6
import java.util.*

interface Entity6Repository {
    fun findAllById(id: UUID) : List<Entity6>
}