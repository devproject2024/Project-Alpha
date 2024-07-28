package com.google.android.gms.internal.vision;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

final class fx<T> implements gi<T> {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f11145a = new int[0];

    /* renamed from: b  reason: collision with root package name */
    private static final Unsafe f11146b = hg.c();

    /* renamed from: c  reason: collision with root package name */
    private final int[] f11147c;

    /* renamed from: d  reason: collision with root package name */
    private final Object[] f11148d;

    /* renamed from: e  reason: collision with root package name */
    private final int f11149e;

    /* renamed from: f  reason: collision with root package name */
    private final int f11150f;

    /* renamed from: g  reason: collision with root package name */
    private final ft f11151g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f11152h;

    /* renamed from: i  reason: collision with root package name */
    private final boolean f11153i;
    private final boolean j;
    private final boolean k;
    private final int[] l;
    private final int m;
    private final int n;
    private final gb o;
    private final fc p;
    private final ha<?, ?> q;
    private final dw<?> r;
    private final fl s;

    private fx(int[] iArr, Object[] objArr, int i2, int i3, ft ftVar, boolean z, int[] iArr2, int i4, int i5, gb gbVar, fc fcVar, ha<?, ?> haVar, dw<?> dwVar, fl flVar) {
        this.f11147c = iArr;
        this.f11148d = objArr;
        this.f11149e = i2;
        this.f11150f = i3;
        this.f11153i = ftVar instanceof ej;
        this.j = z;
        this.f11152h = dwVar != null && dwVar.a(ftVar);
        this.k = false;
        this.l = iArr2;
        this.m = i4;
        this.n = i5;
        this.o = gbVar;
        this.p = fcVar;
        this.q = haVar;
        this.r = dwVar;
        this.f11151g = ftVar;
        this.s = flVar;
    }

    private static boolean e(int i2) {
        return (i2 & 536870912) != 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:164:0x034e  */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x0397  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static <T> com.google.android.gms.internal.vision.fx<T> a(com.google.android.gms.internal.vision.fr r34, com.google.android.gms.internal.vision.gb r35, com.google.android.gms.internal.vision.fc r36, com.google.android.gms.internal.vision.ha<?, ?> r37, com.google.android.gms.internal.vision.dw<?> r38, com.google.android.gms.internal.vision.fl r39) {
        /*
            r0 = r34
            boolean r1 = r0 instanceof com.google.android.gms.internal.vision.gg
            if (r1 == 0) goto L_0x0408
            com.google.android.gms.internal.vision.gg r0 = (com.google.android.gms.internal.vision.gg) r0
            int r1 = r0.a()
            int r2 = com.google.android.gms.internal.vision.ej.e.f11108i
            r3 = 0
            r4 = 1
            if (r1 != r2) goto L_0x0014
            r11 = 1
            goto L_0x0015
        L_0x0014:
            r11 = 0
        L_0x0015:
            java.lang.String r1 = r0.f11173b
            int r2 = r1.length()
            char r5 = r1.charAt(r3)
            r6 = 55296(0xd800, float:7.7486E-41)
            if (r5 < r6) goto L_0x0030
            r5 = 1
        L_0x0025:
            int r7 = r5 + 1
            char r5 = r1.charAt(r5)
            if (r5 >= r6) goto L_0x002e
            goto L_0x0031
        L_0x002e:
            r5 = r7
            goto L_0x0025
        L_0x0030:
            r7 = 1
        L_0x0031:
            int r5 = r7 + 1
            char r7 = r1.charAt(r7)
            if (r7 < r6) goto L_0x0050
            r7 = r7 & 8191(0x1fff, float:1.1478E-41)
            r9 = 13
        L_0x003d:
            int r10 = r5 + 1
            char r5 = r1.charAt(r5)
            if (r5 < r6) goto L_0x004d
            r5 = r5 & 8191(0x1fff, float:1.1478E-41)
            int r5 = r5 << r9
            r7 = r7 | r5
            int r9 = r9 + 13
            r5 = r10
            goto L_0x003d
        L_0x004d:
            int r5 = r5 << r9
            r7 = r7 | r5
            goto L_0x0051
        L_0x0050:
            r10 = r5
        L_0x0051:
            if (r7 != 0) goto L_0x0061
            int[] r5 = f11145a
            r17 = r5
            r5 = 0
            r9 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            goto L_0x0188
        L_0x0061:
            int r5 = r10 + 1
            char r7 = r1.charAt(r10)
            if (r7 < r6) goto L_0x0080
            r7 = r7 & 8191(0x1fff, float:1.1478E-41)
            r9 = 13
        L_0x006d:
            int r10 = r5 + 1
            char r5 = r1.charAt(r5)
            if (r5 < r6) goto L_0x007d
            r5 = r5 & 8191(0x1fff, float:1.1478E-41)
            int r5 = r5 << r9
            r7 = r7 | r5
            int r9 = r9 + 13
            r5 = r10
            goto L_0x006d
        L_0x007d:
            int r5 = r5 << r9
            r5 = r5 | r7
            goto L_0x0082
        L_0x0080:
            r10 = r5
            r5 = r7
        L_0x0082:
            int r7 = r10 + 1
            char r9 = r1.charAt(r10)
            if (r9 < r6) goto L_0x00a1
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            r10 = 13
        L_0x008e:
            int r12 = r7 + 1
            char r7 = r1.charAt(r7)
            if (r7 < r6) goto L_0x009e
            r7 = r7 & 8191(0x1fff, float:1.1478E-41)
            int r7 = r7 << r10
            r9 = r9 | r7
            int r10 = r10 + 13
            r7 = r12
            goto L_0x008e
        L_0x009e:
            int r7 = r7 << r10
            r9 = r9 | r7
            goto L_0x00a2
        L_0x00a1:
            r12 = r7
        L_0x00a2:
            int r7 = r12 + 1
            char r10 = r1.charAt(r12)
            if (r10 < r6) goto L_0x00c2
            r10 = r10 & 8191(0x1fff, float:1.1478E-41)
            r12 = 13
        L_0x00ae:
            int r13 = r7 + 1
            char r7 = r1.charAt(r7)
            if (r7 < r6) goto L_0x00be
            r7 = r7 & 8191(0x1fff, float:1.1478E-41)
            int r7 = r7 << r12
            r10 = r10 | r7
            int r12 = r12 + 13
            r7 = r13
            goto L_0x00ae
        L_0x00be:
            int r7 = r7 << r12
            r7 = r7 | r10
            r10 = r7
            goto L_0x00c3
        L_0x00c2:
            r13 = r7
        L_0x00c3:
            int r7 = r13 + 1
            char r12 = r1.charAt(r13)
            if (r12 < r6) goto L_0x00e3
            r12 = r12 & 8191(0x1fff, float:1.1478E-41)
            r13 = 13
        L_0x00cf:
            int r14 = r7 + 1
            char r7 = r1.charAt(r7)
            if (r7 < r6) goto L_0x00df
            r7 = r7 & 8191(0x1fff, float:1.1478E-41)
            int r7 = r7 << r13
            r12 = r12 | r7
            int r13 = r13 + 13
            r7 = r14
            goto L_0x00cf
        L_0x00df:
            int r7 = r7 << r13
            r7 = r7 | r12
            r12 = r7
            goto L_0x00e4
        L_0x00e3:
            r14 = r7
        L_0x00e4:
            int r7 = r14 + 1
            char r13 = r1.charAt(r14)
            if (r13 < r6) goto L_0x0104
            r13 = r13 & 8191(0x1fff, float:1.1478E-41)
            r14 = 13
        L_0x00f0:
            int r15 = r7 + 1
            char r7 = r1.charAt(r7)
            if (r7 < r6) goto L_0x0100
            r7 = r7 & 8191(0x1fff, float:1.1478E-41)
            int r7 = r7 << r14
            r13 = r13 | r7
            int r14 = r14 + 13
            r7 = r15
            goto L_0x00f0
        L_0x0100:
            int r7 = r7 << r14
            r7 = r7 | r13
            r13 = r7
            goto L_0x0105
        L_0x0104:
            r15 = r7
        L_0x0105:
            int r7 = r15 + 1
            char r14 = r1.charAt(r15)
            if (r14 < r6) goto L_0x0127
            r14 = r14 & 8191(0x1fff, float:1.1478E-41)
            r15 = 13
        L_0x0111:
            int r16 = r7 + 1
            char r7 = r1.charAt(r7)
            if (r7 < r6) goto L_0x0122
            r7 = r7 & 8191(0x1fff, float:1.1478E-41)
            int r7 = r7 << r15
            r14 = r14 | r7
            int r15 = r15 + 13
            r7 = r16
            goto L_0x0111
        L_0x0122:
            int r7 = r7 << r15
            r7 = r7 | r14
            r14 = r7
            r7 = r16
        L_0x0127:
            int r15 = r7 + 1
            char r7 = r1.charAt(r7)
            if (r7 < r6) goto L_0x014a
            r7 = r7 & 8191(0x1fff, float:1.1478E-41)
            r16 = 13
        L_0x0133:
            int r17 = r15 + 1
            char r15 = r1.charAt(r15)
            if (r15 < r6) goto L_0x0145
            r15 = r15 & 8191(0x1fff, float:1.1478E-41)
            int r15 = r15 << r16
            r7 = r7 | r15
            int r16 = r16 + 13
            r15 = r17
            goto L_0x0133
        L_0x0145:
            int r15 = r15 << r16
            r7 = r7 | r15
            r15 = r17
        L_0x014a:
            int r16 = r15 + 1
            char r15 = r1.charAt(r15)
            if (r15 < r6) goto L_0x0175
            r15 = r15 & 8191(0x1fff, float:1.1478E-41)
            r17 = 13
            r33 = r16
            r16 = r15
            r15 = r33
        L_0x015c:
            int r18 = r15 + 1
            char r15 = r1.charAt(r15)
            if (r15 < r6) goto L_0x016f
            r15 = r15 & 8191(0x1fff, float:1.1478E-41)
            int r15 = r15 << r17
            r16 = r16 | r15
            int r17 = r17 + 13
            r15 = r18
            goto L_0x015c
        L_0x016f:
            int r15 = r15 << r17
            r15 = r16 | r15
            r16 = r18
        L_0x0175:
            int r17 = r15 + r14
            int r7 = r17 + r7
            int[] r7 = new int[r7]
            int r17 = r5 << 1
            int r9 = r17 + r9
            r17 = r7
            r33 = r12
            r12 = r10
            r10 = r16
            r16 = r33
        L_0x0188:
            sun.misc.Unsafe r7 = f11146b
            java.lang.Object[] r3 = r0.f11174c
            com.google.android.gms.internal.vision.ft r8 = r0.f11172a
            java.lang.Class r8 = r8.getClass()
            int r6 = r13 * 3
            int[] r6 = new int[r6]
            int r13 = r13 << r4
            java.lang.Object[] r13 = new java.lang.Object[r13]
            int r14 = r14 + r15
            r21 = r9
            r23 = r14
            r22 = r15
            r9 = 0
            r20 = 0
        L_0x01a3:
            if (r10 >= r2) goto L_0x03e6
            int r24 = r10 + 1
            char r10 = r1.charAt(r10)
            r4 = 55296(0xd800, float:7.7486E-41)
            if (r10 < r4) goto L_0x01d7
            r10 = r10 & 8191(0x1fff, float:1.1478E-41)
            r26 = 13
            r33 = r24
            r24 = r10
            r10 = r33
        L_0x01ba:
            int r27 = r10 + 1
            char r10 = r1.charAt(r10)
            if (r10 < r4) goto L_0x01d0
            r4 = r10 & 8191(0x1fff, float:1.1478E-41)
            int r4 = r4 << r26
            r24 = r24 | r4
            int r26 = r26 + 13
            r10 = r27
            r4 = 55296(0xd800, float:7.7486E-41)
            goto L_0x01ba
        L_0x01d0:
            int r4 = r10 << r26
            r10 = r24 | r4
            r4 = r27
            goto L_0x01d9
        L_0x01d7:
            r4 = r24
        L_0x01d9:
            int r24 = r4 + 1
            char r4 = r1.charAt(r4)
            r26 = r2
            r2 = 55296(0xd800, float:7.7486E-41)
            if (r4 < r2) goto L_0x020d
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            r27 = 13
            r33 = r24
            r24 = r4
            r4 = r33
        L_0x01f0:
            int r28 = r4 + 1
            char r4 = r1.charAt(r4)
            if (r4 < r2) goto L_0x0206
            r2 = r4 & 8191(0x1fff, float:1.1478E-41)
            int r2 = r2 << r27
            r24 = r24 | r2
            int r27 = r27 + 13
            r4 = r28
            r2 = 55296(0xd800, float:7.7486E-41)
            goto L_0x01f0
        L_0x0206:
            int r2 = r4 << r27
            r4 = r24 | r2
            r2 = r28
            goto L_0x020f
        L_0x020d:
            r2 = r24
        L_0x020f:
            r24 = r14
            r14 = r4 & 255(0xff, float:3.57E-43)
            r27 = r15
            r15 = r4 & 1024(0x400, float:1.435E-42)
            if (r15 == 0) goto L_0x021e
            int r15 = r9 + 1
            r17[r9] = r20
            r9 = r15
        L_0x021e:
            r15 = 51
            r30 = r9
            if (r14 < r15) goto L_0x02bb
            int r15 = r2 + 1
            char r2 = r1.charAt(r2)
            r9 = 55296(0xd800, float:7.7486E-41)
            if (r2 < r9) goto L_0x024d
            r2 = r2 & 8191(0x1fff, float:1.1478E-41)
            r31 = 13
        L_0x0233:
            int r32 = r15 + 1
            char r15 = r1.charAt(r15)
            if (r15 < r9) goto L_0x0248
            r9 = r15 & 8191(0x1fff, float:1.1478E-41)
            int r9 = r9 << r31
            r2 = r2 | r9
            int r31 = r31 + 13
            r15 = r32
            r9 = 55296(0xd800, float:7.7486E-41)
            goto L_0x0233
        L_0x0248:
            int r9 = r15 << r31
            r2 = r2 | r9
            r15 = r32
        L_0x024d:
            int r9 = r14 + -51
            r31 = r15
            r15 = 9
            if (r9 == r15) goto L_0x026f
            r15 = 17
            if (r9 != r15) goto L_0x025a
            goto L_0x026f
        L_0x025a:
            r15 = 12
            if (r9 != r15) goto L_0x026d
            if (r11 != 0) goto L_0x026d
            int r9 = r20 / 3
            r15 = 1
            int r9 = r9 << r15
            int r9 = r9 + r15
            int r15 = r21 + 1
            r21 = r3[r21]
            r13[r9] = r21
            r21 = r15
        L_0x026d:
            r15 = 1
            goto L_0x027c
        L_0x026f:
            int r9 = r20 / 3
            r15 = 1
            int r9 = r9 << r15
            int r9 = r9 + r15
            int r25 = r21 + 1
            r21 = r3[r21]
            r13[r9] = r21
            r21 = r25
        L_0x027c:
            int r2 = r2 << r15
            r9 = r3[r2]
            boolean r15 = r9 instanceof java.lang.reflect.Field
            if (r15 == 0) goto L_0x0286
            java.lang.reflect.Field r9 = (java.lang.reflect.Field) r9
            goto L_0x028e
        L_0x0286:
            java.lang.String r9 = (java.lang.String) r9
            java.lang.reflect.Field r9 = a((java.lang.Class<?>) r8, (java.lang.String) r9)
            r3[r2] = r9
        L_0x028e:
            r15 = r10
            long r9 = r7.objectFieldOffset(r9)
            int r10 = (int) r9
            int r2 = r2 + 1
            r9 = r3[r2]
            r28 = r10
            boolean r10 = r9 instanceof java.lang.reflect.Field
            if (r10 == 0) goto L_0x02a1
            java.lang.reflect.Field r9 = (java.lang.reflect.Field) r9
            goto L_0x02a9
        L_0x02a1:
            java.lang.String r9 = (java.lang.String) r9
            java.lang.reflect.Field r9 = a((java.lang.Class<?>) r8, (java.lang.String) r9)
            r3[r2] = r9
        L_0x02a9:
            long r9 = r7.objectFieldOffset(r9)
            int r2 = (int) r9
            r10 = r28
            r29 = r31
            r28 = r21
            r21 = r12
            r12 = r8
            r8 = r2
            r2 = 0
            goto L_0x03ac
        L_0x02bb:
            r15 = r10
            int r9 = r21 + 1
            r10 = r3[r21]
            java.lang.String r10 = (java.lang.String) r10
            java.lang.reflect.Field r10 = a((java.lang.Class<?>) r8, (java.lang.String) r10)
            r21 = r12
            r12 = 9
            if (r14 == r12) goto L_0x032f
            r12 = 17
            if (r14 != r12) goto L_0x02d1
            goto L_0x032f
        L_0x02d1:
            r12 = 27
            if (r14 == r12) goto L_0x0320
            r12 = 49
            if (r14 != r12) goto L_0x02da
            goto L_0x0320
        L_0x02da:
            r12 = 12
            if (r14 == r12) goto L_0x030c
            r12 = 30
            if (r14 == r12) goto L_0x030c
            r12 = 44
            if (r14 != r12) goto L_0x02e7
            goto L_0x030c
        L_0x02e7:
            r12 = 50
            if (r14 != r12) goto L_0x033d
            int r12 = r22 + 1
            r17[r22] = r20
            int r22 = r20 / 3
            r25 = 1
            int r22 = r22 << 1
            int r28 = r9 + 1
            r9 = r3[r9]
            r13[r22] = r9
            r9 = r4 & 2048(0x800, float:2.87E-42)
            if (r9 == 0) goto L_0x0309
            int r22 = r22 + 1
            int r9 = r28 + 1
            r28 = r3[r28]
            r13[r22] = r28
            r28 = r9
        L_0x0309:
            r22 = r12
            goto L_0x033f
        L_0x030c:
            if (r11 != 0) goto L_0x031d
            int r12 = r20 / 3
            r25 = 1
            int r12 = r12 << 1
            int r12 = r12 + 1
            int r28 = r9 + 1
            r9 = r3[r9]
            r13[r12] = r9
            goto L_0x033f
        L_0x031d:
            r25 = 1
            goto L_0x033d
        L_0x0320:
            r25 = 1
            int r12 = r20 / 3
            int r12 = r12 << 1
            int r12 = r12 + 1
            int r28 = r9 + 1
            r9 = r3[r9]
            r13[r12] = r9
            goto L_0x033f
        L_0x032f:
            r25 = 1
            int r12 = r20 / 3
            int r12 = r12 << 1
            int r12 = r12 + 1
            java.lang.Class r28 = r10.getType()
            r13[r12] = r28
        L_0x033d:
            r28 = r9
        L_0x033f:
            long r9 = r7.objectFieldOffset(r10)
            int r10 = (int) r9
            r9 = r4 & 4096(0x1000, float:5.74E-42)
            r12 = 4096(0x1000, float:5.74E-42)
            if (r9 != r12) goto L_0x0397
            r9 = 17
            if (r14 > r9) goto L_0x0397
            int r9 = r2 + 1
            char r2 = r1.charAt(r2)
            r12 = 55296(0xd800, float:7.7486E-41)
            if (r2 < r12) goto L_0x0373
            r2 = r2 & 8191(0x1fff, float:1.1478E-41)
            r19 = 13
        L_0x035d:
            int r29 = r9 + 1
            char r9 = r1.charAt(r9)
            if (r9 < r12) goto L_0x036f
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            int r9 = r9 << r19
            r2 = r2 | r9
            int r19 = r19 + 13
            r9 = r29
            goto L_0x035d
        L_0x036f:
            int r9 = r9 << r19
            r2 = r2 | r9
            goto L_0x0375
        L_0x0373:
            r29 = r9
        L_0x0375:
            r9 = 1
            int r19 = r5 << 1
            int r25 = r2 / 32
            int r19 = r19 + r25
            r9 = r3[r19]
            boolean r12 = r9 instanceof java.lang.reflect.Field
            if (r12 == 0) goto L_0x0385
            java.lang.reflect.Field r9 = (java.lang.reflect.Field) r9
            goto L_0x038d
        L_0x0385:
            java.lang.String r9 = (java.lang.String) r9
            java.lang.reflect.Field r9 = a((java.lang.Class<?>) r8, (java.lang.String) r9)
            r3[r19] = r9
        L_0x038d:
            r12 = r8
            long r8 = r7.objectFieldOffset(r9)
            int r9 = (int) r8
            int r2 = r2 % 32
            r8 = r9
            goto L_0x039e
        L_0x0397:
            r12 = r8
            r8 = 1048575(0xfffff, float:1.469367E-39)
            r29 = r2
            r2 = 0
        L_0x039e:
            r9 = 18
            if (r14 < r9) goto L_0x03ac
            r9 = 49
            if (r14 > r9) goto L_0x03ac
            int r9 = r23 + 1
            r17[r23] = r10
            r23 = r9
        L_0x03ac:
            int r9 = r20 + 1
            r6[r20] = r15
            int r15 = r9 + 1
            r19 = r1
            r1 = r4 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x03bb
            r1 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x03bc
        L_0x03bb:
            r1 = 0
        L_0x03bc:
            r4 = r4 & 256(0x100, float:3.59E-43)
            if (r4 == 0) goto L_0x03c3
            r4 = 268435456(0x10000000, float:2.5243549E-29)
            goto L_0x03c4
        L_0x03c3:
            r4 = 0
        L_0x03c4:
            r1 = r1 | r4
            int r4 = r14 << 20
            r1 = r1 | r4
            r1 = r1 | r10
            r6[r9] = r1
            int r20 = r15 + 1
            int r1 = r2 << 20
            r1 = r1 | r8
            r6[r15] = r1
            r8 = r12
            r1 = r19
            r12 = r21
            r14 = r24
            r2 = r26
            r15 = r27
            r21 = r28
            r10 = r29
            r9 = r30
            r4 = 1
            goto L_0x01a3
        L_0x03e6:
            r21 = r12
            r24 = r14
            r27 = r15
            com.google.android.gms.internal.vision.fx r1 = new com.google.android.gms.internal.vision.fx
            com.google.android.gms.internal.vision.ft r10 = r0.f11172a
            r5 = r1
            r7 = r13
            r8 = r21
            r9 = r16
            r12 = r17
            r13 = r27
            r15 = r35
            r16 = r36
            r17 = r37
            r18 = r38
            r19 = r39
            r5.<init>(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            return r1
        L_0x0408:
            java.lang.NoSuchMethodError r0 = new java.lang.NoSuchMethodError
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.fx.a(com.google.android.gms.internal.vision.fr, com.google.android.gms.internal.vision.gb, com.google.android.gms.internal.vision.fc, com.google.android.gms.internal.vision.ha, com.google.android.gms.internal.vision.dw, com.google.android.gms.internal.vision.fl):com.google.android.gms.internal.vision.fx");
    }

    private static Field a(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            String name = cls.getName();
            String arrays = Arrays.toString(declaredFields);
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 40 + String.valueOf(name).length() + String.valueOf(arrays).length());
            sb.append("Field ");
            sb.append(str);
            sb.append(" for ");
            sb.append(name);
            sb.append(" not found. Known fields are ");
            sb.append(arrays);
            throw new RuntimeException(sb.toString());
        }
    }

    public final T a() {
        return this.o.a(this.f11151g);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x006a, code lost:
        if (com.google.android.gms.internal.vision.gk.a(com.google.android.gms.internal.vision.hg.f(r10, r6), com.google.android.gms.internal.vision.hg.f(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x007e, code lost:
        if (com.google.android.gms.internal.vision.hg.b(r10, r6) == com.google.android.gms.internal.vision.hg.b(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0090, code lost:
        if (com.google.android.gms.internal.vision.hg.a((java.lang.Object) r10, r6) == com.google.android.gms.internal.vision.hg.a((java.lang.Object) r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00a4, code lost:
        if (com.google.android.gms.internal.vision.hg.b(r10, r6) == com.google.android.gms.internal.vision.hg.b(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00b6, code lost:
        if (com.google.android.gms.internal.vision.hg.a((java.lang.Object) r10, r6) == com.google.android.gms.internal.vision.hg.a((java.lang.Object) r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00c8, code lost:
        if (com.google.android.gms.internal.vision.hg.a((java.lang.Object) r10, r6) == com.google.android.gms.internal.vision.hg.a((java.lang.Object) r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00da, code lost:
        if (com.google.android.gms.internal.vision.hg.a((java.lang.Object) r10, r6) == com.google.android.gms.internal.vision.hg.a((java.lang.Object) r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00f0, code lost:
        if (com.google.android.gms.internal.vision.gk.a(com.google.android.gms.internal.vision.hg.f(r10, r6), com.google.android.gms.internal.vision.hg.f(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0106, code lost:
        if (com.google.android.gms.internal.vision.gk.a(com.google.android.gms.internal.vision.hg.f(r10, r6), com.google.android.gms.internal.vision.hg.f(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x011c, code lost:
        if (com.google.android.gms.internal.vision.gk.a(com.google.android.gms.internal.vision.hg.f(r10, r6), com.google.android.gms.internal.vision.hg.f(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x012e, code lost:
        if (com.google.android.gms.internal.vision.hg.c(r10, r6) == com.google.android.gms.internal.vision.hg.c(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0140, code lost:
        if (com.google.android.gms.internal.vision.hg.a((java.lang.Object) r10, r6) == com.google.android.gms.internal.vision.hg.a((java.lang.Object) r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0154, code lost:
        if (com.google.android.gms.internal.vision.hg.b(r10, r6) == com.google.android.gms.internal.vision.hg.b(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0165, code lost:
        if (com.google.android.gms.internal.vision.hg.a((java.lang.Object) r10, r6) == com.google.android.gms.internal.vision.hg.a((java.lang.Object) r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0178, code lost:
        if (com.google.android.gms.internal.vision.hg.b(r10, r6) == com.google.android.gms.internal.vision.hg.b(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x018b, code lost:
        if (com.google.android.gms.internal.vision.hg.b(r10, r6) == com.google.android.gms.internal.vision.hg.b(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x01a4, code lost:
        if (java.lang.Float.floatToIntBits(com.google.android.gms.internal.vision.hg.d(r10, r6)) == java.lang.Float.floatToIntBits(com.google.android.gms.internal.vision.hg.d(r11, r6))) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x01bf, code lost:
        if (java.lang.Double.doubleToLongBits(com.google.android.gms.internal.vision.hg.e(r10, r6)) == java.lang.Double.doubleToLongBits(com.google.android.gms.internal.vision.hg.e(r11, r6))) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x01c1, code lost:
        r3 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0038, code lost:
        if (com.google.android.gms.internal.vision.gk.a(com.google.android.gms.internal.vision.hg.f(r10, r6), com.google.android.gms.internal.vision.hg.f(r11, r6)) != false) goto L_0x01c2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(T r10, T r11) {
        /*
            r9 = this;
            int[] r0 = r9.f11147c
            int r0 = r0.length
            r1 = 0
            r2 = 0
        L_0x0005:
            r3 = 1
            if (r2 >= r0) goto L_0x01c9
            int r4 = r9.c((int) r2)
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r6 = r4 & r5
            long r6 = (long) r6
            r8 = 267386880(0xff00000, float:2.3665827E-29)
            r4 = r4 & r8
            int r4 = r4 >>> 20
            switch(r4) {
                case 0: goto L_0x01a7;
                case 1: goto L_0x018e;
                case 2: goto L_0x017b;
                case 3: goto L_0x0168;
                case 4: goto L_0x0157;
                case 5: goto L_0x0144;
                case 6: goto L_0x0132;
                case 7: goto L_0x0120;
                case 8: goto L_0x010a;
                case 9: goto L_0x00f4;
                case 10: goto L_0x00de;
                case 11: goto L_0x00cc;
                case 12: goto L_0x00ba;
                case 13: goto L_0x00a8;
                case 14: goto L_0x0094;
                case 15: goto L_0x0082;
                case 16: goto L_0x006e;
                case 17: goto L_0x0058;
                case 18: goto L_0x004a;
                case 19: goto L_0x004a;
                case 20: goto L_0x004a;
                case 21: goto L_0x004a;
                case 22: goto L_0x004a;
                case 23: goto L_0x004a;
                case 24: goto L_0x004a;
                case 25: goto L_0x004a;
                case 26: goto L_0x004a;
                case 27: goto L_0x004a;
                case 28: goto L_0x004a;
                case 29: goto L_0x004a;
                case 30: goto L_0x004a;
                case 31: goto L_0x004a;
                case 32: goto L_0x004a;
                case 33: goto L_0x004a;
                case 34: goto L_0x004a;
                case 35: goto L_0x004a;
                case 36: goto L_0x004a;
                case 37: goto L_0x004a;
                case 38: goto L_0x004a;
                case 39: goto L_0x004a;
                case 40: goto L_0x004a;
                case 41: goto L_0x004a;
                case 42: goto L_0x004a;
                case 43: goto L_0x004a;
                case 44: goto L_0x004a;
                case 45: goto L_0x004a;
                case 46: goto L_0x004a;
                case 47: goto L_0x004a;
                case 48: goto L_0x004a;
                case 49: goto L_0x004a;
                case 50: goto L_0x003c;
                case 51: goto L_0x001c;
                case 52: goto L_0x001c;
                case 53: goto L_0x001c;
                case 54: goto L_0x001c;
                case 55: goto L_0x001c;
                case 56: goto L_0x001c;
                case 57: goto L_0x001c;
                case 58: goto L_0x001c;
                case 59: goto L_0x001c;
                case 60: goto L_0x001c;
                case 61: goto L_0x001c;
                case 62: goto L_0x001c;
                case 63: goto L_0x001c;
                case 64: goto L_0x001c;
                case 65: goto L_0x001c;
                case 66: goto L_0x001c;
                case 67: goto L_0x001c;
                case 68: goto L_0x001c;
                default: goto L_0x001a;
            }
        L_0x001a:
            goto L_0x01c2
        L_0x001c:
            int r4 = r9.d((int) r2)
            r4 = r4 & r5
            long r4 = (long) r4
            int r8 = com.google.android.gms.internal.vision.hg.a((java.lang.Object) r10, (long) r4)
            int r4 = com.google.android.gms.internal.vision.hg.a((java.lang.Object) r11, (long) r4)
            if (r8 != r4) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.vision.hg.f(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.vision.hg.f(r11, r6)
            boolean r4 = com.google.android.gms.internal.vision.gk.a((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x003c:
            java.lang.Object r3 = com.google.android.gms.internal.vision.hg.f(r10, r6)
            java.lang.Object r4 = com.google.android.gms.internal.vision.hg.f(r11, r6)
            boolean r3 = com.google.android.gms.internal.vision.gk.a((java.lang.Object) r3, (java.lang.Object) r4)
            goto L_0x01c2
        L_0x004a:
            java.lang.Object r3 = com.google.android.gms.internal.vision.hg.f(r10, r6)
            java.lang.Object r4 = com.google.android.gms.internal.vision.hg.f(r11, r6)
            boolean r3 = com.google.android.gms.internal.vision.gk.a((java.lang.Object) r3, (java.lang.Object) r4)
            goto L_0x01c2
        L_0x0058:
            boolean r4 = r9.c(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.vision.hg.f(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.vision.hg.f(r11, r6)
            boolean r4 = com.google.android.gms.internal.vision.gk.a((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x006e:
            boolean r4 = r9.c(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.vision.hg.b(r10, r6)
            long r6 = com.google.android.gms.internal.vision.hg.b(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x0082:
            boolean r4 = r9.c(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.vision.hg.a((java.lang.Object) r10, (long) r6)
            int r5 = com.google.android.gms.internal.vision.hg.a((java.lang.Object) r11, (long) r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x0094:
            boolean r4 = r9.c(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.vision.hg.b(r10, r6)
            long r6 = com.google.android.gms.internal.vision.hg.b(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x00a8:
            boolean r4 = r9.c(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.vision.hg.a((java.lang.Object) r10, (long) r6)
            int r5 = com.google.android.gms.internal.vision.hg.a((java.lang.Object) r11, (long) r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x00ba:
            boolean r4 = r9.c(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.vision.hg.a((java.lang.Object) r10, (long) r6)
            int r5 = com.google.android.gms.internal.vision.hg.a((java.lang.Object) r11, (long) r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x00cc:
            boolean r4 = r9.c(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.vision.hg.a((java.lang.Object) r10, (long) r6)
            int r5 = com.google.android.gms.internal.vision.hg.a((java.lang.Object) r11, (long) r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x00de:
            boolean r4 = r9.c(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.vision.hg.f(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.vision.hg.f(r11, r6)
            boolean r4 = com.google.android.gms.internal.vision.gk.a((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x00f4:
            boolean r4 = r9.c(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.vision.hg.f(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.vision.hg.f(r11, r6)
            boolean r4 = com.google.android.gms.internal.vision.gk.a((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x010a:
            boolean r4 = r9.c(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.vision.hg.f(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.vision.hg.f(r11, r6)
            boolean r4 = com.google.android.gms.internal.vision.gk.a((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x0120:
            boolean r4 = r9.c(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            boolean r4 = com.google.android.gms.internal.vision.hg.c(r10, r6)
            boolean r5 = com.google.android.gms.internal.vision.hg.c(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x0132:
            boolean r4 = r9.c(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.vision.hg.a((java.lang.Object) r10, (long) r6)
            int r5 = com.google.android.gms.internal.vision.hg.a((java.lang.Object) r11, (long) r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x0144:
            boolean r4 = r9.c(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.vision.hg.b(r10, r6)
            long r6 = com.google.android.gms.internal.vision.hg.b(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x0157:
            boolean r4 = r9.c(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.vision.hg.a((java.lang.Object) r10, (long) r6)
            int r5 = com.google.android.gms.internal.vision.hg.a((java.lang.Object) r11, (long) r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x0168:
            boolean r4 = r9.c(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.vision.hg.b(r10, r6)
            long r6 = com.google.android.gms.internal.vision.hg.b(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x017b:
            boolean r4 = r9.c(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.vision.hg.b(r10, r6)
            long r6 = com.google.android.gms.internal.vision.hg.b(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x018e:
            boolean r4 = r9.c(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            float r4 = com.google.android.gms.internal.vision.hg.d(r10, r6)
            int r4 = java.lang.Float.floatToIntBits(r4)
            float r5 = com.google.android.gms.internal.vision.hg.d(r11, r6)
            int r5 = java.lang.Float.floatToIntBits(r5)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x01a7:
            boolean r4 = r9.c(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            double r4 = com.google.android.gms.internal.vision.hg.e(r10, r6)
            long r4 = java.lang.Double.doubleToLongBits(r4)
            double r6 = com.google.android.gms.internal.vision.hg.e(r11, r6)
            long r6 = java.lang.Double.doubleToLongBits(r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01c2
        L_0x01c1:
            r3 = 0
        L_0x01c2:
            if (r3 != 0) goto L_0x01c5
            return r1
        L_0x01c5:
            int r2 = r2 + 3
            goto L_0x0005
        L_0x01c9:
            com.google.android.gms.internal.vision.ha<?, ?> r0 = r9.q
            java.lang.Object r0 = r0.b(r10)
            com.google.android.gms.internal.vision.ha<?, ?> r2 = r9.q
            java.lang.Object r2 = r2.b(r11)
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x01dc
            return r1
        L_0x01dc:
            boolean r0 = r9.f11152h
            if (r0 == 0) goto L_0x01f1
            com.google.android.gms.internal.vision.dw<?> r0 = r9.r
            com.google.android.gms.internal.vision.dz r10 = r0.a((java.lang.Object) r10)
            com.google.android.gms.internal.vision.dw<?> r0 = r9.r
            com.google.android.gms.internal.vision.dz r11 = r0.a((java.lang.Object) r11)
            boolean r10 = r10.equals(r11)
            return r10
        L_0x01f1:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.fx.a(java.lang.Object, java.lang.Object):boolean");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x01c3, code lost:
        r2 = (r2 * 53) + r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0227, code lost:
        r2 = r2 + r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0228, code lost:
        r1 = r1 + 3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int a(T r9) {
        /*
            r8 = this;
            int[] r0 = r8.f11147c
            int r0 = r0.length
            r1 = 0
            r2 = 0
        L_0x0005:
            if (r1 >= r0) goto L_0x022c
            int r3 = r8.c((int) r1)
            int[] r4 = r8.f11147c
            r4 = r4[r1]
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r5 = r5 & r3
            long r5 = (long) r5
            r7 = 267386880(0xff00000, float:2.3665827E-29)
            r3 = r3 & r7
            int r3 = r3 >>> 20
            r7 = 37
            switch(r3) {
                case 0: goto L_0x0219;
                case 1: goto L_0x020e;
                case 2: goto L_0x0203;
                case 3: goto L_0x01f8;
                case 4: goto L_0x01f1;
                case 5: goto L_0x01e6;
                case 6: goto L_0x01df;
                case 7: goto L_0x01d4;
                case 8: goto L_0x01c7;
                case 9: goto L_0x01b9;
                case 10: goto L_0x01ad;
                case 11: goto L_0x01a5;
                case 12: goto L_0x019d;
                case 13: goto L_0x0195;
                case 14: goto L_0x0189;
                case 15: goto L_0x0181;
                case 16: goto L_0x0175;
                case 17: goto L_0x016a;
                case 18: goto L_0x015e;
                case 19: goto L_0x015e;
                case 20: goto L_0x015e;
                case 21: goto L_0x015e;
                case 22: goto L_0x015e;
                case 23: goto L_0x015e;
                case 24: goto L_0x015e;
                case 25: goto L_0x015e;
                case 26: goto L_0x015e;
                case 27: goto L_0x015e;
                case 28: goto L_0x015e;
                case 29: goto L_0x015e;
                case 30: goto L_0x015e;
                case 31: goto L_0x015e;
                case 32: goto L_0x015e;
                case 33: goto L_0x015e;
                case 34: goto L_0x015e;
                case 35: goto L_0x015e;
                case 36: goto L_0x015e;
                case 37: goto L_0x015e;
                case 38: goto L_0x015e;
                case 39: goto L_0x015e;
                case 40: goto L_0x015e;
                case 41: goto L_0x015e;
                case 42: goto L_0x015e;
                case 43: goto L_0x015e;
                case 44: goto L_0x015e;
                case 45: goto L_0x015e;
                case 46: goto L_0x015e;
                case 47: goto L_0x015e;
                case 48: goto L_0x015e;
                case 49: goto L_0x015e;
                case 50: goto L_0x0152;
                case 51: goto L_0x013c;
                case 52: goto L_0x012a;
                case 53: goto L_0x0118;
                case 54: goto L_0x0106;
                case 55: goto L_0x00f8;
                case 56: goto L_0x00e6;
                case 57: goto L_0x00d8;
                case 58: goto L_0x00c6;
                case 59: goto L_0x00b2;
                case 60: goto L_0x00a0;
                case 61: goto L_0x008e;
                case 62: goto L_0x0080;
                case 63: goto L_0x0072;
                case 64: goto L_0x0064;
                case 65: goto L_0x0052;
                case 66: goto L_0x0044;
                case 67: goto L_0x0032;
                case 68: goto L_0x0020;
                default: goto L_0x001e;
            }
        L_0x001e:
            goto L_0x0228
        L_0x0020:
            boolean r3 = r8.a(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            java.lang.Object r3 = com.google.android.gms.internal.vision.hg.f(r9, r5)
            int r2 = r2 * 53
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x0032:
            boolean r3 = r8.a(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            long r3 = e(r9, r5)
            int r3 = com.google.android.gms.internal.vision.ek.a((long) r3)
            goto L_0x0227
        L_0x0044:
            boolean r3 = r8.a(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            int r3 = d(r9, r5)
            goto L_0x0227
        L_0x0052:
            boolean r3 = r8.a(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            long r3 = e(r9, r5)
            int r3 = com.google.android.gms.internal.vision.ek.a((long) r3)
            goto L_0x0227
        L_0x0064:
            boolean r3 = r8.a(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            int r3 = d(r9, r5)
            goto L_0x0227
        L_0x0072:
            boolean r3 = r8.a(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            int r3 = d(r9, r5)
            goto L_0x0227
        L_0x0080:
            boolean r3 = r8.a(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            int r3 = d(r9, r5)
            goto L_0x0227
        L_0x008e:
            boolean r3 = r8.a(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.vision.hg.f(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x00a0:
            boolean r3 = r8.a(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            java.lang.Object r3 = com.google.android.gms.internal.vision.hg.f(r9, r5)
            int r2 = r2 * 53
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x00b2:
            boolean r3 = r8.a(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.vision.hg.f(r9, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x00c6:
            boolean r3 = r8.a(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            boolean r3 = f(r9, r5)
            int r3 = com.google.android.gms.internal.vision.ek.a((boolean) r3)
            goto L_0x0227
        L_0x00d8:
            boolean r3 = r8.a(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            int r3 = d(r9, r5)
            goto L_0x0227
        L_0x00e6:
            boolean r3 = r8.a(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            long r3 = e(r9, r5)
            int r3 = com.google.android.gms.internal.vision.ek.a((long) r3)
            goto L_0x0227
        L_0x00f8:
            boolean r3 = r8.a(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            int r3 = d(r9, r5)
            goto L_0x0227
        L_0x0106:
            boolean r3 = r8.a(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            long r3 = e(r9, r5)
            int r3 = com.google.android.gms.internal.vision.ek.a((long) r3)
            goto L_0x0227
        L_0x0118:
            boolean r3 = r8.a(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            long r3 = e(r9, r5)
            int r3 = com.google.android.gms.internal.vision.ek.a((long) r3)
            goto L_0x0227
        L_0x012a:
            boolean r3 = r8.a(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            float r3 = c(r9, r5)
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x0227
        L_0x013c:
            boolean r3 = r8.a(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            double r3 = b(r9, (long) r5)
            long r3 = java.lang.Double.doubleToLongBits(r3)
            int r3 = com.google.android.gms.internal.vision.ek.a((long) r3)
            goto L_0x0227
        L_0x0152:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.vision.hg.f(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x015e:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.vision.hg.f(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x016a:
            java.lang.Object r3 = com.google.android.gms.internal.vision.hg.f(r9, r5)
            if (r3 == 0) goto L_0x01c3
            int r7 = r3.hashCode()
            goto L_0x01c3
        L_0x0175:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.vision.hg.b(r9, r5)
            int r3 = com.google.android.gms.internal.vision.ek.a((long) r3)
            goto L_0x0227
        L_0x0181:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.vision.hg.a((java.lang.Object) r9, (long) r5)
            goto L_0x0227
        L_0x0189:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.vision.hg.b(r9, r5)
            int r3 = com.google.android.gms.internal.vision.ek.a((long) r3)
            goto L_0x0227
        L_0x0195:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.vision.hg.a((java.lang.Object) r9, (long) r5)
            goto L_0x0227
        L_0x019d:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.vision.hg.a((java.lang.Object) r9, (long) r5)
            goto L_0x0227
        L_0x01a5:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.vision.hg.a((java.lang.Object) r9, (long) r5)
            goto L_0x0227
        L_0x01ad:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.vision.hg.f(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x01b9:
            java.lang.Object r3 = com.google.android.gms.internal.vision.hg.f(r9, r5)
            if (r3 == 0) goto L_0x01c3
            int r7 = r3.hashCode()
        L_0x01c3:
            int r2 = r2 * 53
            int r2 = r2 + r7
            goto L_0x0228
        L_0x01c7:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.vision.hg.f(r9, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x01d4:
            int r2 = r2 * 53
            boolean r3 = com.google.android.gms.internal.vision.hg.c(r9, r5)
            int r3 = com.google.android.gms.internal.vision.ek.a((boolean) r3)
            goto L_0x0227
        L_0x01df:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.vision.hg.a((java.lang.Object) r9, (long) r5)
            goto L_0x0227
        L_0x01e6:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.vision.hg.b(r9, r5)
            int r3 = com.google.android.gms.internal.vision.ek.a((long) r3)
            goto L_0x0227
        L_0x01f1:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.vision.hg.a((java.lang.Object) r9, (long) r5)
            goto L_0x0227
        L_0x01f8:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.vision.hg.b(r9, r5)
            int r3 = com.google.android.gms.internal.vision.ek.a((long) r3)
            goto L_0x0227
        L_0x0203:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.vision.hg.b(r9, r5)
            int r3 = com.google.android.gms.internal.vision.ek.a((long) r3)
            goto L_0x0227
        L_0x020e:
            int r2 = r2 * 53
            float r3 = com.google.android.gms.internal.vision.hg.d(r9, r5)
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x0227
        L_0x0219:
            int r2 = r2 * 53
            double r3 = com.google.android.gms.internal.vision.hg.e(r9, r5)
            long r3 = java.lang.Double.doubleToLongBits(r3)
            int r3 = com.google.android.gms.internal.vision.ek.a((long) r3)
        L_0x0227:
            int r2 = r2 + r3
        L_0x0228:
            int r1 = r1 + 3
            goto L_0x0005
        L_0x022c:
            int r2 = r2 * 53
            com.google.android.gms.internal.vision.ha<?, ?> r0 = r8.q
            java.lang.Object r0 = r0.b(r9)
            int r0 = r0.hashCode()
            int r2 = r2 + r0
            boolean r0 = r8.f11152h
            if (r0 == 0) goto L_0x024a
            int r2 = r2 * 53
            com.google.android.gms.internal.vision.dw<?> r0 = r8.r
            com.google.android.gms.internal.vision.dz r9 = r0.a((java.lang.Object) r9)
            int r9 = r9.hashCode()
            int r2 = r2 + r9
        L_0x024a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.fx.a(java.lang.Object):int");
    }

    public final void b(T t, T t2) {
        if (t2 != null) {
            for (int i2 = 0; i2 < this.f11147c.length; i2 += 3) {
                int c2 = c(i2);
                long j2 = (long) (1048575 & c2);
                int i3 = this.f11147c[i2];
                switch ((c2 & 267386880) >>> 20) {
                    case 0:
                        if (!a(t2, i2)) {
                            break;
                        } else {
                            hg.a((Object) t, j2, hg.e(t2, j2));
                            b(t, i2);
                            break;
                        }
                    case 1:
                        if (!a(t2, i2)) {
                            break;
                        } else {
                            hg.a((Object) t, j2, hg.d(t2, j2));
                            b(t, i2);
                            break;
                        }
                    case 2:
                        if (!a(t2, i2)) {
                            break;
                        } else {
                            hg.a((Object) t, j2, hg.b(t2, j2));
                            b(t, i2);
                            break;
                        }
                    case 3:
                        if (!a(t2, i2)) {
                            break;
                        } else {
                            hg.a((Object) t, j2, hg.b(t2, j2));
                            b(t, i2);
                            break;
                        }
                    case 4:
                        if (!a(t2, i2)) {
                            break;
                        } else {
                            hg.a((Object) t, j2, hg.a((Object) t2, j2));
                            b(t, i2);
                            break;
                        }
                    case 5:
                        if (!a(t2, i2)) {
                            break;
                        } else {
                            hg.a((Object) t, j2, hg.b(t2, j2));
                            b(t, i2);
                            break;
                        }
                    case 6:
                        if (!a(t2, i2)) {
                            break;
                        } else {
                            hg.a((Object) t, j2, hg.a((Object) t2, j2));
                            b(t, i2);
                            break;
                        }
                    case 7:
                        if (!a(t2, i2)) {
                            break;
                        } else {
                            hg.a((Object) t, j2, hg.c(t2, j2));
                            b(t, i2);
                            break;
                        }
                    case 8:
                        if (!a(t2, i2)) {
                            break;
                        } else {
                            hg.a((Object) t, j2, hg.f(t2, j2));
                            b(t, i2);
                            break;
                        }
                    case 9:
                        a(t, t2, i2);
                        break;
                    case 10:
                        if (!a(t2, i2)) {
                            break;
                        } else {
                            hg.a((Object) t, j2, hg.f(t2, j2));
                            b(t, i2);
                            break;
                        }
                    case 11:
                        if (!a(t2, i2)) {
                            break;
                        } else {
                            hg.a((Object) t, j2, hg.a((Object) t2, j2));
                            b(t, i2);
                            break;
                        }
                    case 12:
                        if (!a(t2, i2)) {
                            break;
                        } else {
                            hg.a((Object) t, j2, hg.a((Object) t2, j2));
                            b(t, i2);
                            break;
                        }
                    case 13:
                        if (!a(t2, i2)) {
                            break;
                        } else {
                            hg.a((Object) t, j2, hg.a((Object) t2, j2));
                            b(t, i2);
                            break;
                        }
                    case 14:
                        if (!a(t2, i2)) {
                            break;
                        } else {
                            hg.a((Object) t, j2, hg.b(t2, j2));
                            b(t, i2);
                            break;
                        }
                    case 15:
                        if (!a(t2, i2)) {
                            break;
                        } else {
                            hg.a((Object) t, j2, hg.a((Object) t2, j2));
                            b(t, i2);
                            break;
                        }
                    case 16:
                        if (!a(t2, i2)) {
                            break;
                        } else {
                            hg.a((Object) t, j2, hg.b(t2, j2));
                            b(t, i2);
                            break;
                        }
                    case 17:
                        a(t, t2, i2);
                        break;
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case 29:
                    case 30:
                    case 31:
                    case 32:
                    case 33:
                    case 34:
                    case 35:
                    case 36:
                    case 37:
                    case 38:
                    case 39:
                    case 40:
                    case 41:
                    case 42:
                    case 43:
                    case 44:
                    case 45:
                    case 46:
                    case 47:
                    case 48:
                    case 49:
                        this.p.a(t, t2, j2);
                        break;
                    case 50:
                        gk.a(this.s, t, t2, j2);
                        break;
                    case 51:
                    case 52:
                    case 53:
                    case 54:
                    case 55:
                    case 56:
                    case 57:
                    case 58:
                    case 59:
                        if (!a(t2, i3, i2)) {
                            break;
                        } else {
                            hg.a((Object) t, j2, hg.f(t2, j2));
                            b(t, i3, i2);
                            break;
                        }
                    case 60:
                        b(t, t2, i2);
                        break;
                    case 61:
                    case 62:
                    case 63:
                    case 64:
                    case 65:
                    case 66:
                    case 67:
                        if (!a(t2, i3, i2)) {
                            break;
                        } else {
                            hg.a((Object) t, j2, hg.f(t2, j2));
                            b(t, i3, i2);
                            break;
                        }
                    case 68:
                        b(t, t2, i2);
                        break;
                }
            }
            gk.a(this.q, t, t2);
            if (this.f11152h) {
                gk.a(this.r, t, t2);
                return;
            }
            return;
        }
        throw new NullPointerException();
    }

    private final void a(T t, T t2, int i2) {
        long c2 = (long) (c(i2) & 1048575);
        if (a(t2, i2)) {
            Object f2 = hg.f(t, c2);
            Object f3 = hg.f(t2, c2);
            if (f2 != null && f3 != null) {
                hg.a((Object) t, c2, ek.a(f2, f3));
                b(t, i2);
            } else if (f3 != null) {
                hg.a((Object) t, c2, f3);
                b(t, i2);
            }
        }
    }

    private final void b(T t, T t2, int i2) {
        int c2 = c(i2);
        int i3 = this.f11147c[i2];
        long j2 = (long) (c2 & 1048575);
        if (a(t2, i3, i2)) {
            Object f2 = hg.f(t, j2);
            Object f3 = hg.f(t2, j2);
            if (f2 != null && f3 != null) {
                hg.a((Object) t, j2, ek.a(f2, f3));
                b(t, i3, i2);
            } else if (f3 != null) {
                hg.a((Object) t, j2, f3);
                b(t, i3, i2);
            }
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:398:0x0816, code lost:
        r7 = r7 + ((r4 + r10) + r3);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int b(T r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            boolean r2 = r0.j
            r3 = 267386880(0xff00000, float:2.3665827E-29)
            r4 = 1048575(0xfffff, float:1.469367E-39)
            r5 = 0
            if (r2 == 0) goto L_0x04e4
            sun.misc.Unsafe r2 = f11146b
            r6 = 0
            r7 = 0
        L_0x0012:
            int[] r8 = r0.f11147c
            int r8 = r8.length
            if (r6 >= r8) goto L_0x04dc
            int r8 = r0.c((int) r6)
            r9 = r8 & r3
            int r9 = r9 >>> 20
            int[] r10 = r0.f11147c
            r10 = r10[r6]
            r8 = r8 & r4
            long r11 = (long) r8
            com.google.android.gms.internal.vision.ee r8 = com.google.android.gms.internal.vision.ee.DOUBLE_LIST_PACKED
            int r8 = r8.id()
            if (r9 < r8) goto L_0x003d
            com.google.android.gms.internal.vision.ee r8 = com.google.android.gms.internal.vision.ee.SINT64_LIST_PACKED
            int r8 = r8.id()
            if (r9 > r8) goto L_0x003d
            int[] r8 = r0.f11147c
            int r13 = r6 + 2
            r8 = r8[r13]
            r8 = r8 & r4
            goto L_0x003e
        L_0x003d:
            r8 = 0
        L_0x003e:
            switch(r9) {
                case 0: goto L_0x04cc;
                case 1: goto L_0x04c0;
                case 2: goto L_0x04b0;
                case 3: goto L_0x04a0;
                case 4: goto L_0x0490;
                case 5: goto L_0x0484;
                case 6: goto L_0x0478;
                case 7: goto L_0x046c;
                case 8: goto L_0x044e;
                case 9: goto L_0x043a;
                case 10: goto L_0x0429;
                case 11: goto L_0x041a;
                case 12: goto L_0x040b;
                case 13: goto L_0x0400;
                case 14: goto L_0x03f5;
                case 15: goto L_0x03e6;
                case 16: goto L_0x03d7;
                case 17: goto L_0x03c2;
                case 18: goto L_0x03b7;
                case 19: goto L_0x03ae;
                case 20: goto L_0x03a5;
                case 21: goto L_0x039c;
                case 22: goto L_0x0393;
                case 23: goto L_0x038a;
                case 24: goto L_0x0381;
                case 25: goto L_0x0378;
                case 26: goto L_0x036f;
                case 27: goto L_0x0362;
                case 28: goto L_0x0359;
                case 29: goto L_0x0350;
                case 30: goto L_0x0346;
                case 31: goto L_0x033c;
                case 32: goto L_0x0332;
                case 33: goto L_0x0328;
                case 34: goto L_0x031e;
                case 35: goto L_0x02fe;
                case 36: goto L_0x02e1;
                case 37: goto L_0x02c4;
                case 38: goto L_0x02a7;
                case 39: goto L_0x0289;
                case 40: goto L_0x026b;
                case 41: goto L_0x024d;
                case 42: goto L_0x022f;
                case 43: goto L_0x0211;
                case 44: goto L_0x01f3;
                case 45: goto L_0x01d5;
                case 46: goto L_0x01b7;
                case 47: goto L_0x0199;
                case 48: goto L_0x017b;
                case 49: goto L_0x016d;
                case 50: goto L_0x0161;
                case 51: goto L_0x0155;
                case 52: goto L_0x0149;
                case 53: goto L_0x0139;
                case 54: goto L_0x0129;
                case 55: goto L_0x0119;
                case 56: goto L_0x010d;
                case 57: goto L_0x0101;
                case 58: goto L_0x00f5;
                case 59: goto L_0x00d7;
                case 60: goto L_0x00c3;
                case 61: goto L_0x00b1;
                case 62: goto L_0x00a1;
                case 63: goto L_0x0091;
                case 64: goto L_0x0085;
                case 65: goto L_0x0079;
                case 66: goto L_0x0069;
                case 67: goto L_0x0059;
                case 68: goto L_0x0043;
                default: goto L_0x0041;
            }
        L_0x0041:
            goto L_0x04d8
        L_0x0043:
            boolean r8 = r0.a(r1, (int) r10, (int) r6)
            if (r8 == 0) goto L_0x04d8
            java.lang.Object r8 = com.google.android.gms.internal.vision.hg.f(r1, r11)
            com.google.android.gms.internal.vision.ft r8 = (com.google.android.gms.internal.vision.ft) r8
            com.google.android.gms.internal.vision.gi r9 = r0.a((int) r6)
            int r8 = com.google.android.gms.internal.vision.dr.c(r10, r8, r9)
            goto L_0x03bf
        L_0x0059:
            boolean r8 = r0.a(r1, (int) r10, (int) r6)
            if (r8 == 0) goto L_0x04d8
            long r8 = e(r1, r11)
            int r8 = com.google.android.gms.internal.vision.dr.f((int) r10, (long) r8)
            goto L_0x03bf
        L_0x0069:
            boolean r8 = r0.a(r1, (int) r10, (int) r6)
            if (r8 == 0) goto L_0x04d8
            int r8 = d(r1, r11)
            int r8 = com.google.android.gms.internal.vision.dr.h(r10, r8)
            goto L_0x03bf
        L_0x0079:
            boolean r8 = r0.a(r1, (int) r10, (int) r6)
            if (r8 == 0) goto L_0x04d8
            int r8 = com.google.android.gms.internal.vision.dr.h(r10)
            goto L_0x03bf
        L_0x0085:
            boolean r8 = r0.a(r1, (int) r10, (int) r6)
            if (r8 == 0) goto L_0x04d8
            int r8 = com.google.android.gms.internal.vision.dr.f((int) r10)
            goto L_0x03bf
        L_0x0091:
            boolean r8 = r0.a(r1, (int) r10, (int) r6)
            if (r8 == 0) goto L_0x04d8
            int r8 = d(r1, r11)
            int r8 = com.google.android.gms.internal.vision.dr.i(r10, r8)
            goto L_0x03bf
        L_0x00a1:
            boolean r8 = r0.a(r1, (int) r10, (int) r6)
            if (r8 == 0) goto L_0x04d8
            int r8 = d(r1, r11)
            int r8 = com.google.android.gms.internal.vision.dr.g(r10, r8)
            goto L_0x03bf
        L_0x00b1:
            boolean r8 = r0.a(r1, (int) r10, (int) r6)
            if (r8 == 0) goto L_0x04d8
            java.lang.Object r8 = com.google.android.gms.internal.vision.hg.f(r1, r11)
            com.google.android.gms.internal.vision.cz r8 = (com.google.android.gms.internal.vision.cz) r8
            int r8 = com.google.android.gms.internal.vision.dr.c((int) r10, (com.google.android.gms.internal.vision.cz) r8)
            goto L_0x03bf
        L_0x00c3:
            boolean r8 = r0.a(r1, (int) r10, (int) r6)
            if (r8 == 0) goto L_0x04d8
            java.lang.Object r8 = com.google.android.gms.internal.vision.hg.f(r1, r11)
            com.google.android.gms.internal.vision.gi r9 = r0.a((int) r6)
            int r8 = com.google.android.gms.internal.vision.gk.a((int) r10, (java.lang.Object) r8, (com.google.android.gms.internal.vision.gi) r9)
            goto L_0x03bf
        L_0x00d7:
            boolean r8 = r0.a(r1, (int) r10, (int) r6)
            if (r8 == 0) goto L_0x04d8
            java.lang.Object r8 = com.google.android.gms.internal.vision.hg.f(r1, r11)
            boolean r9 = r8 instanceof com.google.android.gms.internal.vision.cz
            if (r9 == 0) goto L_0x00ed
            com.google.android.gms.internal.vision.cz r8 = (com.google.android.gms.internal.vision.cz) r8
            int r8 = com.google.android.gms.internal.vision.dr.c((int) r10, (com.google.android.gms.internal.vision.cz) r8)
            goto L_0x03bf
        L_0x00ed:
            java.lang.String r8 = (java.lang.String) r8
            int r8 = com.google.android.gms.internal.vision.dr.b((int) r10, (java.lang.String) r8)
            goto L_0x03bf
        L_0x00f5:
            boolean r8 = r0.a(r1, (int) r10, (int) r6)
            if (r8 == 0) goto L_0x04d8
            int r8 = com.google.android.gms.internal.vision.dr.k(r10)
            goto L_0x03bf
        L_0x0101:
            boolean r8 = r0.a(r1, (int) r10, (int) r6)
            if (r8 == 0) goto L_0x04d8
            int r8 = com.google.android.gms.internal.vision.dr.e((int) r10)
            goto L_0x03bf
        L_0x010d:
            boolean r8 = r0.a(r1, (int) r10, (int) r6)
            if (r8 == 0) goto L_0x04d8
            int r8 = com.google.android.gms.internal.vision.dr.g((int) r10)
            goto L_0x03bf
        L_0x0119:
            boolean r8 = r0.a(r1, (int) r10, (int) r6)
            if (r8 == 0) goto L_0x04d8
            int r8 = d(r1, r11)
            int r8 = com.google.android.gms.internal.vision.dr.f((int) r10, (int) r8)
            goto L_0x03bf
        L_0x0129:
            boolean r8 = r0.a(r1, (int) r10, (int) r6)
            if (r8 == 0) goto L_0x04d8
            long r8 = e(r1, r11)
            int r8 = com.google.android.gms.internal.vision.dr.e((int) r10, (long) r8)
            goto L_0x03bf
        L_0x0139:
            boolean r8 = r0.a(r1, (int) r10, (int) r6)
            if (r8 == 0) goto L_0x04d8
            long r8 = e(r1, r11)
            int r8 = com.google.android.gms.internal.vision.dr.d((int) r10, (long) r8)
            goto L_0x03bf
        L_0x0149:
            boolean r8 = r0.a(r1, (int) r10, (int) r6)
            if (r8 == 0) goto L_0x04d8
            int r8 = com.google.android.gms.internal.vision.dr.i(r10)
            goto L_0x03bf
        L_0x0155:
            boolean r8 = r0.a(r1, (int) r10, (int) r6)
            if (r8 == 0) goto L_0x04d8
            int r8 = com.google.android.gms.internal.vision.dr.j(r10)
            goto L_0x03bf
        L_0x0161:
            com.google.android.gms.internal.vision.fl r8 = r0.s
            java.lang.Object r9 = com.google.android.gms.internal.vision.hg.f(r1, r11)
            int r8 = r8.e(r9)
            goto L_0x03bf
        L_0x016d:
            java.util.List r8 = a((java.lang.Object) r1, (long) r11)
            com.google.android.gms.internal.vision.gi r9 = r0.a((int) r6)
            int r8 = com.google.android.gms.internal.vision.gk.b((int) r10, (java.util.List<com.google.android.gms.internal.vision.ft>) r8, (com.google.android.gms.internal.vision.gi) r9)
            goto L_0x03bf
        L_0x017b:
            java.lang.Object r9 = r2.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            int r9 = com.google.android.gms.internal.vision.gk.c(r9)
            if (r9 <= 0) goto L_0x04d8
            boolean r11 = r0.k
            if (r11 == 0) goto L_0x018f
            long r11 = (long) r8
            r2.putInt(r1, r11, r9)
        L_0x018f:
            int r8 = com.google.android.gms.internal.vision.dr.l(r10)
            int r10 = com.google.android.gms.internal.vision.dr.n(r9)
            goto L_0x031a
        L_0x0199:
            java.lang.Object r9 = r2.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            int r9 = com.google.android.gms.internal.vision.gk.g(r9)
            if (r9 <= 0) goto L_0x04d8
            boolean r11 = r0.k
            if (r11 == 0) goto L_0x01ad
            long r11 = (long) r8
            r2.putInt(r1, r11, r9)
        L_0x01ad:
            int r8 = com.google.android.gms.internal.vision.dr.l(r10)
            int r10 = com.google.android.gms.internal.vision.dr.n(r9)
            goto L_0x031a
        L_0x01b7:
            java.lang.Object r9 = r2.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            int r9 = com.google.android.gms.internal.vision.gk.i(r9)
            if (r9 <= 0) goto L_0x04d8
            boolean r11 = r0.k
            if (r11 == 0) goto L_0x01cb
            long r11 = (long) r8
            r2.putInt(r1, r11, r9)
        L_0x01cb:
            int r8 = com.google.android.gms.internal.vision.dr.l(r10)
            int r10 = com.google.android.gms.internal.vision.dr.n(r9)
            goto L_0x031a
        L_0x01d5:
            java.lang.Object r9 = r2.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            int r9 = com.google.android.gms.internal.vision.gk.h(r9)
            if (r9 <= 0) goto L_0x04d8
            boolean r11 = r0.k
            if (r11 == 0) goto L_0x01e9
            long r11 = (long) r8
            r2.putInt(r1, r11, r9)
        L_0x01e9:
            int r8 = com.google.android.gms.internal.vision.dr.l(r10)
            int r10 = com.google.android.gms.internal.vision.dr.n(r9)
            goto L_0x031a
        L_0x01f3:
            java.lang.Object r9 = r2.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            int r9 = com.google.android.gms.internal.vision.gk.d(r9)
            if (r9 <= 0) goto L_0x04d8
            boolean r11 = r0.k
            if (r11 == 0) goto L_0x0207
            long r11 = (long) r8
            r2.putInt(r1, r11, r9)
        L_0x0207:
            int r8 = com.google.android.gms.internal.vision.dr.l(r10)
            int r10 = com.google.android.gms.internal.vision.dr.n(r9)
            goto L_0x031a
        L_0x0211:
            java.lang.Object r9 = r2.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            int r9 = com.google.android.gms.internal.vision.gk.f(r9)
            if (r9 <= 0) goto L_0x04d8
            boolean r11 = r0.k
            if (r11 == 0) goto L_0x0225
            long r11 = (long) r8
            r2.putInt(r1, r11, r9)
        L_0x0225:
            int r8 = com.google.android.gms.internal.vision.dr.l(r10)
            int r10 = com.google.android.gms.internal.vision.dr.n(r9)
            goto L_0x031a
        L_0x022f:
            java.lang.Object r9 = r2.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            int r9 = com.google.android.gms.internal.vision.gk.j(r9)
            if (r9 <= 0) goto L_0x04d8
            boolean r11 = r0.k
            if (r11 == 0) goto L_0x0243
            long r11 = (long) r8
            r2.putInt(r1, r11, r9)
        L_0x0243:
            int r8 = com.google.android.gms.internal.vision.dr.l(r10)
            int r10 = com.google.android.gms.internal.vision.dr.n(r9)
            goto L_0x031a
        L_0x024d:
            java.lang.Object r9 = r2.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            int r9 = com.google.android.gms.internal.vision.gk.h(r9)
            if (r9 <= 0) goto L_0x04d8
            boolean r11 = r0.k
            if (r11 == 0) goto L_0x0261
            long r11 = (long) r8
            r2.putInt(r1, r11, r9)
        L_0x0261:
            int r8 = com.google.android.gms.internal.vision.dr.l(r10)
            int r10 = com.google.android.gms.internal.vision.dr.n(r9)
            goto L_0x031a
        L_0x026b:
            java.lang.Object r9 = r2.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            int r9 = com.google.android.gms.internal.vision.gk.i(r9)
            if (r9 <= 0) goto L_0x04d8
            boolean r11 = r0.k
            if (r11 == 0) goto L_0x027f
            long r11 = (long) r8
            r2.putInt(r1, r11, r9)
        L_0x027f:
            int r8 = com.google.android.gms.internal.vision.dr.l(r10)
            int r10 = com.google.android.gms.internal.vision.dr.n(r9)
            goto L_0x031a
        L_0x0289:
            java.lang.Object r9 = r2.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            int r9 = com.google.android.gms.internal.vision.gk.e(r9)
            if (r9 <= 0) goto L_0x04d8
            boolean r11 = r0.k
            if (r11 == 0) goto L_0x029d
            long r11 = (long) r8
            r2.putInt(r1, r11, r9)
        L_0x029d:
            int r8 = com.google.android.gms.internal.vision.dr.l(r10)
            int r10 = com.google.android.gms.internal.vision.dr.n(r9)
            goto L_0x031a
        L_0x02a7:
            java.lang.Object r9 = r2.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            int r9 = com.google.android.gms.internal.vision.gk.b(r9)
            if (r9 <= 0) goto L_0x04d8
            boolean r11 = r0.k
            if (r11 == 0) goto L_0x02bb
            long r11 = (long) r8
            r2.putInt(r1, r11, r9)
        L_0x02bb:
            int r8 = com.google.android.gms.internal.vision.dr.l(r10)
            int r10 = com.google.android.gms.internal.vision.dr.n(r9)
            goto L_0x031a
        L_0x02c4:
            java.lang.Object r9 = r2.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            int r9 = com.google.android.gms.internal.vision.gk.a((java.util.List<java.lang.Long>) r9)
            if (r9 <= 0) goto L_0x04d8
            boolean r11 = r0.k
            if (r11 == 0) goto L_0x02d8
            long r11 = (long) r8
            r2.putInt(r1, r11, r9)
        L_0x02d8:
            int r8 = com.google.android.gms.internal.vision.dr.l(r10)
            int r10 = com.google.android.gms.internal.vision.dr.n(r9)
            goto L_0x031a
        L_0x02e1:
            java.lang.Object r9 = r2.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            int r9 = com.google.android.gms.internal.vision.gk.h(r9)
            if (r9 <= 0) goto L_0x04d8
            boolean r11 = r0.k
            if (r11 == 0) goto L_0x02f5
            long r11 = (long) r8
            r2.putInt(r1, r11, r9)
        L_0x02f5:
            int r8 = com.google.android.gms.internal.vision.dr.l(r10)
            int r10 = com.google.android.gms.internal.vision.dr.n(r9)
            goto L_0x031a
        L_0x02fe:
            java.lang.Object r9 = r2.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            int r9 = com.google.android.gms.internal.vision.gk.i(r9)
            if (r9 <= 0) goto L_0x04d8
            boolean r11 = r0.k
            if (r11 == 0) goto L_0x0312
            long r11 = (long) r8
            r2.putInt(r1, r11, r9)
        L_0x0312:
            int r8 = com.google.android.gms.internal.vision.dr.l(r10)
            int r10 = com.google.android.gms.internal.vision.dr.n(r9)
        L_0x031a:
            int r8 = r8 + r10
            int r8 = r8 + r9
            goto L_0x03bf
        L_0x031e:
            java.util.List r8 = a((java.lang.Object) r1, (long) r11)
            int r8 = com.google.android.gms.internal.vision.gk.c(r10, r8)
            goto L_0x03bf
        L_0x0328:
            java.util.List r8 = a((java.lang.Object) r1, (long) r11)
            int r8 = com.google.android.gms.internal.vision.gk.g(r10, r8)
            goto L_0x03bf
        L_0x0332:
            java.util.List r8 = a((java.lang.Object) r1, (long) r11)
            int r8 = com.google.android.gms.internal.vision.gk.i(r10, r8)
            goto L_0x03bf
        L_0x033c:
            java.util.List r8 = a((java.lang.Object) r1, (long) r11)
            int r8 = com.google.android.gms.internal.vision.gk.h(r10, r8)
            goto L_0x03bf
        L_0x0346:
            java.util.List r8 = a((java.lang.Object) r1, (long) r11)
            int r8 = com.google.android.gms.internal.vision.gk.d(r10, r8)
            goto L_0x03bf
        L_0x0350:
            java.util.List r8 = a((java.lang.Object) r1, (long) r11)
            int r8 = com.google.android.gms.internal.vision.gk.f(r10, r8)
            goto L_0x03bf
        L_0x0359:
            java.util.List r8 = a((java.lang.Object) r1, (long) r11)
            int r8 = com.google.android.gms.internal.vision.gk.l(r10, r8)
            goto L_0x03bf
        L_0x0362:
            java.util.List r8 = a((java.lang.Object) r1, (long) r11)
            com.google.android.gms.internal.vision.gi r9 = r0.a((int) r6)
            int r8 = com.google.android.gms.internal.vision.gk.a((int) r10, (java.util.List<?>) r8, (com.google.android.gms.internal.vision.gi) r9)
            goto L_0x03bf
        L_0x036f:
            java.util.List r8 = a((java.lang.Object) r1, (long) r11)
            int r8 = com.google.android.gms.internal.vision.gk.k(r10, r8)
            goto L_0x03bf
        L_0x0378:
            java.util.List r8 = a((java.lang.Object) r1, (long) r11)
            int r8 = com.google.android.gms.internal.vision.gk.j(r10, r8)
            goto L_0x03bf
        L_0x0381:
            java.util.List r8 = a((java.lang.Object) r1, (long) r11)
            int r8 = com.google.android.gms.internal.vision.gk.h(r10, r8)
            goto L_0x03bf
        L_0x038a:
            java.util.List r8 = a((java.lang.Object) r1, (long) r11)
            int r8 = com.google.android.gms.internal.vision.gk.i(r10, r8)
            goto L_0x03bf
        L_0x0393:
            java.util.List r8 = a((java.lang.Object) r1, (long) r11)
            int r8 = com.google.android.gms.internal.vision.gk.e(r10, r8)
            goto L_0x03bf
        L_0x039c:
            java.util.List r8 = a((java.lang.Object) r1, (long) r11)
            int r8 = com.google.android.gms.internal.vision.gk.b(r10, r8)
            goto L_0x03bf
        L_0x03a5:
            java.util.List r8 = a((java.lang.Object) r1, (long) r11)
            int r8 = com.google.android.gms.internal.vision.gk.a((int) r10, (java.util.List<java.lang.Long>) r8)
            goto L_0x03bf
        L_0x03ae:
            java.util.List r8 = a((java.lang.Object) r1, (long) r11)
            int r8 = com.google.android.gms.internal.vision.gk.h(r10, r8)
            goto L_0x03bf
        L_0x03b7:
            java.util.List r8 = a((java.lang.Object) r1, (long) r11)
            int r8 = com.google.android.gms.internal.vision.gk.i(r10, r8)
        L_0x03bf:
            int r7 = r7 + r8
            goto L_0x04d8
        L_0x03c2:
            boolean r8 = r0.a(r1, (int) r6)
            if (r8 == 0) goto L_0x04d8
            java.lang.Object r8 = com.google.android.gms.internal.vision.hg.f(r1, r11)
            com.google.android.gms.internal.vision.ft r8 = (com.google.android.gms.internal.vision.ft) r8
            com.google.android.gms.internal.vision.gi r9 = r0.a((int) r6)
            int r8 = com.google.android.gms.internal.vision.dr.c(r10, r8, r9)
            goto L_0x03bf
        L_0x03d7:
            boolean r8 = r0.a(r1, (int) r6)
            if (r8 == 0) goto L_0x04d8
            long r8 = com.google.android.gms.internal.vision.hg.b(r1, r11)
            int r8 = com.google.android.gms.internal.vision.dr.f((int) r10, (long) r8)
            goto L_0x03bf
        L_0x03e6:
            boolean r8 = r0.a(r1, (int) r6)
            if (r8 == 0) goto L_0x04d8
            int r8 = com.google.android.gms.internal.vision.hg.a((java.lang.Object) r1, (long) r11)
            int r8 = com.google.android.gms.internal.vision.dr.h(r10, r8)
            goto L_0x03bf
        L_0x03f5:
            boolean r8 = r0.a(r1, (int) r6)
            if (r8 == 0) goto L_0x04d8
            int r8 = com.google.android.gms.internal.vision.dr.h(r10)
            goto L_0x03bf
        L_0x0400:
            boolean r8 = r0.a(r1, (int) r6)
            if (r8 == 0) goto L_0x04d8
            int r8 = com.google.android.gms.internal.vision.dr.f((int) r10)
            goto L_0x03bf
        L_0x040b:
            boolean r8 = r0.a(r1, (int) r6)
            if (r8 == 0) goto L_0x04d8
            int r8 = com.google.android.gms.internal.vision.hg.a((java.lang.Object) r1, (long) r11)
            int r8 = com.google.android.gms.internal.vision.dr.i(r10, r8)
            goto L_0x03bf
        L_0x041a:
            boolean r8 = r0.a(r1, (int) r6)
            if (r8 == 0) goto L_0x04d8
            int r8 = com.google.android.gms.internal.vision.hg.a((java.lang.Object) r1, (long) r11)
            int r8 = com.google.android.gms.internal.vision.dr.g(r10, r8)
            goto L_0x03bf
        L_0x0429:
            boolean r8 = r0.a(r1, (int) r6)
            if (r8 == 0) goto L_0x04d8
            java.lang.Object r8 = com.google.android.gms.internal.vision.hg.f(r1, r11)
            com.google.android.gms.internal.vision.cz r8 = (com.google.android.gms.internal.vision.cz) r8
            int r8 = com.google.android.gms.internal.vision.dr.c((int) r10, (com.google.android.gms.internal.vision.cz) r8)
            goto L_0x03bf
        L_0x043a:
            boolean r8 = r0.a(r1, (int) r6)
            if (r8 == 0) goto L_0x04d8
            java.lang.Object r8 = com.google.android.gms.internal.vision.hg.f(r1, r11)
            com.google.android.gms.internal.vision.gi r9 = r0.a((int) r6)
            int r8 = com.google.android.gms.internal.vision.gk.a((int) r10, (java.lang.Object) r8, (com.google.android.gms.internal.vision.gi) r9)
            goto L_0x03bf
        L_0x044e:
            boolean r8 = r0.a(r1, (int) r6)
            if (r8 == 0) goto L_0x04d8
            java.lang.Object r8 = com.google.android.gms.internal.vision.hg.f(r1, r11)
            boolean r9 = r8 instanceof com.google.android.gms.internal.vision.cz
            if (r9 == 0) goto L_0x0464
            com.google.android.gms.internal.vision.cz r8 = (com.google.android.gms.internal.vision.cz) r8
            int r8 = com.google.android.gms.internal.vision.dr.c((int) r10, (com.google.android.gms.internal.vision.cz) r8)
            goto L_0x03bf
        L_0x0464:
            java.lang.String r8 = (java.lang.String) r8
            int r8 = com.google.android.gms.internal.vision.dr.b((int) r10, (java.lang.String) r8)
            goto L_0x03bf
        L_0x046c:
            boolean r8 = r0.a(r1, (int) r6)
            if (r8 == 0) goto L_0x04d8
            int r8 = com.google.android.gms.internal.vision.dr.k(r10)
            goto L_0x03bf
        L_0x0478:
            boolean r8 = r0.a(r1, (int) r6)
            if (r8 == 0) goto L_0x04d8
            int r8 = com.google.android.gms.internal.vision.dr.e((int) r10)
            goto L_0x03bf
        L_0x0484:
            boolean r8 = r0.a(r1, (int) r6)
            if (r8 == 0) goto L_0x04d8
            int r8 = com.google.android.gms.internal.vision.dr.g((int) r10)
            goto L_0x03bf
        L_0x0490:
            boolean r8 = r0.a(r1, (int) r6)
            if (r8 == 0) goto L_0x04d8
            int r8 = com.google.android.gms.internal.vision.hg.a((java.lang.Object) r1, (long) r11)
            int r8 = com.google.android.gms.internal.vision.dr.f((int) r10, (int) r8)
            goto L_0x03bf
        L_0x04a0:
            boolean r8 = r0.a(r1, (int) r6)
            if (r8 == 0) goto L_0x04d8
            long r8 = com.google.android.gms.internal.vision.hg.b(r1, r11)
            int r8 = com.google.android.gms.internal.vision.dr.e((int) r10, (long) r8)
            goto L_0x03bf
        L_0x04b0:
            boolean r8 = r0.a(r1, (int) r6)
            if (r8 == 0) goto L_0x04d8
            long r8 = com.google.android.gms.internal.vision.hg.b(r1, r11)
            int r8 = com.google.android.gms.internal.vision.dr.d((int) r10, (long) r8)
            goto L_0x03bf
        L_0x04c0:
            boolean r8 = r0.a(r1, (int) r6)
            if (r8 == 0) goto L_0x04d8
            int r8 = com.google.android.gms.internal.vision.dr.i(r10)
            goto L_0x03bf
        L_0x04cc:
            boolean r8 = r0.a(r1, (int) r6)
            if (r8 == 0) goto L_0x04d8
            int r8 = com.google.android.gms.internal.vision.dr.j(r10)
            goto L_0x03bf
        L_0x04d8:
            int r6 = r6 + 3
            goto L_0x0012
        L_0x04dc:
            com.google.android.gms.internal.vision.ha<?, ?> r2 = r0.q
            int r1 = a(r2, r1)
            int r7 = r7 + r1
            return r7
        L_0x04e4:
            sun.misc.Unsafe r2 = f11146b
            r6 = 0
            r7 = 0
            r8 = 1048575(0xfffff, float:1.469367E-39)
            r9 = 0
        L_0x04ec:
            int[] r10 = r0.f11147c
            int r10 = r10.length
            if (r6 >= r10) goto L_0x09dd
            int r10 = r0.c((int) r6)
            int[] r11 = r0.f11147c
            r12 = r11[r6]
            r13 = r10 & r3
            int r13 = r13 >>> 20
            r14 = 17
            if (r13 > r14) goto L_0x0518
            int r14 = r6 + 2
            r11 = r11[r14]
            r14 = r11 & r4
            int r15 = r11 >>> 20
            r16 = 1
            int r15 = r16 << r15
            if (r14 == r8) goto L_0x0515
            long r8 = (long) r14
            int r9 = r2.getInt(r1, r8)
            goto L_0x0516
        L_0x0515:
            r14 = r8
        L_0x0516:
            r8 = r14
            goto L_0x0536
        L_0x0518:
            boolean r11 = r0.k
            if (r11 == 0) goto L_0x0534
            com.google.android.gms.internal.vision.ee r11 = com.google.android.gms.internal.vision.ee.DOUBLE_LIST_PACKED
            int r11 = r11.id()
            if (r13 < r11) goto L_0x0534
            com.google.android.gms.internal.vision.ee r11 = com.google.android.gms.internal.vision.ee.SINT64_LIST_PACKED
            int r11 = r11.id()
            if (r13 > r11) goto L_0x0534
            int[] r11 = r0.f11147c
            int r14 = r6 + 2
            r11 = r11[r14]
            r11 = r11 & r4
            goto L_0x0535
        L_0x0534:
            r11 = 0
        L_0x0535:
            r15 = 0
        L_0x0536:
            r10 = r10 & r4
            long r3 = (long) r10
            switch(r13) {
                case 0: goto L_0x09ca;
                case 1: goto L_0x09c0;
                case 2: goto L_0x09b2;
                case 3: goto L_0x09a4;
                case 4: goto L_0x0996;
                case 5: goto L_0x098c;
                case 6: goto L_0x0982;
                case 7: goto L_0x0978;
                case 8: goto L_0x095c;
                case 9: goto L_0x094b;
                case 10: goto L_0x093c;
                case 11: goto L_0x092f;
                case 12: goto L_0x0922;
                case 13: goto L_0x0919;
                case 14: goto L_0x0910;
                case 15: goto L_0x0903;
                case 16: goto L_0x08f6;
                case 17: goto L_0x08e3;
                case 18: goto L_0x08d6;
                case 19: goto L_0x08cb;
                case 20: goto L_0x08c0;
                case 21: goto L_0x08b5;
                case 22: goto L_0x08aa;
                case 23: goto L_0x089f;
                case 24: goto L_0x0894;
                case 25: goto L_0x0889;
                case 26: goto L_0x087e;
                case 27: goto L_0x086f;
                case 28: goto L_0x0863;
                case 29: goto L_0x0857;
                case 30: goto L_0x084b;
                case 31: goto L_0x083f;
                case 32: goto L_0x0833;
                case 33: goto L_0x0827;
                case 34: goto L_0x081b;
                case 35: goto L_0x07fa;
                case 36: goto L_0x07dd;
                case 37: goto L_0x07c0;
                case 38: goto L_0x07a3;
                case 39: goto L_0x0785;
                case 40: goto L_0x0767;
                case 41: goto L_0x0749;
                case 42: goto L_0x072b;
                case 43: goto L_0x070d;
                case 44: goto L_0x06ef;
                case 45: goto L_0x06d1;
                case 46: goto L_0x06b3;
                case 47: goto L_0x0695;
                case 48: goto L_0x0677;
                case 49: goto L_0x0667;
                case 50: goto L_0x065b;
                case 51: goto L_0x064f;
                case 52: goto L_0x0643;
                case 53: goto L_0x0633;
                case 54: goto L_0x0623;
                case 55: goto L_0x0613;
                case 56: goto L_0x0607;
                case 57: goto L_0x05fb;
                case 58: goto L_0x05ef;
                case 59: goto L_0x05d1;
                case 60: goto L_0x05bd;
                case 61: goto L_0x05ab;
                case 62: goto L_0x059b;
                case 63: goto L_0x058b;
                case 64: goto L_0x057f;
                case 65: goto L_0x0573;
                case 66: goto L_0x0563;
                case 67: goto L_0x0553;
                case 68: goto L_0x053d;
                default: goto L_0x053b;
            }
        L_0x053b:
            goto L_0x09d4
        L_0x053d:
            boolean r10 = r0.a(r1, (int) r12, (int) r6)
            if (r10 == 0) goto L_0x09d4
            java.lang.Object r3 = r2.getObject(r1, r3)
            com.google.android.gms.internal.vision.ft r3 = (com.google.android.gms.internal.vision.ft) r3
            com.google.android.gms.internal.vision.gi r4 = r0.a((int) r6)
            int r3 = com.google.android.gms.internal.vision.dr.c(r12, r3, r4)
            goto L_0x08e0
        L_0x0553:
            boolean r10 = r0.a(r1, (int) r12, (int) r6)
            if (r10 == 0) goto L_0x09d4
            long r3 = e(r1, r3)
            int r3 = com.google.android.gms.internal.vision.dr.f((int) r12, (long) r3)
            goto L_0x08e0
        L_0x0563:
            boolean r10 = r0.a(r1, (int) r12, (int) r6)
            if (r10 == 0) goto L_0x09d4
            int r3 = d(r1, r3)
            int r3 = com.google.android.gms.internal.vision.dr.h(r12, r3)
            goto L_0x08e0
        L_0x0573:
            boolean r3 = r0.a(r1, (int) r12, (int) r6)
            if (r3 == 0) goto L_0x09d4
            int r3 = com.google.android.gms.internal.vision.dr.h(r12)
            goto L_0x08e0
        L_0x057f:
            boolean r3 = r0.a(r1, (int) r12, (int) r6)
            if (r3 == 0) goto L_0x09d4
            int r3 = com.google.android.gms.internal.vision.dr.f((int) r12)
            goto L_0x08e0
        L_0x058b:
            boolean r10 = r0.a(r1, (int) r12, (int) r6)
            if (r10 == 0) goto L_0x09d4
            int r3 = d(r1, r3)
            int r3 = com.google.android.gms.internal.vision.dr.i(r12, r3)
            goto L_0x08e0
        L_0x059b:
            boolean r10 = r0.a(r1, (int) r12, (int) r6)
            if (r10 == 0) goto L_0x09d4
            int r3 = d(r1, r3)
            int r3 = com.google.android.gms.internal.vision.dr.g(r12, r3)
            goto L_0x08e0
        L_0x05ab:
            boolean r10 = r0.a(r1, (int) r12, (int) r6)
            if (r10 == 0) goto L_0x09d4
            java.lang.Object r3 = r2.getObject(r1, r3)
            com.google.android.gms.internal.vision.cz r3 = (com.google.android.gms.internal.vision.cz) r3
            int r3 = com.google.android.gms.internal.vision.dr.c((int) r12, (com.google.android.gms.internal.vision.cz) r3)
            goto L_0x08e0
        L_0x05bd:
            boolean r10 = r0.a(r1, (int) r12, (int) r6)
            if (r10 == 0) goto L_0x09d4
            java.lang.Object r3 = r2.getObject(r1, r3)
            com.google.android.gms.internal.vision.gi r4 = r0.a((int) r6)
            int r3 = com.google.android.gms.internal.vision.gk.a((int) r12, (java.lang.Object) r3, (com.google.android.gms.internal.vision.gi) r4)
            goto L_0x08e0
        L_0x05d1:
            boolean r10 = r0.a(r1, (int) r12, (int) r6)
            if (r10 == 0) goto L_0x09d4
            java.lang.Object r3 = r2.getObject(r1, r3)
            boolean r4 = r3 instanceof com.google.android.gms.internal.vision.cz
            if (r4 == 0) goto L_0x05e7
            com.google.android.gms.internal.vision.cz r3 = (com.google.android.gms.internal.vision.cz) r3
            int r3 = com.google.android.gms.internal.vision.dr.c((int) r12, (com.google.android.gms.internal.vision.cz) r3)
            goto L_0x08e0
        L_0x05e7:
            java.lang.String r3 = (java.lang.String) r3
            int r3 = com.google.android.gms.internal.vision.dr.b((int) r12, (java.lang.String) r3)
            goto L_0x08e0
        L_0x05ef:
            boolean r3 = r0.a(r1, (int) r12, (int) r6)
            if (r3 == 0) goto L_0x09d4
            int r3 = com.google.android.gms.internal.vision.dr.k(r12)
            goto L_0x08e0
        L_0x05fb:
            boolean r3 = r0.a(r1, (int) r12, (int) r6)
            if (r3 == 0) goto L_0x09d4
            int r3 = com.google.android.gms.internal.vision.dr.e((int) r12)
            goto L_0x08e0
        L_0x0607:
            boolean r3 = r0.a(r1, (int) r12, (int) r6)
            if (r3 == 0) goto L_0x09d4
            int r3 = com.google.android.gms.internal.vision.dr.g((int) r12)
            goto L_0x08e0
        L_0x0613:
            boolean r10 = r0.a(r1, (int) r12, (int) r6)
            if (r10 == 0) goto L_0x09d4
            int r3 = d(r1, r3)
            int r3 = com.google.android.gms.internal.vision.dr.f((int) r12, (int) r3)
            goto L_0x08e0
        L_0x0623:
            boolean r10 = r0.a(r1, (int) r12, (int) r6)
            if (r10 == 0) goto L_0x09d4
            long r3 = e(r1, r3)
            int r3 = com.google.android.gms.internal.vision.dr.e((int) r12, (long) r3)
            goto L_0x08e0
        L_0x0633:
            boolean r10 = r0.a(r1, (int) r12, (int) r6)
            if (r10 == 0) goto L_0x09d4
            long r3 = e(r1, r3)
            int r3 = com.google.android.gms.internal.vision.dr.d((int) r12, (long) r3)
            goto L_0x08e0
        L_0x0643:
            boolean r3 = r0.a(r1, (int) r12, (int) r6)
            if (r3 == 0) goto L_0x09d4
            int r3 = com.google.android.gms.internal.vision.dr.i(r12)
            goto L_0x08e0
        L_0x064f:
            boolean r3 = r0.a(r1, (int) r12, (int) r6)
            if (r3 == 0) goto L_0x09d4
            int r3 = com.google.android.gms.internal.vision.dr.j(r12)
            goto L_0x08e0
        L_0x065b:
            com.google.android.gms.internal.vision.fl r10 = r0.s
            java.lang.Object r3 = r2.getObject(r1, r3)
            int r3 = r10.e(r3)
            goto L_0x08e0
        L_0x0667:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            com.google.android.gms.internal.vision.gi r4 = r0.a((int) r6)
            int r3 = com.google.android.gms.internal.vision.gk.b((int) r12, (java.util.List<com.google.android.gms.internal.vision.ft>) r3, (com.google.android.gms.internal.vision.gi) r4)
            goto L_0x08e0
        L_0x0677:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.vision.gk.c(r3)
            if (r3 <= 0) goto L_0x09d4
            boolean r4 = r0.k
            if (r4 == 0) goto L_0x068b
            long r10 = (long) r11
            r2.putInt(r1, r10, r3)
        L_0x068b:
            int r4 = com.google.android.gms.internal.vision.dr.l(r12)
            int r10 = com.google.android.gms.internal.vision.dr.n(r3)
            goto L_0x0816
        L_0x0695:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.vision.gk.g(r3)
            if (r3 <= 0) goto L_0x09d4
            boolean r4 = r0.k
            if (r4 == 0) goto L_0x06a9
            long r10 = (long) r11
            r2.putInt(r1, r10, r3)
        L_0x06a9:
            int r4 = com.google.android.gms.internal.vision.dr.l(r12)
            int r10 = com.google.android.gms.internal.vision.dr.n(r3)
            goto L_0x0816
        L_0x06b3:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.vision.gk.i(r3)
            if (r3 <= 0) goto L_0x09d4
            boolean r4 = r0.k
            if (r4 == 0) goto L_0x06c7
            long r10 = (long) r11
            r2.putInt(r1, r10, r3)
        L_0x06c7:
            int r4 = com.google.android.gms.internal.vision.dr.l(r12)
            int r10 = com.google.android.gms.internal.vision.dr.n(r3)
            goto L_0x0816
        L_0x06d1:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.vision.gk.h(r3)
            if (r3 <= 0) goto L_0x09d4
            boolean r4 = r0.k
            if (r4 == 0) goto L_0x06e5
            long r10 = (long) r11
            r2.putInt(r1, r10, r3)
        L_0x06e5:
            int r4 = com.google.android.gms.internal.vision.dr.l(r12)
            int r10 = com.google.android.gms.internal.vision.dr.n(r3)
            goto L_0x0816
        L_0x06ef:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.vision.gk.d(r3)
            if (r3 <= 0) goto L_0x09d4
            boolean r4 = r0.k
            if (r4 == 0) goto L_0x0703
            long r10 = (long) r11
            r2.putInt(r1, r10, r3)
        L_0x0703:
            int r4 = com.google.android.gms.internal.vision.dr.l(r12)
            int r10 = com.google.android.gms.internal.vision.dr.n(r3)
            goto L_0x0816
        L_0x070d:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.vision.gk.f(r3)
            if (r3 <= 0) goto L_0x09d4
            boolean r4 = r0.k
            if (r4 == 0) goto L_0x0721
            long r10 = (long) r11
            r2.putInt(r1, r10, r3)
        L_0x0721:
            int r4 = com.google.android.gms.internal.vision.dr.l(r12)
            int r10 = com.google.android.gms.internal.vision.dr.n(r3)
            goto L_0x0816
        L_0x072b:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.vision.gk.j(r3)
            if (r3 <= 0) goto L_0x09d4
            boolean r4 = r0.k
            if (r4 == 0) goto L_0x073f
            long r10 = (long) r11
            r2.putInt(r1, r10, r3)
        L_0x073f:
            int r4 = com.google.android.gms.internal.vision.dr.l(r12)
            int r10 = com.google.android.gms.internal.vision.dr.n(r3)
            goto L_0x0816
        L_0x0749:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.vision.gk.h(r3)
            if (r3 <= 0) goto L_0x09d4
            boolean r4 = r0.k
            if (r4 == 0) goto L_0x075d
            long r10 = (long) r11
            r2.putInt(r1, r10, r3)
        L_0x075d:
            int r4 = com.google.android.gms.internal.vision.dr.l(r12)
            int r10 = com.google.android.gms.internal.vision.dr.n(r3)
            goto L_0x0816
        L_0x0767:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.vision.gk.i(r3)
            if (r3 <= 0) goto L_0x09d4
            boolean r4 = r0.k
            if (r4 == 0) goto L_0x077b
            long r10 = (long) r11
            r2.putInt(r1, r10, r3)
        L_0x077b:
            int r4 = com.google.android.gms.internal.vision.dr.l(r12)
            int r10 = com.google.android.gms.internal.vision.dr.n(r3)
            goto L_0x0816
        L_0x0785:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.vision.gk.e(r3)
            if (r3 <= 0) goto L_0x09d4
            boolean r4 = r0.k
            if (r4 == 0) goto L_0x0799
            long r10 = (long) r11
            r2.putInt(r1, r10, r3)
        L_0x0799:
            int r4 = com.google.android.gms.internal.vision.dr.l(r12)
            int r10 = com.google.android.gms.internal.vision.dr.n(r3)
            goto L_0x0816
        L_0x07a3:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.vision.gk.b(r3)
            if (r3 <= 0) goto L_0x09d4
            boolean r4 = r0.k
            if (r4 == 0) goto L_0x07b7
            long r10 = (long) r11
            r2.putInt(r1, r10, r3)
        L_0x07b7:
            int r4 = com.google.android.gms.internal.vision.dr.l(r12)
            int r10 = com.google.android.gms.internal.vision.dr.n(r3)
            goto L_0x0816
        L_0x07c0:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.vision.gk.a((java.util.List<java.lang.Long>) r3)
            if (r3 <= 0) goto L_0x09d4
            boolean r4 = r0.k
            if (r4 == 0) goto L_0x07d4
            long r10 = (long) r11
            r2.putInt(r1, r10, r3)
        L_0x07d4:
            int r4 = com.google.android.gms.internal.vision.dr.l(r12)
            int r10 = com.google.android.gms.internal.vision.dr.n(r3)
            goto L_0x0816
        L_0x07dd:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.vision.gk.h(r3)
            if (r3 <= 0) goto L_0x09d4
            boolean r4 = r0.k
            if (r4 == 0) goto L_0x07f1
            long r10 = (long) r11
            r2.putInt(r1, r10, r3)
        L_0x07f1:
            int r4 = com.google.android.gms.internal.vision.dr.l(r12)
            int r10 = com.google.android.gms.internal.vision.dr.n(r3)
            goto L_0x0816
        L_0x07fa:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.vision.gk.i(r3)
            if (r3 <= 0) goto L_0x09d4
            boolean r4 = r0.k
            if (r4 == 0) goto L_0x080e
            long r10 = (long) r11
            r2.putInt(r1, r10, r3)
        L_0x080e:
            int r4 = com.google.android.gms.internal.vision.dr.l(r12)
            int r10 = com.google.android.gms.internal.vision.dr.n(r3)
        L_0x0816:
            int r4 = r4 + r10
            int r4 = r4 + r3
            int r7 = r7 + r4
            goto L_0x09d4
        L_0x081b:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.vision.gk.c(r12, r3)
            goto L_0x08e0
        L_0x0827:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.vision.gk.g(r12, r3)
            goto L_0x08e0
        L_0x0833:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.vision.gk.i(r12, r3)
            goto L_0x08e0
        L_0x083f:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.vision.gk.h(r12, r3)
            goto L_0x08e0
        L_0x084b:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.vision.gk.d(r12, r3)
            goto L_0x08e0
        L_0x0857:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.vision.gk.f(r12, r3)
            goto L_0x08e0
        L_0x0863:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.vision.gk.l(r12, r3)
            goto L_0x08e0
        L_0x086f:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            com.google.android.gms.internal.vision.gi r4 = r0.a((int) r6)
            int r3 = com.google.android.gms.internal.vision.gk.a((int) r12, (java.util.List<?>) r3, (com.google.android.gms.internal.vision.gi) r4)
            goto L_0x08e0
        L_0x087e:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.vision.gk.k(r12, r3)
            goto L_0x08e0
        L_0x0889:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.vision.gk.j(r12, r3)
            goto L_0x08e0
        L_0x0894:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.vision.gk.h(r12, r3)
            goto L_0x08e0
        L_0x089f:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.vision.gk.i(r12, r3)
            goto L_0x08e0
        L_0x08aa:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.vision.gk.e(r12, r3)
            goto L_0x08e0
        L_0x08b5:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.vision.gk.b(r12, r3)
            goto L_0x08e0
        L_0x08c0:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.vision.gk.a((int) r12, (java.util.List<java.lang.Long>) r3)
            goto L_0x08e0
        L_0x08cb:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.vision.gk.h(r12, r3)
            goto L_0x08e0
        L_0x08d6:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.vision.gk.i(r12, r3)
        L_0x08e0:
            int r7 = r7 + r3
            goto L_0x09d4
        L_0x08e3:
            r10 = r9 & r15
            if (r10 == 0) goto L_0x09d4
            java.lang.Object r3 = r2.getObject(r1, r3)
            com.google.android.gms.internal.vision.ft r3 = (com.google.android.gms.internal.vision.ft) r3
            com.google.android.gms.internal.vision.gi r4 = r0.a((int) r6)
            int r3 = com.google.android.gms.internal.vision.dr.c(r12, r3, r4)
            goto L_0x08e0
        L_0x08f6:
            r10 = r9 & r15
            if (r10 == 0) goto L_0x09d4
            long r3 = r2.getLong(r1, r3)
            int r3 = com.google.android.gms.internal.vision.dr.f((int) r12, (long) r3)
            goto L_0x08e0
        L_0x0903:
            r10 = r9 & r15
            if (r10 == 0) goto L_0x09d4
            int r3 = r2.getInt(r1, r3)
            int r3 = com.google.android.gms.internal.vision.dr.h(r12, r3)
            goto L_0x08e0
        L_0x0910:
            r3 = r9 & r15
            if (r3 == 0) goto L_0x09d4
            int r3 = com.google.android.gms.internal.vision.dr.h(r12)
            goto L_0x08e0
        L_0x0919:
            r3 = r9 & r15
            if (r3 == 0) goto L_0x09d4
            int r3 = com.google.android.gms.internal.vision.dr.f((int) r12)
            goto L_0x08e0
        L_0x0922:
            r10 = r9 & r15
            if (r10 == 0) goto L_0x09d4
            int r3 = r2.getInt(r1, r3)
            int r3 = com.google.android.gms.internal.vision.dr.i(r12, r3)
            goto L_0x08e0
        L_0x092f:
            r10 = r9 & r15
            if (r10 == 0) goto L_0x09d4
            int r3 = r2.getInt(r1, r3)
            int r3 = com.google.android.gms.internal.vision.dr.g(r12, r3)
            goto L_0x08e0
        L_0x093c:
            r10 = r9 & r15
            if (r10 == 0) goto L_0x09d4
            java.lang.Object r3 = r2.getObject(r1, r3)
            com.google.android.gms.internal.vision.cz r3 = (com.google.android.gms.internal.vision.cz) r3
            int r3 = com.google.android.gms.internal.vision.dr.c((int) r12, (com.google.android.gms.internal.vision.cz) r3)
            goto L_0x08e0
        L_0x094b:
            r10 = r9 & r15
            if (r10 == 0) goto L_0x09d4
            java.lang.Object r3 = r2.getObject(r1, r3)
            com.google.android.gms.internal.vision.gi r4 = r0.a((int) r6)
            int r3 = com.google.android.gms.internal.vision.gk.a((int) r12, (java.lang.Object) r3, (com.google.android.gms.internal.vision.gi) r4)
            goto L_0x08e0
        L_0x095c:
            r10 = r9 & r15
            if (r10 == 0) goto L_0x09d4
            java.lang.Object r3 = r2.getObject(r1, r3)
            boolean r4 = r3 instanceof com.google.android.gms.internal.vision.cz
            if (r4 == 0) goto L_0x0970
            com.google.android.gms.internal.vision.cz r3 = (com.google.android.gms.internal.vision.cz) r3
            int r3 = com.google.android.gms.internal.vision.dr.c((int) r12, (com.google.android.gms.internal.vision.cz) r3)
            goto L_0x08e0
        L_0x0970:
            java.lang.String r3 = (java.lang.String) r3
            int r3 = com.google.android.gms.internal.vision.dr.b((int) r12, (java.lang.String) r3)
            goto L_0x08e0
        L_0x0978:
            r3 = r9 & r15
            if (r3 == 0) goto L_0x09d4
            int r3 = com.google.android.gms.internal.vision.dr.k(r12)
            goto L_0x08e0
        L_0x0982:
            r3 = r9 & r15
            if (r3 == 0) goto L_0x09d4
            int r3 = com.google.android.gms.internal.vision.dr.e((int) r12)
            goto L_0x08e0
        L_0x098c:
            r3 = r9 & r15
            if (r3 == 0) goto L_0x09d4
            int r3 = com.google.android.gms.internal.vision.dr.g((int) r12)
            goto L_0x08e0
        L_0x0996:
            r10 = r9 & r15
            if (r10 == 0) goto L_0x09d4
            int r3 = r2.getInt(r1, r3)
            int r3 = com.google.android.gms.internal.vision.dr.f((int) r12, (int) r3)
            goto L_0x08e0
        L_0x09a4:
            r10 = r9 & r15
            if (r10 == 0) goto L_0x09d4
            long r3 = r2.getLong(r1, r3)
            int r3 = com.google.android.gms.internal.vision.dr.e((int) r12, (long) r3)
            goto L_0x08e0
        L_0x09b2:
            r10 = r9 & r15
            if (r10 == 0) goto L_0x09d4
            long r3 = r2.getLong(r1, r3)
            int r3 = com.google.android.gms.internal.vision.dr.d((int) r12, (long) r3)
            goto L_0x08e0
        L_0x09c0:
            r3 = r9 & r15
            if (r3 == 0) goto L_0x09d4
            int r3 = com.google.android.gms.internal.vision.dr.i(r12)
            goto L_0x08e0
        L_0x09ca:
            r3 = r9 & r15
            if (r3 == 0) goto L_0x09d4
            int r3 = com.google.android.gms.internal.vision.dr.j(r12)
            goto L_0x08e0
        L_0x09d4:
            int r6 = r6 + 3
            r3 = 267386880(0xff00000, float:2.3665827E-29)
            r4 = 1048575(0xfffff, float:1.469367E-39)
            goto L_0x04ec
        L_0x09dd:
            com.google.android.gms.internal.vision.ha<?, ?> r2 = r0.q
            int r2 = a(r2, r1)
            int r7 = r7 + r2
            boolean r2 = r0.f11152h
            if (r2 == 0) goto L_0x0a36
            com.google.android.gms.internal.vision.dw<?> r2 = r0.r
            com.google.android.gms.internal.vision.dz r1 = r2.a((java.lang.Object) r1)
            r2 = 0
        L_0x09ef:
            com.google.android.gms.internal.vision.gn<T, java.lang.Object> r3 = r1.f11075a
            int r3 = r3.b()
            if (r5 >= r3) goto L_0x0a0f
            com.google.android.gms.internal.vision.gn<T, java.lang.Object> r3 = r1.f11075a
            java.util.Map$Entry r3 = r3.b((int) r5)
            java.lang.Object r4 = r3.getKey()
            com.google.android.gms.internal.vision.eb r4 = (com.google.android.gms.internal.vision.eb) r4
            java.lang.Object r3 = r3.getValue()
            int r3 = com.google.android.gms.internal.vision.dz.c(r4, r3)
            int r2 = r2 + r3
            int r5 = r5 + 1
            goto L_0x09ef
        L_0x0a0f:
            com.google.android.gms.internal.vision.gn<T, java.lang.Object> r1 = r1.f11075a
            java.lang.Iterable r1 = r1.c()
            java.util.Iterator r1 = r1.iterator()
        L_0x0a19:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x0a35
            java.lang.Object r3 = r1.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r4 = r3.getKey()
            com.google.android.gms.internal.vision.eb r4 = (com.google.android.gms.internal.vision.eb) r4
            java.lang.Object r3 = r3.getValue()
            int r3 = com.google.android.gms.internal.vision.dz.c(r4, r3)
            int r2 = r2 + r3
            goto L_0x0a19
        L_0x0a35:
            int r7 = r7 + r2
        L_0x0a36:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.fx.b(java.lang.Object):int");
    }

    private static <UT, UB> int a(ha<UT, UB> haVar, T t) {
        return haVar.f(haVar.b(t));
    }

    private static List<?> a(Object obj, long j2) {
        return (List) hg.f(obj, j2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x052e  */
    /* JADX WARNING: Removed duplicated region for block: B:182:0x056e  */
    /* JADX WARNING: Removed duplicated region for block: B:335:0x0a46  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(T r14, com.google.android.gms.internal.vision.hx r15) throws java.io.IOException {
        /*
            r13 = this;
            int r0 = r15.a()
            int r1 = com.google.android.gms.internal.vision.ej.e.k
            r2 = 267386880(0xff00000, float:2.3665827E-29)
            r3 = 0
            r4 = 1
            r5 = 0
            r6 = 1048575(0xfffff, float:1.469367E-39)
            if (r0 != r1) goto L_0x0544
            com.google.android.gms.internal.vision.ha<?, ?> r0 = r13.q
            a(r0, r14, (com.google.android.gms.internal.vision.hx) r15)
            boolean r0 = r13.f11152h
            if (r0 == 0) goto L_0x004d
            com.google.android.gms.internal.vision.dw<?> r0 = r13.r
            com.google.android.gms.internal.vision.dz r0 = r0.a((java.lang.Object) r14)
            com.google.android.gms.internal.vision.gn<T, java.lang.Object> r1 = r0.f11075a
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x004d
            boolean r1 = r0.f11077c
            if (r1 == 0) goto L_0x003c
            com.google.android.gms.internal.vision.ez r1 = new com.google.android.gms.internal.vision.ez
            com.google.android.gms.internal.vision.gn<T, java.lang.Object> r0 = r0.f11075a
            java.util.Set r0 = r0.d()
            java.util.Iterator r0 = r0.iterator()
            r1.<init>(r0)
            r0 = r1
            goto L_0x0046
        L_0x003c:
            com.google.android.gms.internal.vision.gn<T, java.lang.Object> r0 = r0.f11075a
            java.util.Set r0 = r0.d()
            java.util.Iterator r0 = r0.iterator()
        L_0x0046:
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            goto L_0x004f
        L_0x004d:
            r0 = r3
            r1 = r0
        L_0x004f:
            int[] r7 = r13.f11147c
            int r7 = r7.length
            int r7 = r7 + -3
        L_0x0054:
            if (r7 < 0) goto L_0x052c
            int r8 = r13.c((int) r7)
            int[] r9 = r13.f11147c
            r9 = r9[r7]
        L_0x005e:
            if (r1 == 0) goto L_0x007c
            com.google.android.gms.internal.vision.dw<?> r10 = r13.r
            int r10 = r10.a((java.util.Map.Entry<?, ?>) r1)
            if (r10 <= r9) goto L_0x007c
            com.google.android.gms.internal.vision.dw<?> r10 = r13.r
            r10.a(r15, r1)
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x007a
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            goto L_0x005e
        L_0x007a:
            r1 = r3
            goto L_0x005e
        L_0x007c:
            r10 = r8 & r2
            int r10 = r10 >>> 20
            switch(r10) {
                case 0: goto L_0x0519;
                case 1: goto L_0x0509;
                case 2: goto L_0x04f9;
                case 3: goto L_0x04e9;
                case 4: goto L_0x04d9;
                case 5: goto L_0x04c9;
                case 6: goto L_0x04b9;
                case 7: goto L_0x04a8;
                case 8: goto L_0x0497;
                case 9: goto L_0x0482;
                case 10: goto L_0x046f;
                case 11: goto L_0x045e;
                case 12: goto L_0x044d;
                case 13: goto L_0x043c;
                case 14: goto L_0x042b;
                case 15: goto L_0x041a;
                case 16: goto L_0x0409;
                case 17: goto L_0x03f4;
                case 18: goto L_0x03e3;
                case 19: goto L_0x03d2;
                case 20: goto L_0x03c1;
                case 21: goto L_0x03b0;
                case 22: goto L_0x039f;
                case 23: goto L_0x038e;
                case 24: goto L_0x037d;
                case 25: goto L_0x036c;
                case 26: goto L_0x035b;
                case 27: goto L_0x0346;
                case 28: goto L_0x0335;
                case 29: goto L_0x0324;
                case 30: goto L_0x0313;
                case 31: goto L_0x0302;
                case 32: goto L_0x02f1;
                case 33: goto L_0x02e0;
                case 34: goto L_0x02cf;
                case 35: goto L_0x02be;
                case 36: goto L_0x02ad;
                case 37: goto L_0x029c;
                case 38: goto L_0x028b;
                case 39: goto L_0x027a;
                case 40: goto L_0x0269;
                case 41: goto L_0x0258;
                case 42: goto L_0x0247;
                case 43: goto L_0x0236;
                case 44: goto L_0x0225;
                case 45: goto L_0x0214;
                case 46: goto L_0x0203;
                case 47: goto L_0x01f2;
                case 48: goto L_0x01e1;
                case 49: goto L_0x01cc;
                case 50: goto L_0x01c1;
                case 51: goto L_0x01b0;
                case 52: goto L_0x019f;
                case 53: goto L_0x018e;
                case 54: goto L_0x017d;
                case 55: goto L_0x016c;
                case 56: goto L_0x015b;
                case 57: goto L_0x014a;
                case 58: goto L_0x0139;
                case 59: goto L_0x0128;
                case 60: goto L_0x0113;
                case 61: goto L_0x0100;
                case 62: goto L_0x00ef;
                case 63: goto L_0x00de;
                case 64: goto L_0x00cd;
                case 65: goto L_0x00bc;
                case 66: goto L_0x00ab;
                case 67: goto L_0x009a;
                case 68: goto L_0x0085;
                default: goto L_0x0083;
            }
        L_0x0083:
            goto L_0x0528
        L_0x0085:
            boolean r10 = r13.a(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.hg.f(r14, r10)
            com.google.android.gms.internal.vision.gi r10 = r13.a((int) r7)
            r15.b((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.vision.gi) r10)
            goto L_0x0528
        L_0x009a:
            boolean r10 = r13.a(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = e(r14, r10)
            r15.e((int) r9, (long) r10)
            goto L_0x0528
        L_0x00ab:
            boolean r10 = r13.a(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = d(r14, r10)
            r15.f(r9, r8)
            goto L_0x0528
        L_0x00bc:
            boolean r10 = r13.a(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = e(r14, r10)
            r15.b((int) r9, (long) r10)
            goto L_0x0528
        L_0x00cd:
            boolean r10 = r13.a(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = d(r14, r10)
            r15.a((int) r9, (int) r8)
            goto L_0x0528
        L_0x00de:
            boolean r10 = r13.a(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = d(r14, r10)
            r15.b((int) r9, (int) r8)
            goto L_0x0528
        L_0x00ef:
            boolean r10 = r13.a(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = d(r14, r10)
            r15.e((int) r9, (int) r8)
            goto L_0x0528
        L_0x0100:
            boolean r10 = r13.a(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.hg.f(r14, r10)
            com.google.android.gms.internal.vision.cz r8 = (com.google.android.gms.internal.vision.cz) r8
            r15.a((int) r9, (com.google.android.gms.internal.vision.cz) r8)
            goto L_0x0528
        L_0x0113:
            boolean r10 = r13.a(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.hg.f(r14, r10)
            com.google.android.gms.internal.vision.gi r10 = r13.a((int) r7)
            r15.a((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.vision.gi) r10)
            goto L_0x0528
        L_0x0128:
            boolean r10 = r13.a(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.hg.f(r14, r10)
            a((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.vision.hx) r15)
            goto L_0x0528
        L_0x0139:
            boolean r10 = r13.a(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            boolean r8 = f(r14, r10)
            r15.a((int) r9, (boolean) r8)
            goto L_0x0528
        L_0x014a:
            boolean r10 = r13.a(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = d(r14, r10)
            r15.d((int) r9, (int) r8)
            goto L_0x0528
        L_0x015b:
            boolean r10 = r13.a(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = e(r14, r10)
            r15.d((int) r9, (long) r10)
            goto L_0x0528
        L_0x016c:
            boolean r10 = r13.a(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = d(r14, r10)
            r15.c((int) r9, (int) r8)
            goto L_0x0528
        L_0x017d:
            boolean r10 = r13.a(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = e(r14, r10)
            r15.c((int) r9, (long) r10)
            goto L_0x0528
        L_0x018e:
            boolean r10 = r13.a(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = e(r14, r10)
            r15.a((int) r9, (long) r10)
            goto L_0x0528
        L_0x019f:
            boolean r10 = r13.a(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            float r8 = c(r14, r10)
            r15.a((int) r9, (float) r8)
            goto L_0x0528
        L_0x01b0:
            boolean r10 = r13.a(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            double r10 = b(r14, (long) r10)
            r15.a((int) r9, (double) r10)
            goto L_0x0528
        L_0x01c1:
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.hg.f(r14, r10)
            r13.a((com.google.android.gms.internal.vision.hx) r15, (int) r9, (java.lang.Object) r8)
            goto L_0x0528
        L_0x01cc:
            int[] r9 = r13.f11147c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.hg.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.gi r10 = r13.a((int) r7)
            com.google.android.gms.internal.vision.gk.b((int) r9, (java.util.List<?>) r8, (com.google.android.gms.internal.vision.hx) r15, (com.google.android.gms.internal.vision.gi) r10)
            goto L_0x0528
        L_0x01e1:
            int[] r9 = r13.f11147c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.hg.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.gk.e(r9, r8, r15, r4)
            goto L_0x0528
        L_0x01f2:
            int[] r9 = r13.f11147c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.hg.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.gk.j(r9, r8, r15, r4)
            goto L_0x0528
        L_0x0203:
            int[] r9 = r13.f11147c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.hg.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.gk.g(r9, r8, r15, r4)
            goto L_0x0528
        L_0x0214:
            int[] r9 = r13.f11147c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.hg.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.gk.l(r9, r8, r15, r4)
            goto L_0x0528
        L_0x0225:
            int[] r9 = r13.f11147c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.hg.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.gk.m(r9, r8, r15, r4)
            goto L_0x0528
        L_0x0236:
            int[] r9 = r13.f11147c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.hg.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.gk.i(r9, r8, r15, r4)
            goto L_0x0528
        L_0x0247:
            int[] r9 = r13.f11147c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.hg.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.gk.n(r9, r8, r15, r4)
            goto L_0x0528
        L_0x0258:
            int[] r9 = r13.f11147c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.hg.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.gk.k(r9, r8, r15, r4)
            goto L_0x0528
        L_0x0269:
            int[] r9 = r13.f11147c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.hg.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.gk.f(r9, r8, r15, r4)
            goto L_0x0528
        L_0x027a:
            int[] r9 = r13.f11147c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.hg.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.gk.h(r9, r8, r15, r4)
            goto L_0x0528
        L_0x028b:
            int[] r9 = r13.f11147c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.hg.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.gk.d(r9, r8, r15, r4)
            goto L_0x0528
        L_0x029c:
            int[] r9 = r13.f11147c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.hg.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.gk.c(r9, r8, r15, r4)
            goto L_0x0528
        L_0x02ad:
            int[] r9 = r13.f11147c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.hg.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.gk.b((int) r9, (java.util.List<java.lang.Float>) r8, (com.google.android.gms.internal.vision.hx) r15, (boolean) r4)
            goto L_0x0528
        L_0x02be:
            int[] r9 = r13.f11147c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.hg.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.gk.a((int) r9, (java.util.List<java.lang.Double>) r8, (com.google.android.gms.internal.vision.hx) r15, (boolean) r4)
            goto L_0x0528
        L_0x02cf:
            int[] r9 = r13.f11147c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.hg.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.gk.e(r9, r8, r15, r5)
            goto L_0x0528
        L_0x02e0:
            int[] r9 = r13.f11147c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.hg.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.gk.j(r9, r8, r15, r5)
            goto L_0x0528
        L_0x02f1:
            int[] r9 = r13.f11147c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.hg.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.gk.g(r9, r8, r15, r5)
            goto L_0x0528
        L_0x0302:
            int[] r9 = r13.f11147c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.hg.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.gk.l(r9, r8, r15, r5)
            goto L_0x0528
        L_0x0313:
            int[] r9 = r13.f11147c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.hg.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.gk.m(r9, r8, r15, r5)
            goto L_0x0528
        L_0x0324:
            int[] r9 = r13.f11147c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.hg.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.gk.i(r9, r8, r15, r5)
            goto L_0x0528
        L_0x0335:
            int[] r9 = r13.f11147c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.hg.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.gk.b((int) r9, (java.util.List<com.google.android.gms.internal.vision.cz>) r8, (com.google.android.gms.internal.vision.hx) r15)
            goto L_0x0528
        L_0x0346:
            int[] r9 = r13.f11147c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.hg.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.gi r10 = r13.a((int) r7)
            com.google.android.gms.internal.vision.gk.a((int) r9, (java.util.List<?>) r8, (com.google.android.gms.internal.vision.hx) r15, (com.google.android.gms.internal.vision.gi) r10)
            goto L_0x0528
        L_0x035b:
            int[] r9 = r13.f11147c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.hg.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.gk.a((int) r9, (java.util.List<java.lang.String>) r8, (com.google.android.gms.internal.vision.hx) r15)
            goto L_0x0528
        L_0x036c:
            int[] r9 = r13.f11147c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.hg.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.gk.n(r9, r8, r15, r5)
            goto L_0x0528
        L_0x037d:
            int[] r9 = r13.f11147c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.hg.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.gk.k(r9, r8, r15, r5)
            goto L_0x0528
        L_0x038e:
            int[] r9 = r13.f11147c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.hg.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.gk.f(r9, r8, r15, r5)
            goto L_0x0528
        L_0x039f:
            int[] r9 = r13.f11147c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.hg.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.gk.h(r9, r8, r15, r5)
            goto L_0x0528
        L_0x03b0:
            int[] r9 = r13.f11147c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.hg.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.gk.d(r9, r8, r15, r5)
            goto L_0x0528
        L_0x03c1:
            int[] r9 = r13.f11147c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.hg.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.gk.c(r9, r8, r15, r5)
            goto L_0x0528
        L_0x03d2:
            int[] r9 = r13.f11147c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.hg.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.gk.b((int) r9, (java.util.List<java.lang.Float>) r8, (com.google.android.gms.internal.vision.hx) r15, (boolean) r5)
            goto L_0x0528
        L_0x03e3:
            int[] r9 = r13.f11147c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.hg.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.gk.a((int) r9, (java.util.List<java.lang.Double>) r8, (com.google.android.gms.internal.vision.hx) r15, (boolean) r5)
            goto L_0x0528
        L_0x03f4:
            boolean r10 = r13.a(r14, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.hg.f(r14, r10)
            com.google.android.gms.internal.vision.gi r10 = r13.a((int) r7)
            r15.b((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.vision.gi) r10)
            goto L_0x0528
        L_0x0409:
            boolean r10 = r13.a(r14, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.vision.hg.b(r14, r10)
            r15.e((int) r9, (long) r10)
            goto L_0x0528
        L_0x041a:
            boolean r10 = r13.a(r14, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.vision.hg.a((java.lang.Object) r14, (long) r10)
            r15.f(r9, r8)
            goto L_0x0528
        L_0x042b:
            boolean r10 = r13.a(r14, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.vision.hg.b(r14, r10)
            r15.b((int) r9, (long) r10)
            goto L_0x0528
        L_0x043c:
            boolean r10 = r13.a(r14, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.vision.hg.a((java.lang.Object) r14, (long) r10)
            r15.a((int) r9, (int) r8)
            goto L_0x0528
        L_0x044d:
            boolean r10 = r13.a(r14, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.vision.hg.a((java.lang.Object) r14, (long) r10)
            r15.b((int) r9, (int) r8)
            goto L_0x0528
        L_0x045e:
            boolean r10 = r13.a(r14, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.vision.hg.a((java.lang.Object) r14, (long) r10)
            r15.e((int) r9, (int) r8)
            goto L_0x0528
        L_0x046f:
            boolean r10 = r13.a(r14, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.hg.f(r14, r10)
            com.google.android.gms.internal.vision.cz r8 = (com.google.android.gms.internal.vision.cz) r8
            r15.a((int) r9, (com.google.android.gms.internal.vision.cz) r8)
            goto L_0x0528
        L_0x0482:
            boolean r10 = r13.a(r14, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.hg.f(r14, r10)
            com.google.android.gms.internal.vision.gi r10 = r13.a((int) r7)
            r15.a((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.vision.gi) r10)
            goto L_0x0528
        L_0x0497:
            boolean r10 = r13.a(r14, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.hg.f(r14, r10)
            a((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.vision.hx) r15)
            goto L_0x0528
        L_0x04a8:
            boolean r10 = r13.a(r14, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            boolean r8 = com.google.android.gms.internal.vision.hg.c(r14, r10)
            r15.a((int) r9, (boolean) r8)
            goto L_0x0528
        L_0x04b9:
            boolean r10 = r13.a(r14, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.vision.hg.a((java.lang.Object) r14, (long) r10)
            r15.d((int) r9, (int) r8)
            goto L_0x0528
        L_0x04c9:
            boolean r10 = r13.a(r14, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.vision.hg.b(r14, r10)
            r15.d((int) r9, (long) r10)
            goto L_0x0528
        L_0x04d9:
            boolean r10 = r13.a(r14, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.vision.hg.a((java.lang.Object) r14, (long) r10)
            r15.c((int) r9, (int) r8)
            goto L_0x0528
        L_0x04e9:
            boolean r10 = r13.a(r14, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.vision.hg.b(r14, r10)
            r15.c((int) r9, (long) r10)
            goto L_0x0528
        L_0x04f9:
            boolean r10 = r13.a(r14, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.vision.hg.b(r14, r10)
            r15.a((int) r9, (long) r10)
            goto L_0x0528
        L_0x0509:
            boolean r10 = r13.a(r14, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            float r8 = com.google.android.gms.internal.vision.hg.d(r14, r10)
            r15.a((int) r9, (float) r8)
            goto L_0x0528
        L_0x0519:
            boolean r10 = r13.a(r14, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            double r10 = com.google.android.gms.internal.vision.hg.e(r14, r10)
            r15.a((int) r9, (double) r10)
        L_0x0528:
            int r7 = r7 + -3
            goto L_0x0054
        L_0x052c:
            if (r1 == 0) goto L_0x0543
            com.google.android.gms.internal.vision.dw<?> r14 = r13.r
            r14.a(r15, r1)
            boolean r14 = r0.hasNext()
            if (r14 == 0) goto L_0x0541
            java.lang.Object r14 = r0.next()
            java.util.Map$Entry r14 = (java.util.Map.Entry) r14
            r1 = r14
            goto L_0x052c
        L_0x0541:
            r1 = r3
            goto L_0x052c
        L_0x0543:
            return
        L_0x0544:
            boolean r0 = r13.j
            if (r0 == 0) goto L_0x0a61
            boolean r0 = r13.f11152h
            if (r0 == 0) goto L_0x0565
            com.google.android.gms.internal.vision.dw<?> r0 = r13.r
            com.google.android.gms.internal.vision.dz r0 = r0.a((java.lang.Object) r14)
            com.google.android.gms.internal.vision.gn<T, java.lang.Object> r1 = r0.f11075a
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x0565
            java.util.Iterator r0 = r0.c()
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            goto L_0x0567
        L_0x0565:
            r0 = r3
            r1 = r0
        L_0x0567:
            int[] r7 = r13.f11147c
            int r7 = r7.length
            r8 = r1
            r1 = 0
        L_0x056c:
            if (r1 >= r7) goto L_0x0a44
            int r9 = r13.c((int) r1)
            int[] r10 = r13.f11147c
            r10 = r10[r1]
        L_0x0576:
            if (r8 == 0) goto L_0x0594
            com.google.android.gms.internal.vision.dw<?> r11 = r13.r
            int r11 = r11.a((java.util.Map.Entry<?, ?>) r8)
            if (r11 > r10) goto L_0x0594
            com.google.android.gms.internal.vision.dw<?> r11 = r13.r
            r11.a(r15, r8)
            boolean r8 = r0.hasNext()
            if (r8 == 0) goto L_0x0592
            java.lang.Object r8 = r0.next()
            java.util.Map$Entry r8 = (java.util.Map.Entry) r8
            goto L_0x0576
        L_0x0592:
            r8 = r3
            goto L_0x0576
        L_0x0594:
            r11 = r9 & r2
            int r11 = r11 >>> 20
            switch(r11) {
                case 0: goto L_0x0a31;
                case 1: goto L_0x0a21;
                case 2: goto L_0x0a11;
                case 3: goto L_0x0a01;
                case 4: goto L_0x09f1;
                case 5: goto L_0x09e1;
                case 6: goto L_0x09d1;
                case 7: goto L_0x09c0;
                case 8: goto L_0x09af;
                case 9: goto L_0x099a;
                case 10: goto L_0x0987;
                case 11: goto L_0x0976;
                case 12: goto L_0x0965;
                case 13: goto L_0x0954;
                case 14: goto L_0x0943;
                case 15: goto L_0x0932;
                case 16: goto L_0x0921;
                case 17: goto L_0x090c;
                case 18: goto L_0x08fb;
                case 19: goto L_0x08ea;
                case 20: goto L_0x08d9;
                case 21: goto L_0x08c8;
                case 22: goto L_0x08b7;
                case 23: goto L_0x08a6;
                case 24: goto L_0x0895;
                case 25: goto L_0x0884;
                case 26: goto L_0x0873;
                case 27: goto L_0x085e;
                case 28: goto L_0x084d;
                case 29: goto L_0x083c;
                case 30: goto L_0x082b;
                case 31: goto L_0x081a;
                case 32: goto L_0x0809;
                case 33: goto L_0x07f8;
                case 34: goto L_0x07e7;
                case 35: goto L_0x07d6;
                case 36: goto L_0x07c5;
                case 37: goto L_0x07b4;
                case 38: goto L_0x07a3;
                case 39: goto L_0x0792;
                case 40: goto L_0x0781;
                case 41: goto L_0x0770;
                case 42: goto L_0x075f;
                case 43: goto L_0x074e;
                case 44: goto L_0x073d;
                case 45: goto L_0x072c;
                case 46: goto L_0x071b;
                case 47: goto L_0x070a;
                case 48: goto L_0x06f9;
                case 49: goto L_0x06e4;
                case 50: goto L_0x06d9;
                case 51: goto L_0x06c8;
                case 52: goto L_0x06b7;
                case 53: goto L_0x06a6;
                case 54: goto L_0x0695;
                case 55: goto L_0x0684;
                case 56: goto L_0x0673;
                case 57: goto L_0x0662;
                case 58: goto L_0x0651;
                case 59: goto L_0x0640;
                case 60: goto L_0x062b;
                case 61: goto L_0x0618;
                case 62: goto L_0x0607;
                case 63: goto L_0x05f6;
                case 64: goto L_0x05e5;
                case 65: goto L_0x05d4;
                case 66: goto L_0x05c3;
                case 67: goto L_0x05b2;
                case 68: goto L_0x059d;
                default: goto L_0x059b;
            }
        L_0x059b:
            goto L_0x0a40
        L_0x059d:
            boolean r11 = r13.a(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.hg.f(r14, r11)
            com.google.android.gms.internal.vision.gi r11 = r13.a((int) r1)
            r15.b((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.vision.gi) r11)
            goto L_0x0a40
        L_0x05b2:
            boolean r11 = r13.a(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = e(r14, r11)
            r15.e((int) r10, (long) r11)
            goto L_0x0a40
        L_0x05c3:
            boolean r11 = r13.a(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = d(r14, r11)
            r15.f(r10, r9)
            goto L_0x0a40
        L_0x05d4:
            boolean r11 = r13.a(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = e(r14, r11)
            r15.b((int) r10, (long) r11)
            goto L_0x0a40
        L_0x05e5:
            boolean r11 = r13.a(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = d(r14, r11)
            r15.a((int) r10, (int) r9)
            goto L_0x0a40
        L_0x05f6:
            boolean r11 = r13.a(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = d(r14, r11)
            r15.b((int) r10, (int) r9)
            goto L_0x0a40
        L_0x0607:
            boolean r11 = r13.a(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = d(r14, r11)
            r15.e((int) r10, (int) r9)
            goto L_0x0a40
        L_0x0618:
            boolean r11 = r13.a(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.hg.f(r14, r11)
            com.google.android.gms.internal.vision.cz r9 = (com.google.android.gms.internal.vision.cz) r9
            r15.a((int) r10, (com.google.android.gms.internal.vision.cz) r9)
            goto L_0x0a40
        L_0x062b:
            boolean r11 = r13.a(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.hg.f(r14, r11)
            com.google.android.gms.internal.vision.gi r11 = r13.a((int) r1)
            r15.a((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.vision.gi) r11)
            goto L_0x0a40
        L_0x0640:
            boolean r11 = r13.a(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.hg.f(r14, r11)
            a((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.vision.hx) r15)
            goto L_0x0a40
        L_0x0651:
            boolean r11 = r13.a(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            boolean r9 = f(r14, r11)
            r15.a((int) r10, (boolean) r9)
            goto L_0x0a40
        L_0x0662:
            boolean r11 = r13.a(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = d(r14, r11)
            r15.d((int) r10, (int) r9)
            goto L_0x0a40
        L_0x0673:
            boolean r11 = r13.a(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = e(r14, r11)
            r15.d((int) r10, (long) r11)
            goto L_0x0a40
        L_0x0684:
            boolean r11 = r13.a(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = d(r14, r11)
            r15.c((int) r10, (int) r9)
            goto L_0x0a40
        L_0x0695:
            boolean r11 = r13.a(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = e(r14, r11)
            r15.c((int) r10, (long) r11)
            goto L_0x0a40
        L_0x06a6:
            boolean r11 = r13.a(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = e(r14, r11)
            r15.a((int) r10, (long) r11)
            goto L_0x0a40
        L_0x06b7:
            boolean r11 = r13.a(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            float r9 = c(r14, r11)
            r15.a((int) r10, (float) r9)
            goto L_0x0a40
        L_0x06c8:
            boolean r11 = r13.a(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            double r11 = b(r14, (long) r11)
            r15.a((int) r10, (double) r11)
            goto L_0x0a40
        L_0x06d9:
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.hg.f(r14, r11)
            r13.a((com.google.android.gms.internal.vision.hx) r15, (int) r10, (java.lang.Object) r9)
            goto L_0x0a40
        L_0x06e4:
            int[] r10 = r13.f11147c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.hg.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.gi r11 = r13.a((int) r1)
            com.google.android.gms.internal.vision.gk.b((int) r10, (java.util.List<?>) r9, (com.google.android.gms.internal.vision.hx) r15, (com.google.android.gms.internal.vision.gi) r11)
            goto L_0x0a40
        L_0x06f9:
            int[] r10 = r13.f11147c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.hg.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.gk.e(r10, r9, r15, r4)
            goto L_0x0a40
        L_0x070a:
            int[] r10 = r13.f11147c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.hg.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.gk.j(r10, r9, r15, r4)
            goto L_0x0a40
        L_0x071b:
            int[] r10 = r13.f11147c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.hg.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.gk.g(r10, r9, r15, r4)
            goto L_0x0a40
        L_0x072c:
            int[] r10 = r13.f11147c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.hg.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.gk.l(r10, r9, r15, r4)
            goto L_0x0a40
        L_0x073d:
            int[] r10 = r13.f11147c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.hg.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.gk.m(r10, r9, r15, r4)
            goto L_0x0a40
        L_0x074e:
            int[] r10 = r13.f11147c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.hg.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.gk.i(r10, r9, r15, r4)
            goto L_0x0a40
        L_0x075f:
            int[] r10 = r13.f11147c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.hg.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.gk.n(r10, r9, r15, r4)
            goto L_0x0a40
        L_0x0770:
            int[] r10 = r13.f11147c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.hg.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.gk.k(r10, r9, r15, r4)
            goto L_0x0a40
        L_0x0781:
            int[] r10 = r13.f11147c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.hg.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.gk.f(r10, r9, r15, r4)
            goto L_0x0a40
        L_0x0792:
            int[] r10 = r13.f11147c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.hg.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.gk.h(r10, r9, r15, r4)
            goto L_0x0a40
        L_0x07a3:
            int[] r10 = r13.f11147c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.hg.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.gk.d(r10, r9, r15, r4)
            goto L_0x0a40
        L_0x07b4:
            int[] r10 = r13.f11147c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.hg.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.gk.c(r10, r9, r15, r4)
            goto L_0x0a40
        L_0x07c5:
            int[] r10 = r13.f11147c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.hg.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.gk.b((int) r10, (java.util.List<java.lang.Float>) r9, (com.google.android.gms.internal.vision.hx) r15, (boolean) r4)
            goto L_0x0a40
        L_0x07d6:
            int[] r10 = r13.f11147c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.hg.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.gk.a((int) r10, (java.util.List<java.lang.Double>) r9, (com.google.android.gms.internal.vision.hx) r15, (boolean) r4)
            goto L_0x0a40
        L_0x07e7:
            int[] r10 = r13.f11147c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.hg.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.gk.e(r10, r9, r15, r5)
            goto L_0x0a40
        L_0x07f8:
            int[] r10 = r13.f11147c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.hg.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.gk.j(r10, r9, r15, r5)
            goto L_0x0a40
        L_0x0809:
            int[] r10 = r13.f11147c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.hg.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.gk.g(r10, r9, r15, r5)
            goto L_0x0a40
        L_0x081a:
            int[] r10 = r13.f11147c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.hg.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.gk.l(r10, r9, r15, r5)
            goto L_0x0a40
        L_0x082b:
            int[] r10 = r13.f11147c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.hg.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.gk.m(r10, r9, r15, r5)
            goto L_0x0a40
        L_0x083c:
            int[] r10 = r13.f11147c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.hg.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.gk.i(r10, r9, r15, r5)
            goto L_0x0a40
        L_0x084d:
            int[] r10 = r13.f11147c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.hg.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.gk.b((int) r10, (java.util.List<com.google.android.gms.internal.vision.cz>) r9, (com.google.android.gms.internal.vision.hx) r15)
            goto L_0x0a40
        L_0x085e:
            int[] r10 = r13.f11147c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.hg.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.gi r11 = r13.a((int) r1)
            com.google.android.gms.internal.vision.gk.a((int) r10, (java.util.List<?>) r9, (com.google.android.gms.internal.vision.hx) r15, (com.google.android.gms.internal.vision.gi) r11)
            goto L_0x0a40
        L_0x0873:
            int[] r10 = r13.f11147c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.hg.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.gk.a((int) r10, (java.util.List<java.lang.String>) r9, (com.google.android.gms.internal.vision.hx) r15)
            goto L_0x0a40
        L_0x0884:
            int[] r10 = r13.f11147c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.hg.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.gk.n(r10, r9, r15, r5)
            goto L_0x0a40
        L_0x0895:
            int[] r10 = r13.f11147c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.hg.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.gk.k(r10, r9, r15, r5)
            goto L_0x0a40
        L_0x08a6:
            int[] r10 = r13.f11147c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.hg.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.gk.f(r10, r9, r15, r5)
            goto L_0x0a40
        L_0x08b7:
            int[] r10 = r13.f11147c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.hg.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.gk.h(r10, r9, r15, r5)
            goto L_0x0a40
        L_0x08c8:
            int[] r10 = r13.f11147c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.hg.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.gk.d(r10, r9, r15, r5)
            goto L_0x0a40
        L_0x08d9:
            int[] r10 = r13.f11147c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.hg.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.gk.c(r10, r9, r15, r5)
            goto L_0x0a40
        L_0x08ea:
            int[] r10 = r13.f11147c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.hg.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.gk.b((int) r10, (java.util.List<java.lang.Float>) r9, (com.google.android.gms.internal.vision.hx) r15, (boolean) r5)
            goto L_0x0a40
        L_0x08fb:
            int[] r10 = r13.f11147c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.hg.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.gk.a((int) r10, (java.util.List<java.lang.Double>) r9, (com.google.android.gms.internal.vision.hx) r15, (boolean) r5)
            goto L_0x0a40
        L_0x090c:
            boolean r11 = r13.a(r14, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.hg.f(r14, r11)
            com.google.android.gms.internal.vision.gi r11 = r13.a((int) r1)
            r15.b((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.vision.gi) r11)
            goto L_0x0a40
        L_0x0921:
            boolean r11 = r13.a(r14, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.vision.hg.b(r14, r11)
            r15.e((int) r10, (long) r11)
            goto L_0x0a40
        L_0x0932:
            boolean r11 = r13.a(r14, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.vision.hg.a((java.lang.Object) r14, (long) r11)
            r15.f(r10, r9)
            goto L_0x0a40
        L_0x0943:
            boolean r11 = r13.a(r14, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.vision.hg.b(r14, r11)
            r15.b((int) r10, (long) r11)
            goto L_0x0a40
        L_0x0954:
            boolean r11 = r13.a(r14, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.vision.hg.a((java.lang.Object) r14, (long) r11)
            r15.a((int) r10, (int) r9)
            goto L_0x0a40
        L_0x0965:
            boolean r11 = r13.a(r14, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.vision.hg.a((java.lang.Object) r14, (long) r11)
            r15.b((int) r10, (int) r9)
            goto L_0x0a40
        L_0x0976:
            boolean r11 = r13.a(r14, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.vision.hg.a((java.lang.Object) r14, (long) r11)
            r15.e((int) r10, (int) r9)
            goto L_0x0a40
        L_0x0987:
            boolean r11 = r13.a(r14, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.hg.f(r14, r11)
            com.google.android.gms.internal.vision.cz r9 = (com.google.android.gms.internal.vision.cz) r9
            r15.a((int) r10, (com.google.android.gms.internal.vision.cz) r9)
            goto L_0x0a40
        L_0x099a:
            boolean r11 = r13.a(r14, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.hg.f(r14, r11)
            com.google.android.gms.internal.vision.gi r11 = r13.a((int) r1)
            r15.a((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.vision.gi) r11)
            goto L_0x0a40
        L_0x09af:
            boolean r11 = r13.a(r14, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.hg.f(r14, r11)
            a((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.vision.hx) r15)
            goto L_0x0a40
        L_0x09c0:
            boolean r11 = r13.a(r14, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            boolean r9 = com.google.android.gms.internal.vision.hg.c(r14, r11)
            r15.a((int) r10, (boolean) r9)
            goto L_0x0a40
        L_0x09d1:
            boolean r11 = r13.a(r14, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.vision.hg.a((java.lang.Object) r14, (long) r11)
            r15.d((int) r10, (int) r9)
            goto L_0x0a40
        L_0x09e1:
            boolean r11 = r13.a(r14, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.vision.hg.b(r14, r11)
            r15.d((int) r10, (long) r11)
            goto L_0x0a40
        L_0x09f1:
            boolean r11 = r13.a(r14, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.vision.hg.a((java.lang.Object) r14, (long) r11)
            r15.c((int) r10, (int) r9)
            goto L_0x0a40
        L_0x0a01:
            boolean r11 = r13.a(r14, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.vision.hg.b(r14, r11)
            r15.c((int) r10, (long) r11)
            goto L_0x0a40
        L_0x0a11:
            boolean r11 = r13.a(r14, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.vision.hg.b(r14, r11)
            r15.a((int) r10, (long) r11)
            goto L_0x0a40
        L_0x0a21:
            boolean r11 = r13.a(r14, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            float r9 = com.google.android.gms.internal.vision.hg.d(r14, r11)
            r15.a((int) r10, (float) r9)
            goto L_0x0a40
        L_0x0a31:
            boolean r11 = r13.a(r14, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            double r11 = com.google.android.gms.internal.vision.hg.e(r14, r11)
            r15.a((int) r10, (double) r11)
        L_0x0a40:
            int r1 = r1 + 3
            goto L_0x056c
        L_0x0a44:
            if (r8 == 0) goto L_0x0a5b
            com.google.android.gms.internal.vision.dw<?> r1 = r13.r
            r1.a(r15, r8)
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0a59
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            r8 = r1
            goto L_0x0a44
        L_0x0a59:
            r8 = r3
            goto L_0x0a44
        L_0x0a5b:
            com.google.android.gms.internal.vision.ha<?, ?> r0 = r13.q
            a(r0, r14, (com.google.android.gms.internal.vision.hx) r15)
            return
        L_0x0a61:
            r13.b(r14, (com.google.android.gms.internal.vision.hx) r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.fx.a(java.lang.Object, com.google.android.gms.internal.vision.hx):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:172:0x049e  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0032  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void b(T r18, com.google.android.gms.internal.vision.hx r19) throws java.io.IOException {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r19
            boolean r3 = r0.f11152h
            if (r3 == 0) goto L_0x0023
            com.google.android.gms.internal.vision.dw<?> r3 = r0.r
            com.google.android.gms.internal.vision.dz r3 = r3.a((java.lang.Object) r1)
            com.google.android.gms.internal.vision.gn<T, java.lang.Object> r5 = r3.f11075a
            boolean r5 = r5.isEmpty()
            if (r5 != 0) goto L_0x0023
            java.util.Iterator r3 = r3.c()
            java.lang.Object r5 = r3.next()
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            goto L_0x0025
        L_0x0023:
            r3 = 0
            r5 = 0
        L_0x0025:
            int[] r6 = r0.f11147c
            int r6 = r6.length
            sun.misc.Unsafe r7 = f11146b
            r11 = r5
            r5 = 0
            r10 = 1048575(0xfffff, float:1.469367E-39)
            r12 = 0
        L_0x0030:
            if (r5 >= r6) goto L_0x049b
            int r13 = r0.c((int) r5)
            int[] r14 = r0.f11147c
            r15 = r14[r5]
            r16 = 267386880(0xff00000, float:2.3665827E-29)
            r16 = r13 & r16
            int r4 = r16 >>> 20
            boolean r9 = r0.j
            if (r9 != 0) goto L_0x0063
            r9 = 17
            if (r4 > r9) goto L_0x0063
            int r9 = r5 + 2
            r9 = r14[r9]
            r14 = 1048575(0xfffff, float:1.469367E-39)
            r8 = r9 & r14
            r14 = r11
            if (r8 == r10) goto L_0x005a
            long r10 = (long) r8
            int r12 = r7.getInt(r1, r10)
            goto L_0x005b
        L_0x005a:
            r8 = r10
        L_0x005b:
            int r9 = r9 >>> 20
            r10 = 1
            int r9 = r10 << r9
            r10 = r8
            r11 = r14
            goto L_0x0066
        L_0x0063:
            r14 = r11
            r11 = r14
            r9 = 0
        L_0x0066:
            if (r11 == 0) goto L_0x0085
            com.google.android.gms.internal.vision.dw<?> r8 = r0.r
            int r8 = r8.a((java.util.Map.Entry<?, ?>) r11)
            if (r8 > r15) goto L_0x0085
            com.google.android.gms.internal.vision.dw<?> r8 = r0.r
            r8.a(r2, r11)
            boolean r8 = r3.hasNext()
            if (r8 == 0) goto L_0x0083
            java.lang.Object r8 = r3.next()
            java.util.Map$Entry r8 = (java.util.Map.Entry) r8
            r11 = r8
            goto L_0x0066
        L_0x0083:
            r11 = 0
            goto L_0x0066
        L_0x0085:
            r8 = 1048575(0xfffff, float:1.469367E-39)
            r13 = r13 & r8
            long r13 = (long) r13
            switch(r4) {
                case 0: goto L_0x048c;
                case 1: goto L_0x0480;
                case 2: goto L_0x0474;
                case 3: goto L_0x0468;
                case 4: goto L_0x045c;
                case 5: goto L_0x0450;
                case 6: goto L_0x0444;
                case 7: goto L_0x0438;
                case 8: goto L_0x042c;
                case 9: goto L_0x041b;
                case 10: goto L_0x040c;
                case 11: goto L_0x03ff;
                case 12: goto L_0x03f2;
                case 13: goto L_0x03e5;
                case 14: goto L_0x03d8;
                case 15: goto L_0x03cb;
                case 16: goto L_0x03be;
                case 17: goto L_0x03ad;
                case 18: goto L_0x039d;
                case 19: goto L_0x038d;
                case 20: goto L_0x037d;
                case 21: goto L_0x036d;
                case 22: goto L_0x035d;
                case 23: goto L_0x034d;
                case 24: goto L_0x033d;
                case 25: goto L_0x032d;
                case 26: goto L_0x031e;
                case 27: goto L_0x030b;
                case 28: goto L_0x02fc;
                case 29: goto L_0x02ec;
                case 30: goto L_0x02dc;
                case 31: goto L_0x02cc;
                case 32: goto L_0x02bc;
                case 33: goto L_0x02ac;
                case 34: goto L_0x029c;
                case 35: goto L_0x028c;
                case 36: goto L_0x027c;
                case 37: goto L_0x026c;
                case 38: goto L_0x025c;
                case 39: goto L_0x024c;
                case 40: goto L_0x023c;
                case 41: goto L_0x022c;
                case 42: goto L_0x021c;
                case 43: goto L_0x020c;
                case 44: goto L_0x01fc;
                case 45: goto L_0x01ec;
                case 46: goto L_0x01dc;
                case 47: goto L_0x01cc;
                case 48: goto L_0x01bc;
                case 49: goto L_0x01a9;
                case 50: goto L_0x01a0;
                case 51: goto L_0x0191;
                case 52: goto L_0x0182;
                case 53: goto L_0x0173;
                case 54: goto L_0x0164;
                case 55: goto L_0x0155;
                case 56: goto L_0x0146;
                case 57: goto L_0x0137;
                case 58: goto L_0x0128;
                case 59: goto L_0x0119;
                case 60: goto L_0x0106;
                case 61: goto L_0x00f6;
                case 62: goto L_0x00e8;
                case 63: goto L_0x00da;
                case 64: goto L_0x00cc;
                case 65: goto L_0x00be;
                case 66: goto L_0x00b0;
                case 67: goto L_0x00a2;
                case 68: goto L_0x0090;
                default: goto L_0x008d;
            }
        L_0x008d:
            r4 = 0
            goto L_0x0497
        L_0x0090:
            boolean r4 = r0.a(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x008d
            java.lang.Object r4 = r7.getObject(r1, r13)
            com.google.android.gms.internal.vision.gi r9 = r0.a((int) r5)
            r2.b((int) r15, (java.lang.Object) r4, (com.google.android.gms.internal.vision.gi) r9)
            goto L_0x008d
        L_0x00a2:
            boolean r4 = r0.a(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x008d
            long r13 = e(r1, r13)
            r2.e((int) r15, (long) r13)
            goto L_0x008d
        L_0x00b0:
            boolean r4 = r0.a(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x008d
            int r4 = d(r1, r13)
            r2.f(r15, r4)
            goto L_0x008d
        L_0x00be:
            boolean r4 = r0.a(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x008d
            long r13 = e(r1, r13)
            r2.b((int) r15, (long) r13)
            goto L_0x008d
        L_0x00cc:
            boolean r4 = r0.a(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x008d
            int r4 = d(r1, r13)
            r2.a((int) r15, (int) r4)
            goto L_0x008d
        L_0x00da:
            boolean r4 = r0.a(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x008d
            int r4 = d(r1, r13)
            r2.b((int) r15, (int) r4)
            goto L_0x008d
        L_0x00e8:
            boolean r4 = r0.a(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x008d
            int r4 = d(r1, r13)
            r2.e((int) r15, (int) r4)
            goto L_0x008d
        L_0x00f6:
            boolean r4 = r0.a(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x008d
            java.lang.Object r4 = r7.getObject(r1, r13)
            com.google.android.gms.internal.vision.cz r4 = (com.google.android.gms.internal.vision.cz) r4
            r2.a((int) r15, (com.google.android.gms.internal.vision.cz) r4)
            goto L_0x008d
        L_0x0106:
            boolean r4 = r0.a(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x008d
            java.lang.Object r4 = r7.getObject(r1, r13)
            com.google.android.gms.internal.vision.gi r9 = r0.a((int) r5)
            r2.a((int) r15, (java.lang.Object) r4, (com.google.android.gms.internal.vision.gi) r9)
            goto L_0x008d
        L_0x0119:
            boolean r4 = r0.a(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x008d
            java.lang.Object r4 = r7.getObject(r1, r13)
            a((int) r15, (java.lang.Object) r4, (com.google.android.gms.internal.vision.hx) r2)
            goto L_0x008d
        L_0x0128:
            boolean r4 = r0.a(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x008d
            boolean r4 = f(r1, r13)
            r2.a((int) r15, (boolean) r4)
            goto L_0x008d
        L_0x0137:
            boolean r4 = r0.a(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x008d
            int r4 = d(r1, r13)
            r2.d((int) r15, (int) r4)
            goto L_0x008d
        L_0x0146:
            boolean r4 = r0.a(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x008d
            long r13 = e(r1, r13)
            r2.d((int) r15, (long) r13)
            goto L_0x008d
        L_0x0155:
            boolean r4 = r0.a(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x008d
            int r4 = d(r1, r13)
            r2.c((int) r15, (int) r4)
            goto L_0x008d
        L_0x0164:
            boolean r4 = r0.a(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x008d
            long r13 = e(r1, r13)
            r2.c((int) r15, (long) r13)
            goto L_0x008d
        L_0x0173:
            boolean r4 = r0.a(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x008d
            long r13 = e(r1, r13)
            r2.a((int) r15, (long) r13)
            goto L_0x008d
        L_0x0182:
            boolean r4 = r0.a(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x008d
            float r4 = c(r1, r13)
            r2.a((int) r15, (float) r4)
            goto L_0x008d
        L_0x0191:
            boolean r4 = r0.a(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x008d
            double r13 = b(r1, (long) r13)
            r2.a((int) r15, (double) r13)
            goto L_0x008d
        L_0x01a0:
            java.lang.Object r4 = r7.getObject(r1, r13)
            r0.a((com.google.android.gms.internal.vision.hx) r2, (int) r15, (java.lang.Object) r4)
            goto L_0x008d
        L_0x01a9:
            int[] r4 = r0.f11147c
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.gi r13 = r0.a((int) r5)
            com.google.android.gms.internal.vision.gk.b((int) r4, (java.util.List<?>) r9, (com.google.android.gms.internal.vision.hx) r2, (com.google.android.gms.internal.vision.gi) r13)
            goto L_0x008d
        L_0x01bc:
            int[] r4 = r0.f11147c
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            r15 = 1
            com.google.android.gms.internal.vision.gk.e(r4, r9, r2, r15)
            goto L_0x008d
        L_0x01cc:
            r15 = 1
            int[] r4 = r0.f11147c
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.gk.j(r4, r9, r2, r15)
            goto L_0x008d
        L_0x01dc:
            r15 = 1
            int[] r4 = r0.f11147c
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.gk.g(r4, r9, r2, r15)
            goto L_0x008d
        L_0x01ec:
            r15 = 1
            int[] r4 = r0.f11147c
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.gk.l(r4, r9, r2, r15)
            goto L_0x008d
        L_0x01fc:
            r15 = 1
            int[] r4 = r0.f11147c
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.gk.m(r4, r9, r2, r15)
            goto L_0x008d
        L_0x020c:
            r15 = 1
            int[] r4 = r0.f11147c
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.gk.i(r4, r9, r2, r15)
            goto L_0x008d
        L_0x021c:
            r15 = 1
            int[] r4 = r0.f11147c
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.gk.n(r4, r9, r2, r15)
            goto L_0x008d
        L_0x022c:
            r15 = 1
            int[] r4 = r0.f11147c
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.gk.k(r4, r9, r2, r15)
            goto L_0x008d
        L_0x023c:
            r15 = 1
            int[] r4 = r0.f11147c
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.gk.f(r4, r9, r2, r15)
            goto L_0x008d
        L_0x024c:
            r15 = 1
            int[] r4 = r0.f11147c
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.gk.h(r4, r9, r2, r15)
            goto L_0x008d
        L_0x025c:
            r15 = 1
            int[] r4 = r0.f11147c
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.gk.d(r4, r9, r2, r15)
            goto L_0x008d
        L_0x026c:
            r15 = 1
            int[] r4 = r0.f11147c
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.gk.c(r4, r9, r2, r15)
            goto L_0x008d
        L_0x027c:
            r15 = 1
            int[] r4 = r0.f11147c
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.gk.b((int) r4, (java.util.List<java.lang.Float>) r9, (com.google.android.gms.internal.vision.hx) r2, (boolean) r15)
            goto L_0x008d
        L_0x028c:
            r15 = 1
            int[] r4 = r0.f11147c
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.gk.a((int) r4, (java.util.List<java.lang.Double>) r9, (com.google.android.gms.internal.vision.hx) r2, (boolean) r15)
            goto L_0x008d
        L_0x029c:
            int[] r4 = r0.f11147c
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            r15 = 0
            com.google.android.gms.internal.vision.gk.e(r4, r9, r2, r15)
            goto L_0x008d
        L_0x02ac:
            r15 = 0
            int[] r4 = r0.f11147c
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.gk.j(r4, r9, r2, r15)
            goto L_0x008d
        L_0x02bc:
            r15 = 0
            int[] r4 = r0.f11147c
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.gk.g(r4, r9, r2, r15)
            goto L_0x008d
        L_0x02cc:
            r15 = 0
            int[] r4 = r0.f11147c
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.gk.l(r4, r9, r2, r15)
            goto L_0x008d
        L_0x02dc:
            r15 = 0
            int[] r4 = r0.f11147c
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.gk.m(r4, r9, r2, r15)
            goto L_0x008d
        L_0x02ec:
            r15 = 0
            int[] r4 = r0.f11147c
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.gk.i(r4, r9, r2, r15)
            goto L_0x008d
        L_0x02fc:
            int[] r4 = r0.f11147c
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.gk.b((int) r4, (java.util.List<com.google.android.gms.internal.vision.cz>) r9, (com.google.android.gms.internal.vision.hx) r2)
            goto L_0x008d
        L_0x030b:
            int[] r4 = r0.f11147c
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.gi r13 = r0.a((int) r5)
            com.google.android.gms.internal.vision.gk.a((int) r4, (java.util.List<?>) r9, (com.google.android.gms.internal.vision.hx) r2, (com.google.android.gms.internal.vision.gi) r13)
            goto L_0x008d
        L_0x031e:
            int[] r4 = r0.f11147c
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.gk.a((int) r4, (java.util.List<java.lang.String>) r9, (com.google.android.gms.internal.vision.hx) r2)
            goto L_0x008d
        L_0x032d:
            int[] r4 = r0.f11147c
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            r15 = 0
            com.google.android.gms.internal.vision.gk.n(r4, r9, r2, r15)
            goto L_0x008d
        L_0x033d:
            r15 = 0
            int[] r4 = r0.f11147c
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.gk.k(r4, r9, r2, r15)
            goto L_0x008d
        L_0x034d:
            r15 = 0
            int[] r4 = r0.f11147c
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.gk.f(r4, r9, r2, r15)
            goto L_0x008d
        L_0x035d:
            r15 = 0
            int[] r4 = r0.f11147c
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.gk.h(r4, r9, r2, r15)
            goto L_0x008d
        L_0x036d:
            r15 = 0
            int[] r4 = r0.f11147c
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.gk.d(r4, r9, r2, r15)
            goto L_0x008d
        L_0x037d:
            r15 = 0
            int[] r4 = r0.f11147c
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.gk.c(r4, r9, r2, r15)
            goto L_0x008d
        L_0x038d:
            r15 = 0
            int[] r4 = r0.f11147c
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.gk.b((int) r4, (java.util.List<java.lang.Float>) r9, (com.google.android.gms.internal.vision.hx) r2, (boolean) r15)
            goto L_0x008d
        L_0x039d:
            r15 = 0
            int[] r4 = r0.f11147c
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.gk.a((int) r4, (java.util.List<java.lang.Double>) r9, (com.google.android.gms.internal.vision.hx) r2, (boolean) r15)
            goto L_0x008d
        L_0x03ad:
            r4 = 0
            r9 = r9 & r12
            if (r9 == 0) goto L_0x0497
            java.lang.Object r9 = r7.getObject(r1, r13)
            com.google.android.gms.internal.vision.gi r13 = r0.a((int) r5)
            r2.b((int) r15, (java.lang.Object) r9, (com.google.android.gms.internal.vision.gi) r13)
            goto L_0x0497
        L_0x03be:
            r4 = 0
            r9 = r9 & r12
            if (r9 == 0) goto L_0x0497
            long r13 = r7.getLong(r1, r13)
            r2.e((int) r15, (long) r13)
            goto L_0x0497
        L_0x03cb:
            r4 = 0
            r9 = r9 & r12
            if (r9 == 0) goto L_0x0497
            int r9 = r7.getInt(r1, r13)
            r2.f(r15, r9)
            goto L_0x0497
        L_0x03d8:
            r4 = 0
            r9 = r9 & r12
            if (r9 == 0) goto L_0x0497
            long r13 = r7.getLong(r1, r13)
            r2.b((int) r15, (long) r13)
            goto L_0x0497
        L_0x03e5:
            r4 = 0
            r9 = r9 & r12
            if (r9 == 0) goto L_0x0497
            int r9 = r7.getInt(r1, r13)
            r2.a((int) r15, (int) r9)
            goto L_0x0497
        L_0x03f2:
            r4 = 0
            r9 = r9 & r12
            if (r9 == 0) goto L_0x0497
            int r9 = r7.getInt(r1, r13)
            r2.b((int) r15, (int) r9)
            goto L_0x0497
        L_0x03ff:
            r4 = 0
            r9 = r9 & r12
            if (r9 == 0) goto L_0x0497
            int r9 = r7.getInt(r1, r13)
            r2.e((int) r15, (int) r9)
            goto L_0x0497
        L_0x040c:
            r4 = 0
            r9 = r9 & r12
            if (r9 == 0) goto L_0x0497
            java.lang.Object r9 = r7.getObject(r1, r13)
            com.google.android.gms.internal.vision.cz r9 = (com.google.android.gms.internal.vision.cz) r9
            r2.a((int) r15, (com.google.android.gms.internal.vision.cz) r9)
            goto L_0x0497
        L_0x041b:
            r4 = 0
            r9 = r9 & r12
            if (r9 == 0) goto L_0x0497
            java.lang.Object r9 = r7.getObject(r1, r13)
            com.google.android.gms.internal.vision.gi r13 = r0.a((int) r5)
            r2.a((int) r15, (java.lang.Object) r9, (com.google.android.gms.internal.vision.gi) r13)
            goto L_0x0497
        L_0x042c:
            r4 = 0
            r9 = r9 & r12
            if (r9 == 0) goto L_0x0497
            java.lang.Object r9 = r7.getObject(r1, r13)
            a((int) r15, (java.lang.Object) r9, (com.google.android.gms.internal.vision.hx) r2)
            goto L_0x0497
        L_0x0438:
            r4 = 0
            r9 = r9 & r12
            if (r9 == 0) goto L_0x0497
            boolean r9 = com.google.android.gms.internal.vision.hg.c(r1, r13)
            r2.a((int) r15, (boolean) r9)
            goto L_0x0497
        L_0x0444:
            r4 = 0
            r9 = r9 & r12
            if (r9 == 0) goto L_0x0497
            int r9 = r7.getInt(r1, r13)
            r2.d((int) r15, (int) r9)
            goto L_0x0497
        L_0x0450:
            r4 = 0
            r9 = r9 & r12
            if (r9 == 0) goto L_0x0497
            long r13 = r7.getLong(r1, r13)
            r2.d((int) r15, (long) r13)
            goto L_0x0497
        L_0x045c:
            r4 = 0
            r9 = r9 & r12
            if (r9 == 0) goto L_0x0497
            int r9 = r7.getInt(r1, r13)
            r2.c((int) r15, (int) r9)
            goto L_0x0497
        L_0x0468:
            r4 = 0
            r9 = r9 & r12
            if (r9 == 0) goto L_0x0497
            long r13 = r7.getLong(r1, r13)
            r2.c((int) r15, (long) r13)
            goto L_0x0497
        L_0x0474:
            r4 = 0
            r9 = r9 & r12
            if (r9 == 0) goto L_0x0497
            long r13 = r7.getLong(r1, r13)
            r2.a((int) r15, (long) r13)
            goto L_0x0497
        L_0x0480:
            r4 = 0
            r9 = r9 & r12
            if (r9 == 0) goto L_0x0497
            float r9 = com.google.android.gms.internal.vision.hg.d(r1, r13)
            r2.a((int) r15, (float) r9)
            goto L_0x0497
        L_0x048c:
            r4 = 0
            r9 = r9 & r12
            if (r9 == 0) goto L_0x0497
            double r13 = com.google.android.gms.internal.vision.hg.e(r1, r13)
            r2.a((int) r15, (double) r13)
        L_0x0497:
            int r5 = r5 + 3
            goto L_0x0030
        L_0x049b:
            r14 = r11
        L_0x049c:
            if (r14 == 0) goto L_0x04b3
            com.google.android.gms.internal.vision.dw<?> r4 = r0.r
            r4.a(r2, r14)
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x04b1
            java.lang.Object r4 = r3.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            r14 = r4
            goto L_0x049c
        L_0x04b1:
            r14 = 0
            goto L_0x049c
        L_0x04b3:
            com.google.android.gms.internal.vision.ha<?, ?> r3 = r0.q
            a(r3, r1, (com.google.android.gms.internal.vision.hx) r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.fx.b(java.lang.Object, com.google.android.gms.internal.vision.hx):void");
    }

    private final <K, V> void a(hx hxVar, int i2, Object obj) throws IOException {
        if (obj != null) {
            hxVar.a(i2, this.s.b(), this.s.b(obj));
        }
    }

    private static <UT, UB> void a(ha<UT, UB> haVar, T t, hx hxVar) throws IOException {
        haVar.a(haVar.b(t), hxVar);
    }

    /*  JADX ERROR: StackOverflow in pass: MarkFinallyVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    public final void a(T r13, com.google.android.gms.internal.vision.gj r14, com.google.android.gms.internal.vision.du r15) throws java.io.IOException {
        /*
            r12 = this;
            if (r15 == 0) goto L_0x05d2
            com.google.android.gms.internal.vision.ha<?, ?> r7 = r12.q
            com.google.android.gms.internal.vision.dw<?> r8 = r12.r
            r9 = 0
            r0 = r9
            r10 = r0
        L_0x0009:
            int r1 = r14.a()     // Catch:{ all -> 0x05ba }
            int r2 = r12.f(r1)     // Catch:{ all -> 0x05ba }
            if (r2 >= 0) goto L_0x0074
            r2 = 2147483647(0x7fffffff, float:NaN)
            if (r1 != r2) goto L_0x002f
            int r14 = r12.m
        L_0x001a:
            int r15 = r12.n
            if (r14 >= r15) goto L_0x0029
            int[] r15 = r12.l
            r15 = r15[r14]
            java.lang.Object r10 = r12.a(r13, r15, r10, r7)
            int r14 = r14 + 1
            goto L_0x001a
        L_0x0029:
            if (r10 == 0) goto L_0x002e
            r7.b((java.lang.Object) r13, r10)
        L_0x002e:
            return
        L_0x002f:
            boolean r2 = r12.f11152h     // Catch:{ all -> 0x05ba }
            if (r2 != 0) goto L_0x0035
            r2 = r9
            goto L_0x003c
        L_0x0035:
            com.google.android.gms.internal.vision.ft r2 = r12.f11151g     // Catch:{ all -> 0x05ba }
            java.lang.Object r1 = r8.a(r15, r2, r1)     // Catch:{ all -> 0x05ba }
            r2 = r1
        L_0x003c:
            if (r2 == 0) goto L_0x0051
            if (r0 != 0) goto L_0x0044
            com.google.android.gms.internal.vision.dz r0 = r8.b(r13)     // Catch:{ all -> 0x05ba }
        L_0x0044:
            r11 = r0
            r0 = r8
            r1 = r14
            r3 = r15
            r4 = r11
            r5 = r10
            r6 = r7
            java.lang.Object r10 = r0.a(r1, r2, r3, r4, r5, r6)     // Catch:{ all -> 0x05ba }
            r0 = r11
            goto L_0x0009
        L_0x0051:
            if (r10 != 0) goto L_0x0057
            java.lang.Object r10 = r7.c(r13)     // Catch:{ all -> 0x05ba }
        L_0x0057:
            boolean r1 = r7.a(r10, (com.google.android.gms.internal.vision.gj) r14)     // Catch:{ all -> 0x05ba }
            if (r1 != 0) goto L_0x0009
            int r14 = r12.m
        L_0x005f:
            int r15 = r12.n
            if (r14 >= r15) goto L_0x006e
            int[] r15 = r12.l
            r15 = r15[r14]
            java.lang.Object r10 = r12.a(r13, r15, r10, r7)
            int r14 = r14 + 1
            goto L_0x005f
        L_0x006e:
            if (r10 == 0) goto L_0x0073
            r7.b((java.lang.Object) r13, r10)
        L_0x0073:
            return
        L_0x0074:
            int r3 = r12.c((int) r2)     // Catch:{ all -> 0x05ba }
            r4 = 267386880(0xff00000, float:2.3665827E-29)
            r4 = r4 & r3
            int r4 = r4 >>> 20
            r5 = 1048575(0xfffff, float:1.469367E-39)
            switch(r4) {
                case 0: goto L_0x056a;
                case 1: goto L_0x055b;
                case 2: goto L_0x054c;
                case 3: goto L_0x053d;
                case 4: goto L_0x052e;
                case 5: goto L_0x051f;
                case 6: goto L_0x0510;
                case 7: goto L_0x0501;
                case 8: goto L_0x04f9;
                case 9: goto L_0x04c8;
                case 10: goto L_0x04b9;
                case 11: goto L_0x04aa;
                case 12: goto L_0x0488;
                case 13: goto L_0x0479;
                case 14: goto L_0x046a;
                case 15: goto L_0x045b;
                case 16: goto L_0x044c;
                case 17: goto L_0x041b;
                case 18: goto L_0x040d;
                case 19: goto L_0x03ff;
                case 20: goto L_0x03f1;
                case 21: goto L_0x03e3;
                case 22: goto L_0x03d5;
                case 23: goto L_0x03c7;
                case 24: goto L_0x03b9;
                case 25: goto L_0x03ab;
                case 26: goto L_0x0389;
                case 27: goto L_0x0377;
                case 28: goto L_0x0369;
                case 29: goto L_0x035b;
                case 30: goto L_0x0346;
                case 31: goto L_0x0338;
                case 32: goto L_0x032a;
                case 33: goto L_0x031c;
                case 34: goto L_0x030e;
                case 35: goto L_0x0300;
                case 36: goto L_0x02f2;
                case 37: goto L_0x02e4;
                case 38: goto L_0x02d6;
                case 39: goto L_0x02c8;
                case 40: goto L_0x02ba;
                case 41: goto L_0x02ac;
                case 42: goto L_0x029e;
                case 43: goto L_0x0290;
                case 44: goto L_0x027b;
                case 45: goto L_0x026d;
                case 46: goto L_0x025f;
                case 47: goto L_0x0251;
                case 48: goto L_0x0243;
                case 49: goto L_0x0231;
                case 50: goto L_0x01f3;
                case 51: goto L_0x01e1;
                case 52: goto L_0x01cf;
                case 53: goto L_0x01bd;
                case 54: goto L_0x01ab;
                case 55: goto L_0x0199;
                case 56: goto L_0x0187;
                case 57: goto L_0x0175;
                case 58: goto L_0x0163;
                case 59: goto L_0x015b;
                case 60: goto L_0x012a;
                case 61: goto L_0x011c;
                case 62: goto L_0x010a;
                case 63: goto L_0x00e5;
                case 64: goto L_0x00d3;
                case 65: goto L_0x00c1;
                case 66: goto L_0x00af;
                case 67: goto L_0x009d;
                case 68: goto L_0x008b;
                default: goto L_0x0083;
            }
        L_0x0083:
            if (r10 != 0) goto L_0x0579
            java.lang.Object r10 = r7.a()     // Catch:{ et -> 0x0596 }
            goto L_0x0579
        L_0x008b:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ et -> 0x0596 }
            com.google.android.gms.internal.vision.gi r5 = r12.a((int) r2)     // Catch:{ et -> 0x0596 }
            java.lang.Object r5 = r14.b(r5, (com.google.android.gms.internal.vision.du) r15)     // Catch:{ et -> 0x0596 }
            com.google.android.gms.internal.vision.hg.a((java.lang.Object) r13, (long) r3, (java.lang.Object) r5)     // Catch:{ et -> 0x0596 }
            r12.b(r13, (int) r1, (int) r2)     // Catch:{ et -> 0x0596 }
            goto L_0x0009
        L_0x009d:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ et -> 0x0596 }
            long r5 = r14.t()     // Catch:{ et -> 0x0596 }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ et -> 0x0596 }
            com.google.android.gms.internal.vision.hg.a((java.lang.Object) r13, (long) r3, (java.lang.Object) r5)     // Catch:{ et -> 0x0596 }
            r12.b(r13, (int) r1, (int) r2)     // Catch:{ et -> 0x0596 }
            goto L_0x0009
        L_0x00af:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ et -> 0x0596 }
            int r5 = r14.s()     // Catch:{ et -> 0x0596 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ et -> 0x0596 }
            com.google.android.gms.internal.vision.hg.a((java.lang.Object) r13, (long) r3, (java.lang.Object) r5)     // Catch:{ et -> 0x0596 }
            r12.b(r13, (int) r1, (int) r2)     // Catch:{ et -> 0x0596 }
            goto L_0x0009
        L_0x00c1:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ et -> 0x0596 }
            long r5 = r14.r()     // Catch:{ et -> 0x0596 }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ et -> 0x0596 }
            com.google.android.gms.internal.vision.hg.a((java.lang.Object) r13, (long) r3, (java.lang.Object) r5)     // Catch:{ et -> 0x0596 }
            r12.b(r13, (int) r1, (int) r2)     // Catch:{ et -> 0x0596 }
            goto L_0x0009
        L_0x00d3:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ et -> 0x0596 }
            int r5 = r14.q()     // Catch:{ et -> 0x0596 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ et -> 0x0596 }
            com.google.android.gms.internal.vision.hg.a((java.lang.Object) r13, (long) r3, (java.lang.Object) r5)     // Catch:{ et -> 0x0596 }
            r12.b(r13, (int) r1, (int) r2)     // Catch:{ et -> 0x0596 }
            goto L_0x0009
        L_0x00e5:
            int r4 = r14.p()     // Catch:{ et -> 0x0596 }
            com.google.android.gms.internal.vision.ep r6 = r12.b((int) r2)     // Catch:{ et -> 0x0596 }
            if (r6 == 0) goto L_0x00fc
            boolean r6 = r6.a(r4)     // Catch:{ et -> 0x0596 }
            if (r6 == 0) goto L_0x00f6
            goto L_0x00fc
        L_0x00f6:
            java.lang.Object r10 = com.google.android.gms.internal.vision.gk.a((int) r1, (int) r4, r10, r7)     // Catch:{ et -> 0x0596 }
            goto L_0x0009
        L_0x00fc:
            r3 = r3 & r5
            long r5 = (long) r3     // Catch:{ et -> 0x0596 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r4)     // Catch:{ et -> 0x0596 }
            com.google.android.gms.internal.vision.hg.a((java.lang.Object) r13, (long) r5, (java.lang.Object) r3)     // Catch:{ et -> 0x0596 }
            r12.b(r13, (int) r1, (int) r2)     // Catch:{ et -> 0x0596 }
            goto L_0x0009
        L_0x010a:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ et -> 0x0596 }
            int r5 = r14.o()     // Catch:{ et -> 0x0596 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ et -> 0x0596 }
            com.google.android.gms.internal.vision.hg.a((java.lang.Object) r13, (long) r3, (java.lang.Object) r5)     // Catch:{ et -> 0x0596 }
            r12.b(r13, (int) r1, (int) r2)     // Catch:{ et -> 0x0596 }
            goto L_0x0009
        L_0x011c:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ et -> 0x0596 }
            com.google.android.gms.internal.vision.cz r5 = r14.n()     // Catch:{ et -> 0x0596 }
            com.google.android.gms.internal.vision.hg.a((java.lang.Object) r13, (long) r3, (java.lang.Object) r5)     // Catch:{ et -> 0x0596 }
            r12.b(r13, (int) r1, (int) r2)     // Catch:{ et -> 0x0596 }
            goto L_0x0009
        L_0x012a:
            boolean r4 = r12.a(r13, (int) r1, (int) r2)     // Catch:{ et -> 0x0596 }
            if (r4 == 0) goto L_0x0146
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ et -> 0x0596 }
            java.lang.Object r5 = com.google.android.gms.internal.vision.hg.f(r13, r3)     // Catch:{ et -> 0x0596 }
            com.google.android.gms.internal.vision.gi r6 = r12.a((int) r2)     // Catch:{ et -> 0x0596 }
            java.lang.Object r6 = r14.a(r6, (com.google.android.gms.internal.vision.du) r15)     // Catch:{ et -> 0x0596 }
            java.lang.Object r5 = com.google.android.gms.internal.vision.ek.a((java.lang.Object) r5, (java.lang.Object) r6)     // Catch:{ et -> 0x0596 }
            com.google.android.gms.internal.vision.hg.a((java.lang.Object) r13, (long) r3, (java.lang.Object) r5)     // Catch:{ et -> 0x0596 }
            goto L_0x0156
        L_0x0146:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ et -> 0x0596 }
            com.google.android.gms.internal.vision.gi r5 = r12.a((int) r2)     // Catch:{ et -> 0x0596 }
            java.lang.Object r5 = r14.a(r5, (com.google.android.gms.internal.vision.du) r15)     // Catch:{ et -> 0x0596 }
            com.google.android.gms.internal.vision.hg.a((java.lang.Object) r13, (long) r3, (java.lang.Object) r5)     // Catch:{ et -> 0x0596 }
            r12.b(r13, (int) r2)     // Catch:{ et -> 0x0596 }
        L_0x0156:
            r12.b(r13, (int) r1, (int) r2)     // Catch:{ et -> 0x0596 }
            goto L_0x0009
        L_0x015b:
            r12.a((java.lang.Object) r13, (int) r3, (com.google.android.gms.internal.vision.gj) r14)     // Catch:{ et -> 0x0596 }
            r12.b(r13, (int) r1, (int) r2)     // Catch:{ et -> 0x0596 }
            goto L_0x0009
        L_0x0163:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ et -> 0x0596 }
            boolean r5 = r14.k()     // Catch:{ et -> 0x0596 }
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)     // Catch:{ et -> 0x0596 }
            com.google.android.gms.internal.vision.hg.a((java.lang.Object) r13, (long) r3, (java.lang.Object) r5)     // Catch:{ et -> 0x0596 }
            r12.b(r13, (int) r1, (int) r2)     // Catch:{ et -> 0x0596 }
            goto L_0x0009
        L_0x0175:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ et -> 0x0596 }
            int r5 = r14.j()     // Catch:{ et -> 0x0596 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ et -> 0x0596 }
            com.google.android.gms.internal.vision.hg.a((java.lang.Object) r13, (long) r3, (java.lang.Object) r5)     // Catch:{ et -> 0x0596 }
            r12.b(r13, (int) r1, (int) r2)     // Catch:{ et -> 0x0596 }
            goto L_0x0009
        L_0x0187:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ et -> 0x0596 }
            long r5 = r14.i()     // Catch:{ et -> 0x0596 }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ et -> 0x0596 }
            com.google.android.gms.internal.vision.hg.a((java.lang.Object) r13, (long) r3, (java.lang.Object) r5)     // Catch:{ et -> 0x0596 }
            r12.b(r13, (int) r1, (int) r2)     // Catch:{ et -> 0x0596 }
            goto L_0x0009
        L_0x0199:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ et -> 0x0596 }
            int r5 = r14.h()     // Catch:{ et -> 0x0596 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ et -> 0x0596 }
            com.google.android.gms.internal.vision.hg.a((java.lang.Object) r13, (long) r3, (java.lang.Object) r5)     // Catch:{ et -> 0x0596 }
            r12.b(r13, (int) r1, (int) r2)     // Catch:{ et -> 0x0596 }
            goto L_0x0009
        L_0x01ab:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ et -> 0x0596 }
            long r5 = r14.f()     // Catch:{ et -> 0x0596 }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ et -> 0x0596 }
            com.google.android.gms.internal.vision.hg.a((java.lang.Object) r13, (long) r3, (java.lang.Object) r5)     // Catch:{ et -> 0x0596 }
            r12.b(r13, (int) r1, (int) r2)     // Catch:{ et -> 0x0596 }
            goto L_0x0009
        L_0x01bd:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ et -> 0x0596 }
            long r5 = r14.g()     // Catch:{ et -> 0x0596 }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ et -> 0x0596 }
            com.google.android.gms.internal.vision.hg.a((java.lang.Object) r13, (long) r3, (java.lang.Object) r5)     // Catch:{ et -> 0x0596 }
            r12.b(r13, (int) r1, (int) r2)     // Catch:{ et -> 0x0596 }
            goto L_0x0009
        L_0x01cf:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ et -> 0x0596 }
            float r5 = r14.e()     // Catch:{ et -> 0x0596 }
            java.lang.Float r5 = java.lang.Float.valueOf(r5)     // Catch:{ et -> 0x0596 }
            com.google.android.gms.internal.vision.hg.a((java.lang.Object) r13, (long) r3, (java.lang.Object) r5)     // Catch:{ et -> 0x0596 }
            r12.b(r13, (int) r1, (int) r2)     // Catch:{ et -> 0x0596 }
            goto L_0x0009
        L_0x01e1:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ et -> 0x0596 }
            double r5 = r14.d()     // Catch:{ et -> 0x0596 }
            java.lang.Double r5 = java.lang.Double.valueOf(r5)     // Catch:{ et -> 0x0596 }
            com.google.android.gms.internal.vision.hg.a((java.lang.Object) r13, (long) r3, (java.lang.Object) r5)     // Catch:{ et -> 0x0596 }
            r12.b(r13, (int) r1, (int) r2)     // Catch:{ et -> 0x0596 }
            goto L_0x0009
        L_0x01f3:
            int r1 = r12.c((int) r2)     // Catch:{ et -> 0x0596 }
            r1 = r1 & r5
            long r1 = (long) r1     // Catch:{ et -> 0x0596 }
            java.lang.Object r3 = com.google.android.gms.internal.vision.hg.f(r13, r1)     // Catch:{ et -> 0x0596 }
            if (r3 != 0) goto L_0x0209
            com.google.android.gms.internal.vision.fl r3 = r12.s     // Catch:{ et -> 0x0596 }
            java.lang.Object r3 = r3.a()     // Catch:{ et -> 0x0596 }
            com.google.android.gms.internal.vision.hg.a((java.lang.Object) r13, (long) r1, (java.lang.Object) r3)     // Catch:{ et -> 0x0596 }
            goto L_0x0220
        L_0x0209:
            com.google.android.gms.internal.vision.fl r4 = r12.s     // Catch:{ et -> 0x0596 }
            boolean r4 = r4.c(r3)     // Catch:{ et -> 0x0596 }
            if (r4 == 0) goto L_0x0220
            com.google.android.gms.internal.vision.fl r4 = r12.s     // Catch:{ et -> 0x0596 }
            java.lang.Object r4 = r4.a()     // Catch:{ et -> 0x0596 }
            com.google.android.gms.internal.vision.fl r5 = r12.s     // Catch:{ et -> 0x0596 }
            r5.a(r4, r3)     // Catch:{ et -> 0x0596 }
            com.google.android.gms.internal.vision.hg.a((java.lang.Object) r13, (long) r1, (java.lang.Object) r4)     // Catch:{ et -> 0x0596 }
            r3 = r4
        L_0x0220:
            com.google.android.gms.internal.vision.fl r1 = r12.s     // Catch:{ et -> 0x0596 }
            java.util.Map r1 = r1.a(r3)     // Catch:{ et -> 0x0596 }
            com.google.android.gms.internal.vision.fl r2 = r12.s     // Catch:{ et -> 0x0596 }
            com.google.android.gms.internal.vision.fj r2 = r2.b()     // Catch:{ et -> 0x0596 }
            r14.a(r1, r2, (com.google.android.gms.internal.vision.du) r15)     // Catch:{ et -> 0x0596 }
            goto L_0x0009
        L_0x0231:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ et -> 0x0596 }
            com.google.android.gms.internal.vision.gi r1 = r12.a((int) r2)     // Catch:{ et -> 0x0596 }
            com.google.android.gms.internal.vision.fc r2 = r12.p     // Catch:{ et -> 0x0596 }
            java.util.List r2 = r2.a(r13, r3)     // Catch:{ et -> 0x0596 }
            r14.b(r2, r1, r15)     // Catch:{ et -> 0x0596 }
            goto L_0x0009
        L_0x0243:
            com.google.android.gms.internal.vision.fc r1 = r12.p     // Catch:{ et -> 0x0596 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ et -> 0x0596 }
            java.util.List r1 = r1.a(r13, r2)     // Catch:{ et -> 0x0596 }
            r14.q(r1)     // Catch:{ et -> 0x0596 }
            goto L_0x0009
        L_0x0251:
            com.google.android.gms.internal.vision.fc r1 = r12.p     // Catch:{ et -> 0x0596 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ et -> 0x0596 }
            java.util.List r1 = r1.a(r13, r2)     // Catch:{ et -> 0x0596 }
            r14.p(r1)     // Catch:{ et -> 0x0596 }
            goto L_0x0009
        L_0x025f:
            com.google.android.gms.internal.vision.fc r1 = r12.p     // Catch:{ et -> 0x0596 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ et -> 0x0596 }
            java.util.List r1 = r1.a(r13, r2)     // Catch:{ et -> 0x0596 }
            r14.o(r1)     // Catch:{ et -> 0x0596 }
            goto L_0x0009
        L_0x026d:
            com.google.android.gms.internal.vision.fc r1 = r12.p     // Catch:{ et -> 0x0596 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ et -> 0x0596 }
            java.util.List r1 = r1.a(r13, r2)     // Catch:{ et -> 0x0596 }
            r14.n(r1)     // Catch:{ et -> 0x0596 }
            goto L_0x0009
        L_0x027b:
            com.google.android.gms.internal.vision.fc r4 = r12.p     // Catch:{ et -> 0x0596 }
            r3 = r3 & r5
            long r5 = (long) r3     // Catch:{ et -> 0x0596 }
            java.util.List r3 = r4.a(r13, r5)     // Catch:{ et -> 0x0596 }
            r14.m(r3)     // Catch:{ et -> 0x0596 }
            com.google.android.gms.internal.vision.ep r2 = r12.b((int) r2)     // Catch:{ et -> 0x0596 }
            java.lang.Object r10 = com.google.android.gms.internal.vision.gk.a((int) r1, (java.util.List<java.lang.Integer>) r3, (com.google.android.gms.internal.vision.ep) r2, r10, r7)     // Catch:{ et -> 0x0596 }
            goto L_0x0009
        L_0x0290:
            com.google.android.gms.internal.vision.fc r1 = r12.p     // Catch:{ et -> 0x0596 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ et -> 0x0596 }
            java.util.List r1 = r1.a(r13, r2)     // Catch:{ et -> 0x0596 }
            r14.l(r1)     // Catch:{ et -> 0x0596 }
            goto L_0x0009
        L_0x029e:
            com.google.android.gms.internal.vision.fc r1 = r12.p     // Catch:{ et -> 0x0596 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ et -> 0x0596 }
            java.util.List r1 = r1.a(r13, r2)     // Catch:{ et -> 0x0596 }
            r14.h(r1)     // Catch:{ et -> 0x0596 }
            goto L_0x0009
        L_0x02ac:
            com.google.android.gms.internal.vision.fc r1 = r12.p     // Catch:{ et -> 0x0596 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ et -> 0x0596 }
            java.util.List r1 = r1.a(r13, r2)     // Catch:{ et -> 0x0596 }
            r14.g(r1)     // Catch:{ et -> 0x0596 }
            goto L_0x0009
        L_0x02ba:
            com.google.android.gms.internal.vision.fc r1 = r12.p     // Catch:{ et -> 0x0596 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ et -> 0x0596 }
            java.util.List r1 = r1.a(r13, r2)     // Catch:{ et -> 0x0596 }
            r14.f(r1)     // Catch:{ et -> 0x0596 }
            goto L_0x0009
        L_0x02c8:
            com.google.android.gms.internal.vision.fc r1 = r12.p     // Catch:{ et -> 0x0596 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ et -> 0x0596 }
            java.util.List r1 = r1.a(r13, r2)     // Catch:{ et -> 0x0596 }
            r14.e(r1)     // Catch:{ et -> 0x0596 }
            goto L_0x0009
        L_0x02d6:
            com.google.android.gms.internal.vision.fc r1 = r12.p     // Catch:{ et -> 0x0596 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ et -> 0x0596 }
            java.util.List r1 = r1.a(r13, r2)     // Catch:{ et -> 0x0596 }
            r14.c(r1)     // Catch:{ et -> 0x0596 }
            goto L_0x0009
        L_0x02e4:
            com.google.android.gms.internal.vision.fc r1 = r12.p     // Catch:{ et -> 0x0596 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ et -> 0x0596 }
            java.util.List r1 = r1.a(r13, r2)     // Catch:{ et -> 0x0596 }
            r14.d(r1)     // Catch:{ et -> 0x0596 }
            goto L_0x0009
        L_0x02f2:
            com.google.android.gms.internal.vision.fc r1 = r12.p     // Catch:{ et -> 0x0596 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ et -> 0x0596 }
            java.util.List r1 = r1.a(r13, r2)     // Catch:{ et -> 0x0596 }
            r14.b(r1)     // Catch:{ et -> 0x0596 }
            goto L_0x0009
        L_0x0300:
            com.google.android.gms.internal.vision.fc r1 = r12.p     // Catch:{ et -> 0x0596 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ et -> 0x0596 }
            java.util.List r1 = r1.a(r13, r2)     // Catch:{ et -> 0x0596 }
            r14.a(r1)     // Catch:{ et -> 0x0596 }
            goto L_0x0009
        L_0x030e:
            com.google.android.gms.internal.vision.fc r1 = r12.p     // Catch:{ et -> 0x0596 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ et -> 0x0596 }
            java.util.List r1 = r1.a(r13, r2)     // Catch:{ et -> 0x0596 }
            r14.q(r1)     // Catch:{ et -> 0x0596 }
            goto L_0x0009
        L_0x031c:
            com.google.android.gms.internal.vision.fc r1 = r12.p     // Catch:{ et -> 0x0596 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ et -> 0x0596 }
            java.util.List r1 = r1.a(r13, r2)     // Catch:{ et -> 0x0596 }
            r14.p(r1)     // Catch:{ et -> 0x0596 }
            goto L_0x0009
        L_0x032a:
            com.google.android.gms.internal.vision.fc r1 = r12.p     // Catch:{ et -> 0x0596 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ et -> 0x0596 }
            java.util.List r1 = r1.a(r13, r2)     // Catch:{ et -> 0x0596 }
            r14.o(r1)     // Catch:{ et -> 0x0596 }
            goto L_0x0009
        L_0x0338:
            com.google.android.gms.internal.vision.fc r1 = r12.p     // Catch:{ et -> 0x0596 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ et -> 0x0596 }
            java.util.List r1 = r1.a(r13, r2)     // Catch:{ et -> 0x0596 }
            r14.n(r1)     // Catch:{ et -> 0x0596 }
            goto L_0x0009
        L_0x0346:
            com.google.android.gms.internal.vision.fc r4 = r12.p     // Catch:{ et -> 0x0596 }
            r3 = r3 & r5
            long r5 = (long) r3     // Catch:{ et -> 0x0596 }
            java.util.List r3 = r4.a(r13, r5)     // Catch:{ et -> 0x0596 }
            r14.m(r3)     // Catch:{ et -> 0x0596 }
            com.google.android.gms.internal.vision.ep r2 = r12.b((int) r2)     // Catch:{ et -> 0x0596 }
            java.lang.Object r10 = com.google.android.gms.internal.vision.gk.a((int) r1, (java.util.List<java.lang.Integer>) r3, (com.google.android.gms.internal.vision.ep) r2, r10, r7)     // Catch:{ et -> 0x0596 }
            goto L_0x0009
        L_0x035b:
            com.google.android.gms.internal.vision.fc r1 = r12.p     // Catch:{ et -> 0x0596 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ et -> 0x0596 }
            java.util.List r1 = r1.a(r13, r2)     // Catch:{ et -> 0x0596 }
            r14.l(r1)     // Catch:{ et -> 0x0596 }
            goto L_0x0009
        L_0x0369:
            com.google.android.gms.internal.vision.fc r1 = r12.p     // Catch:{ et -> 0x0596 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ et -> 0x0596 }
            java.util.List r1 = r1.a(r13, r2)     // Catch:{ et -> 0x0596 }
            r14.k(r1)     // Catch:{ et -> 0x0596 }
            goto L_0x0009
        L_0x0377:
            com.google.android.gms.internal.vision.gi r1 = r12.a((int) r2)     // Catch:{ et -> 0x0596 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ et -> 0x0596 }
            com.google.android.gms.internal.vision.fc r4 = r12.p     // Catch:{ et -> 0x0596 }
            java.util.List r2 = r4.a(r13, r2)     // Catch:{ et -> 0x0596 }
            r14.a(r2, r1, (com.google.android.gms.internal.vision.du) r15)     // Catch:{ et -> 0x0596 }
            goto L_0x0009
        L_0x0389:
            boolean r1 = e((int) r3)     // Catch:{ et -> 0x0596 }
            if (r1 == 0) goto L_0x039d
            com.google.android.gms.internal.vision.fc r1 = r12.p     // Catch:{ et -> 0x0596 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ et -> 0x0596 }
            java.util.List r1 = r1.a(r13, r2)     // Catch:{ et -> 0x0596 }
            r14.j(r1)     // Catch:{ et -> 0x0596 }
            goto L_0x0009
        L_0x039d:
            com.google.android.gms.internal.vision.fc r1 = r12.p     // Catch:{ et -> 0x0596 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ et -> 0x0596 }
            java.util.List r1 = r1.a(r13, r2)     // Catch:{ et -> 0x0596 }
            r14.i(r1)     // Catch:{ et -> 0x0596 }
            goto L_0x0009
        L_0x03ab:
            com.google.android.gms.internal.vision.fc r1 = r12.p     // Catch:{ et -> 0x0596 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ et -> 0x0596 }
            java.util.List r1 = r1.a(r13, r2)     // Catch:{ et -> 0x0596 }
            r14.h(r1)     // Catch:{ et -> 0x0596 }
            goto L_0x0009
        L_0x03b9:
            com.google.android.gms.internal.vision.fc r1 = r12.p     // Catch:{ et -> 0x0596 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ et -> 0x0596 }
            java.util.List r1 = r1.a(r13, r2)     // Catch:{ et -> 0x0596 }
            r14.g(r1)     // Catch:{ et -> 0x0596 }
            goto L_0x0009
        L_0x03c7:
            com.google.android.gms.internal.vision.fc r1 = r12.p     // Catch:{ et -> 0x0596 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ et -> 0x0596 }
            java.util.List r1 = r1.a(r13, r2)     // Catch:{ et -> 0x0596 }
            r14.f(r1)     // Catch:{ et -> 0x0596 }
            goto L_0x0009
        L_0x03d5:
            com.google.android.gms.internal.vision.fc r1 = r12.p     // Catch:{ et -> 0x0596 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ et -> 0x0596 }
            java.util.List r1 = r1.a(r13, r2)     // Catch:{ et -> 0x0596 }
            r14.e(r1)     // Catch:{ et -> 0x0596 }
            goto L_0x0009
        L_0x03e3:
            com.google.android.gms.internal.vision.fc r1 = r12.p     // Catch:{ et -> 0x0596 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ et -> 0x0596 }
            java.util.List r1 = r1.a(r13, r2)     // Catch:{ et -> 0x0596 }
            r14.c(r1)     // Catch:{ et -> 0x0596 }
            goto L_0x0009
        L_0x03f1:
            com.google.android.gms.internal.vision.fc r1 = r12.p     // Catch:{ et -> 0x0596 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ et -> 0x0596 }
            java.util.List r1 = r1.a(r13, r2)     // Catch:{ et -> 0x0596 }
            r14.d(r1)     // Catch:{ et -> 0x0596 }
            goto L_0x0009
        L_0x03ff:
            com.google.android.gms.internal.vision.fc r1 = r12.p     // Catch:{ et -> 0x0596 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ et -> 0x0596 }
            java.util.List r1 = r1.a(r13, r2)     // Catch:{ et -> 0x0596 }
            r14.b(r1)     // Catch:{ et -> 0x0596 }
            goto L_0x0009
        L_0x040d:
            com.google.android.gms.internal.vision.fc r1 = r12.p     // Catch:{ et -> 0x0596 }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ et -> 0x0596 }
            java.util.List r1 = r1.a(r13, r2)     // Catch:{ et -> 0x0596 }
            r14.a(r1)     // Catch:{ et -> 0x0596 }
            goto L_0x0009
        L_0x041b:
            boolean r1 = r12.a(r13, (int) r2)     // Catch:{ et -> 0x0596 }
            if (r1 == 0) goto L_0x0439
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ et -> 0x0596 }
            java.lang.Object r1 = com.google.android.gms.internal.vision.hg.f(r13, r3)     // Catch:{ et -> 0x0596 }
            com.google.android.gms.internal.vision.gi r2 = r12.a((int) r2)     // Catch:{ et -> 0x0596 }
            java.lang.Object r2 = r14.b(r2, (com.google.android.gms.internal.vision.du) r15)     // Catch:{ et -> 0x0596 }
            java.lang.Object r1 = com.google.android.gms.internal.vision.ek.a((java.lang.Object) r1, (java.lang.Object) r2)     // Catch:{ et -> 0x0596 }
            com.google.android.gms.internal.vision.hg.a((java.lang.Object) r13, (long) r3, (java.lang.Object) r1)     // Catch:{ et -> 0x0596 }
            goto L_0x0009
        L_0x0439:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ et -> 0x0596 }
            com.google.android.gms.internal.vision.gi r1 = r12.a((int) r2)     // Catch:{ et -> 0x0596 }
            java.lang.Object r1 = r14.b(r1, (com.google.android.gms.internal.vision.du) r15)     // Catch:{ et -> 0x0596 }
            com.google.android.gms.internal.vision.hg.a((java.lang.Object) r13, (long) r3, (java.lang.Object) r1)     // Catch:{ et -> 0x0596 }
            r12.b(r13, (int) r2)     // Catch:{ et -> 0x0596 }
            goto L_0x0009
        L_0x044c:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ et -> 0x0596 }
            long r5 = r14.t()     // Catch:{ et -> 0x0596 }
            com.google.android.gms.internal.vision.hg.a((java.lang.Object) r13, (long) r3, (long) r5)     // Catch:{ et -> 0x0596 }
            r12.b(r13, (int) r2)     // Catch:{ et -> 0x0596 }
            goto L_0x0009
        L_0x045b:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ et -> 0x0596 }
            int r1 = r14.s()     // Catch:{ et -> 0x0596 }
            com.google.android.gms.internal.vision.hg.a((java.lang.Object) r13, (long) r3, (int) r1)     // Catch:{ et -> 0x0596 }
            r12.b(r13, (int) r2)     // Catch:{ et -> 0x0596 }
            goto L_0x0009
        L_0x046a:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ et -> 0x0596 }
            long r5 = r14.r()     // Catch:{ et -> 0x0596 }
            com.google.android.gms.internal.vision.hg.a((java.lang.Object) r13, (long) r3, (long) r5)     // Catch:{ et -> 0x0596 }
            r12.b(r13, (int) r2)     // Catch:{ et -> 0x0596 }
            goto L_0x0009
        L_0x0479:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ et -> 0x0596 }
            int r1 = r14.q()     // Catch:{ et -> 0x0596 }
            com.google.android.gms.internal.vision.hg.a((java.lang.Object) r13, (long) r3, (int) r1)     // Catch:{ et -> 0x0596 }
            r12.b(r13, (int) r2)     // Catch:{ et -> 0x0596 }
            goto L_0x0009
        L_0x0488:
            int r4 = r14.p()     // Catch:{ et -> 0x0596 }
            com.google.android.gms.internal.vision.ep r6 = r12.b((int) r2)     // Catch:{ et -> 0x0596 }
            if (r6 == 0) goto L_0x049f
            boolean r6 = r6.a(r4)     // Catch:{ et -> 0x0596 }
            if (r6 == 0) goto L_0x0499
            goto L_0x049f
        L_0x0499:
            java.lang.Object r10 = com.google.android.gms.internal.vision.gk.a((int) r1, (int) r4, r10, r7)     // Catch:{ et -> 0x0596 }
            goto L_0x0009
        L_0x049f:
            r1 = r3 & r5
            long r5 = (long) r1     // Catch:{ et -> 0x0596 }
            com.google.android.gms.internal.vision.hg.a((java.lang.Object) r13, (long) r5, (int) r4)     // Catch:{ et -> 0x0596 }
            r12.b(r13, (int) r2)     // Catch:{ et -> 0x0596 }
            goto L_0x0009
        L_0x04aa:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ et -> 0x0596 }
            int r1 = r14.o()     // Catch:{ et -> 0x0596 }
            com.google.android.gms.internal.vision.hg.a((java.lang.Object) r13, (long) r3, (int) r1)     // Catch:{ et -> 0x0596 }
            r12.b(r13, (int) r2)     // Catch:{ et -> 0x0596 }
            goto L_0x0009
        L_0x04b9:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ et -> 0x0596 }
            com.google.android.gms.internal.vision.cz r1 = r14.n()     // Catch:{ et -> 0x0596 }
            com.google.android.gms.internal.vision.hg.a((java.lang.Object) r13, (long) r3, (java.lang.Object) r1)     // Catch:{ et -> 0x0596 }
            r12.b(r13, (int) r2)     // Catch:{ et -> 0x0596 }
            goto L_0x0009
        L_0x04c8:
            boolean r1 = r12.a(r13, (int) r2)     // Catch:{ et -> 0x0596 }
            if (r1 == 0) goto L_0x04e6
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ et -> 0x0596 }
            java.lang.Object r1 = com.google.android.gms.internal.vision.hg.f(r13, r3)     // Catch:{ et -> 0x0596 }
            com.google.android.gms.internal.vision.gi r2 = r12.a((int) r2)     // Catch:{ et -> 0x0596 }
            java.lang.Object r2 = r14.a(r2, (com.google.android.gms.internal.vision.du) r15)     // Catch:{ et -> 0x0596 }
            java.lang.Object r1 = com.google.android.gms.internal.vision.ek.a((java.lang.Object) r1, (java.lang.Object) r2)     // Catch:{ et -> 0x0596 }
            com.google.android.gms.internal.vision.hg.a((java.lang.Object) r13, (long) r3, (java.lang.Object) r1)     // Catch:{ et -> 0x0596 }
            goto L_0x0009
        L_0x04e6:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ et -> 0x0596 }
            com.google.android.gms.internal.vision.gi r1 = r12.a((int) r2)     // Catch:{ et -> 0x0596 }
            java.lang.Object r1 = r14.a(r1, (com.google.android.gms.internal.vision.du) r15)     // Catch:{ et -> 0x0596 }
            com.google.android.gms.internal.vision.hg.a((java.lang.Object) r13, (long) r3, (java.lang.Object) r1)     // Catch:{ et -> 0x0596 }
            r12.b(r13, (int) r2)     // Catch:{ et -> 0x0596 }
            goto L_0x0009
        L_0x04f9:
            r12.a((java.lang.Object) r13, (int) r3, (com.google.android.gms.internal.vision.gj) r14)     // Catch:{ et -> 0x0596 }
            r12.b(r13, (int) r2)     // Catch:{ et -> 0x0596 }
            goto L_0x0009
        L_0x0501:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ et -> 0x0596 }
            boolean r1 = r14.k()     // Catch:{ et -> 0x0596 }
            com.google.android.gms.internal.vision.hg.a((java.lang.Object) r13, (long) r3, (boolean) r1)     // Catch:{ et -> 0x0596 }
            r12.b(r13, (int) r2)     // Catch:{ et -> 0x0596 }
            goto L_0x0009
        L_0x0510:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ et -> 0x0596 }
            int r1 = r14.j()     // Catch:{ et -> 0x0596 }
            com.google.android.gms.internal.vision.hg.a((java.lang.Object) r13, (long) r3, (int) r1)     // Catch:{ et -> 0x0596 }
            r12.b(r13, (int) r2)     // Catch:{ et -> 0x0596 }
            goto L_0x0009
        L_0x051f:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ et -> 0x0596 }
            long r5 = r14.i()     // Catch:{ et -> 0x0596 }
            com.google.android.gms.internal.vision.hg.a((java.lang.Object) r13, (long) r3, (long) r5)     // Catch:{ et -> 0x0596 }
            r12.b(r13, (int) r2)     // Catch:{ et -> 0x0596 }
            goto L_0x0009
        L_0x052e:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ et -> 0x0596 }
            int r1 = r14.h()     // Catch:{ et -> 0x0596 }
            com.google.android.gms.internal.vision.hg.a((java.lang.Object) r13, (long) r3, (int) r1)     // Catch:{ et -> 0x0596 }
            r12.b(r13, (int) r2)     // Catch:{ et -> 0x0596 }
            goto L_0x0009
        L_0x053d:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ et -> 0x0596 }
            long r5 = r14.f()     // Catch:{ et -> 0x0596 }
            com.google.android.gms.internal.vision.hg.a((java.lang.Object) r13, (long) r3, (long) r5)     // Catch:{ et -> 0x0596 }
            r12.b(r13, (int) r2)     // Catch:{ et -> 0x0596 }
            goto L_0x0009
        L_0x054c:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ et -> 0x0596 }
            long r5 = r14.g()     // Catch:{ et -> 0x0596 }
            com.google.android.gms.internal.vision.hg.a((java.lang.Object) r13, (long) r3, (long) r5)     // Catch:{ et -> 0x0596 }
            r12.b(r13, (int) r2)     // Catch:{ et -> 0x0596 }
            goto L_0x0009
        L_0x055b:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ et -> 0x0596 }
            float r1 = r14.e()     // Catch:{ et -> 0x0596 }
            com.google.android.gms.internal.vision.hg.a((java.lang.Object) r13, (long) r3, (float) r1)     // Catch:{ et -> 0x0596 }
            r12.b(r13, (int) r2)     // Catch:{ et -> 0x0596 }
            goto L_0x0009
        L_0x056a:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ et -> 0x0596 }
            double r5 = r14.d()     // Catch:{ et -> 0x0596 }
            com.google.android.gms.internal.vision.hg.a((java.lang.Object) r13, (long) r3, (double) r5)     // Catch:{ et -> 0x0596 }
            r12.b(r13, (int) r2)     // Catch:{ et -> 0x0596 }
            goto L_0x0009
        L_0x0579:
            boolean r1 = r7.a(r10, (com.google.android.gms.internal.vision.gj) r14)     // Catch:{ et -> 0x0596 }
            if (r1 != 0) goto L_0x0009
            int r14 = r12.m
        L_0x0581:
            int r15 = r12.n
            if (r14 >= r15) goto L_0x0590
            int[] r15 = r12.l
            r15 = r15[r14]
            java.lang.Object r10 = r12.a(r13, r15, r10, r7)
            int r14 = r14 + 1
            goto L_0x0581
        L_0x0590:
            if (r10 == 0) goto L_0x0595
            r7.b((java.lang.Object) r13, r10)
        L_0x0595:
            return
        L_0x0596:
            if (r10 != 0) goto L_0x059d
            java.lang.Object r1 = r7.c(r13)     // Catch:{ all -> 0x05ba }
            r10 = r1
        L_0x059d:
            boolean r1 = r7.a(r10, (com.google.android.gms.internal.vision.gj) r14)     // Catch:{ all -> 0x05ba }
            if (r1 != 0) goto L_0x0009
            int r14 = r12.m
        L_0x05a5:
            int r15 = r12.n
            if (r14 >= r15) goto L_0x05b4
            int[] r15 = r12.l
            r15 = r15[r14]
            java.lang.Object r10 = r12.a(r13, r15, r10, r7)
            int r14 = r14 + 1
            goto L_0x05a5
        L_0x05b4:
            if (r10 == 0) goto L_0x05b9
            r7.b((java.lang.Object) r13, r10)
        L_0x05b9:
            return
        L_0x05ba:
            r14 = move-exception
            int r15 = r12.m
        L_0x05bd:
            int r0 = r12.n
            if (r15 >= r0) goto L_0x05cc
            int[] r0 = r12.l
            r0 = r0[r15]
            java.lang.Object r10 = r12.a(r13, r0, r10, r7)
            int r15 = r15 + 1
            goto L_0x05bd
        L_0x05cc:
            if (r10 == 0) goto L_0x05d1
            r7.b((java.lang.Object) r13, r10)
        L_0x05d1:
            throw r14
        L_0x05d2:
            java.lang.NullPointerException r13 = new java.lang.NullPointerException
            r13.<init>()
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.fx.a(java.lang.Object, com.google.android.gms.internal.vision.gj, com.google.android.gms.internal.vision.du):void");
    }

    private static hd e(Object obj) {
        ej ejVar = (ej) obj;
        hd hdVar = ejVar.zzwj;
        if (hdVar != hd.a()) {
            return hdVar;
        }
        hd b2 = hd.b();
        ejVar.zzwj = b2;
        return b2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        return r2 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        return r2 + 8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int a(byte[] r1, int r2, int r3, com.google.android.gms.internal.vision.hs r4, java.lang.Class<?> r5, com.google.android.gms.internal.vision.ct r6) throws java.io.IOException {
        /*
            int[] r0 = com.google.android.gms.internal.vision.fw.f11144a
            int r4 = r4.ordinal()
            r4 = r0[r4]
            switch(r4) {
                case 1: goto L_0x009a;
                case 2: goto L_0x0095;
                case 3: goto L_0x0088;
                case 4: goto L_0x007b;
                case 5: goto L_0x007b;
                case 6: goto L_0x0070;
                case 7: goto L_0x0070;
                case 8: goto L_0x0065;
                case 9: goto L_0x0058;
                case 10: goto L_0x0058;
                case 11: goto L_0x0058;
                case 12: goto L_0x004b;
                case 13: goto L_0x004b;
                case 14: goto L_0x003e;
                case 15: goto L_0x002c;
                case 16: goto L_0x001a;
                case 17: goto L_0x0014;
                default: goto L_0x000b;
            }
        L_0x000b:
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.String r2 = "unsupported field type."
            r1.<init>(r2)
            throw r1
        L_0x0014:
            int r1 = com.google.android.gms.internal.vision.cr.d(r1, r2, r6)
            goto L_0x00af
        L_0x001a:
            int r1 = com.google.android.gms.internal.vision.cr.b(r1, r2, r6)
            long r2 = r6.f11018b
            long r2 = com.google.android.gms.internal.vision.dl.a((long) r2)
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            r6.f11019c = r2
            goto L_0x00af
        L_0x002c:
            int r1 = com.google.android.gms.internal.vision.cr.a(r1, r2, r6)
            int r2 = r6.f11017a
            int r2 = com.google.android.gms.internal.vision.dl.e(r2)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r6.f11019c = r2
            goto L_0x00af
        L_0x003e:
            com.google.android.gms.internal.vision.ge r4 = com.google.android.gms.internal.vision.ge.a()
            com.google.android.gms.internal.vision.gi r4 = r4.a(r5)
            int r1 = com.google.android.gms.internal.vision.cr.a((com.google.android.gms.internal.vision.gi) r4, (byte[]) r1, (int) r2, (int) r3, (com.google.android.gms.internal.vision.ct) r6)
            goto L_0x00af
        L_0x004b:
            int r1 = com.google.android.gms.internal.vision.cr.b(r1, r2, r6)
            long r2 = r6.f11018b
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            r6.f11019c = r2
            goto L_0x00af
        L_0x0058:
            int r1 = com.google.android.gms.internal.vision.cr.a(r1, r2, r6)
            int r2 = r6.f11017a
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r6.f11019c = r2
            goto L_0x00af
        L_0x0065:
            float r1 = com.google.android.gms.internal.vision.cr.d(r1, r2)
            java.lang.Float r1 = java.lang.Float.valueOf(r1)
            r6.f11019c = r1
            goto L_0x0085
        L_0x0070:
            long r3 = com.google.android.gms.internal.vision.cr.b(r1, r2)
            java.lang.Long r1 = java.lang.Long.valueOf(r3)
            r6.f11019c = r1
            goto L_0x0092
        L_0x007b:
            int r1 = com.google.android.gms.internal.vision.cr.a(r1, r2)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r6.f11019c = r1
        L_0x0085:
            int r1 = r2 + 4
            goto L_0x00af
        L_0x0088:
            double r3 = com.google.android.gms.internal.vision.cr.c(r1, r2)
            java.lang.Double r1 = java.lang.Double.valueOf(r3)
            r6.f11019c = r1
        L_0x0092:
            int r1 = r2 + 8
            goto L_0x00af
        L_0x0095:
            int r1 = com.google.android.gms.internal.vision.cr.e(r1, r2, r6)
            goto L_0x00af
        L_0x009a:
            int r1 = com.google.android.gms.internal.vision.cr.b(r1, r2, r6)
            long r2 = r6.f11018b
            r4 = 0
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x00a8
            r2 = 1
            goto L_0x00a9
        L_0x00a8:
            r2 = 0
        L_0x00a9:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            r6.f11019c = r2
        L_0x00af:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.fx.a(byte[], int, int, com.google.android.gms.internal.vision.hs, java.lang.Class, com.google.android.gms.internal.vision.ct):int");
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0201  */
    /* JADX WARNING: Removed duplicated region for block: B:190:0x0354 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:196:0x0353 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:203:0x0353 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0139  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x01b3  */
    private final int a(T r17, byte[] r18, int r19, int r20, int r21, int r22, int r23, int r24, long r25, int r27, long r28, com.google.android.gms.internal.vision.ct r30) throws java.io.IOException {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r3 = r18
            r4 = r19
            r5 = r20
            r2 = r21
            r6 = r23
            r8 = r24
            r9 = r28
            r7 = r30
            sun.misc.Unsafe r11 = f11146b
            java.lang.Object r11 = r11.getObject(r1, r9)
            com.google.android.gms.internal.vision.eq r11 = (com.google.android.gms.internal.vision.eq) r11
            boolean r12 = r11.a()
            r13 = 1
            if (r12 != 0) goto L_0x0036
            int r12 = r11.size()
            if (r12 != 0) goto L_0x002c
            r12 = 10
            goto L_0x002d
        L_0x002c:
            int r12 = r12 << r13
        L_0x002d:
            com.google.android.gms.internal.vision.eq r11 = r11.a(r12)
            sun.misc.Unsafe r12 = f11146b
            r12.putObject(r1, r9, r11)
        L_0x0036:
            r9 = 5
            r14 = 0
            r10 = 2
            switch(r27) {
                case 18: goto L_0x032d;
                case 19: goto L_0x0307;
                case 20: goto L_0x02de;
                case 21: goto L_0x02de;
                case 22: goto L_0x02c4;
                case 23: goto L_0x029d;
                case 24: goto L_0x0276;
                case 25: goto L_0x023e;
                case 26: goto L_0x018b;
                case 27: goto L_0x0171;
                case 28: goto L_0x0119;
                case 29: goto L_0x02c4;
                case 30: goto L_0x00e1;
                case 31: goto L_0x0276;
                case 32: goto L_0x029d;
                case 33: goto L_0x00b0;
                case 34: goto L_0x007f;
                case 35: goto L_0x032d;
                case 36: goto L_0x0307;
                case 37: goto L_0x02de;
                case 38: goto L_0x02de;
                case 39: goto L_0x02c4;
                case 40: goto L_0x029d;
                case 41: goto L_0x0276;
                case 42: goto L_0x023e;
                case 43: goto L_0x02c4;
                case 44: goto L_0x00e1;
                case 45: goto L_0x0276;
                case 46: goto L_0x029d;
                case 47: goto L_0x00b0;
                case 48: goto L_0x007f;
                case 49: goto L_0x003f;
                default: goto L_0x003d;
            }
        L_0x003d:
            goto L_0x0353
        L_0x003f:
            r1 = 3
            if (r6 != r1) goto L_0x0353
            com.google.android.gms.internal.vision.gi r1 = r0.a((int) r8)
            r6 = r2 & -8
            r6 = r6 | 4
            r22 = r1
            r23 = r18
            r24 = r19
            r25 = r20
            r26 = r6
            r27 = r30
            int r4 = com.google.android.gms.internal.vision.cr.a((com.google.android.gms.internal.vision.gi) r22, (byte[]) r23, (int) r24, (int) r25, (int) r26, (com.google.android.gms.internal.vision.ct) r27)
            java.lang.Object r8 = r7.f11019c
            r11.add(r8)
        L_0x005f:
            if (r4 >= r5) goto L_0x0353
            int r8 = com.google.android.gms.internal.vision.cr.a(r3, r4, r7)
            int r9 = r7.f11017a
            if (r2 != r9) goto L_0x0353
            r22 = r1
            r23 = r18
            r24 = r8
            r25 = r20
            r26 = r6
            r27 = r30
            int r4 = com.google.android.gms.internal.vision.cr.a((com.google.android.gms.internal.vision.gi) r22, (byte[]) r23, (int) r24, (int) r25, (int) r26, (com.google.android.gms.internal.vision.ct) r27)
            java.lang.Object r8 = r7.f11019c
            r11.add(r8)
            goto L_0x005f
        L_0x007f:
            if (r6 != r10) goto L_0x0087
            int r1 = com.google.android.gms.internal.vision.cr.i(r3, r4, r11, r7)
            goto L_0x0354
        L_0x0087:
            if (r6 != 0) goto L_0x0353
            com.google.android.gms.internal.vision.fg r11 = (com.google.android.gms.internal.vision.fg) r11
            int r1 = com.google.android.gms.internal.vision.cr.b(r3, r4, r7)
            long r8 = r7.f11018b
            long r8 = com.google.android.gms.internal.vision.dl.a((long) r8)
            r11.a((long) r8)
        L_0x0098:
            if (r1 >= r5) goto L_0x0354
            int r4 = com.google.android.gms.internal.vision.cr.a(r3, r1, r7)
            int r6 = r7.f11017a
            if (r2 != r6) goto L_0x0354
            int r1 = com.google.android.gms.internal.vision.cr.b(r3, r4, r7)
            long r8 = r7.f11018b
            long r8 = com.google.android.gms.internal.vision.dl.a((long) r8)
            r11.a((long) r8)
            goto L_0x0098
        L_0x00b0:
            if (r6 != r10) goto L_0x00b8
            int r1 = com.google.android.gms.internal.vision.cr.h(r3, r4, r11, r7)
            goto L_0x0354
        L_0x00b8:
            if (r6 != 0) goto L_0x0353
            com.google.android.gms.internal.vision.el r11 = (com.google.android.gms.internal.vision.el) r11
            int r1 = com.google.android.gms.internal.vision.cr.a(r3, r4, r7)
            int r4 = r7.f11017a
            int r4 = com.google.android.gms.internal.vision.dl.e(r4)
            r11.c(r4)
        L_0x00c9:
            if (r1 >= r5) goto L_0x0354
            int r4 = com.google.android.gms.internal.vision.cr.a(r3, r1, r7)
            int r6 = r7.f11017a
            if (r2 != r6) goto L_0x0354
            int r1 = com.google.android.gms.internal.vision.cr.a(r3, r4, r7)
            int r4 = r7.f11017a
            int r4 = com.google.android.gms.internal.vision.dl.e(r4)
            r11.c(r4)
            goto L_0x00c9
        L_0x00e1:
            if (r6 != r10) goto L_0x00e8
            int r2 = com.google.android.gms.internal.vision.cr.a((byte[]) r3, (int) r4, (com.google.android.gms.internal.vision.eq<?>) r11, (com.google.android.gms.internal.vision.ct) r7)
            goto L_0x00f9
        L_0x00e8:
            if (r6 != 0) goto L_0x0353
            r2 = r21
            r3 = r18
            r4 = r19
            r5 = r20
            r6 = r11
            r7 = r30
            int r2 = com.google.android.gms.internal.vision.cr.a((int) r2, (byte[]) r3, (int) r4, (int) r5, (com.google.android.gms.internal.vision.eq<?>) r6, (com.google.android.gms.internal.vision.ct) r7)
        L_0x00f9:
            com.google.android.gms.internal.vision.ej r1 = (com.google.android.gms.internal.vision.ej) r1
            com.google.android.gms.internal.vision.hd r3 = r1.zzwj
            com.google.android.gms.internal.vision.hd r4 = com.google.android.gms.internal.vision.hd.a()
            if (r3 != r4) goto L_0x0104
            r3 = 0
        L_0x0104:
            com.google.android.gms.internal.vision.ep r4 = r0.b((int) r8)
            com.google.android.gms.internal.vision.ha<?, ?> r5 = r0.q
            r6 = r22
            java.lang.Object r3 = com.google.android.gms.internal.vision.gk.a((int) r6, (java.util.List<java.lang.Integer>) r11, (com.google.android.gms.internal.vision.ep) r4, r3, r5)
            com.google.android.gms.internal.vision.hd r3 = (com.google.android.gms.internal.vision.hd) r3
            if (r3 == 0) goto L_0x0116
            r1.zzwj = r3
        L_0x0116:
            r1 = r2
            goto L_0x0354
        L_0x0119:
            if (r6 != r10) goto L_0x0353
            int r1 = com.google.android.gms.internal.vision.cr.a(r3, r4, r7)
            int r4 = r7.f11017a
            if (r4 < 0) goto L_0x016c
            int r6 = r3.length
            int r6 = r6 - r1
            if (r4 > r6) goto L_0x0167
            if (r4 != 0) goto L_0x012f
            com.google.android.gms.internal.vision.cz r4 = com.google.android.gms.internal.vision.cz.zzsd
            r11.add(r4)
            goto L_0x0137
        L_0x012f:
            com.google.android.gms.internal.vision.cz r6 = com.google.android.gms.internal.vision.cz.zza(r3, r1, r4)
            r11.add(r6)
        L_0x0136:
            int r1 = r1 + r4
        L_0x0137:
            if (r1 >= r5) goto L_0x0354
            int r4 = com.google.android.gms.internal.vision.cr.a(r3, r1, r7)
            int r6 = r7.f11017a
            if (r2 != r6) goto L_0x0354
            int r1 = com.google.android.gms.internal.vision.cr.a(r3, r4, r7)
            int r4 = r7.f11017a
            if (r4 < 0) goto L_0x0162
            int r6 = r3.length
            int r6 = r6 - r1
            if (r4 > r6) goto L_0x015d
            if (r4 != 0) goto L_0x0155
            com.google.android.gms.internal.vision.cz r4 = com.google.android.gms.internal.vision.cz.zzsd
            r11.add(r4)
            goto L_0x0137
        L_0x0155:
            com.google.android.gms.internal.vision.cz r6 = com.google.android.gms.internal.vision.cz.zza(r3, r1, r4)
            r11.add(r6)
            goto L_0x0136
        L_0x015d:
            com.google.android.gms.internal.vision.eu r1 = com.google.android.gms.internal.vision.eu.zzgm()
            throw r1
        L_0x0162:
            com.google.android.gms.internal.vision.eu r1 = com.google.android.gms.internal.vision.eu.zzgn()
            throw r1
        L_0x0167:
            com.google.android.gms.internal.vision.eu r1 = com.google.android.gms.internal.vision.eu.zzgm()
            throw r1
        L_0x016c:
            com.google.android.gms.internal.vision.eu r1 = com.google.android.gms.internal.vision.eu.zzgn()
            throw r1
        L_0x0171:
            if (r6 != r10) goto L_0x0353
            com.google.android.gms.internal.vision.gi r1 = r0.a((int) r8)
            r22 = r1
            r23 = r21
            r24 = r18
            r25 = r19
            r26 = r20
            r27 = r11
            r28 = r30
            int r1 = com.google.android.gms.internal.vision.cr.a(r22, r23, r24, r25, r26, r27, r28)
            goto L_0x0354
        L_0x018b:
            if (r6 != r10) goto L_0x0353
            r8 = 536870912(0x20000000, double:2.652494739E-315)
            long r8 = r25 & r8
            java.lang.String r1 = ""
            int r6 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r6 != 0) goto L_0x01de
            int r4 = com.google.android.gms.internal.vision.cr.a(r3, r4, r7)
            int r6 = r7.f11017a
            if (r6 < 0) goto L_0x01d9
            if (r6 != 0) goto L_0x01a6
            r11.add(r1)
            goto L_0x01b1
        L_0x01a6:
            java.lang.String r8 = new java.lang.String
            java.nio.charset.Charset r9 = com.google.android.gms.internal.vision.ek.f11111a
            r8.<init>(r3, r4, r6, r9)
            r11.add(r8)
        L_0x01b0:
            int r4 = r4 + r6
        L_0x01b1:
            if (r4 >= r5) goto L_0x0353
            int r6 = com.google.android.gms.internal.vision.cr.a(r3, r4, r7)
            int r8 = r7.f11017a
            if (r2 != r8) goto L_0x0353
            int r4 = com.google.android.gms.internal.vision.cr.a(r3, r6, r7)
            int r6 = r7.f11017a
            if (r6 < 0) goto L_0x01d4
            if (r6 != 0) goto L_0x01c9
            r11.add(r1)
            goto L_0x01b1
        L_0x01c9:
            java.lang.String r8 = new java.lang.String
            java.nio.charset.Charset r9 = com.google.android.gms.internal.vision.ek.f11111a
            r8.<init>(r3, r4, r6, r9)
            r11.add(r8)
            goto L_0x01b0
        L_0x01d4:
            com.google.android.gms.internal.vision.eu r1 = com.google.android.gms.internal.vision.eu.zzgn()
            throw r1
        L_0x01d9:
            com.google.android.gms.internal.vision.eu r1 = com.google.android.gms.internal.vision.eu.zzgn()
            throw r1
        L_0x01de:
            int r4 = com.google.android.gms.internal.vision.cr.a(r3, r4, r7)
            int r6 = r7.f11017a
            if (r6 < 0) goto L_0x0239
            if (r6 != 0) goto L_0x01ec
            r11.add(r1)
            goto L_0x01ff
        L_0x01ec:
            int r8 = r4 + r6
            boolean r9 = com.google.android.gms.internal.vision.hj.a((byte[]) r3, (int) r4, (int) r8)
            if (r9 == 0) goto L_0x0234
            java.lang.String r9 = new java.lang.String
            java.nio.charset.Charset r10 = com.google.android.gms.internal.vision.ek.f11111a
            r9.<init>(r3, r4, r6, r10)
            r11.add(r9)
        L_0x01fe:
            r4 = r8
        L_0x01ff:
            if (r4 >= r5) goto L_0x0353
            int r6 = com.google.android.gms.internal.vision.cr.a(r3, r4, r7)
            int r8 = r7.f11017a
            if (r2 != r8) goto L_0x0353
            int r4 = com.google.android.gms.internal.vision.cr.a(r3, r6, r7)
            int r6 = r7.f11017a
            if (r6 < 0) goto L_0x022f
            if (r6 != 0) goto L_0x0217
            r11.add(r1)
            goto L_0x01ff
        L_0x0217:
            int r8 = r4 + r6
            boolean r9 = com.google.android.gms.internal.vision.hj.a((byte[]) r3, (int) r4, (int) r8)
            if (r9 == 0) goto L_0x022a
            java.lang.String r9 = new java.lang.String
            java.nio.charset.Charset r10 = com.google.android.gms.internal.vision.ek.f11111a
            r9.<init>(r3, r4, r6, r10)
            r11.add(r9)
            goto L_0x01fe
        L_0x022a:
            com.google.android.gms.internal.vision.eu r1 = com.google.android.gms.internal.vision.eu.zzgt()
            throw r1
        L_0x022f:
            com.google.android.gms.internal.vision.eu r1 = com.google.android.gms.internal.vision.eu.zzgn()
            throw r1
        L_0x0234:
            com.google.android.gms.internal.vision.eu r1 = com.google.android.gms.internal.vision.eu.zzgt()
            throw r1
        L_0x0239:
            com.google.android.gms.internal.vision.eu r1 = com.google.android.gms.internal.vision.eu.zzgn()
            throw r1
        L_0x023e:
            if (r6 != r10) goto L_0x0246
            int r1 = com.google.android.gms.internal.vision.cr.g(r3, r4, r11, r7)
            goto L_0x0354
        L_0x0246:
            if (r6 != 0) goto L_0x0353
            com.google.android.gms.internal.vision.cx r11 = (com.google.android.gms.internal.vision.cx) r11
            int r1 = com.google.android.gms.internal.vision.cr.b(r3, r4, r7)
            long r8 = r7.f11018b
            r4 = 0
            int r6 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r6 == 0) goto L_0x0257
            r6 = 1
            goto L_0x0258
        L_0x0257:
            r6 = 0
        L_0x0258:
            r11.a((boolean) r6)
        L_0x025b:
            if (r1 >= r5) goto L_0x0354
            int r6 = com.google.android.gms.internal.vision.cr.a(r3, r1, r7)
            int r8 = r7.f11017a
            if (r2 != r8) goto L_0x0354
            int r1 = com.google.android.gms.internal.vision.cr.b(r3, r6, r7)
            long r8 = r7.f11018b
            int r6 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r6 == 0) goto L_0x0271
            r6 = 1
            goto L_0x0272
        L_0x0271:
            r6 = 0
        L_0x0272:
            r11.a((boolean) r6)
            goto L_0x025b
        L_0x0276:
            if (r6 != r10) goto L_0x027e
            int r1 = com.google.android.gms.internal.vision.cr.c(r3, r4, r11, r7)
            goto L_0x0354
        L_0x027e:
            if (r6 != r9) goto L_0x0353
            com.google.android.gms.internal.vision.el r11 = (com.google.android.gms.internal.vision.el) r11
            int r1 = com.google.android.gms.internal.vision.cr.a(r18, r19)
            r11.c(r1)
        L_0x0289:
            int r1 = r4 + 4
            if (r1 >= r5) goto L_0x0354
            int r4 = com.google.android.gms.internal.vision.cr.a(r3, r1, r7)
            int r6 = r7.f11017a
            if (r2 != r6) goto L_0x0354
            int r1 = com.google.android.gms.internal.vision.cr.a(r3, r4)
            r11.c(r1)
            goto L_0x0289
        L_0x029d:
            if (r6 != r10) goto L_0x02a5
            int r1 = com.google.android.gms.internal.vision.cr.d(r3, r4, r11, r7)
            goto L_0x0354
        L_0x02a5:
            if (r6 != r13) goto L_0x0353
            com.google.android.gms.internal.vision.fg r11 = (com.google.android.gms.internal.vision.fg) r11
            long r8 = com.google.android.gms.internal.vision.cr.b(r18, r19)
            r11.a((long) r8)
        L_0x02b0:
            int r1 = r4 + 8
            if (r1 >= r5) goto L_0x0354
            int r4 = com.google.android.gms.internal.vision.cr.a(r3, r1, r7)
            int r6 = r7.f11017a
            if (r2 != r6) goto L_0x0354
            long r8 = com.google.android.gms.internal.vision.cr.b(r3, r4)
            r11.a((long) r8)
            goto L_0x02b0
        L_0x02c4:
            if (r6 != r10) goto L_0x02cc
            int r1 = com.google.android.gms.internal.vision.cr.a((byte[]) r3, (int) r4, (com.google.android.gms.internal.vision.eq<?>) r11, (com.google.android.gms.internal.vision.ct) r7)
            goto L_0x0354
        L_0x02cc:
            if (r6 != 0) goto L_0x0353
            r22 = r18
            r23 = r19
            r24 = r20
            r25 = r11
            r26 = r30
            int r1 = com.google.android.gms.internal.vision.cr.a((int) r21, (byte[]) r22, (int) r23, (int) r24, (com.google.android.gms.internal.vision.eq<?>) r25, (com.google.android.gms.internal.vision.ct) r26)
            goto L_0x0354
        L_0x02de:
            if (r6 != r10) goto L_0x02e6
            int r1 = com.google.android.gms.internal.vision.cr.b(r3, r4, r11, r7)
            goto L_0x0354
        L_0x02e6:
            if (r6 != 0) goto L_0x0353
            com.google.android.gms.internal.vision.fg r11 = (com.google.android.gms.internal.vision.fg) r11
            int r1 = com.google.android.gms.internal.vision.cr.b(r3, r4, r7)
            long r8 = r7.f11018b
            r11.a((long) r8)
        L_0x02f3:
            if (r1 >= r5) goto L_0x0354
            int r4 = com.google.android.gms.internal.vision.cr.a(r3, r1, r7)
            int r6 = r7.f11017a
            if (r2 != r6) goto L_0x0354
            int r1 = com.google.android.gms.internal.vision.cr.b(r3, r4, r7)
            long r8 = r7.f11018b
            r11.a((long) r8)
            goto L_0x02f3
        L_0x0307:
            if (r6 != r10) goto L_0x030e
            int r1 = com.google.android.gms.internal.vision.cr.e(r3, r4, r11, r7)
            goto L_0x0354
        L_0x030e:
            if (r6 != r9) goto L_0x0353
            com.google.android.gms.internal.vision.ef r11 = (com.google.android.gms.internal.vision.ef) r11
            float r1 = com.google.android.gms.internal.vision.cr.d(r18, r19)
            r11.a((float) r1)
        L_0x0319:
            int r1 = r4 + 4
            if (r1 >= r5) goto L_0x0354
            int r4 = com.google.android.gms.internal.vision.cr.a(r3, r1, r7)
            int r6 = r7.f11017a
            if (r2 != r6) goto L_0x0354
            float r1 = com.google.android.gms.internal.vision.cr.d(r3, r4)
            r11.a((float) r1)
            goto L_0x0319
        L_0x032d:
            if (r6 != r10) goto L_0x0334
            int r1 = com.google.android.gms.internal.vision.cr.f(r3, r4, r11, r7)
            goto L_0x0354
        L_0x0334:
            if (r6 != r13) goto L_0x0353
            com.google.android.gms.internal.vision.ds r11 = (com.google.android.gms.internal.vision.ds) r11
            double r8 = com.google.android.gms.internal.vision.cr.c(r18, r19)
            r11.a((double) r8)
        L_0x033f:
            int r1 = r4 + 8
            if (r1 >= r5) goto L_0x0354
            int r4 = com.google.android.gms.internal.vision.cr.a(r3, r1, r7)
            int r6 = r7.f11017a
            if (r2 != r6) goto L_0x0354
            double r8 = com.google.android.gms.internal.vision.cr.c(r3, r4)
            r11.a((double) r8)
            goto L_0x033f
        L_0x0353:
            r1 = r4
        L_0x0354:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.fx.a(java.lang.Object, byte[], int, int, int, int, int, int, long, int, long, com.google.android.gms.internal.vision.ct):int");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v12, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final <K, V> int a(T r9, byte[] r10, int r11, int r12, long r13, com.google.android.gms.internal.vision.ct r15) throws java.io.IOException {
        /*
            r8 = this;
            sun.misc.Unsafe r0 = f11146b
            java.lang.Object r1 = r0.getObject(r9, r13)
            com.google.android.gms.internal.vision.fl r2 = r8.s
            boolean r2 = r2.c(r1)
            if (r2 == 0) goto L_0x001d
            com.google.android.gms.internal.vision.fl r2 = r8.s
            java.lang.Object r2 = r2.a()
            com.google.android.gms.internal.vision.fl r3 = r8.s
            r3.a(r2, r1)
            r0.putObject(r9, r13, r2)
            r1 = r2
        L_0x001d:
            com.google.android.gms.internal.vision.fl r9 = r8.s
            com.google.android.gms.internal.vision.fj r9 = r9.b()
            com.google.android.gms.internal.vision.fl r13 = r8.s
            java.util.Map r13 = r13.a(r1)
            int r11 = com.google.android.gms.internal.vision.cr.a(r10, r11, r15)
            int r14 = r15.f11017a
            if (r14 < 0) goto L_0x0093
            int r0 = r12 - r11
            if (r14 > r0) goto L_0x0093
            int r14 = r14 + r11
            K r0 = r9.f11139b
            V r1 = r9.f11141d
        L_0x003a:
            if (r11 >= r14) goto L_0x0088
            int r2 = r11 + 1
            byte r11 = r10[r11]
            if (r11 >= 0) goto L_0x0048
            int r2 = com.google.android.gms.internal.vision.cr.a((int) r11, (byte[]) r10, (int) r2, (com.google.android.gms.internal.vision.ct) r15)
            int r11 = r15.f11017a
        L_0x0048:
            r3 = r2
            int r2 = r11 >>> 3
            r4 = r11 & 7
            r5 = 1
            if (r2 == r5) goto L_0x006e
            r5 = 2
            if (r2 == r5) goto L_0x0054
            goto L_0x0083
        L_0x0054:
            com.google.android.gms.internal.vision.hs r2 = r9.f11140c
            int r2 = r2.zziq()
            if (r4 != r2) goto L_0x0083
            com.google.android.gms.internal.vision.hs r5 = r9.f11140c
            V r11 = r9.f11141d
            java.lang.Class r6 = r11.getClass()
            r2 = r10
            r4 = r12
            r7 = r15
            int r11 = a((byte[]) r2, (int) r3, (int) r4, (com.google.android.gms.internal.vision.hs) r5, (java.lang.Class<?>) r6, (com.google.android.gms.internal.vision.ct) r7)
            java.lang.Object r1 = r15.f11019c
            goto L_0x003a
        L_0x006e:
            com.google.android.gms.internal.vision.hs r2 = r9.f11138a
            int r2 = r2.zziq()
            if (r4 != r2) goto L_0x0083
            com.google.android.gms.internal.vision.hs r5 = r9.f11138a
            r6 = 0
            r2 = r10
            r4 = r12
            r7 = r15
            int r11 = a((byte[]) r2, (int) r3, (int) r4, (com.google.android.gms.internal.vision.hs) r5, (java.lang.Class<?>) r6, (com.google.android.gms.internal.vision.ct) r7)
            java.lang.Object r0 = r15.f11019c
            goto L_0x003a
        L_0x0083:
            int r11 = com.google.android.gms.internal.vision.cr.a((int) r11, (byte[]) r10, (int) r3, (int) r12, (com.google.android.gms.internal.vision.ct) r15)
            goto L_0x003a
        L_0x0088:
            if (r11 != r14) goto L_0x008e
            r13.put(r0, r1)
            return r14
        L_0x008e:
            com.google.android.gms.internal.vision.eu r9 = com.google.android.gms.internal.vision.eu.zzgs()
            throw r9
        L_0x0093:
            com.google.android.gms.internal.vision.eu r9 = com.google.android.gms.internal.vision.eu.zzgm()
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.fx.a(java.lang.Object, byte[], int, int, long, com.google.android.gms.internal.vision.ct):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:62:0x018a, code lost:
        r2 = r4 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x019b, code lost:
        r2 = r4 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x019d, code lost:
        r12.putInt(r1, r13, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:?, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:?, code lost:
        return r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int a(T r17, byte[] r18, int r19, int r20, int r21, int r22, int r23, int r24, int r25, long r26, int r28, com.google.android.gms.internal.vision.ct r29) throws java.io.IOException {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r3 = r18
            r4 = r19
            r2 = r21
            r8 = r22
            r5 = r23
            r9 = r26
            r6 = r28
            r11 = r29
            sun.misc.Unsafe r12 = f11146b
            int[] r7 = r0.f11147c
            int r13 = r6 + 2
            r7 = r7[r13]
            r13 = 1048575(0xfffff, float:1.469367E-39)
            r7 = r7 & r13
            long r13 = (long) r7
            r7 = 5
            r15 = 2
            switch(r25) {
                case 51: goto L_0x018d;
                case 52: goto L_0x017d;
                case 53: goto L_0x016d;
                case 54: goto L_0x016d;
                case 55: goto L_0x015d;
                case 56: goto L_0x014e;
                case 57: goto L_0x0140;
                case 58: goto L_0x0127;
                case 59: goto L_0x00f3;
                case 60: goto L_0x00c5;
                case 61: goto L_0x00b8;
                case 62: goto L_0x015d;
                case 63: goto L_0x008a;
                case 64: goto L_0x0140;
                case 65: goto L_0x014e;
                case 66: goto L_0x0075;
                case 67: goto L_0x0060;
                case 68: goto L_0x0028;
                default: goto L_0x0026;
            }
        L_0x0026:
            goto L_0x01a1
        L_0x0028:
            r7 = 3
            if (r5 != r7) goto L_0x01a1
            r2 = r2 & -8
            r7 = r2 | 4
            com.google.android.gms.internal.vision.gi r2 = r0.a((int) r6)
            r3 = r18
            r4 = r19
            r5 = r20
            r6 = r7
            r7 = r29
            int r2 = com.google.android.gms.internal.vision.cr.a((com.google.android.gms.internal.vision.gi) r2, (byte[]) r3, (int) r4, (int) r5, (int) r6, (com.google.android.gms.internal.vision.ct) r7)
            int r3 = r12.getInt(r1, r13)
            if (r3 != r8) goto L_0x004b
            java.lang.Object r15 = r12.getObject(r1, r9)
            goto L_0x004c
        L_0x004b:
            r15 = 0
        L_0x004c:
            if (r15 != 0) goto L_0x0055
            java.lang.Object r3 = r11.f11019c
            r12.putObject(r1, r9, r3)
            goto L_0x019d
        L_0x0055:
            java.lang.Object r3 = r11.f11019c
            java.lang.Object r3 = com.google.android.gms.internal.vision.ek.a((java.lang.Object) r15, (java.lang.Object) r3)
            r12.putObject(r1, r9, r3)
            goto L_0x019d
        L_0x0060:
            if (r5 != 0) goto L_0x01a1
            int r2 = com.google.android.gms.internal.vision.cr.b(r3, r4, r11)
            long r3 = r11.f11018b
            long r3 = com.google.android.gms.internal.vision.dl.a((long) r3)
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            r12.putObject(r1, r9, r3)
            goto L_0x019d
        L_0x0075:
            if (r5 != 0) goto L_0x01a1
            int r2 = com.google.android.gms.internal.vision.cr.a(r3, r4, r11)
            int r3 = r11.f11017a
            int r3 = com.google.android.gms.internal.vision.dl.e(r3)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r12.putObject(r1, r9, r3)
            goto L_0x019d
        L_0x008a:
            if (r5 != 0) goto L_0x01a1
            int r3 = com.google.android.gms.internal.vision.cr.a(r3, r4, r11)
            int r4 = r11.f11017a
            com.google.android.gms.internal.vision.ep r5 = r0.b((int) r6)
            if (r5 == 0) goto L_0x00ae
            boolean r5 = r5.a(r4)
            if (r5 == 0) goto L_0x009f
            goto L_0x00ae
        L_0x009f:
            com.google.android.gms.internal.vision.hd r1 = e((java.lang.Object) r17)
            long r4 = (long) r4
            java.lang.Long r4 = java.lang.Long.valueOf(r4)
            r1.a((int) r2, (java.lang.Object) r4)
            r2 = r3
            goto L_0x01a2
        L_0x00ae:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r4)
            r12.putObject(r1, r9, r2)
            r2 = r3
            goto L_0x019d
        L_0x00b8:
            if (r5 != r15) goto L_0x01a1
            int r2 = com.google.android.gms.internal.vision.cr.e(r3, r4, r11)
            java.lang.Object r3 = r11.f11019c
            r12.putObject(r1, r9, r3)
            goto L_0x019d
        L_0x00c5:
            if (r5 != r15) goto L_0x01a1
            com.google.android.gms.internal.vision.gi r2 = r0.a((int) r6)
            r5 = r20
            int r2 = com.google.android.gms.internal.vision.cr.a((com.google.android.gms.internal.vision.gi) r2, (byte[]) r3, (int) r4, (int) r5, (com.google.android.gms.internal.vision.ct) r11)
            int r3 = r12.getInt(r1, r13)
            if (r3 != r8) goto L_0x00dc
            java.lang.Object r15 = r12.getObject(r1, r9)
            goto L_0x00dd
        L_0x00dc:
            r15 = 0
        L_0x00dd:
            if (r15 != 0) goto L_0x00e5
            java.lang.Object r3 = r11.f11019c
            r12.putObject(r1, r9, r3)
            goto L_0x00ee
        L_0x00e5:
            java.lang.Object r3 = r11.f11019c
            java.lang.Object r3 = com.google.android.gms.internal.vision.ek.a((java.lang.Object) r15, (java.lang.Object) r3)
            r12.putObject(r1, r9, r3)
        L_0x00ee:
            r12.putInt(r1, r13, r8)
            goto L_0x01a2
        L_0x00f3:
            if (r5 != r15) goto L_0x01a1
            int r2 = com.google.android.gms.internal.vision.cr.a(r3, r4, r11)
            int r4 = r11.f11017a
            if (r4 != 0) goto L_0x0103
            java.lang.String r3 = ""
            r12.putObject(r1, r9, r3)
            goto L_0x0122
        L_0x0103:
            r5 = 536870912(0x20000000, float:1.0842022E-19)
            r5 = r24 & r5
            if (r5 == 0) goto L_0x0117
            int r5 = r2 + r4
            boolean r5 = com.google.android.gms.internal.vision.hj.a((byte[]) r3, (int) r2, (int) r5)
            if (r5 == 0) goto L_0x0112
            goto L_0x0117
        L_0x0112:
            com.google.android.gms.internal.vision.eu r1 = com.google.android.gms.internal.vision.eu.zzgt()
            throw r1
        L_0x0117:
            java.lang.String r5 = new java.lang.String
            java.nio.charset.Charset r6 = com.google.android.gms.internal.vision.ek.f11111a
            r5.<init>(r3, r2, r4, r6)
            r12.putObject(r1, r9, r5)
            int r2 = r2 + r4
        L_0x0122:
            r12.putInt(r1, r13, r8)
            goto L_0x01a2
        L_0x0127:
            if (r5 != 0) goto L_0x01a1
            int r2 = com.google.android.gms.internal.vision.cr.b(r3, r4, r11)
            long r3 = r11.f11018b
            r5 = 0
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 == 0) goto L_0x0137
            r15 = 1
            goto L_0x0138
        L_0x0137:
            r15 = 0
        L_0x0138:
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r15)
            r12.putObject(r1, r9, r3)
            goto L_0x019d
        L_0x0140:
            if (r5 != r7) goto L_0x01a1
            int r2 = com.google.android.gms.internal.vision.cr.a(r18, r19)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r12.putObject(r1, r9, r2)
            goto L_0x018a
        L_0x014e:
            r2 = 1
            if (r5 != r2) goto L_0x01a1
            long r2 = com.google.android.gms.internal.vision.cr.b(r18, r19)
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            r12.putObject(r1, r9, r2)
            goto L_0x019b
        L_0x015d:
            if (r5 != 0) goto L_0x01a1
            int r2 = com.google.android.gms.internal.vision.cr.a(r3, r4, r11)
            int r3 = r11.f11017a
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r12.putObject(r1, r9, r3)
            goto L_0x019d
        L_0x016d:
            if (r5 != 0) goto L_0x01a1
            int r2 = com.google.android.gms.internal.vision.cr.b(r3, r4, r11)
            long r3 = r11.f11018b
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            r12.putObject(r1, r9, r3)
            goto L_0x019d
        L_0x017d:
            if (r5 != r7) goto L_0x01a1
            float r2 = com.google.android.gms.internal.vision.cr.d(r18, r19)
            java.lang.Float r2 = java.lang.Float.valueOf(r2)
            r12.putObject(r1, r9, r2)
        L_0x018a:
            int r2 = r4 + 4
            goto L_0x019d
        L_0x018d:
            r2 = 1
            if (r5 != r2) goto L_0x01a1
            double r2 = com.google.android.gms.internal.vision.cr.c(r18, r19)
            java.lang.Double r2 = java.lang.Double.valueOf(r2)
            r12.putObject(r1, r9, r2)
        L_0x019b:
            int r2 = r4 + 8
        L_0x019d:
            r12.putInt(r1, r13, r8)
            goto L_0x01a2
        L_0x01a1:
            r2 = r4
        L_0x01a2:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.fx.a(java.lang.Object, byte[], int, int, int, int, int, int, int, long, int, com.google.android.gms.internal.vision.ct):int");
    }

    private final gi a(int i2) {
        int i3 = (i2 / 3) << 1;
        gi giVar = (gi) this.f11148d[i3];
        if (giVar != null) {
            return giVar;
        }
        gi a2 = ge.a().a((Class) this.f11148d[i3 + 1]);
        this.f11148d[i3] = a2;
        return a2;
    }

    private final ep b(int i2) {
        return (ep) this.f11148d[((i2 / 3) << 1) + 1];
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v16, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v64, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v33, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v35, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v36, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v37, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v38, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v12, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v35, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v37, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v40, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v38, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v17, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v41, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v42, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v61, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v9, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v39, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v13, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v43, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v15, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v40, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v41, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v42, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v14, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v43, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v15, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v16, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v17, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v18, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v19, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v20, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v21, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v22, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v23, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v24, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v25, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v26, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v27, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v46, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v28, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v29, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v30, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v31, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v53, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v32, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v42, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v33, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v34, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v58, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v35, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v36, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v44, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v29, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v34, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v35, resolved type: byte} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x02c0, code lost:
        r13 = r37;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x02c2, code lost:
        r11 = r38;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x02c6, code lost:
        r22 = r36;
        r15 = r38;
        r2 = r3;
        r6 = r8;
        r31 = r10;
        r25 = r11;
        r26 = r13;
        r24 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x036e, code lost:
        if (r0 == r3) goto L_0x03d4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x03b2, code lost:
        if (r0 == r14) goto L_0x03d4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x0505, code lost:
        r15 = r37;
        r2 = r1;
        r0 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:199:0x0620, code lost:
        r2 = r2 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:201:0x062e, code lost:
        r2 = r2 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00a1, code lost:
        r13 = r0;
        r11 = r2;
        r23 = r6;
        r36 = r8;
        r8 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0174, code lost:
        r5 = r6 | r24;
        r6 = r36;
        r0 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x017b, code lost:
        r23 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x0280, code lost:
        r6 = r36;
        r0 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x029b, code lost:
        r0 = r3 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x02b9, code lost:
        r5 = r23 | r24;
        r6 = r36;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x02bd, code lost:
        r3 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x02be, code lost:
        r2 = r11;
        r1 = r13;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int a(T r34, byte[] r35, int r36, int r37, int r38, com.google.android.gms.internal.vision.ct r39) throws java.io.IOException {
        /*
            r33 = this;
            r15 = r33
            r14 = r34
            r12 = r35
            r13 = r37
            r11 = r38
            r9 = r39
            sun.misc.Unsafe r10 = f11146b
            r16 = 0
            r0 = r36
            r1 = -1
            r2 = 0
            r3 = 0
            r5 = 0
            r6 = 1048575(0xfffff, float:1.469367E-39)
        L_0x0019:
            r17 = 0
            if (r0 >= r13) goto L_0x06b1
            int r3 = r0 + 1
            byte r0 = r12[r0]
            if (r0 >= 0) goto L_0x002c
            int r0 = com.google.android.gms.internal.vision.cr.a((int) r0, (byte[]) r12, (int) r3, (com.google.android.gms.internal.vision.ct) r9)
            int r3 = r9.f11017a
            r4 = r3
            r3 = r0
            goto L_0x002d
        L_0x002c:
            r4 = r0
        L_0x002d:
            int r0 = r4 >>> 3
            r7 = r4 & 7
            r8 = 3
            if (r0 <= r1) goto L_0x003a
            int r2 = r2 / r8
            int r1 = r15.a((int) r0, (int) r2)
            goto L_0x003e
        L_0x003a:
            int r1 = r15.f(r0)
        L_0x003e:
            r2 = r1
            r20 = 0
            r8 = -1
            if (r2 != r8) goto L_0x0057
            r26 = r0
            r2 = r3
            r23 = r5
            r22 = r6
            r31 = r10
            r15 = r11
            r19 = -1
            r24 = 1
            r25 = 0
            r6 = r4
            goto L_0x03d6
        L_0x0057:
            int[] r8 = r15.f11147c
            int r23 = r2 + 1
            r1 = r8[r23]
            r23 = 267386880(0xff00000, float:2.3665827E-29)
            r23 = r1 & r23
            int r11 = r23 >>> 20
            r18 = r4
            r13 = 1048575(0xfffff, float:1.469367E-39)
            r4 = r1 & r13
            long r13 = (long) r4
            r4 = 17
            if (r11 > r4) goto L_0x02d8
            int r24 = r2 + 2
            r8 = r8[r24]
            int r24 = r8 >>> 20
            r22 = 1
            int r24 = r22 << r24
            r25 = r13
            r13 = 1048575(0xfffff, float:1.469367E-39)
            r8 = r8 & r13
            if (r8 == r6) goto L_0x0097
            if (r6 == r13) goto L_0x008c
            long r13 = (long) r6
            r6 = r34
            r27 = r25
            r10.putInt(r6, r13, r5)
            goto L_0x0090
        L_0x008c:
            r6 = r34
            r27 = r25
        L_0x0090:
            long r13 = (long) r8
            int r5 = r10.getInt(r6, r13)
            r14 = r6
            goto L_0x009c
        L_0x0097:
            r14 = r34
            r27 = r25
            r8 = r6
        L_0x009c:
            r6 = r5
            r5 = 5
            switch(r11) {
                case 0: goto L_0x02a0;
                case 1: goto L_0x0284;
                case 2: goto L_0x025e;
                case 3: goto L_0x025e;
                case 4: goto L_0x0244;
                case 5: goto L_0x0222;
                case 6: goto L_0x0209;
                case 7: goto L_0x01e8;
                case 8: goto L_0x01c3;
                case 9: goto L_0x017f;
                case 10: goto L_0x0160;
                case 11: goto L_0x0244;
                case 12: goto L_0x012a;
                case 13: goto L_0x0209;
                case 14: goto L_0x0222;
                case 15: goto L_0x0112;
                case 16: goto L_0x00eb;
                case 17: goto L_0x00af;
                default: goto L_0x00a1;
            }
        L_0x00a1:
            r13 = r0
            r11 = r2
            r23 = r6
            r36 = r8
            r8 = r18
        L_0x00a9:
            r2 = 1
            r18 = 1048575(0xfffff, float:1.469367E-39)
            goto L_0x02c6
        L_0x00af:
            r11 = 3
            if (r7 != r11) goto L_0x00a1
            int r1 = r0 << 3
            r4 = r1 | 4
            com.google.android.gms.internal.vision.gi r1 = r15.a((int) r2)
            r13 = r0
            r0 = r1
            r1 = r35
            r11 = r2
            r2 = r3
            r3 = r37
            r7 = r18
            r5 = r39
            int r0 = com.google.android.gms.internal.vision.cr.a((com.google.android.gms.internal.vision.gi) r0, (byte[]) r1, (int) r2, (int) r3, (int) r4, (com.google.android.gms.internal.vision.ct) r5)
            r1 = r6 & r24
            if (r1 != 0) goto L_0x00d6
            java.lang.Object r1 = r9.f11019c
            r2 = r27
            r10.putObject(r14, r2, r1)
            goto L_0x00e5
        L_0x00d6:
            r2 = r27
            java.lang.Object r1 = r10.getObject(r14, r2)
            java.lang.Object r4 = r9.f11019c
            java.lang.Object r1 = com.google.android.gms.internal.vision.ek.a((java.lang.Object) r1, (java.lang.Object) r4)
            r10.putObject(r14, r2, r1)
        L_0x00e5:
            r5 = r6 | r24
            r3 = r7
            r6 = r8
            goto L_0x02be
        L_0x00eb:
            r13 = r0
            r11 = r2
            r5 = r18
            r1 = r27
            if (r7 != 0) goto L_0x010d
            int r7 = com.google.android.gms.internal.vision.cr.b(r12, r3, r9)
            long r3 = r9.f11018b
            long r17 = com.google.android.gms.internal.vision.dl.a((long) r3)
            r0 = r10
            r2 = r1
            r1 = r34
            r36 = r8
            r8 = r5
            r4 = r17
            r0.putLong(r1, r2, r4)
            r5 = r6 | r24
            goto L_0x0280
        L_0x010d:
            r36 = r8
            r8 = r5
            goto L_0x017b
        L_0x0112:
            r13 = r0
            r11 = r2
            r36 = r8
            r8 = r18
            r0 = r27
            if (r7 != 0) goto L_0x017b
            int r2 = com.google.android.gms.internal.vision.cr.a(r12, r3, r9)
            int r3 = r9.f11017a
            int r3 = com.google.android.gms.internal.vision.dl.e(r3)
            r10.putInt(r14, r0, r3)
            goto L_0x0174
        L_0x012a:
            r13 = r0
            r11 = r2
            r36 = r8
            r8 = r18
            r0 = r27
            if (r7 != 0) goto L_0x017b
            int r2 = com.google.android.gms.internal.vision.cr.a(r12, r3, r9)
            int r3 = r9.f11017a
            com.google.android.gms.internal.vision.ep r4 = r15.b((int) r11)
            if (r4 == 0) goto L_0x015c
            boolean r4 = r4.a(r3)
            if (r4 == 0) goto L_0x0147
            goto L_0x015c
        L_0x0147:
            com.google.android.gms.internal.vision.hd r0 = e((java.lang.Object) r34)
            long r3 = (long) r3
            java.lang.Long r1 = java.lang.Long.valueOf(r3)
            r0.a((int) r8, (java.lang.Object) r1)
            r0 = r2
            r5 = r6
            r3 = r8
            r2 = r11
            r1 = r13
            r6 = r36
            goto L_0x02c0
        L_0x015c:
            r10.putInt(r14, r0, r3)
            goto L_0x0174
        L_0x0160:
            r13 = r0
            r11 = r2
            r36 = r8
            r8 = r18
            r0 = r27
            r2 = 2
            if (r7 != r2) goto L_0x017b
            int r2 = com.google.android.gms.internal.vision.cr.e(r12, r3, r9)
            java.lang.Object r3 = r9.f11019c
            r10.putObject(r14, r0, r3)
        L_0x0174:
            r5 = r6 | r24
            r6 = r36
            r0 = r2
            goto L_0x02bd
        L_0x017b:
            r23 = r6
            goto L_0x00a9
        L_0x017f:
            r13 = r0
            r11 = r2
            r36 = r8
            r8 = r18
            r0 = r27
            r2 = 2
            if (r7 != r2) goto L_0x01ba
            com.google.android.gms.internal.vision.gi r2 = r15.a((int) r11)
            r5 = r37
            r18 = 1048575(0xfffff, float:1.469367E-39)
            int r2 = com.google.android.gms.internal.vision.cr.a((com.google.android.gms.internal.vision.gi) r2, (byte[]) r12, (int) r3, (int) r5, (com.google.android.gms.internal.vision.ct) r9)
            r3 = r6 & r24
            if (r3 != 0) goto L_0x01a1
            java.lang.Object r3 = r9.f11019c
            r10.putObject(r14, r0, r3)
            goto L_0x01ae
        L_0x01a1:
            java.lang.Object r3 = r10.getObject(r14, r0)
            java.lang.Object r4 = r9.f11019c
            java.lang.Object r3 = com.google.android.gms.internal.vision.ek.a((java.lang.Object) r3, (java.lang.Object) r4)
            r10.putObject(r14, r0, r3)
        L_0x01ae:
            r0 = r6 | r24
            r6 = r36
            r3 = r8
            r1 = r13
            r13 = r5
            r5 = r0
            r0 = r2
            r2 = r11
            goto L_0x02c2
        L_0x01ba:
            r5 = r37
            r18 = 1048575(0xfffff, float:1.469367E-39)
            r23 = r6
            goto L_0x029e
        L_0x01c3:
            r13 = r0
            r11 = r2
            r23 = r6
            r36 = r8
            r8 = r18
            r5 = r27
            r0 = 2
            r18 = 1048575(0xfffff, float:1.469367E-39)
            if (r7 != r0) goto L_0x029e
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            r0 = r0 & r1
            if (r0 != 0) goto L_0x01dd
            int r0 = com.google.android.gms.internal.vision.cr.c(r12, r3, r9)
            goto L_0x01e1
        L_0x01dd:
            int r0 = com.google.android.gms.internal.vision.cr.d(r12, r3, r9)
        L_0x01e1:
            java.lang.Object r1 = r9.f11019c
            r10.putObject(r14, r5, r1)
            goto L_0x02b9
        L_0x01e8:
            r13 = r0
            r11 = r2
            r23 = r6
            r36 = r8
            r8 = r18
            r5 = r27
            r18 = 1048575(0xfffff, float:1.469367E-39)
            if (r7 != 0) goto L_0x029e
            int r0 = com.google.android.gms.internal.vision.cr.b(r12, r3, r9)
            long r1 = r9.f11018b
            int r3 = (r1 > r20 ? 1 : (r1 == r20 ? 0 : -1))
            if (r3 == 0) goto L_0x0203
            r1 = 1
            goto L_0x0204
        L_0x0203:
            r1 = 0
        L_0x0204:
            com.google.android.gms.internal.vision.hg.a((java.lang.Object) r14, (long) r5, (boolean) r1)
            goto L_0x02b9
        L_0x0209:
            r13 = r0
            r11 = r2
            r23 = r6
            r36 = r8
            r8 = r18
            r5 = r27
            r0 = 5
            r18 = 1048575(0xfffff, float:1.469367E-39)
            if (r7 != r0) goto L_0x029e
            int r0 = com.google.android.gms.internal.vision.cr.a(r12, r3)
            r10.putInt(r14, r5, r0)
            goto L_0x029b
        L_0x0222:
            r13 = r0
            r11 = r2
            r23 = r6
            r36 = r8
            r8 = r18
            r5 = r27
            r0 = 1
            r18 = 1048575(0xfffff, float:1.469367E-39)
            if (r7 != r0) goto L_0x029e
            long r20 = com.google.android.gms.internal.vision.cr.b(r12, r3)
            r0 = r10
            r1 = r34
            r7 = r3
            r2 = r5
            r4 = r20
            r0.putLong(r1, r2, r4)
            int r0 = r7 + 8
            goto L_0x02b9
        L_0x0244:
            r13 = r0
            r11 = r2
            r23 = r6
            r36 = r8
            r8 = r18
            r5 = r27
            r18 = 1048575(0xfffff, float:1.469367E-39)
            if (r7 != 0) goto L_0x029e
            int r0 = com.google.android.gms.internal.vision.cr.a(r12, r3, r9)
            int r1 = r9.f11017a
            r10.putInt(r14, r5, r1)
            goto L_0x02b9
        L_0x025e:
            r13 = r0
            r11 = r2
            r23 = r6
            r36 = r8
            r8 = r18
            r5 = r27
            r18 = 1048575(0xfffff, float:1.469367E-39)
            if (r7 != 0) goto L_0x029e
            int r7 = com.google.android.gms.internal.vision.cr.b(r12, r3, r9)
            long r2 = r9.f11018b
            r0 = r10
            r1 = r34
            r20 = r2
            r2 = r5
            r4 = r20
            r0.putLong(r1, r2, r4)
            r5 = r23 | r24
        L_0x0280:
            r6 = r36
            r0 = r7
            goto L_0x02bd
        L_0x0284:
            r13 = r0
            r11 = r2
            r23 = r6
            r36 = r8
            r8 = r18
            r5 = r27
            r0 = 5
            r18 = 1048575(0xfffff, float:1.469367E-39)
            if (r7 != r0) goto L_0x029e
            float r0 = com.google.android.gms.internal.vision.cr.d(r12, r3)
            com.google.android.gms.internal.vision.hg.a((java.lang.Object) r14, (long) r5, (float) r0)
        L_0x029b:
            int r0 = r3 + 4
            goto L_0x02b9
        L_0x029e:
            r2 = 1
            goto L_0x02c6
        L_0x02a0:
            r13 = r0
            r11 = r2
            r23 = r6
            r36 = r8
            r8 = r18
            r5 = r27
            r2 = 1
            r18 = 1048575(0xfffff, float:1.469367E-39)
            if (r7 != r2) goto L_0x02c6
            double r0 = com.google.android.gms.internal.vision.cr.c(r12, r3)
            com.google.android.gms.internal.vision.hg.a((java.lang.Object) r14, (long) r5, (double) r0)
            int r0 = r3 + 8
        L_0x02b9:
            r5 = r23 | r24
            r6 = r36
        L_0x02bd:
            r3 = r8
        L_0x02be:
            r2 = r11
            r1 = r13
        L_0x02c0:
            r13 = r37
        L_0x02c2:
            r11 = r38
            goto L_0x0019
        L_0x02c6:
            r22 = r36
            r15 = r38
            r2 = r3
            r6 = r8
            r31 = r10
            r25 = r11
            r26 = r13
            r19 = -1
            r24 = 1
            goto L_0x03d6
        L_0x02d8:
            r23 = r5
            r22 = r6
            r5 = r13
            r8 = r18
            r18 = 1048575(0xfffff, float:1.469367E-39)
            r14 = r34
            r13 = r0
            r0 = r2
            r2 = 27
            if (r11 != r2) goto L_0x033d
            r2 = 2
            if (r7 != r2) goto L_0x032c
            java.lang.Object r1 = r10.getObject(r14, r5)
            com.google.android.gms.internal.vision.eq r1 = (com.google.android.gms.internal.vision.eq) r1
            boolean r2 = r1.a()
            if (r2 != 0) goto L_0x030b
            int r2 = r1.size()
            if (r2 != 0) goto L_0x0302
            r2 = 10
            goto L_0x0304
        L_0x0302:
            int r2 = r2 << 1
        L_0x0304:
            com.google.android.gms.internal.vision.eq r1 = r1.a(r2)
            r10.putObject(r14, r5, r1)
        L_0x030b:
            r5 = r1
            com.google.android.gms.internal.vision.gi r1 = r15.a((int) r0)
            r25 = r0
            r0 = r1
            r1 = r8
            r2 = r35
            r4 = r37
            r6 = r39
            int r0 = com.google.android.gms.internal.vision.cr.a(r0, r1, r2, r3, r4, r5, r6)
            r11 = r38
            r3 = r8
            r1 = r13
            r6 = r22
            r5 = r23
            r2 = r25
            r13 = r37
            goto L_0x0019
        L_0x032c:
            r25 = r0
            r15 = r38
            r14 = r3
            r18 = r8
            r31 = r10
            r26 = r13
            r19 = -1
            r24 = 1
            goto L_0x03b5
        L_0x033d:
            r25 = r0
            r0 = 49
            if (r11 > r0) goto L_0x038b
            long r1 = (long) r1
            r0 = r33
            r26 = r1
            r1 = r34
            r24 = 1
            r2 = r35
            r36 = r3
            r4 = r37
            r29 = r5
            r5 = r8
            r6 = r13
            r18 = r8
            r19 = -1
            r8 = r25
            r31 = r10
            r9 = r26
            r15 = r38
            r26 = r13
            r12 = r29
            r14 = r39
            int r0 = r0.a(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (int) r6, (int) r7, (int) r8, (long) r9, (int) r11, (long) r12, (com.google.android.gms.internal.vision.ct) r14)
            r14 = r36
            if (r0 != r14) goto L_0x0372
            goto L_0x03d4
        L_0x0372:
            r14 = r34
            r12 = r35
            r13 = r37
            r9 = r39
            r11 = r15
            r3 = r18
            r6 = r22
            r5 = r23
            r2 = r25
            r1 = r26
        L_0x0385:
            r10 = r31
            r15 = r33
            goto L_0x0019
        L_0x038b:
            r15 = r38
            r14 = r3
            r29 = r5
            r18 = r8
            r31 = r10
            r26 = r13
            r19 = -1
            r24 = 1
            r0 = 50
            if (r11 != r0) goto L_0x03b9
            r0 = 2
            if (r7 != r0) goto L_0x03b5
            r0 = r33
            r1 = r34
            r2 = r35
            r3 = r14
            r4 = r37
            r5 = r29
            r7 = r39
            int r0 = r0.a(r1, (byte[]) r2, (int) r3, (int) r4, (long) r5, (com.google.android.gms.internal.vision.ct) r7)
            if (r0 != r14) goto L_0x0372
            goto L_0x03d4
        L_0x03b5:
            r2 = r14
        L_0x03b6:
            r6 = r18
            goto L_0x03d6
        L_0x03b9:
            r0 = r33
            r8 = r1
            r1 = r34
            r2 = r35
            r3 = r14
            r4 = r37
            r5 = r18
            r6 = r26
            r9 = r11
            r10 = r29
            r12 = r25
            r13 = r39
            int r0 = r0.a(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (int) r6, (int) r7, (int) r8, (int) r9, (long) r10, (int) r12, (com.google.android.gms.internal.vision.ct) r13)
            if (r0 != r14) goto L_0x069a
        L_0x03d4:
            r2 = r0
            goto L_0x03b6
        L_0x03d6:
            if (r6 != r15) goto L_0x03ec
            if (r15 != 0) goto L_0x03db
            goto L_0x03ec
        L_0x03db:
            r7 = r33
            r12 = r34
            r3 = r6
            r8 = r15
            r0 = r22
            r1 = r23
            r4 = 1048575(0xfffff, float:1.469367E-39)
            r15 = r37
            goto L_0x06c3
        L_0x03ec:
            r7 = r33
            r8 = r15
            boolean r0 = r7.f11152h
            if (r0 == 0) goto L_0x066d
            r9 = r39
            com.google.android.gms.internal.vision.du r0 = r9.f11020d
            com.google.android.gms.internal.vision.du r1 = com.google.android.gms.internal.vision.du.a()
            if (r0 == r1) goto L_0x0666
            com.google.android.gms.internal.vision.ft r0 = r7.f11151g
            com.google.android.gms.internal.vision.ha<?, ?> r1 = r7.q
            com.google.android.gms.internal.vision.du r3 = r9.f11020d
            r10 = r26
            com.google.android.gms.internal.vision.ej$f r11 = r3.a(r0, r10)
            if (r11 != 0) goto L_0x0422
            com.google.android.gms.internal.vision.hd r4 = e((java.lang.Object) r34)
            r0 = r6
            r1 = r35
            r3 = r37
            r5 = r39
            int r0 = com.google.android.gms.internal.vision.cr.a((int) r0, (byte[]) r1, (int) r2, (int) r3, (com.google.android.gms.internal.vision.hd) r4, (com.google.android.gms.internal.vision.ct) r5)
            r12 = r34
            r14 = r35
            r15 = r37
            goto L_0x0686
        L_0x0422:
            r12 = r34
            r0 = r12
            com.google.android.gms.internal.vision.ej$d r0 = (com.google.android.gms.internal.vision.ej.d) r0
            r0.a()
            com.google.android.gms.internal.vision.dz<com.google.android.gms.internal.vision.ej$c> r13 = r0.zzwq
            com.google.android.gms.internal.vision.ej$c r3 = r11.f11110b
            boolean r3 = r3.f11098d
            if (r3 == 0) goto L_0x050a
            com.google.android.gms.internal.vision.ej$c r3 = r11.f11110b
            boolean r3 = r3.f11099e
            if (r3 == 0) goto L_0x050a
            int[] r3 = com.google.android.gms.internal.vision.cu.f11021a
            com.google.android.gms.internal.vision.ej$c r4 = r11.f11110b
            com.google.android.gms.internal.vision.hs r4 = r4.f11097c
            int r4 = r4.ordinal()
            r3 = r3[r4]
            switch(r3) {
                case 1: goto L_0x04fa;
                case 2: goto L_0x04ee;
                case 3: goto L_0x04e2;
                case 4: goto L_0x04e2;
                case 5: goto L_0x04d6;
                case 6: goto L_0x04d6;
                case 7: goto L_0x04ca;
                case 8: goto L_0x04ca;
                case 9: goto L_0x04be;
                case 10: goto L_0x04be;
                case 11: goto L_0x04b2;
                case 12: goto L_0x04a6;
                case 13: goto L_0x049a;
                case 14: goto L_0x0470;
                default: goto L_0x0447;
            }
        L_0x0447:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            com.google.android.gms.internal.vision.ej$c r1 = r11.f11110b
            com.google.android.gms.internal.vision.hs r1 = r1.f11097c
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.String r2 = java.lang.String.valueOf(r1)
            int r2 = r2.length()
            int r2 = r2 + 23
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r2)
            java.lang.String r2 = "Type cannot be packed: "
            r3.append(r2)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r0.<init>(r1)
            throw r0
        L_0x0470:
            com.google.android.gms.internal.vision.el r3 = new com.google.android.gms.internal.vision.el
            r3.<init>()
            r14 = r35
            int r2 = com.google.android.gms.internal.vision.cr.a((byte[]) r14, (int) r2, (com.google.android.gms.internal.vision.eq<?>) r3, (com.google.android.gms.internal.vision.ct) r9)
            com.google.android.gms.internal.vision.hd r4 = r0.zzwj
            com.google.android.gms.internal.vision.hd r5 = com.google.android.gms.internal.vision.hd.a()
            if (r4 != r5) goto L_0x0485
            r4 = r17
        L_0x0485:
            com.google.android.gms.internal.vision.ej$c r5 = r11.f11110b
            com.google.android.gms.internal.vision.em<?> r5 = r5.f11095a
            java.lang.Object r1 = com.google.android.gms.internal.vision.gk.a((int) r10, (java.util.List<java.lang.Integer>) r3, (com.google.android.gms.internal.vision.em<?>) r5, r4, r1)
            com.google.android.gms.internal.vision.hd r1 = (com.google.android.gms.internal.vision.hd) r1
            if (r1 == 0) goto L_0x0493
            r0.zzwj = r1
        L_0x0493:
            com.google.android.gms.internal.vision.ej$c r0 = r11.f11110b
            r13.a(r0, (java.lang.Object) r3)
            goto L_0x0537
        L_0x049a:
            r14 = r35
            com.google.android.gms.internal.vision.fg r0 = new com.google.android.gms.internal.vision.fg
            r0.<init>()
            int r1 = com.google.android.gms.internal.vision.cr.i(r14, r2, r0, r9)
            goto L_0x0505
        L_0x04a6:
            r14 = r35
            com.google.android.gms.internal.vision.el r0 = new com.google.android.gms.internal.vision.el
            r0.<init>()
            int r1 = com.google.android.gms.internal.vision.cr.h(r14, r2, r0, r9)
            goto L_0x0505
        L_0x04b2:
            r14 = r35
            com.google.android.gms.internal.vision.cx r0 = new com.google.android.gms.internal.vision.cx
            r0.<init>()
            int r1 = com.google.android.gms.internal.vision.cr.g(r14, r2, r0, r9)
            goto L_0x0505
        L_0x04be:
            r14 = r35
            com.google.android.gms.internal.vision.el r0 = new com.google.android.gms.internal.vision.el
            r0.<init>()
            int r1 = com.google.android.gms.internal.vision.cr.c(r14, r2, r0, r9)
            goto L_0x0505
        L_0x04ca:
            r14 = r35
            com.google.android.gms.internal.vision.fg r0 = new com.google.android.gms.internal.vision.fg
            r0.<init>()
            int r1 = com.google.android.gms.internal.vision.cr.d(r14, r2, r0, r9)
            goto L_0x0505
        L_0x04d6:
            r14 = r35
            com.google.android.gms.internal.vision.el r0 = new com.google.android.gms.internal.vision.el
            r0.<init>()
            int r1 = com.google.android.gms.internal.vision.cr.a((byte[]) r14, (int) r2, (com.google.android.gms.internal.vision.eq<?>) r0, (com.google.android.gms.internal.vision.ct) r9)
            goto L_0x0505
        L_0x04e2:
            r14 = r35
            com.google.android.gms.internal.vision.fg r0 = new com.google.android.gms.internal.vision.fg
            r0.<init>()
            int r1 = com.google.android.gms.internal.vision.cr.b(r14, r2, r0, r9)
            goto L_0x0505
        L_0x04ee:
            r14 = r35
            com.google.android.gms.internal.vision.ef r0 = new com.google.android.gms.internal.vision.ef
            r0.<init>()
            int r1 = com.google.android.gms.internal.vision.cr.e(r14, r2, r0, r9)
            goto L_0x0505
        L_0x04fa:
            r14 = r35
            com.google.android.gms.internal.vision.ds r0 = new com.google.android.gms.internal.vision.ds
            r0.<init>()
            int r1 = com.google.android.gms.internal.vision.cr.f(r14, r2, r0, r9)
        L_0x0505:
            r15 = r37
            r2 = r1
            goto L_0x065f
        L_0x050a:
            r14 = r35
            com.google.android.gms.internal.vision.ej$c r3 = r11.f11110b
            com.google.android.gms.internal.vision.hs r3 = r3.f11097c
            com.google.android.gms.internal.vision.hs r4 = com.google.android.gms.internal.vision.hs.ENUM
            if (r3 != r4) goto L_0x0542
            int r2 = com.google.android.gms.internal.vision.cr.a(r14, r2, r9)
            com.google.android.gms.internal.vision.ej$c r3 = r11.f11110b
            com.google.android.gms.internal.vision.em<?> r3 = r3.f11095a
            int r4 = r9.f11017a
            com.google.android.gms.internal.vision.en r3 = r3.a(r4)
            if (r3 != 0) goto L_0x053b
            com.google.android.gms.internal.vision.hd r3 = r0.zzwj
            com.google.android.gms.internal.vision.hd r4 = com.google.android.gms.internal.vision.hd.a()
            if (r3 != r4) goto L_0x0532
            com.google.android.gms.internal.vision.hd r3 = com.google.android.gms.internal.vision.hd.b()
            r0.zzwj = r3
        L_0x0532:
            int r0 = r9.f11017a
            com.google.android.gms.internal.vision.gk.a((int) r10, (int) r0, r3, r1)
        L_0x0537:
            r15 = r37
            goto L_0x0664
        L_0x053b:
            int r0 = r9.f11017a
            java.lang.Integer r17 = java.lang.Integer.valueOf(r0)
            goto L_0x0551
        L_0x0542:
            int[] r0 = com.google.android.gms.internal.vision.cu.f11021a
            com.google.android.gms.internal.vision.ej$c r1 = r11.f11110b
            com.google.android.gms.internal.vision.hs r1 = r1.f11097c
            int r1 = r1.ordinal()
            r0 = r0[r1]
            switch(r0) {
                case 1: goto L_0x0624;
                case 2: goto L_0x0616;
                case 3: goto L_0x0608;
                case 4: goto L_0x0608;
                case 5: goto L_0x05fa;
                case 6: goto L_0x05fa;
                case 7: goto L_0x05ef;
                case 8: goto L_0x05ef;
                case 9: goto L_0x05e4;
                case 10: goto L_0x05e4;
                case 11: goto L_0x05cf;
                case 12: goto L_0x05be;
                case 13: goto L_0x05ad;
                case 14: goto L_0x05a5;
                case 15: goto L_0x059b;
                case 16: goto L_0x0591;
                case 17: goto L_0x056f;
                case 18: goto L_0x0557;
                default: goto L_0x0551;
            }
        L_0x0551:
            r15 = r37
        L_0x0553:
            r0 = r17
            goto L_0x0632
        L_0x0557:
            com.google.android.gms.internal.vision.ge r0 = com.google.android.gms.internal.vision.ge.a()
            com.google.android.gms.internal.vision.ft r1 = r11.f11109a
            java.lang.Class r1 = r1.getClass()
            com.google.android.gms.internal.vision.gi r0 = r0.a(r1)
            r15 = r37
            int r2 = com.google.android.gms.internal.vision.cr.a((com.google.android.gms.internal.vision.gi) r0, (byte[]) r14, (int) r2, (int) r15, (com.google.android.gms.internal.vision.ct) r9)
            java.lang.Object r0 = r9.f11019c
            goto L_0x0632
        L_0x056f:
            r15 = r37
            int r0 = r10 << 3
            r4 = r0 | 4
            com.google.android.gms.internal.vision.ge r0 = com.google.android.gms.internal.vision.ge.a()
            com.google.android.gms.internal.vision.ft r1 = r11.f11109a
            java.lang.Class r1 = r1.getClass()
            com.google.android.gms.internal.vision.gi r0 = r0.a(r1)
            r1 = r35
            r3 = r37
            r5 = r39
            int r2 = com.google.android.gms.internal.vision.cr.a((com.google.android.gms.internal.vision.gi) r0, (byte[]) r1, (int) r2, (int) r3, (int) r4, (com.google.android.gms.internal.vision.ct) r5)
            java.lang.Object r0 = r9.f11019c
            goto L_0x0632
        L_0x0591:
            r15 = r37
            int r2 = com.google.android.gms.internal.vision.cr.c(r14, r2, r9)
            java.lang.Object r0 = r9.f11019c
            goto L_0x0632
        L_0x059b:
            r15 = r37
            int r2 = com.google.android.gms.internal.vision.cr.e(r14, r2, r9)
            java.lang.Object r0 = r9.f11019c
            goto L_0x0632
        L_0x05a5:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Shouldn't reach here."
            r0.<init>(r1)
            throw r0
        L_0x05ad:
            r15 = r37
            int r2 = com.google.android.gms.internal.vision.cr.b(r14, r2, r9)
            long r0 = r9.f11018b
            long r0 = com.google.android.gms.internal.vision.dl.a((long) r0)
            java.lang.Long r17 = java.lang.Long.valueOf(r0)
            goto L_0x0553
        L_0x05be:
            r15 = r37
            int r2 = com.google.android.gms.internal.vision.cr.a(r14, r2, r9)
            int r0 = r9.f11017a
            int r0 = com.google.android.gms.internal.vision.dl.e(r0)
            java.lang.Integer r17 = java.lang.Integer.valueOf(r0)
            goto L_0x0553
        L_0x05cf:
            r15 = r37
            int r2 = com.google.android.gms.internal.vision.cr.b(r14, r2, r9)
            long r0 = r9.f11018b
            int r3 = (r0 > r20 ? 1 : (r0 == r20 ? 0 : -1))
            if (r3 == 0) goto L_0x05dc
            goto L_0x05de
        L_0x05dc:
            r24 = 0
        L_0x05de:
            java.lang.Boolean r17 = java.lang.Boolean.valueOf(r24)
            goto L_0x0553
        L_0x05e4:
            r15 = r37
            int r0 = com.google.android.gms.internal.vision.cr.a(r14, r2)
            java.lang.Integer r17 = java.lang.Integer.valueOf(r0)
            goto L_0x0620
        L_0x05ef:
            r15 = r37
            long r0 = com.google.android.gms.internal.vision.cr.b(r14, r2)
            java.lang.Long r17 = java.lang.Long.valueOf(r0)
            goto L_0x062e
        L_0x05fa:
            r15 = r37
            int r2 = com.google.android.gms.internal.vision.cr.a(r14, r2, r9)
            int r0 = r9.f11017a
            java.lang.Integer r17 = java.lang.Integer.valueOf(r0)
            goto L_0x0553
        L_0x0608:
            r15 = r37
            int r2 = com.google.android.gms.internal.vision.cr.b(r14, r2, r9)
            long r0 = r9.f11018b
            java.lang.Long r17 = java.lang.Long.valueOf(r0)
            goto L_0x0553
        L_0x0616:
            r15 = r37
            float r0 = com.google.android.gms.internal.vision.cr.d(r14, r2)
            java.lang.Float r17 = java.lang.Float.valueOf(r0)
        L_0x0620:
            int r2 = r2 + 4
            goto L_0x0553
        L_0x0624:
            r15 = r37
            double r0 = com.google.android.gms.internal.vision.cr.c(r14, r2)
            java.lang.Double r17 = java.lang.Double.valueOf(r0)
        L_0x062e:
            int r2 = r2 + 8
            goto L_0x0553
        L_0x0632:
            com.google.android.gms.internal.vision.ej$c r1 = r11.f11110b
            boolean r1 = r1.f11098d
            if (r1 == 0) goto L_0x063e
            com.google.android.gms.internal.vision.ej$c r1 = r11.f11110b
            r13.b(r1, (java.lang.Object) r0)
            goto L_0x0664
        L_0x063e:
            int[] r1 = com.google.android.gms.internal.vision.cu.f11021a
            com.google.android.gms.internal.vision.ej$c r3 = r11.f11110b
            com.google.android.gms.internal.vision.hs r3 = r3.f11097c
            int r3 = r3.ordinal()
            r1 = r1[r3]
            r3 = 17
            if (r1 == r3) goto L_0x0653
            r3 = 18
            if (r1 == r3) goto L_0x0653
            goto L_0x065f
        L_0x0653:
            com.google.android.gms.internal.vision.ej$c r1 = r11.f11110b
            java.lang.Object r1 = r13.a(r1)
            if (r1 == 0) goto L_0x065f
            java.lang.Object r0 = com.google.android.gms.internal.vision.ek.a((java.lang.Object) r1, (java.lang.Object) r0)
        L_0x065f:
            com.google.android.gms.internal.vision.ej$c r1 = r11.f11110b
            r13.a(r1, (java.lang.Object) r0)
        L_0x0664:
            r0 = r2
            goto L_0x0686
        L_0x0666:
            r12 = r34
            r14 = r35
            r15 = r37
            goto L_0x0675
        L_0x066d:
            r12 = r34
            r14 = r35
            r15 = r37
            r9 = r39
        L_0x0675:
            r10 = r26
            com.google.android.gms.internal.vision.hd r4 = e((java.lang.Object) r34)
            r0 = r6
            r1 = r35
            r3 = r37
            r5 = r39
            int r0 = com.google.android.gms.internal.vision.cr.a((int) r0, (byte[]) r1, (int) r2, (int) r3, (com.google.android.gms.internal.vision.hd) r4, (com.google.android.gms.internal.vision.ct) r5)
        L_0x0686:
            r3 = r6
            r11 = r8
            r1 = r10
            r13 = r15
            r6 = r22
            r5 = r23
            r2 = r25
            r10 = r31
            r15 = r7
            r32 = r14
            r14 = r12
            r12 = r32
            goto L_0x0019
        L_0x069a:
            r6 = r18
            r10 = r26
            r14 = r34
            r12 = r35
            r13 = r37
            r9 = r39
            r3 = r6
            r1 = r10
            r11 = r15
            r6 = r22
            r5 = r23
            r2 = r25
            goto L_0x0385
        L_0x06b1:
            r23 = r5
            r22 = r6
            r31 = r10
            r8 = r11
            r12 = r14
            r7 = r15
            r15 = r13
            r2 = r0
            r0 = r22
            r1 = r23
            r4 = 1048575(0xfffff, float:1.469367E-39)
        L_0x06c3:
            if (r0 == r4) goto L_0x06cb
            long r4 = (long) r0
            r0 = r31
            r0.putInt(r12, r4, r1)
        L_0x06cb:
            int r0 = r7.m
            r1 = r17
        L_0x06cf:
            int r4 = r7.n
            if (r0 >= r4) goto L_0x06e2
            int[] r4 = r7.l
            r4 = r4[r0]
            com.google.android.gms.internal.vision.ha<?, ?> r5 = r7.q
            java.lang.Object r1 = r7.a(r12, r4, r1, r5)
            com.google.android.gms.internal.vision.hd r1 = (com.google.android.gms.internal.vision.hd) r1
            int r0 = r0 + 1
            goto L_0x06cf
        L_0x06e2:
            if (r1 == 0) goto L_0x06e9
            com.google.android.gms.internal.vision.ha<?, ?> r0 = r7.q
            r0.b((java.lang.Object) r12, r1)
        L_0x06e9:
            if (r8 != 0) goto L_0x06f3
            if (r2 != r15) goto L_0x06ee
            goto L_0x06f7
        L_0x06ee:
            com.google.android.gms.internal.vision.eu r0 = com.google.android.gms.internal.vision.eu.zzgs()
            throw r0
        L_0x06f3:
            if (r2 > r15) goto L_0x06f8
            if (r3 != r8) goto L_0x06f8
        L_0x06f7:
            return r2
        L_0x06f8:
            com.google.android.gms.internal.vision.eu r0 = com.google.android.gms.internal.vision.eu.zzgs()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.fx.a(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.vision.ct):int");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v9, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v5, resolved type: byte} */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x0345, code lost:
        if (r0 == r15) goto L_0x036a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x0368, code lost:
        if (r0 == r15) goto L_0x036a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x036a, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x01de, code lost:
        r5 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0251, code lost:
        r6 = r6 | r23;
        r2 = r7;
        r9 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0257, code lost:
        r2 = r5;
        r29 = r10;
        r30 = r20;
        r20 = r7;
        r7 = r30;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x02fe, code lost:
        if (r0 == r15) goto L_0x036a;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(T r32, byte[] r33, int r34, int r35, com.google.android.gms.internal.vision.ct r36) throws java.io.IOException {
        /*
            r31 = this;
            r15 = r31
            r14 = r32
            r12 = r33
            r13 = r35
            r11 = r36
            boolean r0 = r15.j
            if (r0 == 0) goto L_0x03af
            sun.misc.Unsafe r9 = f11146b
            r10 = -1
            r16 = 0
            r8 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r34
            r1 = -1
            r2 = 0
            r6 = 0
            r7 = 1048575(0xfffff, float:1.469367E-39)
        L_0x001e:
            if (r0 >= r13) goto L_0x0392
            int r3 = r0 + 1
            byte r0 = r12[r0]
            if (r0 >= 0) goto L_0x0030
            int r0 = com.google.android.gms.internal.vision.cr.a((int) r0, (byte[]) r12, (int) r3, (com.google.android.gms.internal.vision.ct) r11)
            int r3 = r11.f11017a
            r4 = r0
            r17 = r3
            goto L_0x0033
        L_0x0030:
            r17 = r0
            r4 = r3
        L_0x0033:
            int r5 = r17 >>> 3
            r3 = r17 & 7
            if (r5 <= r1) goto L_0x0040
            int r2 = r2 / 3
            int r0 = r15.a((int) r5, (int) r2)
            goto L_0x0044
        L_0x0040:
            int r0 = r15.f(r5)
        L_0x0044:
            r2 = r0
            if (r2 != r10) goto L_0x0052
            r2 = r4
            r25 = r5
            r29 = r9
            r19 = -1
            r20 = 0
            goto L_0x036c
        L_0x0052:
            int[] r0 = r15.f11147c
            int r1 = r2 + 1
            r1 = r0[r1]
            r18 = 267386880(0xff00000, float:2.3665827E-29)
            r18 = r1 & r18
            int r10 = r18 >>> 20
            r34 = r5
            r5 = r1 & r8
            r18 = r9
            long r8 = (long) r5
            r5 = 17
            r21 = r1
            if (r10 > r5) goto L_0x0264
            int r5 = r2 + 2
            r0 = r0[r5]
            int r5 = r0 >>> 20
            r1 = 1
            int r23 = r1 << r5
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r5
            r20 = r2
            if (r0 == r7) goto L_0x0092
            if (r7 == r5) goto L_0x0085
            long r1 = (long) r7
            r7 = r18
            r7.putInt(r14, r1, r6)
            goto L_0x0087
        L_0x0085:
            r7 = r18
        L_0x0087:
            if (r0 == r5) goto L_0x008f
            long r1 = (long) r0
            int r1 = r7.getInt(r14, r1)
            r6 = r1
        L_0x008f:
            r2 = r7
            r7 = r0
            goto L_0x0094
        L_0x0092:
            r2 = r18
        L_0x0094:
            r0 = 5
            switch(r10) {
                case 0: goto L_0x0238;
                case 1: goto L_0x021f;
                case 2: goto L_0x01fb;
                case 3: goto L_0x01fb;
                case 4: goto L_0x01e1;
                case 5: goto L_0x01bd;
                case 6: goto L_0x01a4;
                case 7: goto L_0x0182;
                case 8: goto L_0x015d;
                case 9: goto L_0x012e;
                case 10: goto L_0x0114;
                case 11: goto L_0x01e1;
                case 12: goto L_0x00fb;
                case 13: goto L_0x01a4;
                case 14: goto L_0x01bd;
                case 15: goto L_0x00de;
                case 16: goto L_0x00a7;
                default: goto L_0x0098;
            }
        L_0x0098:
            r25 = r34
            r10 = r2
            r5 = r4
            r26 = 1048575(0xfffff, float:1.469367E-39)
            r30 = r20
            r20 = r7
            r7 = r30
            goto L_0x0257
        L_0x00a7:
            if (r3 != 0) goto L_0x00d0
            int r10 = com.google.android.gms.internal.vision.cr.b(r12, r4, r11)
            long r0 = r11.f11018b
            long r17 = com.google.android.gms.internal.vision.dl.a((long) r0)
            r0 = r2
            r1 = r32
            r4 = r2
            r30 = r20
            r20 = r7
            r7 = r30
            r2 = r8
            r25 = r34
            r8 = r4
            r26 = 1048575(0xfffff, float:1.469367E-39)
            r4 = r17
            r0.putLong(r1, r2, r4)
            r6 = r6 | r23
            r2 = r7
            r9 = r8
            r0 = r10
            goto L_0x02ae
        L_0x00d0:
            r25 = r34
            r26 = 1048575(0xfffff, float:1.469367E-39)
            r30 = r20
            r20 = r7
            r7 = r30
            r10 = r2
            goto L_0x01de
        L_0x00de:
            r25 = r34
            r10 = r2
            r26 = 1048575(0xfffff, float:1.469367E-39)
            r30 = r20
            r20 = r7
            r7 = r30
            if (r3 != 0) goto L_0x01de
            int r0 = com.google.android.gms.internal.vision.cr.a(r12, r4, r11)
            int r1 = r11.f11017a
            int r1 = com.google.android.gms.internal.vision.dl.e(r1)
            r10.putInt(r14, r8, r1)
            goto L_0x0251
        L_0x00fb:
            r25 = r34
            r10 = r2
            r26 = 1048575(0xfffff, float:1.469367E-39)
            r30 = r20
            r20 = r7
            r7 = r30
            if (r3 != 0) goto L_0x01de
            int r0 = com.google.android.gms.internal.vision.cr.a(r12, r4, r11)
            int r1 = r11.f11017a
            r10.putInt(r14, r8, r1)
            goto L_0x0251
        L_0x0114:
            r25 = r34
            r10 = r2
            r0 = 2
            r26 = 1048575(0xfffff, float:1.469367E-39)
            r30 = r20
            r20 = r7
            r7 = r30
            if (r3 != r0) goto L_0x01de
            int r0 = com.google.android.gms.internal.vision.cr.e(r12, r4, r11)
            java.lang.Object r1 = r11.f11019c
            r10.putObject(r14, r8, r1)
            goto L_0x0251
        L_0x012e:
            r25 = r34
            r10 = r2
            r0 = 2
            r26 = 1048575(0xfffff, float:1.469367E-39)
            r30 = r20
            r20 = r7
            r7 = r30
            if (r3 != r0) goto L_0x01de
            com.google.android.gms.internal.vision.gi r0 = r15.a((int) r7)
            int r0 = com.google.android.gms.internal.vision.cr.a((com.google.android.gms.internal.vision.gi) r0, (byte[]) r12, (int) r4, (int) r13, (com.google.android.gms.internal.vision.ct) r11)
            java.lang.Object r1 = r10.getObject(r14, r8)
            if (r1 != 0) goto L_0x0152
            java.lang.Object r1 = r11.f11019c
            r10.putObject(r14, r8, r1)
            goto L_0x0251
        L_0x0152:
            java.lang.Object r2 = r11.f11019c
            java.lang.Object r1 = com.google.android.gms.internal.vision.ek.a((java.lang.Object) r1, (java.lang.Object) r2)
            r10.putObject(r14, r8, r1)
            goto L_0x0251
        L_0x015d:
            r25 = r34
            r10 = r2
            r0 = 2
            r26 = 1048575(0xfffff, float:1.469367E-39)
            r30 = r20
            r20 = r7
            r7 = r30
            if (r3 != r0) goto L_0x01de
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            r0 = r21 & r0
            if (r0 != 0) goto L_0x0177
            int r0 = com.google.android.gms.internal.vision.cr.c(r12, r4, r11)
            goto L_0x017b
        L_0x0177:
            int r0 = com.google.android.gms.internal.vision.cr.d(r12, r4, r11)
        L_0x017b:
            java.lang.Object r1 = r11.f11019c
            r10.putObject(r14, r8, r1)
            goto L_0x0251
        L_0x0182:
            r25 = r34
            r10 = r2
            r26 = 1048575(0xfffff, float:1.469367E-39)
            r30 = r20
            r20 = r7
            r7 = r30
            if (r3 != 0) goto L_0x01de
            int r0 = com.google.android.gms.internal.vision.cr.b(r12, r4, r11)
            long r1 = r11.f11018b
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x019e
            r1 = 1
            goto L_0x019f
        L_0x019e:
            r1 = 0
        L_0x019f:
            com.google.android.gms.internal.vision.hg.a((java.lang.Object) r14, (long) r8, (boolean) r1)
            goto L_0x0251
        L_0x01a4:
            r25 = r34
            r10 = r2
            r26 = 1048575(0xfffff, float:1.469367E-39)
            r30 = r20
            r20 = r7
            r7 = r30
            if (r3 != r0) goto L_0x01de
            int r0 = com.google.android.gms.internal.vision.cr.a(r12, r4)
            r10.putInt(r14, r8, r0)
            int r0 = r4 + 4
            goto L_0x0251
        L_0x01bd:
            r25 = r34
            r10 = r2
            r0 = 1
            r26 = 1048575(0xfffff, float:1.469367E-39)
            r30 = r20
            r20 = r7
            r7 = r30
            if (r3 != r0) goto L_0x01de
            long r17 = com.google.android.gms.internal.vision.cr.b(r12, r4)
            r0 = r10
            r1 = r32
            r2 = r8
            r8 = r4
            r4 = r17
            r0.putLong(r1, r2, r4)
            int r0 = r8 + 8
            goto L_0x0251
        L_0x01de:
            r5 = r4
            goto L_0x0257
        L_0x01e1:
            r25 = r34
            r10 = r2
            r5 = r4
            r26 = 1048575(0xfffff, float:1.469367E-39)
            r30 = r20
            r20 = r7
            r7 = r30
            if (r3 != 0) goto L_0x0257
            int r0 = com.google.android.gms.internal.vision.cr.a(r12, r5, r11)
            int r1 = r11.f11017a
            r10.putInt(r14, r8, r1)
            goto L_0x0251
        L_0x01fb:
            r25 = r34
            r10 = r2
            r5 = r4
            r26 = 1048575(0xfffff, float:1.469367E-39)
            r30 = r20
            r20 = r7
            r7 = r30
            if (r3 != 0) goto L_0x0257
            int r17 = com.google.android.gms.internal.vision.cr.b(r12, r5, r11)
            long r4 = r11.f11018b
            r0 = r10
            r1 = r32
            r2 = r8
            r0.putLong(r1, r2, r4)
            r6 = r6 | r23
            r2 = r7
            r9 = r10
            r0 = r17
            goto L_0x02ae
        L_0x021f:
            r25 = r34
            r10 = r2
            r5 = r4
            r26 = 1048575(0xfffff, float:1.469367E-39)
            r30 = r20
            r20 = r7
            r7 = r30
            if (r3 != r0) goto L_0x0257
            float r0 = com.google.android.gms.internal.vision.cr.d(r12, r5)
            com.google.android.gms.internal.vision.hg.a((java.lang.Object) r14, (long) r8, (float) r0)
            int r0 = r5 + 4
            goto L_0x0251
        L_0x0238:
            r25 = r34
            r10 = r2
            r5 = r4
            r0 = 1
            r26 = 1048575(0xfffff, float:1.469367E-39)
            r30 = r20
            r20 = r7
            r7 = r30
            if (r3 != r0) goto L_0x0257
            double r0 = com.google.android.gms.internal.vision.cr.c(r12, r5)
            com.google.android.gms.internal.vision.hg.a((java.lang.Object) r14, (long) r8, (double) r0)
            int r0 = r5 + 8
        L_0x0251:
            r6 = r6 | r23
            r2 = r7
            r9 = r10
            goto L_0x02ae
        L_0x0257:
            r2 = r5
            r29 = r10
            r19 = -1
            r30 = r20
            r20 = r7
            r7 = r30
            goto L_0x036c
        L_0x0264:
            r25 = r34
            r5 = r4
            r20 = r7
            r4 = r18
            r26 = 1048575(0xfffff, float:1.469367E-39)
            r7 = r2
            r0 = 27
            if (r10 != r0) goto L_0x02c1
            r0 = 2
            if (r3 != r0) goto L_0x02b4
            java.lang.Object r0 = r4.getObject(r14, r8)
            com.google.android.gms.internal.vision.eq r0 = (com.google.android.gms.internal.vision.eq) r0
            boolean r1 = r0.a()
            if (r1 != 0) goto L_0x0294
            int r1 = r0.size()
            if (r1 != 0) goto L_0x028b
            r1 = 10
            goto L_0x028d
        L_0x028b:
            int r1 = r1 << 1
        L_0x028d:
            com.google.android.gms.internal.vision.eq r0 = r0.a(r1)
            r4.putObject(r14, r8, r0)
        L_0x0294:
            r8 = r0
            com.google.android.gms.internal.vision.gi r0 = r15.a((int) r7)
            r1 = r17
            r2 = r33
            r3 = r5
            r18 = r4
            r4 = r35
            r5 = r8
            r8 = r6
            r6 = r36
            int r0 = com.google.android.gms.internal.vision.cr.a(r0, r1, r2, r3, r4, r5, r6)
            r2 = r7
            r6 = r8
            r9 = r18
        L_0x02ae:
            r7 = r20
            r1 = r25
            goto L_0x038c
        L_0x02b4:
            r29 = r4
            r15 = r5
            r27 = r6
            r28 = r20
            r19 = -1
            r20 = r7
            goto L_0x0348
        L_0x02c1:
            r18 = r4
            r0 = 49
            if (r10 > r0) goto L_0x0316
            r1 = r21
            long r1 = (long) r1
            r0 = r31
            r21 = r1
            r1 = r32
            r2 = r33
            r4 = r3
            r3 = r5
            r34 = r4
            r4 = r35
            r15 = r5
            r5 = r17
            r27 = r6
            r6 = r25
            r28 = r20
            r20 = r7
            r7 = r34
            r23 = r8
            r9 = 1048575(0xfffff, float:1.469367E-39)
            r8 = r20
            r29 = r18
            r19 = -1
            r18 = r10
            r9 = r21
            r11 = r18
            r12 = r23
            r14 = r36
            int r0 = r0.a(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (int) r6, (int) r7, (int) r8, (long) r9, (int) r11, (long) r12, (com.google.android.gms.internal.vision.ct) r14)
            if (r0 != r15) goto L_0x0302
            goto L_0x036a
        L_0x0302:
            r15 = r31
            r14 = r32
            r12 = r33
            r13 = r35
            r11 = r36
            r2 = r20
            r1 = r25
            r6 = r27
            r7 = r28
            goto L_0x038a
        L_0x0316:
            r34 = r3
            r15 = r5
            r27 = r6
            r23 = r8
            r29 = r18
            r28 = r20
            r1 = r21
            r19 = -1
            r20 = r7
            r18 = r10
            r0 = 50
            r9 = r18
            if (r9 != r0) goto L_0x034e
            r7 = r34
            r0 = 2
            if (r7 != r0) goto L_0x0348
            r0 = r31
            r1 = r32
            r2 = r33
            r3 = r15
            r4 = r35
            r5 = r23
            r7 = r36
            int r0 = r0.a(r1, (byte[]) r2, (int) r3, (int) r4, (long) r5, (com.google.android.gms.internal.vision.ct) r7)
            if (r0 != r15) goto L_0x0302
            goto L_0x036a
        L_0x0348:
            r2 = r15
        L_0x0349:
            r6 = r27
            r7 = r28
            goto L_0x036c
        L_0x034e:
            r7 = r34
            r0 = r31
            r8 = r1
            r1 = r32
            r2 = r33
            r3 = r15
            r4 = r35
            r5 = r17
            r6 = r25
            r10 = r23
            r12 = r20
            r13 = r36
            int r0 = r0.a(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (int) r6, (int) r7, (int) r8, (int) r9, (long) r10, (int) r12, (com.google.android.gms.internal.vision.ct) r13)
            if (r0 != r15) goto L_0x0302
        L_0x036a:
            r2 = r0
            goto L_0x0349
        L_0x036c:
            com.google.android.gms.internal.vision.hd r4 = e((java.lang.Object) r32)
            r0 = r17
            r1 = r33
            r3 = r35
            r5 = r36
            int r0 = com.google.android.gms.internal.vision.cr.a((int) r0, (byte[]) r1, (int) r2, (int) r3, (com.google.android.gms.internal.vision.hd) r4, (com.google.android.gms.internal.vision.ct) r5)
            r15 = r31
            r14 = r32
            r12 = r33
            r13 = r35
            r11 = r36
            r2 = r20
            r1 = r25
        L_0x038a:
            r9 = r29
        L_0x038c:
            r8 = 1048575(0xfffff, float:1.469367E-39)
            r10 = -1
            goto L_0x001e
        L_0x0392:
            r27 = r6
            r29 = r9
            r1 = 1048575(0xfffff, float:1.469367E-39)
            if (r7 == r1) goto L_0x03a5
            long r1 = (long) r7
            r3 = r32
            r6 = r27
            r4 = r29
            r4.putInt(r3, r1, r6)
        L_0x03a5:
            r4 = r35
            if (r0 != r4) goto L_0x03aa
            return
        L_0x03aa:
            com.google.android.gms.internal.vision.eu r0 = com.google.android.gms.internal.vision.eu.zzgs()
            throw r0
        L_0x03af:
            r4 = r13
            r3 = r14
            r5 = 0
            r0 = r31
            r1 = r32
            r2 = r33
            r3 = r34
            r4 = r35
            r6 = r36
            r0.a(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (com.google.android.gms.internal.vision.ct) r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.fx.a(java.lang.Object, byte[], int, int, com.google.android.gms.internal.vision.ct):void");
    }

    public final void c(T t) {
        int i2;
        int i3 = this.m;
        while (true) {
            i2 = this.n;
            if (i3 >= i2) {
                break;
            }
            long c2 = (long) (c(this.l[i3]) & 1048575);
            Object f2 = hg.f(t, c2);
            if (f2 != null) {
                hg.a((Object) t, c2, this.s.d(f2));
            }
            i3++;
        }
        int length = this.l.length;
        while (i2 < length) {
            this.p.b(t, (long) this.l[i2]);
            i2++;
        }
        this.q.d(t);
        if (this.f11152h) {
            this.r.c(t);
        }
    }

    private final <UT, UB> UB a(Object obj, int i2, UB ub, ha<UT, UB> haVar) {
        ep b2;
        int i3 = this.f11147c[i2];
        Object f2 = hg.f(obj, (long) (c(i2) & 1048575));
        if (f2 == null || (b2 = b(i2)) == null) {
            return ub;
        }
        return a(i3, this.s.a(f2), b2, ub, haVar);
    }

    private final <K, V, UT, UB> UB a(int i2, Map<K, V> map, ep epVar, UB ub, ha<UT, UB> haVar) {
        fj<?, ?> b2 = this.s.b();
        Iterator<Map.Entry<K, V>> it2 = map.entrySet().iterator();
        while (it2.hasNext()) {
            Map.Entry next = it2.next();
            if (!epVar.a(((Integer) next.getValue()).intValue())) {
                if (ub == null) {
                    ub = haVar.a();
                }
                dh zzaq = cz.zzaq(fk.a(b2, next.getKey(), next.getValue()));
                try {
                    fk.a(zzaq.f11036a, b2, next.getKey(), next.getValue());
                    haVar.a(ub, i2, zzaq.a());
                    it2.remove();
                } catch (IOException e2) {
                    throw new RuntimeException(e2);
                }
            }
        }
        return ub;
    }

    public final boolean d(T t) {
        int i2;
        int i3;
        T t2 = t;
        int i4 = 1048575;
        int i5 = 0;
        int i6 = 0;
        while (true) {
            boolean z = true;
            if (i6 >= this.m) {
                return !this.f11152h || this.r.a((Object) t2).d();
            }
            int i7 = this.l[i6];
            int i8 = this.f11147c[i7];
            int c2 = c(i7);
            int i9 = this.f11147c[i7 + 2];
            int i10 = i9 & 1048575;
            int i11 = 1 << (i9 >>> 20);
            if (i10 != i4) {
                i2 = i10 != 1048575 ? f11146b.getInt(t2, (long) i10) : i5;
                i3 = i10;
            } else {
                i3 = i4;
                i2 = i5;
            }
            if (((268435456 & c2) != 0) && !a(t, i7, i3, i2, i11)) {
                return false;
            }
            int i12 = (267386880 & c2) >>> 20;
            if (i12 != 9 && i12 != 17) {
                if (i12 != 27) {
                    if (i12 == 60 || i12 == 68) {
                        if (a(t2, i8, i7) && !a((Object) t2, c2, a(i7))) {
                            return false;
                        }
                    } else if (i12 != 49) {
                        if (i12 != 50) {
                            continue;
                        } else {
                            Map<?, ?> b2 = this.s.b(hg.f(t2, (long) (c2 & 1048575)));
                            if (!b2.isEmpty() && this.s.b().f11140c.zzip() == hv.MESSAGE) {
                                gi<?> giVar = null;
                                Iterator<?> it2 = b2.values().iterator();
                                while (true) {
                                    if (!it2.hasNext()) {
                                        break;
                                    }
                                    Object next = it2.next();
                                    if (giVar == null) {
                                        giVar = ge.a().a(next.getClass());
                                    }
                                    if (!giVar.d(next)) {
                                        z = false;
                                        break;
                                    }
                                }
                            }
                            if (!z) {
                                return false;
                            }
                        }
                    }
                }
                List list = (List) hg.f(t2, (long) (c2 & 1048575));
                if (!list.isEmpty()) {
                    gi a2 = a(i7);
                    int i13 = 0;
                    while (true) {
                        if (i13 >= list.size()) {
                            break;
                        } else if (!a2.d(list.get(i13))) {
                            z = false;
                            break;
                        } else {
                            i13++;
                        }
                    }
                }
                if (!z) {
                    return false;
                }
            } else if (a(t, i7, i3, i2, i11) && !a((Object) t2, c2, a(i7))) {
                return false;
            }
            i6++;
            i4 = i3;
            i5 = i2;
        }
    }

    private static boolean a(Object obj, int i2, gi giVar) {
        return giVar.d(hg.f(obj, (long) (i2 & 1048575)));
    }

    private static void a(int i2, Object obj, hx hxVar) throws IOException {
        if (obj instanceof String) {
            hxVar.a(i2, (String) obj);
        } else {
            hxVar.a(i2, (cz) obj);
        }
    }

    private final void a(Object obj, int i2, gj gjVar) throws IOException {
        if (e(i2)) {
            hg.a(obj, (long) (i2 & 1048575), (Object) gjVar.m());
        } else if (this.f11153i) {
            hg.a(obj, (long) (i2 & 1048575), (Object) gjVar.l());
        } else {
            hg.a(obj, (long) (i2 & 1048575), (Object) gjVar.n());
        }
    }

    private final int c(int i2) {
        return this.f11147c[i2 + 1];
    }

    private final int d(int i2) {
        return this.f11147c[i2 + 2];
    }

    private static <T> double b(T t, long j2) {
        return ((Double) hg.f(t, j2)).doubleValue();
    }

    private static <T> float c(T t, long j2) {
        return ((Float) hg.f(t, j2)).floatValue();
    }

    private static <T> int d(T t, long j2) {
        return ((Integer) hg.f(t, j2)).intValue();
    }

    private static <T> long e(T t, long j2) {
        return ((Long) hg.f(t, j2)).longValue();
    }

    private static <T> boolean f(T t, long j2) {
        return ((Boolean) hg.f(t, j2)).booleanValue();
    }

    private final boolean c(T t, T t2, int i2) {
        return a(t, i2) == a(t2, i2);
    }

    private final boolean a(T t, int i2, int i3, int i4, int i5) {
        if (i3 == 1048575) {
            return a(t, i2);
        }
        return (i4 & i5) != 0;
    }

    private final boolean a(T t, int i2) {
        int d2 = d(i2);
        long j2 = (long) (d2 & 1048575);
        if (j2 == 1048575) {
            int c2 = c(i2);
            long j3 = (long) (c2 & 1048575);
            switch ((c2 & 267386880) >>> 20) {
                case 0:
                    return hg.e(t, j3) != 0.0d;
                case 1:
                    return hg.d(t, j3) != 0.0f;
                case 2:
                    return hg.b(t, j3) != 0;
                case 3:
                    return hg.b(t, j3) != 0;
                case 4:
                    return hg.a((Object) t, j3) != 0;
                case 5:
                    return hg.b(t, j3) != 0;
                case 6:
                    return hg.a((Object) t, j3) != 0;
                case 7:
                    return hg.c(t, j3);
                case 8:
                    Object f2 = hg.f(t, j3);
                    if (f2 instanceof String) {
                        return !((String) f2).isEmpty();
                    }
                    if (f2 instanceof cz) {
                        return !cz.zzsd.equals(f2);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    return hg.f(t, j3) != null;
                case 10:
                    return !cz.zzsd.equals(hg.f(t, j3));
                case 11:
                    return hg.a((Object) t, j3) != 0;
                case 12:
                    return hg.a((Object) t, j3) != 0;
                case 13:
                    return hg.a((Object) t, j3) != 0;
                case 14:
                    return hg.b(t, j3) != 0;
                case 15:
                    return hg.a((Object) t, j3) != 0;
                case 16:
                    return hg.b(t, j3) != 0;
                case 17:
                    return hg.f(t, j3) != null;
                default:
                    throw new IllegalArgumentException();
            }
        } else {
            return (hg.a((Object) t, j2) & (1 << (d2 >>> 20))) != 0;
        }
    }

    private final void b(T t, int i2) {
        int d2 = d(i2);
        long j2 = (long) (1048575 & d2);
        if (j2 != 1048575) {
            hg.a((Object) t, j2, (1 << (d2 >>> 20)) | hg.a((Object) t, j2));
        }
    }

    private final boolean a(T t, int i2, int i3) {
        return hg.a((Object) t, (long) (d(i3) & 1048575)) == i2;
    }

    private final void b(T t, int i2, int i3) {
        hg.a((Object) t, (long) (d(i3) & 1048575), i2);
    }

    private final int f(int i2) {
        if (i2 < this.f11149e || i2 > this.f11150f) {
            return -1;
        }
        return b(i2, 0);
    }

    private final int a(int i2, int i3) {
        if (i2 < this.f11149e || i2 > this.f11150f) {
            return -1;
        }
        return b(i2, i3);
    }

    private final int b(int i2, int i3) {
        int length = (this.f11147c.length / 3) - 1;
        while (i3 <= length) {
            int i4 = (length + i3) >>> 1;
            int i5 = i4 * 3;
            int i6 = this.f11147c[i5];
            if (i2 == i6) {
                return i5;
            }
            if (i2 < i6) {
                length = i4 - 1;
            } else {
                i3 = i4 + 1;
            }
        }
        return -1;
    }
}
