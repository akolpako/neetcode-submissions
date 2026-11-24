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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }

        return buildTree(preorder, inorder, 0, inorder.length - 1, 0);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder, int il, int ih, int pl) {
        if (pl >= preorder.length || il > ih) {
            return null;
        }

        int root = preorder[pl];
        int inorderRootIndex = findRootIndexInOrder(inorder, il, ih, root);

        int elementsFromTheLeft = inorderRootIndex - il;
        int leftPl = pl + 1;
        int rightPl = pl + elementsFromTheLeft + 1;

        return new TreeNode(
            root,
            buildTree(preorder, inorder, il, inorderRootIndex - 1, leftPl),
            buildTree(preorder, inorder, inorderRootIndex + 1, ih, rightPl)
        );
    }

    private int findRootIndexInOrder(int[] inorder, int l, int h, int root) {
        for (int i = l; i <= h; i++) {
            if (inorder[i] == root) {
                return i;
            }
        }
        return -1;
    }
}
