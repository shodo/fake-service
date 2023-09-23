package com.github.shodo.fakeservice.core.domain.service

import com.github.shodo.fakeservice.core.domain.service.subservice.SubService5T1
import com.github.shodo.fakeservice.core.domain.service.subservice.SubService6T1

class Service3T1(
    val service1: SubService5T1,
    val service2: SubService6T1
) {
    fun execute() {
        service1.execute()
        service2.execute()
    }
}