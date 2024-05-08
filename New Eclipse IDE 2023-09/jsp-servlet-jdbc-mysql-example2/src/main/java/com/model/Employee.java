package com.model;

public class Employee {
    protected int Employee_No;
    protected String First_Name;
    protected String Last_Name;
    protected String Designation;
    protected String DOB;
    protected String Email;
    protected String Mobile_No;

    // Constructors
    public Employee() {
        // Default constructor
    }

    public Employee(String first_Name, String last_Name, String designation, String dOB, String email, String mobile_No) {
        // Constructor with parameters
        this.First_Name = first_Name;
        this.Last_Name = last_Name;
        this.Designation = designation;
        this.DOB = dOB;
        this.Email = email;
        this.Mobile_No = mobile_No;
    }

    public Employee(int employee_No, String first_Name, String last_Name, String designation, String dOB, String email, String mobile_No) {
        // Constructor with parameters including Employee_No
        this.Employee_No = employee_No;
        this.First_Name = first_Name;
        this.Last_Name = last_Name;
        this.Designation = designation;
        this.DOB = dOB;
        this.Email = email;
        this.Mobile_No = mobile_No;
    }
	public int getEmployee_No() {
		return Employee_No;
	}
	public void setEmployee_No(int employee_No) {
		Employee_No = employee_No;
	}
	public String getFirst_Name() {
		return First_Name;
	}
	public void setFirst_Name(String first_Name) {
		First_Name = first_Name;
	}
	public String getLast_Name() {
		return Last_Name;
	}
	public void setLast_Name(String last_Name) {
		Last_Name = last_Name;
	}
	public String getDesignation() {
		return Designation;
	}
	public void setDesignation(String designation) {
		Designation = designation;
	}
	public String getDOB() {
		return DOB;
	}
	public void setDOB(String dOB) {
		DOB = dOB;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getMobile_No() {
		return Mobile_No;
	}
	public void setMobile_No(String mobile_No) {
		Mobile_No = mobile_No;
	} 

}
