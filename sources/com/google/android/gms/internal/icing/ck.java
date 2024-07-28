package com.google.android.gms.internal.icing;

import java.util.Map;

final class ck<K> implements Map.Entry<K, Object> {

    /* renamed from: a  reason: collision with root package name */
    Map.Entry<K, ci> f10128a;

    private ck(Map.Entry<K, ci> entry) {
        this.f10128a = entry;
    }

    public final K getKey() {
        return this.f10128a.getKey();
    }

    public final Object getValue() {
        if (this.f10128a.getValue() == null) {
            return null;
        }
        return ci.a();
    }

    public final Object setValue(Object obj) {
        if (obj instanceof dd) {
            ci value = this.f10128a.getValue();
            dd ddVar = value.f10134b;
            value.f10133a = null;
            value.f10135c = null;
            value.f10134b = (dd) obj;
            return ddVar;
        }
        throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
    }

    /* synthetic */ ck(Map.Entry entry, byte b2) {
        this(entry);
    }
}
