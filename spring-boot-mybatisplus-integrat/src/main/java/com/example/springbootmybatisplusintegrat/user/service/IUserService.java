package com.example.springbootmybatisplusintegrat.user.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.springbootmybatisplusintegrat.user.bean.User;

/**
 * @Author qrn
 * @Title
 * @Date 2021/4/27 16:38
 * @time 16:38
 */
public interface IUserService extends IService<User> {

    public IPage<User> selectUserPage(Page<User> page);
}
