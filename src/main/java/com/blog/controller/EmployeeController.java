package com.blog.controller;

import com.blog.model.Employee;
import com.blog.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;



@RestController
@RequestMapping(value = "employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value = "/selectAll",method= RequestMethod.GET)
    public List<Employee> selectAll(HttpServletRequest request) {
        return employeeService.selectAll(request);
    }


}
