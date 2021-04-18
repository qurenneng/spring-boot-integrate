package com.example.springbootknife4jintegrate.controller;

import com.example.springbootknife4jintegrate.bean.User;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.DynamicParameter;
import com.github.xiaoymin.knife4j.annotations.DynamicParameters;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @Author qrn
 * @Date 2021/4/18 上午11:14
 * @Version 1.0
 * @blog https://blog.csdn.net/qq_41971087
 */
@Api(tags = "用户模块")
@RestController
public class UserController {


    @ApiImplicitParam(name = "id",value = "id",required = true)
    @ApiOperationSupport(author = "1796789910@qq.com")
    @ApiOperation(value = "查询当前用户信息")
    @GetMapping("/getUser")
    public ResponseEntity<User> getUser(Integer id){
        User user = new User();
        user.setAge("男");
        user.setName("小明");
        user.setId(id);
        return ResponseEntity.ok(user);
    }

//    @DynamicParameters(name = "uses",properties = {
//            @DynamicParameter(name = "age",value = "年龄"),
//            @DynamicParameter(name = "name",value = "名称"),
//    })
    @ApiOperationSupport(author = "1796789910@qq.com",ignoreParameters={"id"})
    @ApiOperation(value = "新增用户信息")
    @PutMapping("/addUser")
    public ResponseEntity<User> addUser(User user){
        return ResponseEntity.ok(user);
    }


    @ApiOperationSupport(author = "1796789910@qq.com")
    @ApiOperation(value = "修改用户信息")
    @PutMapping("/updateUser")
    public ResponseEntity<User> updateUser(User user){
        return ResponseEntity.ok(user);
    }


    @ApiImplicitParam(name = "id",value = "id",required = true)
    @ApiOperationSupport(author = "1796789910@qq.com")
    @ApiOperation(value = "删除用户信息")
    @DeleteMapping("/deleteUser")
    public ResponseEntity<String> deleteUser(Integer id){
        return ResponseEntity.ok("删除成功");
    }


}
