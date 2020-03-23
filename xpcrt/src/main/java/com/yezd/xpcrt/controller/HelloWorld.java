package com.yezd.xpcrt.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

    @RequestMapping("hello")
    public String helloWorld(){
        System.out.println("hello world");
        return "hello world";
    }
}
