<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 8/12/2025
  Time: 11:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create Bill - Pahana Edu</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f9f9f9;
            margin: 0;
            padding: 0;
        }
        .container {
            width: 480px;
            margin: 50px auto;
            background: white;
            padding: 25px;
            border-radius: 8px;
            box-shadow: 0 3px 12px rgba(0,0,0,0.1);
        }
        h2 {
            text-align: center;
            color: #2c3e50;
        }
        label {
            display: block;
            margin: 15px 0 5px;
            color: #555;
        }
        input[type="text"], input[type="number"] {
            width: 95%;
            padding: 8px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }
        .btn {
            margin-top: 20px;
            padding: 12px;
            width: 100%;
            background-color: #27ae60;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-weight: bold;
            font-size: 16px;
        }
        .btn:hover {
            background-color: #219150;
        }
        .back-link {
            margin-top: 15px;
            text-align: center;
        }
        .back-link a {
            text-decoration: none;
            color: #2980b9;
        }
    </style>
</head>
<body>

<div class="container">
    <h2>Create Bill</h2>

    <form action="BillController" method="post">
        <input type="hidden" name="action" value="create">

        <label>Bill Number:</label>
        <input type="text" name="billNumber" required>

        <label>Customer Account Number:</label>
        <input type="text" name="customerAccountNumber" required>

        <label>Item Code:</label>
        <input type="text" name="itemCode" required>

        <label>Quantity:</label>
        <input type="number" name="quantity" min="1" required>

        <button type="submit" class="btn">Generate Bill</button>
    </form>

    <div class="back-link">
        <a href="index.jsp">← Back to Main Menu</a>
    </div>
</div>

</body>
</html>
