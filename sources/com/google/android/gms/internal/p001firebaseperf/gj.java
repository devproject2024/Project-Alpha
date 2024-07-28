package com.google.android.gms.internal.p001firebaseperf;

import java.util.Iterator;

/* renamed from: com.google.android.gms.internal.firebase-perf.gj  reason: invalid package */
final class gj implements Iterator<String> {

    /* renamed from: a  reason: collision with root package name */
    private Iterator<String> f9670a = this.f9671b.f9669a.iterator();

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ gh f9671b;

    gj(gh ghVar) {
        this.f9671b = ghVar;
    }

    public final boolean hasNext() {
        return this.f9670a.hasNext();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ Object next() {
        return this.f9670a.next();
    }
}
