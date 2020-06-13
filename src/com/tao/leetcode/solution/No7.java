package com.tao.leetcode.solution;

public class No7 {
    /**
     * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
     *
     * @param str
     * @return
     */
    public static int myAtoi(String str) {
        int flag = 1;
        int result = 0;
        int digit = 0;
        int index = 0;
        while (index < str.length()) {
            if (str.charAt(index) == ' ') {
                index++;
            } else {
                break;
            }
        }
        if (index == str.length()) {
            return 0;
        }
        if (str.charAt(index) == '-') {
            flag = -1;
            index++;
        } else if (str.charAt(index) == '+') {
            index++;
        }
        for (int i = index; i < str.length(); i++) {
            digit = str.charAt(i) - '0';
            if (digit < 0 || digit > 9) {
                break;
            } else {
                System.out.println(result+","+digit);
                if (result > (Integer.MAX_VALUE- digit) / 10 ) {
                    return flag > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                result = result * 10 + digit;
            }
        }

        return result * flag;
    }

    public static void main(String[] args) {
        System.out.println("max"+Integer.MAX_VALUE);
        System.out.println("result=" + myAtoi("2147483648"));
    }
}
