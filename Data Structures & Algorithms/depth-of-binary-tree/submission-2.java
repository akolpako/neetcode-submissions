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
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int maxDepth = 0;
        Deque<NodeToDepth> stack = new ArrayDeque<>();
        stack.push(new NodeToDepth(root, 1));

        while(!stack.isEmpty()) {
            var it = stack.pop();
            
            if (it.hasLeft()) {
                stack.push(it.toLeft());
            }
            if (it.hasRight()) {
                stack.push(it.toRight());
            }

            maxDepth = Math.max(maxDepth, it.depth());
        }

        return maxDepth;
    }

    private static record NodeToDepth(TreeNode node, int depth){
        private boolean hasLeft() {
            return node.left != null;
        }

        private boolean hasRight() {
            return node.right != null;
        }

        private NodeToDepth toLeft() {
            return new NodeToDepth(node.left, depth + 1);
        }

        private NodeToDepth toRight() {
            return new NodeToDepth(node.right, depth + 1);
        }
    }
}
