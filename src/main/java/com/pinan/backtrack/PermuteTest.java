package com.pinan.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author 26050
 * 使用回溯法解决排列问题
 * @Date 2023/5/16 19:02
 * @Version 1.0
 */
public class PermuteTest {

    public static void main(String[] args) {
        permute();
    }

    public static void permute(){
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        Integer[] nums = list.toArray(new Integer[list.size()]);
        int[] n = new int[nums.length];
        for(int i = 0; i< nums.length; i++){
            n[i] = nums[i];
        }
        List<List<Integer>> ret = new LinkedList<>();
        helper(n, 0, ret);
        System.out.println(ret);
    }

    public static void helper(int nums[], int i, List<List<Integer>> ret){
        if(i == nums.length){
            List<Integer> l = new LinkedList<>();
            for(int n : nums){
                l.add(n);
            }
            ret.add(l);
        }else{
            for(int j=i; j< nums.length; j++){
                swap(nums, i, j);
                helper(nums, i+1, ret);
                swap(nums, i, j);
            }
        }
    }

    public static void swap(int[] nums, int i, int j){
        if(i != j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
