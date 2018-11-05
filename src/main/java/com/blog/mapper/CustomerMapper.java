package com.blog.mapper;

import com.blog.model.Customer;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface CustomerMapper extends Mapper<Customer> {

    @Select({"<script>",
            "select * from customer\n" +
                    "<when test=\"name!=''\">\n" +
                    "where `name` regexp #{name} \n"+
                    "</when>"+
                    "</script>"
    })
    @ResultMap("BaseResultMap")
    List<Customer> listByName(@Param("name") String name);
}