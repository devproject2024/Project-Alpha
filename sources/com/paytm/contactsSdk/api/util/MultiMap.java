package com.paytm.contactsSdk.api.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import kotlin.g.b.ab;
import kotlin.g.b.k;
import kotlin.u;

public final class MultiMap<K, V> {
    private Map<K, Collection<V>> map = new HashMap();

    public final void put(K k, V v) {
        if (this.map.get(k) == null) {
            this.map.put(k, new ArrayList());
        }
        Collection<V> collection = this.map.get(k);
        if (collection == null) {
            k.a();
        }
        collection.add(v);
    }

    public final void putIfAbsent(K k, V v) {
        if (this.map.get(k) == null) {
            this.map.put(k, new ArrayList());
        }
        Collection<V> collection = this.map.get(k);
        if (collection == null) {
            k.a();
        }
        if (!collection.contains(v)) {
            Collection<V> collection2 = this.map.get(k);
            if (collection2 == null) {
                k.a();
            }
            collection2.add(v);
        }
    }

    public final Collection<V> get(Object obj) {
        return this.map.get(obj);
    }

    public final Set<K> keySet() {
        return this.map.keySet();
    }

    public final Set<Map.Entry<K, Collection<V>>> entrySet() {
        return this.map.entrySet();
    }

    public final Collection<Collection<V>> values() {
        return this.map.values();
    }

    public final boolean containsKey(Object obj) {
        Map<K, Collection<V>> map2 = this.map;
        if (map2 != null) {
            return map2.containsKey(obj);
        }
        throw new u("null cannot be cast to non-null type kotlin.collections.Map<K, *>");
    }

    public final Collection<V> remove(Object obj) {
        Map<K, Collection<V>> map2 = this.map;
        if (map2 != null) {
            return (Collection) ab.e(map2).remove(obj);
        }
        throw new u("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
    }

    public final int size() {
        int i2 = 0;
        for (Collection next : this.map.values()) {
            if (next == null) {
                k.a();
            }
            i2 += next.size();
        }
        return i2;
    }

    public final boolean isEmpty() {
        return this.map.isEmpty();
    }

    public final void clear() {
        this.map.clear();
    }

    public final boolean remove(K k, V v) {
        if (this.map.get(k) == null) {
            return false;
        }
        Collection<V> collection = this.map.get(k);
        if (collection == null) {
            k.a();
        }
        return collection.remove(v);
    }

    public final boolean replace(K k, V v, V v2) {
        if (this.map.get(k) == null) {
            return false;
        }
        Collection<V> collection = this.map.get(k);
        if (collection == null) {
            k.a();
        }
        if (!collection.remove(v)) {
            return false;
        }
        Collection<V> collection2 = this.map.get(k);
        if (collection2 == null) {
            k.a();
        }
        return collection2.add(v2);
    }
}
