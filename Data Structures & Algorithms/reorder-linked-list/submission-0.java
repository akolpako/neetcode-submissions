/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }

        ListNode mid = findMidNode(head);
        ListNode tail = reverse(mid.next);
        mid.next = null;

        while (tail != null) {
            ListNode headNext = head.next;
            head.next = tail;
            tail = tail.next;
            head.next.next = headNext;
            head = headNext;
        }

    }

    private ListNode reverse(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode prev = head;
        ListNode next = head.next;
        head.next = null;
        while(next != null) {
            ListNode next2 = next.next;
            next.next = prev;
            prev = next;
            next = next2;
        }
        return prev;
    }

    private ListNode findMidNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
