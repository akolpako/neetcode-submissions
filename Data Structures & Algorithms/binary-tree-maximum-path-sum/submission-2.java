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
    public int maxPathSum(TreeNode root) {
        return maxPathSumCandidate(root).allMax();
    }

    private Candidate maxPathSumCandidate(TreeNode root) {
        if (root == null) {
            return new Candidate();
        }

        var leftCandidate = maxPathSumCandidate(root.left);
        var rightCandidate = maxPathSumCandidate(root.right);

        return link(root, leftCandidate, rightCandidate);
    }

    private Candidate link(TreeNode root, Candidate leftCandidate, Candidate righCandidate) {
        Integer pathToLeft = leftCandidate.path() + root.val;
        Integer pathToRight = righCandidate.path() + root.val;
        Integer nextPath = Math.max(0, pathToLeft);
        nextPath = Math.max(nextPath, pathToRight);
        nextPath = Math.max(nextPath, root.val);

        Integer pathToLeftAndRight = leftCandidate.path() + root.val + righCandidate.path();

        Integer nextAllMax = leftCandidate.allMax();
        nextAllMax = Math.max(nextAllMax, root.val);
        nextAllMax = Math.max(nextAllMax, leftCandidate.allMax());
        nextAllMax = Math.max(nextAllMax, righCandidate.allMax());
        if (pathToLeftAndRight > 0) {
            nextAllMax = Math.max(nextAllMax, pathToLeftAndRight);
        }

        return new Candidate(nextPath, nextAllMax);
    }

    private record Candidate(int path, Integer allMax) {
        private Candidate() {
            this(0, Integer.MIN_VALUE);
        }
    }
}
