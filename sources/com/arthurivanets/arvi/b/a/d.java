package com.arthurivanets.arvi.b.a;

import java.util.HashMap;
import java.util.Map;

final class d<K, V> implements a<K, V> {

    /* renamed from: a  reason: collision with root package name */
    private final Map<K, V> f30995a = new HashMap();

    d() {
    }

    public final V a(K k, V v) {
        return this.f30995a.put(k, v);
    }

    public final V b(K k, V v) {
        return b(k) ? this.f30995a.get(k) : v;
    }

    private boolean b(K k) {
        return this.f30995a.get(k) != null;
    }

    public final V a(K k) {
        if (b(k)) {
            return this.f30995a.remove(k);
        }
        return null;
    }
}
