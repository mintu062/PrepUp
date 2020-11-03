package com.prepup.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.prepup.dao.QuestionDetailsDao;
import com.prepup.model.CreateExamDetails;
import com.prepup.model.ExamId;
import com.prepup.model.Question;
import com.prepup.model.Questions;
import com.prepup.rest.model.Status;
import com.prepup.service.ExamDetailsService;
import com.prepup.service.QuestionDetailsService;
import com.prepup.vo.QuestionDetailsVO;

@RestController
public class RestAddQuestionController {

	
	@Autowired
	QuestionDetailsDao questionDetailsDao;
	
	@Autowired
	QuestionDetailsService questionDetailsService;
	
	
	@PostMapping("rest/addquestions")
	public Status addQuestions(@RequestBody Questions ques) {
		List<Question> questions=ques.getQuestions();
		Status s = new Status();
		Boolean status = questionDetailsService.addQuestions(ques.geteCode(),questions);
		if(status==true)
		{
			s.setStatus_code(200);
			s.setMessage("Questions are Successfully Added");
		}
		else {
			s.setStatus_code(400);
			s.setMessage("Question Insertion Failed!");
		}
		return s;
		
	} 
  
}
