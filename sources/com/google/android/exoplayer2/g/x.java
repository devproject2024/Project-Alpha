package com.google.android.exoplayer2.g;

import com.google.android.exoplayer2.c;

public final class x implements n {

    /* renamed from: a  reason: collision with root package name */
    public final b f32589a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f32590b;

    /* renamed from: c  reason: collision with root package name */
    public long f32591c;

    /* renamed from: d  reason: collision with root package name */
    public com.google.android.exoplayer2.x f32592d = com.google.android.exoplayer2.x.f33726a;

    /* renamed from: e  reason: collision with root package name */
    private long f32593e;

    public x(b bVar) {
        this.f32589a = bVar;
    }

    public final void a(long j) {
        this.f32593e = j;
        if (this.f32590b) {
            this.f32591c = this.f32589a.a();
        }
    }

    public final long d() {
        long j;
        long j2 = this.f32593e;
        if (!this.f32590b) {
            return j2;
        }
        long a2 = this.f32589a.a() - this.f32591c;
        if (this.f32592d.f33727b == 1.0f) {
            j = c.b(a2);
        } else {
            j = a2 * ((long) this.f32592d.f33730e);
        }
        return j2 + j;
    }

    public final com.google.android.exoplayer2.x a(com.google.android.exoplayer2.x xVar) {
        if (this.f32590b) {
            a(d());
        }
        this.f32592d = xVar;
        return xVar;
    }

    public final com.google.android.exoplayer2.x e() {
        return this.f32592d;
    }
}
