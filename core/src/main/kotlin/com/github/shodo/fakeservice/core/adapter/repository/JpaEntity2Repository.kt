package com.github.shodo.fakeservice.core.adapter.repository

import com.github.shodo.fakeservice.core.domain.entity.Entity2
import com.github.shodo.fakeservice.core.domain.repository.Entity2Repository
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*


@Repository
interface JpaEntity2Repository : Entity2Repository, JpaRepository<Entity2, UUID>