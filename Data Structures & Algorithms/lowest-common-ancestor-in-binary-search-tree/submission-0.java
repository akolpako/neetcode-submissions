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
        List<TreeNode> pPath = findNodePath(root, p);
        List<TreeNode> qPath = findNodePath(root, q);

        List<TreeNode> shortPath = pPath.size() <= qPath.size() ? pPath : qPath;
        List<TreeNode> longPath = shortPath == pPath ? qPath : pPath;

        TreeNode result = root;

        for (int i = 0; i < shortPath.size(); i++) {
            if (shortPath.get(i) == longPath.get(i)) {
                result = shortPath.get(i);
            } else {
                return result;
            }
        }

        return result;
    }

    private List<TreeNode> findNodePath(TreeNode root, TreeNode node) {
        List<TreeNode> path = new ArrayList<>();
        while(root.val != node.val && root != null) {
            path.add(root);
            
            if (root.val < node.val) {
                root = root.right;
            } else {
                root = root.left;
            }
        }

        path.add(node);

        return path;
    }
}
