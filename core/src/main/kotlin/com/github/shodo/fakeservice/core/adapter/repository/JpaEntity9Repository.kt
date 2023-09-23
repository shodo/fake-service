package com.github.shodo.fakeservice.core.adapter.repository

import com.github.shodo.fakeservice.core.domain.entity.Entity9
import com.github.shodo.fakeservice.core.domain.repository.Entity9Repository
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*


@Repository
interface JpaEntity9Repository : Entity9Repository, JpaRepository<Entity9, UUID>