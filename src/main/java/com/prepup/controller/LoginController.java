package com.prepup.controller;

import com.prepup.model.User;
import com.prepup.service.UserDetailsService;
import com.prepup.vo.UserDetailsVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	
	@Autowired
	UserDetailsService userDetailsService;
	
    @GetMapping("/login")
    public String viewLogin(Model model){
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/login")
    public ModelAndView doLogin(@ModelAttribute("user") User user){
        ModelAndView mav=new ModelAndView();
        
        if(userDetailsService.isValidUser(user)) {
        	UserDetailsVO userDetailsVO = userDetailsService.findUser(user);
        	mav.addObject("userDetais", userDetailsVO);
        	if(userDetailsVO.getRole().equals("teacher")) 
        		mav.setViewName("teacher_dashboard");
        	else
        		mav.setViewName("student_dashboard");
        	
        }else {
        	mav.setViewName("login");
        	mav.addObject("user",user);//pass error
        }            
        return mav;
    }
}
