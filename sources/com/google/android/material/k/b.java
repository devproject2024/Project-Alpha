package com.google.android.material.k;

import android.graphics.RectF;
import java.util.Arrays;

public final class b implements c {

    /* renamed from: a  reason: collision with root package name */
    private final c f36520a;

    /* renamed from: b  reason: collision with root package name */
    private final float f36521b;

    public b(float f2, c cVar) {
        while (cVar instanceof b) {
            cVar = ((b) cVar).f36520a;
            f2 += ((b) cVar).f36521b;
        }
        this.f36520a = cVar;
        this.f36521b = f2;
    }

    public final float a(RectF rectF) {
        return Math.max(0.0f, this.f36520a.a(rectF) + this.f36521b);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f36520a.equals(bVar.f36520a) && this.f36521b == bVar.f36521b;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f36520a, Float.valueOf(this.f36521b)});
    }
}
