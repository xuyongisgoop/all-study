package com.xuyong.study.aogrithum;

/**
 * Created by xuyong on 2021/7/19
 */
public class ReverseList {
    public static void main(String[] args) {
        ListNode f1 = new ListNode(1, null);
        ListNode f2 = new ListNode(2, f1);
        ListNode f3 = new ListNode(3, f2);
        ListNode f4 = new ListNode(4, f3);
        ListNode f5 = new ListNode(5, f4);
        ListNode head = f5;
        while (head.next != null) {
            System.out.println(head.val);
            head = head.next;
        }
        System.out.println("==============");
        ListNode prev = reverseListV1(f5);
        while (prev.next != null) {
            System.out.println(prev.val);
            prev = prev.next;
        }
    }

    public static ListNode reverseListV1(ListNode head) {
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
    public static ListNode reverseListV2(ListNode head) {
        ListNode prev = null;
        return prev;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
