package com.example.springbootmongodbintegrat.server.impl;

import com.example.springbootmongodbintegrat.bean.User;
import com.example.springbootmongodbintegrat.server.IUserServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.CriteriaDefinition;
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

    /**
     * 添加文档
     * @param user
     */
    @Override
    public void saveUser(User user) {
        mongoTemplate.save(user);
    }

    /**
     * 根据id 获取当前文档信息
     * @param id
     * @return
     */
    @Override
    public User getUser(Integer id) {
        return mongoTemplate.findById(id,User.class);
    }

    /**
     * 删除文档信息，这里的删除是先查询当前文档信息，然后在删除
     * @param id
     */
    @Override
    public void removeUser(Integer id) {
        mongoTemplate.remove(mongoTemplate.findById(id, User.class));
    }

    /**
     * 获取所有的文档信息
     * @return
     */
    @Override
    public List<User> listUser() {
        return mongoTemplate.findAll(User.class);
    }


}
