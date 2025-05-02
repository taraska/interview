package us.ivannikov.algo.list;

import java.util.HashSet;
import java.util.Set;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {

    //list: 1 -> 2 -> 3 -> 4 -> 5 -> 6
    //2 -> 3 -> 4 -> 5 -> 6
    //4 -> 6 -> 2 -> 4 -> 6
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            if (slow == fast) {
                return true;  // Cycle detected
            }
            slow = slow.next;       // Move slow by 1
            fast = fast.next.next;  // Move fast by 2
        }

        return false;  // No cycle
    }

    public boolean hasCycleSet(ListNode head) {
        Set<ListNode> visited = new HashSet<>();
        ListNode current = head;

        while (current != null) {
            if (visited.contains(current)) {
                return true;  // Cycle detected
            }
            visited.add(current);
            current = current.next;
        }

        return false;  // No cycle
    }

    public static void main(String[] args) {

    }
}
