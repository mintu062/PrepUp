package com.prepup.model;

import java.util.List;

public class Questions {

	private String eCode;
	private List<Question> questions;
	public Questions() {
		super();
	}
	public Questions(String eCode, List<Question> questions) {
		super();
		this.eCode = eCode;
		this.questions = questions;
	}
	public String geteCode() {
		return eCode;
	}
	public void seteCode(String eCode) {
		this.eCode = eCode;
	}
	public List<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	
	
}
