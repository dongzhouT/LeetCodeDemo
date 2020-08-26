package com.tao.leetcode.test;

public class NodeTest {
    static class ListNode{
        public int val;
        public ListNode next;
        public ListNode(int val){
            this.val=val;
            this.next =null;
        }
    }
    private static ListNode reverse(ListNode node){
        ListNode prev=null;
        ListNode cur=node;
        while(cur!=null){
            ListNode tmp=cur.next;
            cur.next=prev;
            prev=cur;
            cur=tmp;
        }
        return prev;

    }
    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //int a = in.nextInt();
        //System.out.println(a);
        ListNode node=new ListNode(0);
        node.next=new ListNode(1);
        node.next.next=new ListNode(2);
        node.next.next.next=new ListNode(3);
        node.next.next.next.next=new ListNode(4);
        ListNode head=reverse(node);
        while(head!=null){
            System.out.println(head.val+"");
            head=head.next;
        }

    }
}
