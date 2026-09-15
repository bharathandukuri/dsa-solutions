class MyHashSet {

    private static class Node {
        int key;
        Node next;

        Node(int key) {
            this.key = key;
        }

        Node(int key, Node next) {
            this.key = key;
            this.next = next;
        }
    }

    private static class LinkedList {
        Node head = null;
        Node tail = null;

        void add(int key) {
            if (contains(key)) return;
            Node newNode = new Node(key);
            if (head == null) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        void remove(int key) {
            while (head != null && head.key == key) {
                head = head.next;
            }

            Node current = head;
            while (current != null && current.next != null) {
                if (current.next.key == key) {
                    current.next = current.next.next;
                    if (current.next == null) {
                        tail = current;
                    }
                } else {
                    current = current.next;
                }
            }

            if (head == null) {
                tail = null;
            }
        }

        boolean contains(int key) {
            Node temp = head;
            while (temp != null) {
                if (temp.key == key) {
                    return true;
                }
                temp = temp.next;
            }
            return false;
        }
    }

    private LinkedList[] buckets;
    private int capacity;
    private int size;
    private final double LOAD_FACTOR = 0.75;

    public MyHashSet() {
        capacity = 10;
        buckets = new LinkedList[capacity];
        size = 0;
    }

    private int hash(int key) {
        return key % capacity;
    }

    private void checkLoadFactorAndResize() {
        if ((double) size / capacity > LOAD_FACTOR) {
            int oldCapacity = capacity;
            capacity *= 2;
            LinkedList[] oldBuckets = buckets;
            buckets = new LinkedList[capacity];
            size = 0;
            for (int i = 0; i < oldCapacity; i++) {
                LinkedList list = oldBuckets[i];
                if (list != null) {
                    Node current = list.head;
                    while (current != null) {
                        add(current.key);
                        current = current.next;
                    }
                }
            }
        }
    }

    public void add(int key) {
        int index = hash(key);
        if (buckets[index] == null) {
            buckets[index] = new LinkedList();
        }
        if (!buckets[index].contains(key)) {
            buckets[index].add(key);
            size++;
            checkLoadFactorAndResize();
        }
    }

    public void remove(int key) {
        int index = hash(key);
        if (buckets[index] != null && buckets[index].contains(key)) {
            buckets[index].remove(key);
            size--;
        }
    }

    public boolean contains(int key) {
        int index = hash(key);
        return buckets[index] != null && buckets[index].contains(key);
    }
}