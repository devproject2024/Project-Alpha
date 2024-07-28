package com.google.android.exoplayer2;

import com.google.android.exoplayer2.ah;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.o;
import com.google.android.exoplayer2.trackselection.j;

final class w {
    private static final o.a n = new o.a(new Object());

    /* renamed from: a  reason: collision with root package name */
    public final ah f33717a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f33718b;

    /* renamed from: c  reason: collision with root package name */
    public final o.a f33719c;

    /* renamed from: d  reason: collision with root package name */
    public final long f33720d;

    /* renamed from: e  reason: collision with root package name */
    public final long f33721e;

    /* renamed from: f  reason: collision with root package name */
    public final int f33722f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f33723g;

    /* renamed from: h  reason: collision with root package name */
    public final TrackGroupArray f33724h;

    /* renamed from: i  reason: collision with root package name */
    public final j f33725i;
    public final o.a j;
    public volatile long k;
    public volatile long l;
    public volatile long m;

    public static w a(long j2, j jVar) {
        j jVar2 = jVar;
        return new w(ah.f31122a, (Object) null, n, j2, -9223372036854775807L, 1, false, TrackGroupArray.f32783a, jVar2, n, j2, 0, j2);
    }

    public w(ah ahVar, Object obj, o.a aVar, long j2, long j3, int i2, boolean z, TrackGroupArray trackGroupArray, j jVar, o.a aVar2, long j4, long j5, long j6) {
        this.f33717a = ahVar;
        this.f33718b = obj;
        this.f33719c = aVar;
        this.f33720d = j2;
        this.f33721e = j3;
        this.f33722f = i2;
        this.f33723g = z;
        this.f33724h = trackGroupArray;
        this.f33725i = jVar;
        this.j = aVar2;
        this.k = j4;
        this.l = j5;
        this.m = j6;
    }

    public final o.a a(boolean z, ah.b bVar) {
        if (this.f33717a.a()) {
            return n;
        }
        ah ahVar = this.f33717a;
        return new o.a(this.f33717a.a(ahVar.a(ahVar.b(z), bVar).f31134f));
    }

    public final w a(o.a aVar, long j2, long j3, long j4) {
        return new w(this.f33717a, this.f33718b, aVar, j2, aVar.a() ? j3 : -9223372036854775807L, this.f33722f, this.f33723g, this.f33724h, this.f33725i, this.j, this.k, j4, j2);
    }

    public final w a(int i2) {
        ah ahVar = this.f33717a;
        return new w(ahVar, this.f33718b, this.f33719c, this.f33720d, this.f33721e, i2, this.f33723g, this.f33724h, this.f33725i, this.j, this.k, this.l, this.m);
    }

    public final w a(boolean z) {
        ah ahVar = this.f33717a;
        return new w(ahVar, this.f33718b, this.f33719c, this.f33720d, this.f33721e, this.f33722f, z, this.f33724h, this.f33725i, this.j, this.k, this.l, this.m);
    }

    public final w a(TrackGroupArray trackGroupArray, j jVar) {
        ah ahVar = this.f33717a;
        return new w(ahVar, this.f33718b, this.f33719c, this.f33720d, this.f33721e, this.f33722f, this.f33723g, trackGroupArray, jVar, this.j, this.k, this.l, this.m);
    }

    public final w a(o.a aVar) {
        ah ahVar = this.f33717a;
        return new w(ahVar, this.f33718b, this.f33719c, this.f33720d, this.f33721e, this.f33722f, this.f33723g, this.f33724h, this.f33725i, aVar, this.k, this.l, this.m);
    }
}
