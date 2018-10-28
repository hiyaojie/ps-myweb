package com.blog.mapper;

import com.blog.model.LinuxCommand;
import com.blog.model.Student;
import com.blog.support.MyMapper;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface LinuxCommandMapper extends MyMapper<LinuxCommand> {
    @Select({"<script>",
            "select * from linux_command\n" +
                    "where is_studied is null\n" +
                    "or date(studied_at)=curdate()\n"+
                    "order by id\n" +
                    "limit 3"+
                    "</script>"
    })
    @ResultMap("BaseResultMap")
//    @ResultType(LinuxCommand.class)
    List<LinuxCommand> get3commands();
}