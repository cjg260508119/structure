package com.pinan.div;

/**
 * @Author 26050
 * 计算正整数的二进制串中含有1的个数
 * @Date 2023/5/3 14:23
 * @Version 1.0
 */
public class BinStringOneCountTest {

    public static void main(String[] args) {
        test0(10);
        System.out.println(test1(10));
    }

    /**
     * 使用api来处理
     * @param m
     */
    public static void test0(int m){
        String test = Integer.toBinaryString(m);
        int cnt = 0;
        for(char c : test.toCharArray()){
            if(c == '1'){
                cnt ++;
            }
        }
        System.out.println(test);
        System.out.println(cnt);
    }

    /**
     * 方式1 使用j&j-1的方式确定
     */
    public static int test1(int m){
        if(m == 0){
            return 0;
        }
        int cnt = 0;
        while(m > 0){
            m = m & (m-1);
            cnt++;
        }
        return cnt;
    }
}
