package us.ivannikov.algo.list;

import java.util.ArrayList;
import java.util.List;

public class ReverseLinkedList {
    static class ListNode {
        int val;
        ListNode next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ReverseLinkedList.ListNode();
        listNode.val = 1;
        listNode.next = null;

        ListNode listNode1 = new ReverseLinkedList.ListNode();
        listNode1.val = 2;
        listNode1.next = listNode;

        ListNode listNode2 = new ReverseLinkedList.ListNode();
        listNode2.val = 3;
        listNode2.next = listNode1;

        ListNode listNode3 = new ReverseLinkedList.ListNode();
        listNode3.val = 4;
        listNode3.next = listNode2;

        ListNode listNode4 = new ReverseLinkedList.ListNode();
        listNode4.val = 5;
        listNode4.next = listNode3;

        List<ListNode> list = new ArrayList<>();
        list.add(listNode);
        list.add(listNode1);
        list.add(listNode2);
        list.add(listNode3);
        list.add(listNode4);

        ListNode temp = listNode4;
        while (temp != null) {
            System.out.println("value: " + temp.val);
            temp = temp.next;
        }

        ListNode d = reverse(listNode4);
        ListNode t = d;

        while (d != null) {
            System.out.println("value new: " + d.val);
            d = d.next;
        }

        ListNode listNode5 = reverseCopy(t);
        while (listNode5 != null) {
            System.out.println("value new again: " + listNode5.val);
            listNode5 = listNode5.next;
        }

        ListNode d1 = reverse(listNode4);
        ListNode t1 = d1;

        ListNode listNode6 = reverseOneMore(t1);
        while (listNode6 != null) {
            System.out.println("value new again one more: " + listNode6.val);
            listNode6 = listNode6.next;
        }
    }

    public static ListNode reverse(ListNode node) {
        ListNode prev = null;
        ListNode cur = node;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return prev;
    }

    public static ListNode reverseCopy(ListNode n) {
        ListNode prev = null;
        ListNode cur = n;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return cur;
    }

    public static ListNode reverseOneMore(ListNode listNode) {
        ListNode prev = null;
        ListNode cur = listNode;


        //1 -> 2 -> 3 -> 4
        //1    2 -> 3 -> 4
        //1 <- 2    3 -> 4

        //nodeNext = 2
        //prev = 1

        //2 -> 1
        //prev = 2
        while (cur != null) {
            ListNode nodeNext = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nodeNext;
        }

        return prev;
    }
}
