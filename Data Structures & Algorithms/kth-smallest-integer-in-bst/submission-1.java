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
        Deque<NavigableNode> stack = new ArrayDeque<>();
        stack.push(new NavigableNode(root));

        while(!stack.isEmpty()) {
            var curr = stack.peek();

            if (curr.wasNotInLeft() && curr.hasLeft()) {
                stack.push(curr.left());
                continue;
            }

            curr = stack.pop();

            k--;
            if (k == 0) {
                return curr.val();
            }

            if (curr.hasRight()) {
                stack.push(curr.right());
            }
        }

        return -1;
    }

    private class NavigableNode{
        private TreeNode node;
        private boolean leftUsed = false;

        private NavigableNode(TreeNode node) {
            this.node = node;
        }

        private boolean wasNotInLeft() {
            return leftUsed == false;
        }

        private boolean hasLeft() {
            return node != null && node.left != null;
        }

        private NavigableNode left() {
            leftUsed = true;
            return new NavigableNode(node.left);
        }

        private boolean hasRight() {
            return node != null && node.right != null;
        }

        private NavigableNode right() {
            return new NavigableNode(node.right);
        }

        private int val() {
            return node.val;
        }
    }
}
