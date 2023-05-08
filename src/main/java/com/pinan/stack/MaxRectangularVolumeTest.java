package com.pinan.stack;

import java.util.*;

/**
 * @Author 26050
 * 输入一个数组，数组中的每个元素代表直方图的柱子值，求直方图中的最大面积。
 * [3,2,5,4,6,1,4,2]
 * @Date 2023/5/8 13:26
 * @Version 1.0
 */
public class MaxRectangularVolumeTest {

    public static void main(String[] args) {
        /*Deque<Integer> que = new ArrayDeque<>();
        System.out.println(que.peek());*/
        List<Integer> l = new ArrayList<>(Arrays.asList(3,2,5,4,6,1,4,2));
        System.out.println(test0(l.toArray(new Integer[l.size()])));
    }

    public static int test0(Integer[] n){
        Deque<Integer> que = new ArrayDeque<>();
        int max = 0;
        for(int i=0; i<n.length; i++){
            while(!que.isEmpty() && n[que.peek()] > n[i]) {
                Integer pee = que.peek();
                que.pop();
                int left = que.peek() == null ? -1 : que.peek();
                int right = i;
                int wide = right - left - 1;
                max = Math.max(max, wide * n[pee]);
            }
            que.push(i);
        }
        while(!que.isEmpty()){
            Integer pee = que.pop();
            int left = que.peek() == null ? -1 :que.peek();
            int right = n.length;
            int wide = right - left - 1;
            max = Math.max(max, wide * n[pee]);
        }
        return max;
    }
}
