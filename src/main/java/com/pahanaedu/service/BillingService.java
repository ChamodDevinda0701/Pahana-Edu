package com.pahanaedu.service;

import com.pahanaedu.dto.BillDto;
import com.pahanaedu.dto.ItemDto;

import java.util.Date;
import java.util.List;

/**
 * Service class to manage billing operations.
 */

public class BillingService {


    /**
     * Calculates the total amount for the bill.
     *
     * @param bill the BillDto object with items
     * @return total amount
     */
    public double calculateTotalAmount(BillDto bill) {
        if (bill == null || bill.getItems() == null) {
            return 0;
        }
        double total = 0;
        for (ItemDto item : bill.getItems()) {
            total += item.getItemPrice();
        }
        bill.setTotalAmount(total);
        return total;
    }

    /**
     * Creates a new BillDto with total calculated.
     *
     * @param billId the bill identifier
     * @param customerId customer identifier
     * @param items list of items in the bill
     * @return BillDto with total amount and current date set
     */
    public BillDto createBill(String billId, String customerId, List<ItemDto> items) {
        BillDto bill = new BillDto(billId, customerId, items, 0, new Date());
        double total = calculateTotalAmount(bill);
        bill.setTotalAmount(total);
        return bill;
    }

    /**
     * Prints a simple summary of the bill.
     *
     * @param bill the BillDto object
     */
    public void printBillSummary(BillDto bill) {
        if (bill == null) {
            System.out.println("No bill available.");
            return;
        }
        System.out.println("Bill ID: " + bill.getBillId());
        System.out.println("Customer ID: " + bill.getCustomerId());
        System.out.println("Date: " + bill.getBillDate());
        System.out.println("Items:");
        for (ItemDto item : bill.getItems()) {
            System.out.printf(" - %s (%s): $%.2f%n", item.getItemName(), item.getItemId(), item.getItemPrice());
        }
        System.out.printf("Total Amount: $%.2f%n", bill.getTotalAmount());
    }

}
