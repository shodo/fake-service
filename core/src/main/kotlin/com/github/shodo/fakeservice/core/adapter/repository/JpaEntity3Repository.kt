package com.github.shodo.fakeservice.core.adapter.repository

import com.github.shodo.fakeservice.core.domain.entity.Entity3
import com.github.shodo.fakeservice.core.domain.repository.Entity3Repository
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*


@Repository
interface JpaEntity3Repository : Entity3Repository, JpaRepository<Entity3, UUID>