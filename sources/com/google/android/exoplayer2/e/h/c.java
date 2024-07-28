package com.google.android.exoplayer2.e.h;

import com.google.android.exoplayer2.e.b;
import com.google.android.exoplayer2.e.e;
import com.google.android.exoplayer2.g.a;
import java.util.Collections;
import java.util.List;

final class c implements e {

    /* renamed from: a  reason: collision with root package name */
    private final List<b> f31603a;

    public final int a(long j) {
        return j < 0 ? 0 : -1;
    }

    public final int b() {
        return 1;
    }

    public c(List<b> list) {
        this.f31603a = Collections.unmodifiableList(list);
    }

    public final long a_(int i2) {
        a.a(i2 == 0);
        return 0;
    }

    public final List<b> b(long j) {
        return j >= 0 ? this.f31603a : Collections.emptyList();
    }
}
