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
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);

        while(!stack.isEmpty()) {
            var node = stack.pop();

            if (sameVals(node, subRoot) && isSameTree(node, subRoot)) {
                return true;
            }

            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }

        return false;
    }

    private boolean isSameTree(TreeNode p, TreeNode q) {
        Deque<Pair> stack = new ArrayDeque<>();

        stack.push(new Pair(p, q));

        while(!stack.isEmpty()) {
            var pair = stack.pop();

            if (pair.bothNull()) {
                continue;
            }
            if (pair.anyNull()) {
                return false;
            }
            if (pair.differentVals()) {
                return false;
            }

            stack.push(pair.left());
            stack.push(pair.right());
        }

        return true;
    }

    private record Pair(TreeNode p, TreeNode q) {

        private boolean bothNull() {
            return p == null && q == null;
        }

        private boolean anyNull() {
            return p == null || q == null;
        }

        private boolean differentVals() {
            return p.val != q.val;
        }

        private Pair left() {
            return new Pair(p.left, q.left);
        }

        private Pair right() {
            return new Pair(p.right, q.right);
        }
    }

    private static boolean sameVals(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            return p == q;
        }
        return p.val == q.val;
    }
}
