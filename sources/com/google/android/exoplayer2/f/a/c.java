package com.google.android.exoplayer2.f.a;

import com.google.android.exoplayer2.f.h;

public final class c implements h.a {

    /* renamed from: a  reason: collision with root package name */
    private final a f32320a;

    /* renamed from: b  reason: collision with root package name */
    private final long f32321b;

    /* renamed from: c  reason: collision with root package name */
    private final int f32322c;

    public c(a aVar) {
        this(aVar, (byte) 0);
    }

    private c(a aVar, byte b2) {
        this.f32320a = aVar;
        this.f32321b = 5242880;
        this.f32322c = 20480;
    }

    public final h a() {
        return new b(this.f32320a, this.f32321b, this.f32322c);
    }
}
