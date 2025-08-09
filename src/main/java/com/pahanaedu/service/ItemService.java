package com.pahanaedu.service;

import com.pahanaedu.dao.CustomerDao;
import com.pahanaedu.dto.CustomerDto;

/**
 * Service layer for Customer operations.
 */
public class CustomerService {

    private CustomerDao customerDao;

    public CustomerService() {
        customerDao = new CustomerDao();
    }

    public CustomerDto getCustomerByUsername(String username) {
        return customerDao.getCustomerByUsername(username);
    }

    public CustomerDto getCustomerByAccountNumber(String accountNumber) {
        return customerDao.getCustomerByAccountNumber(accountNumber);
    }

    public CustomerDto authenticate(String username, String password) {
        CustomerDto customer = getCustomerByUsername(username);
        if (customer != null && customer.getPassword() != null && customer.getPassword().equals(password)) {
            return customer;
        }
        return null;
    }
}
