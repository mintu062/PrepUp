package com.prepup.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prepup.dao.ClassDetailsDao;
import com.prepup.dao.StudentClassDao;
import com.prepup.model.ClassId;
import com.prepup.model.CreateClassDetails;
import com.prepup.model.JoinClassData;
import com.prepup.model.StudentClassTeacher;
import com.prepup.model.StudentId;
import com.prepup.model.TeacherId;
import com.prepup.rest.model.Status;
import com.prepup.vo.ClassDetailsVO;



@Service
public class ClassDetailsService {
	
	@Autowired
	ClassDetailsDao classDetailsDao;
	
	@Autowired
	StudentClassDao studentClassDao;
	
	
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

public ClassDetailsVO findClassByCid(ClassId cid) {
	
	return classDetailsDao.findClassByCid(cid);
}

			public Status joinClass(JoinClassData joinClassData) {
				
				Status status= new Status();
				if(classDetailsDao.isValidPasskey(joinClassData.getClassPasskey())>0) {
					String classId = classDetailsDao.findClassIdByPasskey(joinClassData.getClassPasskey());
					int classjoinStatus= studentClassDao.checkJoinStatus(joinClassData.getStudentId(), classId);
					if(classjoinStatus==0) {
						studentClassDao.joinClass(joinClassData.getStudentId(), classId);
						status.setStatus_code(200);
						status.setMessage("Class Joined Successfully");
					}
					
					else {
						status.setStatus_code(407);
						status.setMessage("You are already joined in this class");
					}
				}
				else {
					status.setStatus_code(406);
					status.setMessage("Invalid Passkey!");
				}
				
				return status;
			}


				public List<StudentClassTeacher> viewClassByStudentId(StudentId studentId) {
					return studentClassDao.findClassesByStudentId(studentId);
//					return null;
				}

}
