package com.prepup.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.prepup.model.JoinClassData;
import com.prepup.model.StudentClassTeacher;
import com.prepup.model.StudentId;
import com.prepup.rest.model.Status;
import com.prepup.service.ClassDetailsService;
import com.prepup.service.UserDetailsService;


@RestController
public class RestJoinClassController {

	
	@Autowired
	UserDetailsService userDetailsService;
	@Autowired
	ClassDetailsService classDetailsService;
	

	
	@PostMapping("rest/joinclass")
	public Status joinClass(@RequestBody JoinClassData joinClassData) {
		Status status = new Status();
		status = classDetailsService.joinClass(joinClassData);
		
		
		return status;
	} 
	
	
	@PostMapping("rest/viewclasses")
	public List<StudentClassTeacher> viewClasses(@RequestBody StudentId studentId) {
		Status status = new Status();
//		status = classDetailsService.viewClassByStudentId(studentId);
		return classDetailsService.viewClassByStudentId(studentId);
		
		
//		return status;
	} 
	
	
}
