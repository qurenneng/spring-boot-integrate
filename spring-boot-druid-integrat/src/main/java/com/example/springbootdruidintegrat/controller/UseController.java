package com.example.springbootdruidintegrat.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springbootdruidintegrat.bean.User;
import com.example.springbootdruidintegrat.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author qrn
 * @Title
 * @Date 2021/4/27 16:44
 * @time 16:44
 */
@RestController
public class UseController {

    @Autowired
    IUserService iUserService;

    @GetMapping("getUser")
    public User getUser(Integer id){
        return iUserService.getById(id);
    }

    @GetMapping("list")
    public List<User> list(){
        return iUserService.list();
    }


    /**
     * 分页列表查询:
     * @param page
     * @param rows
     * @return
     */
    @GetMapping("getPageUser")
    public IPage<User> getPageUser(Integer page,Integer rows){
        Page<User> userPage = new Page<User>();
        userPage.setCurrent(page);
        userPage.setSize(rows);
        IPage<User> userIPage = iUserService.selectUserPage(userPage);
        return userIPage;
    }


    @PutMapping("saveUser")
    public boolean saveUser(User user){
        boolean saveuser = iUserService.save(user);
        return  saveuser;
    }

    @DeleteMapping("deleteUser")
    public boolean deleteUser(Integer id){
        boolean removeUserById = iUserService.removeById(id);
            return  removeUserById;
    }

}
