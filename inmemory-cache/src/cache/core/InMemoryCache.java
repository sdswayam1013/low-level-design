package cache.core;

import cache.eviction.EvictionPolicy;
import cache.store.HashMapStore;

public class InMemoryCache<K, V> implements Cache<K, V> {

    private final HashMapStore<K, V> store;
    private final EvictionPolicy<K> evictionPolicy;

    public InMemoryCache(HashMapStore<K, V> store,
                         EvictionPolicy<K> evictionPolicy) {
        this.store = store;
        this.evictionPolicy = evictionPolicy;
    }

    @Override
    public synchronized V get(K key) {
        V value = store.get(key);
        if (value != null) {
            evictionPolicy.keyAccessed(key);
        }
        return value;
    }

    @Override
    public synchronized void put(K key, V value) {
        if (store.isFull()) {
            K evictedKey = evictionPolicy.evictKey();
            store.remove(evictedKey);
        }
        store.put(key, value);
        evictionPolicy.keyAccessed(key);
    }
}
