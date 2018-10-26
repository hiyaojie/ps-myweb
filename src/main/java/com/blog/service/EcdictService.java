package com.blog.service;

import com.blog.mapper.EcdictMapper;
import com.blog.model.Ecdict;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yaojie on 2018-10-24.
 */
@Service
public class EcdictService {
    @Autowired
    EcdictMapper ecdictMapper;

    public List<Ecdict> showWords(int num){
        return ecdictMapper.showWords(num);
    }
}
