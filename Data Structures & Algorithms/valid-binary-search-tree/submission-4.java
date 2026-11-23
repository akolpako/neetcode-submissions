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
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode node, int min, int max) {
        if (node == null) {
            return true;
        }

        if (node.left != null) {
            if (node.left.val >= node.val) {
                return false;
            }
            if (node.left.val <= min) {
                return false;
            }
        }

        if (node.right != null) {
            if (node.right.val <= node.val) {
                return false;
            }
            if (node.right.val >= max) {
                return false;
            }
        }

        return isValidBST(node.left, min, node.val) && isValidBST(node.right, node.val, max);
    }
}
