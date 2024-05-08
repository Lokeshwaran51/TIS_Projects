package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.User;

public class UserDao {
	private static final String INSER_USERS_SQL = "INSERT INTO user" + "(name,email,country)VALUES" + "(?,?,?);";
	private static final String SELECT_USER_BY_ID = "select id,name,email,country where id=?";
	private static final String SELECT_ALL_USER = "select*from user";
	private static final String DELETE_USER_SQL = "delete from user where id=?";
	private static final String UPDATE_USER_SQL = "update user set name=?,email=?,country=?where id=?";

	public UserDao() {
	}

	protected Connection getConnection() {
		Connection conn = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo?useSSL=false", "root",
					"SULokesh282001");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();

		}
		return conn;
	}

	public void insertUser(User user) throws SQLException {
		System.out.println(INSER_USERS_SQL);
		try (Connection conn = getConnection();

				PreparedStatement ps = conn.prepareStatement(INSER_USERS_SQL)) {
			ps.setString(1, user.getName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getCountry());
			System.out.println(ps);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public User selectUser(int id) {
		User user = null;
		try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(SELECT_USER_BY_ID)) {
			ps.setInt(1, id);
			System.out.println(ps);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String name = rs.getString("name");
				String email = rs.getString("email");
				String country = rs.getString("country");
				user = new User(name, email, country);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;

	}

	public List<User> selectAllUsers() {
		List<User> user = new ArrayList<>();
		Connection conn = getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(SELECT_ALL_USER);
			System.out.println(ps);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String country = rs.getString("country");
				user.add(new User(id, name, email, country));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;

	}

	public boolean deleteUser(int id) throws SQLException {
		boolean rowDeleted = false;
		Connection conn = getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(DELETE_USER_SQL);
			ps.setInt(1, id);
			rowDeleted = ps.executeUpdate() > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rowDeleted;

	}

	public boolean updateUser(User user) throws SQLException {
		boolean rowUpdated = false;
		Connection conn = getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(UPDATE_USER_SQL);
			ps.setString(1, user.getName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getCountry());
			ps.setInt(4, user.getId());
			rowUpdated = ps.executeUpdate() > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rowUpdated;

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
