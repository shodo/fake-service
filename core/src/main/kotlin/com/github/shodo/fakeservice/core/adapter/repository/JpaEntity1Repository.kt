package com.github.shodo.fakeservice.core.adapter.repository

import com.github.shodo.fakeservice.core.domain.entity.Entity1
import com.github.shodo.fakeservice.core.domain.repository.Entity1Repository
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*


@Repository
interface JpaEntity1Repository : Entity1Repository, JpaRepository<Entity1, UUID>