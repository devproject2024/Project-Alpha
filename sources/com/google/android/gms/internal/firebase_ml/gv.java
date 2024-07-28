package com.google.android.gms.internal.firebase_ml;

import java.util.Map;

final class gv<K> implements Map.Entry<K, Object> {

    /* renamed from: a  reason: collision with root package name */
    Map.Entry<K, gt> f9941a;

    private gv(Map.Entry<K, gt> entry) {
        this.f9941a = entry;
    }

    public final K getKey() {
        return this.f9941a.getKey();
    }

    public final Object getValue() {
        if (this.f9941a.getValue() == null) {
            return null;
        }
        return gt.a();
    }

    public final Object setValue(Object obj) {
        if (obj instanceof hn) {
            gt value = this.f9941a.getValue();
            hn hnVar = value.f9947b;
            value.f9946a = null;
            value.f9948c = null;
            value.f9947b = (hn) obj;
            return hnVar;
        }
        throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
    }

    /* synthetic */ gv(Map.Entry entry, byte b2) {
        this(entry);
    }
}
