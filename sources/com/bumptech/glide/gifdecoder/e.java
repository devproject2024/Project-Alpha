package com.bumptech.glide.gifdecoder;

import android.graphics.Bitmap;
import com.bumptech.glide.gifdecoder.a;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Iterator;
import net.one97.paytm.upi.util.UpiConstants;

public class e implements a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f6649a = e.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private int[] f6650b;

    /* renamed from: c  reason: collision with root package name */
    private final int[] f6651c;

    /* renamed from: d  reason: collision with root package name */
    private final a.C0092a f6652d;

    /* renamed from: e  reason: collision with root package name */
    private ByteBuffer f6653e;

    /* renamed from: f  reason: collision with root package name */
    private byte[] f6654f;

    /* renamed from: g  reason: collision with root package name */
    private short[] f6655g;

    /* renamed from: h  reason: collision with root package name */
    private byte[] f6656h;

    /* renamed from: i  reason: collision with root package name */
    private byte[] f6657i;
    private byte[] j;
    private int[] k;
    private int l;
    private c m;
    private Bitmap n;
    private boolean o;
    private int p;
    private int q;
    private int r;
    private int s;
    private Boolean t;
    private Bitmap.Config u;

    public e(a.C0092a aVar, c cVar, ByteBuffer byteBuffer, int i2) {
        this(aVar);
        a(cVar, byteBuffer, i2);
    }

    private e(a.C0092a aVar) {
        this.f6651c = new int[UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS];
        this.u = Bitmap.Config.ARGB_8888;
        this.f6652d = aVar;
        this.m = new c();
    }

    public final ByteBuffer a() {
        return this.f6653e;
    }

    public final void b() {
        this.l = (this.l + 1) % this.m.f6638c;
    }

    public final int c() {
        int i2;
        if (this.m.f6638c <= 0 || (i2 = this.l) < 0) {
            return 0;
        }
        if (i2 < 0 || i2 >= this.m.f6638c) {
            return -1;
        }
        return this.m.f6640e.get(i2).f6635i;
    }

    public final int d() {
        return this.m.f6638c;
    }

    public final int e() {
        return this.l;
    }

    public final void f() {
        this.l = -1;
    }

    public final int g() {
        return this.f6653e.limit() + this.j.length + (this.k.length * 4);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00d1, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized android.graphics.Bitmap h() {
        /*
            r8 = this;
            monitor-enter(r8)
            com.bumptech.glide.gifdecoder.c r0 = r8.m     // Catch:{ all -> 0x00d2 }
            int r0 = r0.f6638c     // Catch:{ all -> 0x00d2 }
            r1 = 3
            r2 = 1
            if (r0 <= 0) goto L_0x000d
            int r0 = r8.l     // Catch:{ all -> 0x00d2 }
            if (r0 >= 0) goto L_0x002f
        L_0x000d:
            java.lang.String r0 = f6649a     // Catch:{ all -> 0x00d2 }
            boolean r0 = android.util.Log.isLoggable(r0, r1)     // Catch:{ all -> 0x00d2 }
            if (r0 == 0) goto L_0x002d
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d2 }
            java.lang.String r3 = "Unable to decode frame, frameCount="
            r0.<init>(r3)     // Catch:{ all -> 0x00d2 }
            com.bumptech.glide.gifdecoder.c r3 = r8.m     // Catch:{ all -> 0x00d2 }
            int r3 = r3.f6638c     // Catch:{ all -> 0x00d2 }
            r0.append(r3)     // Catch:{ all -> 0x00d2 }
            java.lang.String r3 = ", framePointer="
            r0.append(r3)     // Catch:{ all -> 0x00d2 }
            int r3 = r8.l     // Catch:{ all -> 0x00d2 }
            r0.append(r3)     // Catch:{ all -> 0x00d2 }
        L_0x002d:
            r8.p = r2     // Catch:{ all -> 0x00d2 }
        L_0x002f:
            int r0 = r8.p     // Catch:{ all -> 0x00d2 }
            r3 = 0
            if (r0 == r2) goto L_0x00bc
            int r0 = r8.p     // Catch:{ all -> 0x00d2 }
            r4 = 2
            if (r0 != r4) goto L_0x003b
            goto L_0x00bc
        L_0x003b:
            r0 = 0
            r8.p = r0     // Catch:{ all -> 0x00d2 }
            byte[] r5 = r8.f6654f     // Catch:{ all -> 0x00d2 }
            if (r5 != 0) goto L_0x004c
            com.bumptech.glide.gifdecoder.a$a r5 = r8.f6652d     // Catch:{ all -> 0x00d2 }
            r6 = 255(0xff, float:3.57E-43)
            byte[] r5 = r5.a((int) r6)     // Catch:{ all -> 0x00d2 }
            r8.f6654f = r5     // Catch:{ all -> 0x00d2 }
        L_0x004c:
            com.bumptech.glide.gifdecoder.c r5 = r8.m     // Catch:{ all -> 0x00d2 }
            java.util.List<com.bumptech.glide.gifdecoder.b> r5 = r5.f6640e     // Catch:{ all -> 0x00d2 }
            int r6 = r8.l     // Catch:{ all -> 0x00d2 }
            java.lang.Object r5 = r5.get(r6)     // Catch:{ all -> 0x00d2 }
            com.bumptech.glide.gifdecoder.b r5 = (com.bumptech.glide.gifdecoder.b) r5     // Catch:{ all -> 0x00d2 }
            int r6 = r8.l     // Catch:{ all -> 0x00d2 }
            int r6 = r6 - r2
            if (r6 < 0) goto L_0x0068
            com.bumptech.glide.gifdecoder.c r7 = r8.m     // Catch:{ all -> 0x00d2 }
            java.util.List<com.bumptech.glide.gifdecoder.b> r7 = r7.f6640e     // Catch:{ all -> 0x00d2 }
            java.lang.Object r6 = r7.get(r6)     // Catch:{ all -> 0x00d2 }
            com.bumptech.glide.gifdecoder.b r6 = (com.bumptech.glide.gifdecoder.b) r6     // Catch:{ all -> 0x00d2 }
            goto L_0x0069
        L_0x0068:
            r6 = r3
        L_0x0069:
            int[] r7 = r5.k     // Catch:{ all -> 0x00d2 }
            if (r7 == 0) goto L_0x0070
            int[] r7 = r5.k     // Catch:{ all -> 0x00d2 }
            goto L_0x0074
        L_0x0070:
            com.bumptech.glide.gifdecoder.c r7 = r8.m     // Catch:{ all -> 0x00d2 }
            int[] r7 = r7.f6636a     // Catch:{ all -> 0x00d2 }
        L_0x0074:
            r8.f6650b = r7     // Catch:{ all -> 0x00d2 }
            int[] r7 = r8.f6650b     // Catch:{ all -> 0x00d2 }
            if (r7 != 0) goto L_0x0092
            java.lang.String r0 = f6649a     // Catch:{ all -> 0x00d2 }
            boolean r0 = android.util.Log.isLoggable(r0, r1)     // Catch:{ all -> 0x00d2 }
            if (r0 == 0) goto L_0x008e
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d2 }
            java.lang.String r1 = "No valid color table found for frame #"
            r0.<init>(r1)     // Catch:{ all -> 0x00d2 }
            int r1 = r8.l     // Catch:{ all -> 0x00d2 }
            r0.append(r1)     // Catch:{ all -> 0x00d2 }
        L_0x008e:
            r8.p = r2     // Catch:{ all -> 0x00d2 }
            monitor-exit(r8)
            return r3
        L_0x0092:
            boolean r1 = r5.f6632f     // Catch:{ all -> 0x00d2 }
            if (r1 == 0) goto L_0x00b6
            int[] r1 = r8.f6650b     // Catch:{ all -> 0x00d2 }
            int[] r2 = r8.f6651c     // Catch:{ all -> 0x00d2 }
            int[] r3 = r8.f6650b     // Catch:{ all -> 0x00d2 }
            int r3 = r3.length     // Catch:{ all -> 0x00d2 }
            java.lang.System.arraycopy(r1, r0, r2, r0, r3)     // Catch:{ all -> 0x00d2 }
            int[] r1 = r8.f6651c     // Catch:{ all -> 0x00d2 }
            r8.f6650b = r1     // Catch:{ all -> 0x00d2 }
            int[] r1 = r8.f6650b     // Catch:{ all -> 0x00d2 }
            int r2 = r5.f6634h     // Catch:{ all -> 0x00d2 }
            r1[r2] = r0     // Catch:{ all -> 0x00d2 }
            int r0 = r5.f6633g     // Catch:{ all -> 0x00d2 }
            if (r0 != r4) goto L_0x00b6
            int r0 = r8.l     // Catch:{ all -> 0x00d2 }
            if (r0 != 0) goto L_0x00b6
            java.lang.Boolean r0 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x00d2 }
            r8.t = r0     // Catch:{ all -> 0x00d2 }
        L_0x00b6:
            android.graphics.Bitmap r0 = r8.a(r5, r6)     // Catch:{ all -> 0x00d2 }
            monitor-exit(r8)
            return r0
        L_0x00bc:
            java.lang.String r0 = f6649a     // Catch:{ all -> 0x00d2 }
            boolean r0 = android.util.Log.isLoggable(r0, r1)     // Catch:{ all -> 0x00d2 }
            if (r0 == 0) goto L_0x00d0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d2 }
            java.lang.String r1 = "Unable to decode frame, status="
            r0.<init>(r1)     // Catch:{ all -> 0x00d2 }
            int r1 = r8.p     // Catch:{ all -> 0x00d2 }
            r0.append(r1)     // Catch:{ all -> 0x00d2 }
        L_0x00d0:
            monitor-exit(r8)
            return r3
        L_0x00d2:
            r0 = move-exception
            monitor-exit(r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.gifdecoder.e.h():android.graphics.Bitmap");
    }

    public final void i() {
        this.m = null;
        byte[] bArr = this.j;
        if (bArr != null) {
            this.f6652d.a(bArr);
        }
        int[] iArr = this.k;
        if (iArr != null) {
            this.f6652d.a(iArr);
        }
        Bitmap bitmap = this.n;
        if (bitmap != null) {
            this.f6652d.a(bitmap);
        }
        this.n = null;
        this.f6653e = null;
        this.t = null;
        byte[] bArr2 = this.f6654f;
        if (bArr2 != null) {
            this.f6652d.a(bArr2);
        }
    }

    private synchronized void a(c cVar, ByteBuffer byteBuffer, int i2) {
        if (i2 > 0) {
            int highestOneBit = Integer.highestOneBit(i2);
            this.p = 0;
            this.m = cVar;
            this.l = -1;
            this.f6653e = byteBuffer.asReadOnlyBuffer();
            this.f6653e.position(0);
            this.f6653e.order(ByteOrder.LITTLE_ENDIAN);
            this.o = false;
            Iterator<b> it2 = cVar.f6640e.iterator();
            while (true) {
                if (it2.hasNext()) {
                    if (it2.next().f6633g == 3) {
                        this.o = true;
                        break;
                    }
                } else {
                    break;
                }
            }
            this.q = highestOneBit;
            this.s = cVar.f6641f / highestOneBit;
            this.r = cVar.f6642g / highestOneBit;
            this.j = this.f6652d.a(cVar.f6641f * cVar.f6642g);
            this.k = this.f6652d.b(this.s * this.r);
        } else {
            throw new IllegalArgumentException("Sample size must be >=0, not: ".concat(String.valueOf(i2)));
        }
    }

    public final void a(Bitmap.Config config) {
        if (config == Bitmap.Config.ARGB_8888 || config == Bitmap.Config.RGB_565) {
            this.u = config;
            return;
        }
        throw new IllegalArgumentException("Unsupported format: " + config + ", must be one of " + Bitmap.Config.ARGB_8888 + " or " + Bitmap.Config.RGB_565);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v22, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v23, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r26v12, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r22v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v19, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v32, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v33, resolved type: byte} */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0045, code lost:
        if (r0.m.j == r1.f6634h) goto L_0x0047;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0066  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.Bitmap a(com.bumptech.glide.gifdecoder.b r39, com.bumptech.glide.gifdecoder.b r40) {
        /*
            r38 = this;
            r0 = r38
            r1 = r39
            r2 = r40
            int[] r10 = r0.k
            r11 = 0
            if (r2 != 0) goto L_0x001a
            android.graphics.Bitmap r3 = r0.n
            if (r3 == 0) goto L_0x0014
            com.bumptech.glide.gifdecoder.a$a r4 = r0.f6652d
            r4.a((android.graphics.Bitmap) r3)
        L_0x0014:
            r3 = 0
            r0.n = r3
            java.util.Arrays.fill(r10, r11)
        L_0x001a:
            r12 = 3
            if (r2 == 0) goto L_0x0028
            int r3 = r2.f6633g
            if (r3 != r12) goto L_0x0028
            android.graphics.Bitmap r3 = r0.n
            if (r3 != 0) goto L_0x0028
            java.util.Arrays.fill(r10, r11)
        L_0x0028:
            r13 = 2
            if (r2 == 0) goto L_0x0088
            int r3 = r2.f6633g
            if (r3 <= 0) goto L_0x0088
            int r3 = r2.f6633g
            if (r3 != r13) goto L_0x0074
            boolean r3 = r1.f6632f
            if (r3 != 0) goto L_0x0047
            com.bumptech.glide.gifdecoder.c r3 = r0.m
            int r3 = r3.l
            int[] r4 = r1.k
            if (r4 == 0) goto L_0x0048
            com.bumptech.glide.gifdecoder.c r4 = r0.m
            int r4 = r4.j
            int r5 = r1.f6634h
            if (r4 != r5) goto L_0x0048
        L_0x0047:
            r3 = 0
        L_0x0048:
            int r4 = r2.f6630d
            int r5 = r0.q
            int r4 = r4 / r5
            int r5 = r2.f6628b
            int r6 = r0.q
            int r5 = r5 / r6
            int r6 = r2.f6629c
            int r7 = r0.q
            int r6 = r6 / r7
            int r2 = r2.f6627a
            int r7 = r0.q
            int r2 = r2 / r7
            int r7 = r0.s
            int r5 = r5 * r7
            int r5 = r5 + r2
            int r4 = r4 * r7
            int r4 = r4 + r5
        L_0x0064:
            if (r5 >= r4) goto L_0x0088
            int r2 = r5 + r6
            r7 = r5
        L_0x0069:
            if (r7 >= r2) goto L_0x0070
            r10[r7] = r3
            int r7 = r7 + 1
            goto L_0x0069
        L_0x0070:
            int r2 = r0.s
            int r5 = r5 + r2
            goto L_0x0064
        L_0x0074:
            int r2 = r2.f6633g
            if (r2 != r12) goto L_0x0088
            android.graphics.Bitmap r2 = r0.n
            if (r2 == 0) goto L_0x0088
            r4 = 0
            int r8 = r0.s
            r6 = 0
            r7 = 0
            int r9 = r0.r
            r3 = r10
            r5 = r8
            r2.getPixels(r3, r4, r5, r6, r7, r8, r9)
        L_0x0088:
            if (r1 == 0) goto L_0x0091
            java.nio.ByteBuffer r2 = r0.f6653e
            int r3 = r1.j
            r2.position(r3)
        L_0x0091:
            if (r1 != 0) goto L_0x009c
            com.bumptech.glide.gifdecoder.c r2 = r0.m
            int r2 = r2.f6641f
            com.bumptech.glide.gifdecoder.c r3 = r0.m
            int r3 = r3.f6642g
            goto L_0x00a0
        L_0x009c:
            int r2 = r1.f6629c
            int r3 = r1.f6630d
        L_0x00a0:
            int r2 = r2 * r3
            byte[] r3 = r0.j
            if (r3 == 0) goto L_0x00a9
            int r3 = r3.length
            if (r3 >= r2) goto L_0x00b1
        L_0x00a9:
            com.bumptech.glide.gifdecoder.a$a r3 = r0.f6652d
            byte[] r3 = r3.a((int) r2)
            r0.j = r3
        L_0x00b1:
            byte[] r3 = r0.j
            short[] r4 = r0.f6655g
            r5 = 4096(0x1000, float:5.74E-42)
            if (r4 != 0) goto L_0x00bd
            short[] r4 = new short[r5]
            r0.f6655g = r4
        L_0x00bd:
            short[] r4 = r0.f6655g
            byte[] r6 = r0.f6656h
            if (r6 != 0) goto L_0x00c7
            byte[] r6 = new byte[r5]
            r0.f6656h = r6
        L_0x00c7:
            byte[] r6 = r0.f6656h
            byte[] r7 = r0.f6657i
            if (r7 != 0) goto L_0x00d3
            r7 = 4097(0x1001, float:5.741E-42)
            byte[] r7 = new byte[r7]
            r0.f6657i = r7
        L_0x00d3:
            byte[] r7 = r0.f6657i
            int r8 = r38.j()
            r9 = 1
            int r14 = r9 << r8
            int r15 = r14 + 1
            int r16 = r14 + 2
            int r8 = r8 + r9
            int r17 = r9 << r8
            int r17 = r17 + -1
            r13 = 0
        L_0x00e6:
            if (r13 >= r14) goto L_0x00f2
            r4[r13] = r11
            byte r5 = (byte) r13
            r6[r13] = r5
            int r13 = r13 + 1
            r5 = 4096(0x1000, float:5.74E-42)
            goto L_0x00e6
        L_0x00f2:
            byte[] r5 = r0.f6654f
            r27 = r8
            r25 = r16
            r28 = r17
            r13 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r26 = -1
            r29 = 0
            r30 = 0
        L_0x010b:
            r31 = 8
            if (r13 >= r2) goto L_0x020d
            if (r20 != 0) goto L_0x013c
            int r9 = r38.j()
            if (r9 > 0) goto L_0x011c
            r33 = r8
            r34 = r13
            goto L_0x0130
        L_0x011c:
            java.nio.ByteBuffer r12 = r0.f6653e
            byte[] r11 = r0.f6654f
            r33 = r8
            int r8 = r12.remaining()
            int r8 = java.lang.Math.min(r9, r8)
            r34 = r13
            r13 = 0
            r12.get(r11, r13, r8)
        L_0x0130:
            if (r9 > 0) goto L_0x0137
            r8 = 3
            r0.p = r8
            goto L_0x020d
        L_0x0137:
            r20 = r9
            r21 = 0
            goto L_0x0140
        L_0x013c:
            r33 = r8
            r34 = r13
        L_0x0140:
            byte r8 = r5[r21]
            r8 = r8 & 255(0xff, float:3.57E-43)
            int r8 = r8 << r22
            int r23 = r23 + r8
            int r22 = r22 + 8
            r8 = 1
            int r21 = r21 + 1
            r8 = -1
            int r20 = r20 + -1
            r9 = r22
            r35 = r25
            r12 = r26
            r11 = r27
            r36 = r30
            r13 = r34
        L_0x015c:
            if (r9 < r11) goto L_0x01f2
            r8 = r23 & r28
            int r23 = r23 >> r11
            int r9 = r9 - r11
            if (r8 != r14) goto L_0x016e
            r35 = r16
            r28 = r17
            r11 = r33
            r8 = -1
            r12 = -1
            goto L_0x015c
        L_0x016e:
            r22 = r5
            if (r8 == r15) goto L_0x01d7
            r5 = -1
            if (r12 != r5) goto L_0x0184
            byte r5 = r6[r8]
            r3[r24] = r5
            int r24 = r24 + 1
            int r13 = r13 + 1
            r12 = r8
            r36 = r12
            r5 = r22
        L_0x0182:
            r8 = -1
            goto L_0x015c
        L_0x0184:
            r5 = r35
            r25 = r8
            if (r8 < r5) goto L_0x0192
            r8 = r36
            byte r8 = (byte) r8
            r7[r29] = r8
            int r29 = r29 + 1
            r8 = r12
        L_0x0192:
            if (r8 < r14) goto L_0x019d
            byte r26 = r6[r8]
            r7[r29] = r26
            int r29 = r29 + 1
            short r8 = r4[r8]
            goto L_0x0192
        L_0x019d:
            byte r8 = r6[r8]
            r8 = r8 & 255(0xff, float:3.57E-43)
            r26 = r9
            byte r9 = (byte) r8
            r3[r24] = r9
        L_0x01a6:
            int r24 = r24 + 1
            int r13 = r13 + 1
            if (r29 <= 0) goto L_0x01b3
            int r29 = r29 + -1
            byte r27 = r7[r29]
            r3[r24] = r27
            goto L_0x01a6
        L_0x01b3:
            r27 = r7
            r7 = 4096(0x1000, float:5.74E-42)
            if (r5 >= r7) goto L_0x01ca
            short r12 = (short) r12
            r4[r5] = r12
            r6[r5] = r9
            int r5 = r5 + 1
            r9 = r5 & r28
            if (r9 != 0) goto L_0x01ca
            if (r5 >= r7) goto L_0x01ca
            int r11 = r11 + 1
            int r28 = r28 + r5
        L_0x01ca:
            r35 = r5
            r36 = r8
            r5 = r22
            r12 = r25
            r9 = r26
            r7 = r27
            goto L_0x0182
        L_0x01d7:
            r27 = r7
            r26 = r9
            r5 = r35
            r8 = r36
            r25 = r5
            r30 = r8
            r5 = r22
            r22 = r26
            r8 = r33
            r9 = 1
            r27 = r11
            r26 = r12
            r11 = 0
            r12 = 3
            goto L_0x010b
        L_0x01f2:
            r22 = r5
            r27 = r7
            r5 = r35
            r8 = r36
            r25 = r5
            r30 = r8
            r26 = r12
            r5 = r22
            r8 = r33
            r12 = 3
            r22 = r9
            r27 = r11
            r9 = 1
            r11 = 0
            goto L_0x010b
        L_0x020d:
            r11 = r24
            r13 = 0
            java.util.Arrays.fill(r3, r11, r2, r13)
            boolean r2 = r1.f6631e
            if (r2 != 0) goto L_0x0298
            int r2 = r0.q
            r3 = 1
            if (r2 == r3) goto L_0x021e
            goto L_0x0298
        L_0x021e:
            int[] r2 = r0.k
            int r3 = r1.f6630d
            int r4 = r1.f6628b
            int r5 = r1.f6629c
            int r6 = r1.f6627a
            int r7 = r0.l
            if (r7 != 0) goto L_0x022e
            r7 = 1
            goto L_0x022f
        L_0x022e:
            r7 = 0
        L_0x022f:
            int r8 = r0.s
            byte[] r9 = r0.j
            int[] r11 = r0.f6650b
            r12 = 0
            r14 = -1
        L_0x0237:
            if (r12 >= r3) goto L_0x0276
            int r15 = r12 + r4
            int r15 = r15 * r8
            int r16 = r15 + r6
            int r13 = r16 + r5
            int r15 = r15 + r8
            if (r15 >= r13) goto L_0x0245
            r13 = r15
        L_0x0245:
            int r15 = r1.f6629c
            int r15 = r15 * r12
            r37 = r15
            r15 = r14
            r14 = r16
            r16 = r37
        L_0x0250:
            if (r14 >= r13) goto L_0x026d
            r17 = r3
            byte r3 = r9[r16]
            r18 = r4
            r4 = r3 & 255(0xff, float:3.57E-43)
            if (r4 == r15) goto L_0x0264
            r4 = r11[r4]
            if (r4 == 0) goto L_0x0263
            r2[r14] = r4
            goto L_0x0264
        L_0x0263:
            r15 = r3
        L_0x0264:
            int r16 = r16 + 1
            int r14 = r14 + 1
            r3 = r17
            r4 = r18
            goto L_0x0250
        L_0x026d:
            r17 = r3
            r18 = r4
            int r12 = r12 + 1
            r14 = r15
            r13 = 0
            goto L_0x0237
        L_0x0276:
            java.lang.Boolean r2 = r0.t
            if (r2 == 0) goto L_0x0280
            boolean r2 = r2.booleanValue()
            if (r2 != 0) goto L_0x0289
        L_0x0280:
            java.lang.Boolean r2 = r0.t
            if (r2 != 0) goto L_0x028c
            if (r7 == 0) goto L_0x028c
            r2 = -1
            if (r14 == r2) goto L_0x028c
        L_0x0289:
            r32 = 1
            goto L_0x028e
        L_0x028c:
            r32 = 0
        L_0x028e:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r32)
            r0.t = r2
            r16 = r10
            goto L_0x043d
        L_0x0298:
            int[] r2 = r0.k
            int r3 = r1.f6630d
            int r4 = r0.q
            int r3 = r3 / r4
            int r4 = r1.f6628b
            int r5 = r0.q
            int r4 = r4 / r5
            int r5 = r1.f6629c
            int r6 = r0.q
            int r5 = r5 / r6
            int r6 = r1.f6627a
            int r7 = r0.q
            int r6 = r6 / r7
            int r7 = r0.l
            if (r7 != 0) goto L_0x02b4
            r7 = 1
            goto L_0x02b5
        L_0x02b4:
            r7 = 0
        L_0x02b5:
            int r8 = r0.q
            int r9 = r0.s
            int r11 = r0.r
            byte[] r12 = r0.j
            int[] r13 = r0.f6650b
            java.lang.Boolean r14 = r0.t
            r16 = r10
            r15 = r14
            r10 = 0
            r14 = 0
            r17 = 1
            r19 = 8
        L_0x02ca:
            if (r14 >= r3) goto L_0x0426
            r40 = r15
            boolean r15 = r1.f6631e
            if (r15 == 0) goto L_0x02f7
            if (r10 < r3) goto L_0x02ee
            int r15 = r17 + 1
            r21 = r3
            r3 = 2
            if (r15 == r3) goto L_0x02eb
            r3 = 3
            if (r15 == r3) goto L_0x02e6
            r3 = 4
            if (r15 == r3) goto L_0x02e2
            goto L_0x02f2
        L_0x02e2:
            r10 = 1
            r19 = 2
            goto L_0x02f2
        L_0x02e6:
            r3 = 4
            r10 = 2
            r19 = 4
            goto L_0x02f2
        L_0x02eb:
            r3 = 4
            r10 = 4
            goto L_0x02f2
        L_0x02ee:
            r21 = r3
            r15 = r17
        L_0x02f2:
            int r3 = r10 + r19
            r17 = r15
            goto L_0x02fb
        L_0x02f7:
            r21 = r3
            r3 = r10
            r10 = r14
        L_0x02fb:
            int r10 = r10 + r4
            r15 = 1
            if (r8 != r15) goto L_0x0301
            r15 = 1
            goto L_0x0302
        L_0x0301:
            r15 = 0
        L_0x0302:
            if (r10 >= r11) goto L_0x0406
            int r10 = r10 * r9
            int r20 = r10 + r6
            r22 = r3
            int r3 = r20 + r5
            int r10 = r10 + r9
            if (r10 >= r3) goto L_0x0310
            r3 = r10
        L_0x0310:
            int r10 = r14 * r8
            r23 = r4
            int r4 = r1.f6629c
            int r10 = r10 * r4
            if (r15 == 0) goto L_0x0344
            r15 = r40
            r4 = r20
        L_0x031e:
            if (r4 >= r3) goto L_0x033a
            r24 = r5
            byte r5 = r12[r10]
            r5 = r5 & 255(0xff, float:3.57E-43)
            r5 = r13[r5]
            if (r5 == 0) goto L_0x032d
            r2[r4] = r5
            goto L_0x0334
        L_0x032d:
            if (r7 == 0) goto L_0x0334
            if (r15 != 0) goto L_0x0334
            java.lang.Boolean r5 = java.lang.Boolean.TRUE
            r15 = r5
        L_0x0334:
            int r10 = r10 + r8
            int r4 = r4 + 1
            r5 = r24
            goto L_0x031e
        L_0x033a:
            r24 = r5
            r25 = r6
            r33 = r9
            r34 = r11
            goto L_0x0414
        L_0x0344:
            r24 = r5
            int r4 = r3 - r20
            int r4 = r4 * r8
            int r4 = r4 + r10
            r15 = r10
            r5 = r20
            r10 = r40
        L_0x0350:
            if (r5 >= r3) goto L_0x03fe
            r20 = r3
            int r3 = r1.f6629c
            r25 = r6
            r33 = r9
            r6 = r15
            r26 = 0
            r27 = 0
            r28 = 0
            r29 = 0
            r30 = 0
        L_0x0365:
            int r9 = r0.q
            int r9 = r9 + r15
            if (r6 >= r9) goto L_0x039a
            byte[] r9 = r0.j
            r34 = r11
            int r11 = r9.length
            if (r6 >= r11) goto L_0x039c
            if (r6 >= r4) goto L_0x039c
            byte r9 = r9[r6]
            r9 = r9 & 255(0xff, float:3.57E-43)
            int[] r11 = r0.f6650b
            r9 = r11[r9]
            if (r9 == 0) goto L_0x0395
            int r11 = r9 >> 24
            r11 = r11 & 255(0xff, float:3.57E-43)
            int r26 = r26 + r11
            int r11 = r9 >> 16
            r11 = r11 & 255(0xff, float:3.57E-43)
            int r27 = r27 + r11
            int r11 = r9 >> 8
            r11 = r11 & 255(0xff, float:3.57E-43)
            int r28 = r28 + r11
            r9 = r9 & 255(0xff, float:3.57E-43)
            int r29 = r29 + r9
            int r30 = r30 + 1
        L_0x0395:
            int r6 = r6 + 1
            r11 = r34
            goto L_0x0365
        L_0x039a:
            r34 = r11
        L_0x039c:
            int r3 = r3 + r15
            r6 = r3
        L_0x039e:
            int r9 = r0.q
            int r9 = r9 + r3
            if (r6 >= r9) goto L_0x03cf
            byte[] r9 = r0.j
            int r11 = r9.length
            if (r6 >= r11) goto L_0x03cf
            if (r6 >= r4) goto L_0x03cf
            byte r9 = r9[r6]
            r9 = r9 & 255(0xff, float:3.57E-43)
            int[] r11 = r0.f6650b
            r9 = r11[r9]
            if (r9 == 0) goto L_0x03cc
            int r11 = r9 >> 24
            r11 = r11 & 255(0xff, float:3.57E-43)
            int r26 = r26 + r11
            int r11 = r9 >> 16
            r11 = r11 & 255(0xff, float:3.57E-43)
            int r27 = r27 + r11
            int r11 = r9 >> 8
            r11 = r11 & 255(0xff, float:3.57E-43)
            int r28 = r28 + r11
            r9 = r9 & 255(0xff, float:3.57E-43)
            int r29 = r29 + r9
            int r30 = r30 + 1
        L_0x03cc:
            int r6 = r6 + 1
            goto L_0x039e
        L_0x03cf:
            if (r30 != 0) goto L_0x03d3
            r11 = 0
            goto L_0x03e5
        L_0x03d3:
            int r26 = r26 / r30
            int r3 = r26 << 24
            int r27 = r27 / r30
            int r6 = r27 << 16
            r3 = r3 | r6
            int r28 = r28 / r30
            int r6 = r28 << 8
            r3 = r3 | r6
            int r29 = r29 / r30
            r11 = r3 | r29
        L_0x03e5:
            if (r11 == 0) goto L_0x03ea
            r2[r5] = r11
            goto L_0x03f1
        L_0x03ea:
            if (r7 == 0) goto L_0x03f1
            if (r10 != 0) goto L_0x03f1
            java.lang.Boolean r3 = java.lang.Boolean.TRUE
            r10 = r3
        L_0x03f1:
            int r15 = r15 + r8
            int r5 = r5 + 1
            r3 = r20
            r6 = r25
            r9 = r33
            r11 = r34
            goto L_0x0350
        L_0x03fe:
            r25 = r6
            r33 = r9
            r34 = r11
            r15 = r10
            goto L_0x0414
        L_0x0406:
            r22 = r3
            r23 = r4
            r24 = r5
            r25 = r6
            r33 = r9
            r34 = r11
            r15 = r40
        L_0x0414:
            int r14 = r14 + 1
            r3 = r21
            r10 = r22
            r4 = r23
            r5 = r24
            r6 = r25
            r9 = r33
            r11 = r34
            goto L_0x02ca
        L_0x0426:
            r40 = r15
            java.lang.Boolean r2 = r0.t
            if (r2 != 0) goto L_0x043d
            if (r40 != 0) goto L_0x0431
            r32 = 0
            goto L_0x0437
        L_0x0431:
            boolean r11 = r40.booleanValue()
            r32 = r11
        L_0x0437:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r32)
            r0.t = r2
        L_0x043d:
            boolean r2 = r0.o
            if (r2 == 0) goto L_0x0463
            int r2 = r1.f6633g
            if (r2 == 0) goto L_0x044a
            int r1 = r1.f6633g
            r2 = 1
            if (r1 != r2) goto L_0x0463
        L_0x044a:
            android.graphics.Bitmap r1 = r0.n
            if (r1 != 0) goto L_0x0454
            android.graphics.Bitmap r1 = r38.k()
            r0.n = r1
        L_0x0454:
            android.graphics.Bitmap r1 = r0.n
            r3 = 0
            int r7 = r0.s
            r5 = 0
            r6 = 0
            int r8 = r0.r
            r2 = r16
            r4 = r7
            r1.setPixels(r2, r3, r4, r5, r6, r7, r8)
        L_0x0463:
            android.graphics.Bitmap r9 = r38.k()
            r3 = 0
            int r7 = r0.s
            r5 = 0
            r6 = 0
            int r8 = r0.r
            r1 = r9
            r2 = r16
            r4 = r7
            r1.setPixels(r2, r3, r4, r5, r6, r7, r8)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.gifdecoder.e.a(com.bumptech.glide.gifdecoder.b, com.bumptech.glide.gifdecoder.b):android.graphics.Bitmap");
    }

    private int j() {
        return this.f6653e.get() & 255;
    }

    private Bitmap k() {
        Boolean bool = this.t;
        Bitmap a2 = this.f6652d.a(this.s, this.r, (bool == null || bool.booleanValue()) ? Bitmap.Config.ARGB_8888 : this.u);
        a2.setHasAlpha(true);
        return a2;
    }
}
