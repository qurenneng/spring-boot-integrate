package com.example.springbootredisintegrat.service.Impl;

import com.example.springbootredisintegrat.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @Author qrn
 * @Date 2021/5/1 下午8:52
 * @Version 1.0
 * @blog https://blog.csdn.net/qq_41971087
 * redis 简单封装：
 */
@Service
public class RedisServiceImpl implements RedisService {
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Override
    public void set(String key, Object value) {
        stringRedisTemplate.opsForValue().set(key,value.toString());
    }

    @Override
    public void set(String key, Object value, long var3, TimeUnit var5) {
        stringRedisTemplate.opsForValue().set(key,value.toString(),var3,var5);
    }

    @Override
    public Long size(String key) {
        return stringRedisTemplate.opsForValue().size(key);
    }

    @Override
    public String get(Object var1) {
        return stringRedisTemplate.opsForValue().get(var1);
    }

}
