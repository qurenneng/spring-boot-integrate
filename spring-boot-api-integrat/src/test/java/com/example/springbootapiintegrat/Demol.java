package com.example.springbootapiintegrat;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * @Author qrn
 * @Title
 * @Date 2021/6/10 10:31
 * @time 10:31
 */
public class Demol {


    public static BigDecimal getRandomMoney(Test.RedPackage _redPackage) {
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


    public static  void test(BigDecimal remainMoney,int remainSize){
        ArrayList<Integer> redList = new ArrayList<>();
        Test.RedPackage moneyPackage = new Test.RedPackage();
        moneyPackage.remainMoney =remainMoney;
        moneyPackage.remainSize = remainSize;

        while (moneyPackage.remainSize != 0) {
            redList.add(getRandomMoney(moneyPackage).intValue());
           // System.out.print(getRandomMoney(moneyPackage)  + "   ");
        }
        redList.stream().forEach(System.out::println);
        int sum = redList.stream().mapToInt(i -> i).sum();
        System.out.println("----------------------->");
        System.out.println(sum);
    }

    public static void main(String[] args) {
//        for (int i = 0; i < 50; i++) {
//        Test.RedPackage moneyPackage = new Test.RedPackage();
//        moneyPackage.remainMoney = BigDecimal.valueOf(1000);
//        moneyPackage.remainSize = 4;
//
//        while (moneyPackage.remainSize != 0) {
//            System.out.print(getRandomMoney(moneyPackage)  + "   ");
//        }
        test(BigDecimal.valueOf(100),10);

//    }
    }

    static class RedPackage {
        int    remainSize;
        BigDecimal remainMoney;
    }
}
