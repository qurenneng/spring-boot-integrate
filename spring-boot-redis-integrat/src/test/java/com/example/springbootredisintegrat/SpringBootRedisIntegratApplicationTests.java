package com.example.springbootredisintegrat;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.springbootredisintegrat.bean.Employee;
import com.example.springbootredisintegrat.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@SpringBootTest
class SpringBootRedisIntegratApplicationTests {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    EmployeeService employeeService;

//    @Autowired
//    RedisTemplate<Object, Employee> redisTemplate;


    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger();
         atomicInteger.getAndIncrement();
         System.out.println(atomicInteger.get());
    }

    /**
     * 测试 redis 连接：
     */
    @Test
    void contextLoads() {
//        Employee byEmployee = employeeService.getByEmployee(1);
        //redisTemplate.opsForValue().set("empl-2",byEmployee);

//        ArrayList<Employee> arrayList =new ArrayList<>();
//
//        Employee employee = new Employee();
//        employee.setDId(1);
//        employee.setId(1);
//        employee.setLastName("123456465");
//
//        Employee employee2 = new Employee();
//        employee2.setDId(1);
//        employee2.setId(2);
//        employee2.setLastName("小明");
//
//        arrayList.add(employee);
//        arrayList.add(employee2);
//
//        redisTemplate.opsForValue().set("empl-2", JSONObject.toJSONString(arrayList));
//        redisTemplate.opsForValue().

//        String value =(String) redisTemplate.opsForValue().get("empl-2");
//        List<Employee> employees = JSON.parseArray(value, Employee.class);
        String key = "2";
        SetOperations setOperations = redisTemplate.opsForSet();
        Long size = setOperations.size(key);
        setOperations.pop(key,size);

//        setOperations.pop(key);

        System.out.println(size);

//        System.out.println(size);
//        if(size <= 3){
//            Long add = setOperations.add(key, size + 1);
//            System.out.println(add);
//        }

//        Object pop = setOperations.pop(key);

//        System.out.println(size);

//        Long add = redisTemplate.opsForSet().add(key, 1);
//
//        redisTemplate.opsForSet().size(key);
//
//        System.out.println(add);
//        System.out.println(employees);
    }

}
