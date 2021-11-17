package com.exam.utils;

import java.util.Random;

/**
 * 生成 n 位随机 salt 的工具类
 */
public class SaltUtils {
    //随机生成 n位 salt
    public static String getSalt(int n){
        char[] chars = "ABCDEFGHIGKLMNOPQRSTUVWXYZabcdefghigklmnopqrstuvwxyz0123456789!@#$%^&*()".toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0;i <n;i++){
            char aChar = chars[new Random().nextInt(chars.length)];
            sb.append(aChar);
        }
        return sb.toString();
    }
//    测试工具类
//    public static void main(String[] args) {
//        System.out.println(getSalt(8));
//        System.out.println(getSalt(8));
//        System.out.println(getSalt(8));
//        System.out.println(getSalt(8));
//        System.out.println(getSalt(8));
//    }
}
