package com.example.springbootmybatisplusintegrat.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springbootmybatisplusintegrat.bean.User;
import com.example.springbootmybatisplusintegrat.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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
