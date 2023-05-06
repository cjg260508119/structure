package com.pinan.array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author 26050
 * 输入一个数组，和值k，找出所有的包含3个元素的子序列，子序列元素的和为k；子序列不重复；
 * 1、排序数组（主要为了使用双指针找出两个数的和等于k-另一个数）
 * 2、遍历数组，对于每个n[i],在遍历中找出剩余数的两个数和等于k-n[i]
 * 3、遍历过程中跳过相同的值
 * @Date 2023/5/5 19:49
 * @Version 1.0
 */
public class ThreeSumAllSubArrayInArrayTest {

    public static void main(String[] args) {
        int[] n = new int[6];
        n[0] = -1;
        n[1] = 0;
        n[2] = 1;
        n[3] = 2;
        n[4] = -1;
        n[5] = -4;
        List<List<Integer>> idx = test0(n, 0);
        if(idx != null) {
            for(List l : idx){
                System.out.println(l);
            }
        }
    }

    public static List<List<Integer>> test0(int[] n, int k){

        List<List<Integer>> result = new LinkedList<>();
        //排序数组
        Arrays.sort(n);
        for(int i=0; i<n.length-2; i++){
            //找出两数和等于k—n[i]的数
            int low = i+1, high = n.length-1;
            while(low < high){
                if((n[i] + n[low] +n[high]) == k){
                    result.add(Arrays.asList(n[i], n[low], n[high]));
                    //跳过相同的数（避免有重复的子序列）
                    int temp = n[low];
                    while(low < high && temp == n[low]){
                        low++;
                    }
                }else if((n[i] + n[low] + n[high]) > k){
                    high--;
                }else{
                    low++;
                }
            }

            int temp = n[i];
            while(i<n.length && temp == n[i+1]){
                i++;
            }
        }

        return result;
    }
}
