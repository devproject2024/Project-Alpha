package com.google.android.gms.internal.firebase_ml;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

class is extends AbstractSet<Map.Entry<K, V>> {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ il f10014a;

    private is(il ilVar) {
        this.f10014a = ilVar;
    }

    public Iterator<Map.Entry<K, V>> iterator() {
        return new it(this.f10014a, (byte) 0);
    }

    public int size() {
        return this.f10014a.size();
    }

    public boolean contains(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        Object obj2 = this.f10014a.get(entry.getKey());
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
        this.f10014a.remove(entry.getKey());
        return true;
    }

    public void clear() {
        this.f10014a.clear();
    }

    public /* synthetic */ boolean add(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        if (contains(entry)) {
            return false;
        }
        this.f10014a.put((Comparable) entry.getKey(), entry.getValue());
        return true;
    }

    /* synthetic */ is(il ilVar, byte b2) {
        this(ilVar);
    }
}
