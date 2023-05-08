package com.pinan.stack;

import java.util.*;

/**
 * @Author 26050
 * 后缀表达式计算
 * @Date 2023/5/8 10:01
 * @Version 1.0
 */
public class PostfixExpStackTest {

    public static void main(String[] args) {
        List<String> exp = new ArrayList<>(Arrays.asList("2","8","3","*","+"));
        int ret = cal(exp.toArray(new String[exp.size()]));
        System.out.println(ret);
    }

    public static int cal(String[] exp){

        int ret = 0;
        Deque<Integer> que = new ArrayDeque<>();
        for(String s : exp){
            switch (s){
                case "+":
                case "-":
                case "*":
                case "/":
                    int num1 = que.pop();
                    int num2 = que.pop();
                    que.push(cal0(num1, num2, s));
                    break;
                default:
                    que.push(Integer.parseInt(s));
            }
        }
        return que.pop();
    }

    public static int cal0(int num1, int num2, String s){
        switch (s){
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                return num1 / num2;
            default:
                return 0;
        }
    }
}
