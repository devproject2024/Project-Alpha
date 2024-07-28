package com.google.android.material.k;

import android.graphics.RectF;
import java.util.Arrays;

public final class k implements c {

    /* renamed from: a  reason: collision with root package name */
    private final float f36547a;

    public k(float f2) {
        this.f36547a = f2;
    }

    public final float a(RectF rectF) {
        return this.f36547a * rectF.height();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof k) && this.f36547a == ((k) obj).f36547a;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f36547a)});
    }
}
