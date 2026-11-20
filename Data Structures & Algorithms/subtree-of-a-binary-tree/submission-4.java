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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }
        return isSameTree(root, subRoot) ||
            isSubtree(root.left, subRoot) ||
            isSubtree(root.right, subRoot);
    }

    private static TreeNode left(TreeNode p) {
        return p != null ? p.left : null;
    }

    private static TreeNode right(TreeNode p) {
        return p != null ? p.right : null;
    }

    private boolean isSameTree(TreeNode p, TreeNode q) {
        if (p ==  null || q == null) {
            return p == q;
        }
        return p.val == q.val &&
            isSameTree(p.left, q.left) &&
            isSameTree(p.right, q.right);
    }
}
