package com.pinan.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @Author 26050
 * 快速排序
 * 思想：输入一个数组，任意选择一个中间值（尽量），然后把数组中大于中间值的元素移动到中间值后面，把小于
 * 中间值的元素移动到中间值前面，然后在递归去排序中间值前面和后面的部分。
 * 使用双指针去进行迁移
 * @Date 2023/5/13 11:31
 * @Version 1.0
 */
public class QuickSortTest {

    public static void main(String[] args) {
        List<Integer> l1 = new ArrayList<>(Arrays.asList(2,3,3,7,9,2,1,7,2));
        Integer[] n = test0(l1.toArray(new Integer[l1.size()]), 0, l1.size() - 1);
        for(int n1 : n){
            System.out.println(n1);
        }
    }

    public static Integer[] test0(Integer[] n, int start, int end){
        quickSort(n, start, end);
        return n;
    }

    public static void quickSort(Integer[] n, int start, int end){
        if(end > start){
            int pivot = partition(n, start, end);
            quickSort(n, start, pivot - 1);
            quickSort(n, pivot + 1, end);
        }
    }

    /**
     * 使用双指针处理
     * @param n
     * @return
     */
    public static int partition(Integer[] n, int start, int end){
        int ramdon = new Random().nextInt(end-start + 1) + start;
        swap(n, ramdon, end);
        int left = start - 1;
        for(int i = start; i<end; i++){
            if(n[i] < n[end]){
                left++;
                swap(n, left, i);
            }
        }
        left++;
        swap(n, end, left);
        return left;
    }

    public static void swap(Integer[] n, int idx1, int idx2){
        if(idx1 != idx2){
            int temp = n[idx1];
            n[idx1] = n[idx2];
            n[idx2] = temp;
        }
    }
}
