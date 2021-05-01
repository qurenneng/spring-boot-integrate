package com.example.springbootcacheintegrat.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.springbootcacheintegrat.bean.Employee;

/**
 * @Author qrn
 * @Date 2021/5/1 下午2:53
 * @Version 1.0
 * @blog https://blog.csdn.net/qq_41971087
 */
public interface EmployeeService extends IService<Employee> {

    Employee getByEmployee(Integer id);

    Employee updateEmployee(Employee employee);

    Employee deleteEmployee(Integer id);
}
