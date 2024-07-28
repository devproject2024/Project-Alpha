package com.google.android.gms.internal.p001firebaseperf;

import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-perf.ef  reason: invalid package */
final class ef<K> implements Map.Entry<K, Object> {

    /* renamed from: a  reason: collision with root package name */
    Map.Entry<K, ed> f9587a;

    private ef(Map.Entry<K, ed> entry) {
        this.f9587a = entry;
    }

    public final K getKey() {
        return this.f9587a.getKey();
    }

    public final Object getValue() {
        if (this.f9587a.getValue() == null) {
            return null;
        }
        return ed.a();
    }

    public final Object setValue(Object obj) {
        if (obj instanceof ex) {
            ed value = this.f9587a.getValue();
            ex exVar = value.f9593b;
            value.f9592a = null;
            value.f9594c = null;
            value.f9593b = (ex) obj;
            return exVar;
        }
        throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
    }

    /* synthetic */ ef(Map.Entry entry, byte b2) {
        this(entry);
    }
}
