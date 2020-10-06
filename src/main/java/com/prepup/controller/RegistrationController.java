package com.prepup.controller;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.prepup.model.UserDetails;
import com.prepup.service.UserDetailsService;
//import com.prepup.vo.UserDetailsVO;

@Controller
public class RegistrationController {
	@Autowired
	UserDetailsService userDetailsService;
	
    @GetMapping("/registration")
    public String viewRegistration(Model model){
        model.addAttribute("userdetails", new UserDetails());
        return "registration";
    }

    @PostMapping("/registration")
    public ModelAndView doRegistration(@ModelAttribute("userdetails") UserDetails userdetail){
//        ModelAndView mav=new ModelAndView();
//    	System.out.println(userdetail);
    	
    	userDetailsService.createUser(userdetail);
        
       
        	
              
        return null;
    }
}
