package com.github.shodo.fakeservice.core.adapter.repository

import com.github.shodo.fakeservice.core.domain.entity.Entity10
import com.github.shodo.fakeservice.core.domain.repository.Entity10Repository
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*


@Repository
interface JpaEntity10Repository : Entity10Repository, JpaRepository<Entity10, UUID>