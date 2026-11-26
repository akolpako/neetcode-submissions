class WordDictionary {

    private final List<Node> root = List.of(new Node());

    public WordDictionary() {

    }

    public void addWord(String word) {
        Node currNode = root.getFirst();
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
        List<Node> currNodes = new ArrayList(root);
        List<Node> nextNodes = new ArrayList();
        for(int i = 0; i < word.length(); i++) {
            var c = word.charAt(i);
            for (Node currNode : currNodes) {
                nextNodes.addAll(currNode.searchNodes(c));
            }
            
            if (nextNodes.isEmpty()) {
                return List.of();
            }

            currNodes.clear();
            currNodes.addAll(nextNodes);
            nextNodes.clear();
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

        private List<Node> searchNodes(char c) {
            if (c == '.') {
                return Arrays.stream(children)
                    .filter(Objects::nonNull)
                    .toList();
            }
            var node = children[c - 'a'];
            if (node != null) {
                return List.of(node);
            }
            return List.of();
        }
    }
}