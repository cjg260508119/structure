package com.pinan.backtrack;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author 26050
 * @Date 2023/5/15 22:34
 * @Version 1.0
 */
public class BacktrackTest {

    public static void main(String[] args) {
        int[] n = new int[3];
        n[0] = 2;
        n[1] = 2;
        n[2] = 2;
        List<List<Integer>> list = subSet1(n, 4);
        for(List<Integer> l : list){
            System.out.println(l);
        }
    }

    /**
     * 回溯法求子集
     * @param n
     * @return
     */
    public static List<List<Integer>> subSet0(int[] n){
        List<List<Integer>> ret = new LinkedList<>();
        helperSubSet0(n, 0, new LinkedList<Integer>(), ret);
        return ret;
    }

    public static void helperSubSet0(int[] n, int idx, LinkedList<Integer> subSet, List<List<Integer>> ret){
        if(idx == n.length){
            ret.add(new LinkedList<>(subSet));
        }else if(idx < n.length){
            //选择不放元素
            helperSubSet0(n, idx + 1, subSet, ret);

            //放元素
            subSet.add(n[idx]);
            helperSubSet0(n, idx + 1, subSet, ret);
            subSet.removeLast();
        }
    }

    /**
     * 输入某个数组和一个值k，找出等于k的集合，不能有重复集合。
     * @param n
     * @return
     */
    public static List<List<Integer>> subSet1(int[] n, int k){
        List<List<Integer>> ret = new LinkedList<>();
        helperSubSet1(n, k,0, new LinkedList<Integer>(), ret);
        return ret;
    }

    public static void helperSubSet1(int[] n, int target, int idx, LinkedList<Integer> subSet, List<List<Integer>> ret){
        if(target == 0){
             ret.add(new LinkedList<>(subSet));
        }else if(target > 0 && idx < n.length){
            helperSubSet1(n, target, getNext(n, idx), subSet, ret);
            subSet.add(n[idx]);
            helperSubSet1(n, target-n[idx], idx+1, subSet, ret);
            subSet.removeLast();
        }
    }

    /**
     * 如果跳过一个数值，后面等于这个数值的数都进行跳过，这样就不会选择到相同的集合
     * @param n
     * @param idx
     * @return
     */
    public static int getNext(int[] n, int idx){
        int next = idx;
        while(next < n.length && n[idx] == n[next]){
            next++;
        }
        return next;
    }
}
