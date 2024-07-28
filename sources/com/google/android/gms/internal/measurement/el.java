package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;

final class el<K> implements Iterator<Map.Entry<K, Object>> {

    /* renamed from: a  reason: collision with root package name */
    private Iterator<Map.Entry<K, Object>> f10621a;

    public el(Iterator<Map.Entry<K, Object>> it2) {
        this.f10621a = it2;
    }

    public final boolean hasNext() {
        return this.f10621a.hasNext();
    }

    public final void remove() {
        this.f10621a.remove();
    }

    public final /* synthetic */ Object next() {
        Map.Entry next = this.f10621a.next();
        return next.getValue() instanceof eh ? new ej(next, (byte) 0) : next;
    }
}
