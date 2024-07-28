package com.google.android.gms.internal.vision;

import java.util.Map;

final class ex<K> implements Map.Entry<K, Object> {

    /* renamed from: a  reason: collision with root package name */
    Map.Entry<K, ev> f11120a;

    private ex(Map.Entry<K, ev> entry) {
        this.f11120a = entry;
    }

    public final K getKey() {
        return this.f11120a.getKey();
    }

    public final Object getValue() {
        if (this.f11120a.getValue() == null) {
            return null;
        }
        return ev.a();
    }

    public final Object setValue(Object obj) {
        if (obj instanceof ft) {
            ev value = this.f11120a.getValue();
            ft ftVar = value.f11123b;
            value.f11122a = null;
            value.f11124c = null;
            value.f11123b = (ft) obj;
            return ftVar;
        }
        throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
    }

    /* synthetic */ ex(Map.Entry entry, byte b2) {
        this(entry);
    }
}
