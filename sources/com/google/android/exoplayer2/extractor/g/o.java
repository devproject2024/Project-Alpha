package com.google.android.exoplayer2.extractor.g;

import android.util.Pair;
import com.alipay.mobile.nebula.util.tar.TarConstants;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.g.ac;
import com.google.android.exoplayer2.extractor.i;
import com.google.android.exoplayer2.g.c;
import com.google.android.exoplayer2.g.q;
import com.google.android.exoplayer2.g.r;
import com.google.android.exoplayer2.v;

public final class o implements j {

    /* renamed from: a  reason: collision with root package name */
    private final String f32053a;

    /* renamed from: b  reason: collision with root package name */
    private final r f32054b = new r((int) TarConstants.EOF_BLOCK);

    /* renamed from: c  reason: collision with root package name */
    private final q f32055c = new q(this.f32054b.f32566a);

    /* renamed from: d  reason: collision with root package name */
    private com.google.android.exoplayer2.extractor.q f32056d;

    /* renamed from: e  reason: collision with root package name */
    private Format f32057e;

    /* renamed from: f  reason: collision with root package name */
    private String f32058f;

    /* renamed from: g  reason: collision with root package name */
    private int f32059g;

    /* renamed from: h  reason: collision with root package name */
    private int f32060h;

    /* renamed from: i  reason: collision with root package name */
    private int f32061i;
    private int j;
    private long k;
    private boolean l;
    private int m;
    private int n;
    private int o;
    private boolean p;
    private long q;
    private int r;
    private long s;
    private int t;

    public final void b() {
    }

    public o(String str) {
        this.f32053a = str;
    }

    public final void a() {
        this.f32059g = 0;
        this.l = false;
    }

    public final void a(i iVar, ac.d dVar) {
        dVar.a();
        this.f32056d = iVar.a(dVar.b(), 1);
        this.f32058f = dVar.c();
    }

    public final void a(long j2, int i2) {
        this.k = j2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:64:0x014c, code lost:
        if (r0.l != false) goto L_0x014e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.google.android.exoplayer2.g.r r22) throws com.google.android.exoplayer2.v {
        /*
            r21 = this;
            r0 = r21
        L_0x0002:
            int r1 = r22.b()
            if (r1 <= 0) goto L_0x0203
            int r1 = r0.f32059g
            r2 = 86
            r3 = 1
            if (r1 == 0) goto L_0x01f7
            r4 = 2
            r5 = 0
            if (r1 == r3) goto L_0x01df
            r2 = 3
            r6 = 8
            if (r1 == r4) goto L_0x01b1
            if (r1 != r2) goto L_0x01ab
            int r1 = r22.b()
            int r4 = r0.f32061i
            int r7 = r0.f32060h
            int r4 = r4 - r7
            int r1 = java.lang.Math.min(r1, r4)
            com.google.android.exoplayer2.g.q r4 = r0.f32055c
            byte[] r4 = r4.f32562a
            int r7 = r0.f32060h
            r8 = r22
            r8.a(r4, r7, r1)
            int r4 = r0.f32060h
            int r4 = r4 + r1
            r0.f32060h = r4
            int r1 = r0.f32060h
            int r4 = r0.f32061i
            if (r1 != r4) goto L_0x0002
            com.google.android.exoplayer2.g.q r1 = r0.f32055c
            r1.a(r5)
            com.google.android.exoplayer2.g.q r1 = r0.f32055c
            boolean r4 = r1.e()
            if (r4 != 0) goto L_0x014a
            r0.l = r3
            int r4 = r1.c(r3)
            if (r4 != r3) goto L_0x0057
            int r7 = r1.c(r3)
            goto L_0x0058
        L_0x0057:
            r7 = 0
        L_0x0058:
            r0.m = r7
            int r7 = r0.m
            if (r7 != 0) goto L_0x0144
            if (r4 != r3) goto L_0x0063
            c(r1)
        L_0x0063:
            boolean r7 = r1.e()
            if (r7 == 0) goto L_0x013e
            r7 = 6
            int r9 = r1.c(r7)
            r0.n = r9
            r9 = 4
            int r10 = r1.c(r9)
            int r11 = r1.c(r2)
            if (r10 != 0) goto L_0x0138
            if (r11 != 0) goto L_0x0138
            if (r4 != 0) goto L_0x00c9
            int r10 = r1.b()
            int r11 = r0.a((com.google.android.exoplayer2.g.q) r1)
            r1.a(r10)
            int r10 = r11 + 7
            int r10 = r10 / r6
            byte[] r10 = new byte[r10]
            r1.b(r10, r11)
            java.lang.String r12 = r0.f32058f
            r14 = -1
            r15 = -1
            int r11 = r0.t
            int r13 = r0.r
            java.util.List r18 = java.util.Collections.singletonList(r10)
            r19 = 0
            java.lang.String r10 = r0.f32053a
            java.lang.String r16 = "audio/mp4a-latm"
            r17 = r13
            r13 = r16
            r16 = r11
            r20 = r10
            com.google.android.exoplayer2.Format r10 = com.google.android.exoplayer2.Format.a((java.lang.String) r12, (java.lang.String) r13, (int) r14, (int) r15, (int) r16, (int) r17, (java.util.List<byte[]>) r18, (com.google.android.exoplayer2.drm.DrmInitData) r19, (java.lang.String) r20)
            com.google.android.exoplayer2.Format r11 = r0.f32057e
            boolean r11 = r10.equals(r11)
            if (r11 != 0) goto L_0x00d6
            r0.f32057e = r10
            r11 = 1024000000(0x3d090000, double:5.059232213E-315)
            int r13 = r10.w
            long r13 = (long) r13
            long r11 = r11 / r13
            r0.s = r11
            com.google.android.exoplayer2.extractor.q r11 = r0.f32056d
            r11.a(r10)
            goto L_0x00d6
        L_0x00c9:
            long r10 = c(r1)
            int r11 = (int) r10
            int r10 = r0.a((com.google.android.exoplayer2.g.q) r1)
            int r11 = r11 - r10
            r1.b(r11)
        L_0x00d6:
            int r10 = r1.c(r2)
            r0.o = r10
            int r10 = r0.o
            if (r10 == 0) goto L_0x0103
            if (r10 == r3) goto L_0x00fd
            if (r10 == r2) goto L_0x00f9
            if (r10 == r9) goto L_0x00f9
            r2 = 5
            if (r10 == r2) goto L_0x00f9
            if (r10 == r7) goto L_0x00f5
            r2 = 7
            if (r10 != r2) goto L_0x00ef
            goto L_0x00f5
        L_0x00ef:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            r1.<init>()
            throw r1
        L_0x00f5:
            r1.b(r3)
            goto L_0x0106
        L_0x00f9:
            r1.b(r7)
            goto L_0x0106
        L_0x00fd:
            r2 = 9
            r1.b(r2)
            goto L_0x0106
        L_0x0103:
            r1.b(r6)
        L_0x0106:
            boolean r2 = r1.e()
            r0.p = r2
            r9 = 0
            r0.q = r9
            boolean r2 = r0.p
            if (r2 == 0) goto L_0x012e
            if (r4 != r3) goto L_0x011d
            long r2 = c(r1)
            r0.q = r2
            goto L_0x012e
        L_0x011d:
            boolean r2 = r1.e()
            long r3 = r0.q
            long r3 = r3 << r6
            int r7 = r1.c(r6)
            long r9 = (long) r7
            long r3 = r3 + r9
            r0.q = r3
            if (r2 != 0) goto L_0x011d
        L_0x012e:
            boolean r2 = r1.e()
            if (r2 == 0) goto L_0x014e
            r1.b(r6)
            goto L_0x014e
        L_0x0138:
            com.google.android.exoplayer2.v r1 = new com.google.android.exoplayer2.v
            r1.<init>()
            throw r1
        L_0x013e:
            com.google.android.exoplayer2.v r1 = new com.google.android.exoplayer2.v
            r1.<init>()
            throw r1
        L_0x0144:
            com.google.android.exoplayer2.v r1 = new com.google.android.exoplayer2.v
            r1.<init>()
            throw r1
        L_0x014a:
            boolean r2 = r0.l
            if (r2 == 0) goto L_0x01a7
        L_0x014e:
            int r2 = r0.m
            if (r2 != 0) goto L_0x01a1
            int r2 = r0.n
            if (r2 != 0) goto L_0x019b
            int r13 = r0.b(r1)
            int r2 = r1.b()
            r3 = r2 & 7
            if (r3 != 0) goto L_0x016a
            com.google.android.exoplayer2.g.r r3 = r0.f32054b
            int r2 = r2 >> 3
            r3.c(r2)
            goto L_0x0178
        L_0x016a:
            com.google.android.exoplayer2.g.r r2 = r0.f32054b
            byte[] r2 = r2.f32566a
            int r3 = r13 * 8
            r1.b(r2, r3)
            com.google.android.exoplayer2.g.r r2 = r0.f32054b
            r2.c(r5)
        L_0x0178:
            com.google.android.exoplayer2.extractor.q r2 = r0.f32056d
            com.google.android.exoplayer2.g.r r3 = r0.f32054b
            r2.a(r3, r13)
            com.google.android.exoplayer2.extractor.q r9 = r0.f32056d
            long r10 = r0.k
            r12 = 1
            r14 = 0
            r15 = 0
            r9.a(r10, r12, r13, r14, r15)
            long r2 = r0.k
            long r6 = r0.s
            long r2 = r2 + r6
            r0.k = r2
            boolean r2 = r0.p
            if (r2 == 0) goto L_0x01a7
            long r2 = r0.q
            int r3 = (int) r2
            r1.b(r3)
            goto L_0x01a7
        L_0x019b:
            com.google.android.exoplayer2.v r1 = new com.google.android.exoplayer2.v
            r1.<init>()
            throw r1
        L_0x01a1:
            com.google.android.exoplayer2.v r1 = new com.google.android.exoplayer2.v
            r1.<init>()
            throw r1
        L_0x01a7:
            r0.f32059g = r5
            goto L_0x0002
        L_0x01ab:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            r1.<init>()
            throw r1
        L_0x01b1:
            r8 = r22
            int r1 = r0.j
            r1 = r1 & -225(0xffffffffffffff1f, float:NaN)
            int r1 = r1 << r6
            int r3 = r22.c()
            r1 = r1 | r3
            r0.f32061i = r1
            int r1 = r0.f32061i
            com.google.android.exoplayer2.g.r r3 = r0.f32054b
            byte[] r3 = r3.f32566a
            int r3 = r3.length
            if (r1 <= r3) goto L_0x01d9
            int r1 = r0.f32061i
            com.google.android.exoplayer2.g.r r3 = r0.f32054b
            r3.a(r1)
            com.google.android.exoplayer2.g.q r1 = r0.f32055c
            com.google.android.exoplayer2.g.r r3 = r0.f32054b
            byte[] r3 = r3.f32566a
            int r4 = r3.length
            r1.a(r3, r4)
        L_0x01d9:
            r0.f32060h = r5
            r0.f32059g = r2
            goto L_0x0002
        L_0x01df:
            r8 = r22
            int r1 = r22.c()
            r3 = r1 & 224(0xe0, float:3.14E-43)
            r6 = 224(0xe0, float:3.14E-43)
            if (r3 != r6) goto L_0x01f1
            r0.j = r1
            r0.f32059g = r4
            goto L_0x0002
        L_0x01f1:
            if (r1 == r2) goto L_0x0002
            r0.f32059g = r5
            goto L_0x0002
        L_0x01f7:
            r8 = r22
            int r1 = r22.c()
            if (r1 != r2) goto L_0x0002
            r0.f32059g = r3
            goto L_0x0002
        L_0x0203:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.g.o.a(com.google.android.exoplayer2.g.r):void");
    }

    private int a(q qVar) throws v {
        int a2 = qVar.a();
        Pair<Integer, Integer> a3 = c.a(qVar, true);
        this.r = ((Integer) a3.first).intValue();
        this.t = ((Integer) a3.second).intValue();
        return a2 - qVar.a();
    }

    private int b(q qVar) throws v {
        int c2;
        if (this.o == 0) {
            int i2 = 0;
            do {
                c2 = qVar.c(8);
                i2 += c2;
            } while (c2 == 255);
            return i2;
        }
        throw new v();
    }

    private static long c(q qVar) {
        return (long) qVar.c((qVar.c(2) + 1) * 8);
    }
}
