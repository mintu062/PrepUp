package com.prepup.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.prepup.model.ChangePassDetails;
import com.prepup.model.CreateClassDetails;
import com.prepup.rest.model.ChangePassStatus;
import com.prepup.service.ClassDetailsService;

@RestController
public class RestCreateClassController {
	
	@Autowired
	ClassDetailsService classDetailsService;
	
	@PostMapping("rest/createclass")
	public Boolean createClass(@RequestBody CreateClassDetails createClassDetails) {
//		ChangePassStatus changePassStatus = new ChangePassStatus();
		Boolean status=classDetailsService.createClass(createClassDetails);
//		if(status==true) {
//			changePassStatus.setStatus_code(200);
//			changePassStatus.setMessage("Password Changed Successfully");
//		}
//		else {
//			changePassStatus.setStatus_code(400);
//			changePassStatus.setMessage("Old password is wrong");
//		}
		
		
		
		return status;
	} 

}
