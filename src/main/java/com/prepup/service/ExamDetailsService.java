package com.prepup.service;

import java.sql.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prepup.dao.ExamDetailsDao;
import com.prepup.model.CreateClassDetails;
import com.prepup.model.CreateExamDetails;
import com.prepup.model.ExamId;
import com.prepup.vo.ClassDetailsVO;
import com.prepup.vo.ExamDetailsVO;

@Service
public class ExamDetailsService {

	@Autowired
	ExamDetailsDao examDetailsDao;
	
	
public ExamId createExam(CreateExamDetails createExam) {
		
		ExamDetailsVO examDetailsVO= new ExamDetailsVO();
		examDetailsVO.seteName(createExam.geteName());
		examDetailsVO.setClassId(createExam.getClassId());
		examDetailsVO.setDate(createExam.getDate());
		examDetailsVO.setDuration(createExam.getDuration());
		examDetailsVO.setInstruction(createExam.getInstruction());
		
		char ch='E';
		Integer uniqueIdint = (int) (System.currentTimeMillis() & 0xfffffff);
		 String uniqueIdstr=Integer.toString(uniqueIdint);
			String uniqueId=ch+Integer.toString(uniqueIdint).substring(uniqueIdstr.length()-4,uniqueIdstr.length());
			examDetailsVO.seteCode(uniqueId);
		ExamId eid= new ExamId();
		Boolean isSuccess=Boolean.FALSE;
		 if(examDetailsDao.createExam(examDetailsVO)>0) {
	        isSuccess=Boolean.TRUE;
	        eid.setExamId(uniqueId);
	        }        
	        else {
	        	System.out.println("Exam Creatation failed");
	        }
		 return eid;
	}
}
