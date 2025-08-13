package com.pahanaedu.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Represents a billing record for a customer.
 */
public class Bill implements Serializable {

    private static final long serialVersionUID = 1L;

    private String billId;
    private String customerAccountNumber;
    private LocalDateTime billDate;
    private List<BillItem> billItems; // List of items purchased with quantity and price
    private double totalAmount;

    public Bill() {
        // Default constructor
    }

    public Bill(String billId, String customerAccountNumber, LocalDateTime billDate, List<BillItem> billItems, double totalAmount) {
        this.billId = billId;
        this.customerAccountNumber = customerAccountNumber;
        this.billDate = billDate;
        this.billItems = billItems;
        this.totalAmount = totalAmount;
    }

    // Getters and Setters
    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public String getCustomerAccountNumber() {
        return customerAccountNumber;
    }

    public void setCustomerAccountNumber(String customerAccountNumber) {
        this.customerAccountNumber = customerAccountNumber;
    }

    public LocalDateTime getBillDate() {
        return billDate;
    }

    public void setBillDate(LocalDateTime billDate) {
        this.billDate = billDate;
    }

    public List<BillItem> getBillItems() {
        return billItems;
    }

    public void setBillItems(List<BillItem> billItems) {
        this.billItems = billItems;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "billId='" + billId + '\'' +
                ", customerAccountNumber='" + customerAccountNumber + '\'' +
                ", billDate=" + billDate +
                ", billItems=" + billItems +
                ", totalAmount=" + totalAmount +
                '}';
    }
}
