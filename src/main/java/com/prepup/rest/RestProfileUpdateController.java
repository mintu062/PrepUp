package com.prepup.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.prepup.model.UserUpdateDetails;
import com.prepup.rest.model.RegistrationStatus;
import com.prepup.service.UserDetailsService;

@RestController
public class RestProfileUpdateController {

	@Autowired
	UserDetailsService userDetailsService;
	
	@PostMapping("rest/profileupdate")
	public RegistrationStatus profileupdate(@RequestBody UserUpdateDetails userUpdateDetails) {
		RegistrationStatus registrationStatus = new RegistrationStatus();
		Boolean status=userDetailsService.updateUser(userUpdateDetails);
		if(status==true) {
			registrationStatus.setStatus_code(200);
			registrationStatus.setMessage("Profile Updated Successfully");
		}
		else {
			registrationStatus.setStatus_code(400);
			registrationStatus.setMessage("Profile Update Failed!");
		}
		
		
		
		return registrationStatus;
	} 

}
