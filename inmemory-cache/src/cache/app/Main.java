package cache.app;

import cache.core.Cache;
import cache.core.InMemoryCache;
import cache.eviction.EvictionPolicy;
import cache.eviction.LRUEvictionPolicy;
import cache.store.HashMapStore;

public class Main {
    public static void main(String[] args) {

        HashMapStore<Integer, String> store =
                new HashMapStore<>(2);

        EvictionPolicy<Integer> evictionPolicy =
                new LRUEvictionPolicy<>();

        Cache<Integer, String> cache =
                new InMemoryCache<>(store, evictionPolicy);

        cache.put(1, "A");
        cache.put(2, "B");
        cache.get(1);
        cache.put(3, "C"); // it will evict key 2

        System.out.println(cache.get(2)); // will give the null value
        System.out.println(cache.get(1)); // output:A
    }
}
