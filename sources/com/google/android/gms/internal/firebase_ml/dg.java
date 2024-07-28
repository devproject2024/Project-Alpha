package com.google.android.gms.internal.firebase_ml;

import java.util.HashMap;
import java.util.Map;

public abstract class dg<K, V> {

    /* renamed from: a  reason: collision with root package name */
    private final Map<K, V> f9797a = new HashMap();

    /* access modifiers changed from: protected */
    public abstract V b(K k);

    public final V a(K k) {
        synchronized (this.f9797a) {
            if (this.f9797a.containsKey(k)) {
                V v = this.f9797a.get(k);
                return v;
            }
            V b2 = b(k);
            this.f9797a.put(k, b2);
            return b2;
        }
    }
}
