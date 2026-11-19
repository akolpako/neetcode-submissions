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
    public boolean isBalanced(TreeNode root) {
        return isBalancedNode(root).isBalanced();
    }

    private BalancedResult isBalancedNode(TreeNode node) {
        if (node == null) {
            return new BalancedResult(0, true);
        }
        
        var left = isBalancedNode(node.left);
        if (!left.isBalanced()) {
            return new BalancedResult(left.depth() + 1, false);
        }

        var right = isBalancedNode(node.right);
        var isBalanced = left.isBalancedWith(right);
        var currDepth = Math.max(
            left.depth(),
            right.depth()
        ) + 1;
        return new BalancedResult(currDepth, isBalanced);
    }

    private record BalancedResult(int depth, boolean isBalanced) {
        private boolean isBalancedWith(BalancedResult other) {
            var depthDiff = this.depth - other.depth;
            return this.isBalanced && other.isBalanced && Math.abs(depthDiff) <= 1;
        }
    }
}
