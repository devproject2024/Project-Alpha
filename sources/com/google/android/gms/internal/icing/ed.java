package com.google.android.gms.internal.icing;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

class ed extends AbstractSet<Map.Entry<K, V>> {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ dw f10197a;

    private ed(dw dwVar) {
        this.f10197a = dwVar;
    }

    public Iterator<Map.Entry<K, V>> iterator() {
        return new ee(this.f10197a, (byte) 0);
    }

    public int size() {
        return this.f10197a.size();
    }

    public boolean contains(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        Object obj2 = this.f10197a.get(entry.getKey());
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
        this.f10197a.remove(entry.getKey());
        return true;
    }

    public void clear() {
        this.f10197a.clear();
    }

    public /* synthetic */ boolean add(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        if (contains(entry)) {
            return false;
        }
        this.f10197a.put((Comparable) entry.getKey(), entry.getValue());
        return true;
    }

    /* synthetic */ ed(dw dwVar, byte b2) {
        this(dwVar);
    }
}
