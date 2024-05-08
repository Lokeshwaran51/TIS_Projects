package com.servlet;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Pattern;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		// Email validation using a simple regular expression
		if (!isValidEmail(email)) {
			response.sendRedirect("register.jsp");
			return;
		}

		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			byte[] hash = md.digest(password.getBytes("UTF-8"));
			StringBuilder hashedPassword = new StringBuilder();

			for (byte b : hash) {
				hashedPassword.append(String.format("%02x", b));
			}
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "SULokesh282001");
			String query = "SELECT firstName, lastName, contact, email, password FROM users WHERE email = ?";
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setString(1, email);

			ResultSet result = preparedStatement.executeQuery();

			if (result.next()) {
				String storedPassword = result.getString("password");
				if (hashedPassword.toString().equals(storedPassword)) {
					// Passwords match, user is authenticated
					// Retrieve user details
					String firstName = result.getString("firstName");
					String lastName = result.getString("lastName");
					String contact = result.getString("contact");

					// Set user details as request attributes
					request.setAttribute("email", email);
					request.setAttribute("firstName", firstName);
					request.setAttribute("lastName", lastName);
					request.setAttribute("contact", contact);

					// Forward to the user details JSP
					request.getRequestDispatcher("Details.jsp").forward(request, response);
				} else {
					// Passwords don't match, user authentication failed
					response.sendRedirect("Register.jsp");
				}
			} else {
				// User not found in the database
				response.sendRedirect("Register.jsp");
			}

			conn.close();
		} catch (NoSuchAlgorithmException | SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			response.sendRedirect("Register.jsp");
		}
	}

	private boolean isValidEmail(String email) {
		String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
		return Pattern.matches(regex, email);
	}
}
