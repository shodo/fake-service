package com.github.shodo.fakeservice.core.domain.usecase

import com.github.shodo.fakeservice.core.domain.service.*

class PatchUseCaseT1(
    val service1T1: Service1T1,
    val service2T1: Service2T1,
    val service3T1: Service3T1,
    val service4T1: Service4T1,
    val service5T1: Service5T1,
) {
    fun execute() {
        service1T1.execute()
        service2T1.execute()
        service3T1.execute()
        service4T1.execute()
        service5T1.execute()
    }
}
