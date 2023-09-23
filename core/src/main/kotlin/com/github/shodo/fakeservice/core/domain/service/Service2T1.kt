package com.github.shodo.fakeservice.core.domain.service

import com.github.shodo.fakeservice.core.domain.service.subservice.SubService3T1
import com.github.shodo.fakeservice.core.domain.service.subservice.SubService4T1

class Service2T1(
    val service1: SubService3T1,
    val service2: SubService4T1
) {
    fun execute() {
        service1.execute()
        service2.execute()
    }
}