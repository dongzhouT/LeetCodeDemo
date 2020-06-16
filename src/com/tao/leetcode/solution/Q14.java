package com.tao.leetcode.solution;

/**
 * 14. 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 */
public class Q14 {
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0 || "".equals(strs[0])) {
            return "";
        }
        int index = 0, minLen = strs[0].length();
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() < minLen) {
                minLen = strs[i].length();
                index = i;
            }
        }
        String s1 = strs[index];
        boolean find;
        for (int i = 0; i <= s1.length(); i++) {
            find = true;
            for (String s : strs) {
                if (!s.startsWith(s1.substring(0, i))) {
                    find = false;
                    break;
                }
            }
            if (!find) {
                return s1.substring(0, i - 1);
            }
        }
        return s1;

    }

    public static void main(String[] args) {
        String[] data = new String[]{"a", "ab"};
        System.out.println(longestCommonPrefix(data));
    }

}
