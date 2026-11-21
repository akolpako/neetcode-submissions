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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        Deque<NodeToLevel> stack = new ArrayDeque<>();
        stack.push(new NodeToLevel(root, 0));
        
        while(!stack.isEmpty()) {
            var next = stack.pop();

            if (next.isEmpty()) {
                continue;
            }

            appendToResult(result, next);

            stack.push(next.right());
            stack.push(next.left());
        }

        return result;
    }

    private void appendToResult(List<List<Integer>> result, NodeToLevel node) {
        while(node.level >= result.size()) {
            result.add(new ArrayList<>());
        }
        result.get(node.level).add(node.node().val);
    }

    private record NodeToLevel(TreeNode node, int level){
        private boolean isEmpty() {
            return node == null;
        }

        private NodeToLevel left() {
            return new NodeToLevel(node.left, level + 1);
        }

        private NodeToLevel right() {
            return new NodeToLevel(node.right, level + 1);
        }
    }
}
