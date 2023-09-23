package com.github.shodo.fakeservice.core.adapter.repository

import com.github.shodo.fakeservice.core.domain.entity.Entity8
import com.github.shodo.fakeservice.core.domain.repository.Entity8Repository
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*


@Repository
interface JpaEntity8Repository : Entity8Repository, JpaRepository<Entity8, UUID>