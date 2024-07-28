package com.bumptech.glide.load.d.a;

import android.os.Build;
import com.bumptech.glide.load.h;

public abstract class n {

    /* renamed from: a  reason: collision with root package name */
    public static final n f7150a = new a();

    /* renamed from: b  reason: collision with root package name */
    public static final n f7151b = new b();

    /* renamed from: c  reason: collision with root package name */
    public static final n f7152c = new e();

    /* renamed from: d  reason: collision with root package name */
    public static final n f7153d = new c();

    /* renamed from: e  reason: collision with root package name */
    public static final n f7154e = new d();

    /* renamed from: f  reason: collision with root package name */
    public static final n f7155f = new f();

    /* renamed from: g  reason: collision with root package name */
    public static final n f7156g = f7154e;

    /* renamed from: h  reason: collision with root package name */
    public static final h<n> f7157h = h.a("com.bumptech.glide.load.resource.bitmap.Downsampler.DownsampleStrategy", f7156g);

    /* renamed from: i  reason: collision with root package name */
    static final boolean f7158i = (Build.VERSION.SDK_INT >= 19);

    public enum g {
        MEMORY,
        QUALITY
    }

    public abstract float a(int i2, int i3, int i4, int i5);

    public abstract g b(int i2, int i3, int i4, int i5);

    static class e extends n {
        e() {
        }

        public final float a(int i2, int i3, int i4, int i5) {
            if (f7158i) {
                return Math.min(((float) i4) / ((float) i2), ((float) i5) / ((float) i3));
            }
            int max = Math.max(i3 / i5, i2 / i4);
            if (max == 0) {
                return 1.0f;
            }
            return 1.0f / ((float) Integer.highestOneBit(max));
        }

        public final g b(int i2, int i3, int i4, int i5) {
            if (f7158i) {
                return g.QUALITY;
            }
            return g.MEMORY;
        }
    }

    static class d extends n {
        d() {
        }

        public final float a(int i2, int i3, int i4, int i5) {
            return Math.max(((float) i4) / ((float) i2), ((float) i5) / ((float) i3));
        }

        public final g b(int i2, int i3, int i4, int i5) {
            return g.QUALITY;
        }
    }

    static class a extends n {
        a() {
        }

        public final float a(int i2, int i3, int i4, int i5) {
            int min = Math.min(i3 / i5, i2 / i4);
            if (min == 0) {
                return 1.0f;
            }
            return 1.0f / ((float) Integer.highestOneBit(min));
        }

        public final g b(int i2, int i3, int i4, int i5) {
            return g.QUALITY;
        }
    }

    static class b extends n {
        b() {
        }

        public final float a(int i2, int i3, int i4, int i5) {
            int ceil = (int) Math.ceil((double) Math.max(((float) i3) / ((float) i5), ((float) i2) / ((float) i4)));
            int i6 = 1;
            int max = Math.max(1, Integer.highestOneBit(ceil));
            if (max >= ceil) {
                i6 = 0;
            }
            return 1.0f / ((float) (max << i6));
        }

        public final g b(int i2, int i3, int i4, int i5) {
            return g.MEMORY;
        }
    }

    static class f extends n {
        public final float a(int i2, int i3, int i4, int i5) {
            return 1.0f;
        }

        f() {
        }

        public final g b(int i2, int i3, int i4, int i5) {
            return g.QUALITY;
        }
    }

    static class c extends n {
        c() {
        }

        public final float a(int i2, int i3, int i4, int i5) {
            return Math.min(1.0f, f7152c.a(i2, i3, i4, i5));
        }

        public final g b(int i2, int i3, int i4, int i5) {
            if (a(i2, i3, i4, i5) == 1.0f) {
                return g.QUALITY;
            }
            return f7152c.b(i2, i3, i4, i5);
        }
    }
}
