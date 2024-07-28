package com.google.android.gms.internal.icing;

import java.util.Iterator;
import java.util.Map;

final class cj<K> implements Iterator<Map.Entry<K, Object>> {

    /* renamed from: a  reason: collision with root package name */
    private Iterator<Map.Entry<K, Object>> f10127a;

    public cj(Iterator<Map.Entry<K, Object>> it2) {
        this.f10127a = it2;
    }

    public final boolean hasNext() {
        return this.f10127a.hasNext();
    }

    public final void remove() {
        this.f10127a.remove();
    }

    public final /* synthetic */ Object next() {
        Map.Entry next = this.f10127a.next();
        return next.getValue() instanceof ci ? new ck(next, (byte) 0) : next;
    }
}
