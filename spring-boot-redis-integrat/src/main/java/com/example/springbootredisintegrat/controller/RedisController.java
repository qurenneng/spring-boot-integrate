package com.example.springbootredisintegrat.controller;

import com.example.springbootredisintegrat.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @Author qrn
 * @Title
 * @Date 2021/6/11 11:20
 * @time 11:20
 *  https://blog.csdn.net/qq_41971087
 */
@RestController
public class RedisController {

    @Autowired
    RedisService redisService;

    /**
     * redis list 结构实现 lpush 发红包:
     * @param type 0普通红包 1.随机红包
     * @param number 红包个数
     * @param amount 红包金额
     */
    @PostMapping("/redWars")
    public void redWars(Integer type,Integer number, Integer amount){
        ArrayList<Integer> arrayList = new ArrayList<>();
        //总金额： 发送红包的总金币数
        Integer money = number * amount;
        //普通红包拆分
        if(type == 0){
            arrayList = commonRed(money, number);
            //随机红包拆分
        }else if(type == 1){
            /**
             * 由于我们金币是不需要小数的，我们值需要整数，所以下面代码被我改了
             * 如果是金额的红包 请 参考 RoomTest
             */
            arrayList = commonRoomRed(BigDecimal.valueOf(money),number);
        }
        //类型转换:
        List<String> collect = arrayList.stream().map(i -> String.valueOf(i)).collect(Collectors.toList());
        //红包key 过期时间 拆分的数据: 这就是抢红包的金额:
        redisService.lpush("1002",30, TimeUnit.HOURS,collect);
    }


    /**
     * 普通红包分配:
     * @param money
     * @param count
     * @return
     */
    public  ArrayList<Integer> commonRed(int money, int count) {
        // 创建一个长度的红包数组
        ArrayList<Integer> redList = new ArrayList<>();
        // 由于double的精度分体将其转换为int计算, 即将元转换为分计算，红包最小单位以分计算
        int totalMoney = money;
        Integer avg = totalMoney / count;
        int mod = totalMoney % count;
        for (int i = 0; i < count - 1; i++) {
            redList.add(avg);
        }
        redList.add(avg + mod);
        return redList;
    }



    public  ArrayList<Integer> commonRoomRed(BigDecimal remainMoney, int remainSize){
        ArrayList<Integer> redList = new ArrayList<>();
        RedPackage moneyPackage = new RedPackage();
        moneyPackage.remainMoney =remainMoney;
        moneyPackage.remainSize = remainSize;
        while (moneyPackage.remainSize != 0) {
            redList.add(getRandomMoney(moneyPackage).intValue());
        }
        return  redList;
    }



    public  BigDecimal getRandomMoney(RedPackage _redPackage) {
        // remainSize 剩余的红包数量
        // remainMoney 剩余的钱
        if (_redPackage.remainSize == 1) {
            _redPackage.remainSize--;
            return _redPackage.remainMoney.setScale(0, BigDecimal.ROUND_DOWN);
        }

        BigDecimal random = BigDecimal.valueOf(Math.random());
        BigDecimal min   = BigDecimal.valueOf(1);

        BigDecimal halfRemainSize = BigDecimal.valueOf(_redPackage.remainSize).divide(new BigDecimal(2), BigDecimal.ROUND_UP);
        BigDecimal max1 = _redPackage.remainMoney.divide(halfRemainSize, BigDecimal.ROUND_DOWN);
        BigDecimal minRemainAmount = min.multiply(BigDecimal.valueOf(_redPackage.remainSize - 1)).setScale(0, BigDecimal.ROUND_DOWN);
        BigDecimal max2 = _redPackage.remainMoney.subtract(minRemainAmount);
        BigDecimal max = (max1.compareTo(max2) < 0) ? max1 : max2;

        BigDecimal money = random.multiply(max).setScale(0, BigDecimal.ROUND_DOWN);
        money = money.compareTo(min) < 0 ? min: money;

        _redPackage.remainSize--;
        _redPackage.remainMoney = _redPackage.remainMoney.subtract(money).setScale(0, BigDecimal.ROUND_DOWN);;
        return money;
    }

    static class RedPackage {
        int    remainSize;
        BigDecimal remainMoney;
    }


    /**
     *  list 数据接口给 lpop: 抢红包
     * @param key 红包key
     */
    @RequestMapping("/setLpop")
    public void setLpop(String key){
        String lpop = redisService.lpop(key);
        if(!StringUtils.hasLength(lpop)){
            System.out.println("当前红包已抢光!");
        }else{
            System.out.println("恭喜你抢到红包--->"+lpop);
        }
    }


}
