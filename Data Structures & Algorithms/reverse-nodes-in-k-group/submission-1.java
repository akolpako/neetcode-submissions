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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) {
            return head;
        }
        
        ListNode dummy = new ListNode();
        ListNode groupHead = head;
        ListNode prevTail = dummy;

        while(groupHead != null) {

            if(!validateGroupLength(groupHead, k)) {
                break;
            }

            int gk = k;
            ListNode initialHead = groupHead;
            ListNode nextGroupHead = null;
            ListNode next = null;

            do {
                next = initialHead.next;
                if (next == null) {
                    break;
                }
                gk--;

                if (gk == 1) {
                    nextGroupHead = next.next;
                }

                extractFromList(initialHead, next);
                groupHead = putToHead(groupHead, next);

            } while(gk != 1);

            prevTail.next = groupHead;
            prevTail = initialHead;
            groupHead = initialHead.next;
        }

        return dummy.next;
    }

    private boolean validateGroupLength(ListNode head, int k) {
        while(k != 1 && head != null) {
            head = head.next;
            k--;
        }
        return head != null;
    }

    private void extractFromList(ListNode initialHead, ListNode next) {
        initialHead.next = next.next;
    }

    private ListNode putToHead(ListNode oldHead, ListNode newHead) {
        newHead.next = oldHead;
        return newHead;
    }
}
