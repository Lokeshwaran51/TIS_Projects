package com.dao;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.Register;

public class RegisterDao {
	private String dburl = "jdbc:mysql://localhost:3306/demo";
	private String dbuname = "root";
	private String password = "SULokesh282001";
	private String dbDriver = "com.mysql.cj.jdbc.Driver";

	public Connection getConnection() throws ClassNotFoundException {
		Connection con = null;
		try {
			Class.forName(dbDriver);
			con = DriverManager.getConnection(dburl, dbuname, password);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;

	}
	
	
	// Insert users data
	public String insert(Register register) throws SQLException, ClassNotFoundException {

		Connection con = getConnection();
		String result = "Data Entered Successfully";
		String sql = "insert into users values(?,?,?,?,sha2(?,256));";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, register.getFirstName());
			ps.setString(2, register.getLastName());
			ps.setString(3, register.getContact());
			ps.setString(4, register.getEmail());
			ps.setString(5, register.getPassword());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = "Data not entered";
		}
		return result;

	}

}
