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
    private static final String EMPTY = "";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return EMPTY;
        }

        List<String> serialized = new ArrayList<>();

        serialize(root, serialized);

        return serialized.stream()
                .collect(Collectors.joining(SEPARATOR));
    }

    public void serialize(TreeNode node, List<String> serialized) {
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
        if (EMPTY.equals(data)) {
            return null;
        }

        return new Builder(data).build();
    }

    private class Builder {
        String[] nodes;
        int i;

        private Builder(String data) {
            this.nodes = data.split(SEPARATOR);
            this.i = 0;
        }

        private TreeNode build() {
            return buildNext();
        }

        private TreeNode buildNext() {
            var next = nextRawNode();

            if (next == null) {
                return null;
            }

            next.left = buildNext();
            next.right = buildNext();

            return next;
        }

        private TreeNode nextRawNode() {
            if (i >= nodes.length) {
                return null;
            }
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
