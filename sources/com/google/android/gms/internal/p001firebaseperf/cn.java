package com.google.android.gms.internal.p001firebaseperf;

import java.util.NoSuchElementException;

/* renamed from: com.google.android.gms.internal.firebase-perf.cn  reason: invalid package */
final class cn extends cp {

    /* renamed from: a  reason: collision with root package name */
    private int f9525a = 0;

    /* renamed from: b  reason: collision with root package name */
    private final int f9526b = this.f9527c.size();

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ co f9527c;

    cn(co coVar) {
        this.f9527c = coVar;
    }

    public final boolean hasNext() {
        return this.f9525a < this.f9526b;
    }

    public final byte a() {
        int i2 = this.f9525a;
        if (i2 < this.f9526b) {
            this.f9525a = i2 + 1;
            return this.f9527c.zzr(i2);
        }
        throw new NoSuchElementException();
    }
}
