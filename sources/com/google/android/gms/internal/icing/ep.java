package com.google.android.gms.internal.icing;

import java.util.Iterator;

final class ep implements Iterator<String> {

    /* renamed from: a  reason: collision with root package name */
    private Iterator<String> f10223a = this.f10224b.f10212a.iterator();

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ en f10224b;

    ep(en enVar) {
        this.f10224b = enVar;
    }

    public final boolean hasNext() {
        return this.f10223a.hasNext();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ Object next() {
        return this.f10223a.next();
    }
}
