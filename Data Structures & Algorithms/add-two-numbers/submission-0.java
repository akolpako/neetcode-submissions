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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        int reminder = 0;

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while(l1 != null || l2 != null) {
            int l1Val = l1 != null ? l1.val : 0;
            int l2Val = l2 != null ? l2.val : 0;

            int sum = l1Val + l2Val + reminder;
            reminder = sum >= 10 ? sum / 10 : 0;
            sum = sum >= 10 ? sum % 10 : sum;

            curr.next = new ListNode(sum);
            
            curr = next(curr);
            l1 = next(l1);
            l2 = next(l2);
        }
        
        if (reminder != 0) {
            curr.next = new ListNode(reminder);
        }

        return dummy.next;
    }

    private ListNode next(ListNode curr) {
        if (curr == null) {
            return null;
        }
        return curr.next;
    }

    
}
