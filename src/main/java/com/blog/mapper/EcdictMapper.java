package com.blog.mapper;

import com.blog.model.Ecdict;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface EcdictMapper extends Mapper<Ecdict> {
    @Select({
            "SELECT * FROM ecdict a \n" +
                    "ORDER BY RAND() LIMIT #{num} ;"
    })
    @ResultMap("BaseResultMap")
    List<Ecdict> showWords(@Param("num") int num);
}