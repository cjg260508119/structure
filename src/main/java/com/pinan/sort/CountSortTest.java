package com.pinan.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 26050
 * 计数排序，找出数组内的最大值和最小值，然后构造一个最大值-最小值长度的新数组，用来统计输入数组里面元素的个数（用元素值减去最小值）
 * 然后进行遍历排序
 * 适合数组中k = 最大值-最小值，远小于n的场景
 * @Date 2023/5/13 10:47
 * @Version 1.0
 */
public class CountSortTest {

    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>();
        l.add(10);
        l.add(9);
        l.add(8);
        l.add(19);
        l.add(3);
        l.add(7);
        l.add(8);
        Integer[] n = test0(l.toArray(new Integer[l.size()]));
        for(int i=0; i<n.length; i++){
            System.out.println(n[i]);
        }

    }

    public static Integer[] test0(Integer[] n){

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int i=0; i<n.length; i++){
            max = Math.max(max, n[i]);
            min = Math.min(min, n[i]);
        }

        int[] ne = new int[max - min + 1];
        for(int i=0; i<n.length; i++){
            ne[n[i] - min]++;
        }

        int k = 0;
        for(int i = 0; i<ne.length; i++){
            while(ne[i] > 0){
                n[k++] = i + min;
                ne[i]--;
            }
        }
        return n;
    }
}
