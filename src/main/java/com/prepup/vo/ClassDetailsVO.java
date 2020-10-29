package com.prepup.vo;

public class ClassDetailsVO {

	private String className;
	private String classDesc;
	private String teacherId;
	private String classId;
	private String classPasskey;
	
	public ClassDetailsVO() {
		super();
	}

	public ClassDetailsVO(String className, String classDesc, String teacherId, String classId, String classPasskey) {
		super();
		this.className = className;
		this.classDesc = classDesc;
		this.teacherId = teacherId;
		this.classId = classId;
		this.classPasskey = classPasskey;
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

	public String getClassId() {
		return classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}

	public String getClassPasskey() {
		return classPasskey;
	}

	public void setClassPasskey(String classPasskey) {
		this.classPasskey = classPasskey;
	}

	
	
	
	
}
