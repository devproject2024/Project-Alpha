package com.google.android.exoplayer2.e.g;

import com.google.android.exoplayer2.e.e;
import com.google.android.exoplayer2.g.a;
import java.util.Collections;
import java.util.List;

final class b implements e {

    /* renamed from: a  reason: collision with root package name */
    public static final b f31592a = new b();

    /* renamed from: b  reason: collision with root package name */
    private final List<com.google.android.exoplayer2.e.b> f31593b;

    public final int a(long j) {
        return j < 0 ? 0 : -1;
    }

    public final int b() {
        return 1;
    }

    public b(com.google.android.exoplayer2.e.b bVar) {
        this.f31593b = Collections.singletonList(bVar);
    }

    private b() {
        this.f31593b = Collections.emptyList();
    }

    public final long a_(int i2) {
        a.a(i2 == 0);
        return 0;
    }

    public final List<com.google.android.exoplayer2.e.b> b(long j) {
        return j >= 0 ? this.f31593b : Collections.emptyList();
    }
}
