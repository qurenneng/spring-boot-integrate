package com.example.springbootcacheintegrat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching  //开启基于注解的缓存
public class SpringBootCacheIntegratApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootCacheIntegratApplication.class, args);
    }

}
