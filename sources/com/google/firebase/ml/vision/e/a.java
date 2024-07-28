package com.google.firebase.ml.vision.e;

import java.util.Arrays;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final float f39151a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f39152b;

    /* renamed from: com.google.firebase.ml.vision.e.a$a  reason: collision with other inner class name */
    public static class C0655a {

        /* renamed from: a  reason: collision with root package name */
        public float f39153a = 0.5f;

        /* renamed from: b  reason: collision with root package name */
        public boolean f39154b = false;
    }

    private a(float f2, boolean z) {
        this.f39151a = f2;
        this.f39152b = z;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return Float.compare(this.f39151a, aVar.f39151a) == 0 && this.f39152b == aVar.f39152b;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f39151a), Boolean.valueOf(this.f39152b)});
    }

    public /* synthetic */ a(float f2, boolean z, byte b2) {
        this(f2, z);
    }
}
