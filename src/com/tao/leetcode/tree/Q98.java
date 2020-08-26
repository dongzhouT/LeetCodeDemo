package com.tao.leetcode.tree;

import com.tao.leetcode.utils.TreeNode;

/**
 * 98. 验证二叉搜索树
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * <p>
 * 假设一个二叉搜索树具有如下特征：
 * <p>
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 */
public class Q98 {
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    public boolean helper(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }
        int val = root.val;
        if (min != null && val <= min) return false;
        if (max != null && val >= max) return false;
        if (!helper(root.left, min, val)) return false;
        if (!helper(root.right, val, max)) return false;
        return true;
    }

    long min = Long.MIN_VALUE;

    /**
     * 中序遍历
     *
     * @param root
     * @return
     */
    public boolean isValidBST2(TreeNode root) {
        if (root == null)
            return true;
        if (!isValidBST2(root.left)) {
            return false;
        }
        if (root.val <= min) {
            return false;
        }
        min = root.val;

        return isValidBST2(root.right);
    }
}
