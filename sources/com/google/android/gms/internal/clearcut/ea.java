package com.google.android.gms.internal.clearcut;

import java.util.Iterator;

final class ea implements Iterator<String> {

    /* renamed from: a  reason: collision with root package name */
    private Iterator<String> f9327a = this.f9328b.f9314a.iterator();

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ dy f9328b;

    ea(dy dyVar) {
        this.f9328b = dyVar;
    }

    public final boolean hasNext() {
        return this.f9327a.hasNext();
    }

    public final /* synthetic */ Object next() {
        return this.f9327a.next();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
