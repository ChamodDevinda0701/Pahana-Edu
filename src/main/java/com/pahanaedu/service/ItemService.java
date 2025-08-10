package com.pahanaedu.service;

import com.pahanaedu.dao.ItemDao;
import com.pahanaedu.dto.ItemDto;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Service class to handle business logic related to Items.
 */
public class ItemService {

    private ItemDao itemDao;
    private static final String ITEM_FILE = "items.txt";

    public ItemService() {
        this.itemDao = new ItemDao();
    }

    /**
     * Get item details by itemId.
     *
     * @param itemId Item ID
     * @return ItemDto if found, else null
     */
    public ItemDto getItemById(String itemId) {
        return itemDao.getItemById(itemId);
    }

    /**
     * Add a new item by appending to the items file.
     * Basic implementation; does not check for duplicates.
     *
     * @param item ItemDto to add
     * @return true if added successfully, false otherwise
     */
    public boolean addItem(ItemDto item) {
        if (item == null) return false;

        // Optional: Check if item already exists
        if (getItemById(item.getItemId()) != null) {
            return false; // Item ID already exists
        }

        String line = String.join(",",
                item.getItemId(),
                item.getItemName(),
                item.getItemDescription(),
                String.valueOf(item.getItemPrice()));

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ITEM_FILE, true))) {
            bw.write(line);
            bw.newLine();
            bw.flush();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Update an existing item by rewriting the whole items file.
     *
     * @param updatedItem ItemDto with updated values
     * @return true if updated, false if item not found or error
     */
    public boolean updateItem(ItemDto updatedItem) {
        if (updatedItem == null) return false;

        List<ItemDto> items = readAllItems();
        boolean found = false;

        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getItemId().equals(updatedItem.getItemId())) {
                items.set(i, updatedItem);
                found = true;
                break;
            }
        }

        if (!found) return false;

        return writeAllItems(items);
    }

    /**
     * Delete an item by itemId.
     *
     * @param itemId Item ID to delete
     * @return true if deleted, false if not found or error
     */
    public boolean deleteItem(String itemId) {
        List<ItemDto> items = readAllItems();
        boolean removed = items.removeIf(item -> item.getItemId().equals(itemId));

        if (!removed) return false;

        return writeAllItems(items);
    }

    /**
     * Reads all items from the file.
     *
     * @return List of ItemDto objects
     */
    private List<ItemDto> readAllItems() {
        List<ItemDto> items = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(ITEM_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    try {
                        String itemId = parts[0].trim();
                        String itemName = parts[1].trim();
                        String itemDescription = parts[2].trim();
                        double itemPrice = Double.parseDouble(parts[3].trim());

                        ItemDto item = new ItemDto(itemId, itemName, itemDescription, itemPrice);
                        items.add(item);
                    } catch (NumberFormatException e) {
                        // Skip invalid price lines
                        e.printStackTrace();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return items;
    }

    /**
     * Writes the full list of items back to the file.
     *
     * @param items List of items to write
     * @return true if successful, false otherwise
     */
    private boolean writeAllItems(List<ItemDto> items) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ITEM_FILE, false))) {
            for (ItemDto item : items) {
                String line = String.join(",",
                        item.getItemId(),
                        item.getItemName(),
                        item.getItemDescription(),
                        String.valueOf(item.getItemPrice()));
                bw.write(line);
                bw.newLine();
            }
            bw.flush();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
