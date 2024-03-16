package com.ziylee.account.mapper;

import com.ziylee.account.domain.dto.CustomerDto;
import com.ziylee.account.domain.entity.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public static CustomerDto mapToCustomerDto(Customer customer) {
        return CustomerDto.builder()
                .name(customer.getName())
                .email(customer.getEmail())
                .mobileNumber(customer.getMobileNumber())
                .build();
    }

    public static Customer mapToCustomer(CustomerDto customerDto) {
        return Customer.builder()
                .name(customerDto.name())
                .email(customerDto.email())
                .mobileNumber(customerDto.mobileNumber())
                .build();
    }

    public static Customer mapToCustomer(CustomerDto customerDto, Customer existingCustomer) {
        existingCustomer.setName(customerDto.name());
        existingCustomer.setEmail(customerDto.email());
        existingCustomer.setMobileNumber(customerDto.mobileNumber());
        return existingCustomer;
    }
}
