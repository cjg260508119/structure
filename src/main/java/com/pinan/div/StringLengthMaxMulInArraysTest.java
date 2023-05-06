package com.pinan.div;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @Author 26050
 * 输入一个字符串数组，找出数组中不包含相同字符的两个字符串的长度乘积最大值
 * @Date 2023/5/3 18:27
 * @Version 1.0
 */
public class StringLengthMaxMulInArraysTest {

    public static void main(String[] args) {
        String[] s = new String[4];
        s[0] = "abc";
        s[1] = "abcd";
        s[2] = "test";
        s[3] = "testpo";
        System.out.println(test1(s));
    }

    public static int test0(String[] str){

        Map<String, List<Boolean>> map = new HashMap<>();
        //这里需要改成二维数组处理
        for(String s : str){
            List<Boolean> list = new ArrayList<>(26);
            for(char c : s.toCharArray()){
                System.out.println(c - 'a');
                list.add(c - 'a', true);
            }
            map.put(s, list);
        }

        int max = 0;
        for(int i = 0; i<str.length; i++){
            for(int j = i+1; j>str.length; j++){
                List<Boolean> li = map.get(str[i]);
                List<Boolean> lj = map.get(str[j]);
                for(int k=0; k<26; k++){
                    if(li.get(k) && lj.get(k)){
                        break;
                    }
                }
                //如果没有退出，说明不一样，进行计算
                int mul = str[i].length() * str[j].length();
                if(mul > max) {
                    max = mul;
                }
            }
        }

        return max;
    }

    public static int test1(String[] str){

        int[] bitExist = new int[str.length];
        for(int k=0; k<str.length; k++){
            int i = 0;
            for(char c : str[k].toCharArray()){
                i |= i<<(c - 'a');
            }
            bitExist[k] = i;
        }

        int max = 0;
        for(int i=0; i<str.length; i++){
            for(int j = i+1; j<str.length; j++){
                if ((bitExist[i] & bitExist[j]) == 0) {
                    int len = str[i].length() * str[j].length();
                    if(len > max){
                        max = len;
                    }
                }
            }
        }

        return max;
    }
}
