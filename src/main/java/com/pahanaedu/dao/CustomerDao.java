package com.pahanaedu.dao;

import com.pahanaedu.dto.CustomerDto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * DAO for Customer.
 * Assumes customers.txt CSV format:
 * username,password,fullname,email,accountNumber
 */

public class CustomerDao {

    private static final String CUSTOMER_FILE = "customers.txt";

    public CustomerDto getCustomerByUsername(String username) {
        try (BufferedReader br = new BufferedReader(new FileReader(CUSTOMER_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 5) {
                    if (parts[0].trim().equals(username)) {
                        return new CustomerDto(parts[0].trim(), parts[1].trim(),
                                parts[2].trim(), parts[3].trim(), parts[4].trim());
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public CustomerDto getCustomerByAccountNumber(String accountNumber) {
        try (BufferedReader br = new BufferedReader(new FileReader(CUSTOMER_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 5) {
                    if (parts[4].trim().equals(accountNumber)) {
                        return new CustomerDto(parts[0].trim(), parts[1].trim(),
                                parts[2].trim(), parts[3].trim(), parts[4].trim());
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    // You can add more methods as needed (add, update, delete)
}