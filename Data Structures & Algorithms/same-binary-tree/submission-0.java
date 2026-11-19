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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            return p == q;
        }

        Deque<TreeNode> pStack = new ArrayDeque<>();
        Deque<TreeNode> qStack = new ArrayDeque<>();

        pStack.push(p);
        qStack.push(q);

        while(!pStack.isEmpty()) {
            if (qStack.isEmpty()) {
                return false;
            }

            var nextP = pStack.poll();
            var nextQ = qStack.poll();

            if (nextP.val != nextQ.val) {
                return false;
            }

            if (nextP.left != null) {
                if (nextQ.left == null) {
                    return false;
                }
                pStack.push(nextP.left);
            }
            if (nextQ.left != null) {
                if (nextP.left == null) {
                    return false;
                }
                qStack.push(nextQ.left);
            }

            if (nextP.right != null) {
                if (nextQ.right == null) {
                    return false;
                }
                pStack.push(nextP.right);
            }
            if (nextQ.right != null) {
                if (nextP.right == null) {
                    return false;
                }
                qStack.push(nextQ.right);
            }

        }

        return true;
    }
}
