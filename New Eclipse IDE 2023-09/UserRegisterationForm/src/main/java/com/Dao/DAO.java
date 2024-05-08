	package com.Dao;
	
	import com.Model.UserModel;
	import com.zaxxer.hikari.HikariConfig;
	import com.zaxxer.hikari.HikariDataSource;
	
	import java.sql.*;
	import java.util.ArrayList;
	import java.util.List;
	
	public class DAO {
		private HikariDataSource dataSource;
		private Connection connection;
		
		public DAO() {
			DataSource();
			try {
				Connection();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	    
	    //Initialize datasource
		private void DataSource() {
		    try {
		        HikariConfig config = new HikariConfig();
		        config.setJdbcUrl(DB_URL);  // Use DB_Driver for JDBC URL
		        config.setDriverClassName(DB_DRIVER);  // Correct driver class name
		        config.setUsername(DB_UserName);
		        config.setPassword(DB_Password);
		        config.setMinimumIdle(10);
		        config.setMaximumPoolSize(15);
		        dataSource = new HikariDataSource(config);
		    } catch (Exception e) {
		        e.printStackTrace();
		        // Handle the exception as per your application's requirements
		    }
		}

	    //Initialize Connection
	    private void Connection() throws ClassNotFoundException  {
	    	try {
				connection=dataSource.getConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	    
	    public Connection getConnection() { 	
			return connection;
		}
		
		private static final String DB_DRIVER="com.mysql.cj.jdbc.Driver";
		private static final String DB_URL="jdbc:mysql://localhost:3306/demo";
		private static final String DB_UserName="root";
		private static final String DB_Password="SULokesh282001";
		
	    private static final String INSERT_USER_SQL = "{call InsertUser(?, ?, ?, ?, ?, ?)}";   //CALL Statement is used to execute stored Procedure
	    private static final String SELECT_USER_BY_ID = "{call SelectUserById(?)}";   //Private access modifier is used to we can access within the class
	    private static final String SELECT_ALL_USER = "{call SelectAllUsers()}";
	    private static final String DELETE_USER_SQL = "{call DeleteUserById(?)}";
	    private static final String UPDATE_USER_SQL = "{call UpdateUser(?, ?, ?, ?, ?, ?, ?)}";
	    
	    private static final String Email_Exists="{call UserExistswithEmailinUserForm(?)}";
		
		//Insert User
		public void insertUser(UserModel user) {
				try (CallableStatement cs = connection.prepareCall(INSERT_USER_SQL)) { // CallableStatement is interface
																						// used to call stored procedure and
																						// functions
					cs.setString(1, user.getName()); // PrepareCall Method is used to create object for callable Statement
					cs.setString(2, user.getEmail());
					cs.setString(3, user.getCountry());
					cs.setString(4, user.getContact());
					cs.setString(5, user.getGender());
					cs.setString(6, user.getAreaOfIntrest());
					cs.executeUpdate(); // ExecuteUpdate method which is used for insert,delete,update operations
				} 
				catch (SQLException e) {
				e.printStackTrace();
				}
//				finally {
//					if(connection!=null) {
//						try {
//							connection.close();
//						} catch (SQLException e) {
//							e.printStackTrace();
//						}
//					}
//				}
			}
	
		//Select User by Id
		public UserModel selectUser(int id) {
			UserModel user = null;
				try (CallableStatement cs = connection.prepareCall(SELECT_USER_BY_ID)) {
					cs.setInt(1, id); // Set() method is used to setValues in preparedStatement or callableStatement
										// before Executing it
					ResultSet rs = cs.executeQuery();
					while (rs.next()) {
						String name = rs.getString("name"); // get() method is used to retrive or read the values from
															// ResultSet
						String email = rs.getString("email");
						String country = rs.getString("country");
						String contact = rs.getString("contact");
						String gender = rs.getString("gender");
						String areaOfIntrest = rs.getString("areaOfIntrest");
						user = new UserModel(id, name, email, country, contact, gender, areaOfIntrest);
					}	
			} catch (SQLException e) {
				e.printStackTrace();
			}
//			finally {
//				if(connection!=null) {
//					try {
//						connection.close();
//					} catch (SQLException e) {
//						e.printStackTrace();
//					}
//				}
//			}
			return user;
		}
	    //Select All User
		public List<UserModel> selectAllUser() {
			List<UserModel> userList = new ArrayList<>();
				try (CallableStatement cs = connection.prepareCall(SELECT_ALL_USER)) {
					ResultSet rs = cs.executeQuery(); // ExecuteQuery which is used for select operations
					while (rs.next()) {
						int id = rs.getInt("id");
						String name = rs.getString("name");
						String email = rs.getString("email");
						String country = rs.getString("country");
						String contact = rs.getString("contact");
						String gender = rs.getString("gender");
						String areaOfIntrest = rs.getString("areaOfIntrest");
						userList.add(new UserModel(id, name, email, country, contact, gender, areaOfIntrest));
					}
			} catch (SQLException e) {
				e.printStackTrace();
			}
//				finally {
//					if(connection!=null) {
//						try {
//							connection.close();
//						} catch (SQLException e) {
//							e.printStackTrace();
//						}
//					}
//				}
			return userList;
		}
	    //Delete User by id
		public boolean deleteUser(int id) {
			boolean rowDeleted = false;
				try (CallableStatement cs = connection.prepareCall(DELETE_USER_SQL)) {
					cs.setInt(1, id);
					rowDeleted = cs.executeUpdate() > 0;
				}
			 catch (SQLException e) {
				e.printStackTrace();
			}
//				finally {
//				if(connection!=null) {
//					try {
//						connection.close();
//					} catch (SQLException e) {
//						e.printStackTrace();
//					}
//				}
//			}
			return rowDeleted;
		}
	
	    //Update User
		public boolean updateUser(UserModel user) {
			boolean rowUpdated = false;
				try (CallableStatement cs = connection.prepareCall(UPDATE_USER_SQL)) {
					cs.setInt(1, user.getId());	
					cs.setString(2, user.getName());
					cs.setString(3, user.getEmail());
					cs.setString(4, user.getCountry());
					cs.setString(5, user.getContact());
					cs.setString(6, user.getGender());
					cs.setString(7, user.getAreaOfIntrest());
					rowUpdated = cs.executeUpdate() > 0;
				}
			 catch (SQLException e) {
				e.printStackTrace();
			}
//				finally {
//				if(connection!=null) {
//					try {
//						connection.close();
//					} catch (SQLException e) {
//						e.printStackTrace();
//					}
//				}
//			}
			return rowUpdated;
		}
		//Email validation
		public boolean validateuseremail(String email) {
			boolean emailExists = false;
				try (CallableStatement cs = connection.prepareCall(Email_Exists)) {
					cs.setString(1, email);
					ResultSet rs = cs.executeQuery();
					emailExists = rs.next();
				} 
			 catch (SQLException e) {
				e.printStackTrace();
			}
//				finally {
//				if(connection!=null) {
//					try {
//						connection.close();
//					} catch (SQLException e) {
//						e.printStackTrace();
//					}
//				}
//			}
			return emailExists;
		}
	}
	 