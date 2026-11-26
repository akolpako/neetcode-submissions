class PrefixTree {

    private final Node root = new Node();

    public PrefixTree() {
         
    }

    public void insert(String word) {
        Node currNode = root;
        int end = word.length() - 1;
        for(int i = 0; i < word.length(); i++) {
            var c = word.charAt(i);
            currNode = currNode.insert(c, i == end);
        }
    }

    public boolean search(String word) {
        Node endNode = searchNode(word);
        return endNode != null && endNode.endWord == true;
    }

    public boolean startsWith(String prefix) {
        return searchNode(prefix) != null;
    }

    public Node searchNode(String word) {
        Node currNode = root;
        for(int i = 0; i < word.length(); i++) {
            var c = word.charAt(i);
            currNode = currNode.search(c);
            if (currNode == null) {
                return null;
            }
        }

        return currNode;
    }

    private static class Node {
        private Node[] children = new Node[26];
        private boolean endWord;

        private Node insert(char c, boolean end) {
            var node = search(c);
            if (node == null) {
                node = new Node();
                children[c - 'a'] = node;
            }
            node.endWord = node.endWord | end;
            return node;
        }

        private Node search(char c) {
            return children[c - 'a'];
        }
    }
}
