package com.github.shodo.fakeservice.webapp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class FakeServiceApplication

fun main(args: Array<String>) {
	runApplication<FakeServiceApplication>(*args)
}
