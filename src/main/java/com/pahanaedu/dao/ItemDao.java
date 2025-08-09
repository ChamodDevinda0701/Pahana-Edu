package com.pahanaedu.dao;

import com.pahanaedu.dto.ItemDto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ItemDao {

    private static final String ITEM_FILE = "items.txt";

    /**
     * Retrieves an ItemDto by itemId.
     * @param itemId The ID of the item to find.
     * @return ItemDto if found, else null.
     */
    public ItemDto getItemById(String itemId) {
        try (BufferedReader br = new BufferedReader(new FileReader(ITEM_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                // CSV format: itemId,itemName,itemDescription,itemPrice
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    String fileItemId = parts[0].trim();
                    if (fileItemId.equals(itemId)) {
                        String itemName = parts[1].trim();
                        String itemDescription = parts[2].trim();
                        double itemPrice = Double.parseDouble(parts[3].trim());
                        return new ItemDto(fileItemId, itemName, itemDescription, itemPrice);
                    }
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        return null; // Item not found
    }
}

