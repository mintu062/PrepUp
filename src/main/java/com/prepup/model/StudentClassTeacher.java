package com.prepup.model;

public class StudentClassTeacher {

	private String classid;
	private String studentId;
	private String className;
	private String classDesc;
	private String teacherId;
	private String fname;
	private String mname;
	private String lname;
	private String emailid;
	public StudentClassTeacher() {
		super();
	}
	public StudentClassTeacher(String classid, String studentId, String className, String classDesc, String teacherId,
			String fname, String mname, String lname, String emailid) {
		super();
		this.classid = classid;
		this.studentId = studentId;
		this.className = className;
		this.classDesc = classDesc;
		this.teacherId = teacherId;
		this.fname = fname;
		this.mname = mname;
		this.lname = lname;
		this.emailid = emailid;
	}
	public String getClassid() {
		return classid;
	}
	public void setClassid(String classid) {
		this.classid = classid;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getClassDesc() {
		return classDesc;
	}
	public void setClassDesc(String classDesc) {
		this.classDesc = classDesc;
	}
	public String getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
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
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	
	
	
}
