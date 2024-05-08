<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Welcome</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            display: flex;
            align-items: center;
            justify-content: center;
            height: 100vh;
        }

        .welcome-container {
            text-align: center;
        }

        h1 {
            color: #333;
        }

        a {
            color: #007bff;
            text-decoration: none;
            font-weight: bold;
        }
    </style>
</head>
<body>
    <div class="welcome-container">
        <h1>Welcome to the UserRegistration</h1>
        <p>You have successfully logged in.</p>
        <p>
            <a href="<%= request.getContextPath() %>/Logout.jsp">Logout</a>
        </p>
    </div>
</body>
</html>
