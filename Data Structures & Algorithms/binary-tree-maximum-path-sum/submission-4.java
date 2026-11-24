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

    private Candidate link(TreeNode root, Candidate leftCandidate, Candidate rightCandidate) {
        int pathToLeft = leftCandidate.path() + root.val;
        int pathToRight = rightCandidate.path() + root.val;
        int nextPath = Math.max(0, pathToLeft);
        nextPath = Math.max(nextPath, pathToRight);

        int pathToLeftAndRight = leftCandidate.path() + root.val + rightCandidate.path();

        int nextAllMax = leftCandidate.allMax();
        nextAllMax = Math.max(nextAllMax, rightCandidate.allMax());
        nextAllMax = Math.max(nextAllMax, pathToLeftAndRight);

        return new Candidate(nextPath, nextAllMax);
    }

    private record Candidate(int path, int allMax) {
        private Candidate() {
            this(0, Integer.MIN_VALUE);
        }
    }
}
