package com.pinan.div;

/**
 * @Author 26050
 * 求两个数的商，不使用除法和乘法运算符，进行计算
 * 使用减法，但是需要优化一下，先减去n的2的k次方，然后在进行循环此种方式，提高效率
 * @Date 2023/5/3 10:14
 * @Version 1.0
 */
public class DivTest {

    public static void main(String[] args){
        System.out.println(div(100, 80));
    }

    public static int div(int m, int n){
        int count = 0;
        while(m >= n) {
            int i = 1;
            while (m >= (n << i)) {
                i++;
            }
            i = i - 1;
            count = count + (1 << i);
            m = m - (n << i);
        }
        return count;
    }
}
