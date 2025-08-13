package com.pahanaedu.model;

import java.io.Serializable;

/**
 * Represents a single item in a bill, including quantity and price.
 */
public class BillItem implements Serializable {

    private static final long serialVersionUID = 1L;

    private String itemCode;
    private String itemName;
    private int quantity;
    private double price;
    private double total;

    public BillItem() {
        // Default constructor
    }

    public BillItem(String itemCode, String itemName, int quantity, double price) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.quantity = quantity;
        this.price = price;
        this.total = quantity * price;
    }

    // Getters and Setters
    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        this.total = this.quantity * this.price; // Auto-update total
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
        this.total = this.quantity * this.price; // Auto-update total
    }

    public double getTotal() {
        return total;
    }

    @Override
    public String toString() {
        return "BillItem{" +
                "itemCode='" + itemCode + '\'' +
                ", itemName='" + itemName + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", total=" + total +
                '}';
    }
}
