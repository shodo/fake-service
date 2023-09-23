package com.github.shodo.fakeservice.core.domain.service

import com.github.shodo.fakeservice.core.domain.service.subservice.SubService1T1
import com.github.shodo.fakeservice.core.domain.service.subservice.SubService2T1

class Service1T1(
    val service1: com.github.shodo.fakeservice.core.domain.service.subservice.SubService1T1,
    val service2: SubService2T1
) {
    fun execute() {
        service1.execute()
        service2.execute()
    }
}