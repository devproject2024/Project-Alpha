package com.bumptech.glide.load.d.b;

import com.bumptech.glide.g.j;
import com.bumptech.glide.load.b.v;

public final class b implements v<byte[]> {

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f7199a;

    public final void d() {
    }

    public b(byte[] bArr) {
        this.f7199a = (byte[]) j.a(bArr, "Argument must not be null");
    }

    public final Class<byte[]> a() {
        return byte[].class;
    }

    public final int c() {
        return this.f7199a.length;
    }

    public final /* bridge */ /* synthetic */ Object b() {
        return this.f7199a;
    }
}
