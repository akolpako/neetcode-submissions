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

        return maxDepth(root, 1);
    }

    private int maxDepth(TreeNode node, int depth) {
        int depthLeft = depth;
        int depthRight = depth;

        if (node.left != null) {
            depthLeft = maxDepth(node.left, depth + 1);
        }

        if (node.right != null) {
            depthRight = maxDepth(node.right, depth + 1);
        }

        return Math.max(depthLeft, depthRight);
    } 
}
