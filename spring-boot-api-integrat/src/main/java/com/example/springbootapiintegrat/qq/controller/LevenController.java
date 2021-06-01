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
@RequestMapping("/netease/")
public class LevenController {


    @Autowired
    ILevenService iMusicService;

}
