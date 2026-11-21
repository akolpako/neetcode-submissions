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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(root != null) {

            if (root.val == p.val || root.val == q.val) {
                return root;
            }
            
            if (bothBiggerThanRoot(root, p ,q)) {
                root = root.right;
            } else if (bothSmallerThanRoot(root, p ,q)){
                root = root.left;
            } else {
                return root;
            }
        }

        return root;
    }

    private boolean bothBiggerThanRoot(TreeNode root, TreeNode p, TreeNode q) {
        return root.val < p.val && root.val < q.val;
    }

    private boolean bothSmallerThanRoot(TreeNode root, TreeNode p, TreeNode q) {
        return root.val > p.val && root.val > q.val;
    }
}
