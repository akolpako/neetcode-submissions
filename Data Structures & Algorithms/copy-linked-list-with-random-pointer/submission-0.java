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
        Map<Node, Node> index = new HashMap<>();

        Node dummy = new Node(0);
        Node prev = dummy;
        Node next;
        while(head != null) {
            next = getOrCopy(head, index);
            next.random = getOrCopy(head.random, index);
            prev.next = next;
            head = head.next;
            prev = next;
        }

        return dummy.next;
    }

    private Node getOrCopy(Node node, Map<Node, Node> index) {
        if (node == null) {
            return null;
        }
        if (index.containsKey(node)) {
            return index.get(node);
        }
        Node nodeCopy = new Node(node.val);
        index.put(node, nodeCopy);
        return nodeCopy;
    }
}
