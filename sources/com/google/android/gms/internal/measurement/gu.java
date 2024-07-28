package com.google.android.gms.internal.measurement;

import java.util.Iterator;

final class gu implements Iterator<String> {

    /* renamed from: a  reason: collision with root package name */
    private Iterator<String> f10719a = this.f10720b.f10708a.iterator();

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ gs f10720b;

    gu(gs gsVar) {
        this.f10720b = gsVar;
    }

    public final boolean hasNext() {
        return this.f10719a.hasNext();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ Object next() {
        return this.f10719a.next();
    }
}
