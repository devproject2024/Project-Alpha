package com.google.android.gms.internal.p001firebaseperf;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-perf.fs  reason: invalid package */
final class fs implements Iterator<Map.Entry<K, V>> {

    /* renamed from: a  reason: collision with root package name */
    private int f9648a;

    /* renamed from: b  reason: collision with root package name */
    private Iterator<Map.Entry<K, V>> f9649b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ fq f9650c;

    private fs(fq fqVar) {
        this.f9650c = fqVar;
        this.f9648a = this.f9650c.f9639c.size();
    }

    public final boolean hasNext() {
        int i2 = this.f9648a;
        return (i2 > 0 && i2 <= this.f9650c.f9639c.size()) || a().hasNext();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    private final Iterator<Map.Entry<K, V>> a() {
        if (this.f9649b == null) {
            this.f9649b = this.f9650c.f9642f.entrySet().iterator();
        }
        return this.f9649b;
    }

    public final /* synthetic */ Object next() {
        if (a().hasNext()) {
            return (Map.Entry) a().next();
        }
        List b2 = this.f9650c.f9639c;
        int i2 = this.f9648a - 1;
        this.f9648a = i2;
        return (Map.Entry) b2.get(i2);
    }

    /* synthetic */ fs(fq fqVar, byte b2) {
        this(fqVar);
    }
}
