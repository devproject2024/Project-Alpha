package com.google.android.exoplayer2;

import com.google.android.exoplayer2.g.a;

public final class af {

    /* renamed from: a  reason: collision with root package name */
    public static final af f31106a = new af(0, 0);

    /* renamed from: b  reason: collision with root package name */
    public static final af f31107b = new af(Long.MAX_VALUE, Long.MAX_VALUE);

    /* renamed from: c  reason: collision with root package name */
    public static final af f31108c = new af(Long.MAX_VALUE, 0);

    /* renamed from: d  reason: collision with root package name */
    public static final af f31109d = new af(0, Long.MAX_VALUE);

    /* renamed from: e  reason: collision with root package name */
    public static final af f31110e = f31106a;

    /* renamed from: f  reason: collision with root package name */
    public final long f31111f;

    /* renamed from: g  reason: collision with root package name */
    public final long f31112g;

    public af(long j, long j2) {
        boolean z = true;
        a.a(j >= 0);
        a.a(j2 < 0 ? false : z);
        this.f31111f = j;
        this.f31112g = j2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            af afVar = (af) obj;
            return this.f31111f == afVar.f31111f && this.f31112g == afVar.f31112g;
        }
    }

    public final int hashCode() {
        return (((int) this.f31111f) * 31) + ((int) this.f31112g);
    }
}
