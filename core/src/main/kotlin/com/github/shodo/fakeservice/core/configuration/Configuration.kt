package com.github.shodo.fakeservice.core.configuration

import com.github.shodo.fakeservice.core.domain.repository.*
import com.github.shodo.fakeservice.core.domain.service.*
import com.github.shodo.fakeservice.core.domain.service.subservice.*
import com.github.shodo.fakeservice.core.domain.usecase.DeleteUseCaseT1
import com.github.shodo.fakeservice.core.domain.usecase.GetUseCaseT1
import com.github.shodo.fakeservice.core.domain.usecase.ListUseCaseT1
import com.github.shodo.fakeservice.core.domain.usecase.PatchUseCaseT1
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.retry.annotation.EnableRetry


@Configuration
@EnableRetry
class Configuration {
    //region SubService
    @Bean
    fun subService1T1(repository: Entity1Repository) = SubService1T1(repository)
    @Bean
    fun subService2T1(repository: Entity2Repository) = SubService2T1(repository)
    @Bean
    fun subService3T1(repository: Entity3Repository) = SubService3T1(repository)
    @Bean
    fun subService4T1(repository: Entity4Repository) = SubService4T1(repository)
    @Bean
    fun subService5T1(repository: Entity5Repository) = SubService5T1(repository)
    @Bean
    fun subService6T1(repository: Entity6Repository) = SubService6T1(repository)
    @Bean
    fun subService7T1(repository: Entity7Repository) = SubService7T1(repository)
    @Bean
    fun subService8T1(repository: Entity8Repository) = SubService8T1(repository)
    @Bean
    fun subService9T1(repository: Entity9Repository) = SubService9T1(repository)
    @Bean
    fun subService10T1(repository: Entity10Repository) = SubService10T1(repository)
    //endregion

    //region Service
    @Bean
    fun service1T1(
        subService1T1: SubService1T1,
        subService2T1: SubService2T1
    ) = Service1T1(subService1T1, subService2T1)

    @Bean
    fun service2T1(
        subService3T1: SubService3T1,
        subService4T1: SubService4T1
    ) = Service2T1(subService3T1, subService4T1)

    @Bean
    fun service3T1(
        subService5T1: SubService5T1,
        subService6T1: SubService6T1
    ) = Service3T1(subService5T1, subService6T1)

    @Bean
    fun service4T1(
        subService7T1: SubService7T1,
        subService8T1: SubService8T1
    ) = Service4T1(subService7T1, subService8T1)

    @Bean
    fun service5T1(
        subService9T1: SubService9T1,
        subService10T1: SubService10T1
    ) = Service5T1(subService9T1, subService10T1)
    //endregion

    //region UseCase
    @Bean
    fun deleteUseCaseT1(
        service1T1: Service1T1,
        service2T1: Service2T1,
        service3T1: Service3T1,
        service4T1: Service4T1,
        service5T1: Service5T1
    ) = DeleteUseCaseT1(service1T1, service2T1, service3T1, service4T1, service5T1)

    @Bean
    fun getUseCaseT1(
        service1T1: Service1T1,
        service2T1: Service2T1,
        service3T1: Service3T1,
        service4T1: Service4T1,
        service5T1: Service5T1
    ) = GetUseCaseT1(service1T1, service2T1, service3T1, service4T1, service5T1)

    @Bean
    fun listUseCaseT1(
        service1T1: Service1T1,
        service2T1: Service2T1,
        service3T1: Service3T1,
        service4T1: Service4T1,
        service5T1: Service5T1
    ) = ListUseCaseT1(service1T1, service2T1, service3T1, service4T1, service5T1)

    @Bean
    fun patchUseCaseT1(
        service1T1: Service1T1,
        service2T1: Service2T1,
        service3T1: Service3T1,
        service4T1: Service4T1,
        service5T1: Service5T1
    ) = PatchUseCaseT1(service1T1, service2T1, service3T1, service4T1, service5T1)
    //endregion
}