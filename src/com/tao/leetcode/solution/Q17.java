package com.tao.leetcode.solution;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 17. 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
public class Q17 {
    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        String[][] newArr = new String[digits.length()][4];
        int row = 0;
        for (int i = 0; i < digits.length(); i++) {
            if (digits.charAt(i) >= '2' && digits.charAt(i) <= '9') {
                newArr[row] = getString(digits.charAt(i) - '0');
                row++;
            }
        }
        String[] strings = newArr[0];
        for (int i = 1; i < newArr.length; i++) {
            strings = getTwo(strings, newArr[i]);
        }
        Collections.addAll(result, strings);

//        System.out.println(new Gson().toJson(newArr));
//        System.out.println(new Gson().toJson(result));
//        System.out.println(result.size());
        return result;
    }

    public static String[] getTwo(String[] a, String[] b) {
        ArrayList<String> result = new ArrayList<>();
        StringBuilder sb;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                sb = new StringBuilder();
                sb.append(a[i]).append(b[j]);
                result.add(sb.toString());
            }

        }
        String[] strings = new String[]{};
        return result.toArray(strings);

    }

    public static String[] getString(int num) {
        switch (num) {
            case 2:
                return new String[]{"a", "b", "c"};
            case 3:
                return new String[]{"d", "e", "f"};
            case 4:
                return new String[]{"g", "h", "i"};
            case 5:
                return new String[]{"j", "k", "l"};
            case 6:
                return new String[]{"m", "n", "o"};
            case 7:
                return new String[]{"p", "q", "r", "s"};
            case 8:
                return new String[]{"t", "u", "v"};
            case 9:
                return new String[]{"w", "x", "y", "z"};
        }
        return new String[]{};

    }

    public static void main(String[] args) {
        String data = "2";
        System.out.println(letterCombinations(data));
    }
}
