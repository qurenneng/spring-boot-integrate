package com.example.springbootapiintegrat.qq.server.Impl;

import cn.hutool.http.HttpUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springbootapiintegrat.qq.bean.Leven;
import com.example.springbootapiintegrat.qq.common.LevenConfig;
import com.example.springbootapiintegrat.qq.mapper.LevenMapper;
import com.example.springbootapiintegrat.qq.server.ILevenService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author qrn
 * @Title https://blog.csdn.net/qq_4197108
 * @Date 2021/5/27 19:59
 * @time 19:59
 */
@Service
public class LevenServiceImpl extends ServiceImpl<LevenMapper, Leven> implements ILevenService {

    /**
     *根据qq号获取qq等级:
     * @param qq
     * @return
     */
    @Override
    public String queryQQ(String qq) {
        Map<String,Object> map = new HashMap<>();
        map.put("qq",qq);
        String data = HttpUtil.get(LevenConfig.QQLEVEL, map);
        return data;
    }

    /**
     * 直连qq群:
     * @param qq
     * @return
     */
    @Override
    public String queryQun(String qq) {
        Map<String,Object> map = new HashMap<>();
        map.put("qq",qq);
        String data = HttpUtil.get(LevenConfig.QQQUN, map);
        return data;
    }
}
