package com.google.android.material.k;

import android.graphics.RectF;
import java.util.Arrays;

public final class a implements c {

    /* renamed from: a  reason: collision with root package name */
    private final float f36519a;

    public a(float f2) {
        this.f36519a = f2;
    }

    public final float a(RectF rectF) {
        return this.f36519a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof a) && this.f36519a == ((a) obj).f36519a;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f36519a)});
    }
}
