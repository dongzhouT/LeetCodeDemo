package com.tao.leetcode.solution;

/**
 * 28. 实现 strStr()
 * 实现 strStr() 函数。
 * <p>
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-strstr
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q28 {
    public int strStr(String haystack, String needle) {
        int len = needle.length();
        if (haystack.length() < needle.length()) {
            return -1;
        }
        if (haystack.equals(needle)) {
            return 0;
        }
        for (int i = 0; i <= haystack.length() - len; i++) {
            if (haystack.substring(i, i + len).equals(needle)) {
                return i;
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        String s = "mississippi";
        System.out.println(new Q28().strStr(s, "pi"));
    }
}
