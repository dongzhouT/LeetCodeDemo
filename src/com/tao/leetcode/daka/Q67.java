package com.tao.leetcode.daka;

/**
 * 67. 二进制求和
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 * <p>
 * 输入为 非空 字符串且只包含数字 1 和 0。
 * 输入: a = "11", b = "1"
 * 输出: "100"
 */
public class Q67 {
    public String addBinary(String a, String b) {
        int m = a.length();
        int n = b.length();
        int len = Math.max(m, n);
        if (m > n) {
            StringBuilder bBuilder = new StringBuilder(b);
            for (int i = 0; i < m - n; i++) {
                bBuilder.insert(0, "0");
            }
            b = bBuilder.toString();
        } else if (m < n) {
            StringBuilder sb = new StringBuilder(a);
            for (int i = 0; i < n - m; i++) {
                sb.insert(0, "0");
            }
            a = sb.toString();
        }
        boolean flag = false;
        StringBuilder sb = new StringBuilder();
        for (int i = len - 1; i >= 0; i--) {
            if (a.charAt(i) == b.charAt(i)) {
                if (flag) {
                    sb.insert(0, "1");
                    flag = a.charAt(i) == '1';
                } else {
                    sb.insert(0, "0");
                    flag = a.charAt(i) == '1';
                }
            } else {
                //一个0，一个1
                if (flag) {
                    sb.insert(0, "0");
                    flag = true;
                } else {
                    sb.insert(0, "1");
                    flag = false;
                }

            }
        }
        if (flag) {
            sb.insert(0, "1");
        }
        return sb.toString();

    }

    public String addBinaryPro(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int ca = 0;
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int sum = ca;
            sum += (i >= 0 ? a.charAt(i) - '0' : 0);
            sum += (j >= 0 ? b.charAt(j) - '0' : 0);
            sb.append(sum % 2);
            ca = sum / 2;
        }
        sb.append(ca > 0 ? "1" : "");
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String a = "1";
        String b = "111";
        System.out.println(new Q67().addBinaryPro(a, b));
    }

}
