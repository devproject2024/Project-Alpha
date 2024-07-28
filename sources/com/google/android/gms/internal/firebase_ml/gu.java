package com.google.android.gms.internal.firebase_ml;

import java.util.Iterator;
import java.util.Map;

final class gu<K> implements Iterator<Map.Entry<K, Object>> {

    /* renamed from: a  reason: collision with root package name */
    private Iterator<Map.Entry<K, Object>> f9940a;

    public gu(Iterator<Map.Entry<K, Object>> it2) {
        this.f9940a = it2;
    }

    public final boolean hasNext() {
        return this.f9940a.hasNext();
    }

    public final void remove() {
        this.f9940a.remove();
    }

    public final /* synthetic */ Object next() {
        Map.Entry next = this.f9940a.next();
        return next.getValue() instanceof gt ? new gv(next, (byte) 0) : next;
    }
}
