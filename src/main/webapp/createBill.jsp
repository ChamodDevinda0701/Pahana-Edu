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
            width: 650px;
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
            width: 100%;
            padding: 8px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 15px;
        }
        table th, table td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: center;
        }
        table th {
            background-color: #f2f2f2;
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
        .add-row-btn {
            background-color: #3498db;
            color: white;
            border: none;
            padding: 8px 12px;
            cursor: pointer;
            border-radius: 4px;
        }
        .add-row-btn:hover {
            background-color: #2980b9;
        }
    </style>
    <script>
        function addRow() {
            let table = document.getElementById("itemsTable");
            let row = table.insertRow(-1);
            row.innerHTML = `
                <td><input type="text" name="itemCode" required></td>
                <td><input type="text" name="itemName" required></td>
                <td><input type="number" name="quantity" min="1" required></td>
                <td><input type="number" name="price" min="0" step="0.01" required></td>
            `;
        }
    </script>
</head>
<body>

<div class="container">
    <h2>Create Bill</h2>

    <form action="BillController" method="post">
        <input type="hidden" name="action" value="create">

        <label>Bill ID:</label>
        <input type="text" name="billId" required>

        <label>Customer Account Number:</label>
        <input type="text" name="customerAccountNumber" required>

        <h3>Bill Items</h3>
        <table id="itemsTable">
            <tr>
                <th>Item Code</th>
                <th>Item Name</th>
                <th>Quantity</th>
                <th>Price</th>
            </tr>
            <tr>
                <td><input type="text" name="itemCode" required></td>
                <td><input type="text" name="itemName" required></td>
                <td><input type="number" name="quantity" min="1" required></td>
                <td><input type="number" name="price" min="0" step="0.01" required></td>
            </tr>
        </table>
        <button type="button" class="add-row-btn" onclick="addRow()">+ Add Item</button>

        <button type="submit" class="btn">Generate Bill</button>
    </form>

    <div class="back-link">
        <a href="index.jsp">← Back to Main Menu</a>
    </div>
</div>

</body>
</html>
