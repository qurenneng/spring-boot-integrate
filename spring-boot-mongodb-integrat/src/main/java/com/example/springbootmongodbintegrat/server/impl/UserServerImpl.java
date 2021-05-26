package com.example.springbootmongodbintegrat.server.impl;

import com.example.springbootmongodbintegrat.bean.User;
import com.example.springbootmongodbintegrat.server.IUserServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author qrn
 * @Title
 * @Date 2021/5/26 18:04
 * @time 18:04
 */
@Service
public class UserServerImpl implements IUserServer {
    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public void saveUser(User user) {
        mongoTemplate.save(user);
    }

    @Override
    public User getUser(Integer id) {
        return mongoTemplate.findById(id,User.class);
    }

    @Override
    public void removeUser(Integer id) {
        mongoTemplate.remove(id);
    }

    @Override
    public List<User> listUser() {
        return mongoTemplate.findAll(User.class);
    }


}
