package com.pahanaedu.model;

import java.io.Serializable;

/**
 * Represents a customer in the Pahana Edu system.
 * Stores details such as account number, name, address, contact number, and units consumed.
 */
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;

    private String accountNumber;
    private String name;
    private String address;
    private String telephoneNumber;
    private int unitsConsumed;

    public Customer() {
        // Default constructor
    }

    public Customer(String accountNumber, String name, String address, String telephoneNumber, int unitsConsumed) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.address = address;
        this.telephoneNumber = telephoneNumber;
        this.unitsConsumed = unitsConsumed;
    }

    // Getters and Setters
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public int getUnitsConsumed() {
        return unitsConsumed;
    }

    public void setUnitsConsumed(int unitsConsumed) {
        this.unitsConsumed = unitsConsumed;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "accountNumber='" + accountNumber + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", telephoneNumber='" + telephoneNumber + '\'' +
                ", unitsConsumed=" + unitsConsumed +
                '}';
    }
}
