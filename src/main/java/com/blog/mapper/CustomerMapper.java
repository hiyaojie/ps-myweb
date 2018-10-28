package com.blog.mapper;

import com.blog.model.Customer;
import com.blog.model.Student;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.RequestParam;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface CustomerMapper extends Mapper<Customer> {

    @Select({"<script>",
            "select * from customer\n" +
                    "where name like '%"+ "#{name}"+"%'\n"+
                    "</script>"
    })
    @ResultMap("BaseResultMap")
    List<Customer> listByName(@Param("name") String name);
}