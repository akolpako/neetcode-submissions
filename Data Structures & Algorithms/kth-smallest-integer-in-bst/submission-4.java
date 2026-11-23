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
        return kthSmallest(root, k, new AtomicInteger(0));
    }

    public Integer kthSmallest(TreeNode root, int k, AtomicInteger c) {
        if (root == null) {
            return null;
        }

        if (root.left != null) {
            var leftRes = kthSmallest(root.left, k, c);

            if (leftRes != null) {
                return leftRes;
            }
        }

        c.incrementAndGet();
        if (c.get() == k) {
            return root.val;
        }

        return kthSmallest(root.right, k, c);
    }
}
