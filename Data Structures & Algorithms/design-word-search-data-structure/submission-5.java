class WordDictionary {

    private final Node root = new Node();

    public WordDictionary() {

    }

    public void addWord(String word) {
        Node currNode = root;
        for(int i = 0; i < word.length(); i++) {
            var c = word.charAt(i);
            currNode = currNode.getOrCreate(c);
        }
        currNode.endWord = true;
    }

    public boolean search(String word) {
        return search(root, word, 0);
    }

    private boolean search(Node node, String word, int i) {
        if (i == word.length()) {
            return node.endWord;
        }
        char c = word.charAt(i);
        if (c == '.') {
            for (Node nextNode : node.children) {
                if (nextNode != null) {
                    if (search(nextNode, word, i + 1)) {
                        return true;
                    }
                }
                
            }
        } else {
            var nextNode = node.search(c);
            if (nextNode != null) {
                return search(nextNode, word, i + 1);
            }
        }
        return false;
    }

    private static class Node {
        private final Node[] children = new Node[26];
        private boolean endWord;

        private Node getOrCreate(char c) {
            var node = search(c);
            if (node == null) {
                node = new Node();
                children[c - 'a'] = node;
            }
            return node;
        }

        private Node search(char c) {
            return children[c - 'a'];
        }
    }
}