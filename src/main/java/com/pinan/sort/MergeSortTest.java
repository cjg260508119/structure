package com.pinan.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author 26050
 * 归并排序
 * @Date 2023/5/13 13:18
 * @Version 1.0
 */
public class MergeSortTest {

    public static void main(String[] args) {
        List<Integer> l1 = new ArrayList<>(Arrays.asList(2,3,3,7,9,2,1,7,2));
        Integer[] n = iteSort(l1.toArray(new Integer[l1.size()]));
        for(int n1 : n){
            System.out.println(n1);
        }
    }

    public static Integer[] iteSort(Integer[] n){
        int length = n.length;
        Integer[] src = n;
        Integer[] dest = new Integer[length];
        for(int seg=1; seg<length; seg+=seg){
            for(int start = 0; start < length; start += seg * 2){
                int mid = Math.min(start + seg, length);
                int end = Math.min(start + seg*2, length);
                int i=start, j=mid, k=start;
                while(i<mid || j<end){
                    if(j==end || (i<mid && src[i]<src[j])){
                        dest[k++] = src[i++];
                    }else{
                        dest[k++] = src[j++];
                    }
                }
            }
            Integer temp[] = src;
            src = dest;
            dest = temp;
        }
        return src;
    }
}
