package com.prepup.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.prepup.model.User;
import com.prepup.model.UserDetails;
import com.prepup.rest.model.LoginStatus;
import com.prepup.rest.model.RegistrationStatus;
import com.prepup.service.UserDetailsService;
import com.prepup.vo.UserDetailsVO;

@RestController
public class RestRegistrationController {
	@Autowired
	UserDetailsService userDetailsService;
	
	@PostMapping("rest/registration")
	public RegistrationStatus login(@RequestBody UserDetails userDetails) {
		RegistrationStatus registrationStatus = new RegistrationStatus();
		Boolean status=userDetailsService.createUser(userDetails);
		if(status==true) {
			registrationStatus.setStatus_code(200);
			registrationStatus.setMessage("Registation Successful");
		}
		else {
			registrationStatus.setStatus_code(400);
			registrationStatus.setMessage("Registration Failed");
		}
		
		
		
		return registrationStatus;
	} 

}
