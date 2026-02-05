package cache.eviction;

import java.util.HashMap;
import java.util.Map;

public class LRUEvictionPolicy<K> implements EvictionPolicy<K> {

    private final Map<K, Node<K>> map = new HashMap<>();
    private Node<K> head;
    private Node<K> tail;

    @Override
    public void keyAccessed(K key) {
        if (map.containsKey(key)) {
            moveToHead(map.get(key));
        } else {
            Node<K> node = new Node<>(key);
            map.put(key, node);
            addToHead(node);
        }
    }

    @Override
    public K evictKey() {
        if (tail == null) return null;
        K key = tail.key;
        removeNode(tail);
        map.remove(key);
        return key;
    }

    private void addToHead(Node<K> node) {
        node.next = head;
        node.prev = null;

        if (head != null) head.prev = node;
        head = node;

        if (tail == null) tail = node;
    }

    private void removeNode(Node<K> node) {
        if (node.prev != null) node.prev.next = node.next;
        else head = node.next;

        if (node.next != null) node.next.prev = node.prev;
        else tail = node.prev;
    }

    private void moveToHead(Node<K> node) {
        removeNode(node);
        addToHead(node);
    }
}
