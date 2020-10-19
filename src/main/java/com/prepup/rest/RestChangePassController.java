package com.prepup.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.prepup.model.ChangePassDetails;
import com.prepup.model.UserDetails;
import com.prepup.rest.model.ChangePassStatus;
import com.prepup.rest.model.RegistrationStatus;
import com.prepup.service.UserDetailsService;

@RestController
public class RestChangePassController {

	@Autowired
	UserDetailsService userDetailsService;
	
	@PostMapping("rest/changepass")
	public ChangePassStatus registration(@RequestBody ChangePassDetails changePassDetails) {
		ChangePassStatus changePassStatus = new ChangePassStatus();
		Boolean status=userDetailsService.changePass(changePassDetails);
		if(status==true) {
			changePassStatus.setStatus_code(200);
			changePassStatus.setMessage("Password Changed Successfully");
		}
		else {
			changePassStatus.setStatus_code(400);
			changePassStatus.setMessage("Old password is wrong");
		}
		
		
		
		return changePassStatus;
	} 
}
