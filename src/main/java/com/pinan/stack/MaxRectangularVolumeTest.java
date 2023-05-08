package com.pinan.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author 26050
 * 输入一个数组，数组中的每个元素代表直方图的柱子值，求直方图中的最大面积。
 * [3,2,5,4,6,1,4,2]
 * @Date 2023/5/8 13:26
 * @Version 1.0
 */
public class MaxRectangularVolumeTest {

    public static void main(String[] args) {
        Deque<Integer> que = new ArrayDeque<>();
        System.out.println(que.peek());
    }

    public static int test0(int[] n){
        Deque<Integer> que = new ArrayDeque<>();
        int max = 0;
        for(int i=0; i<n.length; i++){
            Integer pee = que.peek();
            if(pee != null && n[pee.intValue()] > n[i]){
                que.pop();
                int left = que.peek() == null ? -1 : que.peek();
                int right = i;
                int wide = i - left - 1;
                max = Math.max(max, wide * pee);
            }
            que.push(i);
        }
        while(!que.isEmpty()){
            Integer pee = que.pop();
            int left = que.peek() == null ? -1 :que.peek();
            int right = n.length;
            int wide = right - left - 1;
            max = Math.max(max, wide * pee);
        }
        return 0;
    }
}
