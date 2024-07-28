package com.google.zxing.g.b;

import com.google.zxing.u;
import java.util.ArrayList;
import java.util.List;

final class b {

    /* renamed from: a  reason: collision with root package name */
    final com.google.zxing.b.b f40524a;

    /* renamed from: b  reason: collision with root package name */
    final List<a> f40525b = new ArrayList(5);

    /* renamed from: c  reason: collision with root package name */
    final int f40526c;

    /* renamed from: d  reason: collision with root package name */
    final int f40527d;

    /* renamed from: e  reason: collision with root package name */
    final int f40528e;

    /* renamed from: f  reason: collision with root package name */
    final int f40529f;

    /* renamed from: g  reason: collision with root package name */
    private final float f40530g;

    /* renamed from: h  reason: collision with root package name */
    private final int[] f40531h;

    /* renamed from: i  reason: collision with root package name */
    private final u f40532i;

    b(com.google.zxing.b.b bVar, int i2, int i3, int i4, int i5, float f2, u uVar) {
        this.f40524a = bVar;
        this.f40526c = i2;
        this.f40527d = i3;
        this.f40528e = i4;
        this.f40529f = i5;
        this.f40530g = f2;
        this.f40531h = new int[3];
        this.f40532i = uVar;
    }

    private static float a(int[] iArr, int i2) {
        return ((float) (i2 - iArr[2])) - (((float) iArr[1]) / 2.0f);
    }

    /* access modifiers changed from: package-private */
    public final boolean a(int[] iArr) {
        float f2 = this.f40530g;
        float f3 = f2 / 2.0f;
        for (int i2 = 0; i2 < 3; i2++) {
            if (Math.abs(f2 - ((float) iArr[i2])) >= f3) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0100 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.zxing.g.b.a a(int[] r13, int r14, int r15) {
        /*
            r12 = this;
            r0 = 0
            r1 = r13[r0]
            r2 = 1
            r3 = r13[r2]
            int r1 = r1 + r3
            r3 = 2
            r4 = r13[r3]
            int r1 = r1 + r4
            float r15 = a(r13, r15)
            int r4 = (int) r15
            r5 = r13[r2]
            int r5 = r5 * 2
            com.google.zxing.b.b r6 = r12.f40524a
            int r7 = r6.f39890b
            int[] r8 = r12.f40531h
            r8[r0] = r0
            r8[r2] = r0
            r8[r3] = r0
            r9 = r14
        L_0x0021:
            if (r9 < 0) goto L_0x0035
            boolean r10 = r6.a((int) r4, (int) r9)
            if (r10 == 0) goto L_0x0035
            r10 = r8[r2]
            if (r10 > r5) goto L_0x0035
            r10 = r8[r2]
            int r10 = r10 + r2
            r8[r2] = r10
            int r9 = r9 + -1
            goto L_0x0021
        L_0x0035:
            r10 = 2143289344(0x7fc00000, float:NaN)
            if (r9 < 0) goto L_0x00ab
            r11 = r8[r2]
            if (r11 <= r5) goto L_0x003f
            goto L_0x00ab
        L_0x003f:
            if (r9 < 0) goto L_0x0053
            boolean r11 = r6.a((int) r4, (int) r9)
            if (r11 != 0) goto L_0x0053
            r11 = r8[r0]
            if (r11 > r5) goto L_0x0053
            r11 = r8[r0]
            int r11 = r11 + r2
            r8[r0] = r11
            int r9 = r9 + -1
            goto L_0x003f
        L_0x0053:
            r9 = r8[r0]
            if (r9 <= r5) goto L_0x0058
            goto L_0x00ab
        L_0x0058:
            int r14 = r14 + r2
        L_0x0059:
            if (r14 >= r7) goto L_0x006d
            boolean r9 = r6.a((int) r4, (int) r14)
            if (r9 == 0) goto L_0x006d
            r9 = r8[r2]
            if (r9 > r5) goto L_0x006d
            r9 = r8[r2]
            int r9 = r9 + r2
            r8[r2] = r9
            int r14 = r14 + 1
            goto L_0x0059
        L_0x006d:
            if (r14 == r7) goto L_0x00ab
            r9 = r8[r2]
            if (r9 <= r5) goto L_0x0074
            goto L_0x00ab
        L_0x0074:
            if (r14 >= r7) goto L_0x0088
            boolean r9 = r6.a((int) r4, (int) r14)
            if (r9 != 0) goto L_0x0088
            r9 = r8[r3]
            if (r9 > r5) goto L_0x0088
            r9 = r8[r3]
            int r9 = r9 + r2
            r8[r3] = r9
            int r14 = r14 + 1
            goto L_0x0074
        L_0x0088:
            r4 = r8[r3]
            if (r4 <= r5) goto L_0x008d
            goto L_0x00ab
        L_0x008d:
            r4 = r8[r0]
            r5 = r8[r2]
            int r4 = r4 + r5
            r5 = r8[r3]
            int r4 = r4 + r5
            int r4 = r4 - r1
            int r4 = java.lang.Math.abs(r4)
            int r4 = r4 * 5
            int r1 = r1 * 2
            if (r4 < r1) goto L_0x00a1
            goto L_0x00ab
        L_0x00a1:
            boolean r1 = r12.a(r8)
            if (r1 == 0) goto L_0x00ab
            float r10 = a(r8, r14)
        L_0x00ab:
            boolean r14 = java.lang.Float.isNaN(r10)
            if (r14 != 0) goto L_0x0125
            r14 = r13[r0]
            r1 = r13[r2]
            int r14 = r14 + r1
            r13 = r13[r3]
            int r14 = r14 + r13
            float r13 = (float) r14
            r14 = 1077936128(0x40400000, float:3.0)
            float r13 = r13 / r14
            java.util.List<com.google.zxing.g.b.a> r14 = r12.f40525b
            java.util.Iterator r14 = r14.iterator()
        L_0x00c3:
            boolean r1 = r14.hasNext()
            if (r1 == 0) goto L_0x0114
            java.lang.Object r1 = r14.next()
            com.google.zxing.g.b.a r1 = (com.google.zxing.g.b.a) r1
            float r3 = r1.f40585b
            float r3 = r10 - r3
            float r3 = java.lang.Math.abs(r3)
            int r3 = (r3 > r13 ? 1 : (r3 == r13 ? 0 : -1))
            if (r3 > 0) goto L_0x00fd
            float r3 = r1.f40584a
            float r3 = r15 - r3
            float r3 = java.lang.Math.abs(r3)
            int r3 = (r3 > r13 ? 1 : (r3 == r13 ? 0 : -1))
            if (r3 > 0) goto L_0x00fd
            float r3 = r1.f40523c
            float r3 = r13 - r3
            float r3 = java.lang.Math.abs(r3)
            r4 = 1065353216(0x3f800000, float:1.0)
            int r4 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r4 <= 0) goto L_0x00fb
            float r4 = r1.f40523c
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 > 0) goto L_0x00fd
        L_0x00fb:
            r3 = 1
            goto L_0x00fe
        L_0x00fd:
            r3 = 0
        L_0x00fe:
            if (r3 == 0) goto L_0x00c3
            float r14 = r1.f40584a
            float r14 = r14 + r15
            r15 = 1073741824(0x40000000, float:2.0)
            float r14 = r14 / r15
            float r0 = r1.f40585b
            float r0 = r0 + r10
            float r0 = r0 / r15
            float r1 = r1.f40523c
            float r1 = r1 + r13
            float r1 = r1 / r15
            com.google.zxing.g.b.a r13 = new com.google.zxing.g.b.a
            r13.<init>(r14, r0, r1)
            return r13
        L_0x0114:
            com.google.zxing.g.b.a r14 = new com.google.zxing.g.b.a
            r14.<init>(r15, r10, r13)
            java.util.List<com.google.zxing.g.b.a> r13 = r12.f40525b
            r13.add(r14)
            com.google.zxing.u r13 = r12.f40532i
            if (r13 == 0) goto L_0x0125
            r13.a(r14)
        L_0x0125:
            r13 = 0
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.g.b.b.a(int[], int, int):com.google.zxing.g.b.a");
    }
}
