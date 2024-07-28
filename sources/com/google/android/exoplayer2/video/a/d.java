package com.google.android.exoplayer2.video.a;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public final a f33674a;

    /* renamed from: b  reason: collision with root package name */
    public final a f33675b;

    /* renamed from: c  reason: collision with root package name */
    public final int f33676c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f33677d;

    public d(a aVar, int i2) {
        this(aVar, aVar, i2);
    }

    public d(a aVar, a aVar2, int i2) {
        this.f33674a = aVar;
        this.f33675b = aVar2;
        this.f33676c = i2;
        this.f33677d = aVar == aVar2;
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final int f33679a;

        /* renamed from: b  reason: collision with root package name */
        public final int f33680b;

        /* renamed from: c  reason: collision with root package name */
        public final float[] f33681c;

        /* renamed from: d  reason: collision with root package name */
        public final float[] f33682d;

        public b(int i2, float[] fArr, float[] fArr2, int i3) {
            this.f33679a = i2;
            com.google.android.exoplayer2.g.a.a(((long) fArr.length) * 2 == ((long) fArr2.length) * 3);
            this.f33681c = fArr;
            this.f33682d = fArr2;
            this.f33680b = i3;
        }
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final b[] f33678a;

        public a(b... bVarArr) {
            this.f33678a = bVarArr;
        }
    }
}
