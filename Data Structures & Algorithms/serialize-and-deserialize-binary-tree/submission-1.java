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

public class Codec {

    private static final String NULL = "@";
    private static final String SEPARATOR = ",";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> serialized = new ArrayList<>();

        serialize(root, serialized);

        return String.join(SEPARATOR, serialized);
    }

    private void serialize(TreeNode node, List<String> serialized) {
        if (node == null) {
            serialized.add(NULL);
            return;
        }

        serialized.add(Integer.toString(node.val));

        serialize(node.left, serialized);
        serialize(node.right, serialized);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return new Builder(data).build();
    }

    private class Builder {
        private final String[] nodes;
        private int i;

        private Builder(String data) {
            this.nodes = data.split(SEPARATOR);
            this.i = 0;
        }

        private TreeNode build() {
            var next = nextRawNode();

            if (next == null) {
                return null;
            }

            next.left = build();
            next.right = build();

            return next;
        }

        private TreeNode nextRawNode() {
            return nodeFrom(nodes[i++]);
        }

        private TreeNode nodeFrom(String node) {
            if (NULL.equals(node)) {
                return null;
            }
            int val = Integer.parseInt(node);
            return new TreeNode(val);
        }
    }
}
