package com.blog.controller;

import com.blog.dto.StudentGenderDto;
import com.blog.model.Student;
import com.blog.service.StudentService;
import com.blog.support.PageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;



@RestController
@RequestMapping(value = "api/user")
public class StudentController {

    @Autowired
    StudentService studentService;

    @RequestMapping(value = "/get")
    public String getStudent(){
        return "aaa";
    }


    @RequestMapping(value = "/listStudents",method= RequestMethod.GET)
    public PageDto<Student> listStudents(@RequestParam int page,@RequestParam int size) {
        return studentService.list(page,size);
    }

    @RequestMapping(value = "/selectAll",method= RequestMethod.GET)

    public List<Student> selectAll() {
        return studentService.selectAll();
    }

    @RequestMapping(value = "/insert",method= RequestMethod.POST)
    public void insert(Student student) throws Exception {

        studentService.insert(student);
    }

    @RequestMapping(value = "/update",method= RequestMethod.POST)
    public void update(Student student){

        studentService.update(student);
    }

    @RequestMapping(value = "/staticGender",method= RequestMethod.GET)
    public List<StudentGenderDto> staticGender() {
        return studentService.staticGender();
    }

    @RequestMapping(value = "/delete",method= RequestMethod.GET)
    public void deleteStudent(@RequestParam long id) {
        studentService.deleteStudent(id);
    }

    @RequestMapping(value = "/selectStudentById",method= RequestMethod.GET)
    public Student selectStudentById(@RequestParam long id) {
        return studentService.selectStudentById(id);
    }
}
