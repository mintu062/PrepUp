package com.prepup.rest;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import com.prepup.dao.QuestionDetailsDao;
import com.prepup.model.EmailId;
import com.prepup.model.Question;
import com.prepup.model.Questions;
import com.prepup.rest.model.Status;
import com.prepup.service.QuestionDetailsService;
import com.prepup.service.UserDetailsService;

@RestController
public class RestResetPassController {
	
	@Autowired
	UserDetailsService userDetailsService;
	@Autowired
    private JavaMailSender javaMailSender;
	
	
	@PostMapping("rest/resetpassword")
	public Status resetpassword(@RequestBody EmailId email) {
	
		Status status = userDetailsService.isEmailValid(email);
		return status;
		
	} 
	
	@PostMapping("rest/sendemail")
	public void sendemail() {
	
		SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("sanket.de333@gmail.com");

        msg.setSubject("Testing from Spring Boot");
        msg.setText("Hello World \n Spring Boot Email");

        javaMailSender.send(msg);
		
	} 
}
