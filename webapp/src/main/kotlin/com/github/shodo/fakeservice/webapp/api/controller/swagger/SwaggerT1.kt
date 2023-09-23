package com.github.shodo.fakeservice.webapp.api.controller.swagger

import com.github.shodo.fakeservice.webapp.Constants
import io.swagger.v3.oas.annotations.Parameter

@Parameter(
    name = "Account ID",
    description = "The account ID of the company.",
    required = true,
    example = "602c335e79bed70d74ea4d2e",
)
annotation class RequiredAccountIdDescription

@Parameter(
    name = "Account ID",
    description = "The account ID of the company.",
    required = false,
    example = "602c335e79bed70d74ea4d2e",
)
annotation class OptionalAccountIdDescription

@Parameter(
    name = "Content ID",
    description = "The ID of the content related to a program step.",
    required = false,
    example = "602c335e79bed70d74ea4d2e",
)
annotation class OptionalContentIdDescription

@Parameter(
    name = Constants.TENANT_HEADER,
    description = "The tenant of the request.",
    required = true,
    example = "FAKECOMPANY",
)
annotation class RequiredTenantDescription

@Parameter(
    name = "Program ID",
    description = "The ID of the program.",
    required = true,
    example = "15cb972f-96ee-4f74-ba2e-c59109725dbd",
)
annotation class RequiredProgramIdDescription

@Parameter(
    name = "A list of program IDs",
    description = "A list of program IDs to delete, comma-separated.",
    required = true,
    example = "15cb972f-96ee-4f74-ba2e-c59109725dbd,f2f15bad-616e-41a3-838f-bf394c2283bf",
)
annotation class RequiredProgramIdListDescription

@Parameter(
    name = "User ID",
    description = "The ID of the user",
    required = true,
    example = "d6199909d0b5fdc22",
)
annotation class RequiredUserIdDescription

@Parameter(
    name = "User Program Assignment ID",
    description = "The ID of the user program assignment.",
    required = true,
    example = "15cb972f-96ee-4f74-ba2e-c59109725dbd",
)
annotation class RequiredUserProgramAssignmentIdDescription

@Parameter(
    name = "User Program Assignment ids",
    description = "The list of user program assignment ids used to filter the output",
    required = false,
    example = "15cb972f-96ee-4f74-ba2e-c59109725dbd,f2f15bad-616e-41a3-838f-bf394c2283bf",
)
annotation class OptionalUserProgramAssignmentIdsDescription

@Parameter(
    name = "User Program Assignment ids",
    description = "The list of user program assignment ids used to filter the output",
    required = true,
    example = "15cb972f-96ee-4f74-ba2e-c59109725dbd,f2f15bad-616e-41a3-838f-bf394c2283bf",
)
annotation class RequiredUserProgramAssignmentIdsDescription

@Parameter(
    name = "Page",
    description = "The page of the list starting from 1.",
    required = false,
    example = "1",
)
annotation class OptionalPageIndexDescription

@Parameter(
    name = "Size",
    description = "The number of results to get. Defaults to 50.",
    required = false,
    example = "50",
)
annotation class OptionalPageSizeDescription


@Parameter(
    name = "A list of skill IDs",
    description = "A list of skill IDs to filter the results, comma-separated.",
    required = false,
    example = "15cb972f-96ee-4f74-ba2e-c59109725dbd,f2f15bad-616e-41a3-838f-bf394c2283bf",
)
annotation class OptionalSkillIdsDescription

@Parameter(
    name = "Smart Rule ID",
    description = "The ID of the smart rule",
    required = true,
    example = "15cb972f-96ee-4f74-ba2e-c59109725dbd",
)
annotation class RequiredSmartRuleIdDescription

@Parameter(
    name = "Target ID",
    description = "The ID of the target of the smart rule.",
    required = true,
    example = "15cb972f-96ee-4f74-ba2e-c59109725dbd",
)
annotation class RequiredTargetIdDescription

@Parameter(
    name = "User Assignment statuses",
    description = "The list of assignment statuses used to filter the output",
    required = true,
    example = "[ACTIVE,PAST]",
)
annotation class RequiredUserTrainingAssignmentStatuses

@Parameter(
    name = "User Assignment assigner types",
    description = "The list of User Assignment assigner types used to filter the output",
    required = true,
    example = "[MANAGER]",
)
annotation class RequiredUserTrainingAssignerTypes

@Parameter(
    name = "Sorting logic applied.",
    description = "The sorting you want to apply when retrieving the assignments.",
    required = false,
    example = "CUSTOM",
)
annotation class OptionalTrainingAssignmentSortingLogicDescription

@Parameter(
    name = "User Training Assignment Id",
    description = "The id of the UserTrainingAssignment we need to retrieve",
    required = true,
    example = "3580b5f8-94ae-4789-a71a-72183e73b57b",
)
annotation class RequiredUserTrainingAssignmentIdDescription