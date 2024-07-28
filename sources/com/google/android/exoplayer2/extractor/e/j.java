package com.google.android.exoplayer2.extractor.e;

import com.google.android.exoplayer2.extractor.e.k;
import com.google.android.exoplayer2.g.r;
import com.google.android.exoplayer2.v;
import com.paytmmall.clpartifact.customViews.PriceRangeSeekBar;

final class j extends h {

    /* renamed from: a  reason: collision with root package name */
    private a f31845a;

    /* renamed from: d  reason: collision with root package name */
    private int f31846d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f31847e;

    /* renamed from: f  reason: collision with root package name */
    private k.d f31848f;

    /* renamed from: g  reason: collision with root package name */
    private k.b f31849g;

    j() {
    }

    public static boolean a(r rVar) {
        try {
            return k.a(1, rVar, true);
        } catch (v unused) {
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public final void a(boolean z) {
        super.a(z);
        if (z) {
            this.f31845a = null;
            this.f31848f = null;
            this.f31849g = null;
        }
        this.f31846d = 0;
        this.f31847e = false;
    }

    /* access modifiers changed from: protected */
    public final void c(long j) {
        super.c(j);
        int i2 = 0;
        this.f31847e = j != 0;
        k.d dVar = this.f31848f;
        if (dVar != null) {
            i2 = dVar.f31873g;
        }
        this.f31846d = i2;
    }

    /* access modifiers changed from: protected */
    public final long b(r rVar) {
        int i2;
        int i3 = 0;
        if ((rVar.f32566a[0] & 1) == 1) {
            return -1;
        }
        byte b2 = rVar.f32566a[0];
        a aVar = this.f31845a;
        if (!aVar.f31853d[(b2 >> 1) & (PriceRangeSeekBar.INVALID_POINTER_ID >>> (8 - aVar.f31854e))].f31863a) {
            i2 = aVar.f31850a.f31873g;
        } else {
            i2 = aVar.f31850a.f31874h;
        }
        if (this.f31847e) {
            i3 = (this.f31846d + i2) / 4;
        }
        long j = (long) i3;
        rVar.b(rVar.f32568c + 4);
        rVar.f32566a[rVar.f32568c - 4] = (byte) ((int) (j & 255));
        rVar.f32566a[rVar.f32568c - 3] = (byte) ((int) ((j >>> 8) & 255));
        rVar.f32566a[rVar.f32568c - 2] = (byte) ((int) ((j >>> 16) & 255));
        rVar.f32566a[rVar.f32568c - 1] = (byte) ((int) ((j >>> 24) & 255));
        this.f31847e = true;
        this.f31846d = i2;
        return j;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0224 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0226  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(com.google.android.exoplayer2.g.r r21, long r22, com.google.android.exoplayer2.extractor.e.h.a r24) throws java.io.IOException, java.lang.InterruptedException {
        /*
            r20 = this;
            r0 = r20
            r1 = r21
            com.google.android.exoplayer2.extractor.e.j$a r2 = r0.f31845a
            r3 = 0
            if (r2 == 0) goto L_0x000a
            return r3
        L_0x000a:
            com.google.android.exoplayer2.extractor.e.k$d r2 = r0.f31848f
            r5 = 4
            r6 = 1
            if (r2 != 0) goto L_0x0066
            com.google.android.exoplayer2.extractor.e.k.a(r6, r1, r3)
            long r8 = r21.h()
            int r10 = r21.c()
            long r11 = r21.h()
            int r13 = r21.j()
            int r14 = r21.j()
            int r15 = r21.j()
            int r2 = r21.c()
            r7 = r2 & 15
            double r3 = (double) r7
            r6 = 4611686018427387904(0x4000000000000000, double:2.0)
            double r3 = java.lang.Math.pow(r6, r3)
            int r3 = (int) r3
            r2 = r2 & 240(0xf0, float:3.36E-43)
            int r2 = r2 >> r5
            double r4 = (double) r2
            double r4 = java.lang.Math.pow(r6, r4)
            int r2 = (int) r4
            int r4 = r21.c()
            r5 = 1
            r4 = r4 & r5
            if (r4 <= 0) goto L_0x004d
            r18 = 1
            goto L_0x004f
        L_0x004d:
            r18 = 0
        L_0x004f:
            byte[] r4 = r1.f32566a
            int r1 = r1.f32568c
            byte[] r19 = java.util.Arrays.copyOf(r4, r1)
            com.google.android.exoplayer2.extractor.e.k$d r1 = new com.google.android.exoplayer2.extractor.e.k$d
            r7 = r1
            r16 = r3
            r17 = r2
            r7.<init>(r8, r10, r11, r13, r14, r15, r16, r17, r18, r19)
            r0.f31848f = r1
        L_0x0063:
            r1 = 0
            goto L_0x021e
        L_0x0066:
            com.google.android.exoplayer2.extractor.e.k$b r2 = r0.f31849g
            if (r2 != 0) goto L_0x00bd
            r2 = 3
            r3 = 0
            com.google.android.exoplayer2.extractor.e.k.a(r2, r1, r3)
            long r2 = r21.h()
            int r3 = (int) r2
            java.lang.String r2 = r1.e(r3)
            int r3 = r2.length()
            int r3 = r3 + 11
            long r6 = r21.h()
            int r4 = (int) r6
            java.lang.String[] r4 = new java.lang.String[r4]
            int r3 = r3 + r5
            r5 = r3
            r3 = 0
        L_0x0088:
            long r8 = (long) r3
            int r10 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r10 >= 0) goto L_0x00a4
            long r8 = r21.h()
            int r9 = (int) r8
            int r5 = r5 + 4
            java.lang.String r8 = r1.e(r9)
            r4[r3] = r8
            r8 = r4[r3]
            int r8 = r8.length()
            int r5 = r5 + r8
            int r3 = r3 + 1
            goto L_0x0088
        L_0x00a4:
            int r1 = r21.c()
            r3 = 1
            r1 = r1 & r3
            if (r1 == 0) goto L_0x00b5
            int r5 = r5 + r3
            com.google.android.exoplayer2.extractor.e.k$b r1 = new com.google.android.exoplayer2.extractor.e.k$b
            r1.<init>(r2, r4, r5)
            r0.f31849g = r1
            goto L_0x0063
        L_0x00b5:
            com.google.android.exoplayer2.v r1 = new com.google.android.exoplayer2.v
            java.lang.String r2 = "framing bit expected to be set"
            r1.<init>((java.lang.String) r2)
            throw r1
        L_0x00bd:
            int r2 = r1.f32568c
            byte[] r9 = new byte[r2]
            byte[] r2 = r1.f32566a
            int r3 = r1.f32568c
            r4 = 0
            java.lang.System.arraycopy(r2, r4, r9, r4, r3)
            com.google.android.exoplayer2.extractor.e.k$d r2 = r0.f31848f
            int r2 = r2.f31868b
            r3 = 5
            com.google.android.exoplayer2.extractor.e.k.a(r3, r1, r4)
            int r6 = r21.c()
            r7 = 1
            int r6 = r6 + r7
            com.google.android.exoplayer2.extractor.e.i r7 = new com.google.android.exoplayer2.extractor.e.i
            byte[] r8 = r1.f32566a
            r7.<init>(r8)
            int r1 = r1.f32567b
            int r1 = r1 * 8
            r7.b(r1)
            r1 = 0
        L_0x00e6:
            r8 = 16
            if (r1 >= r6) goto L_0x01df
            r10 = 24
            int r11 = r7.a(r10)
            r12 = 5653314(0x564342, float:7.92198E-39)
            if (r11 != r12) goto L_0x01c4
            int r14 = r7.a(r8)
            int r15 = r7.a(r10)
            long[] r8 = new long[r15]
            boolean r18 = r7.a()
            r10 = 0
            if (r18 != 0) goto L_0x012c
            boolean r12 = r7.a()
            r13 = 0
        L_0x010c:
            int r4 = r8.length
            if (r13 >= r4) goto L_0x0160
            if (r12 == 0) goto L_0x011c
            boolean r4 = r7.a()
            if (r4 != 0) goto L_0x011c
            r8[r13] = r10
            r16 = 1
            goto L_0x0127
        L_0x011c:
            int r4 = r7.a(r3)
            r16 = 1
            int r4 = r4 + 1
            long r10 = (long) r4
            r8[r13] = r10
        L_0x0127:
            int r13 = r13 + 1
            r10 = 0
            goto L_0x010c
        L_0x012c:
            r16 = 1
            int r4 = r7.a(r3)
            int r4 = r4 + 1
            r10 = r4
            r4 = 0
        L_0x0136:
            int r11 = r8.length
            if (r4 >= r11) goto L_0x0160
            int r11 = r15 - r4
            int r11 = com.google.android.exoplayer2.extractor.e.k.a((int) r11)
            int r11 = r7.a(r11)
            r12 = r4
            r4 = 0
        L_0x0145:
            if (r4 >= r11) goto L_0x0157
            int r13 = r8.length
            if (r12 >= r13) goto L_0x0157
            r19 = r6
            long r5 = (long) r10
            r8[r12] = r5
            int r12 = r12 + 1
            int r4 = r4 + 1
            r6 = r19
            r5 = 4
            goto L_0x0145
        L_0x0157:
            r19 = r6
            int r10 = r10 + 1
            r4 = r12
            r6 = r19
            r5 = 4
            goto L_0x0136
        L_0x0160:
            r19 = r6
            r4 = 4
            int r5 = r7.a(r4)
            r6 = 2
            if (r5 > r6) goto L_0x01b4
            r10 = 1
            if (r5 == r10) goto L_0x016f
            if (r5 != r6) goto L_0x01a3
        L_0x016f:
            r6 = 32
            r7.b(r6)
            r7.b(r6)
            int r6 = r7.a(r4)
            int r6 = r6 + r10
            r7.b(r10)
            if (r5 != r10) goto L_0x0198
            if (r14 == 0) goto L_0x0195
            long r10 = (long) r15
            long r12 = (long) r14
            double r10 = (double) r10
            r16 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            double r12 = (double) r12
            double r12 = r16 / r12
            double r10 = java.lang.Math.pow(r10, r12)
            double r10 = java.lang.Math.floor(r10)
            long r10 = (long) r10
            goto L_0x019c
        L_0x0195:
            r10 = 0
            goto L_0x019c
        L_0x0198:
            long r10 = (long) r15
            long r12 = (long) r14
            long r10 = r10 * r12
        L_0x019c:
            long r12 = (long) r6
            long r10 = r10 * r12
            int r6 = (int) r10
            r7.b(r6)
        L_0x01a3:
            com.google.android.exoplayer2.extractor.e.k$a r13 = new com.google.android.exoplayer2.extractor.e.k$a
            r16 = r8
            r17 = r5
            r13.<init>(r14, r15, r16, r17, r18)
            int r1 = r1 + 1
            r6 = r19
            r4 = 0
            r5 = 4
            goto L_0x00e6
        L_0x01b4:
            com.google.android.exoplayer2.v r1 = new com.google.android.exoplayer2.v
            java.lang.String r2 = java.lang.String.valueOf(r5)
            java.lang.String r3 = "lookup type greater than 2 not decodable: "
            java.lang.String r2 = r3.concat(r2)
            r1.<init>((java.lang.String) r2)
            throw r1
        L_0x01c4:
            com.google.android.exoplayer2.v r1 = new com.google.android.exoplayer2.v
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "expected code book to start with [0x56, 0x43, 0x42] at "
            r2.<init>(r3)
            int r3 = r7.f31841a
            int r3 = r3 * 8
            int r4 = r7.f31842b
            int r3 = r3 + r4
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>((java.lang.String) r2)
            throw r1
        L_0x01df:
            r1 = 6
            int r1 = r7.a(r1)
            r3 = 1
            int r1 = r1 + r3
            r3 = 0
        L_0x01e7:
            if (r3 >= r1) goto L_0x01fa
            int r4 = r7.a(r8)
            if (r4 != 0) goto L_0x01f2
            int r3 = r3 + 1
            goto L_0x01e7
        L_0x01f2:
            com.google.android.exoplayer2.v r1 = new com.google.android.exoplayer2.v
            java.lang.String r2 = "placeholder of time domain transforms not zeroed out"
            r1.<init>((java.lang.String) r2)
            throw r1
        L_0x01fa:
            com.google.android.exoplayer2.extractor.e.k.c(r7)
            com.google.android.exoplayer2.extractor.e.k.b(r7)
            com.google.android.exoplayer2.extractor.e.k.a(r2, r7)
            com.google.android.exoplayer2.extractor.e.k$c[] r10 = com.google.android.exoplayer2.extractor.e.k.a((com.google.android.exoplayer2.extractor.e.i) r7)
            boolean r1 = r7.a()
            if (r1 == 0) goto L_0x025e
            int r1 = r10.length
            r2 = 1
            int r1 = r1 - r2
            int r11 = com.google.android.exoplayer2.extractor.e.k.a((int) r1)
            com.google.android.exoplayer2.extractor.e.j$a r1 = new com.google.android.exoplayer2.extractor.e.j$a
            com.google.android.exoplayer2.extractor.e.k$d r7 = r0.f31848f
            com.google.android.exoplayer2.extractor.e.k$b r8 = r0.f31849g
            r6 = r1
            r6.<init>(r7, r8, r9, r10, r11)
        L_0x021e:
            r0.f31845a = r1
            com.google.android.exoplayer2.extractor.e.j$a r1 = r0.f31845a
            if (r1 != 0) goto L_0x0226
            r1 = 1
            return r1
        L_0x0226:
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            com.google.android.exoplayer2.extractor.e.j$a r1 = r0.f31845a
            com.google.android.exoplayer2.extractor.e.k$d r1 = r1.f31850a
            byte[] r1 = r1.j
            r8.add(r1)
            com.google.android.exoplayer2.extractor.e.j$a r1 = r0.f31845a
            byte[] r1 = r1.f31852c
            r8.add(r1)
            r2 = 0
            com.google.android.exoplayer2.extractor.e.j$a r1 = r0.f31845a
            com.google.android.exoplayer2.extractor.e.k$d r1 = r1.f31850a
            int r4 = r1.f31871e
            r5 = -1
            com.google.android.exoplayer2.extractor.e.j$a r1 = r0.f31845a
            com.google.android.exoplayer2.extractor.e.k$d r1 = r1.f31850a
            int r6 = r1.f31868b
            com.google.android.exoplayer2.extractor.e.j$a r1 = r0.f31845a
            com.google.android.exoplayer2.extractor.e.k$d r1 = r1.f31850a
            long r9 = r1.f31869c
            int r7 = (int) r9
            r9 = 0
            r10 = 0
            java.lang.String r3 = "audio/vorbis"
            com.google.android.exoplayer2.Format r1 = com.google.android.exoplayer2.Format.a((java.lang.String) r2, (java.lang.String) r3, (int) r4, (int) r5, (int) r6, (int) r7, (java.util.List<byte[]>) r8, (com.google.android.exoplayer2.drm.DrmInitData) r9, (java.lang.String) r10)
            r2 = r24
            r2.f31839a = r1
            r1 = 1
            return r1
        L_0x025e:
            com.google.android.exoplayer2.v r1 = new com.google.android.exoplayer2.v
            java.lang.String r2 = "framing bit after modes not set as expected"
            r1.<init>((java.lang.String) r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.e.j.a(com.google.android.exoplayer2.g.r, long, com.google.android.exoplayer2.extractor.e.h$a):boolean");
    }

    static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final k.d f31850a;

        /* renamed from: b  reason: collision with root package name */
        public final k.b f31851b;

        /* renamed from: c  reason: collision with root package name */
        public final byte[] f31852c;

        /* renamed from: d  reason: collision with root package name */
        public final k.c[] f31853d;

        /* renamed from: e  reason: collision with root package name */
        public final int f31854e;

        public a(k.d dVar, k.b bVar, byte[] bArr, k.c[] cVarArr, int i2) {
            this.f31850a = dVar;
            this.f31851b = bVar;
            this.f31852c = bArr;
            this.f31853d = cVarArr;
            this.f31854e = i2;
        }
    }
}
