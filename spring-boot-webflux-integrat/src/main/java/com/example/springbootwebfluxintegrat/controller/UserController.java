package com.example.springbootwebfluxintegrat.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springbootwebfluxintegrat.bean.User;
import com.example.springbootwebfluxintegrat.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * @Author qrn
 * @Title
 * @Date 2021/6/2 10:51
 * @time 10:51
 * web flux 实例:
 */
@RestController
@RequestMapping("/users")
public class UserController {


    @Autowired
    private IUserService iUserService;

    /**
     * 获取用户信息:
     * @param userId
     * @return
     */
    @GetMapping("/getUser")
    public Mono<User> getUser(Integer userId) {
        return Mono.just(iUserService.getById(userId));
    }

    /**
     * 删除用户信息:
     * @param userId
     */
    @DeleteMapping("/deleteUser")
    public void deleteUser(Long userId) {
        iUserService.removeById(userId);
    }


    @GetMapping("list")
    public Flux<List<User>> list(){
        return Flux.just(iUserService.list());
    }


    /**
     * 分页列表查询:
     * @param page
     * @param rows
     * @return
     */
    @GetMapping("getPageUser")
    public Flux<IPage<User>> getPageUser(Integer page, Integer rows){
        Page<User> userPage = new Page<User>();
        userPage.setCurrent(page);
        userPage.setSize(rows);
        IPage<User> userIPage = iUserService.selectUserPage(userPage);
        return Flux.just(userIPage);
    }


    @PutMapping("saveUser")
    public boolean saveUser(User user){
        boolean saveuser = iUserService.save(user);
        return  saveuser;
    }

}
