package com.blog.service;

import com.blog.exception.ServiceException;
import com.blog.mapper.LinuxCommandMapper;
import com.blog.model.LinuxCommand;
import com.blog.support.PageDto;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class LinuxStudyService {

    @Autowired
    LinuxCommandMapper linuxCommandMapper;

    public PageDto<LinuxCommand> list(int page, int size){
        PageHelper.startPage(page,size);
        List<LinuxCommand> list = linuxCommandMapper.selectAll();
        PageDto<LinuxCommand> pageDto = new PageDto<LinuxCommand>(list);
        return pageDto;
    }

    public void update(long id,String type){
        if (type.equals("studied")){
            LinuxCommand linuxCommand = linuxCommandMapper.selectByPrimaryKey(id);
            if (linuxCommand==null){
                throw new ServiceException(100,"无此数据");
            }
            linuxCommand.setIsStudied("1");
            linuxCommand.setStudiedAt(new Date());
            linuxCommandMapper.updateByPrimaryKey(linuxCommand);
        }
        else if (type.equals("unstudied")){
            LinuxCommand linuxCommand = linuxCommandMapper.selectByPrimaryKey(id);
            if (linuxCommand==null){
                throw new ServiceException(100,"无此数据");
            }
            linuxCommand.setIsStudied(null);
            linuxCommand.setStudiedAt(null);
            linuxCommandMapper.updateByPrimaryKey(linuxCommand);
        }

    }

    public List<LinuxCommand> get3commands(){
        return linuxCommandMapper.get3commands();
    }
}
