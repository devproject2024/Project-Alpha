package com.google.android.gms.measurement.internal;

import java.util.Iterator;

final class m implements Iterator<String> {

    /* renamed from: a  reason: collision with root package name */
    private Iterator<String> f12344a = this.f12345b.f12367a.keySet().iterator();

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ zzam f12345b;

    m(zzam zzam) {
        this.f12345b = zzam;
    }

    public final boolean hasNext() {
        return this.f12344a.hasNext();
    }

    public final void remove() {
        throw new UnsupportedOperationException("Remove not supported");
    }

    public final /* synthetic */ Object next() {
        return this.f12344a.next();
    }
}
