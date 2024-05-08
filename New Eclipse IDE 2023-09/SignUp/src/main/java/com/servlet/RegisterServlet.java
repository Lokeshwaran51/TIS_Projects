package com.servlet;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String contact = request.getParameter("contact");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		// Password validation
		if (!isValidPassword(password)) {
			// Password is not valid, redirect to the registration page with an error
			// message
			response.sendRedirect("Register.jsp?error=password");
			return;
		}

		try {
			// Hash the password
			String hashedPassword = hashPassword(password);

			// Save user details to the database
			boolean success = registerUser(email, hashedPassword, firstName, lastName, contact);
			if (success) {
				// Redirect to the login page or send a success response
				response.sendRedirect("Login.jsp");
			} else {
				// Registration failed, redirect to the registration page or send an error
				// response
				response.sendRedirect("Register.jsp");
			}
		} catch (NoSuchAlgorithmException | SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			response.sendRedirect("Register.jsp");
		}
	}

	private boolean isValidPassword(String password) {
		return password.length() >= 8 && password.matches(".*\\d.*") && password.matches(".*[a-zA-Z].*");
	}

	private String hashPassword(String password) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		byte[] hash = md.digest(password.getBytes());
		StringBuilder hashedPassword = new StringBuilder();

		for (byte b : hash) {
			hashedPassword.append(String.format("%02x", b));
		}

		return hashedPassword.toString();
	}

	private boolean registerUser(String firstName, String lastName, String contact, String email, String hashedPassword)
			throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "SULokesh282001");
		String query = "INSERT INTO decrypt (firstName, lastName, contact, email, password,) "
				+ "VALUES (?, ?, ?, ?, ?)";
		PreparedStatement preparedStatement = conn.prepareStatement(query);
		preparedStatement.setString(1, email);
		preparedStatement.setString(2, hashedPassword);
		preparedStatement.setString(3, firstName);
		preparedStatement.setString(4, lastName);
		preparedStatement.setString(5, contact);

		int rowsAffected = preparedStatement.executeUpdate();
		conn.close();
		return rowsAffected > 0;
	}
}
