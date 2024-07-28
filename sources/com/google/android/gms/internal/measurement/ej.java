package com.google.android.gms.internal.measurement;

import java.util.Map;

final class ej<K> implements Map.Entry<K, Object> {

    /* renamed from: a  reason: collision with root package name */
    Map.Entry<K, eh> f10616a;

    private ej(Map.Entry<K, eh> entry) {
        this.f10616a = entry;
    }

    public final K getKey() {
        return this.f10616a.getKey();
    }

    public final Object getValue() {
        if (this.f10616a.getValue() == null) {
            return null;
        }
        return eh.a();
    }

    public final Object setValue(Object obj) {
        if (obj instanceof ff) {
            eh value = this.f10616a.getValue();
            ff ffVar = value.f10619b;
            value.f10618a = null;
            value.f10620c = null;
            value.f10619b = (ff) obj;
            return ffVar;
        }
        throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
    }

    /* synthetic */ ej(Map.Entry entry, byte b2) {
        this(entry);
    }
}
