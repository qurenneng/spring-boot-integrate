package com.example.springbootapiintegrat.netease.controller;

import com.example.springbootapiintegrat.netease.server.IMusicService;
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
public class NeteaseController {


    @Autowired
    IMusicService iMusicService;

    /**
     * 获取网易云音乐:
     * @return
     */
    @RequestMapping("getMusicUrl")
    public String getMusicUrl(){
        return  iMusicService.getMusicUrl();
    }

    /**
     * 获取网易云热评:
     * @return
     */
    @RequestMapping("getHotMusicUrl")
    public String getHotMusicUrl(){
        return  iMusicService.getHotMusicUrl();
    }

}
