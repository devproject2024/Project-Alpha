package com.google.android.exoplayer2.extractor.e;

import com.google.android.exoplayer2.extractor.h;
import com.google.android.exoplayer2.extractor.o;
import com.google.android.exoplayer2.extractor.p;
import com.google.android.exoplayer2.g.ae;
import java.io.IOException;
import net.one97.paytm.nativesdk.emiSubvention.utils.EmiUtil;

final class a implements f {

    /* renamed from: a  reason: collision with root package name */
    final long f31792a;

    /* renamed from: b  reason: collision with root package name */
    final long f31793b;

    /* renamed from: c  reason: collision with root package name */
    final h f31794c;

    /* renamed from: d  reason: collision with root package name */
    long f31795d;

    /* renamed from: e  reason: collision with root package name */
    private final e f31796e = new e();

    /* renamed from: f  reason: collision with root package name */
    private int f31797f;

    /* renamed from: g  reason: collision with root package name */
    private long f31798g;

    /* renamed from: h  reason: collision with root package name */
    private long f31799h;

    /* renamed from: i  reason: collision with root package name */
    private long f31800i;
    private long j;
    private long k;
    private long l;

    public a(h hVar, long j2, long j3, long j4, long j5, boolean z) {
        com.google.android.exoplayer2.g.a.a(j2 >= 0 && j3 > j2);
        this.f31794c = hVar;
        this.f31792a = j2;
        this.f31793b = j3;
        if (j4 == j3 - j2 || z) {
            this.f31795d = j5;
            this.f31797f = 4;
            return;
        }
        this.f31797f = 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x00c7 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00c8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long a(com.google.android.exoplayer2.extractor.h r24) throws java.io.IOException, java.lang.InterruptedException {
        /*
            r23 = this;
            r0 = r23
            r1 = r24
            int r2 = r0.f31797f
            r3 = 0
            r4 = 1
            r5 = 4
            if (r2 == 0) goto L_0x00d8
            if (r2 == r4) goto L_0x00ed
            r4 = 2
            r8 = 3
            r9 = -1
            if (r2 == r4) goto L_0x001e
            if (r2 == r8) goto L_0x00cb
            if (r2 != r5) goto L_0x0018
            return r9
        L_0x0018:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            r1.<init>()
            throw r1
        L_0x001e:
            long r11 = r0.f31800i
            long r13 = r0.j
            int r2 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r2 != 0) goto L_0x002a
        L_0x0026:
            r2 = r9
            r4 = r2
            goto L_0x00c3
        L_0x002a:
            long r11 = r24.c()
            long r13 = r0.j
            boolean r2 = r0.a(r1, r13)
            if (r2 != 0) goto L_0x0047
            long r2 = r0.f31800i
            int r4 = (r2 > r11 ? 1 : (r2 == r11 ? 0 : -1))
            if (r4 == 0) goto L_0x003f
            r4 = r9
            goto L_0x00c3
        L_0x003f:
            java.io.IOException r1 = new java.io.IOException
            java.lang.String r2 = "No ogg page can be found."
            r1.<init>(r2)
            throw r1
        L_0x0047:
            com.google.android.exoplayer2.extractor.e.e r2 = r0.f31796e
            r2.a(r1, r3)
            r24.a()
            long r2 = r0.f31799h
            com.google.android.exoplayer2.extractor.e.e r4 = r0.f31796e
            long r13 = r4.f31820c
            long r2 = r2 - r13
            com.google.android.exoplayer2.extractor.e.e r4 = r0.f31796e
            int r4 = r4.f31825h
            com.google.android.exoplayer2.extractor.e.e r13 = r0.f31796e
            int r13 = r13.f31826i
            int r4 = r4 + r13
            r13 = 0
            int r15 = (r13 > r2 ? 1 : (r13 == r2 ? 0 : -1))
            if (r15 > 0) goto L_0x006d
            r15 = 72000(0x11940, double:3.55727E-319)
            int r17 = (r2 > r15 ? 1 : (r2 == r15 ? 0 : -1))
            if (r17 >= 0) goto L_0x006d
            goto L_0x0026
        L_0x006d:
            int r15 = (r2 > r13 ? 1 : (r2 == r13 ? 0 : -1))
            if (r15 >= 0) goto L_0x007a
            r0.j = r11
            com.google.android.exoplayer2.extractor.e.e r11 = r0.f31796e
            long r11 = r11.f31820c
            r0.l = r11
            goto L_0x0088
        L_0x007a:
            long r11 = r24.c()
            long r13 = (long) r4
            long r11 = r11 + r13
            r0.f31800i = r11
            com.google.android.exoplayer2.extractor.e.e r11 = r0.f31796e
            long r11 = r11.f31820c
            r0.k = r11
        L_0x0088:
            long r11 = r0.j
            long r13 = r0.f31800i
            long r11 = r11 - r13
            r16 = 100000(0x186a0, double:4.94066E-319)
            int r18 = (r11 > r16 ? 1 : (r11 == r16 ? 0 : -1))
            if (r18 >= 0) goto L_0x0099
            r0.j = r13
            r4 = r9
            r2 = r13
            goto L_0x00c3
        L_0x0099:
            long r11 = (long) r4
            r13 = 1
            if (r15 > 0) goto L_0x00a1
            r15 = 2
            goto L_0x00a2
        L_0x00a1:
            r15 = r13
        L_0x00a2:
            long r11 = r11 * r15
            long r15 = r24.c()
            long r15 = r15 - r11
            long r11 = r0.j
            long r6 = r0.f31800i
            long r17 = r11 - r6
            long r2 = r2 * r17
            long r8 = r0.l
            long r4 = r0.k
            long r8 = r8 - r4
            long r2 = r2 / r8
            long r17 = r15 + r2
            long r21 = r11 - r13
            r19 = r6
            long r2 = com.google.android.exoplayer2.g.ae.a((long) r17, (long) r19, (long) r21)
            r4 = -1
        L_0x00c3:
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 == 0) goto L_0x00c8
            return r2
        L_0x00c8:
            r2 = 3
            r0.f31797f = r2
        L_0x00cb:
            r23.b(r24)
            r1 = 4
            r0.f31797f = r1
            long r1 = r0.k
            r3 = 2
            long r1 = r1 + r3
            long r1 = -r1
            return r1
        L_0x00d8:
            long r5 = r24.c()
            r0.f31798g = r5
            r0.f31797f = r4
            long r4 = r0.f31793b
            r6 = 65307(0xff1b, double:3.2266E-319)
            long r4 = r4 - r6
            long r6 = r0.f31798g
            int r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r2 <= 0) goto L_0x00ed
            return r4
        L_0x00ed:
            long r4 = r0.f31793b
            boolean r2 = r0.a(r1, r4)
            if (r2 == 0) goto L_0x012a
            com.google.android.exoplayer2.extractor.e.e r2 = r0.f31796e
            r2.a()
        L_0x00fa:
            com.google.android.exoplayer2.extractor.e.e r2 = r0.f31796e
            int r2 = r2.f31819b
            r4 = 4
            r2 = r2 & r4
            if (r2 == r4) goto L_0x011e
            long r4 = r24.c()
            long r6 = r0.f31793b
            int r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r2 >= 0) goto L_0x011e
            com.google.android.exoplayer2.extractor.e.e r2 = r0.f31796e
            r2.a(r1, r3)
            com.google.android.exoplayer2.extractor.e.e r2 = r0.f31796e
            int r2 = r2.f31825h
            com.google.android.exoplayer2.extractor.e.e r4 = r0.f31796e
            int r4 = r4.f31826i
            int r2 = r2 + r4
            r1.b(r2)
            goto L_0x00fa
        L_0x011e:
            com.google.android.exoplayer2.extractor.e.e r1 = r0.f31796e
            long r1 = r1.f31820c
            r0.f31795d = r1
            r1 = 4
            r0.f31797f = r1
            long r1 = r0.f31798g
            return r1
        L_0x012a:
            java.io.EOFException r1 = new java.io.EOFException
            r1.<init>()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.e.a.a(com.google.android.exoplayer2.extractor.h):long");
    }

    public final void a_(long j2) {
        this.f31799h = ae.a(j2, 0, this.f31795d - 1);
        this.f31797f = 2;
        this.f31800i = this.f31792a;
        this.j = this.f31793b;
        this.k = 0;
        this.l = this.f31795d;
    }

    private void b(h hVar) throws IOException, InterruptedException {
        this.f31796e.a(hVar, false);
        while (this.f31796e.f31820c <= this.f31799h) {
            hVar.b(this.f31796e.f31825h + this.f31796e.f31826i);
            this.f31800i = hVar.c();
            this.k = this.f31796e.f31820c;
            this.f31796e.a(hVar, false);
        }
        hVar.a();
    }

    private boolean a(h hVar, long j2) throws IOException, InterruptedException {
        int i2;
        long min = Math.min(j2 + 3, this.f31793b);
        int i3 = EmiUtil.EMI_PLAN_REQUEST_CODE;
        byte[] bArr = new byte[EmiUtil.EMI_PLAN_REQUEST_CODE];
        while (true) {
            int i4 = 0;
            if (hVar.c() + ((long) i3) <= min || (i3 = (int) (min - hVar.c())) >= 4) {
                hVar.b(bArr, 0, i3, false);
                while (true) {
                    i2 = i3 - 3;
                    if (i4 >= i2) {
                        break;
                    } else if (bArr[i4] == 79 && bArr[i4 + 1] == 103 && bArr[i4 + 2] == 103 && bArr[i4 + 3] == 83) {
                        hVar.b(i4);
                        return true;
                    } else {
                        i4++;
                    }
                }
            } else {
                return false;
            }
            hVar.b(i2);
        }
    }

    /* renamed from: com.google.android.exoplayer2.extractor.e.a$a  reason: collision with other inner class name */
    final class C0540a implements o {
        public final boolean h_() {
            return true;
        }

        private C0540a() {
        }

        /* synthetic */ C0540a(a aVar, byte b2) {
            this();
        }

        public final o.a a(long j) {
            return new o.a(new p(j, ae.a((a.this.f31792a + ((a.this.f31794c.b(j) * (a.this.f31793b - a.this.f31792a)) / a.this.f31795d)) - 30000, a.this.f31792a, a.this.f31793b - 1)));
        }

        public final long b() {
            return a.this.f31794c.a(a.this.f31795d);
        }
    }

    public final /* synthetic */ o a() {
        if (this.f31795d != 0) {
            return new C0540a(this, (byte) 0);
        }
        return null;
    }
}
