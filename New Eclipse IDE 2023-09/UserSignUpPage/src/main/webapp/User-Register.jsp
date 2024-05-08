<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign-Up</title>
</head>
<body>
	<div align="center">
		<form action="<%=request.getContextPath() %>/register" method="post">
			<h2>Sign Up</h2>
			<table>
				<tr>
					<td>FirstName:</td>
					<td><input type="text" name="firstName" required></td>
				</tr>

				<tr>
					<td>LastName:</td>
					<td><input type="text" name="lastName" required></td>
				</tr>

				<tr>
					<td>Contact:</td>
					<td><input type="text" name="contact" required></td>
				</tr>

				<tr>
					<td>Email:</td>
					<td><input type="email" name="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" required></td>
				</tr>

				<tr>
					<td>Password:</td>
					<td><input type="password" name="password"  required></td>
				</tr>

				<tr>
				<tr>
					<td></td>
					<td><input type="submit" value="register"></td>
				</tr>



			</table>

		</form>



	</div>
</body>
</html>