package com.example.springbootcacheintegrat.controller;

import com.example.springbootcacheintegrat.bean.Employee;
import com.example.springbootcacheintegrat.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author qrn
 * @Date 2021/5/1 下午2:55
 * @Version 1.0
 * @blog https://blog.csdn.net/qq_41971087
 */
@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    /**
     * 查询信息：
     * @param id
     * @return
     */
    @RequestMapping("/getEmployee")
    public Employee getEmployee(Integer id){
        return  employeeService.getByEmployee(id);
    }

    /**
     * 更新信息
     * @param employee
     * @return
     */
    @RequestMapping("/updateEmployee")
    public Employee updateEmployee(Employee employee){
        return  employeeService.updateEmployee(employee);
    }

    /**
     * 删除信息：
     * @param id
     * @return
     */
    @RequestMapping("/deleteEmployee")
    public Employee deleteEmployee(Integer id){
        return  employeeService.deleteEmployee(id);
    }
}
