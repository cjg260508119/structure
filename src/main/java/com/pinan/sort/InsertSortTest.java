package com.pinan.sort;

import java.security.SecureRandom;

/**
 * @Author 26050
 * 插入排序
 * @Date 2023/5/4 21:08
 * @Version 1.0
 */
public class InsertSortTest {

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

    public static void sort(int[] n){
        int tmp = 0;
        for(int i=1; i<n.length; i++){
            tmp = n[i];
            if(n[i] < n[i-1]){
                int j;
                for(j=i-1; j>=0; j--){
                    if(n[j] > tmp){
                        n[j+1] = n[j];
                    }else{
                        break;
                    }
                }
                n[j+1] = tmp;
            }
        }
    }
}
