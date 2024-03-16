package com.ziylee.account.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Builder
@Schema(name = "ErrorResponse",
        description = "Schema to hold error response information")
public record ErrorResponseDto(

        @Schema(description = "API path invoked by client")
        String apiPath,

        @Schema(description = "Error code representing the error happened")
        HttpStatus errorCode,

        @Schema(description = "Error message representing the error happened")
        String errorMessage,

        @Schema(description = "Time representing the error happened")
        LocalDateTime errorTime
) {}