package com.google.android.gms.internal.measurement;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

class gh extends AbstractSet<Map.Entry<K, V>> {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ ga f10693a;

    private gh(ga gaVar) {
        this.f10693a = gaVar;
    }

    public Iterator<Map.Entry<K, V>> iterator() {
        return new gi(this.f10693a, (byte) 0);
    }

    public int size() {
        return this.f10693a.size();
    }

    public boolean contains(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        Object obj2 = this.f10693a.get(entry.getKey());
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
        this.f10693a.remove(entry.getKey());
        return true;
    }

    public void clear() {
        this.f10693a.clear();
    }

    public /* synthetic */ boolean add(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        if (contains(entry)) {
            return false;
        }
        this.f10693a.put((Comparable) entry.getKey(), entry.getValue());
        return true;
    }

    /* synthetic */ gh(ga gaVar, byte b2) {
        this(gaVar);
    }
}
