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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = null;

        ListNode curr = null;
        while(list1 != null || list2 != null) {
            ListNode next = null;

            if (list1 == null || (list1 != null && list2 != null && list1.val >= list2.val)) {
                next = list2;
                list2 = list2.next;
            } else if (list2 == null || (list1 != null && list2 != null && list1.val < list2.val)){
                next = list1;
                list1 = list1.next;
            }

            if (curr != null) {
                curr.next = next;
            } else {
                head = next;
            }
            curr = next;
        }

        return head;
    }
}