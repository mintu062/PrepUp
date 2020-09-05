package com.prepup.controller;

import com.prepup.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String viewLogin(Model model){
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/login")
    public String doLogin(@ModelAttribute("user") User user){
        Boolean isSuccess=Boolean.FALSE;
        //TODO: validate login from db

        if(isSuccess)//define login_success jsp
            return "login_success";
        return "login";
    }
}
