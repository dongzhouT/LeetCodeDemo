package com.tao.leetcode.solution;

import com.google.gson.Gson;

/**
 * 23. 合并K个排序链表
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * 示例:
 * <p>
 * 输入:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 */
public class Q23 {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while (true) {
            dummy.next = getMinNode(lists);
            if (dummy.next == null) {
                break;
            }
            dummy = dummy.next;
        }

        return head.next;
    }

    public ListNode getMinNode(ListNode[] listNodes) {
        int min = Integer.MAX_VALUE;
        int index = 0;
        ListNode result = null;
        for (int i = 0; i < listNodes.length; i++) {
            //do somethine
            if (listNodes[i] == null) {
                continue;
            }
            if (min > listNodes[i].val) {
                min = listNodes[i].val;
                index = i;
                result = listNodes[i];
            }
        }
        if (result != null) {
            listNodes[index] = result.next;
        }
        return result;
    }

    public static ListNode buildListNode(int[] data) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        for (int i = 0; i < data.length; i++) {
            ListNode node = new ListNode(data[i]);
            dummy.next = node;
            dummy = dummy.next;
            //do somethine
        }
        return head.next;
    }

    public static void main(String[] args) {
        int[] data1 = new int[]{1, 4, 5};
        ListNode[] data = new ListNode[]{
                buildListNode(new int[]{1, 4, 5}),
                buildListNode(new int[]{1, 3, 4}),
                buildListNode(new int[]{2, 6}),
        };
//        System.out.println(new Gson().toJson(data));
        System.out.println(new Gson().toJson(new Q23().mergeKLists(data)));
    }
}
