package com.google.android.exoplayer2.extractor.g;

import com.google.android.exoplayer2.extractor.g.ac;
import com.google.android.exoplayer2.extractor.i;
import com.google.android.exoplayer2.g.ab;
import com.google.android.exoplayer2.g.q;

public final class r implements ac {

    /* renamed from: a  reason: collision with root package name */
    private final j f32076a;

    /* renamed from: b  reason: collision with root package name */
    private final q f32077b = new q(new byte[10]);

    /* renamed from: c  reason: collision with root package name */
    private int f32078c = 0;

    /* renamed from: d  reason: collision with root package name */
    private int f32079d;

    /* renamed from: e  reason: collision with root package name */
    private ab f32080e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f32081f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f32082g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f32083h;

    /* renamed from: i  reason: collision with root package name */
    private int f32084i;
    private int j;
    private boolean k;
    private long l;

    public r(j jVar) {
        this.f32076a = jVar;
    }

    public final void a(ab abVar, i iVar, ac.d dVar) {
        this.f32080e = abVar;
        this.f32076a.a(iVar, dVar);
    }

    public final void a() {
        this.f32078c = 0;
        this.f32079d = 0;
        this.f32083h = false;
        this.f32076a.a();
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x01d6 A[SYNTHETIC] */
    public final void a(com.google.android.exoplayer2.g.r r16, int r17) throws com.google.android.exoplayer2.v {
        /*
            r15 = this;
            r0 = r15
            r1 = r17 & 1
            r2 = 2
            r3 = -1
            r4 = 3
            r5 = 1
            if (r1 == 0) goto L_0x0040
            int r1 = r0.f32078c
            if (r1 == 0) goto L_0x003a
            if (r1 == r5) goto L_0x003a
            if (r1 == r2) goto L_0x0037
            if (r1 != r4) goto L_0x0031
            int r1 = r0.j
            if (r1 == r3) goto L_0x002b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r6 = "Unexpected start indicator: expected "
            r1.<init>(r6)
            int r6 = r0.j
            r1.append(r6)
            java.lang.String r6 = " more bytes"
            r1.append(r6)
            com.google.android.exoplayer2.g.l.c()
        L_0x002b:
            com.google.android.exoplayer2.extractor.g.j r1 = r0.f32076a
            r1.b()
            goto L_0x003a
        L_0x0031:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            r1.<init>()
            throw r1
        L_0x0037:
            com.google.android.exoplayer2.g.l.c()
        L_0x003a:
            r1 = r16
            r7 = r17
            r6 = r0
            goto L_0x007f
        L_0x0040:
            r1 = r16
            r7 = r17
            r6 = r0
        L_0x0045:
            int r8 = r1.b()
            if (r8 <= 0) goto L_0x01d6
            int r8 = r6.f32078c
            if (r8 == 0) goto L_0x01c9
            r9 = 0
            if (r8 == r5) goto L_0x013f
            if (r8 == r2) goto L_0x0089
            if (r8 != r4) goto L_0x0083
            int r8 = r1.b()
            int r10 = r6.j
            if (r10 != r3) goto L_0x005f
            goto L_0x0061
        L_0x005f:
            int r9 = r8 - r10
        L_0x0061:
            if (r9 <= 0) goto L_0x006a
            int r8 = r8 - r9
            int r9 = r1.f32567b
            int r9 = r9 + r8
            r1.b(r9)
        L_0x006a:
            com.google.android.exoplayer2.extractor.g.j r9 = r6.f32076a
            r9.a(r1)
            int r9 = r6.j
            if (r9 == r3) goto L_0x01c6
            int r9 = r9 - r8
            r6.j = r9
            int r8 = r6.j
            if (r8 != 0) goto L_0x01c6
            com.google.android.exoplayer2.extractor.g.j r8 = r6.f32076a
            r8.b()
        L_0x007f:
            r6.a(r5)
            goto L_0x0045
        L_0x0083:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            r1.<init>()
            throw r1
        L_0x0089:
            r8 = 10
            int r10 = r6.f32084i
            int r8 = java.lang.Math.min(r8, r10)
            com.google.android.exoplayer2.g.q r10 = r6.f32077b
            byte[] r10 = r10.f32562a
            boolean r8 = r6.a((com.google.android.exoplayer2.g.r) r1, (byte[]) r10, (int) r8)
            if (r8 == 0) goto L_0x01c6
            r8 = 0
            int r10 = r6.f32084i
            boolean r8 = r6.a((com.google.android.exoplayer2.g.r) r1, (byte[]) r8, (int) r10)
            if (r8 == 0) goto L_0x01c6
            com.google.android.exoplayer2.g.q r8 = r6.f32077b
            r8.a(r9)
            r10 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r6.l = r10
            boolean r8 = r6.f32081f
            r10 = 4
            if (r8 == 0) goto L_0x012b
            com.google.android.exoplayer2.g.q r8 = r6.f32077b
            r8.b(r10)
            com.google.android.exoplayer2.g.q r8 = r6.f32077b
            int r8 = r8.c(r4)
            long r11 = (long) r8
            r8 = 30
            long r11 = r11 << r8
            com.google.android.exoplayer2.g.q r13 = r6.f32077b
            r13.b(r5)
            com.google.android.exoplayer2.g.q r13 = r6.f32077b
            r14 = 15
            int r13 = r13.c(r14)
            int r13 = r13 << r14
            long r2 = (long) r13
            long r2 = r2 | r11
            com.google.android.exoplayer2.g.q r11 = r6.f32077b
            r11.b(r5)
            com.google.android.exoplayer2.g.q r11 = r6.f32077b
            int r11 = r11.c(r14)
            long r11 = (long) r11
            long r2 = r2 | r11
            com.google.android.exoplayer2.g.q r11 = r6.f32077b
            r11.b(r5)
            boolean r11 = r6.f32083h
            if (r11 != 0) goto L_0x0123
            boolean r11 = r6.f32082g
            if (r11 == 0) goto L_0x0123
            com.google.android.exoplayer2.g.q r11 = r6.f32077b
            r11.b(r10)
            com.google.android.exoplayer2.g.q r11 = r6.f32077b
            int r11 = r11.c(r4)
            long r11 = (long) r11
            long r11 = r11 << r8
            com.google.android.exoplayer2.g.q r8 = r6.f32077b
            r8.b(r5)
            com.google.android.exoplayer2.g.q r8 = r6.f32077b
            int r8 = r8.c(r14)
            int r8 = r8 << r14
            long r9 = (long) r8
            long r8 = r11 | r9
            com.google.android.exoplayer2.g.q r10 = r6.f32077b
            r10.b(r5)
            com.google.android.exoplayer2.g.q r10 = r6.f32077b
            int r10 = r10.c(r14)
            long r10 = (long) r10
            long r8 = r8 | r10
            com.google.android.exoplayer2.g.q r10 = r6.f32077b
            r10.b(r5)
            com.google.android.exoplayer2.g.ab r10 = r6.f32080e
            r10.b(r8)
            r6.f32083h = r5
        L_0x0123:
            com.google.android.exoplayer2.g.ab r8 = r6.f32080e
            long r2 = r8.b(r2)
            r6.l = r2
        L_0x012b:
            boolean r2 = r6.k
            if (r2 == 0) goto L_0x0131
            r2 = 4
            goto L_0x0132
        L_0x0131:
            r2 = 0
        L_0x0132:
            r7 = r7 | r2
            com.google.android.exoplayer2.extractor.g.j r2 = r6.f32076a
            long r8 = r6.l
            r2.a((long) r8, (int) r7)
            r6.a(r4)
            goto L_0x01d2
        L_0x013f:
            com.google.android.exoplayer2.g.q r2 = r6.f32077b
            byte[] r2 = r2.f32562a
            r3 = 9
            boolean r2 = r6.a((com.google.android.exoplayer2.g.r) r1, (byte[]) r2, (int) r3)
            if (r2 == 0) goto L_0x01c6
            com.google.android.exoplayer2.g.q r2 = r6.f32077b
            r8 = 0
            r2.a(r8)
            com.google.android.exoplayer2.g.q r2 = r6.f32077b
            r9 = 24
            int r2 = r2.c(r9)
            if (r2 == r5) goto L_0x016e
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r3 = "Unexpected start code prefix: "
            r3.concat(r2)
            com.google.android.exoplayer2.g.l.c()
            r2 = -1
            r6.j = r2
            r2 = 0
            r9 = -1
            r11 = 2
            goto L_0x01bf
        L_0x016e:
            com.google.android.exoplayer2.g.q r2 = r6.f32077b
            r9 = 8
            r2.b(r9)
            com.google.android.exoplayer2.g.q r2 = r6.f32077b
            r10 = 16
            int r2 = r2.c(r10)
            com.google.android.exoplayer2.g.q r10 = r6.f32077b
            r11 = 5
            r10.b(r11)
            com.google.android.exoplayer2.g.q r10 = r6.f32077b
            boolean r10 = r10.e()
            r6.k = r10
            com.google.android.exoplayer2.g.q r10 = r6.f32077b
            r11 = 2
            r10.b(r11)
            com.google.android.exoplayer2.g.q r10 = r6.f32077b
            boolean r10 = r10.e()
            r6.f32081f = r10
            com.google.android.exoplayer2.g.q r10 = r6.f32077b
            boolean r10 = r10.e()
            r6.f32082g = r10
            com.google.android.exoplayer2.g.q r10 = r6.f32077b
            r12 = 6
            r10.b(r12)
            com.google.android.exoplayer2.g.q r10 = r6.f32077b
            int r9 = r10.c(r9)
            r6.f32084i = r9
            if (r2 != 0) goto L_0x01b5
            r9 = -1
            r6.j = r9
            goto L_0x01be
        L_0x01b5:
            r9 = -1
            int r2 = r2 + 6
            int r2 = r2 - r3
            int r3 = r6.f32084i
            int r2 = r2 - r3
            r6.j = r2
        L_0x01be:
            r2 = 1
        L_0x01bf:
            if (r2 == 0) goto L_0x01c2
            r8 = 2
        L_0x01c2:
            r6.a(r8)
            goto L_0x01d2
        L_0x01c6:
            r9 = -1
            r11 = 2
            goto L_0x01d2
        L_0x01c9:
            r9 = -1
            r11 = 2
            int r2 = r1.b()
            r1.d(r2)
        L_0x01d2:
            r2 = 2
            r3 = -1
            goto L_0x0045
        L_0x01d6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.g.r.a(com.google.android.exoplayer2.g.r, int):void");
    }

    private void a(int i2) {
        this.f32078c = i2;
        this.f32079d = 0;
    }

    private boolean a(com.google.android.exoplayer2.g.r rVar, byte[] bArr, int i2) {
        int min = Math.min(rVar.b(), i2 - this.f32079d);
        if (min <= 0) {
            return true;
        }
        if (bArr == null) {
            rVar.d(min);
        } else {
            rVar.a(bArr, this.f32079d, min);
        }
        this.f32079d += min;
        if (this.f32079d == i2) {
            return true;
        }
        return false;
    }
}
