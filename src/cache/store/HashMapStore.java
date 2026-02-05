package cache.store;

import java.util.HashMap;
import java.util.Map;

public class HashMapStore<K, V> {

    private final int capacity;
    private final Map<K, V> map = new HashMap<>();

    public HashMapStore(int capacity) {
        this.capacity = capacity;
    }

    public boolean isFull() {
        return map.size() >= capacity;
    }

    public V get(K key) {
        return map.get(key);
    }

    public void put(K key, V value) {
        map.put(key, value);
    }

    public void remove(K key) {
        map.remove(key);
    }
}
