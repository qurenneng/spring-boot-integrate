package com.example.springbootmybatisplusintegrat.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springbootmybatisplusintegrat.bean.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author qrn
 * @Title
 * @Date 2021/4/27 16:37
 * @time 16:37
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
