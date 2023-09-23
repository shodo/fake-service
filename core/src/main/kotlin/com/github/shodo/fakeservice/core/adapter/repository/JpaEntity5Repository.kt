package com.github.shodo.fakeservice.core.adapter.repository

import com.github.shodo.fakeservice.core.domain.entity.Entity5
import com.github.shodo.fakeservice.core.domain.repository.Entity5Repository
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*


@Repository
interface JpaEntity5Repository : Entity5Repository, JpaRepository<Entity5, UUID>