package com.blog.service;

import com.blog.dto.Cource;
import com.blog.dto.StudentGenderDto;
import com.blog.exception.ErrorCode;
import com.blog.exception.ServiceException;
import com.blog.mapper.StudentMapper;
import com.blog.model.Student;

import com.blog.support.PageDto;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * Created by yaojie on 2018-10-18.
 */

//@CacheConfig(cacheNames = "StudentService")
@Service
public class StudentService {

    @Autowired
    StudentMapper studentMapper;

//    public List<Student> showStudent(){
//        return studentMapper.selectAllUser();
//    }


    public PageDto<Student> list(int page,int size){
        PageHelper.startPage(page, size);
        List<Student> students = studentMapper.list();
        System.out.println(students);
        PageDto<Student> pageDto = new PageDto<Student>(students);
        return pageDto;
    }

//    public int addUser(Student user) {
//
//        return studentMapper.insert(user);
//    }

    public List<Student> selectAll(){
        return studentMapper.selectAll();
    }

    public List<StudentGenderDto> staticGender(){
        return studentMapper.staticGender();
    }

    public void insert(Student student)  {
        if (StringUtils.isEmpty(student.getSname()) || StringUtils.isEmpty(student.getSsex()) ){
            throw new ServiceException(ErrorCode.paramError);
        }
        studentMapper.insert(student);
    }

    public void update(Student student)  {
        if (StringUtils.isEmpty(student.getSname()) || StringUtils.isEmpty(student.getSsex()) ){
            throw new ServiceException(ErrorCode.paramError);
        }
        studentMapper.updateByPrimaryKey(student);
    }

    public void deleteStudent(long id){
        if (studentMapper.selectByPrimaryKey(id)==null){
            throw new ServiceException(100,"无此数据");
        }
        studentMapper.deleteByPrimaryKey(id);
    }

    public Student selectStudentById(long id){
        if (studentMapper.selectByPrimaryKey(id)==null){
            throw new ServiceException(100,"无此数据");
        }
        return studentMapper.selectByPrimaryKey(id);
    }


    public List<Cource> test(){
        return studentMapper.test();
    }



}
