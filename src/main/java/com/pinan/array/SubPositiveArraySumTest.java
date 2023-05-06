package com.pinan.array;

/**
 * @Author 26050
 * 输入一个正整数数组和k，找出大于k的位数最小的连续子序列，输出该子序列的位数
 * 因为是正整数，所以可以使用双指针p1、p2，都指向数组第一个位置，两个指针之间就是一个子序列，
 * 每次移动一次p2表示增加一个数，移动一次p1表述减少一个数
 * @Date 2023/5/5 21:28
 * @Version 1.0
 */
public class SubPositiveArraySumTest {

    public static void main(String[] args) {
        int[] n = new int[4];
        n[0] = 5;
        n[1] = 1;
        n[2] = 4;
        n[3] = 3;
        int idx = test0(n, 7);
        System.out.println(idx);
    }

    public static int test0(int[] n, int k){

        int left = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for(int right = 0; right<n.length; right++){
            sum += n[right];
            while(left<=right && sum >= k){
                min = Math.min(min, right - left + 1);
                sum -= n[left++];
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;

        //最小子序列位数
        /*int min = Integer.MAX_VALUE;
        int p0 = 0, p1 = 0;
        while(p1 < n.length){
            int sum = 0;
            int i = p0, j = p1;
            for(;i<=j; i++){
                sum += n[i];
            }
            if(sum >= k){
                int tempMin = p1 - p0 + 1;
                if(tempMin == 1){
                    return 1;
                }
                min = Math.min(tempMin, min);
                p0++;
            }else{
                p1++;
            }
        }
        return min;*/
    }
}
