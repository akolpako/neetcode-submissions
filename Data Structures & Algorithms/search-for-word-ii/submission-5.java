class Solution {

    public List<String> findWords(char[][] board, String[] words) {
        Node trie = buildTrieFrom(words);

        List<String> result = new ArrayList<>();
        var visited = visitedFor(board);

        for(int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                tryVisit(trie, board, i, j, visited, result);
            }
        }

        return result;
    }

    private boolean[][] visitedFor(char[][] board) {
        boolean[][] visited = new boolean[board.length][];
        for(int i = 0; i < board.length; i++) {
            visited[i] = new boolean[board[i].length];
        }
        return visited;
    }

    private void tryVisit(Node node, char[][] board, 
                          int i, int j,
                          boolean[][] visited,
                          List<String> result) {
        if (i >= 0 && i < board.length) {
            var row = board[i];
            if (j >= 0 && j < row.length) {
                if (!visited[i][j]) {
                    char c = board[i][j];
                    Node nextNode = node.search(c);
                    if (nextNode != null) {
                        findWord(nextNode, board, i, j, visited, result);
                        if (nextNode.canBeRemovedFromParent()) {
                            node.remove(c);
                        }
                    }
                }
            }
        }
    }

    private void findWord(Node node, 
                          char[][] board, 
                          int i, int j,
                          boolean[][] visited,
                          List<String> result) {
        if (node.word != null) {
            result.add(node.word);
            node.word = null;
        }

        visited[i][j] = true;

        tryVisit(node, board, i, j - 1, visited, result);
        tryVisit(node, board, i, j + 1, visited, result);
        tryVisit(node, board, i - 1, j, visited, result);
        tryVisit(node, board, i + 1, j, visited, result);

        visited[i][j] = false;
    }

    private Node buildTrieFrom(String[] words) {
        Node trie = new Node();

        for (String word : words) {
            insert(trie, word);
        }

        return trie;
    }

    private void insert(Node root, String word) {
        Node currNode = root;
        for(int i = 0; i < word.length(); i++) {
            var c = word.charAt(i);
            currNode = currNode.getOrCreate(c);
        }
        currNode.word = word;
    }

    private static class Node {
        private final Node[] children = new Node[26];
        private int childrenCount = 0;
        private String word;

        private Node getOrCreate(char c) {
            var node = search(c);
            if (node == null) {
                node = new Node();
                children[c - 'a'] = node;
                childrenCount++;
            }
            return node;
        }

        private Node search(char c) {
            return children[c - 'a'];
        }

        private void remove(char c) {
            children[c - 'a'] = null;
            childrenCount--;
        }

        private boolean canBeRemovedFromParent() {
            return this.word == null && this.hasNoChildren();
        }

        private boolean hasNoChildren() {
            return childrenCount == 0;
        }
    }
}
