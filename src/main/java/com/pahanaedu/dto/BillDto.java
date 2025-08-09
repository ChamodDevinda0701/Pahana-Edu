package com.pahanaedu.dto;

import java.util.Date;
import java.util.List;

/**
 * Data Transfer Object (DTO) for Bill information.
 */

public class BillDto {

    private String billId;
    private String customerId;
    private List<ItemDto> items;  // Assuming you have an ItemDto class
    private double totalAmount;
    private Date billDate;

    /**
     * Constructor to initialize BillDto.
     *
     * @param billId      the bill identifier
     * @param customerId  the customer identifier
     * @param items       list of items in the bill
     * @param totalAmount total amount for the bill
     * @param billDate    date of the bill
     */
    public BillDto(String billId, String customerId, List<ItemDto> items, double totalAmount, Date billDate) {
        this.billId = billId;
        this.customerId = customerId;
        this.items = items;
        this.totalAmount = totalAmount;
        this.billDate = billDate;
    }

    // Getters and setters

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public List<ItemDto> getItems() {
        return items;
    }

    public void setItems(List<ItemDto> items) {
        this.items = items;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Date getBillDate() {
        return billDate;
    }

    public void setBillDate(Date billDate) {
        this.billDate = billDate;
    }

}
