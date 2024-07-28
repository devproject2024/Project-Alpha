package com.google.android.gms.internal.firebase_ml;

import java.util.Iterator;

final class e implements Iterator<String> {

    /* renamed from: a  reason: collision with root package name */
    private Iterator<String> f9839a = this.f9840b.f9772a.iterator();

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ c f9840b;

    e(c cVar) {
        this.f9840b = cVar;
    }

    public final boolean hasNext() {
        return this.f9839a.hasNext();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ Object next() {
        return this.f9839a.next();
    }
}
