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
        ArrayDeque<TreeNode> stack = new ArrayDeque<TreeNode>();
        Set<TreeNode> seen = new HashSet<>();
        stack.push(root);

        while(!stack.isEmpty()) {
            var node = stack.pop();
            if (node.left != null && seen.add(node.left)) {
                stack.push(node);
                stack.push(node.left);
            } else if (node.right != null && seen.add(node.right)) {
                stack.push(node);
                stack.push(node.right);
            } else {
                maxDepth = Math.max(maxDepth, stack.size() + 1);
            }
        }

        return maxDepth;
    }
}
