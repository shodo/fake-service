package com.github.shodo.fakeservice.core.domain.service

import com.github.shodo.fakeservice.core.domain.service.subservice.SubService10T1
import com.github.shodo.fakeservice.core.domain.service.subservice.SubService9T1

class Service5T1(
    val service1: SubService9T1,
    val service2: SubService10T1
) {
    fun execute() {
        service1.execute()
        service2.execute()
    }
}