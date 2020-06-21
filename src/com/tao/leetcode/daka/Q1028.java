package com.tao.leetcode.daka;


import com.google.gson.Gson;
import com.tao.leetcode.utils.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 1028. 从先序遍历还原二叉树
 */
public class Q1028 {
    public TreeNode recoverFromPreorder(String S) {
        Deque<TreeNode> path = new LinkedList<TreeNode>();
        int pos = 0;
        while (pos < S.length()) {
            int level = 0;
            while (pos < S.length() && S.charAt(pos) == '-') {
                level++;
                pos++;
            }
            int value = 0;
            while (pos < S.length() && Character.isDigit(S.charAt(pos))) {
                value = value * 10 + (S.charAt(pos) - '0');
                pos++;
            }
            TreeNode node = new TreeNode(value);
            if (level == path.size()) {
                if (!path.isEmpty()) {
                    path.peek().left = node;
                }
            } else {
                while (level != path.size()) {
                    path.pop();
                }
                path.peek().right = node;
            }
            path.push(node);
        }
        while (path.size() > 1) {
            path.pop();
        }
        return path.peek();
    }

    public static void main(String[] args) {
        Q1028 ff = new Q1028();
        String data = "1-2--3--4-5--6--7";
        System.out.println(new Gson().toJson(ff.recoverFromPreorder(data)));
    }
}
