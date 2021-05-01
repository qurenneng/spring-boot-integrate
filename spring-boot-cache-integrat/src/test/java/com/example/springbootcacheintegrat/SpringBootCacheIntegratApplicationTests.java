package com.example.springbootcacheintegrat;

import com.example.springbootcacheintegrat.bean.Employee;
import com.example.springbootcacheintegrat.mapper.EmployeeMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootCacheIntegratApplicationTests {

    @Autowired
    EmployeeMapper employeeMapper;

    @Test
    void contextLoads() {
        Employee employee = employeeMapper.selectById(1);
        System.out.println(employee);
    }

}
