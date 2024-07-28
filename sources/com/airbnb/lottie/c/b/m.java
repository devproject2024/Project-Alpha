package com.airbnb.lottie.c.b;

import android.graphics.Path;
import com.airbnb.lottie.a.a.c;
import com.airbnb.lottie.a.a.g;
import com.airbnb.lottie.c.a.a;
import com.airbnb.lottie.c.a.d;
import com.airbnb.lottie.f;

public final class m implements b {

    /* renamed from: a  reason: collision with root package name */
    public final Path.FillType f5890a;

    /* renamed from: b  reason: collision with root package name */
    public final String f5891b;

    /* renamed from: c  reason: collision with root package name */
    public final a f5892c;

    /* renamed from: d  reason: collision with root package name */
    public final d f5893d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f5894e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f5895f;

    public m(String str, boolean z, Path.FillType fillType, a aVar, d dVar, boolean z2) {
        this.f5891b = str;
        this.f5895f = z;
        this.f5890a = fillType;
        this.f5892c = aVar;
        this.f5893d = dVar;
        this.f5894e = z2;
    }

    public final c a(f fVar, com.airbnb.lottie.c.c.a aVar) {
        return new g(fVar, aVar, this);
    }

    public final String toString() {
        return "ShapeFill{color=, fillEnabled=" + this.f5895f + '}';
    }
}
