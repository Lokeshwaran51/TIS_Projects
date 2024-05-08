package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.userModel;

public class userDAO {
	public Connection getConnection() throws ClassNotFoundException {
		// Connction Declaration and Initialization
		Connection con = null;
		try {
			// Load Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Connection Creation
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "SULokesh282001");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	// Insert users data
	public String insert(userModel usermodel) throws SQLException, ClassNotFoundException {
		Connection con = getConnection();
		String sql = "INSERT INTO users VALUES (?, ?, ?, ?, ?, sha2(?,256));";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, usermodel.getFirstName());
			ps.setString(2, usermodel.getLastName());
			ps.setString(3, usermodel.getContact());
			ps.setString(4, usermodel.getAddress());
			ps.setString(5, usermodel.getEmail());
			ps.setString(6, usermodel.getPassword());
			ps.executeUpdate();
			return "Data Entered Successfully";
		} catch (SQLException e) {
			e.printStackTrace();
			return "Data Not Entered";
		}
	}

	public boolean userExistsByEmail(String email) throws SQLException, ClassNotFoundException { //this function is used to check whether email is registerd or not
		// Variable Declaration and Initialization
		boolean userExists = false;

		try {
			Connection con = getConnection();
			String sql = "SELECT * FROM users WHERE email = ? AND password=sha2(?,256)";
			//PreparedStatement used for execute Query
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, email);
			
			ResultSet rs = ps.executeQuery();
				userExists = rs.next(); // If there is a next row, user exists
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userExists;
	}
	
	 @SuppressWarnings("unused")
	private boolean validateUser(String email, String password) {
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "SULokesh282001");
	            String sql = "SELECT * FROM users WHERE email=? AND password=sha2(?,256)";
	            PreparedStatement ps = con.prepareStatement(sql);
	            ps.setString(1, email);
	            ps.setString(2, password);
	            ResultSet rs = ps.executeQuery();
	            return rs.next(); 

	        } catch (ClassNotFoundException | SQLException e) {
	            e.printStackTrace();
	            return false;
	        }
	    }
}
