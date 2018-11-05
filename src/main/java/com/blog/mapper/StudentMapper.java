package com.blog.mapper;

import com.blog.dto.Cource;
import com.blog.dto.StudentGenderDto;
import com.blog.model.Student;
import com.blog.support.MyMapper;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface StudentMapper extends MyMapper<Student> {
    @Select({"<script>",
            "SELECT *\n" +
                    "FROM student"+
                    "</script>"
    })
//    @ResultMap("BaseResultMap")
    @ResultType(Student.class)
    List<Student> list();


    @Select({"<script>",
            "SELECT a.`Ssex` ssex,COUNT(*) as num\n" +
                    "FROM `student` a\n" +
                    "GROUP BY a.`Ssex`\n" +
                    "ORDER BY COUNT(*) DESC"+
                    "</script>"
    })
    @ResultType(StudentGenderDto.class)
    List<StudentGenderDto> staticGender();


    @Select({"<script>",
            "SELECT a.`cname`,a.`tid`\n" +
                    "FROM course a"+
                    "</script>"
    })
    @ResultType(Cource.class)
    List<Cource> test();



}