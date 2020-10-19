package com.prepup.rest.model;

import com.prepup.vo.UserDetailsVO;

public class ChangePassStatus {

	private Integer status_code;
	private String  message;
	public ChangePassStatus() {
		super();
	}
	public ChangePassStatus(Integer status_code, String message) {
		super();
		this.status_code = status_code;
		this.message = message;
	}
	public Integer getStatus_code() {
		return status_code;
	}
	public void setStatus_code(Integer status_code) {
		this.status_code = status_code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
