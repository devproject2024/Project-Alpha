package com.google.android.gms.internal.clearcut;

import java.util.Iterator;
import java.util.Map;

final class bs<K> implements Iterator<Map.Entry<K, Object>> {

    /* renamed from: a  reason: collision with root package name */
    private Iterator<Map.Entry<K, Object>> f9214a;

    public bs(Iterator<Map.Entry<K, Object>> it2) {
        this.f9214a = it2;
    }

    public final boolean hasNext() {
        return this.f9214a.hasNext();
    }

    public final /* synthetic */ Object next() {
        Map.Entry next = this.f9214a.next();
        return next.getValue() instanceof bq ? new br(next, (byte) 0) : next;
    }

    public final void remove() {
        this.f9214a.remove();
    }
}
