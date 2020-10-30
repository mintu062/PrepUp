package com.prepup.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prepup.dao.ClassDetailsDao;
import com.prepup.model.CreateClassDetails;
import com.prepup.model.TeacherId;
import com.prepup.vo.ClassDetailsVO;



@Service
public class ClassDetailsService {
	
	@Autowired
	ClassDetailsDao classDetailsDao;
	
	
public Boolean createClass(CreateClassDetails classDetails) {
		
		ClassDetailsVO classDetailsVO= new ClassDetailsVO();
		classDetailsVO.setClassName(classDetails.getClassName());
		classDetailsVO.setClassDesc(classDetails.getClassDesc());
		classDetailsVO.setTeacherId(classDetails.getTeacherId());
		
		char ch='C';
		Integer uniqueIdint = (int) (System.currentTimeMillis() & 0xfffffff);
		 String uniqueIdstr=Integer.toString(uniqueIdint);
			String uniqueId=ch+Integer.toString(uniqueIdint).substring(uniqueIdstr.length()-4,uniqueIdstr.length());
		classDetailsVO.setClassId(uniqueId);

				String uuid = UUID.randomUUID().toString();
				classDetailsVO.setClassPasskey(uuid.substring(28,36));
		
		Boolean isSuccess=Boolean.FALSE;
		 if(classDetailsDao.createClass(classDetailsVO)>0) {
	        isSuccess=Boolean.TRUE;
	        }        
	        else {
	        	System.out.println("Registration failed");
	        }
		 return isSuccess;
	}


public List<ClassDetailsVO> findClassByTid(TeacherId tid) {
	
	return classDetailsDao.findClassByTid(tid);
}

}
