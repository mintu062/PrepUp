package com.prepup.rest;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.prepup.model.User;
import com.prepup.rest.model.LoginStatus;
import com.prepup.service.UserDetailsService;
import com.prepup.vo.UserDetailsVO;

//@CrossOrigin(origins = "http://domain2.com", maxAge = 3600)
@RestController
public class RestLoginController {
	
	@Autowired
	UserDetailsService userDetailsService;
	

	
	@PostMapping("rest/login")
	public LoginStatus login(@RequestBody User user) {
		LoginStatus loginStatus = new LoginStatus();
		if(userDetailsService.isValidUser(user)) {
			
        	UserDetailsVO userDetailsVO = userDetailsService.findUser(user);
        	loginStatus.setStatus_code(200);
        	loginStatus.setMessage("login success");
        	loginStatus.setUserDetails(userDetailsVO);
        }else {
        	
        	loginStatus.setStatus_code(400);
        	loginStatus.setMessage("invalid credentials!");
        	
        }	
		
		return loginStatus;
	} 
}
