package com.example.springbootredisintegrat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringBootRedisIntegratApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootRedisIntegratApplication.class, args);
    }

}
