package com.google.android.exoplayer2.trackselection;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.f.d;
import com.google.android.exoplayer2.g.ae;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.b.l;
import com.google.android.exoplayer2.source.b.m;
import com.google.android.exoplayer2.trackselection.f;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public final class a extends b {

    /* renamed from: a  reason: collision with root package name */
    final C0553a f33465a;

    /* renamed from: b  reason: collision with root package name */
    e f33466b;

    /* renamed from: g  reason: collision with root package name */
    private final long f33467g;

    /* renamed from: h  reason: collision with root package name */
    private final long f33468h;

    /* renamed from: i  reason: collision with root package name */
    private final long f33469i;
    private final float j;
    private final long k;
    private final com.google.android.exoplayer2.g.b l;
    private final Format[] m;
    private final int[] n;
    private final int[] o;
    private float p;
    private int q;
    private int r;
    private long s;

    /* renamed from: com.google.android.exoplayer2.trackselection.a$a  reason: collision with other inner class name */
    interface C0553a {
        long a();
    }

    public final Object c() {
        return null;
    }

    /* synthetic */ a(TrackGroup trackGroup, int[] iArr, C0553a aVar, long j2, long j3, long j4, float f2, long j5, com.google.android.exoplayer2.g.b bVar, byte b2) {
        this(trackGroup, iArr, aVar, j2, j3, j4, f2, j5, bVar);
    }

    public static class c implements f.b {

        /* renamed from: a  reason: collision with root package name */
        private final d f33474a;

        /* renamed from: b  reason: collision with root package name */
        private final int f33475b;

        /* renamed from: c  reason: collision with root package name */
        private final int f33476c;

        /* renamed from: d  reason: collision with root package name */
        private final int f33477d;

        /* renamed from: e  reason: collision with root package name */
        private final float f33478e;

        /* renamed from: f  reason: collision with root package name */
        private final float f33479f;

        /* renamed from: g  reason: collision with root package name */
        private final long f33480g;

        /* renamed from: h  reason: collision with root package name */
        private final com.google.android.exoplayer2.g.b f33481h;

        /* renamed from: i  reason: collision with root package name */
        private e f33482i;
        private boolean j;

        @Deprecated
        public /* synthetic */ f a() {
            return f.b.CC.$default$a(this);
        }

        public c() {
            this(com.google.android.exoplayer2.g.b.f32508a);
        }

        private c(com.google.android.exoplayer2.g.b bVar) {
            this(bVar, (byte) 0);
        }

        @Deprecated
        private c(com.google.android.exoplayer2.g.b bVar, byte b2) {
            this.f33474a = null;
            this.f33475b = AppConstants.START_OTP_FLOW;
            this.f33476c = 25000;
            this.f33477d = 25000;
            this.f33478e = 0.75f;
            this.f33479f = 0.75f;
            this.f33480g = 2000;
            this.f33481h = bVar;
            this.f33482i = e.f33499a;
        }

        public final f[] a(f.a[] aVarArr, d dVar) {
            f[] fVarArr;
            d dVar2;
            int i2;
            ArrayList arrayList;
            f.a[] aVarArr2 = aVarArr;
            d dVar3 = this.f33474a;
            if (dVar3 == null) {
                dVar3 = dVar;
            }
            f[] fVarArr2 = new f[aVarArr2.length];
            ArrayList arrayList2 = new ArrayList();
            int i3 = 0;
            int i4 = 0;
            while (i3 < aVarArr2.length) {
                f.a aVar = aVarArr2[i3];
                if (aVar == null) {
                    dVar2 = dVar3;
                    fVarArr = fVarArr2;
                    arrayList = arrayList2;
                    i2 = i3;
                } else if (aVar.f33501b.length > 1) {
                    TrackGroup trackGroup = aVar.f33500a;
                    int[] iArr = aVar.f33501b;
                    b bVar = new b(dVar3, this.f33478e);
                    i2 = i3;
                    long j2 = (long) this.f33476c;
                    dVar2 = dVar3;
                    long j3 = (long) this.f33477d;
                    float f2 = this.f33479f;
                    fVarArr = fVarArr2;
                    float f3 = f2;
                    a aVar2 = new a(trackGroup, iArr, bVar, (long) this.f33475b, j2, j3, f3, this.f33480g, this.f33481h, (byte) 0);
                    aVar2.f33466b = this.f33482i;
                    arrayList = arrayList2;
                    arrayList.add(aVar2);
                    fVarArr[i2] = aVar2;
                } else {
                    dVar2 = dVar3;
                    fVarArr = fVarArr2;
                    arrayList = arrayList2;
                    i2 = i3;
                    fVarArr[i2] = new c(aVar.f33500a, aVar.f33501b[0], aVar.f33502c, aVar.f33503d);
                    int i5 = aVar.f33500a.f32781b[aVar.f33501b[0]].f31065e;
                    if (i5 != -1) {
                        i4 += i5;
                    }
                    i3 = i2 + 1;
                    arrayList2 = arrayList;
                    dVar3 = dVar2;
                    fVarArr2 = fVarArr;
                    aVarArr2 = aVarArr;
                }
                i3 = i2 + 1;
                arrayList2 = arrayList;
                dVar3 = dVar2;
                fVarArr2 = fVarArr;
                aVarArr2 = aVarArr;
            }
            f[] fVarArr3 = fVarArr2;
            ArrayList arrayList3 = arrayList2;
            if (this.j) {
                for (int i6 = 0; i6 < arrayList3.size(); i6++) {
                    ((b) ((a) arrayList3.get(i6)).f33465a).f33470a = (long) i4;
                }
            }
            if (arrayList3.size() > 1) {
                long[][] jArr = new long[arrayList3.size()][];
                for (int i7 = 0; i7 < arrayList3.size(); i7++) {
                    a aVar3 = (a) arrayList3.get(i7);
                    jArr[i7] = new long[aVar3.f()];
                    for (int i8 = 0; i8 < aVar3.f(); i8++) {
                        jArr[i7][i8] = (long) aVar3.f33488f[(aVar3.f() - i8) - 1].f31065e;
                    }
                }
                long[][][] a2 = a.a(jArr);
                for (int i9 = 0; i9 < arrayList3.size(); i9++) {
                    long[][] jArr2 = a2[i9];
                    b bVar2 = (b) ((a) arrayList3.get(i9)).f33465a;
                    com.google.android.exoplayer2.g.a.a(jArr2.length >= 2);
                    bVar2.f33471b = jArr2;
                }
            }
            return fVarArr3;
        }
    }

    private a(TrackGroup trackGroup, int[] iArr, C0553a aVar, long j2, long j3, long j4, float f2, long j5, com.google.android.exoplayer2.g.b bVar) {
        super(trackGroup, iArr);
        this.f33465a = aVar;
        this.f33467g = j2 * 1000;
        this.f33468h = j3 * 1000;
        this.f33469i = j4 * 1000;
        this.j = f2;
        this.k = j5;
        this.l = bVar;
        this.p = 1.0f;
        this.r = 0;
        this.s = -9223372036854775807L;
        this.f33466b = e.f33499a;
        this.m = new Format[this.f33486d];
        this.n = new int[this.f33486d];
        this.o = new int[this.f33486d];
        for (int i2 = 0; i2 < this.f33486d; i2++) {
            Format format = this.f33488f[i2];
            Format[] formatArr = this.m;
            formatArr[i2] = format;
            this.n[i2] = formatArr[i2].f31065e;
        }
    }

    public final void d() {
        this.s = -9223372036854775807L;
    }

    public final void a(float f2) {
        this.p = f2;
    }

    public final void a(long j2, long j3, List<? extends l> list, m[] mVarArr) {
        long a2 = this.l.a();
        this.f33466b.getBitrates(this.m, list, mVarArr, this.o);
        boolean z = true;
        if (this.r == 0) {
            this.r = 1;
            this.q = a(a2, this.o);
            return;
        }
        int i2 = this.q;
        this.q = a(a2, this.o);
        if (this.q != i2) {
            if (!b(i2, a2)) {
                Format format = this.f33488f[i2];
                Format format2 = this.f33488f[this.q];
                if (format2.f31065e > format.f31065e) {
                    if (j3 == -9223372036854775807L || j3 > this.f33467g) {
                        z = false;
                    }
                    if (j2 < (z ? (long) (((float) j3) * this.j) : this.f33467g)) {
                        this.q = i2;
                    }
                }
                if (format2.f31065e < format.f31065e && j2 >= this.f33468h) {
                    this.q = i2;
                }
            }
            if (this.q != i2) {
                this.r = 3;
            }
        }
    }

    public final int a() {
        return this.q;
    }

    public final int b() {
        return this.r;
    }

    public final int a(long j2, List<? extends l> list) {
        long a2 = this.l.a();
        long j3 = this.s;
        if (!(j3 == -9223372036854775807L || a2 - j3 >= this.k)) {
            return list.size();
        }
        this.s = a2;
        if (list.isEmpty()) {
            return 0;
        }
        int size = list.size();
        long b2 = ae.b(((l) list.get(size - 1)).j - j2, this.p);
        long j4 = this.f33469i;
        if (b2 < j4) {
            return size;
        }
        Format format = this.f33488f[a(a2, this.n)];
        for (int i2 = 0; i2 < size; i2++) {
            l lVar = (l) list.get(i2);
            Format format2 = lVar.f32816g;
            if (ae.b(lVar.j - j2, this.p) >= j4 && format2.f31065e < format.f31065e && format2.o != -1 && format2.o < 720 && format2.n != -1 && format2.n < 1280 && format2.o < format.o) {
                return i2;
            }
        }
        return size;
    }

    private static boolean a(int i2, float f2, long j2) {
        return ((long) Math.round(((float) i2) * f2)) <= j2;
    }

    private int a(long j2, int[] iArr) {
        long a2 = this.f33465a.a();
        int i2 = 0;
        for (int i3 = 0; i3 < this.f33486d; i3++) {
            if (j2 == Long.MIN_VALUE || !b(i3, j2)) {
                if (a(iArr[i3], this.p, a2)) {
                    return i3;
                }
                i2 = i3;
            }
        }
        return i2;
    }

    static final class b implements C0553a {

        /* renamed from: a  reason: collision with root package name */
        long f33470a;

        /* renamed from: b  reason: collision with root package name */
        long[][] f33471b;

        /* renamed from: c  reason: collision with root package name */
        private final d f33472c;

        /* renamed from: d  reason: collision with root package name */
        private final float f33473d;

        b(d dVar, float f2) {
            this.f33472c = dVar;
            this.f33473d = f2;
        }

        public final long a() {
            long max = Math.max(0, ((long) (((float) this.f33472c.b()) * this.f33473d)) - this.f33470a);
            if (this.f33471b == null) {
                return max;
            }
            int i2 = 1;
            while (true) {
                long[][] jArr = this.f33471b;
                if (i2 >= jArr.length - 1 || jArr[i2][0] >= max) {
                    long[][] jArr2 = this.f33471b;
                    long[] jArr3 = jArr2[i2 - 1];
                    long[] jArr4 = jArr2[i2];
                } else {
                    i2++;
                }
            }
            long[][] jArr22 = this.f33471b;
            long[] jArr32 = jArr22[i2 - 1];
            long[] jArr42 = jArr22[i2];
            return jArr32[1] + ((long) ((((float) (max - jArr32[0])) / ((float) (jArr42[0] - jArr32[0]))) * ((float) (jArr42[1] - jArr32[1]))));
        }
    }

    private static void a(long[][][] jArr, int i2, long[][] jArr2, int[] iArr) {
        long j2 = 0;
        for (int i3 = 0; i3 < jArr.length; i3++) {
            jArr[i3][i2][1] = jArr2[i3][iArr[i3]];
            j2 += jArr[i3][i2][1];
        }
        for (long[][] jArr3 : jArr) {
            jArr3[i2][0] = j2;
        }
    }

    static /* synthetic */ long[][][] a(long[][] jArr) {
        int i2;
        long[][] jArr2 = jArr;
        double[][] dArr = new double[jArr2.length][];
        for (int i3 = 0; i3 < jArr2.length; i3++) {
            dArr[i3] = new double[jArr2[i3].length];
            for (int i4 = 0; i4 < jArr2[i3].length; i4++) {
                dArr[i3][i4] = jArr2[i3][i4] == -1 ? 0.0d : Math.log((double) jArr2[i3][i4]);
            }
        }
        double[][] dArr2 = new double[dArr.length][];
        for (int i5 = 0; i5 < dArr.length; i5++) {
            dArr2[i5] = new double[(dArr[i5].length - 1)];
            if (dArr2[i5].length != 0) {
                double d2 = dArr[i5][dArr[i5].length - 1] - dArr[i5][0];
                int i6 = 0;
                while (i6 < dArr[i5].length - 1) {
                    int i7 = i6 + 1;
                    dArr2[i5][i6] = d2 == 0.0d ? 1.0d : (((dArr[i5][i6] + dArr[i5][i7]) * 0.5d) - dArr[i5][0]) / d2;
                    i6 = i7;
                }
            }
        }
        int i8 = 0;
        for (double[] length : dArr2) {
            i8 += length.length;
        }
        int i9 = i8 + 3;
        long[][][] jArr3 = (long[][][]) Array.newInstance(long.class, new int[]{dArr.length, i9, 2});
        int[] iArr = new int[dArr.length];
        a(jArr3, 1, jArr2, iArr);
        int i10 = 2;
        while (true) {
            i2 = i9 - 1;
            if (i10 >= i2) {
                break;
            }
            double d3 = Double.MAX_VALUE;
            int i11 = 0;
            for (int i12 = 0; i12 < dArr.length; i12++) {
                if (iArr[i12] + 1 != dArr[i12].length) {
                    double d4 = dArr2[i12][iArr[i12]];
                    if (d4 < d3) {
                        i11 = i12;
                        d3 = d4;
                    }
                }
            }
            iArr[i11] = iArr[i11] + 1;
            a(jArr3, i10, jArr2, iArr);
            i10++;
        }
        for (long[][] jArr4 : jArr3) {
            int i13 = i9 - 2;
            jArr4[i2][0] = jArr4[i13][0] * 2;
            jArr4[i2][1] = jArr4[i13][1] * 2;
        }
        return jArr3;
    }
}
