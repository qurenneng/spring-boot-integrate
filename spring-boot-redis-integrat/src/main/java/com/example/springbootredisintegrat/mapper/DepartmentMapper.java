package com.example.springbootredisintegrat.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springbootredisintegrat.bean.Department;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author qrn
 * @Date 2021/5/1 下午2:42
 * @Version 1.0
 * @blog https://blog.csdn.net/qq_41971087
 */
@Mapper
public interface DepartmentMapper extends BaseMapper<Department> {
}
