package com.google.android.gms.internal.clearcut;

import java.util.Map;

final class br<K> implements Map.Entry<K, Object> {

    /* renamed from: a  reason: collision with root package name */
    Map.Entry<K, bq> f9213a;

    private br(Map.Entry<K, bq> entry) {
        this.f9213a = entry;
    }

    /* synthetic */ br(Map.Entry entry, byte b2) {
        this(entry);
    }

    public final K getKey() {
        return this.f9213a.getKey();
    }

    public final Object getValue() {
        if (this.f9213a.getValue() == null) {
            return null;
        }
        return bq.a();
    }

    public final Object setValue(Object obj) {
        if (obj instanceof cm) {
            bq value = this.f9213a.getValue();
            cm cmVar = value.f9217b;
            value.f9216a = null;
            value.f9218c = null;
            value.f9217b = (cm) obj;
            return cmVar;
        }
        throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
    }
}
