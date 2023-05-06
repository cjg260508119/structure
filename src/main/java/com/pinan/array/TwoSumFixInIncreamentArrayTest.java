package com.pinan.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author 26050
 * 输入一个有序数组a和一个整数k，找出数组中两个数的和等于整数k的数，返回两个数的下标
 * 假设只存在一对整数值等于k
 * [1,2,3,6,9] 8 ->1,3
 * @Date 2023/5/5 18:01
 * @Version 1.0
 */
public class TwoSumFixInIncreamentArrayTest {

    public static void main(String[] args) {
        int[] n = new int[5];
        n[0] = 1;
        n[1] = 2;
        n[2] = 3;
        n[3] = 6;
        n[4] = 9;
        int [] idx = test1(n, 8);
        if(idx != null) {
            System.out.println(idx[0] + " - " + idx[1]);
        }
    }

    /**
     * 使用空间换时间的方式
     * @param n
     * @param k
     * @return
     */
    public static int[] test0(int[] n, int k){

        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n.length; i++){
            map.put(n[i], i);
        }
        int[] index = new int[2];
        for(int i=0; i<n.length; i++){
            if(map.containsKey(k - n[i])){
                index[0] = i;
                index[1] = map.get(k-n[i]);
                return index;
            }
        }
        return null;
    }

    /**
     * 使用双指针
     * 思想：因为数组是递增的，可以使用双指针的方式，一个指向数组头部，另一个指向数组尾部，判断两个指针指向的数的和
     * 如果大于给定的值，移动右边指针；如果小于给定的值，移动左右的指针
     * @param n
     * @param k
     * @return
     */
    public static int[] test1(int[] n, int k){

        int left = 0, right = n.length-1;
        int[] idx = new int[2];
        while(left < right) {
            int v = n[left] + n[right];
            if(v == k){
                idx[0] = left;
                idx[1] = right;
                return idx;
            }else if(v > k){
                right--;
            }else{
                left++;
            }
        }
        return null;
    }
}
