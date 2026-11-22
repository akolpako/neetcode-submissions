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
        Deque<NodeToMax> stack = new ArrayDeque<>();
        stack.push(new NodeToMax(root, root.val));

        int goodNodes = 0;

        while(!stack.isEmpty()) {
            var node = stack.pop();

            if (node.isGood()) {
                goodNodes++;
            }
            
            if (node.hasLeft()) {
                stack.push(node.left());
            }
            if (node.hasRight()) {
                stack.push(node.right());
            }
        }

        return goodNodes;
    }

    private record NodeToMax(TreeNode node, int prevMax) {

        private boolean isGood() {
            return node.val >= prevMax;
        }

        private boolean hasLeft() {
            return node.left != null;
        }

        private boolean hasRight() {
            return node.right != null;
        }

        private NodeToMax left() {
            return new NodeToMax(node.left, Math.max(prevMax, node.val));
        }

        private NodeToMax right() {
            return new NodeToMax(node.right, Math.max(prevMax, node.val));
        }
    }
}
