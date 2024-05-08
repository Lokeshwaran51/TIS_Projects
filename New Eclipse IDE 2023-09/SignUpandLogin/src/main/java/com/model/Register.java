package com.model;

public class Register {
	private static String firstName, lastName, contact, email, password;

	public Register(String firstName, String lastName, String contact, String email, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.contact = contact;
		this.email = email;
		this.password = password;
	}

	public Register() {
		super();
		
	}

	public Register(String email, String password) {
		
	}

	public static String getFirstName() {
		return firstName;
	}

	public static void setFirstName(String firstName) {
		Register.firstName = firstName;
	}

	public static String getLastName() {
		return lastName;
	}

	public static void setLastName(String lastName) {
		Register.lastName = lastName;
	}

	public static String getContact() {
		return contact;
	}

	public static void setContact(String contact) {
		Register.contact = contact;
	}

	public static String getEmail() {
		return email;
	}

	public static void setEmail(String email) {
		Register.email = email;
	}

	public static String getPassword() {
		return password;
	}

	public static void setPassword(String password) {
		Register.password = password;
	}

}
