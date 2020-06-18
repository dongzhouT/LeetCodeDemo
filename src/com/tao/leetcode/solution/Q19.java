package com.tao.leetcode.solution;

import sun.security.util.Length;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 19. 删除链表的倒数第N个节点
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * <p>
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 */
public class Q19 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode oldHead = head;
        List<ListNode> nodeList = new ArrayList<>();
        while (head != null) {
            nodeList.add(head);
            head = head.next;
        }
        int removeIndex = nodeList.size() - n;
        if (removeIndex == 0) {
            oldHead = nodeList.get(removeIndex).next;
        } else {
            nodeList.get(removeIndex - 1).next = nodeList.get(removeIndex).next;
        }
        return oldHead;

    }

    public static void main(String[] args) {
        System.out.println();
    }
}
