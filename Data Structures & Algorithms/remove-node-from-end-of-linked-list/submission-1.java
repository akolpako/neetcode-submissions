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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = moveForwardIn(head, n);

        if (fast == null) {
            return removeHead(head);
        }

        while(fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        ListNode toRemove = slow.next;
        if (toRemove != null) {
            slow.next = toRemove.next;
        } else {
            slow.next = null;
        }

        return head;
    }

    private ListNode removeHead(ListNode head) {
        if (head == null) {
            return null;
        }
        return head.next;
    }

    private ListNode moveForwardIn(ListNode head, int n) {
        while(n != 0 && head != null) {
            head = head.next;
            n--;
        }
        return head;
    }
}
