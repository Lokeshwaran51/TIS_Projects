package com.model;

public class RegisterUser {
	private static String firstName,lastName,contact,email,password;
	
	
	

	public RegisterUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RegisterUser(String firstName2, String lastName2, String contact2, String email2, String password2) {
		// TODO Auto-generated constructor stub
	}

	public static String getFirstName() {
		return firstName;
	}

	public static void setFirstName(String firstName) {
		RegisterUser.firstName = firstName;
	}

	public static String getLastName() {
		return lastName;
	}

	public static void setLastName(String lastName) {
		RegisterUser.lastName = lastName;
	}

	public static String getContact() {
		return contact;
	}

	public static void setContact(String contact) {
		RegisterUser.contact = contact;
	}

	public static String getEmail() {
		return email;
	}

	public static void setEmail(String email) {
		RegisterUser.email = email;
	}

	public static String getPassword() {
		return password;
	}

	public static void setPassword(String password) {
		RegisterUser.password = password;
	}
	

}
