package com.example.springbootredisintegrat;

import com.example.springbootredisintegrat.bean.Employee;
import com.example.springbootredisintegrat.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@SpringBootTest
class SpringBootRedisIntegratApplicationTests {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    EmployeeService employeeService;

    @Autowired
    RedisTemplate<Object, Employee> employeeRedisTemplate;

    /**
     * 测试 redis 连接：
     */
    @Test
    void contextLoads() {
        Employee byEmployee = employeeService.getByEmployee(1);
        //redisTemplate.opsForValue().set("empl-2",byEmployee);
        employeeRedisTemplate.opsForValue().set("empl-2",byEmployee);
    }

}
