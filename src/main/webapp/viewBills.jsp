<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 8/12/2025
  Time: 11:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.pahanaedu.model.Bill" %>
<%@ page import="com.pahanaedu.service.BillingService" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>View Bills - Pahana Edu</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #fafafa;
            margin: 0;
            padding: 20px;
        }
        .container {
            max-width: 900px;
            margin: auto;
            background: white;
            padding: 25px;
            border-radius: 8px;
            box-shadow: 0 3px 12px rgba(0,0,0,0.1);
        }
        h2 {
            color: #2c3e50;
            text-align: center;
            margin-bottom: 20px;
        }
        table {
            border-collapse: collapse;
            width: 100%;
            text-align: left;
        }
        th, td {
            padding: 12px;
            border-bottom: 1px solid #ddd;
        }
        th {
            background-color: #2980b9;
            color: white;
        }
        tr:hover {
            background-color: #f1f1f1;
        }
        .back-link {
            margin-top: 20px;
            text-align: center;
        }
        .back-link a {
            color: #2980b9;
            text-decoration: none;
        }
    </style>
</head>
<body>

<div class="container">
    <h2>All Bills</h2>

    <%
        // Assuming BillingService has static method getAllBills() returning List<Bill>
        List<Bill> bills = BillingService.getAllBills();

        if (bills == null || bills.isEmpty()) {
    %>
    <p>No bills found.</p>
    <%
    } else {
    %>

    <table>
        <thead>
        <tr>
            <th>Bill Number</th>
            <th>Customer Account</th>
            <th>Customer Name</th>
            <th>Item Code</th>
            <th>Item Name</th>
            <th>Quantity</th>
            <th>Total Amount</th>
        </tr>
        </thead>
        <tbody>
        <%
            for (Bill bill : bills) {
        %>
        <tr>
            <td><%= bill.getBillNumber() %></td>
            <td><%= bill.getCustomer().getAccountNumber() %></td>
            <td><%= bill.getCustomer().getFullname() %></td>
            <td><%= bill.getItem().getItemCode() %></td>
            <td><%= bill.getItem().getItemName() %></td>
            <td><%= bill.getQuantity() %></td>
            <td><%= String.format("%.2f", bill.getTotalAmount()) %></td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
    <%
        }
    %>

    <div class="back-link">
        <a href="index.jsp">← Back to Main Menu</a>
    </div>
</div>

</body>
</html>
