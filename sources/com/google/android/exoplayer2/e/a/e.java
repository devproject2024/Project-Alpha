package com.google.android.exoplayer2.e.a;

import com.google.android.exoplayer2.e.b;
import com.google.android.exoplayer2.g.a;
import java.util.Collections;
import java.util.List;

final class e implements com.google.android.exoplayer2.e.e {

    /* renamed from: a  reason: collision with root package name */
    private final List<b> f31443a;

    public final int a(long j) {
        return j < 0 ? 0 : -1;
    }

    public final int b() {
        return 1;
    }

    public e(List<b> list) {
        this.f31443a = list;
    }

    public final long a_(int i2) {
        a.a(i2 == 0);
        return 0;
    }

    public final List<b> b(long j) {
        return j >= 0 ? this.f31443a : Collections.emptyList();
    }
}
