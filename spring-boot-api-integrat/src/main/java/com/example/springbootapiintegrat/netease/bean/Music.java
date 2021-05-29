package com.example.springbootapiintegrat.netease.bean;

import java.util.Date;

/**
 * @Author qrn
 * @Title
 * @Date 2021/5/27 19:55
 * @time 19:55
 * 网易云音乐实体类:
 */
public class Music {

    private Integer id;
    /**
     * 作者名称:
     */
    private String artistsName;
    /**
     * 歌曲链接:
     */
    private String musicUrl;
    /**
     * 歌曲封面图片
     */
    private String musicPic;
    /**
     * 创建时间:
     */
    private Date createTime;
}
