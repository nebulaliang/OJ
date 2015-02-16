package LRUCache;

import java.util.HashMap;

public class LRUCache {
    private class DoublyNode {
        private int key;
        private int value;
        private DoublyNode next;
        private DoublyNode prev;

        public DoublyNode(int key, int val) {
            this.key = key;
            this.value = val;
            this.next = null;
            this.prev = null;
        }
    }

    private int capacity = 0;
    private HashMap<Integer, DoublyNode> map = new HashMap<Integer, DoublyNode>();
    private DoublyNode head = new DoublyNode(-1, -1);
    private DoublyNode tail = new DoublyNode(-1, -1);

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    private void move_to_tail(DoublyNode node) {
        DoublyNode last = tail.prev;
        last.next = node;
        node.prev = last;
        node.next = tail;
        tail.prev = node;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            DoublyNode node = map.get(key);
            // delete current
            DoublyNode prev = node.prev;
            DoublyNode next = node.next;
            prev.next = next;
            next.prev = prev;

            move_to_tail(node);
            return node.value;

        } else {
            return -1;
        }
    }

    public void set(int key, int value) {
        if (this.get(key) != -1) {
            map.get(key).value = value;
            return;
        }
        if (map.size() == capacity) {
            // delete the first node
            map.remove(head.next.key);
            head.next = head.next.next;
            head.next.prev = head;
        }
        DoublyNode node = new DoublyNode(key, value);
        map.put(key, node);
        move_to_tail(node);
    }
}
