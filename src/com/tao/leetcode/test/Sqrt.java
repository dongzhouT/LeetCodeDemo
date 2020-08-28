package com.tao.leetcode.test;

/**
 * 二分法开根号
 */

public class Sqrt {
    public static float getAns(float n) {
        float left = 0, right = n;
        float ans = 0;
        while (ans * ans != n && Math.abs(n - ans * ans) > 0.001f) {
            ans = (left + right) / 2;
            System.out.println("ans=" + ans);
            float tmp = ans * ans;
            if (tmp == n || Math.abs(n - tmp) < 0.001f) {
                return ans;
            } else if (tmp < n) {
                left = ans;
            } else {
                right = ans;
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        System.out.println(getAns(2));
    }

}
