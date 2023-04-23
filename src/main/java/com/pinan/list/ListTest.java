package com.pinan.list;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName:ListTest
 * @Auther: 26050
 * @Description:
 * @Date: 2023/4/21 19:36
 * @Version: v1.0
 */
public class ListTest {

    public static void main(String[] args){
        /*List<String> list = new ArrayList<>();
        list.add("String1");
        list.add("String2");
        list.add("String3");
        Object[] arrs = list.toArray();*/
        Object[] arrs = new Object[10];
        for(int i=0; i<5; i++){
            arrs[i] = "" + i;
        }
        System.arraycopy(arrs, 0, arrs, 1, 5);
        for(int i=0; i<10; i++){
            System.out.println(arrs[i]);
        }
    }
}
