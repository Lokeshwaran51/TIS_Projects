package com.Model;

public class UserModel {
	protected int id;
	protected String name, email, country, contact,gender,areaOfIntrest;

	public UserModel(String name, String email, String country, String contact,String gender,String areaOfIntrest) {
		super();
		this.name = name;
		this.email = email;
		this.country = country;
		this.contact = contact;
		this.gender=gender;
		this.areaOfIntrest=areaOfIntrest;	
	}

	public UserModel(int id, String name, String email, String country, String contact,String gender,String areaOfIntrest) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.country = country;
		this.contact = contact;
		this.gender=gender;
		this.areaOfIntrest=areaOfIntrest;	
	}
	
	public UserModel() {
		super();
		
	}

	

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAreaOfIntrest() {
	    return areaOfIntrest;
	}
	
	public void setAreaOfIntrest(String areaOfIntrest) {
	    this.areaOfIntrest = areaOfIntrest;
	}

	
	

}
