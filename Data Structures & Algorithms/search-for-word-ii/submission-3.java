class Solution {

    public List<String> findWords(char[][] board, String[] words) {
        Node trie = buildTrieFrom(words);

        List<String> result = new ArrayList<>();
        var visited = visitedFor(board);

        for(int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                startWordSearch(trie, board, i, j, visited, result);
            }
        }

        return result;
    }

    private void startWordSearch(Node root, 
                                char[][] board, 
                                int i, int j, 
                                boolean[][] visited,
                                List<String> result) {
        Node[] nextNodes = root.children;

        for (int n = 0; n < nextNodes.length; n++) {
            var nextNode = nextNodes[n];
            if (nextNode != null) {
                char c = wordFromIndex(n);
                if (canBeVisited(board, c, i, j, visited)) {
                    findWord(nextNode, board, i, j, "" + c, visited, result);
                }
            }
        }
    }

    private char wordFromIndex(int index) {
        return (char) ('a' + index);
    }

    private boolean[][] visitedFor(char[][] board) {
        boolean[][] visited = new boolean[board.length][];
        for(int i = 0; i < board.length; i++) {
            visited[i] = new boolean[board[i].length];
        }
        return visited;
    }

    private void findWord(Node node, 
                            char[][] board, 
                            int i, int j, 
                            String word,
                            boolean[][] visited,
                            List<String> result) {
            if (node.endWord) {
                node.endWord = false;
                result.add(word);
            }

            visited[i][j] = true;

            Node[] nextNodes = node.children;

            for (int n = 0; n < nextNodes.length; n++) {
                var nextNode = nextNodes[n];
                if (nextNode != null) {
                    char c = wordFromIndex(n);

                    if (canBeVisited(board, c, i, j - 1, visited)) {
                        findWord(nextNode, board, i, j - 1, word + c, visited, result);
                    }

                    if (canBeVisited(board, c, i, j + 1, visited)) {
                        findWord(nextNode, board, i, j + 1, word + c, visited, result);
                    }

                    if (canBeVisited(board, c, i - 1, j, visited)) {
                        findWord(nextNode, board, i - 1, j, word + c, visited, result);
                    }

                    if (canBeVisited(board, c, i + 1, j, visited)) {
                        findWord(nextNode, board, i + 1, j, word + c, visited, result);
                    }
                }
            }

            visited[i][j] = false;
    }

    private boolean canBeVisited(char[][] board, char c, int i, int j, boolean[][] visited) {
        if (i >= 0 && i < board.length) {
            var row = board[i];
            if (j >= 0 && j < row.length) {
                if (!visited[i][j] && board[i][j] == c) {
                    return true;
                }
            }
        }
        return false;
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
        currNode.endWord = true;
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
