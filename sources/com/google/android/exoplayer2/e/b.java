package com.google.android.exoplayer2.e;

import android.graphics.Bitmap;
import android.text.Layout;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f31445a = new b("");

    /* renamed from: b  reason: collision with root package name */
    public final CharSequence f31446b;

    /* renamed from: c  reason: collision with root package name */
    public final Layout.Alignment f31447c;

    /* renamed from: d  reason: collision with root package name */
    public final Bitmap f31448d;

    /* renamed from: e  reason: collision with root package name */
    public final float f31449e;

    /* renamed from: f  reason: collision with root package name */
    public final int f31450f;

    /* renamed from: g  reason: collision with root package name */
    public final int f31451g;

    /* renamed from: h  reason: collision with root package name */
    public final float f31452h;

    /* renamed from: i  reason: collision with root package name */
    public final int f31453i;
    public final float j;
    public final float k;
    public final boolean l;
    public final int m;
    public final int n;
    public final float o;

    public b(Bitmap bitmap, float f2, float f3, int i2, float f4, float f5) {
        this((CharSequence) null, (Layout.Alignment) null, bitmap, f3, 0, i2, f2, 0, Integer.MIN_VALUE, Float.MIN_VALUE, f4, f5, false, -16777216);
    }

    public b(CharSequence charSequence) {
        this(charSequence, (Layout.Alignment) null, Float.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Float.MIN_VALUE, Integer.MIN_VALUE, Float.MIN_VALUE);
    }

    public b(CharSequence charSequence, Layout.Alignment alignment, float f2, int i2, int i3, float f3, int i4, float f4) {
        this(charSequence, alignment, f2, i2, i3, f3, i4, f4, false, -16777216);
    }

    public b(CharSequence charSequence, float f2, int i2, int i3, float f3, float f4, int i4, float f5) {
        this(charSequence, (Layout.Alignment) null, (Bitmap) null, f2, i2, i3, f3, Integer.MIN_VALUE, i4, f5, f4, Float.MIN_VALUE, false, -16777216);
    }

    public b(CharSequence charSequence, Layout.Alignment alignment, float f2, int i2, int i3, float f3, int i4, float f4, boolean z, int i5) {
        this(charSequence, alignment, (Bitmap) null, f2, i2, i3, f3, i4, Integer.MIN_VALUE, Float.MIN_VALUE, f4, Float.MIN_VALUE, z, i5);
    }

    private b(CharSequence charSequence, Layout.Alignment alignment, Bitmap bitmap, float f2, int i2, int i3, float f3, int i4, int i5, float f4, float f5, float f6, boolean z, int i6) {
        this.f31446b = charSequence;
        this.f31447c = alignment;
        this.f31448d = bitmap;
        this.f31449e = f2;
        this.f31450f = i2;
        this.f31451g = i3;
        this.f31452h = f3;
        this.f31453i = i4;
        this.j = f5;
        this.k = f6;
        this.l = z;
        this.m = i6;
        this.n = i5;
        this.o = f4;
    }
}
