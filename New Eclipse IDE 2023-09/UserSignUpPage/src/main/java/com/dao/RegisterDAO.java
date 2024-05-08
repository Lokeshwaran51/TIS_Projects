package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.model.RegisterUser;

public class RegisterDAO {

	public int registerUser(RegisterUser registerUser) throws ClassNotFoundException {
		String INSERT_USERS_SQL = "INSERT INTO users" + "  (firstName, lastName, contact, email, password) VALUES "
				+ " (?, ?, ?, ?, ?);";

		int result = 0;

		Class.forName("com.mysql.jdbc.Driver");

		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?allowPublicKeyRetrieval=true&useSSL=false",
				"root", "root");

				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {

			preparedStatement.setString(1, registerUser.getFirstName());
			preparedStatement.setString(2, registerUser.getLastName());

			preparedStatement.setString(3, registerUser.getContact());
			preparedStatement.setString(4, registerUser.getEmail());
			preparedStatement.setString(5, registerUser.getPassword());

			System.out.println(preparedStatement);

			result = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			
			printSQLException(e);
		}
		return result;
	}

	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}
}
