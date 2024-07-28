package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.s;

final class k {

    /* renamed from: a  reason: collision with root package name */
    final String f12313a;

    /* renamed from: b  reason: collision with root package name */
    final String f12314b;

    /* renamed from: c  reason: collision with root package name */
    final long f12315c;

    /* renamed from: d  reason: collision with root package name */
    final long f12316d;

    /* renamed from: e  reason: collision with root package name */
    final long f12317e;

    /* renamed from: f  reason: collision with root package name */
    final long f12318f;

    /* renamed from: g  reason: collision with root package name */
    final long f12319g;

    /* renamed from: h  reason: collision with root package name */
    final Long f12320h;

    /* renamed from: i  reason: collision with root package name */
    final Long f12321i;
    final Long j;
    final Boolean k;

    k(String str, String str2, long j2, long j3, long j4, long j5, long j6, Long l, Long l2, Long l3, Boolean bool) {
        long j7 = j2;
        long j8 = j3;
        long j9 = j4;
        long j10 = j6;
        s.a(str);
        s.a(str2);
        boolean z = true;
        s.b(j7 >= 0);
        s.b(j8 >= 0);
        s.b(j9 >= 0);
        s.b(j10 < 0 ? false : z);
        this.f12313a = str;
        this.f12314b = str2;
        this.f12315c = j7;
        this.f12316d = j8;
        this.f12317e = j9;
        this.f12318f = j5;
        this.f12319g = j10;
        this.f12320h = l;
        this.f12321i = l2;
        this.j = l3;
        this.k = bool;
    }

    k(String str, String str2, long j2, long j3, long j4) {
        this(str, str2, j2, j3, 0, j4, 0, (Long) null, (Long) null, (Long) null, (Boolean) null);
    }

    /* access modifiers changed from: package-private */
    public final k a(long j2) {
        return new k(this.f12313a, this.f12314b, this.f12315c, this.f12316d, this.f12317e, j2, this.f12319g, this.f12320h, this.f12321i, this.j, this.k);
    }

    /* access modifiers changed from: package-private */
    public final k a(long j2, long j3) {
        return new k(this.f12313a, this.f12314b, this.f12315c, this.f12316d, this.f12317e, this.f12318f, j2, Long.valueOf(j3), this.f12321i, this.j, this.k);
    }

    /* access modifiers changed from: package-private */
    public final k a(Long l, Long l2, Boolean bool) {
        return new k(this.f12313a, this.f12314b, this.f12315c, this.f12316d, this.f12317e, this.f12318f, this.f12319g, this.f12320h, l, l2, (bool == null || bool.booleanValue()) ? bool : null);
    }
}
