package com.example.shiro.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class hello {
    @RequestMapping("/hello")
    public String hello(Model model){
        model.addAttribute("name","OK");
        return "test";
    }

    @RequestMapping("/add")
    public String add(Model model){
        model.addAttribute("name","OK");
        return "user/add";
    }
    @RequestMapping("/update")
    public String update(Model model){
        model.addAttribute("name","OK");
        return "user/update";
    }
    @RequestMapping("/toLogin")
    public String toLogin(Model model){
        model.addAttribute("name","OK");
        return "login";
    }
    @RequestMapping("/unAuth")
    public String unAuth(Model model){
        model.addAttribute("name","OK");
        return "unAuth";
    }
}
