package com.tao.leetcode.solution;

import java.util.HashMap;

/**
 * 13. 罗马数字转整数
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 * <p>
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。
 * 27 写做  XXVII, 即为 XX + V + II 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/roman-to-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 输入: "MCMXCIV"
 * 输出: 1994
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 */
public class Q13 {
    public static int romanToInt(String s) {
        HashMap<Character, Integer> ma = new HashMap<>();
        ma.put('I', 1);
        ma.put('V', 5);
        ma.put('X', 10);
        ma.put('L', 50);
        ma.put('C', 100);
        ma.put('D', 500);
        ma.put('M', 1000);
        int result = 0;
        int preNum = ma.get(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            int num = ma.get(s.charAt(i));
            if (preNum < num) {
                result -= preNum;
            } else {
                result += preNum;
            }
            preNum = num;
        }
        result += preNum;

        return result;
    }

    public static void main(String[] args) {
        String s = "M";
        System.out.println(romanToInt(s));
    }


}
