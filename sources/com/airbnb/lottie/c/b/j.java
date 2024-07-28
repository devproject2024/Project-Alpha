package com.airbnb.lottie.c.b;

import android.graphics.PointF;
import com.airbnb.lottie.a.a.c;
import com.airbnb.lottie.a.a.o;
import com.airbnb.lottie.c.a.b;
import com.airbnb.lottie.c.a.f;
import com.airbnb.lottie.c.a.m;
import com.airbnb.lottie.c.c.a;

public final class j implements b {

    /* renamed from: a  reason: collision with root package name */
    public final String f5877a;

    /* renamed from: b  reason: collision with root package name */
    public final m<PointF, PointF> f5878b;

    /* renamed from: c  reason: collision with root package name */
    public final f f5879c;

    /* renamed from: d  reason: collision with root package name */
    public final b f5880d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f5881e;

    public j(String str, m<PointF, PointF> mVar, f fVar, b bVar, boolean z) {
        this.f5877a = str;
        this.f5878b = mVar;
        this.f5879c = fVar;
        this.f5880d = bVar;
        this.f5881e = z;
    }

    public final c a(com.airbnb.lottie.f fVar, a aVar) {
        return new o(fVar, aVar, this);
    }

    public final String toString() {
        return "RectangleShape{position=" + this.f5878b + ", size=" + this.f5879c + '}';
    }
}
