package com.pahanaedu.model;

import java.io.Serializable;

/**
 * Represents an item in the Pahana Edu inventory.
 * Stores details such as item code, name, description, price, and stock quantity.
 */
public class Item implements Serializable {

    private static final long serialVersionUID = 1L;

    private String itemCode;
    private String name;
    private String description;
    private double price;
    private int quantity;

    public Item() {
        // Default constructor
    }

    public Item(String itemCode, String name, String description, double price, int quantity) {
        this.itemCode = itemCode;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters and Setters
    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemCode='" + itemCode + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
