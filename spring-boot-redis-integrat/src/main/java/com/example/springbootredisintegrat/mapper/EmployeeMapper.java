package com.example.springbootredisintegrat.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springbootredisintegrat.bean.Employee;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author qrn
 * @Date 2021/5/1 下午2:43
 * @Version 1.0
 * @blog https://blog.csdn.net/qq_41971087
 */
@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {
}
