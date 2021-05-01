package com.example.springbootcacheintegrat.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springbootcacheintegrat.bean.Employee;
import com.example.springbootcacheintegrat.mapper.EmployeeMapper;
import com.example.springbootcacheintegrat.service.EmployeeService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @Author qrn
 * @Date 2021/5/1 下午2:53
 * @Version 1.0
 * @blog https://blog.csdn.net/qq_41971087
 */
@Service
@CacheConfig(cacheNames = "emp")
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {


    /**
     * 数据执行完成后，加入到缓存中，当下一次执行时候，直接从缓存中查询数据，无需查库。
     * @param id
     * @return
     */
    @Override
    @Cacheable(cacheNames = "emp",sync = true)
    public Employee getByEmployee(Integer id) {
        return baseMapper.selectById(id);
    }

    /**
     * 更新数据库数据，并且更新缓存中的数据
     * @param employee
     * @return
     */
    @Override
    @CachePut(key = "#employee.id")
    public Employee updateEmployee(Employee employee) {
        baseMapper.updateById(employee);
        return employee;
    }

    /**
     * 删除数据库并且清除缓存中的数据：
     * 其他参数：allEntries = true 删除所有  emp 中的缓存数据
     * beforeInvocation = true 默认是在方法执行之后删除缓存中的数据。
     * @param id
     * @return
     */
    @Override
    @CacheEvict()
    public Employee deleteEmployee(Integer id) {
        return null;
    }


}
