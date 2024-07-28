package com.google.firebase.ml.vision.d;

import com.google.android.gms.internal.firebase_ml.am;
import java.util.Arrays;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final int f39139a;

    /* renamed from: b  reason: collision with root package name */
    private final int f39140b;

    /* renamed from: c  reason: collision with root package name */
    private final int f39141c;

    /* renamed from: d  reason: collision with root package name */
    private final int f39142d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f39143e;

    /* renamed from: f  reason: collision with root package name */
    private final float f39144f;

    /* renamed from: com.google.firebase.ml.vision.d.a$a  reason: collision with other inner class name */
    public static class C0654a {

        /* renamed from: a  reason: collision with root package name */
        public int f39145a = 1;

        /* renamed from: b  reason: collision with root package name */
        public int f39146b = 1;

        /* renamed from: c  reason: collision with root package name */
        public int f39147c = 1;

        /* renamed from: d  reason: collision with root package name */
        public int f39148d = 1;

        /* renamed from: e  reason: collision with root package name */
        public boolean f39149e = false;

        /* renamed from: f  reason: collision with root package name */
        public float f39150f = 0.1f;
    }

    private a(int i2, int i3, int i4, int i5, boolean z, float f2) {
        this.f39139a = i2;
        this.f39140b = i3;
        this.f39141c = i4;
        this.f39142d = i5;
        this.f39143e = z;
        this.f39144f = f2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return Float.floatToIntBits(this.f39144f) == Float.floatToIntBits(aVar.f39144f) && this.f39139a == aVar.f39139a && this.f39140b == aVar.f39140b && this.f39142d == aVar.f39142d && this.f39143e == aVar.f39143e && this.f39141c == aVar.f39141c;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(Float.floatToIntBits(this.f39144f)), Integer.valueOf(this.f39139a), Integer.valueOf(this.f39140b), Integer.valueOf(this.f39142d), Boolean.valueOf(this.f39143e), Integer.valueOf(this.f39141c)});
    }

    public /* synthetic */ a(int i2, int i3, int i4, int i5, boolean z, float f2, byte b2) {
        this(i2, i3, i4, i5, z, f2);
    }

    public final String toString() {
        return new am("FaceDetectorOptions", (byte) 0).a("landmarkMode", this.f39139a).a("contourMode", this.f39140b).a("classificationMode", this.f39141c).a("performanceMode", this.f39142d).a("trackingEnabled", (Object) String.valueOf(this.f39143e)).a("minFaceSize", (Object) String.valueOf(this.f39144f)).toString();
    }
}
