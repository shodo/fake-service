package com.github.shodo.fakeservice.webapp.api

import com.github.shodo.fakeservice.webapp.api.response.GenericErrorResponse
import com.github.shodo.fakeservice.webapp.api.response.ValidationErrorResponse
import io.swagger.v3.oas.annotations.ExternalDocumentation
import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Info
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.ExampleObject
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.servers.Server


@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS)
@OpenAPIDefinition(
    info = Info(
        title = "FakeService",
        description = "A fake service",
        version = "v1",
    ),
    servers = [
        Server(
            url = "https://localhost:25400",
            description = "Local",
        ),
    ],
)
@ApiResponses(
    value = [
        ApiResponse(
            responseCode = "400",
            description = "The application cannot understand the request. The response SHOULD contain the reason why it was rejected.",
            content = [
                (Content(
                    mediaType = "application/json",
                    schema = (
                            Schema(oneOf = [GenericErrorResponse::class, ValidationErrorResponse::class])
                            ),
                    examples = [
                        ExampleObject(
                            value = "{\"error_code\": \"Missing tenant header in the request\"}"
                        ),
                        ExampleObject(
                            value = "{\"error_code\": \"Wrong tenant FOO_BAR in the request\"}"
                        ),
                        ExampleObject(
                            value = "{\"error_code\": \"generic-error\", \"detail\": \"A generic error occurred\"}"
                        ),
                        ExampleObject(
                            value = "{\"error_code\": \"INVALID_DATA\", \"fields\": \"{\"name\": \"Field is missing\"}\"}"
                        ),
                    ]
                )),
            ]
        ),
        ApiResponse(
            responseCode = "401", description = "Permission check failed", content = [
                (Content(
                    mediaType = "application/json",
                    schema = (
                            Schema(implementation = GenericErrorResponse::class)
                            ),
                    examples = [ExampleObject(
                        value = "{\"error_code\": \"generic-error\", \"detail\": \"A generic error occurred\"}"
                    )]
                ))]
        ),
        ApiResponse(
            responseCode = "403", description = "Permission check failed", content = [
                (Content(
                    mediaType = "application/json",
                    schema = (
                            Schema(implementation = GenericErrorResponse::class)
                            ),
                    examples = [ExampleObject(
                        value = "{\"error_code\": \"generic-error\", \"detail\": \"A generic error occurred\"}"
                    )]
                ))]
        ),
        ApiResponse(
            responseCode = "500",
            description = "Unhandled internal exception.",
            content = [Content(
                mediaType = "application/json",
                schema = Schema(implementation = GenericErrorResponse::class),
                examples = [ExampleObject(value = "{\"error_code\": \"generic-error\", \"detail\": \"A generic error occurred\"}")]
            )]
        )
    ]
)
annotation class FakeServiceEndpoint
