package com.tao.leetcode.solution;

import java.util.*;

/**
 * 17. 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * DFS
 */
public class Q17_pro {
    static Map<String, String> phone = new HashMap<String, String>() {
        {
            put("2", "abc");
            put("3", "def");
            put("4", "ghi");
            put("5", "jkl");
            put("6", "mno");
            put("7", "pqrs");
            put("8", "tuv");
            put("9", "wxyz");
        }
    };

    public void backTrack(String combination, String nextDigits) {
        if (nextDigits.length() == 0) {
            output.add(combination);
        } else {
            String digit = nextDigits.substring(0, 1);
            String letters = phone.get(digit);
            for (int i = 0; i < letters.length(); i++) {
                String letter = letters.charAt(i) + "";
                backTrack(combination + letter, nextDigits.substring(1));
            }
        }

    }

    List<String> output = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits != null && digits.length() != 0) {
            backTrack("", digits);
        }
        return output;
    }

    public static void main(String[] args) {
        Q17_pro q = new Q17_pro();
        System.out.println(q.letterCombinations("2"));
    }
}
