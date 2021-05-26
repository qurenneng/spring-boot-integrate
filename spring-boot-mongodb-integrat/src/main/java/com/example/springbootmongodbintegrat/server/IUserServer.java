package com.example.springbootmongodbintegrat.server;

import com.example.springbootmongodbintegrat.bean.User;

import java.util.List;

/**
 * @Author qrn
 * @Title
 * @Date 2021/5/26 18:03
 * @time 18:03
 */
public interface IUserServer {

    /**
     * 添加
     * @param user
     */
    void saveUser(User user);

    User getUser(Integer id);

    void removeUser(Integer id);

    List<User> listUser();

}
