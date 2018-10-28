package com.blog.service;

import com.blog.dto.StudentGenderDto;
import com.blog.exception.ErrorCode;
import com.blog.exception.ServiceException;
import com.blog.mapper.CustomerMapper;
import com.blog.mapper.StudentMapper;
import com.blog.model.Customer;
import com.blog.model.Student;
import com.blog.support.PageDto;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by yaojie on 2018-10-18.
 */

//@CacheConfig(cacheNames = "CustomerService")
@Service
public class CustomerService {

    @Autowired
    CustomerMapper customerMapper;

//    public List<StudentGenderDto> staticGender(){
//        return studentMapper.staticGender();
//    }

    public void insert(Customer customer)  {
        if (StringUtils.isEmpty(customer.getName()) || StringUtils.isEmpty(customer.getGender())
        || StringUtils.isEmpty(customer.getPhone()) || StringUtils.isEmpty(customer.getSource())){
            throw new ServiceException(ErrorCode.paramError);
        }
        customer.setCreatedAt(new Date());
        customerMapper.insert(customer);
    }

    public void deleteStudent(int id){
        if (customerMapper.selectByPrimaryKey(id)==null){
            throw new ServiceException(100,"无此数据");
        }
        customerMapper.deleteByPrimaryKey(id);
    }

    public void update(Customer customer)  {
        if (StringUtils.isEmpty(customer.getName()) || StringUtils.isEmpty(customer.getGender())
                || StringUtils.isEmpty(customer.getPhone()) || StringUtils.isEmpty(customer.getSource())){
            throw new ServiceException(ErrorCode.paramError);
        }
        customer.setUpdateAt(new Date());
        customerMapper.updateByPrimaryKey(customer);
    }

    public Customer selectById(int id){
        if (customerMapper.selectByPrimaryKey(id)==null){
            throw new ServiceException(100,"无此数据");
        }
        return customerMapper.selectByPrimaryKey(id);
    }

    public PageDto<Customer> list(int page, int size){
        PageHelper.startPage(page, size);
        List<Customer> customers = customerMapper.selectAll();
        PageDto<Customer> pageDto = new PageDto<Customer>(customers);
        return pageDto;
    }

    public PageDto<Customer> listByName(int page, int size, String name){
        PageHelper.startPage(page, size);
        List<Customer> customers = customerMapper.listByName(name);
        PageDto<Customer> pageDto = new PageDto<Customer>(customers);
        return pageDto;
    }



}
