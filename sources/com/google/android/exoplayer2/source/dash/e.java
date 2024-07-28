package com.google.android.exoplayer2.source.dash;

import com.google.android.exoplayer2.extractor.b;
import com.google.android.exoplayer2.source.dash.a.h;

public final class e implements d {

    /* renamed from: a  reason: collision with root package name */
    private final b f32993a;

    /* renamed from: b  reason: collision with root package name */
    private final long f32994b;

    public final long a() {
        return 0;
    }

    public final boolean b() {
        return true;
    }

    public e(b bVar, long j) {
        this.f32993a = bVar;
        this.f32994b = j;
    }

    public final int c(long j) {
        return this.f32993a.f31681a;
    }

    public final long a(long j) {
        return this.f32993a.f31685e[(int) j] - this.f32994b;
    }

    public final long b(long j, long j2) {
        return this.f32993a.f31684d[(int) j];
    }

    public final h b(long j) {
        int i2 = (int) j;
        return new h((String) null, this.f32993a.f31683c[i2], (long) this.f32993a.f31682b[i2]);
    }

    public final long a(long j, long j2) {
        return (long) this.f32993a.b(j + this.f32994b);
    }
}
