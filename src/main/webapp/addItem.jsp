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
  <title>Add New Item - Pahana Edu</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #f5f5f5;
      margin: 0;
      padding: 0;
    }
    .container {
      width: 500px;
      margin: 50px auto;
      background: white;
      padding: 20px;
      border-radius: 8px;
      box-shadow: 0px 2px 10px rgba(0,0,0,0.1);
    }
    h2 {
      text-align: center;
      color: #333;
    }
    label {
      display: block;
      margin: 10px 0 5px;
      color: #555;
    }
    input[type="text"], input[type="number"] {
      width: 95%;
      padding: 8px;
      border: 1px solid #ccc;
      border-radius: 4px;
    }
    .btn {
      margin-top: 15px;
      padding: 10px;
      width: 100%;
      background-color: #4CAF50;
      color: white;
      border: none;
      border-radius: 4px;
      cursor: pointer;
    }
    .btn:hover {
      background-color: #45a049;
    }
    .back-link {
      display: block;
      margin-top: 15px;
      text-align: center;
    }
  </style>
</head>
<body>

<div class="container">
  <h2>Add New Item</h2>
  <form action="ItemController" method="post">
    <!-- Hidden action for the servlet -->
    <input type="hidden" name="action" value="add">

    <label>Item Code:</label>
    <input type="text" name="itemCode" required>

    <label>Item Name:</label>
    <input type="text" name="itemName" required>

    <label>Unit Price:</label>
    <input type="number" name="unitPrice" step="0.01" min="0" required>

    <label>Quantity Available:</label>
    <input type="number" name="quantity" min="0" required>

    <button type="submit" class="btn">Save Item</button>
  </form>

  <div class="back-link">
    <a href="index.jsp">← Back to Main Menu</a>
  </div>
</div>

</body>
</html>
