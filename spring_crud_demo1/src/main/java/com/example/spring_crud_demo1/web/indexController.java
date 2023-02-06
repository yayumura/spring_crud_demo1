package com.example.spring_crud_demo1.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class indexController {

    @GetMapping
    public String index(){
        return "index";
    }

}
