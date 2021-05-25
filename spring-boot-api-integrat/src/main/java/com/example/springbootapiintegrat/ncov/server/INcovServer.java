package com.example.springbootapiintegrat.ncov.server;

/**
 * @Author qrn
 * @Title
 * @Date 2021/5/25 15:11
 * @time 15:11
 */
public interface INcovServer {

    /**
     * 新冠全国疫情(腾讯)
     * @return
     */
    String getOnsInfo();

    /**
     * 新冠全国疫情（136）
     * @return
     */
    String listTotal();

    /**
     * 新冠全国疫情（新浪）
     * @return
     */
    String newsWapList();

}
