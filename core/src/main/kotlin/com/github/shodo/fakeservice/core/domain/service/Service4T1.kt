package com.github.shodo.fakeservice.core.domain.service

import com.github.shodo.fakeservice.core.domain.service.subservice.SubService7T1
import com.github.shodo.fakeservice.core.domain.service.subservice.SubService8T1

class Service4T1(
    val service1: SubService7T1,
    val service2: SubService8T1
) {
    fun execute() {
        service1.execute()
        service2.execute()
    }
}