package com.tao.leetcode.daka;

import com.tao.leetcode.utils.TreeNode;

/**
 * 124. 二叉树中的最大路径和
 */
public class Q124 {
    int maxSum = Integer.MIN_VALUE;

    public int maxGain(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(maxGain(root.left), 0);
        int right = Math.max(maxGain(root.right), 0);
        int priceNewPath = root.val + left + right;
        maxSum = Math.max(maxSum, priceNewPath);
        return root.val + Math.max(left, right);
    }

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        Q124 qq = new Q124();
//        qq.maxPathSum(root);
//        System.out.println("maxSum =" + maxSum);
        System.out.println(qq.maxPathSum(root));
    }

}
