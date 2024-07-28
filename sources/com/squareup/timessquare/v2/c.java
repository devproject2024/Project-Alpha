package com.squareup.timessquare.v2;

import java.util.LinkedHashMap;
import java.util.Map;

final class c<K, V> extends LinkedHashMap<K, V> {
    private int index = 0;
    private final Map<Integer, K> indexToKey = new LinkedHashMap();
    private final Map<K, Integer> keyToIndex = new LinkedHashMap();

    c() {
    }

    public final V put(K k, V v) {
        this.indexToKey.put(Integer.valueOf(this.index), k);
        this.keyToIndex.put(k, Integer.valueOf(this.index));
        this.index++;
        return super.put(k, v);
    }

    public final void clear() {
        super.clear();
        this.index = 0;
        this.indexToKey.clear();
        this.keyToIndex.clear();
    }

    public final V remove(Object obj) {
        throw new UnsupportedOperationException("IndexedLinkedHashMap is put/clear only");
    }

    /* access modifiers changed from: package-private */
    public final V getValueAtIndex(int i2) {
        return get(this.indexToKey.get(Integer.valueOf(i2)));
    }

    /* access modifiers changed from: package-private */
    public final int getIndexOfKey(K k) {
        return this.keyToIndex.get(k).intValue();
    }
}
