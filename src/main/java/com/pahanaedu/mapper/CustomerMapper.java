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
            return null;
        }

        CustomerDto customer = new CustomerDto();
        customer.setUsername(fields[0].trim());
        customer.setPassword(fields[1].trim());
        customer.setFullname(fields[2].trim());
        customer.setEmail(fields[3].trim());

        return customer;
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
                safeValue(customer.getUsername()),
                safeValue(customer.getPassword()),
                safeValue(customer.getFullname()),
                safeValue(customer.getEmail()));
    }

    /**
     * Ensures null-safe string values.
     */
    private static String safeValue(String value) {
        return value == null ? "" : value.trim();
    }
}
