package com.google.android.gms.internal.vision;

import java.util.Iterator;
import java.util.Map;

final class ez<K> implements Iterator<Map.Entry<K, Object>> {

    /* renamed from: a  reason: collision with root package name */
    private Iterator<Map.Entry<K, Object>> f11125a;

    public ez(Iterator<Map.Entry<K, Object>> it2) {
        this.f11125a = it2;
    }

    public final boolean hasNext() {
        return this.f11125a.hasNext();
    }

    public final void remove() {
        this.f11125a.remove();
    }

    public final /* synthetic */ Object next() {
        Map.Entry next = this.f11125a.next();
        return next.getValue() instanceof ev ? new ex(next, (byte) 0) : next;
    }
}
