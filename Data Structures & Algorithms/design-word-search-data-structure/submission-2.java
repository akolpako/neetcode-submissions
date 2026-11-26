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
        return searchNodes(word)
            .stream()
            .anyMatch(n -> n.endWord);
    }

    private List<Node> searchNodes(String word) {
        List<Node> currNodes = new ArrayList<>();
        currNodes.add(root);
        List<Node> nextNodes = new ArrayList<>();
        for(int i = 0; i < word.length(); i++) {
            var c = word.charAt(i);
            for (Node currNode : currNodes) {
                currNode.searchNodes(c, nextNodes);
            }
            
            if (nextNodes.isEmpty()) {
                return List.of();
            }

            currNodes = nextNodes;
            nextNodes = new ArrayList<>();
        }

        return currNodes;
    }

    private static class Node {
        private final Node[] children = new Node[26];
        private boolean endWord;

        private Node getOrCreate(char c) {
            var node = searchSingleNode(c);
            if (node == null) {
                node = new Node();
                children[c - 'a'] = node;
            }
            return node;
        }

        private Node searchSingleNode(char c) {
            return children[c - 'a'];
        }

        private void searchNodes(char c, List<Node> result) {
            if (c == '.') {
                for (Node node : children) {
                    if (node != null) {
                        result.add(node);
                    }
                }
            } else {
                var node = searchSingleNode(c);
                if (node != null) {
                    result.add(node);
                }
            }
        }
    }
}