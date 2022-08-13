package com.xuyong.study.aogrithum.reverselist;

/**
 * @Description: 反转链表
 * @Author: xuyong
 * @Date: 2022/7/27
 **/
public class ReverseList2 {

    public static void main(String[] args) {
        ListNode f1 = new ListNode(1, null);
        ListNode f2 = new ListNode(2, f1);
        ListNode f3 = new ListNode(3, f2);
        ListNode f4 = new ListNode(4, f3);
        ListNode f5 = new ListNode(5, f4);
        ListNode head = f5;
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
        System.out.println("==============");
        ListNode prev = reverse(f5);
        while (prev != null) {
            System.out.println(prev.val);
            prev = prev.next;
        }
    }

    public static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

}


