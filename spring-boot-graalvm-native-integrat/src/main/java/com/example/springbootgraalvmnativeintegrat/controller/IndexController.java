package com.example.springbootgraalvmnativeintegrat.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author qrn
 * @Title
 * @Date 2021/6/15 16:58
 * @time 16:58
 * spring-native 实例:
 */
@RestController
public class IndexController {


    /**
     * 实例:
     * @return
     */
    @RequestMapping("/hello")
    public String hello(){
        return  "Hello, World!";
    }
}
