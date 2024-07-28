package com.facebook.shimmer;

import android.content.res.TypedArray;
import android.graphics.RectF;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    final float[] f7443a = new float[4];

    /* renamed from: b  reason: collision with root package name */
    final int[] f7444b = new int[4];

    /* renamed from: c  reason: collision with root package name */
    final RectF f7445c = new RectF();

    /* renamed from: d  reason: collision with root package name */
    int f7446d = 0;

    /* renamed from: e  reason: collision with root package name */
    int f7447e = -1;

    /* renamed from: f  reason: collision with root package name */
    int f7448f = 1291845631;

    /* renamed from: g  reason: collision with root package name */
    int f7449g = 0;

    /* renamed from: h  reason: collision with root package name */
    int f7450h = 0;

    /* renamed from: i  reason: collision with root package name */
    int f7451i = 0;
    float j = 1.0f;
    float k = 1.0f;
    float l = 0.0f;
    float m = 0.5f;
    float n = 20.0f;
    boolean o = true;
    boolean p = true;
    boolean q = true;
    int r = -1;
    int s = 1;
    long t = 1000;
    long u;

    a() {
    }

    /* access modifiers changed from: package-private */
    public final int a(int i2) {
        int i3 = this.f7450h;
        return i3 > 0 ? i3 : Math.round(this.j * ((float) i2));
    }

    /* access modifiers changed from: package-private */
    public final int b(int i2) {
        int i3 = this.f7451i;
        return i3 > 0 ? i3 : Math.round(this.k * ((float) i2));
    }

    public static abstract class b<T extends b<T>> {

        /* renamed from: a  reason: collision with root package name */
        final a f7452a = new a();

        /* access modifiers changed from: protected */
        public abstract T a();

        /* access modifiers changed from: package-private */
        public T a(TypedArray typedArray) {
            if (typedArray.hasValue(R.styleable.ShimmerFrameLayout_shimmer_clip_to_children)) {
                this.f7452a.o = typedArray.getBoolean(R.styleable.ShimmerFrameLayout_shimmer_clip_to_children, this.f7452a.o);
            }
            if (typedArray.hasValue(R.styleable.ShimmerFrameLayout_shimmer_auto_start)) {
                this.f7452a.p = typedArray.getBoolean(R.styleable.ShimmerFrameLayout_shimmer_auto_start, this.f7452a.p);
            }
            if (typedArray.hasValue(R.styleable.ShimmerFrameLayout_shimmer_base_alpha)) {
                a aVar = this.f7452a;
                aVar.f7448f = (((int) (a(typedArray.getFloat(R.styleable.ShimmerFrameLayout_shimmer_base_alpha, 0.3f)) * 255.0f)) << 24) | (aVar.f7448f & 16777215);
            }
            if (typedArray.hasValue(R.styleable.ShimmerFrameLayout_shimmer_highlight_alpha)) {
                a aVar2 = this.f7452a;
                aVar2.f7447e = (((int) (a(typedArray.getFloat(R.styleable.ShimmerFrameLayout_shimmer_highlight_alpha, 1.0f)) * 255.0f)) << 24) | (16777215 & aVar2.f7447e);
            }
            if (typedArray.hasValue(R.styleable.ShimmerFrameLayout_shimmer_duration)) {
                long j = (long) typedArray.getInt(R.styleable.ShimmerFrameLayout_shimmer_duration, (int) this.f7452a.t);
                if (j >= 0) {
                    this.f7452a.t = j;
                } else {
                    throw new IllegalArgumentException("Given a negative duration: ".concat(String.valueOf(j)));
                }
            }
            if (typedArray.hasValue(R.styleable.ShimmerFrameLayout_shimmer_repeat_count)) {
                this.f7452a.r = typedArray.getInt(R.styleable.ShimmerFrameLayout_shimmer_repeat_count, this.f7452a.r);
            }
            if (typedArray.hasValue(R.styleable.ShimmerFrameLayout_shimmer_repeat_delay)) {
                long j2 = (long) typedArray.getInt(R.styleable.ShimmerFrameLayout_shimmer_repeat_delay, (int) this.f7452a.u);
                if (j2 >= 0) {
                    this.f7452a.u = j2;
                } else {
                    throw new IllegalArgumentException("Given a negative repeat delay: ".concat(String.valueOf(j2)));
                }
            }
            if (typedArray.hasValue(R.styleable.ShimmerFrameLayout_shimmer_repeat_mode)) {
                this.f7452a.s = typedArray.getInt(R.styleable.ShimmerFrameLayout_shimmer_repeat_mode, this.f7452a.s);
            }
            if (typedArray.hasValue(R.styleable.ShimmerFrameLayout_shimmer_direction)) {
                int i2 = typedArray.getInt(R.styleable.ShimmerFrameLayout_shimmer_direction, this.f7452a.f7446d);
                if (i2 == 1) {
                    a(1);
                } else if (i2 == 2) {
                    a(2);
                } else if (i2 != 3) {
                    a(0);
                } else {
                    a(3);
                }
            }
            if (typedArray.hasValue(R.styleable.ShimmerFrameLayout_shimmer_shape)) {
                if (typedArray.getInt(R.styleable.ShimmerFrameLayout_shimmer_shape, this.f7452a.f7449g) != 1) {
                    b(0);
                } else {
                    b(1);
                }
            }
            if (typedArray.hasValue(R.styleable.ShimmerFrameLayout_shimmer_dropoff)) {
                float f2 = typedArray.getFloat(R.styleable.ShimmerFrameLayout_shimmer_dropoff, this.f7452a.m);
                if (f2 >= 0.0f) {
                    this.f7452a.m = f2;
                } else {
                    throw new IllegalArgumentException("Given invalid dropoff value: ".concat(String.valueOf(f2)));
                }
            }
            if (typedArray.hasValue(R.styleable.ShimmerFrameLayout_shimmer_fixed_width)) {
                int dimensionPixelSize = typedArray.getDimensionPixelSize(R.styleable.ShimmerFrameLayout_shimmer_fixed_width, this.f7452a.f7450h);
                if (dimensionPixelSize >= 0) {
                    this.f7452a.f7450h = dimensionPixelSize;
                } else {
                    throw new IllegalArgumentException("Given invalid width: ".concat(String.valueOf(dimensionPixelSize)));
                }
            }
            if (typedArray.hasValue(R.styleable.ShimmerFrameLayout_shimmer_fixed_height)) {
                int dimensionPixelSize2 = typedArray.getDimensionPixelSize(R.styleable.ShimmerFrameLayout_shimmer_fixed_height, this.f7452a.f7451i);
                if (dimensionPixelSize2 >= 0) {
                    this.f7452a.f7451i = dimensionPixelSize2;
                } else {
                    throw new IllegalArgumentException("Given invalid height: ".concat(String.valueOf(dimensionPixelSize2)));
                }
            }
            if (typedArray.hasValue(R.styleable.ShimmerFrameLayout_shimmer_intensity)) {
                float f3 = typedArray.getFloat(R.styleable.ShimmerFrameLayout_shimmer_intensity, this.f7452a.l);
                if (f3 >= 0.0f) {
                    this.f7452a.l = f3;
                } else {
                    throw new IllegalArgumentException("Given invalid intensity value: ".concat(String.valueOf(f3)));
                }
            }
            if (typedArray.hasValue(R.styleable.ShimmerFrameLayout_shimmer_width_ratio)) {
                float f4 = typedArray.getFloat(R.styleable.ShimmerFrameLayout_shimmer_width_ratio, this.f7452a.j);
                if (f4 >= 0.0f) {
                    this.f7452a.j = f4;
                } else {
                    throw new IllegalArgumentException("Given invalid width ratio: ".concat(String.valueOf(f4)));
                }
            }
            if (typedArray.hasValue(R.styleable.ShimmerFrameLayout_shimmer_height_ratio)) {
                float f5 = typedArray.getFloat(R.styleable.ShimmerFrameLayout_shimmer_height_ratio, this.f7452a.k);
                if (f5 >= 0.0f) {
                    this.f7452a.k = f5;
                } else {
                    throw new IllegalArgumentException("Given invalid height ratio: ".concat(String.valueOf(f5)));
                }
            }
            if (typedArray.hasValue(R.styleable.ShimmerFrameLayout_shimmer_tilt)) {
                this.f7452a.n = typedArray.getFloat(R.styleable.ShimmerFrameLayout_shimmer_tilt, this.f7452a.n);
            }
            return a();
        }

        private T a(int i2) {
            this.f7452a.f7446d = i2;
            return a();
        }

        private T b(int i2) {
            this.f7452a.f7449g = i2;
            return a();
        }

        public final a b() {
            a aVar = this.f7452a;
            if (aVar.f7449g != 1) {
                aVar.f7444b[0] = aVar.f7448f;
                aVar.f7444b[1] = aVar.f7447e;
                aVar.f7444b[2] = aVar.f7447e;
                aVar.f7444b[3] = aVar.f7448f;
            } else {
                aVar.f7444b[0] = aVar.f7447e;
                aVar.f7444b[1] = aVar.f7447e;
                aVar.f7444b[2] = aVar.f7448f;
                aVar.f7444b[3] = aVar.f7448f;
            }
            a aVar2 = this.f7452a;
            if (aVar2.f7449g != 1) {
                aVar2.f7443a[0] = Math.max(((1.0f - aVar2.l) - aVar2.m) / 2.0f, 0.0f);
                aVar2.f7443a[1] = Math.max(((1.0f - aVar2.l) - 0.001f) / 2.0f, 0.0f);
                aVar2.f7443a[2] = Math.min(((aVar2.l + 1.0f) + 0.001f) / 2.0f, 1.0f);
                aVar2.f7443a[3] = Math.min(((aVar2.l + 1.0f) + aVar2.m) / 2.0f, 1.0f);
            } else {
                aVar2.f7443a[0] = 0.0f;
                aVar2.f7443a[1] = Math.min(aVar2.l, 1.0f);
                aVar2.f7443a[2] = Math.min(aVar2.l + aVar2.m, 1.0f);
                aVar2.f7443a[3] = 1.0f;
            }
            return this.f7452a;
        }

        private static float a(float f2) {
            return Math.min(1.0f, Math.max(0.0f, f2));
        }
    }

    /* renamed from: com.facebook.shimmer.a$a  reason: collision with other inner class name */
    public static class C0106a extends b<C0106a> {
        /* access modifiers changed from: protected */
        public final /* bridge */ /* synthetic */ b a() {
            return this;
        }

        public C0106a() {
            this.f7452a.q = true;
        }
    }

    public static class c extends b<c> {
        /* access modifiers changed from: protected */
        public final /* bridge */ /* synthetic */ b a() {
            return this;
        }

        public c() {
            this.f7452a.q = false;
        }

        /* access modifiers changed from: package-private */
        public final /* synthetic */ b a(TypedArray typedArray) {
            super.a(typedArray);
            if (typedArray.hasValue(R.styleable.ShimmerFrameLayout_shimmer_base_color)) {
                int color = typedArray.getColor(R.styleable.ShimmerFrameLayout_shimmer_base_color, this.f7452a.f7448f);
                this.f7452a.f7448f = (color & 16777215) | (this.f7452a.f7448f & -16777216);
            }
            if (typedArray.hasValue(R.styleable.ShimmerFrameLayout_shimmer_highlight_color)) {
                this.f7452a.f7447e = typedArray.getColor(R.styleable.ShimmerFrameLayout_shimmer_highlight_color, this.f7452a.f7447e);
            }
            return this;
        }
    }
}
