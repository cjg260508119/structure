package com.pinan.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author 26050
 * 输入一个整数数组和正整数k，请求出数组中有多少个数字之和等于k的连续子数组。
 * 输入的是正整数，使用双指针无法实现。
 * 思想：数组前i个数和为x，如果前j个值为x-k(j<i), 则i+1->j之间的数的和为k。
 * 因为是连续的子数组，可以遍历数组的时候，使用一个map缓存key为每次遍历后前i个数的和，value为这个和的次数，
 *
 * @Date 2023/5/6 9:29
 * @Version 1.0
 */
public class SubArraySumTest {

    public static void main(String[] args) {
        int[] n = new int[7];
        n[0] = 1;
        n[1] = 2;
        n[2] = 1;
        n[3] = 2;
        n[4] = -1;
        n[5] = 1;
        n[6] = -4;
        int idx = test0(n, 3);
        System.out.println(idx);
    }

    public static int test0(int[] n, int k){
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int count = 0;
        int sum = 0;
        for(int i=0; i<n.length; i++){
            sum += n[i];
            count += map.getOrDefault(sum - k, 0);
            map.put(sum, map.getOrDefault(sum,0) +1);
        }
        return count;
    }
}
