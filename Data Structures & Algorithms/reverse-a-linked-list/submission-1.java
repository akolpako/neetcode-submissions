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
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        return reverse(head.next, new ListNode(head.val));
    }

    private ListNode reverse(ListNode curr, ListNode prev) {
        if (curr == null) {
            return prev;
        }
        var next = curr.next;
        var reversed = curr;
        reversed.next = prev;
        if (next != null) {
            return reverse(next, reversed);
        }
        return reversed;
    }
}
