package com.pinan.sort;

import java.security.SecureRandom;

/**
 * @Author 26050
 * 冒泡排序
 * @Date 2023/5/4 20:04
 * @Version 1.0
 */
public class BubbleSortTest{

    public static void main(String[] args) {
        SecureRandom r = new SecureRandom();
        int[] n = new int[10];
        for(int i = 0; i<10; i++){
            n[i] = r.nextInt();
            System.out.print(n[i] + " * ");
        }
        System.out.println("\n---------\n");

        sort(n);
        for(int i = 0; i<10; i++){
            System.out.print(n[i] + " * ");
        }

    }

    public static void sort(int[] t) {
        int len = t.length;
        int swap = 0;
        for(int i=0; i<len; i++){
            for(int j=len-1; j>i; j--){
                if(t[j] < t[j-1]){
                    swap = t[j];
                    t[j] = t[j-1];
                    t[j-1] = swap;
                }
            }
        }
    }
}
