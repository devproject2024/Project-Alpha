package com.google.android.gms.internal.vision;

import java.util.Iterator;

final class hh implements Iterator<String> {

    /* renamed from: a  reason: collision with root package name */
    private Iterator<String> f11225a = this.f11226b.f11214a.iterator();

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ hf f11226b;

    hh(hf hfVar) {
        this.f11226b = hfVar;
    }

    public final boolean hasNext() {
        return this.f11225a.hasNext();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ Object next() {
        return this.f11225a.next();
    }
}
