package com.google.android.exoplayer2;

import com.google.android.exoplayer2.g.ae;
import com.google.android.exoplayer2.source.o;

final class t {

    /* renamed from: a  reason: collision with root package name */
    public final o.a f33411a;

    /* renamed from: b  reason: collision with root package name */
    public final long f33412b;

    /* renamed from: c  reason: collision with root package name */
    public final long f33413c;

    /* renamed from: d  reason: collision with root package name */
    public final long f33414d;

    /* renamed from: e  reason: collision with root package name */
    public final long f33415e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f33416f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f33417g;

    t(o.a aVar, long j, long j2, long j3, long j4, boolean z, boolean z2) {
        this.f33411a = aVar;
        this.f33412b = j;
        this.f33413c = j2;
        this.f33414d = j3;
        this.f33415e = j4;
        this.f33416f = z;
        this.f33417g = z2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            t tVar = (t) obj;
            return this.f33412b == tVar.f33412b && this.f33413c == tVar.f33413c && this.f33414d == tVar.f33414d && this.f33415e == tVar.f33415e && this.f33416f == tVar.f33416f && this.f33417g == tVar.f33417g && ae.a((Object) this.f33411a, (Object) tVar.f33411a);
        }
    }

    public final int hashCode() {
        return ((((((((((((this.f33411a.hashCode() + 527) * 31) + ((int) this.f33412b)) * 31) + ((int) this.f33413c)) * 31) + ((int) this.f33414d)) * 31) + ((int) this.f33415e)) * 31) + (this.f33416f ? 1 : 0)) * 31) + (this.f33417g ? 1 : 0);
    }
}
