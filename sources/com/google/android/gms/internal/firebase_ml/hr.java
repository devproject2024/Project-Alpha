package com.google.android.gms.internal.firebase_ml;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

final class hr<T> implements ig<T> {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f9963a = new int[0];

    /* renamed from: b  reason: collision with root package name */
    private static final Unsafe f9964b = d.c();

    /* renamed from: c  reason: collision with root package name */
    private final int[] f9965c;

    /* renamed from: d  reason: collision with root package name */
    private final Object[] f9966d;

    /* renamed from: e  reason: collision with root package name */
    private final int f9967e;

    /* renamed from: f  reason: collision with root package name */
    private final int f9968f;

    /* renamed from: g  reason: collision with root package name */
    private final hn f9969g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f9970h;

    /* renamed from: i  reason: collision with root package name */
    private final boolean f9971i;
    private final boolean j;
    private final boolean k;
    private final int[] l;
    private final int m;
    private final int n;
    private final hu o;
    private final gy p;
    private final ix<?, ?> q;
    private final fy<?> r;
    private final hk s;

    private hr(int[] iArr, Object[] objArr, int i2, int i3, hn hnVar, boolean z, int[] iArr2, int i4, int i5, hu huVar, gy gyVar, ix<?, ?> ixVar, fy<?> fyVar, hk hkVar) {
        this.f9965c = iArr;
        this.f9966d = objArr;
        this.f9967e = i2;
        this.f9968f = i3;
        this.f9971i = hnVar instanceof gg;
        this.j = z;
        this.f9970h = fyVar != null && fyVar.a(hnVar);
        this.k = false;
        this.l = iArr2;
        this.m = i4;
        this.n = i5;
        this.o = huVar;
        this.p = gyVar;
        this.q = ixVar;
        this.r = fyVar;
        this.f9969g = hnVar;
        this.s = hkVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:164:0x034e  */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x0397  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static <T> com.google.android.gms.internal.firebase_ml.hr<T> a(com.google.android.gms.internal.firebase_ml.hl r34, com.google.android.gms.internal.firebase_ml.hu r35, com.google.android.gms.internal.firebase_ml.gy r36, com.google.android.gms.internal.firebase_ml.ix<?, ?> r37, com.google.android.gms.internal.firebase_ml.fy<?> r38, com.google.android.gms.internal.firebase_ml.hk r39) {
        /*
            r0 = r34
            boolean r1 = r0 instanceof com.google.android.gms.internal.firebase_ml.id
            if (r1 == 0) goto L_0x0408
            com.google.android.gms.internal.firebase_ml.id r0 = (com.google.android.gms.internal.firebase_ml.id) r0
            int r1 = r0.a()
            int r2 = com.google.android.gms.internal.firebase_ml.gg.e.f9930i
            r3 = 0
            r4 = 1
            if (r1 != r2) goto L_0x0014
            r11 = 1
            goto L_0x0015
        L_0x0014:
            r11 = 0
        L_0x0015:
            java.lang.String r1 = r0.f9985b
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
            int[] r5 = f9963a
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
            sun.misc.Unsafe r7 = f9964b
            java.lang.Object[] r3 = r0.f9986c
            com.google.android.gms.internal.firebase_ml.hn r8 = r0.f9984a
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
            com.google.android.gms.internal.firebase_ml.hr r1 = new com.google.android.gms.internal.firebase_ml.hr
            com.google.android.gms.internal.firebase_ml.hn r10 = r0.f9984a
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_ml.hr.a(com.google.android.gms.internal.firebase_ml.hl, com.google.android.gms.internal.firebase_ml.hu, com.google.android.gms.internal.firebase_ml.gy, com.google.android.gms.internal.firebase_ml.ix, com.google.android.gms.internal.firebase_ml.fy, com.google.android.gms.internal.firebase_ml.hk):com.google.android.gms.internal.firebase_ml.hr");
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

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x006a, code lost:
        if (com.google.android.gms.internal.firebase_ml.ii.a(com.google.android.gms.internal.firebase_ml.d.f(r10, r6), com.google.android.gms.internal.firebase_ml.d.f(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x007e, code lost:
        if (com.google.android.gms.internal.firebase_ml.d.b(r10, r6) == com.google.android.gms.internal.firebase_ml.d.b(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0090, code lost:
        if (com.google.android.gms.internal.firebase_ml.d.a((java.lang.Object) r10, r6) == com.google.android.gms.internal.firebase_ml.d.a((java.lang.Object) r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00a4, code lost:
        if (com.google.android.gms.internal.firebase_ml.d.b(r10, r6) == com.google.android.gms.internal.firebase_ml.d.b(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00b6, code lost:
        if (com.google.android.gms.internal.firebase_ml.d.a((java.lang.Object) r10, r6) == com.google.android.gms.internal.firebase_ml.d.a((java.lang.Object) r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00c8, code lost:
        if (com.google.android.gms.internal.firebase_ml.d.a((java.lang.Object) r10, r6) == com.google.android.gms.internal.firebase_ml.d.a((java.lang.Object) r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00da, code lost:
        if (com.google.android.gms.internal.firebase_ml.d.a((java.lang.Object) r10, r6) == com.google.android.gms.internal.firebase_ml.d.a((java.lang.Object) r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00f0, code lost:
        if (com.google.android.gms.internal.firebase_ml.ii.a(com.google.android.gms.internal.firebase_ml.d.f(r10, r6), com.google.android.gms.internal.firebase_ml.d.f(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0106, code lost:
        if (com.google.android.gms.internal.firebase_ml.ii.a(com.google.android.gms.internal.firebase_ml.d.f(r10, r6), com.google.android.gms.internal.firebase_ml.d.f(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x011c, code lost:
        if (com.google.android.gms.internal.firebase_ml.ii.a(com.google.android.gms.internal.firebase_ml.d.f(r10, r6), com.google.android.gms.internal.firebase_ml.d.f(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x012e, code lost:
        if (com.google.android.gms.internal.firebase_ml.d.c(r10, r6) == com.google.android.gms.internal.firebase_ml.d.c(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0140, code lost:
        if (com.google.android.gms.internal.firebase_ml.d.a((java.lang.Object) r10, r6) == com.google.android.gms.internal.firebase_ml.d.a((java.lang.Object) r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0154, code lost:
        if (com.google.android.gms.internal.firebase_ml.d.b(r10, r6) == com.google.android.gms.internal.firebase_ml.d.b(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0165, code lost:
        if (com.google.android.gms.internal.firebase_ml.d.a((java.lang.Object) r10, r6) == com.google.android.gms.internal.firebase_ml.d.a((java.lang.Object) r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0178, code lost:
        if (com.google.android.gms.internal.firebase_ml.d.b(r10, r6) == com.google.android.gms.internal.firebase_ml.d.b(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x018b, code lost:
        if (com.google.android.gms.internal.firebase_ml.d.b(r10, r6) == com.google.android.gms.internal.firebase_ml.d.b(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x01a4, code lost:
        if (java.lang.Float.floatToIntBits(com.google.android.gms.internal.firebase_ml.d.d(r10, r6)) == java.lang.Float.floatToIntBits(com.google.android.gms.internal.firebase_ml.d.d(r11, r6))) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x01bf, code lost:
        if (java.lang.Double.doubleToLongBits(com.google.android.gms.internal.firebase_ml.d.e(r10, r6)) == java.lang.Double.doubleToLongBits(com.google.android.gms.internal.firebase_ml.d.e(r11, r6))) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x01c1, code lost:
        r3 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0038, code lost:
        if (com.google.android.gms.internal.firebase_ml.ii.a(com.google.android.gms.internal.firebase_ml.d.f(r10, r6), com.google.android.gms.internal.firebase_ml.d.f(r11, r6)) != false) goto L_0x01c2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(T r10, T r11) {
        /*
            r9 = this;
            int[] r0 = r9.f9965c
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
            int r8 = com.google.android.gms.internal.firebase_ml.d.a((java.lang.Object) r10, (long) r4)
            int r4 = com.google.android.gms.internal.firebase_ml.d.a((java.lang.Object) r11, (long) r4)
            if (r8 != r4) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.firebase_ml.d.f(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.firebase_ml.d.f(r11, r6)
            boolean r4 = com.google.android.gms.internal.firebase_ml.ii.a((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x003c:
            java.lang.Object r3 = com.google.android.gms.internal.firebase_ml.d.f(r10, r6)
            java.lang.Object r4 = com.google.android.gms.internal.firebase_ml.d.f(r11, r6)
            boolean r3 = com.google.android.gms.internal.firebase_ml.ii.a((java.lang.Object) r3, (java.lang.Object) r4)
            goto L_0x01c2
        L_0x004a:
            java.lang.Object r3 = com.google.android.gms.internal.firebase_ml.d.f(r10, r6)
            java.lang.Object r4 = com.google.android.gms.internal.firebase_ml.d.f(r11, r6)
            boolean r3 = com.google.android.gms.internal.firebase_ml.ii.a((java.lang.Object) r3, (java.lang.Object) r4)
            goto L_0x01c2
        L_0x0058:
            boolean r4 = r9.c(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.firebase_ml.d.f(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.firebase_ml.d.f(r11, r6)
            boolean r4 = com.google.android.gms.internal.firebase_ml.ii.a((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x006e:
            boolean r4 = r9.c(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.firebase_ml.d.b(r10, r6)
            long r6 = com.google.android.gms.internal.firebase_ml.d.b(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x0082:
            boolean r4 = r9.c(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.firebase_ml.d.a((java.lang.Object) r10, (long) r6)
            int r5 = com.google.android.gms.internal.firebase_ml.d.a((java.lang.Object) r11, (long) r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x0094:
            boolean r4 = r9.c(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.firebase_ml.d.b(r10, r6)
            long r6 = com.google.android.gms.internal.firebase_ml.d.b(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x00a8:
            boolean r4 = r9.c(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.firebase_ml.d.a((java.lang.Object) r10, (long) r6)
            int r5 = com.google.android.gms.internal.firebase_ml.d.a((java.lang.Object) r11, (long) r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x00ba:
            boolean r4 = r9.c(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.firebase_ml.d.a((java.lang.Object) r10, (long) r6)
            int r5 = com.google.android.gms.internal.firebase_ml.d.a((java.lang.Object) r11, (long) r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x00cc:
            boolean r4 = r9.c(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.firebase_ml.d.a((java.lang.Object) r10, (long) r6)
            int r5 = com.google.android.gms.internal.firebase_ml.d.a((java.lang.Object) r11, (long) r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x00de:
            boolean r4 = r9.c(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.firebase_ml.d.f(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.firebase_ml.d.f(r11, r6)
            boolean r4 = com.google.android.gms.internal.firebase_ml.ii.a((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x00f4:
            boolean r4 = r9.c(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.firebase_ml.d.f(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.firebase_ml.d.f(r11, r6)
            boolean r4 = com.google.android.gms.internal.firebase_ml.ii.a((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x010a:
            boolean r4 = r9.c(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.firebase_ml.d.f(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.firebase_ml.d.f(r11, r6)
            boolean r4 = com.google.android.gms.internal.firebase_ml.ii.a((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x0120:
            boolean r4 = r9.c(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            boolean r4 = com.google.android.gms.internal.firebase_ml.d.c(r10, r6)
            boolean r5 = com.google.android.gms.internal.firebase_ml.d.c(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x0132:
            boolean r4 = r9.c(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.firebase_ml.d.a((java.lang.Object) r10, (long) r6)
            int r5 = com.google.android.gms.internal.firebase_ml.d.a((java.lang.Object) r11, (long) r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x0144:
            boolean r4 = r9.c(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.firebase_ml.d.b(r10, r6)
            long r6 = com.google.android.gms.internal.firebase_ml.d.b(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x0157:
            boolean r4 = r9.c(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.firebase_ml.d.a((java.lang.Object) r10, (long) r6)
            int r5 = com.google.android.gms.internal.firebase_ml.d.a((java.lang.Object) r11, (long) r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x0168:
            boolean r4 = r9.c(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.firebase_ml.d.b(r10, r6)
            long r6 = com.google.android.gms.internal.firebase_ml.d.b(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x017b:
            boolean r4 = r9.c(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.firebase_ml.d.b(r10, r6)
            long r6 = com.google.android.gms.internal.firebase_ml.d.b(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x018e:
            boolean r4 = r9.c(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            float r4 = com.google.android.gms.internal.firebase_ml.d.d(r10, r6)
            int r4 = java.lang.Float.floatToIntBits(r4)
            float r5 = com.google.android.gms.internal.firebase_ml.d.d(r11, r6)
            int r5 = java.lang.Float.floatToIntBits(r5)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x01a7:
            boolean r4 = r9.c(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            double r4 = com.google.android.gms.internal.firebase_ml.d.e(r10, r6)
            long r4 = java.lang.Double.doubleToLongBits(r4)
            double r6 = com.google.android.gms.internal.firebase_ml.d.e(r11, r6)
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
            com.google.android.gms.internal.firebase_ml.ix<?, ?> r0 = r9.q
            java.lang.Object r0 = r0.a(r10)
            com.google.android.gms.internal.firebase_ml.ix<?, ?> r2 = r9.q
            java.lang.Object r2 = r2.a(r11)
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x01dc
            return r1
        L_0x01dc:
            boolean r0 = r9.f9970h
            if (r0 == 0) goto L_0x01f1
            com.google.android.gms.internal.firebase_ml.fy<?> r0 = r9.r
            com.google.android.gms.internal.firebase_ml.fz r10 = r0.a((java.lang.Object) r10)
            com.google.android.gms.internal.firebase_ml.fy<?> r0 = r9.r
            com.google.android.gms.internal.firebase_ml.fz r11 = r0.a((java.lang.Object) r11)
            boolean r10 = r10.equals(r11)
            return r10
        L_0x01f1:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_ml.hr.a(java.lang.Object, java.lang.Object):boolean");
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
            int[] r0 = r8.f9965c
            int r0 = r0.length
            r1 = 0
            r2 = 0
        L_0x0005:
            if (r1 >= r0) goto L_0x022c
            int r3 = r8.c((int) r1)
            int[] r4 = r8.f9965c
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
            java.lang.Object r3 = com.google.android.gms.internal.firebase_ml.d.f(r9, r5)
            int r2 = r2 * 53
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x0032:
            boolean r3 = r8.a(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            long r3 = e(r9, r5)
            int r3 = com.google.android.gms.internal.firebase_ml.gk.a((long) r3)
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
            int r3 = com.google.android.gms.internal.firebase_ml.gk.a((long) r3)
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
            java.lang.Object r3 = com.google.android.gms.internal.firebase_ml.d.f(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x00a0:
            boolean r3 = r8.a(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            java.lang.Object r3 = com.google.android.gms.internal.firebase_ml.d.f(r9, r5)
            int r2 = r2 * 53
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x00b2:
            boolean r3 = r8.a(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.firebase_ml.d.f(r9, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x00c6:
            boolean r3 = r8.a(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            boolean r3 = f(r9, r5)
            int r3 = com.google.android.gms.internal.firebase_ml.gk.a((boolean) r3)
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
            int r3 = com.google.android.gms.internal.firebase_ml.gk.a((long) r3)
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
            int r3 = com.google.android.gms.internal.firebase_ml.gk.a((long) r3)
            goto L_0x0227
        L_0x0118:
            boolean r3 = r8.a(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            long r3 = e(r9, r5)
            int r3 = com.google.android.gms.internal.firebase_ml.gk.a((long) r3)
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
            int r3 = com.google.android.gms.internal.firebase_ml.gk.a((long) r3)
            goto L_0x0227
        L_0x0152:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.firebase_ml.d.f(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x015e:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.firebase_ml.d.f(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x016a:
            java.lang.Object r3 = com.google.android.gms.internal.firebase_ml.d.f(r9, r5)
            if (r3 == 0) goto L_0x01c3
            int r7 = r3.hashCode()
            goto L_0x01c3
        L_0x0175:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.firebase_ml.d.b(r9, r5)
            int r3 = com.google.android.gms.internal.firebase_ml.gk.a((long) r3)
            goto L_0x0227
        L_0x0181:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.firebase_ml.d.a((java.lang.Object) r9, (long) r5)
            goto L_0x0227
        L_0x0189:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.firebase_ml.d.b(r9, r5)
            int r3 = com.google.android.gms.internal.firebase_ml.gk.a((long) r3)
            goto L_0x0227
        L_0x0195:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.firebase_ml.d.a((java.lang.Object) r9, (long) r5)
            goto L_0x0227
        L_0x019d:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.firebase_ml.d.a((java.lang.Object) r9, (long) r5)
            goto L_0x0227
        L_0x01a5:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.firebase_ml.d.a((java.lang.Object) r9, (long) r5)
            goto L_0x0227
        L_0x01ad:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.firebase_ml.d.f(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x01b9:
            java.lang.Object r3 = com.google.android.gms.internal.firebase_ml.d.f(r9, r5)
            if (r3 == 0) goto L_0x01c3
            int r7 = r3.hashCode()
        L_0x01c3:
            int r2 = r2 * 53
            int r2 = r2 + r7
            goto L_0x0228
        L_0x01c7:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.firebase_ml.d.f(r9, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x01d4:
            int r2 = r2 * 53
            boolean r3 = com.google.android.gms.internal.firebase_ml.d.c(r9, r5)
            int r3 = com.google.android.gms.internal.firebase_ml.gk.a((boolean) r3)
            goto L_0x0227
        L_0x01df:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.firebase_ml.d.a((java.lang.Object) r9, (long) r5)
            goto L_0x0227
        L_0x01e6:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.firebase_ml.d.b(r9, r5)
            int r3 = com.google.android.gms.internal.firebase_ml.gk.a((long) r3)
            goto L_0x0227
        L_0x01f1:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.firebase_ml.d.a((java.lang.Object) r9, (long) r5)
            goto L_0x0227
        L_0x01f8:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.firebase_ml.d.b(r9, r5)
            int r3 = com.google.android.gms.internal.firebase_ml.gk.a((long) r3)
            goto L_0x0227
        L_0x0203:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.firebase_ml.d.b(r9, r5)
            int r3 = com.google.android.gms.internal.firebase_ml.gk.a((long) r3)
            goto L_0x0227
        L_0x020e:
            int r2 = r2 * 53
            float r3 = com.google.android.gms.internal.firebase_ml.d.d(r9, r5)
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x0227
        L_0x0219:
            int r2 = r2 * 53
            double r3 = com.google.android.gms.internal.firebase_ml.d.e(r9, r5)
            long r3 = java.lang.Double.doubleToLongBits(r3)
            int r3 = com.google.android.gms.internal.firebase_ml.gk.a((long) r3)
        L_0x0227:
            int r2 = r2 + r3
        L_0x0228:
            int r1 = r1 + 3
            goto L_0x0005
        L_0x022c:
            int r2 = r2 * 53
            com.google.android.gms.internal.firebase_ml.ix<?, ?> r0 = r8.q
            java.lang.Object r0 = r0.a(r9)
            int r0 = r0.hashCode()
            int r2 = r2 + r0
            boolean r0 = r8.f9970h
            if (r0 == 0) goto L_0x024a
            int r2 = r2 * 53
            com.google.android.gms.internal.firebase_ml.fy<?> r0 = r8.r
            com.google.android.gms.internal.firebase_ml.fz r9 = r0.a((java.lang.Object) r9)
            int r9 = r9.hashCode()
            int r2 = r2 + r9
        L_0x024a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_ml.hr.a(java.lang.Object):int");
    }

    public final void b(T t, T t2) {
        if (t2 != null) {
            for (int i2 = 0; i2 < this.f9965c.length; i2 += 3) {
                int c2 = c(i2);
                long j2 = (long) (1048575 & c2);
                int i3 = this.f9965c[i2];
                switch ((c2 & 267386880) >>> 20) {
                    case 0:
                        if (!a(t2, i2)) {
                            break;
                        } else {
                            d.a((Object) t, j2, d.e(t2, j2));
                            b(t, i2);
                            break;
                        }
                    case 1:
                        if (!a(t2, i2)) {
                            break;
                        } else {
                            d.a((Object) t, j2, d.d(t2, j2));
                            b(t, i2);
                            break;
                        }
                    case 2:
                        if (!a(t2, i2)) {
                            break;
                        } else {
                            d.a((Object) t, j2, d.b(t2, j2));
                            b(t, i2);
                            break;
                        }
                    case 3:
                        if (!a(t2, i2)) {
                            break;
                        } else {
                            d.a((Object) t, j2, d.b(t2, j2));
                            b(t, i2);
                            break;
                        }
                    case 4:
                        if (!a(t2, i2)) {
                            break;
                        } else {
                            d.a((Object) t, j2, d.a((Object) t2, j2));
                            b(t, i2);
                            break;
                        }
                    case 5:
                        if (!a(t2, i2)) {
                            break;
                        } else {
                            d.a((Object) t, j2, d.b(t2, j2));
                            b(t, i2);
                            break;
                        }
                    case 6:
                        if (!a(t2, i2)) {
                            break;
                        } else {
                            d.a((Object) t, j2, d.a((Object) t2, j2));
                            b(t, i2);
                            break;
                        }
                    case 7:
                        if (!a(t2, i2)) {
                            break;
                        } else {
                            d.a((Object) t, j2, d.c(t2, j2));
                            b(t, i2);
                            break;
                        }
                    case 8:
                        if (!a(t2, i2)) {
                            break;
                        } else {
                            d.a((Object) t, j2, d.f(t2, j2));
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
                            d.a((Object) t, j2, d.f(t2, j2));
                            b(t, i2);
                            break;
                        }
                    case 11:
                        if (!a(t2, i2)) {
                            break;
                        } else {
                            d.a((Object) t, j2, d.a((Object) t2, j2));
                            b(t, i2);
                            break;
                        }
                    case 12:
                        if (!a(t2, i2)) {
                            break;
                        } else {
                            d.a((Object) t, j2, d.a((Object) t2, j2));
                            b(t, i2);
                            break;
                        }
                    case 13:
                        if (!a(t2, i2)) {
                            break;
                        } else {
                            d.a((Object) t, j2, d.a((Object) t2, j2));
                            b(t, i2);
                            break;
                        }
                    case 14:
                        if (!a(t2, i2)) {
                            break;
                        } else {
                            d.a((Object) t, j2, d.b(t2, j2));
                            b(t, i2);
                            break;
                        }
                    case 15:
                        if (!a(t2, i2)) {
                            break;
                        } else {
                            d.a((Object) t, j2, d.a((Object) t2, j2));
                            b(t, i2);
                            break;
                        }
                    case 16:
                        if (!a(t2, i2)) {
                            break;
                        } else {
                            d.a((Object) t, j2, d.b(t2, j2));
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
                        ii.a(this.s, t, t2, j2);
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
                            d.a((Object) t, j2, d.f(t2, j2));
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
                            d.a((Object) t, j2, d.f(t2, j2));
                            b(t, i3, i2);
                            break;
                        }
                    case 68:
                        b(t, t2, i2);
                        break;
                }
            }
            ii.a(this.q, t, t2);
            if (this.f9970h) {
                ii.a(this.r, t, t2);
                return;
            }
            return;
        }
        throw new NullPointerException();
    }

    private final void a(T t, T t2, int i2) {
        long c2 = (long) (c(i2) & 1048575);
        if (a(t2, i2)) {
            Object f2 = d.f(t, c2);
            Object f3 = d.f(t2, c2);
            if (f2 != null && f3 != null) {
                d.a((Object) t, c2, gk.a(f2, f3));
                b(t, i2);
            } else if (f3 != null) {
                d.a((Object) t, c2, f3);
                b(t, i2);
            }
        }
    }

    private final void b(T t, T t2, int i2) {
        int c2 = c(i2);
        int i3 = this.f9965c[i2];
        long j2 = (long) (c2 & 1048575);
        if (a(t2, i3, i2)) {
            Object f2 = d.f(t, j2);
            Object f3 = d.f(t2, j2);
            if (f2 != null && f3 != null) {
                d.a((Object) t, j2, gk.a(f2, f3));
                b(t, i3, i2);
            } else if (f3 != null) {
                d.a((Object) t, j2, f3);
                b(t, i3, i2);
            }
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:398:0x081e, code lost:
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
            if (r2 == 0) goto L_0x04e8
            sun.misc.Unsafe r2 = f9964b
            r6 = 0
            r7 = 0
        L_0x0012:
            int[] r8 = r0.f9965c
            int r8 = r8.length
            if (r6 >= r8) goto L_0x04e0
            int r8 = r0.c((int) r6)
            r9 = r8 & r3
            int r9 = r9 >>> 20
            int[] r10 = r0.f9965c
            r10 = r10[r6]
            r8 = r8 & r4
            long r11 = (long) r8
            com.google.android.gms.internal.firebase_ml.ge r8 = com.google.android.gms.internal.firebase_ml.ge.DOUBLE_LIST_PACKED
            int r8 = r8.id()
            if (r9 < r8) goto L_0x003d
            com.google.android.gms.internal.firebase_ml.ge r8 = com.google.android.gms.internal.firebase_ml.ge.SINT64_LIST_PACKED
            int r8 = r8.id()
            if (r9 > r8) goto L_0x003d
            int[] r8 = r0.f9965c
            int r13 = r6 + 2
            r8 = r8[r13]
            r8 = r8 & r4
            goto L_0x003e
        L_0x003d:
            r8 = 0
        L_0x003e:
            switch(r9) {
                case 0: goto L_0x04d0;
                case 1: goto L_0x04c4;
                case 2: goto L_0x04b4;
                case 3: goto L_0x04a4;
                case 4: goto L_0x0494;
                case 5: goto L_0x0488;
                case 6: goto L_0x047c;
                case 7: goto L_0x0470;
                case 8: goto L_0x0452;
                case 9: goto L_0x043e;
                case 10: goto L_0x042d;
                case 11: goto L_0x041e;
                case 12: goto L_0x040f;
                case 13: goto L_0x0404;
                case 14: goto L_0x03f9;
                case 15: goto L_0x03ea;
                case 16: goto L_0x03db;
                case 17: goto L_0x03c6;
                case 18: goto L_0x03bb;
                case 19: goto L_0x03b2;
                case 20: goto L_0x03a9;
                case 21: goto L_0x03a0;
                case 22: goto L_0x0397;
                case 23: goto L_0x038e;
                case 24: goto L_0x0385;
                case 25: goto L_0x037c;
                case 26: goto L_0x0373;
                case 27: goto L_0x0366;
                case 28: goto L_0x035d;
                case 29: goto L_0x0354;
                case 30: goto L_0x034a;
                case 31: goto L_0x0340;
                case 32: goto L_0x0336;
                case 33: goto L_0x032c;
                case 34: goto L_0x0322;
                case 35: goto L_0x0302;
                case 36: goto L_0x02e5;
                case 37: goto L_0x02c8;
                case 38: goto L_0x02ab;
                case 39: goto L_0x028d;
                case 40: goto L_0x026f;
                case 41: goto L_0x0251;
                case 42: goto L_0x0233;
                case 43: goto L_0x0215;
                case 44: goto L_0x01f7;
                case 45: goto L_0x01d9;
                case 46: goto L_0x01bb;
                case 47: goto L_0x019d;
                case 48: goto L_0x017f;
                case 49: goto L_0x0171;
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
            goto L_0x04dc
        L_0x0043:
            boolean r8 = r0.a(r1, (int) r10, (int) r6)
            if (r8 == 0) goto L_0x04dc
            java.lang.Object r8 = com.google.android.gms.internal.firebase_ml.d.f(r1, r11)
            com.google.android.gms.internal.firebase_ml.hn r8 = (com.google.android.gms.internal.firebase_ml.hn) r8
            com.google.android.gms.internal.firebase_ml.ig r9 = r0.a((int) r6)
            int r8 = com.google.android.gms.internal.firebase_ml.ft.c(r10, r8, r9)
            goto L_0x03c3
        L_0x0059:
            boolean r8 = r0.a(r1, (int) r10, (int) r6)
            if (r8 == 0) goto L_0x04dc
            long r8 = e(r1, r11)
            int r8 = com.google.android.gms.internal.firebase_ml.ft.f((int) r10, (long) r8)
            goto L_0x03c3
        L_0x0069:
            boolean r8 = r0.a(r1, (int) r10, (int) r6)
            if (r8 == 0) goto L_0x04dc
            int r8 = d(r1, r11)
            int r8 = com.google.android.gms.internal.firebase_ml.ft.h(r10, r8)
            goto L_0x03c3
        L_0x0079:
            boolean r8 = r0.a(r1, (int) r10, (int) r6)
            if (r8 == 0) goto L_0x04dc
            int r8 = com.google.android.gms.internal.firebase_ml.ft.h(r10)
            goto L_0x03c3
        L_0x0085:
            boolean r8 = r0.a(r1, (int) r10, (int) r6)
            if (r8 == 0) goto L_0x04dc
            int r8 = com.google.android.gms.internal.firebase_ml.ft.f((int) r10)
            goto L_0x03c3
        L_0x0091:
            boolean r8 = r0.a(r1, (int) r10, (int) r6)
            if (r8 == 0) goto L_0x04dc
            int r8 = d(r1, r11)
            int r8 = com.google.android.gms.internal.firebase_ml.ft.i(r10, r8)
            goto L_0x03c3
        L_0x00a1:
            boolean r8 = r0.a(r1, (int) r10, (int) r6)
            if (r8 == 0) goto L_0x04dc
            int r8 = d(r1, r11)
            int r8 = com.google.android.gms.internal.firebase_ml.ft.g(r10, r8)
            goto L_0x03c3
        L_0x00b1:
            boolean r8 = r0.a(r1, (int) r10, (int) r6)
            if (r8 == 0) goto L_0x04dc
            java.lang.Object r8 = com.google.android.gms.internal.firebase_ml.d.f(r1, r11)
            com.google.android.gms.internal.firebase_ml.fh r8 = (com.google.android.gms.internal.firebase_ml.fh) r8
            int r8 = com.google.android.gms.internal.firebase_ml.ft.c((int) r10, (com.google.android.gms.internal.firebase_ml.fh) r8)
            goto L_0x03c3
        L_0x00c3:
            boolean r8 = r0.a(r1, (int) r10, (int) r6)
            if (r8 == 0) goto L_0x04dc
            java.lang.Object r8 = com.google.android.gms.internal.firebase_ml.d.f(r1, r11)
            com.google.android.gms.internal.firebase_ml.ig r9 = r0.a((int) r6)
            int r8 = com.google.android.gms.internal.firebase_ml.ii.a((int) r10, (java.lang.Object) r8, (com.google.android.gms.internal.firebase_ml.ig) r9)
            goto L_0x03c3
        L_0x00d7:
            boolean r8 = r0.a(r1, (int) r10, (int) r6)
            if (r8 == 0) goto L_0x04dc
            java.lang.Object r8 = com.google.android.gms.internal.firebase_ml.d.f(r1, r11)
            boolean r9 = r8 instanceof com.google.android.gms.internal.firebase_ml.fh
            if (r9 == 0) goto L_0x00ed
            com.google.android.gms.internal.firebase_ml.fh r8 = (com.google.android.gms.internal.firebase_ml.fh) r8
            int r8 = com.google.android.gms.internal.firebase_ml.ft.c((int) r10, (com.google.android.gms.internal.firebase_ml.fh) r8)
            goto L_0x03c3
        L_0x00ed:
            java.lang.String r8 = (java.lang.String) r8
            int r8 = com.google.android.gms.internal.firebase_ml.ft.b((int) r10, (java.lang.String) r8)
            goto L_0x03c3
        L_0x00f5:
            boolean r8 = r0.a(r1, (int) r10, (int) r6)
            if (r8 == 0) goto L_0x04dc
            int r8 = com.google.android.gms.internal.firebase_ml.ft.k(r10)
            goto L_0x03c3
        L_0x0101:
            boolean r8 = r0.a(r1, (int) r10, (int) r6)
            if (r8 == 0) goto L_0x04dc
            int r8 = com.google.android.gms.internal.firebase_ml.ft.e((int) r10)
            goto L_0x03c3
        L_0x010d:
            boolean r8 = r0.a(r1, (int) r10, (int) r6)
            if (r8 == 0) goto L_0x04dc
            int r8 = com.google.android.gms.internal.firebase_ml.ft.g((int) r10)
            goto L_0x03c3
        L_0x0119:
            boolean r8 = r0.a(r1, (int) r10, (int) r6)
            if (r8 == 0) goto L_0x04dc
            int r8 = d(r1, r11)
            int r8 = com.google.android.gms.internal.firebase_ml.ft.f((int) r10, (int) r8)
            goto L_0x03c3
        L_0x0129:
            boolean r8 = r0.a(r1, (int) r10, (int) r6)
            if (r8 == 0) goto L_0x04dc
            long r8 = e(r1, r11)
            int r8 = com.google.android.gms.internal.firebase_ml.ft.e((int) r10, (long) r8)
            goto L_0x03c3
        L_0x0139:
            boolean r8 = r0.a(r1, (int) r10, (int) r6)
            if (r8 == 0) goto L_0x04dc
            long r8 = e(r1, r11)
            int r8 = com.google.android.gms.internal.firebase_ml.ft.d((int) r10, (long) r8)
            goto L_0x03c3
        L_0x0149:
            boolean r8 = r0.a(r1, (int) r10, (int) r6)
            if (r8 == 0) goto L_0x04dc
            int r8 = com.google.android.gms.internal.firebase_ml.ft.i(r10)
            goto L_0x03c3
        L_0x0155:
            boolean r8 = r0.a(r1, (int) r10, (int) r6)
            if (r8 == 0) goto L_0x04dc
            int r8 = com.google.android.gms.internal.firebase_ml.ft.j(r10)
            goto L_0x03c3
        L_0x0161:
            com.google.android.gms.internal.firebase_ml.hk r8 = r0.s
            java.lang.Object r9 = com.google.android.gms.internal.firebase_ml.d.f(r1, r11)
            java.lang.Object r11 = r0.b((int) r6)
            int r8 = r8.a(r10, r9, r11)
            goto L_0x03c3
        L_0x0171:
            java.util.List r8 = a((java.lang.Object) r1, (long) r11)
            com.google.android.gms.internal.firebase_ml.ig r9 = r0.a((int) r6)
            int r8 = com.google.android.gms.internal.firebase_ml.ii.b((int) r10, (java.util.List<com.google.android.gms.internal.firebase_ml.hn>) r8, (com.google.android.gms.internal.firebase_ml.ig) r9)
            goto L_0x03c3
        L_0x017f:
            java.lang.Object r9 = r2.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            int r9 = com.google.android.gms.internal.firebase_ml.ii.c(r9)
            if (r9 <= 0) goto L_0x04dc
            boolean r11 = r0.k
            if (r11 == 0) goto L_0x0193
            long r11 = (long) r8
            r2.putInt(r1, r11, r9)
        L_0x0193:
            int r8 = com.google.android.gms.internal.firebase_ml.ft.l(r10)
            int r10 = com.google.android.gms.internal.firebase_ml.ft.n(r9)
            goto L_0x031e
        L_0x019d:
            java.lang.Object r9 = r2.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            int r9 = com.google.android.gms.internal.firebase_ml.ii.g(r9)
            if (r9 <= 0) goto L_0x04dc
            boolean r11 = r0.k
            if (r11 == 0) goto L_0x01b1
            long r11 = (long) r8
            r2.putInt(r1, r11, r9)
        L_0x01b1:
            int r8 = com.google.android.gms.internal.firebase_ml.ft.l(r10)
            int r10 = com.google.android.gms.internal.firebase_ml.ft.n(r9)
            goto L_0x031e
        L_0x01bb:
            java.lang.Object r9 = r2.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            int r9 = com.google.android.gms.internal.firebase_ml.ii.i(r9)
            if (r9 <= 0) goto L_0x04dc
            boolean r11 = r0.k
            if (r11 == 0) goto L_0x01cf
            long r11 = (long) r8
            r2.putInt(r1, r11, r9)
        L_0x01cf:
            int r8 = com.google.android.gms.internal.firebase_ml.ft.l(r10)
            int r10 = com.google.android.gms.internal.firebase_ml.ft.n(r9)
            goto L_0x031e
        L_0x01d9:
            java.lang.Object r9 = r2.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            int r9 = com.google.android.gms.internal.firebase_ml.ii.h(r9)
            if (r9 <= 0) goto L_0x04dc
            boolean r11 = r0.k
            if (r11 == 0) goto L_0x01ed
            long r11 = (long) r8
            r2.putInt(r1, r11, r9)
        L_0x01ed:
            int r8 = com.google.android.gms.internal.firebase_ml.ft.l(r10)
            int r10 = com.google.android.gms.internal.firebase_ml.ft.n(r9)
            goto L_0x031e
        L_0x01f7:
            java.lang.Object r9 = r2.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            int r9 = com.google.android.gms.internal.firebase_ml.ii.d(r9)
            if (r9 <= 0) goto L_0x04dc
            boolean r11 = r0.k
            if (r11 == 0) goto L_0x020b
            long r11 = (long) r8
            r2.putInt(r1, r11, r9)
        L_0x020b:
            int r8 = com.google.android.gms.internal.firebase_ml.ft.l(r10)
            int r10 = com.google.android.gms.internal.firebase_ml.ft.n(r9)
            goto L_0x031e
        L_0x0215:
            java.lang.Object r9 = r2.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            int r9 = com.google.android.gms.internal.firebase_ml.ii.f(r9)
            if (r9 <= 0) goto L_0x04dc
            boolean r11 = r0.k
            if (r11 == 0) goto L_0x0229
            long r11 = (long) r8
            r2.putInt(r1, r11, r9)
        L_0x0229:
            int r8 = com.google.android.gms.internal.firebase_ml.ft.l(r10)
            int r10 = com.google.android.gms.internal.firebase_ml.ft.n(r9)
            goto L_0x031e
        L_0x0233:
            java.lang.Object r9 = r2.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            int r9 = com.google.android.gms.internal.firebase_ml.ii.j(r9)
            if (r9 <= 0) goto L_0x04dc
            boolean r11 = r0.k
            if (r11 == 0) goto L_0x0247
            long r11 = (long) r8
            r2.putInt(r1, r11, r9)
        L_0x0247:
            int r8 = com.google.android.gms.internal.firebase_ml.ft.l(r10)
            int r10 = com.google.android.gms.internal.firebase_ml.ft.n(r9)
            goto L_0x031e
        L_0x0251:
            java.lang.Object r9 = r2.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            int r9 = com.google.android.gms.internal.firebase_ml.ii.h(r9)
            if (r9 <= 0) goto L_0x04dc
            boolean r11 = r0.k
            if (r11 == 0) goto L_0x0265
            long r11 = (long) r8
            r2.putInt(r1, r11, r9)
        L_0x0265:
            int r8 = com.google.android.gms.internal.firebase_ml.ft.l(r10)
            int r10 = com.google.android.gms.internal.firebase_ml.ft.n(r9)
            goto L_0x031e
        L_0x026f:
            java.lang.Object r9 = r2.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            int r9 = com.google.android.gms.internal.firebase_ml.ii.i(r9)
            if (r9 <= 0) goto L_0x04dc
            boolean r11 = r0.k
            if (r11 == 0) goto L_0x0283
            long r11 = (long) r8
            r2.putInt(r1, r11, r9)
        L_0x0283:
            int r8 = com.google.android.gms.internal.firebase_ml.ft.l(r10)
            int r10 = com.google.android.gms.internal.firebase_ml.ft.n(r9)
            goto L_0x031e
        L_0x028d:
            java.lang.Object r9 = r2.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            int r9 = com.google.android.gms.internal.firebase_ml.ii.e(r9)
            if (r9 <= 0) goto L_0x04dc
            boolean r11 = r0.k
            if (r11 == 0) goto L_0x02a1
            long r11 = (long) r8
            r2.putInt(r1, r11, r9)
        L_0x02a1:
            int r8 = com.google.android.gms.internal.firebase_ml.ft.l(r10)
            int r10 = com.google.android.gms.internal.firebase_ml.ft.n(r9)
            goto L_0x031e
        L_0x02ab:
            java.lang.Object r9 = r2.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            int r9 = com.google.android.gms.internal.firebase_ml.ii.b(r9)
            if (r9 <= 0) goto L_0x04dc
            boolean r11 = r0.k
            if (r11 == 0) goto L_0x02bf
            long r11 = (long) r8
            r2.putInt(r1, r11, r9)
        L_0x02bf:
            int r8 = com.google.android.gms.internal.firebase_ml.ft.l(r10)
            int r10 = com.google.android.gms.internal.firebase_ml.ft.n(r9)
            goto L_0x031e
        L_0x02c8:
            java.lang.Object r9 = r2.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            int r9 = com.google.android.gms.internal.firebase_ml.ii.a((java.util.List<java.lang.Long>) r9)
            if (r9 <= 0) goto L_0x04dc
            boolean r11 = r0.k
            if (r11 == 0) goto L_0x02dc
            long r11 = (long) r8
            r2.putInt(r1, r11, r9)
        L_0x02dc:
            int r8 = com.google.android.gms.internal.firebase_ml.ft.l(r10)
            int r10 = com.google.android.gms.internal.firebase_ml.ft.n(r9)
            goto L_0x031e
        L_0x02e5:
            java.lang.Object r9 = r2.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            int r9 = com.google.android.gms.internal.firebase_ml.ii.h(r9)
            if (r9 <= 0) goto L_0x04dc
            boolean r11 = r0.k
            if (r11 == 0) goto L_0x02f9
            long r11 = (long) r8
            r2.putInt(r1, r11, r9)
        L_0x02f9:
            int r8 = com.google.android.gms.internal.firebase_ml.ft.l(r10)
            int r10 = com.google.android.gms.internal.firebase_ml.ft.n(r9)
            goto L_0x031e
        L_0x0302:
            java.lang.Object r9 = r2.getObject(r1, r11)
            java.util.List r9 = (java.util.List) r9
            int r9 = com.google.android.gms.internal.firebase_ml.ii.i(r9)
            if (r9 <= 0) goto L_0x04dc
            boolean r11 = r0.k
            if (r11 == 0) goto L_0x0316
            long r11 = (long) r8
            r2.putInt(r1, r11, r9)
        L_0x0316:
            int r8 = com.google.android.gms.internal.firebase_ml.ft.l(r10)
            int r10 = com.google.android.gms.internal.firebase_ml.ft.n(r9)
        L_0x031e:
            int r8 = r8 + r10
            int r8 = r8 + r9
            goto L_0x03c3
        L_0x0322:
            java.util.List r8 = a((java.lang.Object) r1, (long) r11)
            int r8 = com.google.android.gms.internal.firebase_ml.ii.c(r10, r8)
            goto L_0x03c3
        L_0x032c:
            java.util.List r8 = a((java.lang.Object) r1, (long) r11)
            int r8 = com.google.android.gms.internal.firebase_ml.ii.g(r10, r8)
            goto L_0x03c3
        L_0x0336:
            java.util.List r8 = a((java.lang.Object) r1, (long) r11)
            int r8 = com.google.android.gms.internal.firebase_ml.ii.i(r10, r8)
            goto L_0x03c3
        L_0x0340:
            java.util.List r8 = a((java.lang.Object) r1, (long) r11)
            int r8 = com.google.android.gms.internal.firebase_ml.ii.h(r10, r8)
            goto L_0x03c3
        L_0x034a:
            java.util.List r8 = a((java.lang.Object) r1, (long) r11)
            int r8 = com.google.android.gms.internal.firebase_ml.ii.d(r10, r8)
            goto L_0x03c3
        L_0x0354:
            java.util.List r8 = a((java.lang.Object) r1, (long) r11)
            int r8 = com.google.android.gms.internal.firebase_ml.ii.f(r10, r8)
            goto L_0x03c3
        L_0x035d:
            java.util.List r8 = a((java.lang.Object) r1, (long) r11)
            int r8 = com.google.android.gms.internal.firebase_ml.ii.l(r10, r8)
            goto L_0x03c3
        L_0x0366:
            java.util.List r8 = a((java.lang.Object) r1, (long) r11)
            com.google.android.gms.internal.firebase_ml.ig r9 = r0.a((int) r6)
            int r8 = com.google.android.gms.internal.firebase_ml.ii.a((int) r10, (java.util.List<?>) r8, (com.google.android.gms.internal.firebase_ml.ig) r9)
            goto L_0x03c3
        L_0x0373:
            java.util.List r8 = a((java.lang.Object) r1, (long) r11)
            int r8 = com.google.android.gms.internal.firebase_ml.ii.k(r10, r8)
            goto L_0x03c3
        L_0x037c:
            java.util.List r8 = a((java.lang.Object) r1, (long) r11)
            int r8 = com.google.android.gms.internal.firebase_ml.ii.j(r10, r8)
            goto L_0x03c3
        L_0x0385:
            java.util.List r8 = a((java.lang.Object) r1, (long) r11)
            int r8 = com.google.android.gms.internal.firebase_ml.ii.h(r10, r8)
            goto L_0x03c3
        L_0x038e:
            java.util.List r8 = a((java.lang.Object) r1, (long) r11)
            int r8 = com.google.android.gms.internal.firebase_ml.ii.i(r10, r8)
            goto L_0x03c3
        L_0x0397:
            java.util.List r8 = a((java.lang.Object) r1, (long) r11)
            int r8 = com.google.android.gms.internal.firebase_ml.ii.e(r10, r8)
            goto L_0x03c3
        L_0x03a0:
            java.util.List r8 = a((java.lang.Object) r1, (long) r11)
            int r8 = com.google.android.gms.internal.firebase_ml.ii.b(r10, r8)
            goto L_0x03c3
        L_0x03a9:
            java.util.List r8 = a((java.lang.Object) r1, (long) r11)
            int r8 = com.google.android.gms.internal.firebase_ml.ii.a((int) r10, (java.util.List<java.lang.Long>) r8)
            goto L_0x03c3
        L_0x03b2:
            java.util.List r8 = a((java.lang.Object) r1, (long) r11)
            int r8 = com.google.android.gms.internal.firebase_ml.ii.h(r10, r8)
            goto L_0x03c3
        L_0x03bb:
            java.util.List r8 = a((java.lang.Object) r1, (long) r11)
            int r8 = com.google.android.gms.internal.firebase_ml.ii.i(r10, r8)
        L_0x03c3:
            int r7 = r7 + r8
            goto L_0x04dc
        L_0x03c6:
            boolean r8 = r0.a(r1, (int) r6)
            if (r8 == 0) goto L_0x04dc
            java.lang.Object r8 = com.google.android.gms.internal.firebase_ml.d.f(r1, r11)
            com.google.android.gms.internal.firebase_ml.hn r8 = (com.google.android.gms.internal.firebase_ml.hn) r8
            com.google.android.gms.internal.firebase_ml.ig r9 = r0.a((int) r6)
            int r8 = com.google.android.gms.internal.firebase_ml.ft.c(r10, r8, r9)
            goto L_0x03c3
        L_0x03db:
            boolean r8 = r0.a(r1, (int) r6)
            if (r8 == 0) goto L_0x04dc
            long r8 = com.google.android.gms.internal.firebase_ml.d.b(r1, r11)
            int r8 = com.google.android.gms.internal.firebase_ml.ft.f((int) r10, (long) r8)
            goto L_0x03c3
        L_0x03ea:
            boolean r8 = r0.a(r1, (int) r6)
            if (r8 == 0) goto L_0x04dc
            int r8 = com.google.android.gms.internal.firebase_ml.d.a((java.lang.Object) r1, (long) r11)
            int r8 = com.google.android.gms.internal.firebase_ml.ft.h(r10, r8)
            goto L_0x03c3
        L_0x03f9:
            boolean r8 = r0.a(r1, (int) r6)
            if (r8 == 0) goto L_0x04dc
            int r8 = com.google.android.gms.internal.firebase_ml.ft.h(r10)
            goto L_0x03c3
        L_0x0404:
            boolean r8 = r0.a(r1, (int) r6)
            if (r8 == 0) goto L_0x04dc
            int r8 = com.google.android.gms.internal.firebase_ml.ft.f((int) r10)
            goto L_0x03c3
        L_0x040f:
            boolean r8 = r0.a(r1, (int) r6)
            if (r8 == 0) goto L_0x04dc
            int r8 = com.google.android.gms.internal.firebase_ml.d.a((java.lang.Object) r1, (long) r11)
            int r8 = com.google.android.gms.internal.firebase_ml.ft.i(r10, r8)
            goto L_0x03c3
        L_0x041e:
            boolean r8 = r0.a(r1, (int) r6)
            if (r8 == 0) goto L_0x04dc
            int r8 = com.google.android.gms.internal.firebase_ml.d.a((java.lang.Object) r1, (long) r11)
            int r8 = com.google.android.gms.internal.firebase_ml.ft.g(r10, r8)
            goto L_0x03c3
        L_0x042d:
            boolean r8 = r0.a(r1, (int) r6)
            if (r8 == 0) goto L_0x04dc
            java.lang.Object r8 = com.google.android.gms.internal.firebase_ml.d.f(r1, r11)
            com.google.android.gms.internal.firebase_ml.fh r8 = (com.google.android.gms.internal.firebase_ml.fh) r8
            int r8 = com.google.android.gms.internal.firebase_ml.ft.c((int) r10, (com.google.android.gms.internal.firebase_ml.fh) r8)
            goto L_0x03c3
        L_0x043e:
            boolean r8 = r0.a(r1, (int) r6)
            if (r8 == 0) goto L_0x04dc
            java.lang.Object r8 = com.google.android.gms.internal.firebase_ml.d.f(r1, r11)
            com.google.android.gms.internal.firebase_ml.ig r9 = r0.a((int) r6)
            int r8 = com.google.android.gms.internal.firebase_ml.ii.a((int) r10, (java.lang.Object) r8, (com.google.android.gms.internal.firebase_ml.ig) r9)
            goto L_0x03c3
        L_0x0452:
            boolean r8 = r0.a(r1, (int) r6)
            if (r8 == 0) goto L_0x04dc
            java.lang.Object r8 = com.google.android.gms.internal.firebase_ml.d.f(r1, r11)
            boolean r9 = r8 instanceof com.google.android.gms.internal.firebase_ml.fh
            if (r9 == 0) goto L_0x0468
            com.google.android.gms.internal.firebase_ml.fh r8 = (com.google.android.gms.internal.firebase_ml.fh) r8
            int r8 = com.google.android.gms.internal.firebase_ml.ft.c((int) r10, (com.google.android.gms.internal.firebase_ml.fh) r8)
            goto L_0x03c3
        L_0x0468:
            java.lang.String r8 = (java.lang.String) r8
            int r8 = com.google.android.gms.internal.firebase_ml.ft.b((int) r10, (java.lang.String) r8)
            goto L_0x03c3
        L_0x0470:
            boolean r8 = r0.a(r1, (int) r6)
            if (r8 == 0) goto L_0x04dc
            int r8 = com.google.android.gms.internal.firebase_ml.ft.k(r10)
            goto L_0x03c3
        L_0x047c:
            boolean r8 = r0.a(r1, (int) r6)
            if (r8 == 0) goto L_0x04dc
            int r8 = com.google.android.gms.internal.firebase_ml.ft.e((int) r10)
            goto L_0x03c3
        L_0x0488:
            boolean r8 = r0.a(r1, (int) r6)
            if (r8 == 0) goto L_0x04dc
            int r8 = com.google.android.gms.internal.firebase_ml.ft.g((int) r10)
            goto L_0x03c3
        L_0x0494:
            boolean r8 = r0.a(r1, (int) r6)
            if (r8 == 0) goto L_0x04dc
            int r8 = com.google.android.gms.internal.firebase_ml.d.a((java.lang.Object) r1, (long) r11)
            int r8 = com.google.android.gms.internal.firebase_ml.ft.f((int) r10, (int) r8)
            goto L_0x03c3
        L_0x04a4:
            boolean r8 = r0.a(r1, (int) r6)
            if (r8 == 0) goto L_0x04dc
            long r8 = com.google.android.gms.internal.firebase_ml.d.b(r1, r11)
            int r8 = com.google.android.gms.internal.firebase_ml.ft.e((int) r10, (long) r8)
            goto L_0x03c3
        L_0x04b4:
            boolean r8 = r0.a(r1, (int) r6)
            if (r8 == 0) goto L_0x04dc
            long r8 = com.google.android.gms.internal.firebase_ml.d.b(r1, r11)
            int r8 = com.google.android.gms.internal.firebase_ml.ft.d((int) r10, (long) r8)
            goto L_0x03c3
        L_0x04c4:
            boolean r8 = r0.a(r1, (int) r6)
            if (r8 == 0) goto L_0x04dc
            int r8 = com.google.android.gms.internal.firebase_ml.ft.i(r10)
            goto L_0x03c3
        L_0x04d0:
            boolean r8 = r0.a(r1, (int) r6)
            if (r8 == 0) goto L_0x04dc
            int r8 = com.google.android.gms.internal.firebase_ml.ft.j(r10)
            goto L_0x03c3
        L_0x04dc:
            int r6 = r6 + 3
            goto L_0x0012
        L_0x04e0:
            com.google.android.gms.internal.firebase_ml.ix<?, ?> r2 = r0.q
            int r1 = a(r2, r1)
            int r7 = r7 + r1
            return r7
        L_0x04e8:
            sun.misc.Unsafe r2 = f9964b
            r6 = 0
            r7 = 0
            r8 = 1048575(0xfffff, float:1.469367E-39)
            r9 = 0
        L_0x04f0:
            int[] r10 = r0.f9965c
            int r10 = r10.length
            if (r6 >= r10) goto L_0x09e5
            int r10 = r0.c((int) r6)
            int[] r11 = r0.f9965c
            r12 = r11[r6]
            r13 = r10 & r3
            int r13 = r13 >>> 20
            r14 = 17
            if (r13 > r14) goto L_0x051c
            int r14 = r6 + 2
            r11 = r11[r14]
            r14 = r11 & r4
            int r15 = r11 >>> 20
            r16 = 1
            int r15 = r16 << r15
            if (r14 == r8) goto L_0x0519
            long r8 = (long) r14
            int r9 = r2.getInt(r1, r8)
            goto L_0x051a
        L_0x0519:
            r14 = r8
        L_0x051a:
            r8 = r14
            goto L_0x053a
        L_0x051c:
            boolean r11 = r0.k
            if (r11 == 0) goto L_0x0538
            com.google.android.gms.internal.firebase_ml.ge r11 = com.google.android.gms.internal.firebase_ml.ge.DOUBLE_LIST_PACKED
            int r11 = r11.id()
            if (r13 < r11) goto L_0x0538
            com.google.android.gms.internal.firebase_ml.ge r11 = com.google.android.gms.internal.firebase_ml.ge.SINT64_LIST_PACKED
            int r11 = r11.id()
            if (r13 > r11) goto L_0x0538
            int[] r11 = r0.f9965c
            int r14 = r6 + 2
            r11 = r11[r14]
            r11 = r11 & r4
            goto L_0x0539
        L_0x0538:
            r11 = 0
        L_0x0539:
            r15 = 0
        L_0x053a:
            r10 = r10 & r4
            long r3 = (long) r10
            switch(r13) {
                case 0: goto L_0x09d2;
                case 1: goto L_0x09c8;
                case 2: goto L_0x09ba;
                case 3: goto L_0x09ac;
                case 4: goto L_0x099e;
                case 5: goto L_0x0994;
                case 6: goto L_0x098a;
                case 7: goto L_0x0980;
                case 8: goto L_0x0964;
                case 9: goto L_0x0953;
                case 10: goto L_0x0944;
                case 11: goto L_0x0937;
                case 12: goto L_0x092a;
                case 13: goto L_0x0921;
                case 14: goto L_0x0918;
                case 15: goto L_0x090b;
                case 16: goto L_0x08fe;
                case 17: goto L_0x08eb;
                case 18: goto L_0x08de;
                case 19: goto L_0x08d3;
                case 20: goto L_0x08c8;
                case 21: goto L_0x08bd;
                case 22: goto L_0x08b2;
                case 23: goto L_0x08a7;
                case 24: goto L_0x089c;
                case 25: goto L_0x0891;
                case 26: goto L_0x0886;
                case 27: goto L_0x0877;
                case 28: goto L_0x086b;
                case 29: goto L_0x085f;
                case 30: goto L_0x0853;
                case 31: goto L_0x0847;
                case 32: goto L_0x083b;
                case 33: goto L_0x082f;
                case 34: goto L_0x0823;
                case 35: goto L_0x0802;
                case 36: goto L_0x07e5;
                case 37: goto L_0x07c8;
                case 38: goto L_0x07ab;
                case 39: goto L_0x078d;
                case 40: goto L_0x076f;
                case 41: goto L_0x0751;
                case 42: goto L_0x0733;
                case 43: goto L_0x0715;
                case 44: goto L_0x06f7;
                case 45: goto L_0x06d9;
                case 46: goto L_0x06bb;
                case 47: goto L_0x069d;
                case 48: goto L_0x067f;
                case 49: goto L_0x066f;
                case 50: goto L_0x065f;
                case 51: goto L_0x0653;
                case 52: goto L_0x0647;
                case 53: goto L_0x0637;
                case 54: goto L_0x0627;
                case 55: goto L_0x0617;
                case 56: goto L_0x060b;
                case 57: goto L_0x05ff;
                case 58: goto L_0x05f3;
                case 59: goto L_0x05d5;
                case 60: goto L_0x05c1;
                case 61: goto L_0x05af;
                case 62: goto L_0x059f;
                case 63: goto L_0x058f;
                case 64: goto L_0x0583;
                case 65: goto L_0x0577;
                case 66: goto L_0x0567;
                case 67: goto L_0x0557;
                case 68: goto L_0x0541;
                default: goto L_0x053f;
            }
        L_0x053f:
            goto L_0x09dc
        L_0x0541:
            boolean r10 = r0.a(r1, (int) r12, (int) r6)
            if (r10 == 0) goto L_0x09dc
            java.lang.Object r3 = r2.getObject(r1, r3)
            com.google.android.gms.internal.firebase_ml.hn r3 = (com.google.android.gms.internal.firebase_ml.hn) r3
            com.google.android.gms.internal.firebase_ml.ig r4 = r0.a((int) r6)
            int r3 = com.google.android.gms.internal.firebase_ml.ft.c(r12, r3, r4)
            goto L_0x08e8
        L_0x0557:
            boolean r10 = r0.a(r1, (int) r12, (int) r6)
            if (r10 == 0) goto L_0x09dc
            long r3 = e(r1, r3)
            int r3 = com.google.android.gms.internal.firebase_ml.ft.f((int) r12, (long) r3)
            goto L_0x08e8
        L_0x0567:
            boolean r10 = r0.a(r1, (int) r12, (int) r6)
            if (r10 == 0) goto L_0x09dc
            int r3 = d(r1, r3)
            int r3 = com.google.android.gms.internal.firebase_ml.ft.h(r12, r3)
            goto L_0x08e8
        L_0x0577:
            boolean r3 = r0.a(r1, (int) r12, (int) r6)
            if (r3 == 0) goto L_0x09dc
            int r3 = com.google.android.gms.internal.firebase_ml.ft.h(r12)
            goto L_0x08e8
        L_0x0583:
            boolean r3 = r0.a(r1, (int) r12, (int) r6)
            if (r3 == 0) goto L_0x09dc
            int r3 = com.google.android.gms.internal.firebase_ml.ft.f((int) r12)
            goto L_0x08e8
        L_0x058f:
            boolean r10 = r0.a(r1, (int) r12, (int) r6)
            if (r10 == 0) goto L_0x09dc
            int r3 = d(r1, r3)
            int r3 = com.google.android.gms.internal.firebase_ml.ft.i(r12, r3)
            goto L_0x08e8
        L_0x059f:
            boolean r10 = r0.a(r1, (int) r12, (int) r6)
            if (r10 == 0) goto L_0x09dc
            int r3 = d(r1, r3)
            int r3 = com.google.android.gms.internal.firebase_ml.ft.g(r12, r3)
            goto L_0x08e8
        L_0x05af:
            boolean r10 = r0.a(r1, (int) r12, (int) r6)
            if (r10 == 0) goto L_0x09dc
            java.lang.Object r3 = r2.getObject(r1, r3)
            com.google.android.gms.internal.firebase_ml.fh r3 = (com.google.android.gms.internal.firebase_ml.fh) r3
            int r3 = com.google.android.gms.internal.firebase_ml.ft.c((int) r12, (com.google.android.gms.internal.firebase_ml.fh) r3)
            goto L_0x08e8
        L_0x05c1:
            boolean r10 = r0.a(r1, (int) r12, (int) r6)
            if (r10 == 0) goto L_0x09dc
            java.lang.Object r3 = r2.getObject(r1, r3)
            com.google.android.gms.internal.firebase_ml.ig r4 = r0.a((int) r6)
            int r3 = com.google.android.gms.internal.firebase_ml.ii.a((int) r12, (java.lang.Object) r3, (com.google.android.gms.internal.firebase_ml.ig) r4)
            goto L_0x08e8
        L_0x05d5:
            boolean r10 = r0.a(r1, (int) r12, (int) r6)
            if (r10 == 0) goto L_0x09dc
            java.lang.Object r3 = r2.getObject(r1, r3)
            boolean r4 = r3 instanceof com.google.android.gms.internal.firebase_ml.fh
            if (r4 == 0) goto L_0x05eb
            com.google.android.gms.internal.firebase_ml.fh r3 = (com.google.android.gms.internal.firebase_ml.fh) r3
            int r3 = com.google.android.gms.internal.firebase_ml.ft.c((int) r12, (com.google.android.gms.internal.firebase_ml.fh) r3)
            goto L_0x08e8
        L_0x05eb:
            java.lang.String r3 = (java.lang.String) r3
            int r3 = com.google.android.gms.internal.firebase_ml.ft.b((int) r12, (java.lang.String) r3)
            goto L_0x08e8
        L_0x05f3:
            boolean r3 = r0.a(r1, (int) r12, (int) r6)
            if (r3 == 0) goto L_0x09dc
            int r3 = com.google.android.gms.internal.firebase_ml.ft.k(r12)
            goto L_0x08e8
        L_0x05ff:
            boolean r3 = r0.a(r1, (int) r12, (int) r6)
            if (r3 == 0) goto L_0x09dc
            int r3 = com.google.android.gms.internal.firebase_ml.ft.e((int) r12)
            goto L_0x08e8
        L_0x060b:
            boolean r3 = r0.a(r1, (int) r12, (int) r6)
            if (r3 == 0) goto L_0x09dc
            int r3 = com.google.android.gms.internal.firebase_ml.ft.g((int) r12)
            goto L_0x08e8
        L_0x0617:
            boolean r10 = r0.a(r1, (int) r12, (int) r6)
            if (r10 == 0) goto L_0x09dc
            int r3 = d(r1, r3)
            int r3 = com.google.android.gms.internal.firebase_ml.ft.f((int) r12, (int) r3)
            goto L_0x08e8
        L_0x0627:
            boolean r10 = r0.a(r1, (int) r12, (int) r6)
            if (r10 == 0) goto L_0x09dc
            long r3 = e(r1, r3)
            int r3 = com.google.android.gms.internal.firebase_ml.ft.e((int) r12, (long) r3)
            goto L_0x08e8
        L_0x0637:
            boolean r10 = r0.a(r1, (int) r12, (int) r6)
            if (r10 == 0) goto L_0x09dc
            long r3 = e(r1, r3)
            int r3 = com.google.android.gms.internal.firebase_ml.ft.d((int) r12, (long) r3)
            goto L_0x08e8
        L_0x0647:
            boolean r3 = r0.a(r1, (int) r12, (int) r6)
            if (r3 == 0) goto L_0x09dc
            int r3 = com.google.android.gms.internal.firebase_ml.ft.i(r12)
            goto L_0x08e8
        L_0x0653:
            boolean r3 = r0.a(r1, (int) r12, (int) r6)
            if (r3 == 0) goto L_0x09dc
            int r3 = com.google.android.gms.internal.firebase_ml.ft.j(r12)
            goto L_0x08e8
        L_0x065f:
            com.google.android.gms.internal.firebase_ml.hk r10 = r0.s
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.lang.Object r4 = r0.b((int) r6)
            int r3 = r10.a(r12, r3, r4)
            goto L_0x08e8
        L_0x066f:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            com.google.android.gms.internal.firebase_ml.ig r4 = r0.a((int) r6)
            int r3 = com.google.android.gms.internal.firebase_ml.ii.b((int) r12, (java.util.List<com.google.android.gms.internal.firebase_ml.hn>) r3, (com.google.android.gms.internal.firebase_ml.ig) r4)
            goto L_0x08e8
        L_0x067f:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.firebase_ml.ii.c(r3)
            if (r3 <= 0) goto L_0x09dc
            boolean r4 = r0.k
            if (r4 == 0) goto L_0x0693
            long r10 = (long) r11
            r2.putInt(r1, r10, r3)
        L_0x0693:
            int r4 = com.google.android.gms.internal.firebase_ml.ft.l(r12)
            int r10 = com.google.android.gms.internal.firebase_ml.ft.n(r3)
            goto L_0x081e
        L_0x069d:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.firebase_ml.ii.g(r3)
            if (r3 <= 0) goto L_0x09dc
            boolean r4 = r0.k
            if (r4 == 0) goto L_0x06b1
            long r10 = (long) r11
            r2.putInt(r1, r10, r3)
        L_0x06b1:
            int r4 = com.google.android.gms.internal.firebase_ml.ft.l(r12)
            int r10 = com.google.android.gms.internal.firebase_ml.ft.n(r3)
            goto L_0x081e
        L_0x06bb:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.firebase_ml.ii.i(r3)
            if (r3 <= 0) goto L_0x09dc
            boolean r4 = r0.k
            if (r4 == 0) goto L_0x06cf
            long r10 = (long) r11
            r2.putInt(r1, r10, r3)
        L_0x06cf:
            int r4 = com.google.android.gms.internal.firebase_ml.ft.l(r12)
            int r10 = com.google.android.gms.internal.firebase_ml.ft.n(r3)
            goto L_0x081e
        L_0x06d9:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.firebase_ml.ii.h(r3)
            if (r3 <= 0) goto L_0x09dc
            boolean r4 = r0.k
            if (r4 == 0) goto L_0x06ed
            long r10 = (long) r11
            r2.putInt(r1, r10, r3)
        L_0x06ed:
            int r4 = com.google.android.gms.internal.firebase_ml.ft.l(r12)
            int r10 = com.google.android.gms.internal.firebase_ml.ft.n(r3)
            goto L_0x081e
        L_0x06f7:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.firebase_ml.ii.d(r3)
            if (r3 <= 0) goto L_0x09dc
            boolean r4 = r0.k
            if (r4 == 0) goto L_0x070b
            long r10 = (long) r11
            r2.putInt(r1, r10, r3)
        L_0x070b:
            int r4 = com.google.android.gms.internal.firebase_ml.ft.l(r12)
            int r10 = com.google.android.gms.internal.firebase_ml.ft.n(r3)
            goto L_0x081e
        L_0x0715:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.firebase_ml.ii.f(r3)
            if (r3 <= 0) goto L_0x09dc
            boolean r4 = r0.k
            if (r4 == 0) goto L_0x0729
            long r10 = (long) r11
            r2.putInt(r1, r10, r3)
        L_0x0729:
            int r4 = com.google.android.gms.internal.firebase_ml.ft.l(r12)
            int r10 = com.google.android.gms.internal.firebase_ml.ft.n(r3)
            goto L_0x081e
        L_0x0733:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.firebase_ml.ii.j(r3)
            if (r3 <= 0) goto L_0x09dc
            boolean r4 = r0.k
            if (r4 == 0) goto L_0x0747
            long r10 = (long) r11
            r2.putInt(r1, r10, r3)
        L_0x0747:
            int r4 = com.google.android.gms.internal.firebase_ml.ft.l(r12)
            int r10 = com.google.android.gms.internal.firebase_ml.ft.n(r3)
            goto L_0x081e
        L_0x0751:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.firebase_ml.ii.h(r3)
            if (r3 <= 0) goto L_0x09dc
            boolean r4 = r0.k
            if (r4 == 0) goto L_0x0765
            long r10 = (long) r11
            r2.putInt(r1, r10, r3)
        L_0x0765:
            int r4 = com.google.android.gms.internal.firebase_ml.ft.l(r12)
            int r10 = com.google.android.gms.internal.firebase_ml.ft.n(r3)
            goto L_0x081e
        L_0x076f:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.firebase_ml.ii.i(r3)
            if (r3 <= 0) goto L_0x09dc
            boolean r4 = r0.k
            if (r4 == 0) goto L_0x0783
            long r10 = (long) r11
            r2.putInt(r1, r10, r3)
        L_0x0783:
            int r4 = com.google.android.gms.internal.firebase_ml.ft.l(r12)
            int r10 = com.google.android.gms.internal.firebase_ml.ft.n(r3)
            goto L_0x081e
        L_0x078d:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.firebase_ml.ii.e(r3)
            if (r3 <= 0) goto L_0x09dc
            boolean r4 = r0.k
            if (r4 == 0) goto L_0x07a1
            long r10 = (long) r11
            r2.putInt(r1, r10, r3)
        L_0x07a1:
            int r4 = com.google.android.gms.internal.firebase_ml.ft.l(r12)
            int r10 = com.google.android.gms.internal.firebase_ml.ft.n(r3)
            goto L_0x081e
        L_0x07ab:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.firebase_ml.ii.b(r3)
            if (r3 <= 0) goto L_0x09dc
            boolean r4 = r0.k
            if (r4 == 0) goto L_0x07bf
            long r10 = (long) r11
            r2.putInt(r1, r10, r3)
        L_0x07bf:
            int r4 = com.google.android.gms.internal.firebase_ml.ft.l(r12)
            int r10 = com.google.android.gms.internal.firebase_ml.ft.n(r3)
            goto L_0x081e
        L_0x07c8:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.firebase_ml.ii.a((java.util.List<java.lang.Long>) r3)
            if (r3 <= 0) goto L_0x09dc
            boolean r4 = r0.k
            if (r4 == 0) goto L_0x07dc
            long r10 = (long) r11
            r2.putInt(r1, r10, r3)
        L_0x07dc:
            int r4 = com.google.android.gms.internal.firebase_ml.ft.l(r12)
            int r10 = com.google.android.gms.internal.firebase_ml.ft.n(r3)
            goto L_0x081e
        L_0x07e5:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.firebase_ml.ii.h(r3)
            if (r3 <= 0) goto L_0x09dc
            boolean r4 = r0.k
            if (r4 == 0) goto L_0x07f9
            long r10 = (long) r11
            r2.putInt(r1, r10, r3)
        L_0x07f9:
            int r4 = com.google.android.gms.internal.firebase_ml.ft.l(r12)
            int r10 = com.google.android.gms.internal.firebase_ml.ft.n(r3)
            goto L_0x081e
        L_0x0802:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.firebase_ml.ii.i(r3)
            if (r3 <= 0) goto L_0x09dc
            boolean r4 = r0.k
            if (r4 == 0) goto L_0x0816
            long r10 = (long) r11
            r2.putInt(r1, r10, r3)
        L_0x0816:
            int r4 = com.google.android.gms.internal.firebase_ml.ft.l(r12)
            int r10 = com.google.android.gms.internal.firebase_ml.ft.n(r3)
        L_0x081e:
            int r4 = r4 + r10
            int r4 = r4 + r3
            int r7 = r7 + r4
            goto L_0x09dc
        L_0x0823:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.firebase_ml.ii.c(r12, r3)
            goto L_0x08e8
        L_0x082f:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.firebase_ml.ii.g(r12, r3)
            goto L_0x08e8
        L_0x083b:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.firebase_ml.ii.i(r12, r3)
            goto L_0x08e8
        L_0x0847:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.firebase_ml.ii.h(r12, r3)
            goto L_0x08e8
        L_0x0853:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.firebase_ml.ii.d(r12, r3)
            goto L_0x08e8
        L_0x085f:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.firebase_ml.ii.f(r12, r3)
            goto L_0x08e8
        L_0x086b:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.firebase_ml.ii.l(r12, r3)
            goto L_0x08e8
        L_0x0877:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            com.google.android.gms.internal.firebase_ml.ig r4 = r0.a((int) r6)
            int r3 = com.google.android.gms.internal.firebase_ml.ii.a((int) r12, (java.util.List<?>) r3, (com.google.android.gms.internal.firebase_ml.ig) r4)
            goto L_0x08e8
        L_0x0886:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.firebase_ml.ii.k(r12, r3)
            goto L_0x08e8
        L_0x0891:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.firebase_ml.ii.j(r12, r3)
            goto L_0x08e8
        L_0x089c:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.firebase_ml.ii.h(r12, r3)
            goto L_0x08e8
        L_0x08a7:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.firebase_ml.ii.i(r12, r3)
            goto L_0x08e8
        L_0x08b2:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.firebase_ml.ii.e(r12, r3)
            goto L_0x08e8
        L_0x08bd:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.firebase_ml.ii.b(r12, r3)
            goto L_0x08e8
        L_0x08c8:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.firebase_ml.ii.a((int) r12, (java.util.List<java.lang.Long>) r3)
            goto L_0x08e8
        L_0x08d3:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.firebase_ml.ii.h(r12, r3)
            goto L_0x08e8
        L_0x08de:
            java.lang.Object r3 = r2.getObject(r1, r3)
            java.util.List r3 = (java.util.List) r3
            int r3 = com.google.android.gms.internal.firebase_ml.ii.i(r12, r3)
        L_0x08e8:
            int r7 = r7 + r3
            goto L_0x09dc
        L_0x08eb:
            r10 = r9 & r15
            if (r10 == 0) goto L_0x09dc
            java.lang.Object r3 = r2.getObject(r1, r3)
            com.google.android.gms.internal.firebase_ml.hn r3 = (com.google.android.gms.internal.firebase_ml.hn) r3
            com.google.android.gms.internal.firebase_ml.ig r4 = r0.a((int) r6)
            int r3 = com.google.android.gms.internal.firebase_ml.ft.c(r12, r3, r4)
            goto L_0x08e8
        L_0x08fe:
            r10 = r9 & r15
            if (r10 == 0) goto L_0x09dc
            long r3 = r2.getLong(r1, r3)
            int r3 = com.google.android.gms.internal.firebase_ml.ft.f((int) r12, (long) r3)
            goto L_0x08e8
        L_0x090b:
            r10 = r9 & r15
            if (r10 == 0) goto L_0x09dc
            int r3 = r2.getInt(r1, r3)
            int r3 = com.google.android.gms.internal.firebase_ml.ft.h(r12, r3)
            goto L_0x08e8
        L_0x0918:
            r3 = r9 & r15
            if (r3 == 0) goto L_0x09dc
            int r3 = com.google.android.gms.internal.firebase_ml.ft.h(r12)
            goto L_0x08e8
        L_0x0921:
            r3 = r9 & r15
            if (r3 == 0) goto L_0x09dc
            int r3 = com.google.android.gms.internal.firebase_ml.ft.f((int) r12)
            goto L_0x08e8
        L_0x092a:
            r10 = r9 & r15
            if (r10 == 0) goto L_0x09dc
            int r3 = r2.getInt(r1, r3)
            int r3 = com.google.android.gms.internal.firebase_ml.ft.i(r12, r3)
            goto L_0x08e8
        L_0x0937:
            r10 = r9 & r15
            if (r10 == 0) goto L_0x09dc
            int r3 = r2.getInt(r1, r3)
            int r3 = com.google.android.gms.internal.firebase_ml.ft.g(r12, r3)
            goto L_0x08e8
        L_0x0944:
            r10 = r9 & r15
            if (r10 == 0) goto L_0x09dc
            java.lang.Object r3 = r2.getObject(r1, r3)
            com.google.android.gms.internal.firebase_ml.fh r3 = (com.google.android.gms.internal.firebase_ml.fh) r3
            int r3 = com.google.android.gms.internal.firebase_ml.ft.c((int) r12, (com.google.android.gms.internal.firebase_ml.fh) r3)
            goto L_0x08e8
        L_0x0953:
            r10 = r9 & r15
            if (r10 == 0) goto L_0x09dc
            java.lang.Object r3 = r2.getObject(r1, r3)
            com.google.android.gms.internal.firebase_ml.ig r4 = r0.a((int) r6)
            int r3 = com.google.android.gms.internal.firebase_ml.ii.a((int) r12, (java.lang.Object) r3, (com.google.android.gms.internal.firebase_ml.ig) r4)
            goto L_0x08e8
        L_0x0964:
            r10 = r9 & r15
            if (r10 == 0) goto L_0x09dc
            java.lang.Object r3 = r2.getObject(r1, r3)
            boolean r4 = r3 instanceof com.google.android.gms.internal.firebase_ml.fh
            if (r4 == 0) goto L_0x0978
            com.google.android.gms.internal.firebase_ml.fh r3 = (com.google.android.gms.internal.firebase_ml.fh) r3
            int r3 = com.google.android.gms.internal.firebase_ml.ft.c((int) r12, (com.google.android.gms.internal.firebase_ml.fh) r3)
            goto L_0x08e8
        L_0x0978:
            java.lang.String r3 = (java.lang.String) r3
            int r3 = com.google.android.gms.internal.firebase_ml.ft.b((int) r12, (java.lang.String) r3)
            goto L_0x08e8
        L_0x0980:
            r3 = r9 & r15
            if (r3 == 0) goto L_0x09dc
            int r3 = com.google.android.gms.internal.firebase_ml.ft.k(r12)
            goto L_0x08e8
        L_0x098a:
            r3 = r9 & r15
            if (r3 == 0) goto L_0x09dc
            int r3 = com.google.android.gms.internal.firebase_ml.ft.e((int) r12)
            goto L_0x08e8
        L_0x0994:
            r3 = r9 & r15
            if (r3 == 0) goto L_0x09dc
            int r3 = com.google.android.gms.internal.firebase_ml.ft.g((int) r12)
            goto L_0x08e8
        L_0x099e:
            r10 = r9 & r15
            if (r10 == 0) goto L_0x09dc
            int r3 = r2.getInt(r1, r3)
            int r3 = com.google.android.gms.internal.firebase_ml.ft.f((int) r12, (int) r3)
            goto L_0x08e8
        L_0x09ac:
            r10 = r9 & r15
            if (r10 == 0) goto L_0x09dc
            long r3 = r2.getLong(r1, r3)
            int r3 = com.google.android.gms.internal.firebase_ml.ft.e((int) r12, (long) r3)
            goto L_0x08e8
        L_0x09ba:
            r10 = r9 & r15
            if (r10 == 0) goto L_0x09dc
            long r3 = r2.getLong(r1, r3)
            int r3 = com.google.android.gms.internal.firebase_ml.ft.d((int) r12, (long) r3)
            goto L_0x08e8
        L_0x09c8:
            r3 = r9 & r15
            if (r3 == 0) goto L_0x09dc
            int r3 = com.google.android.gms.internal.firebase_ml.ft.i(r12)
            goto L_0x08e8
        L_0x09d2:
            r3 = r9 & r15
            if (r3 == 0) goto L_0x09dc
            int r3 = com.google.android.gms.internal.firebase_ml.ft.j(r12)
            goto L_0x08e8
        L_0x09dc:
            int r6 = r6 + 3
            r3 = 267386880(0xff00000, float:2.3665827E-29)
            r4 = 1048575(0xfffff, float:1.469367E-39)
            goto L_0x04f0
        L_0x09e5:
            com.google.android.gms.internal.firebase_ml.ix<?, ?> r2 = r0.q
            int r2 = a(r2, r1)
            int r7 = r7 + r2
            boolean r2 = r0.f9970h
            if (r2 == 0) goto L_0x0a3e
            com.google.android.gms.internal.firebase_ml.fy<?> r2 = r0.r
            com.google.android.gms.internal.firebase_ml.fz r1 = r2.a((java.lang.Object) r1)
            r2 = 0
        L_0x09f7:
            com.google.android.gms.internal.firebase_ml.il<T, java.lang.Object> r3 = r1.f9908a
            int r3 = r3.b()
            if (r5 >= r3) goto L_0x0a17
            com.google.android.gms.internal.firebase_ml.il<T, java.lang.Object> r3 = r1.f9908a
            java.util.Map$Entry r3 = r3.b((int) r5)
            java.lang.Object r4 = r3.getKey()
            com.google.android.gms.internal.firebase_ml.gb r4 = (com.google.android.gms.internal.firebase_ml.gb) r4
            java.lang.Object r3 = r3.getValue()
            int r3 = com.google.android.gms.internal.firebase_ml.fz.a((com.google.android.gms.internal.firebase_ml.gb<?>) r4, (java.lang.Object) r3)
            int r2 = r2 + r3
            int r5 = r5 + 1
            goto L_0x09f7
        L_0x0a17:
            com.google.android.gms.internal.firebase_ml.il<T, java.lang.Object> r1 = r1.f9908a
            java.lang.Iterable r1 = r1.c()
            java.util.Iterator r1 = r1.iterator()
        L_0x0a21:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x0a3d
            java.lang.Object r3 = r1.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r4 = r3.getKey()
            com.google.android.gms.internal.firebase_ml.gb r4 = (com.google.android.gms.internal.firebase_ml.gb) r4
            java.lang.Object r3 = r3.getValue()
            int r3 = com.google.android.gms.internal.firebase_ml.fz.a((com.google.android.gms.internal.firebase_ml.gb<?>) r4, (java.lang.Object) r3)
            int r2 = r2 + r3
            goto L_0x0a21
        L_0x0a3d:
            int r7 = r7 + r2
        L_0x0a3e:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_ml.hr.b(java.lang.Object):int");
    }

    private static <UT, UB> int a(ix<UT, UB> ixVar, T t) {
        return ixVar.d(ixVar.a(t));
    }

    private static List<?> a(Object obj, long j2) {
        return (List) d.f(obj, j2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x052e  */
    /* JADX WARNING: Removed duplicated region for block: B:182:0x056e  */
    /* JADX WARNING: Removed duplicated region for block: B:335:0x0a46  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(T r14, com.google.android.gms.internal.firebase_ml.s r15) throws java.io.IOException {
        /*
            r13 = this;
            int r0 = r15.a()
            int r1 = com.google.android.gms.internal.firebase_ml.gg.e.k
            r2 = 267386880(0xff00000, float:2.3665827E-29)
            r3 = 0
            r4 = 1
            r5 = 0
            r6 = 1048575(0xfffff, float:1.469367E-39)
            if (r0 != r1) goto L_0x0544
            com.google.android.gms.internal.firebase_ml.ix<?, ?> r0 = r13.q
            a(r0, r14, (com.google.android.gms.internal.firebase_ml.s) r15)
            boolean r0 = r13.f9970h
            if (r0 == 0) goto L_0x004d
            com.google.android.gms.internal.firebase_ml.fy<?> r0 = r13.r
            com.google.android.gms.internal.firebase_ml.fz r0 = r0.a((java.lang.Object) r14)
            com.google.android.gms.internal.firebase_ml.il<T, java.lang.Object> r1 = r0.f9908a
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x004d
            boolean r1 = r0.f9910c
            if (r1 == 0) goto L_0x003c
            com.google.android.gms.internal.firebase_ml.gu r1 = new com.google.android.gms.internal.firebase_ml.gu
            com.google.android.gms.internal.firebase_ml.il<T, java.lang.Object> r0 = r0.f9908a
            java.util.Set r0 = r0.d()
            java.util.Iterator r0 = r0.iterator()
            r1.<init>(r0)
            r0 = r1
            goto L_0x0046
        L_0x003c:
            com.google.android.gms.internal.firebase_ml.il<T, java.lang.Object> r0 = r0.f9908a
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
            int[] r7 = r13.f9965c
            int r7 = r7.length
            int r7 = r7 + -3
        L_0x0054:
            if (r7 < 0) goto L_0x052c
            int r8 = r13.c((int) r7)
            int[] r9 = r13.f9965c
            r9 = r9[r7]
        L_0x005e:
            if (r1 == 0) goto L_0x007c
            com.google.android.gms.internal.firebase_ml.fy<?> r10 = r13.r
            int r10 = r10.a((java.util.Map.Entry<?, ?>) r1)
            if (r10 <= r9) goto L_0x007c
            com.google.android.gms.internal.firebase_ml.fy<?> r10 = r13.r
            r10.b((java.util.Map.Entry<?, ?>) r1)
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
            java.lang.Object r8 = com.google.android.gms.internal.firebase_ml.d.f(r14, r10)
            com.google.android.gms.internal.firebase_ml.ig r10 = r13.a((int) r7)
            r15.b((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.firebase_ml.ig) r10)
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
            java.lang.Object r8 = com.google.android.gms.internal.firebase_ml.d.f(r14, r10)
            com.google.android.gms.internal.firebase_ml.fh r8 = (com.google.android.gms.internal.firebase_ml.fh) r8
            r15.a((int) r9, (com.google.android.gms.internal.firebase_ml.fh) r8)
            goto L_0x0528
        L_0x0113:
            boolean r10 = r13.a(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_ml.d.f(r14, r10)
            com.google.android.gms.internal.firebase_ml.ig r10 = r13.a((int) r7)
            r15.a((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.firebase_ml.ig) r10)
            goto L_0x0528
        L_0x0128:
            boolean r10 = r13.a(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_ml.d.f(r14, r10)
            a((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.firebase_ml.s) r15)
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
            java.lang.Object r8 = com.google.android.gms.internal.firebase_ml.d.f(r14, r10)
            r13.a(r15, r9, r8, r7)
            goto L_0x0528
        L_0x01cc:
            int[] r9 = r13.f9965c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_ml.d.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_ml.ig r10 = r13.a((int) r7)
            com.google.android.gms.internal.firebase_ml.ii.b((int) r9, (java.util.List<?>) r8, (com.google.android.gms.internal.firebase_ml.s) r15, (com.google.android.gms.internal.firebase_ml.ig) r10)
            goto L_0x0528
        L_0x01e1:
            int[] r9 = r13.f9965c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_ml.d.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_ml.ii.e(r9, r8, r15, r4)
            goto L_0x0528
        L_0x01f2:
            int[] r9 = r13.f9965c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_ml.d.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_ml.ii.j(r9, r8, r15, r4)
            goto L_0x0528
        L_0x0203:
            int[] r9 = r13.f9965c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_ml.d.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_ml.ii.g(r9, r8, r15, r4)
            goto L_0x0528
        L_0x0214:
            int[] r9 = r13.f9965c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_ml.d.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_ml.ii.l(r9, r8, r15, r4)
            goto L_0x0528
        L_0x0225:
            int[] r9 = r13.f9965c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_ml.d.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_ml.ii.m(r9, r8, r15, r4)
            goto L_0x0528
        L_0x0236:
            int[] r9 = r13.f9965c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_ml.d.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_ml.ii.i(r9, r8, r15, r4)
            goto L_0x0528
        L_0x0247:
            int[] r9 = r13.f9965c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_ml.d.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_ml.ii.n(r9, r8, r15, r4)
            goto L_0x0528
        L_0x0258:
            int[] r9 = r13.f9965c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_ml.d.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_ml.ii.k(r9, r8, r15, r4)
            goto L_0x0528
        L_0x0269:
            int[] r9 = r13.f9965c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_ml.d.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_ml.ii.f(r9, r8, r15, r4)
            goto L_0x0528
        L_0x027a:
            int[] r9 = r13.f9965c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_ml.d.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_ml.ii.h(r9, r8, r15, r4)
            goto L_0x0528
        L_0x028b:
            int[] r9 = r13.f9965c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_ml.d.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_ml.ii.d(r9, r8, r15, r4)
            goto L_0x0528
        L_0x029c:
            int[] r9 = r13.f9965c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_ml.d.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_ml.ii.c(r9, r8, r15, r4)
            goto L_0x0528
        L_0x02ad:
            int[] r9 = r13.f9965c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_ml.d.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_ml.ii.b((int) r9, (java.util.List<java.lang.Float>) r8, (com.google.android.gms.internal.firebase_ml.s) r15, (boolean) r4)
            goto L_0x0528
        L_0x02be:
            int[] r9 = r13.f9965c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_ml.d.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_ml.ii.a((int) r9, (java.util.List<java.lang.Double>) r8, (com.google.android.gms.internal.firebase_ml.s) r15, (boolean) r4)
            goto L_0x0528
        L_0x02cf:
            int[] r9 = r13.f9965c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_ml.d.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_ml.ii.e(r9, r8, r15, r5)
            goto L_0x0528
        L_0x02e0:
            int[] r9 = r13.f9965c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_ml.d.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_ml.ii.j(r9, r8, r15, r5)
            goto L_0x0528
        L_0x02f1:
            int[] r9 = r13.f9965c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_ml.d.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_ml.ii.g(r9, r8, r15, r5)
            goto L_0x0528
        L_0x0302:
            int[] r9 = r13.f9965c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_ml.d.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_ml.ii.l(r9, r8, r15, r5)
            goto L_0x0528
        L_0x0313:
            int[] r9 = r13.f9965c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_ml.d.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_ml.ii.m(r9, r8, r15, r5)
            goto L_0x0528
        L_0x0324:
            int[] r9 = r13.f9965c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_ml.d.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_ml.ii.i(r9, r8, r15, r5)
            goto L_0x0528
        L_0x0335:
            int[] r9 = r13.f9965c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_ml.d.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_ml.ii.b((int) r9, (java.util.List<com.google.android.gms.internal.firebase_ml.fh>) r8, (com.google.android.gms.internal.firebase_ml.s) r15)
            goto L_0x0528
        L_0x0346:
            int[] r9 = r13.f9965c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_ml.d.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_ml.ig r10 = r13.a((int) r7)
            com.google.android.gms.internal.firebase_ml.ii.a((int) r9, (java.util.List<?>) r8, (com.google.android.gms.internal.firebase_ml.s) r15, (com.google.android.gms.internal.firebase_ml.ig) r10)
            goto L_0x0528
        L_0x035b:
            int[] r9 = r13.f9965c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_ml.d.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_ml.ii.a((int) r9, (java.util.List<java.lang.String>) r8, (com.google.android.gms.internal.firebase_ml.s) r15)
            goto L_0x0528
        L_0x036c:
            int[] r9 = r13.f9965c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_ml.d.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_ml.ii.n(r9, r8, r15, r5)
            goto L_0x0528
        L_0x037d:
            int[] r9 = r13.f9965c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_ml.d.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_ml.ii.k(r9, r8, r15, r5)
            goto L_0x0528
        L_0x038e:
            int[] r9 = r13.f9965c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_ml.d.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_ml.ii.f(r9, r8, r15, r5)
            goto L_0x0528
        L_0x039f:
            int[] r9 = r13.f9965c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_ml.d.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_ml.ii.h(r9, r8, r15, r5)
            goto L_0x0528
        L_0x03b0:
            int[] r9 = r13.f9965c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_ml.d.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_ml.ii.d(r9, r8, r15, r5)
            goto L_0x0528
        L_0x03c1:
            int[] r9 = r13.f9965c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_ml.d.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_ml.ii.c(r9, r8, r15, r5)
            goto L_0x0528
        L_0x03d2:
            int[] r9 = r13.f9965c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_ml.d.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_ml.ii.b((int) r9, (java.util.List<java.lang.Float>) r8, (com.google.android.gms.internal.firebase_ml.s) r15, (boolean) r5)
            goto L_0x0528
        L_0x03e3:
            int[] r9 = r13.f9965c
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_ml.d.f(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_ml.ii.a((int) r9, (java.util.List<java.lang.Double>) r8, (com.google.android.gms.internal.firebase_ml.s) r15, (boolean) r5)
            goto L_0x0528
        L_0x03f4:
            boolean r10 = r13.a(r14, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_ml.d.f(r14, r10)
            com.google.android.gms.internal.firebase_ml.ig r10 = r13.a((int) r7)
            r15.b((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.firebase_ml.ig) r10)
            goto L_0x0528
        L_0x0409:
            boolean r10 = r13.a(r14, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.firebase_ml.d.b(r14, r10)
            r15.e((int) r9, (long) r10)
            goto L_0x0528
        L_0x041a:
            boolean r10 = r13.a(r14, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.firebase_ml.d.a((java.lang.Object) r14, (long) r10)
            r15.f(r9, r8)
            goto L_0x0528
        L_0x042b:
            boolean r10 = r13.a(r14, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.firebase_ml.d.b(r14, r10)
            r15.b((int) r9, (long) r10)
            goto L_0x0528
        L_0x043c:
            boolean r10 = r13.a(r14, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.firebase_ml.d.a((java.lang.Object) r14, (long) r10)
            r15.a((int) r9, (int) r8)
            goto L_0x0528
        L_0x044d:
            boolean r10 = r13.a(r14, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.firebase_ml.d.a((java.lang.Object) r14, (long) r10)
            r15.b((int) r9, (int) r8)
            goto L_0x0528
        L_0x045e:
            boolean r10 = r13.a(r14, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.firebase_ml.d.a((java.lang.Object) r14, (long) r10)
            r15.e((int) r9, (int) r8)
            goto L_0x0528
        L_0x046f:
            boolean r10 = r13.a(r14, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_ml.d.f(r14, r10)
            com.google.android.gms.internal.firebase_ml.fh r8 = (com.google.android.gms.internal.firebase_ml.fh) r8
            r15.a((int) r9, (com.google.android.gms.internal.firebase_ml.fh) r8)
            goto L_0x0528
        L_0x0482:
            boolean r10 = r13.a(r14, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_ml.d.f(r14, r10)
            com.google.android.gms.internal.firebase_ml.ig r10 = r13.a((int) r7)
            r15.a((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.firebase_ml.ig) r10)
            goto L_0x0528
        L_0x0497:
            boolean r10 = r13.a(r14, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_ml.d.f(r14, r10)
            a((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.firebase_ml.s) r15)
            goto L_0x0528
        L_0x04a8:
            boolean r10 = r13.a(r14, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            boolean r8 = com.google.android.gms.internal.firebase_ml.d.c(r14, r10)
            r15.a((int) r9, (boolean) r8)
            goto L_0x0528
        L_0x04b9:
            boolean r10 = r13.a(r14, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.firebase_ml.d.a((java.lang.Object) r14, (long) r10)
            r15.d((int) r9, (int) r8)
            goto L_0x0528
        L_0x04c9:
            boolean r10 = r13.a(r14, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.firebase_ml.d.b(r14, r10)
            r15.d((int) r9, (long) r10)
            goto L_0x0528
        L_0x04d9:
            boolean r10 = r13.a(r14, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.firebase_ml.d.a((java.lang.Object) r14, (long) r10)
            r15.c((int) r9, (int) r8)
            goto L_0x0528
        L_0x04e9:
            boolean r10 = r13.a(r14, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.firebase_ml.d.b(r14, r10)
            r15.c((int) r9, (long) r10)
            goto L_0x0528
        L_0x04f9:
            boolean r10 = r13.a(r14, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.firebase_ml.d.b(r14, r10)
            r15.a((int) r9, (long) r10)
            goto L_0x0528
        L_0x0509:
            boolean r10 = r13.a(r14, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            float r8 = com.google.android.gms.internal.firebase_ml.d.d(r14, r10)
            r15.a((int) r9, (float) r8)
            goto L_0x0528
        L_0x0519:
            boolean r10 = r13.a(r14, (int) r7)
            if (r10 == 0) goto L_0x0528
            r8 = r8 & r6
            long r10 = (long) r8
            double r10 = com.google.android.gms.internal.firebase_ml.d.e(r14, r10)
            r15.a((int) r9, (double) r10)
        L_0x0528:
            int r7 = r7 + -3
            goto L_0x0054
        L_0x052c:
            if (r1 == 0) goto L_0x0543
            com.google.android.gms.internal.firebase_ml.fy<?> r14 = r13.r
            r14.b((java.util.Map.Entry<?, ?>) r1)
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
            boolean r0 = r13.f9970h
            if (r0 == 0) goto L_0x0565
            com.google.android.gms.internal.firebase_ml.fy<?> r0 = r13.r
            com.google.android.gms.internal.firebase_ml.fz r0 = r0.a((java.lang.Object) r14)
            com.google.android.gms.internal.firebase_ml.il<T, java.lang.Object> r1 = r0.f9908a
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
            int[] r7 = r13.f9965c
            int r7 = r7.length
            r8 = r1
            r1 = 0
        L_0x056c:
            if (r1 >= r7) goto L_0x0a44
            int r9 = r13.c((int) r1)
            int[] r10 = r13.f9965c
            r10 = r10[r1]
        L_0x0576:
            if (r8 == 0) goto L_0x0594
            com.google.android.gms.internal.firebase_ml.fy<?> r11 = r13.r
            int r11 = r11.a((java.util.Map.Entry<?, ?>) r8)
            if (r11 > r10) goto L_0x0594
            com.google.android.gms.internal.firebase_ml.fy<?> r11 = r13.r
            r11.b((java.util.Map.Entry<?, ?>) r8)
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
            java.lang.Object r9 = com.google.android.gms.internal.firebase_ml.d.f(r14, r11)
            com.google.android.gms.internal.firebase_ml.ig r11 = r13.a((int) r1)
            r15.b((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.firebase_ml.ig) r11)
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
            java.lang.Object r9 = com.google.android.gms.internal.firebase_ml.d.f(r14, r11)
            com.google.android.gms.internal.firebase_ml.fh r9 = (com.google.android.gms.internal.firebase_ml.fh) r9
            r15.a((int) r10, (com.google.android.gms.internal.firebase_ml.fh) r9)
            goto L_0x0a40
        L_0x062b:
            boolean r11 = r13.a(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_ml.d.f(r14, r11)
            com.google.android.gms.internal.firebase_ml.ig r11 = r13.a((int) r1)
            r15.a((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.firebase_ml.ig) r11)
            goto L_0x0a40
        L_0x0640:
            boolean r11 = r13.a(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_ml.d.f(r14, r11)
            a((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.firebase_ml.s) r15)
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
            java.lang.Object r9 = com.google.android.gms.internal.firebase_ml.d.f(r14, r11)
            r13.a(r15, r10, r9, r1)
            goto L_0x0a40
        L_0x06e4:
            int[] r10 = r13.f9965c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_ml.d.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_ml.ig r11 = r13.a((int) r1)
            com.google.android.gms.internal.firebase_ml.ii.b((int) r10, (java.util.List<?>) r9, (com.google.android.gms.internal.firebase_ml.s) r15, (com.google.android.gms.internal.firebase_ml.ig) r11)
            goto L_0x0a40
        L_0x06f9:
            int[] r10 = r13.f9965c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_ml.d.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_ml.ii.e(r10, r9, r15, r4)
            goto L_0x0a40
        L_0x070a:
            int[] r10 = r13.f9965c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_ml.d.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_ml.ii.j(r10, r9, r15, r4)
            goto L_0x0a40
        L_0x071b:
            int[] r10 = r13.f9965c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_ml.d.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_ml.ii.g(r10, r9, r15, r4)
            goto L_0x0a40
        L_0x072c:
            int[] r10 = r13.f9965c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_ml.d.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_ml.ii.l(r10, r9, r15, r4)
            goto L_0x0a40
        L_0x073d:
            int[] r10 = r13.f9965c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_ml.d.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_ml.ii.m(r10, r9, r15, r4)
            goto L_0x0a40
        L_0x074e:
            int[] r10 = r13.f9965c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_ml.d.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_ml.ii.i(r10, r9, r15, r4)
            goto L_0x0a40
        L_0x075f:
            int[] r10 = r13.f9965c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_ml.d.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_ml.ii.n(r10, r9, r15, r4)
            goto L_0x0a40
        L_0x0770:
            int[] r10 = r13.f9965c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_ml.d.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_ml.ii.k(r10, r9, r15, r4)
            goto L_0x0a40
        L_0x0781:
            int[] r10 = r13.f9965c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_ml.d.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_ml.ii.f(r10, r9, r15, r4)
            goto L_0x0a40
        L_0x0792:
            int[] r10 = r13.f9965c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_ml.d.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_ml.ii.h(r10, r9, r15, r4)
            goto L_0x0a40
        L_0x07a3:
            int[] r10 = r13.f9965c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_ml.d.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_ml.ii.d(r10, r9, r15, r4)
            goto L_0x0a40
        L_0x07b4:
            int[] r10 = r13.f9965c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_ml.d.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_ml.ii.c(r10, r9, r15, r4)
            goto L_0x0a40
        L_0x07c5:
            int[] r10 = r13.f9965c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_ml.d.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_ml.ii.b((int) r10, (java.util.List<java.lang.Float>) r9, (com.google.android.gms.internal.firebase_ml.s) r15, (boolean) r4)
            goto L_0x0a40
        L_0x07d6:
            int[] r10 = r13.f9965c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_ml.d.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_ml.ii.a((int) r10, (java.util.List<java.lang.Double>) r9, (com.google.android.gms.internal.firebase_ml.s) r15, (boolean) r4)
            goto L_0x0a40
        L_0x07e7:
            int[] r10 = r13.f9965c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_ml.d.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_ml.ii.e(r10, r9, r15, r5)
            goto L_0x0a40
        L_0x07f8:
            int[] r10 = r13.f9965c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_ml.d.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_ml.ii.j(r10, r9, r15, r5)
            goto L_0x0a40
        L_0x0809:
            int[] r10 = r13.f9965c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_ml.d.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_ml.ii.g(r10, r9, r15, r5)
            goto L_0x0a40
        L_0x081a:
            int[] r10 = r13.f9965c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_ml.d.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_ml.ii.l(r10, r9, r15, r5)
            goto L_0x0a40
        L_0x082b:
            int[] r10 = r13.f9965c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_ml.d.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_ml.ii.m(r10, r9, r15, r5)
            goto L_0x0a40
        L_0x083c:
            int[] r10 = r13.f9965c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_ml.d.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_ml.ii.i(r10, r9, r15, r5)
            goto L_0x0a40
        L_0x084d:
            int[] r10 = r13.f9965c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_ml.d.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_ml.ii.b((int) r10, (java.util.List<com.google.android.gms.internal.firebase_ml.fh>) r9, (com.google.android.gms.internal.firebase_ml.s) r15)
            goto L_0x0a40
        L_0x085e:
            int[] r10 = r13.f9965c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_ml.d.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_ml.ig r11 = r13.a((int) r1)
            com.google.android.gms.internal.firebase_ml.ii.a((int) r10, (java.util.List<?>) r9, (com.google.android.gms.internal.firebase_ml.s) r15, (com.google.android.gms.internal.firebase_ml.ig) r11)
            goto L_0x0a40
        L_0x0873:
            int[] r10 = r13.f9965c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_ml.d.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_ml.ii.a((int) r10, (java.util.List<java.lang.String>) r9, (com.google.android.gms.internal.firebase_ml.s) r15)
            goto L_0x0a40
        L_0x0884:
            int[] r10 = r13.f9965c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_ml.d.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_ml.ii.n(r10, r9, r15, r5)
            goto L_0x0a40
        L_0x0895:
            int[] r10 = r13.f9965c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_ml.d.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_ml.ii.k(r10, r9, r15, r5)
            goto L_0x0a40
        L_0x08a6:
            int[] r10 = r13.f9965c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_ml.d.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_ml.ii.f(r10, r9, r15, r5)
            goto L_0x0a40
        L_0x08b7:
            int[] r10 = r13.f9965c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_ml.d.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_ml.ii.h(r10, r9, r15, r5)
            goto L_0x0a40
        L_0x08c8:
            int[] r10 = r13.f9965c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_ml.d.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_ml.ii.d(r10, r9, r15, r5)
            goto L_0x0a40
        L_0x08d9:
            int[] r10 = r13.f9965c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_ml.d.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_ml.ii.c(r10, r9, r15, r5)
            goto L_0x0a40
        L_0x08ea:
            int[] r10 = r13.f9965c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_ml.d.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_ml.ii.b((int) r10, (java.util.List<java.lang.Float>) r9, (com.google.android.gms.internal.firebase_ml.s) r15, (boolean) r5)
            goto L_0x0a40
        L_0x08fb:
            int[] r10 = r13.f9965c
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_ml.d.f(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_ml.ii.a((int) r10, (java.util.List<java.lang.Double>) r9, (com.google.android.gms.internal.firebase_ml.s) r15, (boolean) r5)
            goto L_0x0a40
        L_0x090c:
            boolean r11 = r13.a(r14, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_ml.d.f(r14, r11)
            com.google.android.gms.internal.firebase_ml.ig r11 = r13.a((int) r1)
            r15.b((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.firebase_ml.ig) r11)
            goto L_0x0a40
        L_0x0921:
            boolean r11 = r13.a(r14, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.firebase_ml.d.b(r14, r11)
            r15.e((int) r10, (long) r11)
            goto L_0x0a40
        L_0x0932:
            boolean r11 = r13.a(r14, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.firebase_ml.d.a((java.lang.Object) r14, (long) r11)
            r15.f(r10, r9)
            goto L_0x0a40
        L_0x0943:
            boolean r11 = r13.a(r14, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.firebase_ml.d.b(r14, r11)
            r15.b((int) r10, (long) r11)
            goto L_0x0a40
        L_0x0954:
            boolean r11 = r13.a(r14, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.firebase_ml.d.a((java.lang.Object) r14, (long) r11)
            r15.a((int) r10, (int) r9)
            goto L_0x0a40
        L_0x0965:
            boolean r11 = r13.a(r14, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.firebase_ml.d.a((java.lang.Object) r14, (long) r11)
            r15.b((int) r10, (int) r9)
            goto L_0x0a40
        L_0x0976:
            boolean r11 = r13.a(r14, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.firebase_ml.d.a((java.lang.Object) r14, (long) r11)
            r15.e((int) r10, (int) r9)
            goto L_0x0a40
        L_0x0987:
            boolean r11 = r13.a(r14, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_ml.d.f(r14, r11)
            com.google.android.gms.internal.firebase_ml.fh r9 = (com.google.android.gms.internal.firebase_ml.fh) r9
            r15.a((int) r10, (com.google.android.gms.internal.firebase_ml.fh) r9)
            goto L_0x0a40
        L_0x099a:
            boolean r11 = r13.a(r14, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_ml.d.f(r14, r11)
            com.google.android.gms.internal.firebase_ml.ig r11 = r13.a((int) r1)
            r15.a((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.firebase_ml.ig) r11)
            goto L_0x0a40
        L_0x09af:
            boolean r11 = r13.a(r14, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_ml.d.f(r14, r11)
            a((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.firebase_ml.s) r15)
            goto L_0x0a40
        L_0x09c0:
            boolean r11 = r13.a(r14, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            boolean r9 = com.google.android.gms.internal.firebase_ml.d.c(r14, r11)
            r15.a((int) r10, (boolean) r9)
            goto L_0x0a40
        L_0x09d1:
            boolean r11 = r13.a(r14, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.firebase_ml.d.a((java.lang.Object) r14, (long) r11)
            r15.d((int) r10, (int) r9)
            goto L_0x0a40
        L_0x09e1:
            boolean r11 = r13.a(r14, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.firebase_ml.d.b(r14, r11)
            r15.d((int) r10, (long) r11)
            goto L_0x0a40
        L_0x09f1:
            boolean r11 = r13.a(r14, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.firebase_ml.d.a((java.lang.Object) r14, (long) r11)
            r15.c((int) r10, (int) r9)
            goto L_0x0a40
        L_0x0a01:
            boolean r11 = r13.a(r14, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.firebase_ml.d.b(r14, r11)
            r15.c((int) r10, (long) r11)
            goto L_0x0a40
        L_0x0a11:
            boolean r11 = r13.a(r14, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.firebase_ml.d.b(r14, r11)
            r15.a((int) r10, (long) r11)
            goto L_0x0a40
        L_0x0a21:
            boolean r11 = r13.a(r14, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            float r9 = com.google.android.gms.internal.firebase_ml.d.d(r14, r11)
            r15.a((int) r10, (float) r9)
            goto L_0x0a40
        L_0x0a31:
            boolean r11 = r13.a(r14, (int) r1)
            if (r11 == 0) goto L_0x0a40
            r9 = r9 & r6
            long r11 = (long) r9
            double r11 = com.google.android.gms.internal.firebase_ml.d.e(r14, r11)
            r15.a((int) r10, (double) r11)
        L_0x0a40:
            int r1 = r1 + 3
            goto L_0x056c
        L_0x0a44:
            if (r8 == 0) goto L_0x0a5b
            com.google.android.gms.internal.firebase_ml.fy<?> r1 = r13.r
            r1.b((java.util.Map.Entry<?, ?>) r8)
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
            com.google.android.gms.internal.firebase_ml.ix<?, ?> r0 = r13.q
            a(r0, r14, (com.google.android.gms.internal.firebase_ml.s) r15)
            return
        L_0x0a61:
            r13.b(r14, (com.google.android.gms.internal.firebase_ml.s) r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_ml.hr.a(java.lang.Object, com.google.android.gms.internal.firebase_ml.s):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:172:0x049e  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0032  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void b(T r18, com.google.android.gms.internal.firebase_ml.s r19) throws java.io.IOException {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r19
            boolean r3 = r0.f9970h
            if (r3 == 0) goto L_0x0023
            com.google.android.gms.internal.firebase_ml.fy<?> r3 = r0.r
            com.google.android.gms.internal.firebase_ml.fz r3 = r3.a((java.lang.Object) r1)
            com.google.android.gms.internal.firebase_ml.il<T, java.lang.Object> r5 = r3.f9908a
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
            int[] r6 = r0.f9965c
            int r6 = r6.length
            sun.misc.Unsafe r7 = f9964b
            r11 = r5
            r5 = 0
            r10 = 1048575(0xfffff, float:1.469367E-39)
            r12 = 0
        L_0x0030:
            if (r5 >= r6) goto L_0x049b
            int r13 = r0.c((int) r5)
            int[] r14 = r0.f9965c
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
            com.google.android.gms.internal.firebase_ml.fy<?> r8 = r0.r
            int r8 = r8.a((java.util.Map.Entry<?, ?>) r11)
            if (r8 > r15) goto L_0x0085
            com.google.android.gms.internal.firebase_ml.fy<?> r8 = r0.r
            r8.b((java.util.Map.Entry<?, ?>) r11)
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
            com.google.android.gms.internal.firebase_ml.ig r9 = r0.a((int) r5)
            r2.b((int) r15, (java.lang.Object) r4, (com.google.android.gms.internal.firebase_ml.ig) r9)
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
            com.google.android.gms.internal.firebase_ml.fh r4 = (com.google.android.gms.internal.firebase_ml.fh) r4
            r2.a((int) r15, (com.google.android.gms.internal.firebase_ml.fh) r4)
            goto L_0x008d
        L_0x0106:
            boolean r4 = r0.a(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x008d
            java.lang.Object r4 = r7.getObject(r1, r13)
            com.google.android.gms.internal.firebase_ml.ig r9 = r0.a((int) r5)
            r2.a((int) r15, (java.lang.Object) r4, (com.google.android.gms.internal.firebase_ml.ig) r9)
            goto L_0x008d
        L_0x0119:
            boolean r4 = r0.a(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x008d
            java.lang.Object r4 = r7.getObject(r1, r13)
            a((int) r15, (java.lang.Object) r4, (com.google.android.gms.internal.firebase_ml.s) r2)
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
            r0.a(r2, r15, r4, r5)
            goto L_0x008d
        L_0x01a9:
            int[] r4 = r0.f9965c
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_ml.ig r13 = r0.a((int) r5)
            com.google.android.gms.internal.firebase_ml.ii.b((int) r4, (java.util.List<?>) r9, (com.google.android.gms.internal.firebase_ml.s) r2, (com.google.android.gms.internal.firebase_ml.ig) r13)
            goto L_0x008d
        L_0x01bc:
            int[] r4 = r0.f9965c
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            r15 = 1
            com.google.android.gms.internal.firebase_ml.ii.e(r4, r9, r2, r15)
            goto L_0x008d
        L_0x01cc:
            r15 = 1
            int[] r4 = r0.f9965c
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_ml.ii.j(r4, r9, r2, r15)
            goto L_0x008d
        L_0x01dc:
            r15 = 1
            int[] r4 = r0.f9965c
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_ml.ii.g(r4, r9, r2, r15)
            goto L_0x008d
        L_0x01ec:
            r15 = 1
            int[] r4 = r0.f9965c
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_ml.ii.l(r4, r9, r2, r15)
            goto L_0x008d
        L_0x01fc:
            r15 = 1
            int[] r4 = r0.f9965c
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_ml.ii.m(r4, r9, r2, r15)
            goto L_0x008d
        L_0x020c:
            r15 = 1
            int[] r4 = r0.f9965c
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_ml.ii.i(r4, r9, r2, r15)
            goto L_0x008d
        L_0x021c:
            r15 = 1
            int[] r4 = r0.f9965c
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_ml.ii.n(r4, r9, r2, r15)
            goto L_0x008d
        L_0x022c:
            r15 = 1
            int[] r4 = r0.f9965c
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_ml.ii.k(r4, r9, r2, r15)
            goto L_0x008d
        L_0x023c:
            r15 = 1
            int[] r4 = r0.f9965c
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_ml.ii.f(r4, r9, r2, r15)
            goto L_0x008d
        L_0x024c:
            r15 = 1
            int[] r4 = r0.f9965c
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_ml.ii.h(r4, r9, r2, r15)
            goto L_0x008d
        L_0x025c:
            r15 = 1
            int[] r4 = r0.f9965c
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_ml.ii.d(r4, r9, r2, r15)
            goto L_0x008d
        L_0x026c:
            r15 = 1
            int[] r4 = r0.f9965c
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_ml.ii.c(r4, r9, r2, r15)
            goto L_0x008d
        L_0x027c:
            r15 = 1
            int[] r4 = r0.f9965c
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_ml.ii.b((int) r4, (java.util.List<java.lang.Float>) r9, (com.google.android.gms.internal.firebase_ml.s) r2, (boolean) r15)
            goto L_0x008d
        L_0x028c:
            r15 = 1
            int[] r4 = r0.f9965c
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_ml.ii.a((int) r4, (java.util.List<java.lang.Double>) r9, (com.google.android.gms.internal.firebase_ml.s) r2, (boolean) r15)
            goto L_0x008d
        L_0x029c:
            int[] r4 = r0.f9965c
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            r15 = 0
            com.google.android.gms.internal.firebase_ml.ii.e(r4, r9, r2, r15)
            goto L_0x008d
        L_0x02ac:
            r15 = 0
            int[] r4 = r0.f9965c
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_ml.ii.j(r4, r9, r2, r15)
            goto L_0x008d
        L_0x02bc:
            r15 = 0
            int[] r4 = r0.f9965c
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_ml.ii.g(r4, r9, r2, r15)
            goto L_0x008d
        L_0x02cc:
            r15 = 0
            int[] r4 = r0.f9965c
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_ml.ii.l(r4, r9, r2, r15)
            goto L_0x008d
        L_0x02dc:
            r15 = 0
            int[] r4 = r0.f9965c
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_ml.ii.m(r4, r9, r2, r15)
            goto L_0x008d
        L_0x02ec:
            r15 = 0
            int[] r4 = r0.f9965c
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_ml.ii.i(r4, r9, r2, r15)
            goto L_0x008d
        L_0x02fc:
            int[] r4 = r0.f9965c
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_ml.ii.b((int) r4, (java.util.List<com.google.android.gms.internal.firebase_ml.fh>) r9, (com.google.android.gms.internal.firebase_ml.s) r2)
            goto L_0x008d
        L_0x030b:
            int[] r4 = r0.f9965c
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_ml.ig r13 = r0.a((int) r5)
            com.google.android.gms.internal.firebase_ml.ii.a((int) r4, (java.util.List<?>) r9, (com.google.android.gms.internal.firebase_ml.s) r2, (com.google.android.gms.internal.firebase_ml.ig) r13)
            goto L_0x008d
        L_0x031e:
            int[] r4 = r0.f9965c
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_ml.ii.a((int) r4, (java.util.List<java.lang.String>) r9, (com.google.android.gms.internal.firebase_ml.s) r2)
            goto L_0x008d
        L_0x032d:
            int[] r4 = r0.f9965c
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            r15 = 0
            com.google.android.gms.internal.firebase_ml.ii.n(r4, r9, r2, r15)
            goto L_0x008d
        L_0x033d:
            r15 = 0
            int[] r4 = r0.f9965c
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_ml.ii.k(r4, r9, r2, r15)
            goto L_0x008d
        L_0x034d:
            r15 = 0
            int[] r4 = r0.f9965c
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_ml.ii.f(r4, r9, r2, r15)
            goto L_0x008d
        L_0x035d:
            r15 = 0
            int[] r4 = r0.f9965c
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_ml.ii.h(r4, r9, r2, r15)
            goto L_0x008d
        L_0x036d:
            r15 = 0
            int[] r4 = r0.f9965c
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_ml.ii.d(r4, r9, r2, r15)
            goto L_0x008d
        L_0x037d:
            r15 = 0
            int[] r4 = r0.f9965c
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_ml.ii.c(r4, r9, r2, r15)
            goto L_0x008d
        L_0x038d:
            r15 = 0
            int[] r4 = r0.f9965c
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_ml.ii.b((int) r4, (java.util.List<java.lang.Float>) r9, (com.google.android.gms.internal.firebase_ml.s) r2, (boolean) r15)
            goto L_0x008d
        L_0x039d:
            r15 = 0
            int[] r4 = r0.f9965c
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_ml.ii.a((int) r4, (java.util.List<java.lang.Double>) r9, (com.google.android.gms.internal.firebase_ml.s) r2, (boolean) r15)
            goto L_0x008d
        L_0x03ad:
            r4 = 0
            r9 = r9 & r12
            if (r9 == 0) goto L_0x0497
            java.lang.Object r9 = r7.getObject(r1, r13)
            com.google.android.gms.internal.firebase_ml.ig r13 = r0.a((int) r5)
            r2.b((int) r15, (java.lang.Object) r9, (com.google.android.gms.internal.firebase_ml.ig) r13)
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
            com.google.android.gms.internal.firebase_ml.fh r9 = (com.google.android.gms.internal.firebase_ml.fh) r9
            r2.a((int) r15, (com.google.android.gms.internal.firebase_ml.fh) r9)
            goto L_0x0497
        L_0x041b:
            r4 = 0
            r9 = r9 & r12
            if (r9 == 0) goto L_0x0497
            java.lang.Object r9 = r7.getObject(r1, r13)
            com.google.android.gms.internal.firebase_ml.ig r13 = r0.a((int) r5)
            r2.a((int) r15, (java.lang.Object) r9, (com.google.android.gms.internal.firebase_ml.ig) r13)
            goto L_0x0497
        L_0x042c:
            r4 = 0
            r9 = r9 & r12
            if (r9 == 0) goto L_0x0497
            java.lang.Object r9 = r7.getObject(r1, r13)
            a((int) r15, (java.lang.Object) r9, (com.google.android.gms.internal.firebase_ml.s) r2)
            goto L_0x0497
        L_0x0438:
            r4 = 0
            r9 = r9 & r12
            if (r9 == 0) goto L_0x0497
            boolean r9 = com.google.android.gms.internal.firebase_ml.d.c(r1, r13)
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
            float r9 = com.google.android.gms.internal.firebase_ml.d.d(r1, r13)
            r2.a((int) r15, (float) r9)
            goto L_0x0497
        L_0x048c:
            r4 = 0
            r9 = r9 & r12
            if (r9 == 0) goto L_0x0497
            double r13 = com.google.android.gms.internal.firebase_ml.d.e(r1, r13)
            r2.a((int) r15, (double) r13)
        L_0x0497:
            int r5 = r5 + 3
            goto L_0x0030
        L_0x049b:
            r14 = r11
        L_0x049c:
            if (r14 == 0) goto L_0x04b3
            com.google.android.gms.internal.firebase_ml.fy<?> r4 = r0.r
            r4.b((java.util.Map.Entry<?, ?>) r14)
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
            com.google.android.gms.internal.firebase_ml.ix<?, ?> r3 = r0.q
            a(r3, r1, (com.google.android.gms.internal.firebase_ml.s) r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_ml.hr.b(java.lang.Object, com.google.android.gms.internal.firebase_ml.s):void");
    }

    private final <K, V> void a(s sVar, int i2, Object obj, int i3) throws IOException {
        if (obj != null) {
            sVar.a(i2, this.s.a(b(i3)), this.s.b(obj));
        }
    }

    private static <UT, UB> void a(ix<UT, UB> ixVar, T t, s sVar) throws IOException {
        ixVar.a(ixVar.a(t), sVar);
    }

    private final ig a(int i2) {
        int i3 = (i2 / 3) << 1;
        ig igVar = (ig) this.f9966d[i3];
        if (igVar != null) {
            return igVar;
        }
        ig a2 = ib.a().a((Class) this.f9966d[i3 + 1]);
        this.f9966d[i3] = a2;
        return a2;
    }

    private final Object b(int i2) {
        return this.f9966d[(i2 / 3) << 1];
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
            Object f2 = d.f(t, c2);
            if (f2 != null) {
                d.a((Object) t, c2, this.s.c(f2));
            }
            i3++;
        }
        int length = this.l.length;
        while (i2 < length) {
            this.p.a(t, (long) this.l[i2]);
            i2++;
        }
        this.q.b(t);
        if (this.f9970h) {
            this.r.c(t);
        }
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
                return !this.f9970h || this.r.a((Object) t2).d();
            }
            int i7 = this.l[i6];
            int i8 = this.f9965c[i7];
            int c2 = c(i7);
            int i9 = this.f9965c[i7 + 2];
            int i10 = i9 & 1048575;
            int i11 = 1 << (i9 >>> 20);
            if (i10 != i4) {
                i2 = i10 != 1048575 ? f9964b.getInt(t2, (long) i10) : i5;
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
                            Map<?, ?> b2 = this.s.b(d.f(t2, (long) (c2 & 1048575)));
                            if (!b2.isEmpty()) {
                                if (this.s.a(b(i7)).f9960b.zzxi() == q.MESSAGE) {
                                    ig<?> igVar = null;
                                    Iterator<?> it2 = b2.values().iterator();
                                    while (true) {
                                        if (!it2.hasNext()) {
                                            break;
                                        }
                                        Object next = it2.next();
                                        if (igVar == null) {
                                            igVar = ib.a().a(next.getClass());
                                        }
                                        if (!igVar.d(next)) {
                                            z = false;
                                            break;
                                        }
                                    }
                                }
                            }
                            if (!z) {
                                return false;
                            }
                        }
                    }
                }
                List list = (List) d.f(t2, (long) (c2 & 1048575));
                if (!list.isEmpty()) {
                    ig a2 = a(i7);
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

    private static boolean a(Object obj, int i2, ig igVar) {
        return igVar.d(d.f(obj, (long) (i2 & 1048575)));
    }

    private static void a(int i2, Object obj, s sVar) throws IOException {
        if (obj instanceof String) {
            sVar.a(i2, (String) obj);
        } else {
            sVar.a(i2, (fh) obj);
        }
    }

    private final int c(int i2) {
        return this.f9965c[i2 + 1];
    }

    private final int d(int i2) {
        return this.f9965c[i2 + 2];
    }

    private static <T> double b(T t, long j2) {
        return ((Double) d.f(t, j2)).doubleValue();
    }

    private static <T> float c(T t, long j2) {
        return ((Float) d.f(t, j2)).floatValue();
    }

    private static <T> int d(T t, long j2) {
        return ((Integer) d.f(t, j2)).intValue();
    }

    private static <T> long e(T t, long j2) {
        return ((Long) d.f(t, j2)).longValue();
    }

    private static <T> boolean f(T t, long j2) {
        return ((Boolean) d.f(t, j2)).booleanValue();
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
                    return d.e(t, j3) != 0.0d;
                case 1:
                    return d.d(t, j3) != 0.0f;
                case 2:
                    return d.b(t, j3) != 0;
                case 3:
                    return d.b(t, j3) != 0;
                case 4:
                    return d.a((Object) t, j3) != 0;
                case 5:
                    return d.b(t, j3) != 0;
                case 6:
                    return d.a((Object) t, j3) != 0;
                case 7:
                    return d.c(t, j3);
                case 8:
                    Object f2 = d.f(t, j3);
                    if (f2 instanceof String) {
                        return !((String) f2).isEmpty();
                    }
                    if (f2 instanceof fh) {
                        return !fh.zzchp.equals(f2);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    return d.f(t, j3) != null;
                case 10:
                    return !fh.zzchp.equals(d.f(t, j3));
                case 11:
                    return d.a((Object) t, j3) != 0;
                case 12:
                    return d.a((Object) t, j3) != 0;
                case 13:
                    return d.a((Object) t, j3) != 0;
                case 14:
                    return d.b(t, j3) != 0;
                case 15:
                    return d.a((Object) t, j3) != 0;
                case 16:
                    return d.b(t, j3) != 0;
                case 17:
                    return d.f(t, j3) != null;
                default:
                    throw new IllegalArgumentException();
            }
        } else {
            return (d.a((Object) t, j2) & (1 << (d2 >>> 20))) != 0;
        }
    }

    private final void b(T t, int i2) {
        int d2 = d(i2);
        long j2 = (long) (1048575 & d2);
        if (j2 != 1048575) {
            d.a((Object) t, j2, (1 << (d2 >>> 20)) | d.a((Object) t, j2));
        }
    }

    private final boolean a(T t, int i2, int i3) {
        return d.a((Object) t, (long) (d(i3) & 1048575)) == i2;
    }

    private final void b(T t, int i2, int i3) {
        d.a((Object) t, (long) (d(i3) & 1048575), i2);
    }
}
