package com.example.springbootredisintegrat.service.Impl;

import com.example.springbootredisintegrat.service.RedisService;
import com.example.springbootredisintegrat.service.SmscodeServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author qrn
 * @Date 2021/7/21 下午9:18
 * @Version 1.0
 * @blog https://blog.csdn.net/qq_41971087
 * 1. 获取短信验证码 2分钟过期
 * 2。每天只能发送3次验证码
 * 3。验证码校验：
 */
@Service
public class SmscodeServerImpl implements SmscodeServer {

    @Autowired
    RedisService redisService;

    private  final  static String KEY = "code_";

    private final  static String COUND = "cound_";

    @Override
    public String smsCode(String phone, String code) {
        String codeCound = redisService.get(COUND + phone);
        AtomicInteger atomicInteger = new AtomicInteger();
        if(StringUtils.hasLength(codeCound)){
            Integer cound = Integer.valueOf(codeCound);
            if(cound < 3){
                atomicInteger.set(cound);
                int andIncrement = atomicInteger.getAndIncrement();
                redisService.set(COUND + phone,String.valueOf(andIncrement));
                redisService.set(KEY+code,code,2, TimeUnit.MINUTES);
            }else{
                return  "当前请求超过3次";
            }
        }else{
            int andIncrement = atomicInteger.getAndIncrement();
            redisService.set(COUND + phone,String.valueOf(andIncrement));
        }
        return "成功";
    }

    @Override
    public String signCode(String code) {
        String codeCound = redisService.get(KEY + code);
        if(StringUtils.hasLength(codeCound)){
            if(code.equals(codeCound)){
                return  "成功";
            }
        }
        return "失败";
    }
}
