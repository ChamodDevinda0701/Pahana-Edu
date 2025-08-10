package com.pahanaedu.service;

import com.pahanaedu.dto.ItemDto;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Service class to handle CRUD operations for items.
 */
public class ItemService {

    private static final String FILE_PATH = "items.txt";

    /**
     * Save an item to the file.
     */
    public void saveItem(ItemDto item) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(item.getItemCode() + "," + item.getItemName() + "," +
                    item.getPrice() + "," + item.getQtyOnHand());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Get all items from the file.
     */
    public List<ItemDto> getAllItems() {
        List<ItemDto> items = new ArrayList<>();
        File file = new File(FILE_PATH);

        if (!file.exists()) {
            return items;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 4) {
                    items.add(new ItemDto(data[0], data[1],
                            Double.parseDouble(data[2]),
                            Integer.parseInt(data[3])));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return items;
    }

    /**
     * Find an item by its code.
     */
    public ItemDto findItemByCode(String code) {
        for (ItemDto item : getAllItems()) {
            if (item.getItemCode().equalsIgnoreCase(code)) {
                return item;
            }
        }
        return null;
    }

    /**
     * Update an existing item by its code.
     */
    public boolean updateItem(ItemDto updatedItem) {
        List<ItemDto> items = getAllItems();
        boolean updated = false;

        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getItemCode().equalsIgnoreCase(updatedItem.getItemCode())) {
                items.set(i, updatedItem);
                updated = true;
                break;
            }
        }

        if (updated) {
            saveAllItems(items);
        }
        return updated;
    }

    /**
     * Delete an item by its code.
     */
    public boolean deleteItem(String code) {
        List<ItemDto> items = getAllItems();
        boolean removed = items.removeIf(item -> item.getItemCode().equalsIgnoreCase(code));

        if (removed) {
            saveAllItems(items);
        }
        return removed;
    }

    /**
     * Save all items to the file (overwrites existing file).
     */
    private void saveAllItems(List<ItemDto> items) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (ItemDto item : items) {
                writer.write(item.getItemCode() + "," + item.getItemName() + "," +
                        item.getPrice() + "," + item.getQtyOnHand());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
