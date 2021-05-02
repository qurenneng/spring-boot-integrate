package com.example.springboottaskintegrat.controller;

import com.example.springboottaskintegrat.service.AsyncTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author qrn
 * @Date 2021/5/2 上午10:16
 * @Version 1.0
 * @blog https://blog.csdn.net/qq_41971087
 */
@RestController
public class AsyncTestController {

    @Autowired
    AsyncTestService asyncTestService;

    /**
     * 没有开启异步支持需要等待3秒后，返回
     * @return
     */
    @RequestMapping("/test")
    public String test(){
        asyncTestService.ayanc();
        return  "进来了吗";
    }
}
