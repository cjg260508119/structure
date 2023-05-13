package com.pinan.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author 26050
 * 计数统计排序算法扩展1：
 * 输入两个数组，第一个数组用于排序，第二个数组是参照，根据第二个数组的元素值，从第一个数组中找到对应的值
 * 按照第二个数组的下标进行排序，剩余没有在第二个数组的元素往后面顺序排序
 * 假设值只有0-1000；
 * 比如[2,3,3,7,3,9,2,1,7,2],[3,2,1]
 * 排序后[3,3,3,2,2,1,7,7,9]
 * @Date 2023/5/13 11:16
 * @Version 1.0
 */
public class CountSortExtTest {

    public static void main(String[] args) {
        List<Integer> l1 = new ArrayList<>(Arrays.asList(2,3,3,7,9,2,1,7,2));
        List<Integer> l2 = new ArrayList<>(Arrays.asList(3,2,1));
        Integer[] n = test0(l1.toArray(new Integer[l1.size()]), l2.toArray(new Integer[l2.size()]));
        for(int n1 : n){
            System.out.println(n1);
        }
    }

    public static Integer[] test0(Integer[] n1, Integer[] n2){
        int[] count = new int[1001];
        for(int num : n1){
            count[num]++;
        }

        int i = 0;
        for(int num : n2){
            while(count[num] > 0){
                n1[i++] = num;
                count[num]--;
            }
        }

        for(int k=0; k<count.length; k++){
            while(count[k] > 0){
                n1[i++] = k;
                count[k]--;
            }
        }
        return n1;
    }
}
