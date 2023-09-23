package com.github.shodo.fakeservice.webapp.api.controller

import com.github.shodo.fakeservice.core.domain.usecase.DeleteUseCaseT1
import com.github.shodo.fakeservice.core.domain.usecase.GetUseCaseT1
import com.github.shodo.fakeservice.core.domain.usecase.ListUseCaseT1
import com.github.shodo.fakeservice.core.domain.usecase.PatchUseCaseT1
import com.github.shodo.fakeservice.webapp.api.FakeServiceEndpoint
import com.github.shodo.fakeservice.webapp.api.controller.swagger.RequiredAccountIdDescription
import com.github.shodo.fakeservice.webapp.api.controller.swagger.RequiredProgramIdDescription
import com.github.shodo.fakeservice.webapp.api.response.FakeResponseT1
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@Tag(name = "Program")
@FakeServiceEndpoint
@RequestMapping("/v1/entity")
class GenericControllerT1(
    private val getUseCase: GetUseCaseT1,
    private val patchUseCase: PatchUseCaseT1,
    private val deleteUseCase: DeleteUseCaseT1,
    private val listUseCase: ListUseCaseT1,
) {
//    @GetProgramSwagger
//    @GetMapping("/{accountId}/{id}")
//    fun getProgram(
//    @RequiredAccountIdDescription @PathVariable accountId: String,
//    @RequiredProgramIdDescription @PathVariable id: UUID
//    ): ResponseEntity<FakeResponseT1> {
////        return getProgramUseCase.execute(accountId, programId).let {
////            responseConverter.toGetProgramResponse(program = it)
////        }.let {
////            ResponseEntity(it, HttpStatus.OK)
////        }
//    }


//    @UpdateProgramSwagger
//    @PatchMapping("/{accountId}/programs/{programId}")
//    fun updateProgram(
//        @RequiredAccountIdDescription @PathVariable accountId: String,
//        @RequiredProgramIdDescription @PathVariable programId: UUID,
//        @RequestBody updateProgramRequest: UpdateProgramRequest,
//        @RequiredTenantDescription @RequestHeader(Constants.TENANT_HEADER) tenantFromHeader: String,
//    ): ResponseEntity<FakeResponseT1> {
//        val tenant = Tenant.valueOf(tenantFromHeader.uppercase())
//
//        return updateProgramUseCase.execute(updateProgramRequest.toCommand(programId, accountId, tenant, actorId))
//            .let {
//                responseConverter.toGetProgramResponse(it)
//            }
//            .let {
//                ResponseEntity(it, HttpStatus.OK)
//            }
//    }
//
//
//    @GetProgramSwagger
//    @GetMapping("/{accountId}/programs/{programId}")
//    fun getProgram(
//        @RequiredAccountIdDescription @PathVariable accountId: String,
//        @RequiredProgramIdDescription @PathVariable programId: UUID
//    ): ResponseEntity<ProgramResponse> {
//        return getProgramUseCase.execute(accountId, programId).let {
//            responseConverter.toGetProgramResponse(program = it)
//        }.let {
//            ResponseEntity(it, HttpStatus.OK)
//        }
//    }
//
//
//    @DeleteProgramListSwagger
//    @DeleteMapping("/{accountId}/programs")
//    fun deleteProgramList(
//        @RequiredAccountIdDescription @PathVariable accountId: String,
//        @RequiredProgramIdListDescription @RequestParam programIds: List<UUID>,
//        @RequestHeader(Constants.TENANT_HEADER) tenantFromHeader: String,
//    ): ResponseEntity<Unit> {
//        val tenant = Tenant.valueOf(tenantFromHeader.uppercase())
//        val actorId = requester.externalUserId
//
//        deleteProgramsUseCase.execute(
//            DeleteProgramsCommand(tenant = tenant, accountId = accountId, programIds = programIds, actorId = actorId)
//        )
//
//        return ResponseEntity<Unit>(HttpStatus.NO_CONTENT)
//
//    }
//
//
//    @PostMapping("/{accountId}/programs/{programId}/archive")
//    fun archiveProgram(
//        @RequiredAccountIdDescription @PathVariable accountId: String,
//        @RequiredProgramIdDescription @PathVariable programId: UUID,
//    ): ResponseEntity<ProgramResponse> {
//        return archiveProgramUseCase.execute(programId, accountId, requester.externalUserId)
//            .let {
//                responseConverter.toGetProgramResponse(it)
//            }.let {
//                ResponseEntity(it, HttpStatus.OK)
//            }
//    }
}