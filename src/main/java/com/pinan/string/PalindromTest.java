package com.pinan.string;

/**
 * @Author 26050
 * 回文字符串相关的算法
 * 使用双指针处理
 * @Date 2023/5/6 17:52
 * @Version 1.0
 */
public class PalindromTest {

    public static void main(String[] args) {
        String str = "abc abcdcbacba";
        System.out.println(isPalindrom(str));
    }

    public static boolean isPalindrom(String str){

        int left = 0, right = str.length()-1;
        while(left < right){
            char a = str.charAt(left);
            char b = str.charAt(right);
            if(!Character.isLetterOrDigit(a)){
                left++;
            }else if(!Character.isLetterOrDigit(b)){
                right--;
            }else{
                if(a != b){
                    return false;
                }
                left++;
                right--;
            }


        }

        return true;
    }
}
