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
        var iIndex = inorderIndex(inorder);
        return buildTree(preorder, iIndex, 0, inorder.length - 1, 0);
    }

    private TreeNode buildTree(int[] preorder, Map<Integer, Integer> inorder, int il, int ih, int pl) {
        if (il > ih) {
            return null;
        }

        int root = preorder[pl];
        int inorderRootIndex = inorder.get(root);

        int elementsFromTheLeft = inorderRootIndex - il;
        int leftPl = pl + 1;
        int rightPl = pl + elementsFromTheLeft + 1;

        return new TreeNode(
            root,
            buildTree(preorder, inorder, il, inorderRootIndex - 1, leftPl),
            buildTree(preorder, inorder, inorderRootIndex + 1, ih, rightPl)
        );
    }

    private Map<Integer, Integer> inorderIndex(int[] inorder) {
        Map<Integer, Integer> index = HashMap.newHashMap(inorder.length);

        for (int i = 0; i < inorder.length; i++) {
            index.put(inorder[i], i);
        }

        return index;
    }
}
