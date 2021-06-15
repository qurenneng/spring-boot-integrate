package com.example.springbootapiintegrat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@SpringBootTest
class SpringBootApiIntegratApplicationTests {

    @Test
    void contextLoads() {
    }


    public static void main(String[] args) {
		ArrayList<Integer> arrayList = averageDivideDOF(100, 2);
        List<String> collect = arrayList.stream().map(i -> String.valueOf(i)).collect(Collectors.toList());

//        ArrayList<Integer> arrayList = averageDivideDO(20,4);

        arrayList.stream().forEach(System.out::println);
        collect.stream().forEach(System.out::println);

//		Double totalMoney = 10.0;
//		Double count = 15.0;
//
//		double avg = totalMoney / count;
//		System.out.println(avg);

//		BigDecimal bigDecimal = new BigDecimal(10);
//		BigDecimal divide = bigDecimal.divide(new BigDecimal(8),BigDecimal.ROUND_DOWN);
//
//		BigDecimal[] bigDecimals = bigDecimal.divideAndRemainder(new BigDecimal(8));
//		System.out.println(bigDecimals[1]);
////
//		int mod = 10 / 8;
//
//		System.out.println(mod);

//		System.out.println(divide);

//		String name = "2";
//
//		if(!name.equals("1")){
//			System.out.println(1);
//		}else{
//			System.out.println(2);
//		}

    }


    /**
     * 普通红包计算:
     *
     * @param money
     * @param count
     * @return
     */
    public static ArrayList<BigDecimal> averageDivide(BigDecimal money, int count) {
        // 创建一个长度的红包数组
        ArrayList<BigDecimal> redList = new ArrayList<>();
        // 由于double的精度分体将其转换为int计算, 即将元转换为分计算，红包最小单位以分计算
        BigDecimal totalMoney = money;
        BigDecimal avg = totalMoney.divide(new BigDecimal(count), BigDecimal.ROUND_DOWN);
        BigDecimal[] mod = totalMoney.divideAndRemainder(new BigDecimal(count));
        for (int i = 0; i < count - 1; i++) {
            redList.add(avg);
        }
        redList.add(avg.add(mod[1]));
        return redList;
    }

    /**
     * @param money 金额
     * @param count 个数
     * @return
     */
    public static ArrayList<Integer> averageDivideDOF(int totalMoney, int totalCount) {
		ArrayList<Integer> redList = new ArrayList<>();
		Integer avgBag = null;
		Integer redBagMoney = null;
		Random random = new Random();
		Integer totalNum = totalCount-1;
		Integer result = null;
		//遍历
		for (int i = 0; i <totalCount-1; i++) {
			avgBag = totalMoney/totalNum;//当前平均数 但是会出现不能整除的情况
			result = totalMoney%totalNum;//当前可以整除

			redBagMoney = random.nextInt(avgBag*2);
			//如果不小心被随机到了0 就给他最小的红包
			if(redBagMoney==0){
				redBagMoney = 1;
			}
			totalNum--;
			totalMoney-=redBagMoney;
//			System.out.println("被分到的钱数:"+redBagMoney);
			redList.add(redBagMoney);
		}
		redList.add(totalMoney);//最后剩余的钱数给最后一个人

		return redList;
    }






    public static ArrayList<Integer> averageDivideDO(int money, int count) {
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


}
