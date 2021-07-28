package com.example.springbootapiintegrat;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author qrn
 * @Title
 * @Date 2021/6/16 19:38
 * @time 19:38
 */
public class Dome {

    public static void main(String[] args) {
        int[] nums = new int[4];
        nums[0] = 2;
        nums[1] = 7;
        nums[2] = 11;
        nums[3] = 15;
        int target = 9;
        int[] ints = twoSums(nums, target);
        for(int i=0;i<ints.length;i++){
            System.out.print(ints[i]);
        }
    }

    public static int[] twoSums(int[] nums, int target) {
        int[] sum = new int[2];
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j] == target){
                    sum[0]=i;
                    sum[1]=j;
                    return  sum;
                }
            }
        }
        return  sum;
    }


    public static int[] twoSum(int[] nums, int target) {
        int[] sum = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            //如果目标值减去数组中得到的值存在map中那么代表，相加等于 target
            if (map.containsKey(target - nums[i])) {
                sum[0] = map.get(target - nums[i]);
                sum[1] = i;
            }else{
                map.put(nums[i],i);
            }

        }
        return  sum;
    }
}
