package com.prepup.model;

import java.io.Serializable;

public class StudentId implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String studentId;

	public StudentId() {
		super();
	}

	public StudentId(String studentId) {
		super();
		this.studentId = studentId;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	
}
