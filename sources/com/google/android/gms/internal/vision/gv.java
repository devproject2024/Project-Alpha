package com.google.android.gms.internal.vision;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

class gv extends AbstractSet<Map.Entry<K, V>> {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ gn f11199a;

    private gv(gn gnVar) {
        this.f11199a = gnVar;
    }

    public Iterator<Map.Entry<K, V>> iterator() {
        return new gw(this.f11199a, (byte) 0);
    }

    public int size() {
        return this.f11199a.size();
    }

    public boolean contains(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        Object obj2 = this.f11199a.get(entry.getKey());
        Object value = entry.getValue();
        if (obj2 != value) {
            return obj2 != null && obj2.equals(value);
        }
        return true;
    }

    public boolean remove(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        if (!contains(entry)) {
            return false;
        }
        this.f11199a.remove(entry.getKey());
        return true;
    }

    public void clear() {
        this.f11199a.clear();
    }

    public /* synthetic */ boolean add(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        if (contains(entry)) {
            return false;
        }
        this.f11199a.put((Comparable) entry.getKey(), entry.getValue());
        return true;
    }

    /* synthetic */ gv(gn gnVar, byte b2) {
        this(gnVar);
    }
}
