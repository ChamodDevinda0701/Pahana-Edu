package com.pahanaedu.controller;

import com.pahanaedu.dto.ItemDto;
import com.pahanaedu.service.ItemService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

public class ItemController extends HttpServlet {

    private ItemService itemService;

    @Override
    public void init() throws ServletException {
        super.init();
        itemService = new ItemService(); // Initialize your item service here
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // For example: display list of items or show add/edit form based on parameters
        String action = request.getParameter("action");

        if ("edit".equalsIgnoreCase(action)) {
            // Load item for edit
            String itemId = request.getParameter("id");
            ItemDto item = itemService.getItemById(itemId);
            request.setAttribute("item", item);
            request.getRequestDispatcher("/jsp/itemForm.jsp").forward(request, response);
        } else if ("delete".equalsIgnoreCase(action)) {
            // Delete the item
            String itemId = request.getParameter("id");
            boolean deleted = itemService.deleteItem(itemId);
            if (deleted) {
                request.setAttribute("message", "Item deleted successfully.");
            } else {
                request.setAttribute("errorMessage", "Failed to delete item.");
            }
            request.getRequestDispatcher("/jsp/itemList.jsp").forward(request, response);
        } else {
            // Default: show all items
            request.setAttribute("items", itemService.getAllItems());
            request.getRequestDispatcher("/jsp/itemList.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Handle add or update item based on presence of id
        String itemId = request.getParameter("id");
        String itemName = request.getParameter("name");
        String itemDescription = request.getParameter("description");
        String priceStr = request.getParameter("price");

        double price = 0;
        try {
            price = Double.parseDouble(priceStr);
        } catch (NumberFormatException e) {
            request.setAttribute("errorMessage", "Invalid price format.");
            request.getRequestDispatcher("/jsp/itemForm.jsp").forward(request, response);
            return;
        }

        ItemDto item = new ItemDto();
        item.setId(itemId);
        item.setName(itemName);
        item.setDescription(itemDescription);
        item.setPrice(price);

        boolean success;
        if (itemId == null || itemId.isEmpty()) {
            // Add new item
            success = itemService.addItem(item);
        } else {
            // Update existing item
            success = itemService.updateItem(item);
        }

        if (success) {
            response.sendRedirect(request.getContextPath() + "/items");
        } else {
            request.setAttribute("errorMessage", "Failed to save item.");
            request.getRequestDispatcher("/jsp/itemForm.jsp").forward(request, response);
        }
    }
}
