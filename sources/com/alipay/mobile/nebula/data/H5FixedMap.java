package com.alipay.mobile.nebula.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class H5FixedMap<K, V> {
    private List<K> keyList;
    private HashMap<K, V> map;
    private int sizeLimit;

    public H5FixedMap(int i2) {
        if (i2 > 0) {
            this.sizeLimit = i2;
            this.map = new HashMap<>(i2);
            this.keyList = new ArrayList(i2);
            return;
        }
        throw new IllegalArgumentException("invalid size");
    }

    public synchronized V get(K k) {
        if (!this.map.containsKey(k)) {
            return null;
        }
        this.keyList.remove(k);
        this.keyList.add(0, k);
        return this.map.get(k);
    }

    public synchronized void set(K k, V v) {
        if (!this.map.containsKey(k)) {
            if (this.map.size() >= this.sizeLimit) {
                this.map.remove(this.keyList.remove(this.map.size() - 1));
            }
            this.keyList.add(0, k);
            this.map.put(k, v);
        }
    }

    public void remove(K k) {
        if (this.map.containsKey(k)) {
            this.map.remove(k);
            this.keyList.remove(k);
        }
    }
}
