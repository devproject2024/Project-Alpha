package com.google.android.gms.internal.p001firebaseperf;

import java.util.Iterator;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-perf.fy  reason: invalid package */
final class fy implements Iterator<Map.Entry<K, V>> {

    /* renamed from: a  reason: collision with root package name */
    private int f9654a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f9655b;

    /* renamed from: c  reason: collision with root package name */
    private Iterator<Map.Entry<K, V>> f9656c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ fq f9657d;

    private fy(fq fqVar) {
        this.f9657d = fqVar;
        this.f9654a = -1;
    }

    public final boolean hasNext() {
        if (this.f9654a + 1 < this.f9657d.f9639c.size() || (!this.f9657d.f9640d.isEmpty() && a().hasNext())) {
            return true;
        }
        return false;
    }

    public final void remove() {
        if (this.f9655b) {
            this.f9655b = false;
            this.f9657d.e();
            if (this.f9654a < this.f9657d.f9639c.size()) {
                fq fqVar = this.f9657d;
                int i2 = this.f9654a;
                this.f9654a = i2 - 1;
                Object unused = fqVar.c(i2);
                return;
            }
            a().remove();
            return;
        }
        throw new IllegalStateException("remove() was called before next()");
    }

    private final Iterator<Map.Entry<K, V>> a() {
        if (this.f9656c == null) {
            this.f9656c = this.f9657d.f9640d.entrySet().iterator();
        }
        return this.f9656c;
    }

    public final /* synthetic */ Object next() {
        this.f9655b = true;
        int i2 = this.f9654a + 1;
        this.f9654a = i2;
        if (i2 < this.f9657d.f9639c.size()) {
            return (Map.Entry) this.f9657d.f9639c.get(this.f9654a);
        }
        return (Map.Entry) a().next();
    }

    /* synthetic */ fy(fq fqVar, byte b2) {
        this(fqVar);
    }
}
