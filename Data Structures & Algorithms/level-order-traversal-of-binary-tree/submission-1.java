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

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        
        while(!queue.isEmpty()) {
            TreeNode[] currentLevel = nextTreeLevel(queue);

            result.add(
                toLevelResult(currentLevel)
            );

            addNextLevelToQueue(queue, currentLevel);
        }

        return result;
    }

    private void addNextLevelToQueue(Queue<TreeNode> queue, TreeNode[] currentLevel) {
        for (TreeNode node : currentLevel) {
            if (node != null) {
                if (node.left != null) {
                    queue.offer(node.left); 
                }
                if (node.right != null) {
                    queue.offer(node.right); 
                }
            }
        }
    }

    private List<Integer> toLevelResult(TreeNode[] level) {
        List<Integer> levelResult = new ArrayList<>();
        for (TreeNode node : level) {
            if (node != null) {
                levelResult.add(node.val);
            }
            
        }
        return levelResult;
    } 

    private TreeNode[] nextTreeLevel(Queue<TreeNode> queue) {
        TreeNode[] level = new TreeNode[queue.size()];
        for (int i = 0; i < level.length; i++) {
            var node = queue.poll();
            level[i] = node;
        }
        return level;
    }
}
