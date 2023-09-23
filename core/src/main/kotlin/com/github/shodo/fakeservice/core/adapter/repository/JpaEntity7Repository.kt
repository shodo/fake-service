package com.github.shodo.fakeservice.core.adapter.repository

import com.github.shodo.fakeservice.core.domain.entity.Entity7
import com.github.shodo.fakeservice.core.domain.repository.Entity7Repository
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*


@Repository
interface JpaEntity7Repository : Entity7Repository, JpaRepository<Entity7, UUID>