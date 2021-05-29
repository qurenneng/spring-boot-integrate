package com.example.springbootapiintegrat.netease.server;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.springbootapiintegrat.netease.bean.Music;

/**
 * @Author qrn
 * @Title https://blog.csdn.net/qq_4197108
 * @Date 2021/5/27 19:58
 * @time 19:58
 */
public interface IMusicService  extends IService<Music> {


    /**
     * 获取网易云音乐:
     * @return
     */
    String getMusicUrl();


    /**
     * 获取网易云热评
     * @return
     */
    String getHotMusicUrl();

}
