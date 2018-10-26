package com.blog.controller;

import com.blog.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;



@RestController
@RequestMapping(value = "api/admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    @RequestMapping(value = "/login",method= RequestMethod.GET)
    public void login(@RequestParam String user,@RequestParam String pass,HttpServletResponse response) {
        adminService.login(user,pass,response);
    }
}
