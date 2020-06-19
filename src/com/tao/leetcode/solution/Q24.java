package com.tao.leetcode.solution;

import com.google.gson.Gson;

/**
 * 24. 两两交换链表中的节点
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 示例:
 * <p>
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 */
public class Q24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next=head;
        return next;
    }

    public static void main(String[] args) {
        System.out.println(new Gson().toJson(new Q24().swapPairs(ListNode.buildListNode(new int[]{1, 2, 3, 4}))));
    }
}
