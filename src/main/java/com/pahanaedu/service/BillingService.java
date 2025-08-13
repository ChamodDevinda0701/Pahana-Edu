package com.pahanaedu.service;

import com.pahanaedu.dto.BillDto;
import com.pahanaedu.dto.CustomerDto;
import com.pahanaedu.dto.ItemDto;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class BillingService {

    public double calculateTotalAmount(BillDto bill) {
        if (bill == null || bill.getItems() == null) {
            return 0;
        }
        double total = 0;
        for (ItemDto item : bill.getItems()) {
            total += item.getItemPrice() * item.getQuantity();
        }
        bill.setTotalAmount(total);
        return total;
    }

    public BillDto createBill(String billId, String customerId, List<ItemDto> items) {
        BillDto bill = new BillDto(billId, customerId, items, 0, new Date());
        double total = calculateTotalAmount(bill);
        bill.setTotalAmount(total);
        return bill;
    }

    public BillDto calculateBill(CustomerDto customer) {
        if (customer == null || customer.getPurchasedItems() == null) {
            return null;
        }
        String billId = UUID.randomUUID().toString();
        BillDto bill = new BillDto(billId, customer.getAccountNumber(),
                customer.getPurchasedItems(), 0, new Date());
        double total = calculateTotalAmount(bill);
        bill.setTotalAmount(total);
        return bill;
    }

    public void printBillSummary(BillDto bill) {
        if (bill == null) {
            System.out.println("No bill available.");
            return;
        }
        System.out.println("Bill ID: " + bill.getBillId());
        System.out.println("Customer Account Number: " + bill.getCustomerId());
        System.out.println("Date: " + bill.getBillDate());
        System.out.println("Items:");
        for (ItemDto item : bill.getItems()) {
            System.out.printf(" - %s (%s): $%.2f x %d%n",
                    item.getItemName(), item.getItemId(),
                    item.getItemPrice(), item.getQuantity());
        }
        System.out.printf("Total Amount: $%.2f%n", bill.getTotalAmount());
    }
}
