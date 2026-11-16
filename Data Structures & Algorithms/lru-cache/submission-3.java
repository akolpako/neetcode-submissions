class LRUCache {

    private final Map<Integer, Node> index;
    private final int capacity;
    private Node tail;
    private Node head;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        index = HashMap.newHashMap(capacity);
    }
    
    public int get(int key) {
        var node = touch(key);
        if (node != null) {
            return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        Node existing = touch(key);
        if (existing == null) {
            evictIfFull();
            Node newNode = new Node(key, value);
            putToHead(newNode);
            index.put(key, newNode);
        } else {
            existing.value = value;
        }
    }

    private Node touch(int key) {
        var node = index.get(key);
        if (node != null) {
            cutAndPutToHead(node);
            return node;
        }
        return null;
    }

    private void evictIfFull() {
        if (index.size() == capacity) {
            index.remove(tail.key);
            cutFromList(tail);
        }
    }

    private void cutAndPutToHead(Node node) {
        cutFromList(node);
        putToHead(node);
    }

    private void cutFromList(Node node) {
        if (node.prev != null) {
            node.prev.next = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        }
        if (node == tail) {
            tail = node.next;
        }
        if (node == head) {
            head = node.prev;
        }
        node.next = null;
        node.prev = null;
    }

    private void putToHead(Node node) {
        if (tail == null) {
            tail = node;
        } else {
            head.next = node;
            node.prev = head;
        }
        head = node;
    }

    private static class Node{
        int key;
        int value;
        Node prev;
        Node next;
        private Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
