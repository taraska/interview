package us.ivannikov.algo.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class MergedLinkedList {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        MergedLinkedList mergedLinkedList = new MergedLinkedList();
        ListNode listNode = mergedLinkedList.new ListNode(1);
        ListNode listNode2 = mergedLinkedList.new ListNode(2);
        ListNode listNode3 = mergedLinkedList.new ListNode(3);

        listNode.next = listNode2;
        listNode2.next = listNode3;
    }

    public ListNode mergeTwoSortedLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        current.next = (l1 != null) ? l1 : l2;
        return dummy.next;
    }

    public static LinkedList<Integer> mergeSortedLinkedLists(LinkedList<Integer> list1,
                                                             LinkedList<Integer> list2) {
        LinkedList<Integer> mergedList = new LinkedList<>();
        ListIterator<Integer> it1 = list1.listIterator();
        ListIterator<Integer> it2 = list2.listIterator();

        Integer elem1 = it1.hasNext() ? it1.next() : null;
        Integer elem2 = it2.hasNext() ? it2.next() : null;

        while (elem1 != null && elem2 != null) {
            if (elem1 < elem2) {
                mergedList.add(elem1);
                elem1 = it1.hasNext() ? it1.next() : null;
            } else {
                mergedList.add(elem2);
                elem2 = it2.hasNext() ? it2.next() : null;
            }
        }

        int[] b = new int[1];
        ArrayList<Object> objects = new ArrayList<>();

        List<int[]> list = Arrays.asList(b);

        // Add remaining elements
        while (elem1 != null) {
            mergedList.add(elem1);
            elem1 = it1.hasNext() ? it1.next() : null;
        }

        while (elem2 != null) {
            mergedList.add(elem2);
            elem2 = it2.hasNext() ? it2.next() : null;
        }

        return mergedList;
    }
}
