package com.airbnb.lottie.c.b;

import com.airbnb.lottie.a.a.c;
import com.airbnb.lottie.a.a.q;
import com.airbnb.lottie.c.a.h;
import com.airbnb.lottie.c.c.a;
import com.airbnb.lottie.f;

public final class o implements b {

    /* renamed from: a  reason: collision with root package name */
    public final String f5899a;

    /* renamed from: b  reason: collision with root package name */
    public final h f5900b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f5901c;

    /* renamed from: d  reason: collision with root package name */
    private final int f5902d;

    public o(String str, int i2, h hVar, boolean z) {
        this.f5899a = str;
        this.f5902d = i2;
        this.f5900b = hVar;
        this.f5901c = z;
    }

    public final c a(f fVar, a aVar) {
        return new q(fVar, aVar, this);
    }

    public final String toString() {
        return "ShapePath{name=" + this.f5899a + ", index=" + this.f5902d + '}';
    }
}
