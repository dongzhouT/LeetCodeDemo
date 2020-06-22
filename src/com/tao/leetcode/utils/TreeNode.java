package com.tao.leetcode.utils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public static TreeNode buildTree(Integer[] datas) {
        if (datas == null || datas.length == 0) {
            return null;
        }
        List<TreeNode> list = new ArrayList<>();
        for (Integer d : datas) {
            list.add(new TreeNode(d));
        }
        for (int i = 0; i < list.size() / 2; i++) {
            list.get(i).left = list.get(2 * i + 1);
            list.get(i).right = list.get(2 * i + 2);
        }
        return list.get(0);
    }

    // 递归生成树
    public static TreeNode buildTree2(Integer[] datas) {
        if (datas == null || datas.length == 0) {
            return null;
        }
        TreeNode root = getSubTree(datas, 0);
        return root;
    }

    public static TreeNode getSubTree(Integer[] datas, int index) {
        if (index >= datas.length) {
            return null;
        }
        TreeNode root = new TreeNode(datas[index]);
        root.left = getSubTree(datas, 2 * index + 1);
        root.right = getSubTree(datas, 2 * index + 2);
        return root;
    }

    //Breadth First Search(BFS)
    public static void bsf(TreeNode root) {
        if (root == null) {
            return;
        }
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            System.out.println(queue.peek().val);
//            list.add(queue.peek().val);
            if (queue.peek().left != null) {
                queue.add(queue.peek().left);
            }
            if (queue.peek().right != null) {
                queue.add(queue.peek().right);
            }
            queue.poll();
        }

    }

    public static void main(String[] args) {
        Integer[] trees = new Integer[]{1, 2, 3, 4, 0, 0, 5, 6, 7, 0, 8, 9};
        TreeNode root = buildTree2(trees);
        System.out.println(GsonUtils.toJson(root));
        bsf(root);
    }

}
