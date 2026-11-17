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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.val, b.val)
        );

        for (ListNode head : lists) {
            if (head != null) {
                pq.offer(head);
            }
        }

        ListNode dummy = new ListNode();
        ListNode curr = dummy;

        while(!pq.isEmpty()) {
            var node = pq.poll();
            curr.next = node;
            curr = node;

            if (curr.next != null) {
                pq.offer(curr.next);
            }
        }

        curr.next = null;

        return dummy.next;
    }
}
