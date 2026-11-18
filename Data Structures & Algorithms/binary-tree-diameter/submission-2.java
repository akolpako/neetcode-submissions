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
    public int diameterOfBinaryTree(TreeNode root) {
        return dig(root).diameter();
    }

    private Result dig(TreeNode root) {
        if (root == null) {
            return new Result(0, 0);
        }
        
        var left = dig(root.left);
        var right = dig(root.right);

        var diameter = left.depth() + right.depth();
        diameter = Math.max(diameter, left.diameter());
        diameter = Math.max(diameter, right.diameter());

        var depth = Math.max(left.depth(), right.depth()) + 1;

        return new Result(depth, diameter);
    }

    private record Result(int depth, int diameter){}
}
