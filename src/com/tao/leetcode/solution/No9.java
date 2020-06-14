package com.tao.leetcode.solution;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 */
public class No9 {
    public static boolean isPalindrome(int x) {
        int y=x;
        if (x < 0) {
            return false;
        }
        int data = 0;
        while (x != 0) {
            data = data * 10 + x % 10;
            x = x / 10;
        }
        return data == y;

    }

    public static void main(String[] args) {
        int data = 121;
        System.out.println(isPalindrome(data));
    }
}
