<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SignUp</title>
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

form {
	background-color: #fff;
	padding: 20px;
	border-radius: 8px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	width: 300px;
	text-align: center;
}

label {
	display: block;
	margin: 10px 0 5px;
	font-weight: bold;
}

input {
	width: 100%;
	padding: 8px;
	margin-bottom: 10px;
	box-sizing: border-box;
}

button {
	background-color: #4caf50;
	color: #fff;
	border: none;
	padding: 10px;
	border-radius: 5px;
	cursor: pointer;
	font-size: 16px;
}

button:hover {
	background-color: #45a049;
}
</style>


</head>
<body>
	<div align="center">
		<form action="<%=request.getContextPath()%>/register" method="post">
			<h2 style="color: red">SignUp</h2>
			<table>
				<tr>
					<td>FirstName:</td>
					<td><input type="text" name="firstName"
						value="${register != null ? register.getFirstName() : '' }"
						required></td>
				</tr>
				<tr>
					<td>LastName:</td>
					<td><input type="text" name="lastName"
						value="${register != null ? register.getLastName() : '' }"
						required></td>
				</tr>
				<tr>
					<td>Contact:</td>
					<td><input type="text" name="contact"
						value="${register != null ? register.getContact() : '' }" required></td>
				</tr>
				<tr>
					<td>Email:</td>
					<td><input type="text" name="email"
						value="${register != null ? register.getEmail() : '' }"
						pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" required></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type="password" name="password" id="pwd"
						value="${register != null ? register.getPassword() : '' }"
						pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*_=+-]).{8,20}$"
						title="Must contain at least one number and one uppercase and lowercase letter and special characters, and at least 8 or more characters"
						required></td>
				</tr>
				<tr>
					<td><input type="submit" value="register" 
						style="background-color: blue; color: white"></td>
				</tr>
				
			</table>
			<p>Thank you for register..<a href="LoginPage.jsp">Login Here......</a></p>
	</div>
	
	</form>
	
</body>
</html>