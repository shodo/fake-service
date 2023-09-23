package com.github.shodo.fakeservice.core.adapter.repository

import com.github.shodo.fakeservice.core.domain.entity.Entity6
import com.github.shodo.fakeservice.core.domain.repository.Entity6Repository
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*


@Repository
interface JpaEntity6Repository : Entity6Repository, JpaRepository<Entity6, UUID>