package com.example.springbootmybatisplusintegrat.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springbootmybatisplusintegrat.bean.User;
import com.example.springbootmybatisplusintegrat.mapper.UserMapper;
import com.example.springbootmybatisplusintegrat.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * @Author qrn
 * @Title
 * @Date 2021/4/27 16:38
 * @time 16:38
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements IUserService {

    @Override
    public IPage<User> selectUserPage(Page<User> page) {
        return baseMapper.selectPageVo(page);
    }
}
