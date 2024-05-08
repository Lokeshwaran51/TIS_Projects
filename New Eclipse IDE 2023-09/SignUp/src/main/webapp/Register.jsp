<!DOCTYPE html>
<html>
<head>
<title>Registration</title>
<link rel="stylesheet" type="text/css" href="style2.css">
<!-- Link to your external CSS file -->
</head>
<body>
	<div class="container">
		<div class="form-container registration-card">
			<h1 class="header">Registration</h1>
			<form action="RegisterServlet" method="post">
				<div class="form-group form-field">
					<div class="icon">
						<i class="fas fa-user"></i>
									<div class="form-group form-field">
					<div class="icon">
						<i class="fas fa-user"></i>
					</div>
					<input type="text" name="firstName" id="firstName"
						placeholder="First Name">
				</div>
				<div class="form-group form-field">
					<div class="icon">
						<i class="fas fa-user"></i>
					</div>
					<input type="text" name="lastName" id="lastName"
						placeholder="Last Name">
				</div>
				<div class="form-group form-field">
					<div class="icon">
						<i class="fas fa-map-marker"></i>
					</div>
					<input type="text" name="contact" id="contact"
						placeholder="contact">
				</div>
				</div>
					<input type="email" name="email" id="email" placeholder="Email"
						required>
				</div>
				<div class="form-group form-field">
					<div class="icon">
						<i class="fas fa-lock"></i>
					</div>
					<input type="password" name="password" id="password"
						placeholder="Password" required>
				</div>
				
				<div class="form-group form-field">
					<input type="submit" value="Register">
				</div>
			</form>

			<div>
				Already have an account? <a href="Login.jsp">Login</a>
			</div>
		</div>
	</div>
</body>
</html>
