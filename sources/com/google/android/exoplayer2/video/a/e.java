package com.google.android.exoplayer2.video.a;

import com.google.android.exoplayer2.g.ae;
import com.google.android.exoplayer2.g.q;
import com.google.android.exoplayer2.g.r;
import com.google.android.exoplayer2.video.a.d;
import java.util.ArrayList;
import java.util.zip.Inflater;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    private static final int f33683a = ae.h("ytmp");

    /* renamed from: b  reason: collision with root package name */
    private static final int f33684b = ae.h("mshp");

    /* renamed from: c  reason: collision with root package name */
    private static final int f33685c = ae.h("raw ");

    /* renamed from: d  reason: collision with root package name */
    private static final int f33686d = ae.h("dfl8");

    /* renamed from: e  reason: collision with root package name */
    private static final int f33687e = ae.h("mesh");

    /* renamed from: f  reason: collision with root package name */
    private static final int f33688f = ae.h("proj");

    private static int a(int i2) {
        return (-(i2 & 1)) ^ (i2 >> 1);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0043, code lost:
        r0.b(r5);
        r7 = a(r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.exoplayer2.video.a.d a(byte[] r7, int r8) {
        /*
            com.google.android.exoplayer2.g.r r0 = new com.google.android.exoplayer2.g.r
            r0.<init>((byte[]) r7)
            r7 = 4
            r1 = 1
            r2 = 0
            r3 = 0
            r0.d(r7)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0050 }
            int r7 = r0.i()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0050 }
            r0.c(r2)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0050 }
            int r4 = f33688f     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0050 }
            if (r7 != r4) goto L_0x0019
            r7 = 1
            goto L_0x001a
        L_0x0019:
            r7 = 0
        L_0x001a:
            if (r7 == 0) goto L_0x004b
            r7 = 8
            r0.d(r7)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0050 }
            int r7 = r0.f32567b     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0050 }
            int r4 = r0.f32568c     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0050 }
        L_0x0025:
            if (r7 >= r4) goto L_0x0050
            int r5 = r0.i()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0050 }
            int r5 = r5 + r7
            if (r5 <= r7) goto L_0x0050
            if (r5 <= r4) goto L_0x0031
            goto L_0x0050
        L_0x0031:
            int r7 = r0.i()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0050 }
            int r6 = f33683a     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0050 }
            if (r7 == r6) goto L_0x0043
            int r6 = f33684b     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0050 }
            if (r7 != r6) goto L_0x003e
            goto L_0x0043
        L_0x003e:
            r0.c(r5)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0050 }
            r7 = r5
            goto L_0x0025
        L_0x0043:
            r0.b(r5)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0050 }
            java.util.ArrayList r7 = a((com.google.android.exoplayer2.g.r) r0)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0050 }
            goto L_0x0051
        L_0x004b:
            java.util.ArrayList r7 = a((com.google.android.exoplayer2.g.r) r0)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0050 }
            goto L_0x0051
        L_0x0050:
            r7 = r3
        L_0x0051:
            if (r7 != 0) goto L_0x0054
            return r3
        L_0x0054:
            int r0 = r7.size()
            if (r0 == r1) goto L_0x0070
            r4 = 2
            if (r0 == r4) goto L_0x005e
            return r3
        L_0x005e:
            com.google.android.exoplayer2.video.a.d r0 = new com.google.android.exoplayer2.video.a.d
            java.lang.Object r2 = r7.get(r2)
            com.google.android.exoplayer2.video.a.d$a r2 = (com.google.android.exoplayer2.video.a.d.a) r2
            java.lang.Object r7 = r7.get(r1)
            com.google.android.exoplayer2.video.a.d$a r7 = (com.google.android.exoplayer2.video.a.d.a) r7
            r0.<init>(r2, r7, r8)
            return r0
        L_0x0070:
            com.google.android.exoplayer2.video.a.d r0 = new com.google.android.exoplayer2.video.a.d
            java.lang.Object r7 = r7.get(r2)
            com.google.android.exoplayer2.video.a.d$a r7 = (com.google.android.exoplayer2.video.a.d.a) r7
            r0.<init>(r7, r8)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.video.a.e.a(byte[], int):com.google.android.exoplayer2.video.a.d");
    }

    private static ArrayList<d.a> a(r rVar) {
        if (rVar.c() != 0) {
            return null;
        }
        rVar.d(7);
        int i2 = rVar.i();
        if (i2 == f33686d) {
            r rVar2 = new r();
            Inflater inflater = new Inflater(true);
            try {
                if (!ae.a(rVar, rVar2, inflater)) {
                    return null;
                }
                inflater.end();
                rVar = rVar2;
            } finally {
                inflater.end();
            }
        } else if (i2 != f33685c) {
            return null;
        }
        return b(rVar);
    }

    private static ArrayList<d.a> b(r rVar) {
        ArrayList<d.a> arrayList = new ArrayList<>();
        int i2 = rVar.f32567b;
        int i3 = rVar.f32568c;
        while (i2 < i3) {
            int i4 = rVar.i() + i2;
            if (i4 <= i2 || i4 > i3) {
                return null;
            }
            if (rVar.i() == f33687e) {
                d.a c2 = c(rVar);
                if (c2 == null) {
                    return null;
                }
                arrayList.add(c2);
            }
            rVar.c(i4);
            i2 = i4;
        }
        return arrayList;
    }

    private static d.a c(r rVar) {
        r rVar2 = rVar;
        int i2 = rVar.i();
        if (i2 > 10000) {
            return null;
        }
        float[] fArr = new float[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            fArr[i3] = Float.intBitsToFloat(rVar.i());
        }
        int i4 = rVar.i();
        if (i4 > 32000) {
            return null;
        }
        double d2 = 2.0d;
        double log = Math.log(2.0d);
        int ceil = (int) Math.ceil(Math.log(((double) i2) * 2.0d) / log);
        q qVar = new q(rVar2.f32566a);
        int i5 = 8;
        qVar.a(rVar2.f32567b * 8);
        float[] fArr2 = new float[(i4 * 5)];
        int i6 = 5;
        int[] iArr = new int[5];
        int i7 = 0;
        int i8 = 0;
        while (i7 < i4) {
            int i9 = 0;
            while (i9 < i6) {
                int a2 = iArr[i9] + a(qVar.c(ceil));
                if (a2 >= i2 || a2 < 0) {
                    return null;
                }
                fArr2[i8] = fArr[a2];
                iArr[i9] = a2;
                i9++;
                i8++;
                i6 = 5;
            }
            i7++;
            i6 = 5;
        }
        qVar.a((qVar.b() + 7) & -8);
        int i10 = 32;
        int c2 = qVar.c(32);
        d.b[] bVarArr = new d.b[c2];
        int i11 = 0;
        while (i11 < c2) {
            int c3 = qVar.c(i5);
            int c4 = qVar.c(i5);
            int c5 = qVar.c(i10);
            if (c5 > 128000) {
                return null;
            }
            int i12 = c3;
            int ceil2 = (int) Math.ceil(Math.log(((double) i4) * d2) / log);
            float[] fArr3 = new float[(c5 * 3)];
            float[] fArr4 = new float[(c5 * 2)];
            int i13 = 0;
            for (int i14 = 0; i14 < c5; i14++) {
                i13 += a(qVar.c(ceil2));
                if (i13 < 0 || i13 >= i4) {
                    return null;
                }
                int i15 = i14 * 3;
                int i16 = i13 * 5;
                fArr3[i15] = fArr2[i16];
                fArr3[i15 + 1] = fArr2[i16 + 1];
                fArr3[i15 + 2] = fArr2[i16 + 2];
                int i17 = i14 * 2;
                fArr4[i17] = fArr2[i16 + 3];
                fArr4[i17 + 1] = fArr2[i16 + 4];
            }
            bVarArr[i11] = new d.b(i12, fArr3, fArr4, c4);
            i11++;
            i10 = 32;
            d2 = 2.0d;
            i5 = 8;
        }
        return new d.a(bVarArr);
    }
}
