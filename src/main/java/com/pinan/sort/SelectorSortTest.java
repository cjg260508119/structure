package com.pinan.sort;

import java.security.SecureRandom;

/**
 * @Author 26050
 * 选择排序
 * @Date 2023/5/4 20:33
 * @Version 1.0
 */
public class SelectorSortTest {

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

    public static void sort(int[] n) {
        int swap = 0;
        for(int i=0; i<n.length; i++){
            int minIndex = i;
            for(int j=i+1; j<n.length; j++){
                if(n[minIndex] > n[j]){
                    /*swap = n[i];
                    n[i] = n[j];
                    n[j] = swap;*/
                    minIndex = j;
                }
            }
            if(minIndex != i){
                swap = n[i];
                n[i] = n[minIndex];
                n[minIndex] = swap;
            }
        }
    }
}
