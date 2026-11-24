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

    public Candidate maxPathSumCandidate(TreeNode root) {
        if (root == null) {
            return new Candidate();
        }

        var leftCandidate = maxPathSumCandidate(root.left);
        var righCandidate = maxPathSumCandidate(root.right);

        return link(root, leftCandidate, righCandidate);
    }

    private Candidate link(TreeNode root, Candidate leftCandidate, Candidate righCandidate) {
        Integer pathToLeft = plus(leftCandidate, root.val);
        Integer pathToRight = plus(righCandidate, root.val);
        Integer pathToLeftAndRight = plus(plus(leftCandidate, righCandidate), root.val);

        Integer[] allMaxCandidates = new Integer[] {
                leftCandidate.allMax(),
                righCandidate.allMax(),
                root.val,
                pathToLeftAndRight
        };
        Integer[] currentMaxPathsCandidates = new Integer[] {
            pathToLeft,
            pathToRight,
            root.val
        };
        return Candidate.from(
            currentMaxPathsCandidates, allMaxCandidates
        );
    }

    private static Integer plus(Integer curr, Integer other) {
        if (other == null) {
            return curr;
        }
        if (curr == null) {
            return other;
        }
        return curr + other;
    }

    private static Integer plus(Candidate curr, Integer other) {
        return plus(curr.currentMaxPath, other);
    }

    private static Integer plus(Candidate curr, Candidate other) {
        return plus(curr.currentMaxPath, other.currentMaxPath);
    }

    private record Candidate(Integer currentMaxPath, Integer allMax) {

        private Candidate() {
            this(null, Integer.MIN_VALUE);
        }

        private static Candidate from(Integer[] currentMaxPathsCandidates, Integer[] allMaxCandidates) {
            Integer currentMaxPath = null;
            for (Integer c : currentMaxPathsCandidates) {
                if (c != null) {
                    currentMaxPath = currentMaxPath != null ? Math.max(currentMaxPath, c) : c;
                }
            }
            Integer allMax = currentMaxPath;
            for (Integer maxCandidate : allMaxCandidates) {
                if (maxCandidate != null) {
                    allMax = allMax != null ? Math.max(allMax, maxCandidate) : maxCandidate;
                }
            }
            return new Candidate(currentMaxPath, allMax);
        }
    }
}
