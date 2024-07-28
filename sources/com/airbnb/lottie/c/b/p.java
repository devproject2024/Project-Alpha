package com.airbnb.lottie.c.b;

import android.graphics.Paint;
import com.airbnb.lottie.a.a.c;
import com.airbnb.lottie.a.a.r;
import com.airbnb.lottie.c.a.d;
import com.airbnb.lottie.f;
import java.util.List;

public final class p implements b {

    /* renamed from: a  reason: collision with root package name */
    public final String f5903a;

    /* renamed from: b  reason: collision with root package name */
    public final com.airbnb.lottie.c.a.b f5904b;

    /* renamed from: c  reason: collision with root package name */
    public final List<com.airbnb.lottie.c.a.b> f5905c;

    /* renamed from: d  reason: collision with root package name */
    public final com.airbnb.lottie.c.a.a f5906d;

    /* renamed from: e  reason: collision with root package name */
    public final d f5907e;

    /* renamed from: f  reason: collision with root package name */
    public final com.airbnb.lottie.c.a.b f5908f;

    /* renamed from: g  reason: collision with root package name */
    public final a f5909g;

    /* renamed from: h  reason: collision with root package name */
    public final b f5910h;

    /* renamed from: i  reason: collision with root package name */
    public final float f5911i;
    public final boolean j;

    public enum a {
        BUTT,
        ROUND,
        UNKNOWN;

        public final Paint.Cap toPaintCap() {
            int i2 = AnonymousClass1.f5912a[ordinal()];
            if (i2 == 1) {
                return Paint.Cap.BUTT;
            }
            if (i2 != 2) {
                return Paint.Cap.SQUARE;
            }
            return Paint.Cap.ROUND;
        }
    }

    /* renamed from: com.airbnb.lottie.c.b.p$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f5912a = new int[a.values().length];

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f5913b = new int[b.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|16|17|18|20) */
        /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x003d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0047 */
        static {
            /*
                com.airbnb.lottie.c.b.p$b[] r0 = com.airbnb.lottie.c.b.p.b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f5913b = r0
                r0 = 1
                int[] r1 = f5913b     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.airbnb.lottie.c.b.p$b r2 = com.airbnb.lottie.c.b.p.b.BEVEL     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                r1 = 2
                int[] r2 = f5913b     // Catch:{ NoSuchFieldError -> 0x001f }
                com.airbnb.lottie.c.b.p$b r3 = com.airbnb.lottie.c.b.p.b.MITER     // Catch:{ NoSuchFieldError -> 0x001f }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                r2 = 3
                int[] r3 = f5913b     // Catch:{ NoSuchFieldError -> 0x002a }
                com.airbnb.lottie.c.b.p$b r4 = com.airbnb.lottie.c.b.p.b.ROUND     // Catch:{ NoSuchFieldError -> 0x002a }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                com.airbnb.lottie.c.b.p$a[] r3 = com.airbnb.lottie.c.b.p.a.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                f5912a = r3
                int[] r3 = f5912a     // Catch:{ NoSuchFieldError -> 0x003d }
                com.airbnb.lottie.c.b.p$a r4 = com.airbnb.lottie.c.b.p.a.BUTT     // Catch:{ NoSuchFieldError -> 0x003d }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x003d }
                r3[r4] = r0     // Catch:{ NoSuchFieldError -> 0x003d }
            L_0x003d:
                int[] r0 = f5912a     // Catch:{ NoSuchFieldError -> 0x0047 }
                com.airbnb.lottie.c.b.p$a r3 = com.airbnb.lottie.c.b.p.a.ROUND     // Catch:{ NoSuchFieldError -> 0x0047 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0047 }
                r0[r3] = r1     // Catch:{ NoSuchFieldError -> 0x0047 }
            L_0x0047:
                int[] r0 = f5912a     // Catch:{ NoSuchFieldError -> 0x0051 }
                com.airbnb.lottie.c.b.p$a r1 = com.airbnb.lottie.c.b.p.a.UNKNOWN     // Catch:{ NoSuchFieldError -> 0x0051 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0051 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0051 }
            L_0x0051:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.c.b.p.AnonymousClass1.<clinit>():void");
        }
    }

    public enum b {
        MITER,
        ROUND,
        BEVEL;

        public final Paint.Join toPaintJoin() {
            int i2 = AnonymousClass1.f5913b[ordinal()];
            if (i2 == 1) {
                return Paint.Join.BEVEL;
            }
            if (i2 == 2) {
                return Paint.Join.MITER;
            }
            if (i2 != 3) {
                return null;
            }
            return Paint.Join.ROUND;
        }
    }

    public p(String str, com.airbnb.lottie.c.a.b bVar, List<com.airbnb.lottie.c.a.b> list, com.airbnb.lottie.c.a.a aVar, d dVar, com.airbnb.lottie.c.a.b bVar2, a aVar2, b bVar3, float f2, boolean z) {
        this.f5903a = str;
        this.f5904b = bVar;
        this.f5905c = list;
        this.f5906d = aVar;
        this.f5907e = dVar;
        this.f5908f = bVar2;
        this.f5909g = aVar2;
        this.f5910h = bVar3;
        this.f5911i = f2;
        this.j = z;
    }

    public final c a(f fVar, com.airbnb.lottie.c.c.a aVar) {
        return new r(fVar, aVar, this);
    }
}
