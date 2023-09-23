package com.github.shodo.fakeservice.core.adapter.repository

import com.github.shodo.fakeservice.core.domain.entity.Entity4
import com.github.shodo.fakeservice.core.domain.repository.Entity4Repository
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*


@Repository
interface JpaEntity4Repository : Entity4Repository, JpaRepository<Entity4, UUID>