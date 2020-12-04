package com.team.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


// RestController注解修饰的类 不支持视图转跳
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String sayHello(){
        return "hello!SpringBoot!!!";
    }

}
