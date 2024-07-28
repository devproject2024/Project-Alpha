package com.google.android.gms.internal.p001firebaseperf;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-perf.ga  reason: invalid package */
class ga extends AbstractSet<Map.Entry<K, V>> {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ fq f9661a;

    private ga(fq fqVar) {
        this.f9661a = fqVar;
    }

    public Iterator<Map.Entry<K, V>> iterator() {
        return new fy(this.f9661a, (byte) 0);
    }

    public int size() {
        return this.f9661a.size();
    }

    public boolean contains(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        Object obj2 = this.f9661a.get(entry.getKey());
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
        this.f9661a.remove(entry.getKey());
        return true;
    }

    public void clear() {
        this.f9661a.clear();
    }

    public /* synthetic */ boolean add(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        if (contains(entry)) {
            return false;
        }
        this.f9661a.put((Comparable) entry.getKey(), entry.getValue());
        return true;
    }

    /* synthetic */ ga(fq fqVar, byte b2) {
        this(fqVar);
    }
}
