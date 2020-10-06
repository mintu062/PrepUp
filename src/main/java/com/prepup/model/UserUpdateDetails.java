package com.prepup.model;

public class UserUpdateDetails {

	private String fname,mname,lname,phone,email,institute;

	

	public UserUpdateDetails() {
		super();
	}

	public UserUpdateDetails(String fname, String mname, String lname, String phone,String email, String institute) {
		super();
		this.fname = fname;
		this.mname = mname;
		this.lname = lname;
		this.phone = phone;
		this.email = email;
		this.institute = institute;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getInstitute() {
		return institute;
	}

	public void setInstitute(String institute) {
		this.institute = institute;
	}
	
	
}
