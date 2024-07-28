package com.google.android.exoplayer2.e;

import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.g.a;
import java.util.List;

public abstract class j extends f implements e {

    /* renamed from: d  reason: collision with root package name */
    private e f31644d;

    /* renamed from: e  reason: collision with root package name */
    private long f31645e;

    public abstract void e();

    public final void a(long j, e eVar, long j2) {
        this.f31314b = j;
        this.f31644d = eVar;
        if (j2 == Long.MAX_VALUE) {
            j2 = this.f31314b;
        }
        this.f31645e = j2;
    }

    public final int b() {
        return ((e) a.a(this.f31644d)).b();
    }

    public final long a_(int i2) {
        return ((e) a.a(this.f31644d)).a_(i2) + this.f31645e;
    }

    public final int a(long j) {
        return ((e) a.a(this.f31644d)).a(j - this.f31645e);
    }

    public final List<b> b(long j) {
        return ((e) a.a(this.f31644d)).b(j - this.f31645e);
    }

    public final void a() {
        super.a();
        this.f31644d = null;
    }
}
