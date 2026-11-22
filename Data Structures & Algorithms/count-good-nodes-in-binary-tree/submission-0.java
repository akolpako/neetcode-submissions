/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int goodNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Deque<NodeToMax> queue = new ArrayDeque<>();
        queue.push(new NodeToMax(root, root.val));

        int goodNodes = 0;

        while(!queue.isEmpty()) {
            var node = queue.pop();

            if (node.isEmpty()) {
                continue;
            }

            if (node.isGood()) {
                goodNodes++;
            }
            
            queue.push(node.left());
            queue.push(node.right());
        }

        return goodNodes;
    }

    private record NodeToMax(TreeNode node, int prevMax) {
        private boolean isEmpty() {
            return node == null;
        }

        private boolean isGood() {
            return node.val >= prevMax;
        }

        private NodeToMax left() {
            return new NodeToMax(node.left, Math.max(prevMax, node.val));
        }

        private NodeToMax right() {
            return new NodeToMax(node.right, Math.max(prevMax, node.val));
        }
    }
}
