class MyHashMap {

    private static class Node {
        int key;
        int value;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private static class LinkedList {
        Node head = null;
        Node tail = null;

        void put(int key, int value) {
            Node temp = head;
            while (temp != null) {
                if (temp.key == key) {
                    temp.value = value;
                    return;
                }
                temp = temp.next;
            }

            Node newNode = new Node(key, value);
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

        int get(int key) {
            Node temp = head;
            while (temp != null) {
                if (temp.key == key) {
                    return temp.value;
                }
                temp = temp.next;
            }
            return -1;
        }
    }

    private static final int SIZE = 1000;
    private LinkedList[] map;

    public MyHashMap() {
        map = new LinkedList[SIZE];
    }

    private int hash(int key) {
        return key % SIZE;
    }

    public void put(int key, int value) {
        int index = hash(key);
        if (map[index] == null) {
            map[index] = new LinkedList();
        }
        map[index].put(key, value);
    }

    public int get(int key) {
        int index = hash(key);
        if (map[index] == null) {
            return -1;
        }
        return map[index].get(key);
    }

    public void remove(int key) {
        int index = hash(key);
        if (map[index] != null) {
            map[index].remove(key);
        }
    }
}
