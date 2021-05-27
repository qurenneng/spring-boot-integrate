package com.example.springbootmongodbintegrat.controller;

import com.example.springbootmongodbintegrat.bean.User;
import com.example.springbootmongodbintegrat.repository.UserRepository;
import com.example.springbootmongodbintegrat.server.IUserServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author qrn
 * @Title
 * @Date 2021/5/26 20:48
 * @time 20:48
 */
@RestController
@RequestMapping("/user/")
public class UserController {

    @Autowired
    IUserServer iUserServer;


    @Autowired
    UserRepository userRepository;


    /**
     * 添加文档数据
     * @param user
     * @return
     */
    @RequestMapping("saveUser")
    public String saveUser(User user){
        iUserServer.saveUser(user);
        return  "添加成功";
    }

    /**
     * 获取当前文档内容
     * @param id
     * @return
     */
    @RequestMapping("getUser")
    public User getUser(Integer id){
      return iUserServer.getUser(id);
    }

    /**
     * 当前文档 user 所有内容
     * @return
     */
    @RequestMapping("listUser")
    public List<User> listUser(){
        return iUserServer.listUser();
    }

    /**
     * 删除文档
     * @param id
     * @return
     */
    @RequestMapping("removeUser")
    public String removeUser(Integer id){
        iUserServer.removeUser(id);
        return  "删除成功";
    }


// 使用 jpa 来操作 MongoDB 数据库:

    /**
     * 添加文档数据
     * @param user
     * @return
     */
    @RequestMapping("saveJpaUser")
    public String saveJpaUser(User user){
        userRepository.save(user);
        return  "添加成功";
    }

    /**
     * 获取当前文档内容
     * @param id
     * @return
     */
    @RequestMapping("getJpaUser")
    public User getJpaUser(Integer id){
        return userRepository.findById(id).get();
    }

    /**
     * 当前文档 user 所有内容
     * @return
     */
    @RequestMapping("listJpaUser")
    public Iterable<User> listJpaUser(){
        return userRepository.findAll();
    }

    /**
     * 删除文档
     * @param id
     * @return
     */
    @RequestMapping("removeJpaUser")
    public String removeJpaUser(Integer id){
        userRepository.deleteById(id);
        return  "删除成功";
    }



}
