package com.ziylee.account.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Builder;

@Builder
@Schema(
        name = "Customer",
        description = "Schema to hold Customer and Account information"
)
public record CustomerDto(

        @Schema(description = "Name of the Customer",
                example = "ziylee")
        @NotEmpty(message = "Name can not be a null or empty")
        @Size(min = 5, max = 30, message = "The length of the customer name should be between 5 and 30")
        String name,

        @Schema(description = "Email of the Customer",
                example = "ziylee@deloitte.com")
        @NotEmpty(message = "Email address can not be a null or empty")
        @Email(message = "Email address should be a valid value")
        String email,

        @Schema(description = "Mobile Number of the Customer",
                example = "1234567891")
        @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits")
        String mobileNumber,

        @Schema(description = "Account Details of the Customer")
        AccountDto accountDto
) {}
