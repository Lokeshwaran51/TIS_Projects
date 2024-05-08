<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>User Details</title>
    <link rel="stylesheet" type="text/css">
    <style>
        /* Center-align the content */
        .container {
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
            background-color: lightgrey;
        }

        /* Style the user details */
        .details-container {
            background: rgba(3, 3, 55, 0.5);;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 10px rgba(0, 0, 0, 0.9);
            color: white;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="details-container">
            <h1>User Details</h1>
            <p>Email: <%= request.getAttribute("email") %></p>
            <p>First Name: <%= request.getAttribute("firstName") %></p>
            <p>Last Name: <%= request.getAttribute("lastName") %></p>
            <p>Contact: <%= request.getAttribute("contact") %></p>
            
        </div>
    </div>
</body>
</html>
