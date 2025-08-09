package com.pahanaedu.mapper;

import com.pahanaedu.dto.ItemDto;

public class ItemMapper {

    /**
     * Converts CSV fields to an ItemDto.
     * Expects fields in order: itemId, itemName, itemDescription, itemPrice
     *
     * @param fields array of CSV fields
     * @return ItemDto or null if input invalid
     */
    public static ItemDto toItemDto(String[] fields) {
        if (fields == null || fields.length < 4) {
            return null; // or throw exception
        }
        String itemId = fields[0].trim();
        String itemName = fields[1].trim();
        String itemDescription = fields[2].trim();
        double itemPrice;
        try {
            itemPrice = Double.parseDouble(fields[3].trim());
        } catch (NumberFormatException e) {
            return null; // or handle error
        }
        return new ItemDto(itemId, itemName, itemDescription, itemPrice);
    }

    /**
     * Converts an ItemDto to a CSV line string.
     *
     * @param item ItemDto object
     * @return CSV formatted string
     */
    public static String toCsvLine(ItemDto item) {
        if (item == null) {
            return "";
        }
        return String.join(",",
                item.getItemId(),
                item.getItemName(),
                item.getItemDescription(),
                String.valueOf(item.getItemPrice()));
    }

}
