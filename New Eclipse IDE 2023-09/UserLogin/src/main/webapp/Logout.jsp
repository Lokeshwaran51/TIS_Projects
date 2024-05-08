<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Logout Page</title>
</head>
<body>
<div align="center">
    <h2>You are Successfully Logged out. Please login again to continue!!</h2>
    <p>
        <button>
            <a href="<%= request.getContextPath() %>/UserSignin.jsp" style="text-decoration:none">Login</a>
        </button>
    </p>
</div>
</body>
</html>
