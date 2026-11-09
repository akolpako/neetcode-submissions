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
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();

        stack.add(root);
        while(!stack.isEmpty()) {
            var next = stack.pollLast();
            if (next.left != null) {
                stack.addLast(next.left);
            }
            if (next.right != null) {
                stack.addLast(next.right);
            }
            var left = next.left;
            next.left = next.right;
            next.right = left;
        }

        return root;
    }
}
