class LFUCache {

    class Node {
        int key, value, freq;
        Node prev, next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }

    class DLL {
        Node head, tail;
        int size;

        DLL() {
            head = new Node(0, 0);
            tail = new Node(0, 0);

            head.next = tail;
            tail.prev = head;
        }

        void add(Node node) {
            node.next = head.next;
            node.prev = head;

            head.next.prev = node;
            head.next = node;

            size++;
        }

        void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;

            size--;
        }

        Node removeLast() {
            if (size == 0) return null;

            Node node = tail.prev;
            remove(node);

            return node;
        }
    }

    int capacity;
    int minFreq;

    HashMap<Integer, Node> nodeMap;
    HashMap<Integer, DLL> freqMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        minFreq = 0;

        nodeMap = new HashMap<>();
        freqMap = new HashMap<>();
    }

    private void updateFreq(Node node) {

        int freq = node.freq;

        DLL list = freqMap.get(freq);
        list.remove(node);

        if (freq == minFreq && list.size == 0) {
            minFreq++;
        }

        node.freq++;

        freqMap.putIfAbsent(node.freq, new DLL());
        freqMap.get(node.freq).add(node);
    }

    public int get(int key) {

        if (!nodeMap.containsKey(key)) {
            return -1;
        }

        Node node = nodeMap.get(key);

        updateFreq(node);

        return node.value;
    }

    public void put(int key, int value) {

        if (capacity == 0) return;

        if (nodeMap.containsKey(key)) {

            Node node = nodeMap.get(key);

            node.value = value;

            updateFreq(node);

            return;
        }

        if (nodeMap.size() == capacity) {

            DLL list = freqMap.get(minFreq);

            Node removeNode = list.removeLast();

            nodeMap.remove(removeNode.key);
        }

        Node node = new Node(key, value);

        minFreq = 1;

        freqMap.putIfAbsent(1, new DLL());
        freqMap.get(1).add(node);

        nodeMap.put(key, node);
    }
}