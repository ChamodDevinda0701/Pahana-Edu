package com.pahanaedu.service;

import com.pahanaedu.dto.ItemDto;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ItemService {

    private static final String ITEM_FILE = "items.txt";

    public ItemDto getItemById(String itemId) {
        for (ItemDto item : readAllItems()) {
            if (item.getItemId().equals(itemId)) {
                return item;
            }
        }
        return null;
    }

    public boolean addItem(ItemDto item) {
        if (item == null || getItemById(item.getItemId()) != null) {
            return false;
        }
        String line = String.join(",",
                item.getItemId(),
                item.getItemName(),
                item.getItemDescription(),
                String.valueOf(item.getItemPrice()),
                String.valueOf(item.getQuantity())); // include quantity

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ITEM_FILE, true))) {
            bw.write(line);
            bw.newLine();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateItem(ItemDto updatedItem) {
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

    public boolean deleteItem(String itemId) {
        List<ItemDto> items = readAllItems();
        boolean removed = items.removeIf(item -> item.getItemId().equals(itemId));
        if (!removed) return false;

        return writeAllItems(items);
    }

    private List<ItemDto> readAllItems() {
        List<ItemDto> items = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(ITEM_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    try {
                        String id = parts[0].trim();
                        String name = parts[1].trim();
                        String desc = parts[2].trim();
                        double price = Double.parseDouble(parts[3].trim());
                        int quantity = Integer.parseInt(parts[4].trim());

                        items.add(new ItemDto(id, name, desc, price, quantity));
                    } catch (NumberFormatException e) {
                        e.printStackTrace(); // skip invalid line
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return items;
    }

    private boolean writeAllItems(List<ItemDto> items) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ITEM_FILE, false))) {
            for (ItemDto item : items) {
                String line = String.join(",",
                        item.getItemId(),
                        item.getItemName(),
                        item.getItemDescription(),
                        String.valueOf(item.getItemPrice()),
                        String.valueOf(item.getQuantity())); // include quantity
                bw.write(line);
                bw.newLine();
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
