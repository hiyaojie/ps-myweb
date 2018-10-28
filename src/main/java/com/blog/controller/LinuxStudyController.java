package com.blog.controller;

import com.blog.dto.StudentGenderDto;
import com.blog.model.LinuxCommand;
import com.blog.model.Student;
import com.blog.service.LinuxStudyService;
import com.blog.service.StudentService;
import com.blog.support.PageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(value = "api/linux")
public class LinuxStudyController {

    @Autowired
    LinuxStudyService linuxStudyService;

    @RequestMapping(value = "/list",method= RequestMethod.GET)
    public PageDto<LinuxCommand> listLinuxStudy(@RequestParam int page, @RequestParam int size) {
        return linuxStudyService.list(page,size);
    }

//    @RequestMapping(value = "/selectAll",method= RequestMethod.GET)
//
//    public List<Student> selectAll() {
//        return studentService.selectAll();
//    }
//
//    @RequestMapping(value = "/insert",method= RequestMethod.POST)
//    public void insert(Student student) throws Exception {
//
//        studentService.insert(student);
//    }
//
    @RequestMapping(value = "/update",method= RequestMethod.GET)
    public void update(@RequestParam long id,@RequestParam String type){
        linuxStudyService.update(id,type);
    }

    @RequestMapping(value = "/get3commands",method= RequestMethod.GET)
    public List<LinuxCommand> get3commands(){
        return linuxStudyService.get3commands();
    }
//
//    @RequestMapping(value = "/staticGender",method= RequestMethod.GET)
//    public List<StudentGenderDto> staticGender() {
//        return studentService.staticGender();
//    }
//
//    @RequestMapping(value = "/delete",method= RequestMethod.GET)
//    public void deleteStudent(@RequestParam long id) {
//        studentService.deleteStudent(id);
//    }
//
//    @RequestMapping(value = "/selectStudentById",method= RequestMethod.GET)
//    public Student selectStudentById(@RequestParam long id) {
//        return studentService.selectStudentById(id);
//    }
}
