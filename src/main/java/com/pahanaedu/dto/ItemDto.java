package com.pahanaedu.dto;

public class ItemDto {
    private String itemId;
    private String itemName;
    private String itemDescription;
    private double itemPrice;
    private int quantity; // NEW field for purchased quantity

    // Full constructor
    public ItemDto(String itemId, String itemName, String itemDescription, double itemPrice, int quantity) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.itemPrice = itemPrice;
        this.quantity = quantity;
    }

    // No-arg constructor
    public ItemDto() {
    }

    // Getters and setters
    public String getItemId() { return itemId; }
    public void setItemId(String itemId) { this.itemId = itemId; }

    public String getItemName() { return itemName; }
    public void setItemName(String itemName) { this.itemName = itemName; }

    public String getItemDescription() { return itemDescription; }
    public void setItemDescription(String itemDescription) { this.itemDescription = itemDescription; }

    public double getItemPrice() { return itemPrice; }
    public void setItemPrice(double itemPrice) { this.itemPrice = itemPrice; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
}
