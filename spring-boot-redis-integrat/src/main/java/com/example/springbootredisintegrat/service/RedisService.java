package com.example.springbootredisintegrat.service;

import java.util.concurrent.TimeUnit;

/**
 * @Author qrn
 * @Date 2021/5/1 下午8:48
 * @Version 1.0
 * @blog https://blog.csdn.net/qq_41971087
 * redis接口：
 */
public interface RedisService {

    void set(String key, Object value);

    void set(String key, Object value, long var3, TimeUnit var5);

    Long size(String key);

    String get(Object var1);
}
