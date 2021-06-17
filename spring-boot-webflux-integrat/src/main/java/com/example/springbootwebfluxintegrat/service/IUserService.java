package com.example.springbootwebfluxintegrat.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.springbootwebfluxintegrat.bean.User;;

/**
 * @Author qrn
 * @Title
 * @Date 2021/4/27 16:38
 * @time 16:38
 */
public interface IUserService extends IService<User> {

     IPage<User> selectUserPage(Page<User> page);

     User getUser(Integer id);

     @SuppressWarnings("AlibabaAbstractMethodOrInterfaceMethodMustUseJavadoc")
     int insertUser(User user);
}
