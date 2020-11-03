package com.prepup.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prepup.dao.ExamDetailsDao;
import com.prepup.dao.QuestionDetailsDao;
import com.prepup.model.CreateExamDetails;
import com.prepup.model.ExamId;
import com.prepup.model.Question;
import com.prepup.vo.ExamDetailsVO;
import com.prepup.vo.QuestionDetailsVO;

@Service
public class QuestionDetailsService {

	@Autowired
	QuestionDetailsDao questionDetailsDao;
	
	
	
	
	
	public Boolean addQuestions(String eCode,List<Question> questions) {
			
			Boolean isSuccess=Boolean.FALSE;
			for (int i = 0; i < questions.size(); i++) {
	            isSuccess =addQuestion(eCode, questions.get(i));
	        }
			
			
			
			 return isSuccess;
		}
	
	public Boolean addQuestion(String eCode,Question question) {
			
		QuestionDetailsVO qdv= new QuestionDetailsVO();
		qdv.seteCode(eCode);
		qdv.setQuestion(question.getQuestion());
		qdv.setOptionA(question.getOptionA());
		qdv.setOptionB(question.getOptionB());
		qdv.setOptionC(question.getOptionC());
		qdv.setOptionD(question.getOptionD());
		qdv.setAnswer(question.getAnswer());
		
		
		
		
			
			Boolean isSuccess=Boolean.FALSE;
			 if(questionDetailsDao.addQuestion(qdv)>0) {
		        isSuccess=Boolean.TRUE;
		        }        
		        else {
		        	System.out.println("Question Add Failed");
		        }
			 return isSuccess;
		}
}
