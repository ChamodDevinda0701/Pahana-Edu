package com.pahanaedu.mapper;

import com.pahanaedu.dto.CustomerDto;

public class CustomerMapper {

    /**
     * Converts CSV line fields to a CustomerDto object.
     * Expects array in order: username, password, fullname, email
     *
     * @param fields String array of CSV fields
     * @return CustomerDto or null if input is invalid
     */
    public static CustomerDto toCustomerDto(String[] fields) {
        if (fields == null || fields.length < 4) {
            return null;  // or throw IllegalArgumentException
        }
        String username = fields[0].trim();
        String password = fields[1].trim();
        String fullname = fields[2].trim();
        String email = fields[3].trim();

        return new CustomerDto(username, password, fullname, email);
    }

    /**
     * Converts CustomerDto back to CSV line.
     *
     * @param customer CustomerDto object
     * @return CSV line string
     */
    public static String toCsvLine(CustomerDto customer) {
        if (customer == null) {
            return "";
        }
        return String.join(",",
                customer.getUsername(),
                customer.getPassword(),
                customer.getFullname(),
                customer.getEmail());
    }

}
