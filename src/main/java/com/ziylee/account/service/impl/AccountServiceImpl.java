package com.ziylee.account.service.impl;

import com.ziylee.account.constant.AccountConstant;
import com.ziylee.account.domain.dto.AccountDto;
import com.ziylee.account.domain.dto.CustomerDto;
import com.ziylee.account.domain.entity.Account;
import com.ziylee.account.domain.entity.Customer;
import com.ziylee.account.exception.CustomerAlreadyExistException;
import com.ziylee.account.exception.ResourceNotFoundException;
import com.ziylee.account.mapper.AccountMapper;
import com.ziylee.account.mapper.CustomerMapper;
import com.ziylee.account.repository.AccountRepository;
import com.ziylee.account.repository.CustomerRepository;
import com.ziylee.account.service.IAccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
@Log4j2
@RequiredArgsConstructor
public class AccountServiceImpl implements IAccountService {
    private final AccountRepository accountRepository;
    private final CustomerRepository customerRepository;


    @Override
    public void createAccount(CustomerDto customerDto) {
        Customer customer = CustomerMapper.mapToCustomer(customerDto);
        Optional<Customer> optionalCustomer = customerRepository.findByMobileNumber(customerDto.mobileNumber());

        if (optionalCustomer.isPresent()) {
            throw new CustomerAlreadyExistException("Customer already registered with given mobile number: " + customerDto.mobileNumber());
        }

        Customer savedCustomer = customerRepository.save(customer);
        accountRepository.save(createNewAccount(customer));
    }

    /**
     * @param customer Customer Object
     * @return new account details
     */
    private Account createNewAccount(Customer customer) {
        long randomAccNumber = 10000000000L + new Random().nextInt(90000000);
        return Account.builder()
                .customerId(customer.getCustomerId())
                .accountNumber(randomAccNumber)
                .accountType(AccountConstant.SAVINGS)
                .branchAddress(AccountConstant.ADDRESS)
                .build();
    }


    @Override
    public CustomerDto fetchAccount(String mobileNumber) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber));

        Account account = accountRepository.findByCustomerId(customer.getCustomerId())
                .orElseThrow(() -> new ResourceNotFoundException("Account", "customerId", customer.getCustomerId().toString()));

        return CustomerDto.builder()
                .name(customer.getName())
                .email(customer.getEmail())
                .mobileNumber(customer.getMobileNumber())
                .accountDto(AccountMapper.mapToAccountDto(account))
                .build();
    }

    @Override
    public boolean updateAccount(CustomerDto customerDto) {
        if (customerDto.accountDto() != null) {
            AccountDto accountDto = customerDto.accountDto();

            // validate having the account to be updated
            Account existingAccount = accountRepository.findById(accountDto.accountNumber())
                    .orElseThrow(() -> new ResourceNotFoundException("Account", "accountNumber", accountDto.accountNumber().toString()));

            // validate having the customer
            Customer existingCustomer = customerRepository.findById(existingAccount.getCustomerId())
                    .orElseThrow(() -> new ResourceNotFoundException("Customer", "customerId", existingAccount.getCustomerId().toString()));

            accountRepository.save(AccountMapper.mapToAccount(accountDto, existingAccount));
            customerRepository.save(CustomerMapper.mapToCustomer(customerDto, existingCustomer));
        }

        return true;
    }

    @Override
    public boolean deleteAccount(String mobileNumber) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber));

        accountRepository.deleteByCustomerId(customer.getCustomerId());
        customerRepository.deleteById(customer.getCustomerId());
        return true;
    }
}
