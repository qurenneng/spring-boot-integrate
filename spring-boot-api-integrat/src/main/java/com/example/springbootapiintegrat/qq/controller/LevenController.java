package com.example.springbootapiintegrat.qq.controller;

import com.example.springbootapiintegrat.qq.server.ILevenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author qrn
 * @Title
 * @Date 2021/5/29 17:21
 * @time 17:21
 * 网易云控制层:
 */
@RestController
@RequestMapping("/leven/")
public class LevenController {


    @Autowired
    ILevenService iMusicService;

    /**
     * 根据qq号查询 qq等级:
     * @param qq
     * @return
     */
    @RequestMapping("queryQQ")
    public String queryQQ(String qq){
        return  iMusicService.queryQQ(qq);
    }


    /**
     * 直连qq群:
     * @param qq
     * @return
     */
    @RequestMapping("queryQun")
    public String queryQun(String qq){
        return  iMusicService.queryQun(qq);
    }

}
