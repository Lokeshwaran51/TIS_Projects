<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.Model.UserModel"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.naming.*"%>
<%@ page import="com.servlet.UserServlet"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>User Management Form</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<%
String error=(String) request.getAttribute("error");
if(error!=null){%>
<script>
alert("<%=error%>");
</script>
<%}%>
<style>
body {
	background-color: #f8f9fa;
}

header {
	text-align: center;
	margin-bottom: 20px;
}

form {
	max-width: 600px;
	margin: 0 auto;
	background-color: #fff;
	padding: 20px;
	border-radius: 10px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 1.0);
}

table {
	width: 100%;
	margin-top: 10px;
}

td {
	padding: 10px;
}

button {
	padding: 10px 20px;
	border-radius: 5px;
	background-color: #28a745;
	color: #fff;
	border: none;
	cursor: pointer;
}
select {
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.5);
	margin: 0 auto;
	border-radius: 5px;
	border: none;
}

button a {
	color: #fff;
	text-decoration: none;
}
</style>
</head>
<body>

	<%
	UserModel user = (UserModel) request.getAttribute("user");  //is used to retrieve data stored in the request scope under the attribute name "user". 
	%>

	<%
	if (request.getAttribute("user") != null) {
	%>
	<form action="<%= request.getContextPath() %>/update" method="POST">
		<input type="hidden" name="_method" value="PUT">
		<%
    } else {
    %>
		<form action="<%= request.getContextPath() %>/insert" method="POST" name="myform">
			<%
        }
        %>
			<caption>
				<h2 align="center">
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
			<div align="center">
				<table>
					<tr>
						<td>
							<button style="background-color: Orange">
								<a href="<%= request.getContextPath() %>/list" style="text-decoration: none">User List</a>
							</button>
						</td>
					</tr>
					<tr>
						<td><input type="hidden" name="id"
							value="${user != null ? user.getId() : ''}" /></td>  <%--Here ternary operator used to bind the value while update the form --%>
					</tr>
					<tr>
						<td><b>Name :</b></td>
						<td><input type="text"
							value="${user != null ? user.getName() : '' }"
							class="form-control" name="name" required></td>
					</tr>
					<tr>
						<td><b>Email :</b></td>
						<td><input type="email"
							value="${user != null ? user.getEmail() : '' }"
							class="form-control" name="email" id="email"
							pattern="/^[a-zA-Z0-9._%+-]+@[a-zA-Z]+\.[a-zA-Z]{2,3}$/"
							required="required"> 
						</td>
					</tr>
					<tr>
						<td><b>Contact :</b></td>
						<td><input type="text"
							value="${user != null ? user.getContact() : '' }"
							class="form-control" name="contact" required></td>
					</tr>
			<tr>
                <td><label for="country"><b>Select a country:</b></label></td>
                <td>
                    <select name="country" id="country" required>
                        <option value="">Select Country</option>                
                        <%
                            try {
                                Class.forName("com.mysql.cj.jdbc.Driver");
                                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "SULokesh282001");
                                Statement stmt = conn.createStatement();
                                ResultSet rs = stmt.executeQuery("SELECT country_Name from country");
                                while (rs.next()) {
                                    String name = rs.getString("country_Name");
                                    %>
                                    <option value="<%= name %>" 
                                        <%= (user != null && name.equals(user.getCountry())) ? "selected" : "" %>><%= name %></option>
                                    <%
                                }
                            } catch(Exception e) { 
                                e.printStackTrace(); 
                            } 
                        %>
                    </select>
                </td>
             </tr>         
					<tr>
					    <td><b>Gender: </b></td>
					    <td>
					        <input type="radio" value="male" id="male" name="gender" 
					            <%= (user != null && "male".equals(user.getGender())) ? "checked" : "" %> required>
					        Male 
					        <input type="radio" value="female" id="female" name="gender"
					            <%= (user != null && "female".equals(user.getGender())) ? "checked" : "" %>>
					        Female
					    </td>
					</tr>
					<tr>
					    <td><b>Area of Intrest:</b></td>
					    <td>
					        <input type="checkbox" name="areaOfIntrest" value="Reading Books" <%= (user != null && user.getAreaOfIntrest() != null && user.getAreaOfIntrest().contains("Reading Books")) ? "checked" : "" %>> Reading Books<br />
					        <input type="checkbox" name="areaOfIntrest" value="Playing Cricket"  <%= (user != null && user.getAreaOfIntrest() != null && user.getAreaOfIntrest().contains("Playing Cricket")) ? "checked" : "" %>> Playing Cricket<br /> 
					        <input type="checkbox" name="areaOfIntrest" value="Listening Music"  <%= (user != null && user.getAreaOfIntrest() != null && user.getAreaOfIntrest().contains("Listening Music")) ? "checked" : "" %>> Listening Music<br />
					    </td>
					</tr>
				</table>
				<button type="submit" style="padding: 5px 100px"class="btn btn-success">Save</button>
			</div>
		</form>
</body>
</html>