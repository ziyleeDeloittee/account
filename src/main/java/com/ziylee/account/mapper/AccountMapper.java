package com.ziylee.account.mapper;

import com.ziylee.account.domain.dto.AccountDto;
import com.ziylee.account.domain.entity.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {

    public static AccountDto mapToAccountDto(Account account) {
        return AccountDto.builder()
                .accountNumber(account.getAccountNumber())
                .accountType(account.getAccountType())
                .branchAddress(account.getBranchAddress())
                .build();
    }

    public static Account mapToAccount(AccountDto accountDto) {
        return Account.builder()
                .accountNumber(accountDto.accountNumber())
                .accountType(accountDto.accountType())
                .branchAddress(accountDto.branchAddress())
                .build();
    }

    public static Account mapToAccount(AccountDto accountDto, Account existingAccount) {
        existingAccount.setAccountNumber(accountDto.accountNumber());
        existingAccount.setAccountType(accountDto.accountType());
        existingAccount.setBranchAddress(accountDto.branchAddress());
        return existingAccount;
    }
}
