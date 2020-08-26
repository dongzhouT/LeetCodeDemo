package com.tao.leetcode.tree;

import com.tao.leetcode.utils.TreeNode;

import java.util.*;

/**
 * 107. 二叉树的层次遍历 II
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 */
public class Q107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        Stack<List<Integer>> stack = new Stack<>();
        if(root==null){
            return ans;
        }
        deque.offer(root);
        while (!deque.isEmpty()) {
            int len = deque.size();
            List<Integer> list=new ArrayList<>();
            for (int i = 0; i < len; i++) {
                TreeNode node = deque.poll();
                list.add(node.val);
                if (node.right != null) {
                    deque.offer(node.right);
                }
                if (node.left != null) {
                    deque.offer(node.left);
                }
            }
            stack.add(list);
        }
        while(!stack.isEmpty()){
            ans.add(stack.pop());
        }
        return ans;

    }
    public List<List<Integer>> levelOrderBottom2(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        if(root==null){
            return ans;
        }
        deque.offer(root);
        while (!deque.isEmpty()) {
            int len = deque.size();
            List<Integer> list=new ArrayList<>();
            for (int i = 0; i < len; i++) {
                TreeNode node = deque.poll();
                list.add(node.val);
                if (node.left != null) {
                    deque.offer(node.left);
                }
                if (node.right != null) {
                    deque.offer(node.right);
                }
            }
            ans.add(0,list);
        }
        return ans;

    }
}
