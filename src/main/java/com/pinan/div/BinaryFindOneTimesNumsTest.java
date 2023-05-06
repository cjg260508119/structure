package com.pinan.div;

/**
 * @Author 26050
 * 从一个数组中找到一个只出现一次的整数，其他的整数都出现3次
 * @Date 2023/5/3 17:32
 * @Version 1.0
 */
public class BinaryFindOneTimesNumsTest {

    public static void main(String[] args) {
        int[] i = new int[4];
        for(int l = 0; l < 3; l ++){
            i[l] = 1;
        }
        i[3] = 4;
        System.out.println(test(i));
    }

    public static int test(int[] m){
        //求和
        int[] bitNums = new int[32];
        for(int n : m){
            for(int i = 0; i<32; i++){
                //移位 &1是找出每一位的二进制位
                bitNums[i] += (n >> (31-i)) & 1;
            }
        }

        //取模
        int result = 0;
        for(int i=0; i<32; i++){
            //移位是空出个位进行追加
            result = (result << 1) + (bitNums[i] % 3);
        }
        return result;
    }
}
