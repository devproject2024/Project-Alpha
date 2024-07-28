package com.google.android.gms.internal.p001firebaseperf;

import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.firebase-perf.ht  reason: invalid package */
public final class ht<K, V> {

    /* renamed from: a  reason: collision with root package name */
    int f9699a;

    /* renamed from: b  reason: collision with root package name */
    private Object[] f9700b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f9701c;

    public ht() {
        this(4);
    }

    ht(int i2) {
        this.f9700b = new Object[(i2 * 2)];
        this.f9699a = 0;
        this.f9701c = false;
    }

    /* access modifiers changed from: package-private */
    public final void a(int i2) {
        int i3 = i2 << 1;
        Object[] objArr = this.f9700b;
        if (i3 > objArr.length) {
            this.f9700b = Arrays.copyOf(objArr, hn.a(objArr.length, i3));
            this.f9701c = false;
        }
    }

    public final ht<K, V> a(K k, V v) {
        a(this.f9699a + 1);
        hj.a((Object) k, (Object) v);
        Object[] objArr = this.f9700b;
        int i2 = this.f9699a;
        objArr[i2 * 2] = k;
        objArr[(i2 * 2) + 1] = v;
        this.f9699a = i2 + 1;
        return this;
    }

    public final hq<K, V> a() {
        this.f9701c = true;
        return hu.zza(this.f9699a, this.f9700b);
    }
}
