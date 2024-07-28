package com.google.android.exoplayer2.e.d;

import com.google.android.exoplayer2.e.e;
import com.google.android.exoplayer2.g.a;
import com.google.android.exoplayer2.g.ae;
import java.util.Collections;
import java.util.List;

final class b implements e {

    /* renamed from: a  reason: collision with root package name */
    private final com.google.android.exoplayer2.e.b[] f31531a;

    /* renamed from: b  reason: collision with root package name */
    private final long[] f31532b;

    public b(com.google.android.exoplayer2.e.b[] bVarArr, long[] jArr) {
        this.f31531a = bVarArr;
        this.f31532b = jArr;
    }

    public final int a(long j) {
        int a2 = ae.a(this.f31532b, j, false, false);
        if (a2 < this.f31532b.length) {
            return a2;
        }
        return -1;
    }

    public final int b() {
        return this.f31532b.length;
    }

    public final long a_(int i2) {
        boolean z = true;
        a.a(i2 >= 0);
        if (i2 >= this.f31532b.length) {
            z = false;
        }
        a.a(z);
        return this.f31532b[i2];
    }

    public final List<com.google.android.exoplayer2.e.b> b(long j) {
        int a2 = ae.a(this.f31532b, j, false);
        if (a2 == -1 || this.f31531a[a2] == com.google.android.exoplayer2.e.b.f31445a) {
            return Collections.emptyList();
        }
        return Collections.singletonList(this.f31531a[a2]);
    }
}
