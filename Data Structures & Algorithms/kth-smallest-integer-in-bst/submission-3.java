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
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode next = root;
        
        while(next != null || !stack.isEmpty()) {
            if (next != null) {
                stack.push(next);
                next = next.left;
                continue;
            }

            var curr = stack.pop();

            k--;
            if (k == 0) {
                return curr.val;
            }

            next = curr.right;
        }

        return -1;
    }
}
