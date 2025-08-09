package com.pahanaedu.controller;

import com.pahanaedu.dto.BillDto;
import com.pahanaedu.dto.CustomerDto;
import com.pahanaedu.service.BillingService;
import com.pahanaedu.service.CustomerService;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;


public class BillController extends HttpServlet {

    private BillingService billingService;
    private CustomerService customerService;

    @Override
    public void init() throws ServletException {
        super.init();
        billingService = new BillingService();
        customerService = new CustomerService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/jsp/billForm.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accountNumber = request.getParameter("accountNumber");

        if (accountNumber == null || accountNumber.trim().isEmpty()) {
            request.setAttribute("errorMessage", "Account Number is required.");
            request.getRequestDispatcher("/jsp/billForm.jsp").forward(request, response);
            return;
        }

        CustomerDto customer = customerService.getCustomerByAccountNumber(accountNumber);

        if (customer == null) {
            request.setAttribute("errorMessage", "Customer with account number " + accountNumber + " not found.");
            request.getRequestDispatcher("/jsp/billForm.jsp").forward(request, response);
            return;
        }

        BillDto bill = billingService.calculateBill(customer);

        request.setAttribute("customer", customer);
        request.setAttribute("bill", bill);

        request.getRequestDispatcher("/jsp/billPrint.jsp").forward(request, response);
    }
}