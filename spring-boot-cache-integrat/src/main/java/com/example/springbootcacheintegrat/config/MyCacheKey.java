package com.example.springbootcacheintegrat.config;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @Author qrn
 * @Date 2021/5/1 下午5:05
 * @Version 1.0
 * @blog https://blog.csdn.net/qq_41971087
 *  自定义缓存key KeyGenerator
 */
@Configuration
public class MyCacheKey {

    @Bean("getkeyGenerator")
    public KeyGenerator getkeyGenerator(){
        return new KeyGenerator(){

            @Override
            public Object generate(Object o, Method method, Object... objects) {
                return method.getName()+"["+ Arrays.asList(objects).toString() +"]";
            }
        };
    }
}
