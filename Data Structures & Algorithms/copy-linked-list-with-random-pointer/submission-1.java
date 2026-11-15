/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {

        Node curr = head;
        while(curr != null) {
            Node copy = new Node(curr.val);
            Node next = curr.next;
            curr.next = copy;
            copy.next = next;
            curr = next;
        }

        curr = head;
        while(curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }
        
        curr = head;
        Node dummy = new Node(0);
        Node prev = dummy;
        while(curr != null) {
            Node copy = curr.next;
            prev.next = copy;
            curr.next = copy.next;
            
            prev = copy;
            curr = curr.next;
        }

        return dummy.next;
    }
}
