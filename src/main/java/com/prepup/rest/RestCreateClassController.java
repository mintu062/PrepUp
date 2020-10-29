package com.prepup.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.prepup.model.ChangePassDetails;
import com.prepup.model.CreateClassDetails;
import com.prepup.rest.model.Status;
import com.prepup.rest.model.ChangePassStatus;
import com.prepup.rest.model.Status;
import com.prepup.service.ClassDetailsService;


@RestController
public class RestCreateClassController {
	
	@Autowired
	ClassDetailsService classDetailsService;
	
	@PostMapping("rest/createclass")
	public Status createClass(@RequestBody CreateClassDetails createClassDetails) {
		Status s = new Status();
		Boolean status=classDetailsService.createClass(createClassDetails);
		if(status==true) {
		s.setStatus_code(200);
		s.setMessage("Your class is created");
		}
		else {
			s.setStatus_code(400);
			s.setMessage("Class creation failed");
		}
		
		
		
		return s;
	} 

}
