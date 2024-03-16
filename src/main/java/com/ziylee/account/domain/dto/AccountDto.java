package com.ziylee.account.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;

@Builder
@Schema(name = "Account",
        description = "Schema to hold Account information")
public record AccountDto(

        @Schema(description = "Account Number of EasyBank account",
                example = "123456789")
        @Pattern(regexp="(^$|[0-9]{10})",message = "AccountNumber must be 10 digits")
        Long accountNumber,

        @Schema(description = "Account Type of Easy Bank account",
                example = "savings")
        @NotEmpty(message = "AccountType can not be a null or empty")
        String accountType,

        @Schema(description = "Easy Bank Branch Address",
                example = "123NewZealand")
        @NotEmpty(message = "BranchAddress can not be a null or empty")
        String branchAddress
) {}
