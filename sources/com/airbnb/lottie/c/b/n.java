package com.airbnb.lottie.c.b;

import com.airbnb.lottie.a.a.c;
import com.airbnb.lottie.a.a.d;
import com.airbnb.lottie.c.c.a;
import com.airbnb.lottie.f;
import java.util.Arrays;
import java.util.List;

public final class n implements b {

    /* renamed from: a  reason: collision with root package name */
    public final String f5896a;

    /* renamed from: b  reason: collision with root package name */
    public final List<b> f5897b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f5898c;

    public n(String str, List<b> list, boolean z) {
        this.f5896a = str;
        this.f5897b = list;
        this.f5898c = z;
    }

    public final c a(f fVar, a aVar) {
        return new d(fVar, aVar, this);
    }

    public final String toString() {
        return "ShapeGroup{name='" + this.f5896a + "' Shapes: " + Arrays.toString(this.f5897b.toArray()) + '}';
    }
}
