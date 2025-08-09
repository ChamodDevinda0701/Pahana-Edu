package com.pahanaedu.dto;

/**
 * Data Transfer Object (DTO) for Customer information including accountNumber field.
 */
public class CustomerDto {
    private String username;
    private String password;
    private String fullname;
    private String email;
    private String accountNumber;  // new field

    // Constructor
    public CustomerDto(String username, String password, String fullname, String email, String accountNumber) {
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.email = email;
        this.accountNumber = accountNumber;
    }

    // Getters and setters

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
}
