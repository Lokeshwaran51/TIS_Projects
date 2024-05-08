<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="jakarta.servlet.http.HttpServlet" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Login</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        form {
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            padding: 20px;
            width: 300px;
        }

        h2 {
            text-align: center;
            color: #333;
        }

        table {
            display: block;
            margin: 10px 0 5px;
            font-weight: bold;
            border-radius: 50%;
        }

        td {
            padding: 10px;
        }

        input {
            width: 100%;
            padding: 4px;
            margin-bottom: 10px;
            box-sizing: 50px;
            border-radius: 10px;
        }

        input[type="submit"] {
            background-color: green;
            color: #fff;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }

        p {
            text-align: center;
            margin-top: 10px;
        }

        a {
            color: #007bff;
        }
 
		a:hover {
    	text-decoration: underline;
		}
    </style>
</head>
<body>
    <div>
        <form action="login" method="post">
            <h2>User Login</h2>
            <table>
                <tr>
                    <td>Email:</td>
                    <td><input type="email" name="email" placeholder="someone1@gmail.com" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}" required></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><input type="password" name="password" placeholder="Enter your password" pattern="(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*_=+-]).{8,20}" required></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="Login" class="btn btn-danger"></td>
                </tr>
            </table>
        </form>
        <p>Don't have an account? <a href="UserRegister.jsp" style="text-decoration:none">Register Here</a></p>
    </div>
</body>
</html>
