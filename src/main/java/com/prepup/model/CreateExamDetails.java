package com.prepup.model;

import java.sql.Date;

public class CreateExamDetails {


	private String eName;
	private String classId;
	private Date date;
	public CreateExamDetails() {
		super();
	}
	public CreateExamDetails(String eName, String classId, Date date) {
		super();
		this.eName = eName;
		this.classId = classId;
		this.date = date;
	}
	public String geteName() {
		return eName;
	}
	public void seteName(String eName) {
		this.eName = eName;
	}
	public String getClassId() {
		return classId;
	}
	public void setClassId(String classId) {
		this.classId = classId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
