package com.tao.leetcode.solution;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 输入: "()[]{}"
 * 输出: true
 */
public class Q20 {
    Map<Character, Character> mappings = new HashMap<Character, Character>() {
        {
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }
    };

    public boolean isValidPro(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            if (!mappings.containsKey(a)) {
                stack.push(a);
            } else {
                char topElement = stack.empty() ? '#' : stack.pop();
                if (topElement != mappings.get(a)) {
                    return false;
                }
            }
            //do somethine
        }
        return stack.empty();
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            if (a == '(' || a == '[' || a == '{') {
                stack.push(a);
            } else {
                if (stack.empty()) {
                    return false;
                }
                if (!valid(stack.pop(), a)) {
                    return false;
                }
            }
            //do somethine
        }
        return stack.empty();
    }


    private boolean valid(char a, char b) {
        return a == '(' && b == ')' ||
                a == '[' && b == ']' ||
                a == '{' && b == '}';
    }

    public static void main(String[] args) {
        String s = "{[]}";
        System.out.println(new Q20().isValidPro(s));
    }
}
