package com.google.zxing.e;

import com.google.zxing.b.a;
import com.google.zxing.e;
import com.google.zxing.h;
import com.google.zxing.m;
import com.google.zxing.r;
import com.google.zxing.t;
import java.util.Map;

public final class n extends r {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f40382a = {6, 8, 10, 12, 14};

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f40383c = {1, 1, 1, 1};

    /* renamed from: d  reason: collision with root package name */
    private static final int[][] f40384d = {new int[]{1, 1, 2}, new int[]{1, 1, 3}};

    /* renamed from: e  reason: collision with root package name */
    private static final int[][] f40385e = {new int[]{1, 1, 2, 2, 1}, new int[]{2, 1, 1, 1, 2}, new int[]{1, 2, 1, 1, 2}, new int[]{2, 2, 1, 1, 1}, new int[]{1, 1, 2, 1, 2}, new int[]{2, 1, 2, 1, 1}, new int[]{1, 2, 2, 1, 1}, new int[]{1, 1, 1, 2, 2}, new int[]{2, 1, 1, 2, 1}, new int[]{1, 2, 1, 2, 1}, new int[]{1, 1, 3, 3, 1}, new int[]{3, 1, 1, 1, 3}, new int[]{1, 3, 1, 1, 3}, new int[]{3, 3, 1, 1, 1}, new int[]{1, 1, 3, 1, 3}, new int[]{3, 1, 3, 1, 1}, new int[]{1, 3, 3, 1, 1}, new int[]{1, 1, 1, 3, 3}, new int[]{3, 1, 1, 3, 1}, new int[]{1, 3, 1, 3, 1}};

    /* renamed from: b  reason: collision with root package name */
    private int f40386b = -1;

    private static void a(a aVar, int i2, int i3, StringBuilder sb) throws m {
        int[] iArr = new int[10];
        int[] iArr2 = new int[5];
        int[] iArr3 = new int[5];
        while (i2 < i3) {
            a(aVar, i2, iArr);
            for (int i4 = 0; i4 < 5; i4++) {
                int i5 = i4 * 2;
                iArr2[i4] = iArr[i5];
                iArr3[i4] = iArr[i5 + 1];
            }
            sb.append((char) (a(iArr2) + 48));
            sb.append((char) (a(iArr3) + 48));
            for (int i6 = 0; i6 < 10; i6++) {
                i2 += iArr[i6];
            }
        }
    }

    private void a(a aVar, int i2) throws m {
        int i3 = this.f40386b * 10;
        if (i3 >= i2) {
            i3 = i2;
        }
        int i4 = i2 - 1;
        while (i3 > 0 && i4 >= 0 && !aVar.a(i4)) {
            i3--;
            i4--;
        }
        if (i3 != 0) {
            throw m.getNotFoundInstance();
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:6|7) */
    /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
        r0 = c(r7, r0, f40384d[1]);
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0012 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int[] b(com.google.zxing.b.a r7) throws com.google.zxing.m {
        /*
            r6 = this;
            r7.c()
            int r0 = a((com.google.zxing.b.a) r7)     // Catch:{ all -> 0x0031 }
            r1 = 1
            r2 = 0
            int[][] r3 = f40384d     // Catch:{ m -> 0x0012 }
            r3 = r3[r2]     // Catch:{ m -> 0x0012 }
            int[] r0 = c(r7, r0, r3)     // Catch:{ m -> 0x0012 }
            goto L_0x001a
        L_0x0012:
            int[][] r3 = f40384d     // Catch:{ all -> 0x0031 }
            r3 = r3[r1]     // Catch:{ all -> 0x0031 }
            int[] r0 = c(r7, r0, r3)     // Catch:{ all -> 0x0031 }
        L_0x001a:
            r3 = r0[r2]     // Catch:{ all -> 0x0031 }
            r6.a(r7, r3)     // Catch:{ all -> 0x0031 }
            r3 = r0[r2]     // Catch:{ all -> 0x0031 }
            int r4 = r7.f39881b     // Catch:{ all -> 0x0031 }
            r5 = r0[r1]     // Catch:{ all -> 0x0031 }
            int r4 = r4 - r5
            r0[r2] = r4     // Catch:{ all -> 0x0031 }
            int r2 = r7.f39881b     // Catch:{ all -> 0x0031 }
            int r2 = r2 - r3
            r0[r1] = r2     // Catch:{ all -> 0x0031 }
            r7.c()
            return r0
        L_0x0031:
            r0 = move-exception
            r7.c()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.e.n.b(com.google.zxing.b.a):int[]");
    }

    private static int[] c(a aVar, int i2, int[] iArr) throws m {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        int i3 = aVar.f39881b;
        int i4 = i2;
        boolean z = false;
        int i5 = 0;
        while (i2 < i3) {
            if (aVar.a(i2) != z) {
                iArr2[i5] = iArr2[i5] + 1;
            } else {
                if (i5 != length - 1) {
                    i5++;
                } else if (a(iArr2, iArr, 0.5f) < 0.38f) {
                    return new int[]{i4, i2};
                } else {
                    i4 += iArr2[0] + iArr2[1];
                    int i6 = i5 - 1;
                    System.arraycopy(iArr2, 2, iArr2, 0, i6);
                    iArr2[i6] = 0;
                    iArr2[i5] = 0;
                    i5--;
                }
                iArr2[i5] = 1;
                z = !z;
            }
            i2++;
        }
        throw m.getNotFoundInstance();
    }

    private static int a(int[] iArr) throws m {
        int length = f40385e.length;
        int i2 = -1;
        float f2 = 0.38f;
        for (int i3 = 0; i3 < length; i3++) {
            float a2 = a(iArr, f40385e[i3], 0.5f);
            if (a2 < f2) {
                i2 = i3;
                f2 = a2;
            } else if (a2 == f2) {
                i2 = -1;
            }
        }
        if (i2 >= 0) {
            return i2 % 10;
        }
        throw m.getNotFoundInstance();
    }

    public final r a(int i2, a aVar, Map<e, ?> map) throws h, m {
        boolean z;
        int[] c2 = c(aVar, a(aVar), f40383c);
        this.f40386b = (c2[1] - c2[0]) / 4;
        a(aVar, c2[0]);
        int[] b2 = b(aVar);
        StringBuilder sb = new StringBuilder(20);
        a(aVar, c2[1], b2[0], sb);
        String sb2 = sb.toString();
        int[] iArr = map != null ? (int[]) map.get(e.ALLOWED_LENGTHS) : null;
        if (iArr == null) {
            iArr = f40382a;
        }
        int length = sb2.length();
        int length2 = iArr.length;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (i3 >= length2) {
                z = false;
                break;
            }
            int i5 = iArr[i3];
            if (length == i5) {
                z = true;
                break;
            }
            if (i5 > i4) {
                i4 = i5;
            }
            i3++;
        }
        if (!z && length > i4) {
            z = true;
        }
        if (z) {
            float f2 = (float) i2;
            return new r(sb2, (byte[]) null, new t[]{new t((float) c2[1], f2), new t((float) b2[0], f2)}, com.google.zxing.a.ITF);
        }
        throw h.getFormatInstance();
    }

    private static int a(a aVar) throws m {
        int i2 = aVar.f39881b;
        int c2 = aVar.c(0);
        if (c2 != i2) {
            return c2;
        }
        throw m.getNotFoundInstance();
    }
}
