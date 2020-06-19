package com.tao.leetcode.solution;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public static ListNode buildListNode(int[] data) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        for (int i = 0; i < data.length; i++) {
            ListNode node = new ListNode(data[i]);
            dummy.next = node;
            dummy = dummy.next;
        }
        return head.next;
    }
}
