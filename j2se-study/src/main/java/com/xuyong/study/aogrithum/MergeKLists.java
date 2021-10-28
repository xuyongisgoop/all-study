package com.xuyong.study.aogrithum;

/**
 * Created by xuyong on 2021/10/25
 */
public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode listNode = lists[0];
        for (int i = 1; i < lists.length; i++) {
            listNode = mergeTwoLists(listNode, lists[i]);
        }
        return listNode;
    }

    private ListNode mergeTwoLists(ListNode a, ListNode b) {
        ListNode head = new ListNode(0, null);
        ListNode aTemp = a;
        ListNode bTemp = b;
        while (aTemp != null && bTemp != null) {
            if (aTemp.val < bTemp.val) {
                head.next = aTemp;
                aTemp = aTemp.next;
            } else {
                head.next = bTemp;
                bTemp = bTemp.next;
            }
            head = head.next;
        }
        while (aTemp != null) {
            head.next = aTemp;
            aTemp = aTemp.next;
            head = head.next;
        }
        while (bTemp != null) {
            head.next = bTemp;
            bTemp = bTemp.next;
            head = head.next;
        }
        return head;
    }
}
