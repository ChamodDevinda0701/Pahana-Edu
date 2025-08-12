<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%
    String username = (String) session.getAttribute("username");
    if (username == null) {
        response.sendRedirect("login.jsp"); // Redirect to login if not logged in
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Pahana Edu - Main Menu</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f4f6f9;
            font-family: Arial, sans-serif;
        }
        .container {
            max-width: 800px;
            margin-top: 50px;
            background: white;
            padding: 25px;
            border-radius: 12px;
            box-shadow: 0px 4px 10px rgba(0,0,0,0.1);
        }
        h2 {
            color: #2c3e50;
            font-weight: bold;
        }
        .menu-btn {
            width: 100%;
            margin-bottom: 10px;
            padding: 12px;
            font-size: 16px;
            font-weight: bold;
        }
        .logout-btn {
            background-color: #e74c3c;
            border: none;
        }
        .logout-btn:hover {
            background-color: #c0392b;
        }
    </style>
</head>
<body>

<div class="container text-center">
    <h2>Welcome, <%= username %> 👋</h2>
    <p>Select an option from the menu below</p>
    <hr>

    <form action="addCustomer.jsp" method="get">
        <button type="submit" class="btn btn-primary menu-btn">➕ Add New Customer</button>
    </form>

    <form action="editCustomer.jsp" method="get">
        <button type="submit" class="btn btn-warning menu-btn">✏️ Edit Customer Information</button>
    </form>

    <form action="manageItems.jsp" method="get">
        <button type="submit" class="btn btn-info menu-btn">📦 Manage Item Information</button>
    </form>

    <form action="viewCustomer.jsp" method="get">
        <button type="submit" class="btn btn-secondary menu-btn">📄 Display Account Details</button>
    </form>

    <form action="calculateBill.jsp" method="get">
        <button type="submit" class="btn btn-success menu-btn">💰 Calculate & Print Bill</button>
    </form>

    <form action="help.jsp" method="get">
        <button type="submit" class="btn btn-dark menu-btn">❓ Help Section</button>
    </form>

    <form action="logout.jsp" method="post">
        <button type="submit" class="btn btn-danger menu-btn logout-btn">🚪 Logout</button>
    </form>
</div>

</body>
</html>
