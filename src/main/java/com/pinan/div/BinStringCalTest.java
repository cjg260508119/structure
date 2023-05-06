package com.pinan.div;

/**
 * @Author 26050
 * 输入两个二进制字符串，计算两个二进制字符串的和，并以二进制字符串输出。
 * @Date 2023/5/3 11:08
 * @Version 1.0
 */
public class BinStringCalTest {

    public static void main(String[] args) {
        //System.out.println(Integer.toBinaryString(10000));
        /*System.out.println(Integer.parseInt("1010", 2));
        System.out.println(test("11", "10"));
        System.out.println(test2("11", "10"));*/
        System.out.println(Integer.toBinaryString(1234));
    }

    public static String test(String bin1, String bin2){
        int a = Integer.parseInt(bin1,2);
        int b = Integer.parseInt(bin2,2);
        int sum = a + b;
        return Integer.toBinaryString(sum);
    }

    /**
     * 通过解析String的位来进行逐位相加
     * @param bin1
     * @param bin2
     * @return
     */
    public static String test2(String bin1, String bin2){
        StringBuffer sb = new StringBuffer();
        int i = bin1.length() -1;
        int j = bin2.length() -1;
        int carry = 0;
        int sum = 0;
        while(i >= 0 || j >=0){
            /*int a = i>=0 ? bin1.charAt(i--) - '0' : 0;
            int b = j>=0 ? bin2.charAt(j--) - '0' : 0;*/
            int a = i>=0 ? bin1.charAt(i--) - '0' : 0;
            int b = j>=0 ? bin2.charAt(j--) - '0' : 0;
            sum = (a + b + carry) % 2;
            carry = (a + b + carry) / 2;
            sb.append(sum);
        }
        if(carry == 1){
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}
