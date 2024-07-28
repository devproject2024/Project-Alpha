package com.google.android.exoplayer2.g;

import com.google.android.exoplayer2.metadata.Metadata;

public final class i {

    /* renamed from: a  reason: collision with root package name */
    public final int f32529a;

    /* renamed from: b  reason: collision with root package name */
    public final int f32530b;

    /* renamed from: c  reason: collision with root package name */
    public final int f32531c;

    /* renamed from: d  reason: collision with root package name */
    public final int f32532d;

    /* renamed from: e  reason: collision with root package name */
    public final int f32533e;

    /* renamed from: f  reason: collision with root package name */
    public final int f32534f;

    /* renamed from: g  reason: collision with root package name */
    public final int f32535g;

    /* renamed from: h  reason: collision with root package name */
    public final long f32536h;

    /* renamed from: i  reason: collision with root package name */
    public final Metadata f32537i = null;

    public i(byte[] bArr) {
        q qVar = new q(bArr);
        qVar.a(136);
        this.f32529a = qVar.c(16);
        this.f32530b = qVar.c(16);
        this.f32531c = qVar.c(24);
        this.f32532d = qVar.c(24);
        this.f32533e = qVar.c(20);
        this.f32534f = qVar.c(3) + 1;
        this.f32535g = qVar.c(5) + 1;
        this.f32536h = ((((long) qVar.c(4)) & 15) << 32) | (((long) qVar.c(32)) & 4294967295L);
    }
}
