package com.example.springbootmybatisplusintegrat.user.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springbootmybatisplusintegrat.user.bean.User;
import com.example.springbootmybatisplusintegrat.user.mapper.UserMapper;
import com.example.springbootmybatisplusintegrat.user.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * @Author qrn
 * @Title
 * @Date 2021/4/27 16:38
 * @time 16:38
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Override
    public IPage<User> selectUserPage(Page<User> page) {
        return baseMapper.selectPageVo(page);
    }

    @Override
    public User getUser(Integer id) {
        return baseMapper.getUser(id);
    }

    @Override
    public int insertUser(User user) {
        return baseMapper.insertUser(user);
    }
}
