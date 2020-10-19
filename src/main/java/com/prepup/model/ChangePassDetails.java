package com.prepup.model;

public class ChangePassDetails {
	
	private String emaiId;
	private String oldPass;
	private String newPass;
	
	public ChangePassDetails() {
		super();
	}

	public ChangePassDetails(String emaiId, String oldPass, String newPass) {
		super();
		this.emaiId = emaiId;
		this.oldPass = oldPass;
		this.newPass = newPass;
	}

	public String getEmaiId() {
		return emaiId;
	}

	public void setEmaiId(String emaiId) {
		this.emaiId = emaiId;
	}

	public String getOldPass() {
		return oldPass;
	}

	public void setOldPass(String oldPass) {
		this.oldPass = oldPass;
	}

	public String getNewPass() {
		return newPass;
	}

	public void setNewPass(String newPass) {
		this.newPass = newPass;
	}
	
	
	
	
	
	

}
