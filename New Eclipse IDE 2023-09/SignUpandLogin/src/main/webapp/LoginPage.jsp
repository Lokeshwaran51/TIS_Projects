<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>UserLogin</title>
</head>
<body>
	<div align="center">

		<legend>
			<h2>User Login</h2>
		</legend>
		<form action="login" method="post" onsubmit="return.validate();">

			<table>
				<tr>
					<td>Email:</td>
					<td><input type="email" name="email"
						placeholder="someone1@gmail.com"
						pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}";
						required><br />
					</td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type="password" name="email"
						placeholder="enter your password"
						pattern="(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*_=+-]).{8,20}"
						required><br /></td>
				</tr>
				<tr>
					<td><input type="submit" value="login" colspan="2">
					</td>
				</tr>
			</table>
		</form>
		<p>
			Don't have an account? <a href="UserSignUp.jsp">Register Here</a>
		</p>
	</div>
</body>
</html>