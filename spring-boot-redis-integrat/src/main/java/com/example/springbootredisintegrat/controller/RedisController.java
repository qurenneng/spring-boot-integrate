package com.example.springbootredisintegrat.controller;

import com.example.springbootredisintegrat.bean.Employee;
import com.example.springbootredisintegrat.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * @Author qrn
 * @Title
 * @Date 2021/6/11 11:20
 * @time 11:20
 *  https://blog.csdn.net/qq_41971087
 */
@RestController
public class RedisController {

    @Autowired
    RedisService redisService;

    /**
     * list 数据接口给 push:
     * @return
     */
    @RequestMapping("/setLpush")
    public void getEmployee(){
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("10");
        arrayList.add("11");
        arrayList.add("12");
        arrayList.add("13");
        arrayList.add("14");
        redisService.lpush("1002",30, TimeUnit.DAYS,arrayList);
    }


    /**
     * list 数据接口给 push:
     * @return
     */
    @RequestMapping("/setLpop")
    public void setLpop(){
        String lpop = redisService.lpop("1002");
        System.out.println(lpop);
    }


}
