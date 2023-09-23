package com.github.shodo.fakeservice.webapp.api.controller

import com.github.shodo.fakeservice.core.domain.usecase.DeleteUseCaseT1
import com.github.shodo.fakeservice.core.domain.usecase.GetUseCaseT1
import com.github.shodo.fakeservice.core.domain.usecase.ListUseCaseT1
import com.github.shodo.fakeservice.core.domain.usecase.PatchUseCaseT1
import com.github.shodo.fakeservice.webapp.api.FakeServiceEndpoint
import org.springframework.web.bind.annotation.*

@RestController
@FakeServiceEndpoint
@RequestMapping("/v1/entity")
class GenericControllerT1(
    private val getUseCase: GetUseCaseT1,
    private val patchUseCase: PatchUseCaseT1,
    private val deleteUseCase: DeleteUseCaseT1,
    private val listUseCase: ListUseCaseT1,
)