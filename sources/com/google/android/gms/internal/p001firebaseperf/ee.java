package com.google.android.gms.internal.p001firebaseperf;

import java.util.Iterator;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-perf.ee  reason: invalid package */
final class ee<K> implements Iterator<Map.Entry<K, Object>> {

    /* renamed from: a  reason: collision with root package name */
    private Iterator<Map.Entry<K, Object>> f9586a;

    public ee(Iterator<Map.Entry<K, Object>> it2) {
        this.f9586a = it2;
    }

    public final boolean hasNext() {
        return this.f9586a.hasNext();
    }

    public final void remove() {
        this.f9586a.remove();
    }

    public final /* synthetic */ Object next() {
        Map.Entry next = this.f9586a.next();
        return next.getValue() instanceof ed ? new ef(next, (byte) 0) : next;
    }
}
