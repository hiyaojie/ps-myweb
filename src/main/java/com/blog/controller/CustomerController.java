package com.blog.controller;

import com.blog.dto.StudentGenderDto;
import com.blog.model.Customer;
import com.blog.model.Student;
import com.blog.service.CustomerService;
import com.blog.service.StudentService;
import com.blog.support.PageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(value = "api/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;


    @RequestMapping(value = "/insert",method= RequestMethod.POST)
    public void insert(Customer customer) throws Exception {
        customerService.insert(customer);
    }

    @RequestMapping(value = "/delete",method= RequestMethod.GET)
    public void deleteStudent(@RequestParam int id) {
        customerService.deleteStudent(id);
    }

    @RequestMapping(value = "/update",method= RequestMethod.POST)
    public void update(Customer customer){
        customerService.update(customer);
    }

//    @RequestMapping(value = "/staticGender",method= RequestMethod.GET)
//    public List<StudentGenderDto> staticGender() {
//        return studentService.staticGender();
//    }


    @RequestMapping(value = "/selectById",method= RequestMethod.GET)
    public Customer selectById(@RequestParam int id) {
        return customerService.selectById(id);
    }

    @RequestMapping(value = "/list",method= RequestMethod.GET)
    public PageDto<Customer> listCustomers(@RequestParam int page, @RequestParam int size) {
        return customerService.list(page,size);
    }


    @RequestMapping(value = "/listByName",method= RequestMethod.GET)
    public PageDto<Customer> listByName(@RequestParam int page, @RequestParam int size, @RequestParam String name) {
        return customerService.listByName(page,size,name);
    }
}
