package com.tao.leetcode.daka;

/**
 * 125. 验证回文串
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 */
public class Q125 {
    public boolean isPalindrome(String s) {
        if (s == null || s.equals("")) {
            return true;
        }
        int start = 0, end = s.length() - 1;
        while (start < end) {
            while (start < s.length() && !Character.isLetterOrDigit(s.charAt(start))) {
                start++;
            }
            while (end >= 0 && !Character.isLetterOrDigit(s.charAt(end))) {
                end--;
            }
            if (start >= s.length() || end < start) {
                return true;
            }
            if (!(s.charAt(start) + "").equalsIgnoreCase(s.charAt(end) + "")) {
                return false;
            }
            start++;
            end--;

        }
        return true;

    }

    public boolean isPalindromePro(String s) {
        if (s == null || s.equals("")) {
            return true;
        }
        int start = 0, end = s.length() - 1;
        boolean result = true;
        while (start < end) {
            if (!Character.isLetterOrDigit(s.charAt(start))) {
                start++;
            } else if (!Character.isLetterOrDigit(s.charAt(end))) {
                end--;
            } else if (!(s.charAt(start) + "").equalsIgnoreCase(s.charAt(end) + "")) {
                return false;
            } else {
                start++;
                end--;
            }

        }
        return result;

    }

    public static void main(String[] args) {
        String s = "\"Sue,\" Tom smiles, \"Selim smote us.\"";
        s = ".,";
        Q125 qq = new Q125();
        System.out.println(qq.isPalindrome(s));
    }
}
