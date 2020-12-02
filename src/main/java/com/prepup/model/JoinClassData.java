package com.prepup.model;

public class JoinClassData {

	private String studentId;
	private String classPasskey;
	public JoinClassData() {
		super();
	}
	public JoinClassData(String studentId, String classPasskey) {
		super();
		this.studentId = studentId;
		this.classPasskey = classPasskey;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getClassPasskey() {
		return classPasskey;
	}
	public void setClassPasskey(String classPasskey) {
		this.classPasskey = classPasskey;
	}
	
	
}
