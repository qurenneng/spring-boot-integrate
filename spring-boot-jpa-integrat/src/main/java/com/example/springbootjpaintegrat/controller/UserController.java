package com.example.springbootjpaintegrat.controller;

import com.example.springbootjpaintegrat.entity.User;
import com.example.springbootjpaintegrat.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.web.bind.annotation.*;

/**
 * @Author qrn
 * @Title
 * @Date 2021/5/8 12:43
 * @time 12:43
 */
@RestController
@RequestMapping("/user/")
public class UserController {

    @Autowired
    UserRepository userRepository;

    /**
     * 没有id 就新增，有就修改
     * @param user
     */
    @PostMapping(path="save")
    public void addNewUser (User user) {
        userRepository.save(user);
    }

    /**
     * 获取所有的用户对象
     * @return
     */
    @GetMapping(path="list")
    public  Iterable<User> getAllUsers() {
     userRepository.findAll(PageRequest.of(1, 20));
        return userRepository.findAll();
    }


    /**
     * 分页查询 继承  PagingAndSortingRepository 就可以实现
     * @return
     */
    @GetMapping(path="pageList")
    public  Page<User> list(Integer page,Integer size) {
        Page<User> all = userRepository.findAll(PageRequest.of(page, size));
        return all;
    }

    /**
     * 删除用户数据
     * @param id
     */
    @GetMapping(path="del")
    public  void deleteUsers(Integer id) {
        userRepository.deleteById(id);
    }
}
