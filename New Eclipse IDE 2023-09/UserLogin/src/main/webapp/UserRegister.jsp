<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Registration</title>

<script>
        function validateForm() {
            // Validation logic here
            // You can customize this function based on your requirements
            var password = document.getElementById("password").value;

            var length = document.getElementById("length");
            var lowercase = document.getElementById("lowercase");
            var uppercase = document.getElementById("uppercase");
            var number = document.getElementById("number");

            // Check password length
            length.style.color = password.length >= 12 ? "green" : "red";

            // Check for lowercase letters
            lowercase.style.color = /[a-z]/.test(password) ? "green" : "red";

            // Check for uppercase letters
            uppercase.style.color = /[A-Z]/.test(password) ? "green" : "red";

            // Check for numbers
            number.style.color = /\d/.test(password) ? "green" : "red";

            // Ensure all criteria are met
            return password.length >= 12 && /[a-z]/.test(password) && /[A-Z]/.test(password) && /\d/.test(password);
        }
    </script>

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
    text-align: left;
}

h2 {
    color: #333;
    margin-bottom: 20px;
    text-align:center;
}

label {
    display: block;
    margin: 10px 0 5px;
    font-weight: bold;
}

input {
    width: calc(100% - 20px);
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
    width: 100%;
}

button:hover {
    background-color: #45a049;
}

p {
    margin-top: 20px;
    color: #333;
}

a {
    color: #3498db;
    text-decoration: none;
}

a:hover {
    text-decoration: underline;
}


</style>
</head>
<body>
    <div align="center">
    <form action="<%=request.getContextPath()%>/register" method="post">
        
         <h2>User Registration</h2>
        <label>First Name:</label>
        <input type="text" name="firstName"  required>

        <label>Last Name:</label>
        <input type="text" name="lastName"  required>

        <label>Contact:</label>
        <input type="text" name="contact" pattern="[0-9]{10}" required>

        <label>Address:</label>
        <input type="text" name="address"  required>

        <label>Email:</label>
        <input type="email" name="email"  pattern="[a-z0-9._%+-]+@[a-z0-9.-]+.[a-z]{2,3}$" required>

        <label>Password:</label>
        <input type="password" name="password" pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*_=+-]).{8,20}$" required>
        <div class="col-auto">
            <p>Password must contain:</p>
        <ul>
            <li><span id="length">At least 12 characters</span></li>
            <li><span id="lowercase">Lower case letters (a-z)</span></li>
            <li><span id="uppercase">Upper case letters (A-Z)</span></li>
            <li><span id="number">Numbers (0-9)</span></li>
        </ul>
        </div>
        <button type="submit" onclick="validateForm()">Register</button>
       
        <p>Already have an account? <a href="UserSignin.jsp" style="text-decoration:none">Login Here</a></p>
    </form>
</div>
</body>
</html>
