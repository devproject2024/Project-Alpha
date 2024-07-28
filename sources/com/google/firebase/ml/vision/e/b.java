package com.google.firebase.ml.vision.e;

import java.util.Arrays;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final float f39155a;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public float f39156a = 0.5f;
    }

    private b(float f2) {
        this.f39155a = f2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof b) && this.f39155a == ((b) obj).f39155a;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f39155a)});
    }

    public /* synthetic */ b(float f2, byte b2) {
        this(f2);
    }
}
