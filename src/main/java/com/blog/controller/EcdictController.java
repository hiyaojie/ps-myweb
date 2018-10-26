package com.blog.controller;

import com.blog.model.Ecdict;
import com.blog.service.EcdictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;



@RestController
@RequestMapping(value = "api/ecdict")
public class EcdictController {

    @Autowired
    EcdictService ecdictService;

    @RequestMapping(value = "/showWords",method= RequestMethod.GET)
    public List<Ecdict> showords(@RequestParam int num) {
        return ecdictService.showWords(num);
    }


}
