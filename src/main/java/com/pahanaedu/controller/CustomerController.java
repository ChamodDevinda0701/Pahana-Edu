package com.pahanaedu.controller;

import com.pahanaedu.dto.CustomerDto;
import com.pahanaedu.service.CustomerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/customers") // Servlet mapping
public class CustomerController extends HttpServlet {

    private CustomerService customerService;

    @Override
    public void init() throws ServletException {
        super.init();
        customerService = new CustomerService(); // Initialize your service
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if ("edit".equalsIgnoreCase(action)) {
            String accountNumber = request.getParameter("accountNumber");
            CustomerDto customer = customerService.getCustomerByAccountNumber(accountNumber);
            if (customer != null) {
                request.setAttribute("customer", customer);
                request.getRequestDispatcher("/jsp/customerForm.jsp").forward(request, response);
            } else {
                request.setAttribute("errorMessage", "Customer not found.");
                listCustomers(request, response);
            }

        } else if ("delete".equalsIgnoreCase(action)) {
            String accountNumber = request.getParameter("accountNumber");
            boolean deleted = customerService.deleteCustomer(accountNumber);
            if (deleted) {
                request.setAttribute("message", "Customer deleted successfully.");
            } else {
                request.setAttribute("errorMessage", "Failed to delete customer.");
            }
            listCustomers(request, response);

        } else {
            // Default action: list all customers
            listCustomers(request, response);
        }
    }

    private void listCustomers(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<CustomerDto> customers = customerService.getAllCustomers();
        request.setAttribute("customers", customers);
        request.getRequestDispatcher("/jsp/customerList.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accountNumber = request.getParameter("accountNumber");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String fullname = request.getParameter("fullname");
        String email = request.getParameter("email");

        CustomerDto customer = new CustomerDto();
        customer.setAccountNumber(accountNumber);
        customer.setUsername(username);
        customer.setPassword(password);
        customer.setFullname(fullname);
        customer.setEmail(email);

        boolean success;
        if (accountNumber == null || accountNumber.trim().isEmpty()) {
            // Add new customer
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
