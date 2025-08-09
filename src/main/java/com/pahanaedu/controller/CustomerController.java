package com.pahanaedu.controller;

import com.pahanaedu.dto.CustomerDto;
import com.pahanaedu.service.CustomerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

public class CustomerController extends HttpServlet {

    private CustomerService customerService;

    @Override
    public void init() throws ServletException {
        super.init();
        customerService = new CustomerService(); // Initialize your service
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("edit".equalsIgnoreCase(action)) {
            // Show form to edit customer details
            String accountNumber = request.getParameter("accountNumber");
            CustomerDto customer = customerService.getCustomerByAccountNumber(accountNumber);
            if (customer != null) {
                request.setAttribute("customer", customer);
                request.getRequestDispatcher("/jsp/customerForm.jsp").forward(request, response);
            } else {
                request.setAttribute("errorMessage", "Customer not found.");
                listCustomers(request, response);
            }
        } else {
            // Default: list all customers
            listCustomers(request, response);
        }
    }

    private void listCustomers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("customers", customerService.getAllCustomers());
        request.getRequestDispatcher("/jsp/customerList.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Handle add or update customer based on presence of accountNumber parameter
        String accountNumber = request.getParameter("accountNumber");
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String telephone = request.getParameter("telephone");
        String unitsConsumedStr = request.getParameter("unitsConsumed");

        int unitsConsumed = 0;
        try {
            unitsConsumed = Integer.parseInt(unitsConsumedStr);
        } catch (NumberFormatException e) {
            request.setAttribute("errorMessage", "Units Consumed must be a valid number.");
            request.getRequestDispatcher("/jsp/customerForm.jsp").forward(request, response);
            return;
        }

        CustomerDto customer = new CustomerDto();
        customer.setAccountNumber(accountNumber);
        customer.setName(name);
        customer.setAddress(address);
        customer.setTelephone(telephone);
        customer.setUnitsConsumed(unitsConsumed);

        boolean success;
        if (accountNumber == null || accountNumber.trim().isEmpty()) {
            // Add new customer - generate unique account number (optional: generate here or in service)
            success = customerService.addCustomer(customer);
        } else {
            // Update existing customer
            success = customerService.updateCustomer(customer);
        }

        if (success) {
            response.sendRedirect(request.getContextPath() + "/customers");
        } else {
            request.setAttribute("errorMessage", "Failed to save customer.");
            request.getRequestDispatcher("/jsp/customerForm.jsp").forward(request, response);
        }
    }

}