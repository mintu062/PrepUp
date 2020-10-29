package com.prepup.model;

public class CreateClassDetails {

	
	private String className;
	private String classDesc;
	private String teacherId;
	
	public CreateClassDetails() {
		super();
	}

	public CreateClassDetails(String className, String classDesc, String teacherId) {
		super();
		this.className = className;
		this.classDesc = classDesc;
		this.teacherId = teacherId;
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
	
	
	
	
}
