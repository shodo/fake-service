package com.github.shodo.fakeservice.core.domain.entity

import jakarta.persistence.*
import java.time.ZonedDateTime
import java.util.*

@Entity
@Table(
    name = "entity6",
)
class Entity6(
    id: UUID = UUID.randomUUID(),
    param1: String?,
    param2: String,
    param3: ZonedDateTime,
    param4: ZonedDateTime,
    param5: String,
    param6: String,
) {
    //region fields
    @Id
    @Column(columnDefinition = "UUID")
    var id: UUID = id
        protected set

    @Column(name = "param1", nullable = true)
    var param1: String? = param1
        protected set

    @Column(name = "param2", nullable = false)
    var param2: String = param2
        protected set

    @Column(name = "param3", nullable = false)
    var param3: ZonedDateTime = param3
        protected set

    @Column(name = "param4", nullable = false)
    var param4: ZonedDateTime = param4
        protected set

    @Column(name = "param5", nullable = false)
    var param5: String = param5
        protected set
    @Column(name = "param6", nullable = false)
    var param6: String = param6
        protected set
}