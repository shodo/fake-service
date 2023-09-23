package com.github.shodo.fakeservice.webapp.configuration

import com.github.shodo.fakeservice.core.configuration.Configuration
import com.github.shodo.fakeservice.webapp.api.response.ResponseConverter
import org.springframework.boot.SpringBootConfiguration
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.*
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@SpringBootConfiguration
@EnableJpaRepositories(
    "com.github.shodo.fakeservice.core.adapter.repository",
)
@EntityScan(
    "com.github.shodo.fakeservice.core.domain.entity",
)
@Import(
    Configuration::class,
)
class WebAppConfiguration : WebMvcConfigurer {
    override fun configurePathMatch(configurer: PathMatchConfigurer) {
        configurer.setUseTrailingSlashMatch(true);
    }

    @Bean
    fun responseConverter() = ResponseConverter()
}