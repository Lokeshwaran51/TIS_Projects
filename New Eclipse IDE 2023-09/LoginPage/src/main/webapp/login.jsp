<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<div align="center">
		<form action="LoginServlet" method="post"></form>
		<table>
			<tr>
				<td>Enter Name:</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>Enter Password:</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td><input type="submit" value="login"></td>
				<td><input type="reset"></td>
			</tr>



		</table>




	</div>
</body>
</html>