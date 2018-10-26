package com.blog.service;

import com.blog.mapper.EmployeeMapper;
import com.blog.model.Employee;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by yaojie on 2018-10-19.
 */

@Service
public class EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public List<Employee> selectAll(HttpServletRequest request){

        String token =request.getHeader("token");

        String user = stringRedisTemplate.opsForValue().get(token);

        System.out.println(user);

        return employeeMapper.selectAll();

    }




}
