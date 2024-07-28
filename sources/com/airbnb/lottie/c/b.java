package com.airbnb.lottie.c;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final String f5827a;

    /* renamed from: b  reason: collision with root package name */
    public final String f5828b;

    /* renamed from: c  reason: collision with root package name */
    public final float f5829c;

    /* renamed from: d  reason: collision with root package name */
    public final a f5830d;

    /* renamed from: e  reason: collision with root package name */
    public final int f5831e;

    /* renamed from: f  reason: collision with root package name */
    public final float f5832f;

    /* renamed from: g  reason: collision with root package name */
    public final float f5833g;

    /* renamed from: h  reason: collision with root package name */
    public final int f5834h;

    /* renamed from: i  reason: collision with root package name */
    public final int f5835i;
    public final float j;
    public final boolean k;

    public enum a {
        LEFT_ALIGN,
        RIGHT_ALIGN,
        CENTER
    }

    public b(String str, String str2, float f2, a aVar, int i2, float f3, float f4, int i3, int i4, float f5, boolean z) {
        this.f5827a = str;
        this.f5828b = str2;
        this.f5829c = f2;
        this.f5830d = aVar;
        this.f5831e = i2;
        this.f5832f = f3;
        this.f5833g = f4;
        this.f5834h = i3;
        this.f5835i = i4;
        this.j = f5;
        this.k = z;
    }

    public final int hashCode() {
        int hashCode = (((((int) (((float) (((this.f5827a.hashCode() * 31) + this.f5828b.hashCode()) * 31)) + this.f5829c)) * 31) + this.f5830d.ordinal()) * 31) + this.f5831e;
        long floatToRawIntBits = (long) Float.floatToRawIntBits(this.f5832f);
        return (((hashCode * 31) + ((int) (floatToRawIntBits ^ (floatToRawIntBits >>> 32)))) * 31) + this.f5834h;
    }
}
