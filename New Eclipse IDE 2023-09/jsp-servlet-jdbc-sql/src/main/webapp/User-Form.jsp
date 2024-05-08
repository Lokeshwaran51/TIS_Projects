<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.model.User"%>

<!DOCTYPE html>
<html>
<head>
<title>User Registration Form</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div>
				<a href="User-List.jsp" class="navbar-brand"> User
					Registration Form </a>
			</div>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<%
				if (request.getAttribute("user") != null) {
				%>
				<form action="<%=request.getContextPath()%>/update" method="POST">
					<input type="hidden" name="_method" value="PUT">
					<%
					} else {
					%>
					<form action="<%=request.getContextPath()%>/insert" method="POST">
						<%
						}
						%>
						<caption>
							<h2>
								<%
								if (request.getAttribute("user") == null) {
									
								%>
								Add New User
								<%
								} else {
								%>
								Update User
								<%
								}
								%>
							</h2>
						</caption>
						<fieldset class="form-group">
							<input type="hidden" name="id"
								value="${user != null ? user.getId() : ''}" /> 
								<label>Name</label>
							<input type="text" value="${user != null ? user.getName() : ''}"
								class="form-control" name="name" />
						</fieldset>
						<fieldset class="form-group">
							<label>Email</label> 
							<input type="text"
								value="${user != null ? user.getEmail() : ''}"
								class="form-control" name="email" />
						</fieldset>
						<fieldset class="form-group">
							<label>Country</label> 
							<input type="text"
								value="${user != null ? user.getCountry() : ''}"
								class="form-control" name="country" />
						</fieldset>

						<button type="submit" class="btn btn-success">Save</button>
					</form>
			</div>
		</div>
	</div>
</body>
</html>