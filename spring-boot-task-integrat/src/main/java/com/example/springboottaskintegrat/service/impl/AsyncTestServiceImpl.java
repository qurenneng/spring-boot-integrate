package com.example.springboottaskintegrat.service.impl;

import com.example.springboottaskintegrat.service.AsyncTestService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @Author qrn
 * @Date 2021/5/2 上午10:14
 * @Version 1.0
 * @blog https://blog.csdn.net/qq_41971087
 */
@Service
public class AsyncTestServiceImpl implements AsyncTestService {

    /**
     * 执行睡3秒
     * @Async 异步执行方法，无需等待
     */
    @Override
    @Async
    public void ayanc() {
        try{
            Thread.sleep(3000);
        }catch (Exception e){

        }
    }


    /**
     * 每五秒执行一次
     */
    @Override
    @Scheduled(fixedDelay=5000)
    public void hello(){
        System.out.println("进来了吗定时任务");
    }
}
