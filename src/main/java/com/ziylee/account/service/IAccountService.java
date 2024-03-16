package com.ziylee.account.service;

import com.ziylee.account.domain.dto.CustomerDto;

public interface IAccountService {

    /**
     * @param customerDto CustomerDto Object
     */
    void createAccount(CustomerDto customerDto);

    /**
     * @param mobileNumber Customer mobile Number
     * @return account details based on the mobile number
     */
    CustomerDto fetchAccount(String mobileNumber);

    /**
     * @param customerDto CustomerDto Object
     * @return Boolean indicate success or not
     */
    boolean updateAccount(CustomerDto customerDto);

    /**
     * @param mobileNumber Customer Mobile Number
     * @return Boolean indicate success or not
     */
    boolean deleteAccount(String mobileNumber);
}
