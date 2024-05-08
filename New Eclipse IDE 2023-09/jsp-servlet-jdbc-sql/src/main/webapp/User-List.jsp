<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.model.User"%>
<!-- Import the List class -->
<!DOCTYPE html>
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
				<a href="https://www.javaguides.net" class="navbar-brand"> User
					Registration </a>
			</div>
			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Users</a></li>
			</ul>
		</nav>
	</header>
	<br>

	<div class="container">
		<h3 class="text-center">List of Users</h3>
		<hr>
		<div class="container text-left">
			<a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add
				New Users</a>
		</div>
		<br>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>Email</th>
					<th>Country</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<%
				List<User> listUser = (List<User>) request.getAttribute("listUser");
				if (listUser != null) {
					for (User user : listUser) {
				%>
				<tr>
					<td><%=user.getId()%></td>
					<td><%=user.getName()%></td>
					<td><%=user.getEmail()%></td>
					<td><%=user.getCountry()%></td>

					<td><a
						href="<%=request.getContextPath()%>/edit?Employee_No=<%=user.getId()%>"
						class="btn btn-primary">Edit</a> <a
						href="<%=request.getContextPath()%>/delete?Employee_No=<%=user.getId()%>"
						class="btn btn-danger">Delete</a></td>
				</tr>
				<%
				}
				}
				%>
			</tbody>
		</table>
	</div>
</body>
</html>
