package com.google.android.exoplayer2.extractor.b;

import com.google.android.exoplayer2.extractor.g;
import com.google.android.exoplayer2.extractor.h;
import com.google.android.exoplayer2.extractor.i;
import com.google.android.exoplayer2.extractor.j;
import com.google.android.exoplayer2.extractor.o;
import com.google.android.exoplayer2.g.ae;
import com.google.android.exoplayer2.g.r;
import java.io.IOException;

public final class b implements g {

    /* renamed from: a  reason: collision with root package name */
    public static final j f31691a = $$Lambda$b$RvdZHAXEOE2V0hhqwKg3_YUgsb0.INSTANCE;

    /* renamed from: b  reason: collision with root package name */
    private static final int f31692b = ae.h("FLV");

    /* renamed from: c  reason: collision with root package name */
    private final r f31693c = new r(4);

    /* renamed from: d  reason: collision with root package name */
    private final r f31694d = new r(9);

    /* renamed from: e  reason: collision with root package name */
    private final r f31695e = new r(11);

    /* renamed from: f  reason: collision with root package name */
    private final r f31696f = new r();

    /* renamed from: g  reason: collision with root package name */
    private final c f31697g = new c();

    /* renamed from: h  reason: collision with root package name */
    private i f31698h;

    /* renamed from: i  reason: collision with root package name */
    private int f31699i = 1;
    private boolean j;
    private long k;
    private int l;
    private int m;
    private int n;
    private long o;
    private boolean p;
    private a q;
    private e r;

    /* access modifiers changed from: private */
    public static /* synthetic */ g[] b() {
        return new g[]{new b()};
    }

    public final boolean a(h hVar) throws IOException, InterruptedException {
        hVar.c(this.f31693c.f32566a, 0, 3);
        this.f31693c.c(0);
        if (this.f31693c.f() != f31692b) {
            return false;
        }
        hVar.c(this.f31693c.f32566a, 0, 2);
        this.f31693c.c(0);
        if ((this.f31693c.d() & 250) != 0) {
            return false;
        }
        hVar.c(this.f31693c.f32566a, 0, 4);
        this.f31693c.c(0);
        int i2 = this.f31693c.i();
        hVar.a();
        hVar.c(i2);
        hVar.c(this.f31693c.f32566a, 0, 4);
        this.f31693c.c(0);
        if (this.f31693c.i() == 0) {
            return true;
        }
        return false;
    }

    public final void a(i iVar) {
        this.f31698h = iVar;
    }

    public final void a(long j2, long j3) {
        this.f31699i = 1;
        this.j = false;
        this.l = 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x00ad A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0004 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int a(com.google.android.exoplayer2.extractor.h r17, com.google.android.exoplayer2.extractor.n r18) throws java.io.IOException, java.lang.InterruptedException {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
        L_0x0004:
            int r2 = r0.f31699i
            r3 = -1
            r4 = 8
            r5 = 9
            r6 = 2
            r7 = 4
            r8 = 0
            r9 = 1
            if (r2 == r9) goto L_0x0107
            r10 = 3
            if (r2 == r6) goto L_0x00fc
            if (r2 == r10) goto L_0x00b4
            if (r2 != r7) goto L_0x00ae
            boolean r2 = r0.j
            r10 = 0
            r12 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r2 == 0) goto L_0x0029
            long r2 = r0.k
            long r14 = r0.o
            long r2 = r2 + r14
            goto L_0x0035
        L_0x0029:
            com.google.android.exoplayer2.extractor.b.c r2 = r0.f31697g
            long r2 = r2.f31700a
            int r14 = (r2 > r12 ? 1 : (r2 == r12 ? 0 : -1))
            if (r14 != 0) goto L_0x0033
            r2 = r10
            goto L_0x0035
        L_0x0033:
            long r2 = r0.o
        L_0x0035:
            int r14 = r0.m
            if (r14 != r4) goto L_0x004c
            com.google.android.exoplayer2.extractor.b.a r4 = r0.q
            if (r4 == 0) goto L_0x004c
            r16.a()
            com.google.android.exoplayer2.extractor.b.a r4 = r0.q
            com.google.android.exoplayer2.g.r r5 = r16.b(r17)
            boolean r2 = r4.b(r5, r2)
        L_0x004a:
            r3 = 1
            goto L_0x0092
        L_0x004c:
            int r4 = r0.m
            if (r4 != r5) goto L_0x0062
            com.google.android.exoplayer2.extractor.b.e r4 = r0.r
            if (r4 == 0) goto L_0x0062
            r16.a()
            com.google.android.exoplayer2.extractor.b.e r4 = r0.r
            com.google.android.exoplayer2.g.r r5 = r16.b(r17)
            boolean r2 = r4.b(r5, r2)
            goto L_0x004a
        L_0x0062:
            int r4 = r0.m
            r5 = 18
            if (r4 != r5) goto L_0x008b
            boolean r4 = r0.p
            if (r4 != 0) goto L_0x008b
            com.google.android.exoplayer2.extractor.b.c r4 = r0.f31697g
            com.google.android.exoplayer2.g.r r5 = r16.b(r17)
            boolean r2 = r4.b(r5, r2)
            com.google.android.exoplayer2.extractor.b.c r3 = r0.f31697g
            long r3 = r3.f31700a
            int r5 = (r3 > r12 ? 1 : (r3 == r12 ? 0 : -1))
            if (r5 == 0) goto L_0x004a
            com.google.android.exoplayer2.extractor.i r5 = r0.f31698h
            com.google.android.exoplayer2.extractor.o$b r14 = new com.google.android.exoplayer2.extractor.o$b
            r14.<init>(r3)
            r5.a(r14)
            r0.p = r9
            goto L_0x004a
        L_0x008b:
            int r2 = r0.n
            r1.b(r2)
            r2 = 0
            r3 = 0
        L_0x0092:
            boolean r4 = r0.j
            if (r4 != 0) goto L_0x00a7
            if (r2 == 0) goto L_0x00a7
            r0.j = r9
            com.google.android.exoplayer2.extractor.b.c r2 = r0.f31697g
            long r4 = r2.f31700a
            int r2 = (r4 > r12 ? 1 : (r4 == r12 ? 0 : -1))
            if (r2 != 0) goto L_0x00a5
            long r4 = r0.o
            long r10 = -r4
        L_0x00a5:
            r0.k = r10
        L_0x00a7:
            r0.l = r7
            r0.f31699i = r6
            if (r3 == 0) goto L_0x0004
            return r8
        L_0x00ae:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            r1.<init>()
            throw r1
        L_0x00b4:
            com.google.android.exoplayer2.g.r r2 = r0.f31695e
            byte[] r2 = r2.f32566a
            r4 = 11
            boolean r2 = r1.a(r2, r8, r4, r9)
            if (r2 != 0) goto L_0x00c1
            goto L_0x00f9
        L_0x00c1:
            com.google.android.exoplayer2.g.r r2 = r0.f31695e
            r2.c(r8)
            com.google.android.exoplayer2.g.r r2 = r0.f31695e
            int r2 = r2.c()
            r0.m = r2
            com.google.android.exoplayer2.g.r r2 = r0.f31695e
            int r2 = r2.f()
            r0.n = r2
            com.google.android.exoplayer2.g.r r2 = r0.f31695e
            int r2 = r2.f()
            long r4 = (long) r2
            r0.o = r4
            com.google.android.exoplayer2.g.r r2 = r0.f31695e
            int r2 = r2.c()
            int r2 = r2 << 24
            long r4 = (long) r2
            long r11 = r0.o
            long r4 = r4 | r11
            r11 = 1000(0x3e8, double:4.94E-321)
            long r4 = r4 * r11
            r0.o = r4
            com.google.android.exoplayer2.g.r r2 = r0.f31695e
            r2.d(r10)
            r0.f31699i = r7
            r8 = 1
        L_0x00f9:
            if (r8 != 0) goto L_0x0004
            return r3
        L_0x00fc:
            int r2 = r0.l
            r1.b(r2)
            r0.l = r8
            r0.f31699i = r10
            goto L_0x0004
        L_0x0107:
            com.google.android.exoplayer2.g.r r2 = r0.f31694d
            byte[] r2 = r2.f32566a
            boolean r2 = r1.a(r2, r8, r5, r9)
            if (r2 != 0) goto L_0x0112
            goto L_0x0166
        L_0x0112:
            com.google.android.exoplayer2.g.r r2 = r0.f31694d
            r2.c(r8)
            com.google.android.exoplayer2.g.r r2 = r0.f31694d
            r2.d(r7)
            com.google.android.exoplayer2.g.r r2 = r0.f31694d
            int r2 = r2.c()
            r10 = r2 & 4
            if (r10 == 0) goto L_0x0128
            r10 = 1
            goto L_0x0129
        L_0x0128:
            r10 = 0
        L_0x0129:
            r2 = r2 & 1
            if (r2 == 0) goto L_0x012e
            r8 = 1
        L_0x012e:
            if (r10 == 0) goto L_0x0141
            com.google.android.exoplayer2.extractor.b.a r2 = r0.q
            if (r2 != 0) goto L_0x0141
            com.google.android.exoplayer2.extractor.b.a r2 = new com.google.android.exoplayer2.extractor.b.a
            com.google.android.exoplayer2.extractor.i r10 = r0.f31698h
            com.google.android.exoplayer2.extractor.q r4 = r10.a(r4, r9)
            r2.<init>(r4)
            r0.q = r2
        L_0x0141:
            if (r8 == 0) goto L_0x0154
            com.google.android.exoplayer2.extractor.b.e r2 = r0.r
            if (r2 != 0) goto L_0x0154
            com.google.android.exoplayer2.extractor.b.e r2 = new com.google.android.exoplayer2.extractor.b.e
            com.google.android.exoplayer2.extractor.i r4 = r0.f31698h
            com.google.android.exoplayer2.extractor.q r4 = r4.a(r5, r6)
            r2.<init>(r4)
            r0.r = r2
        L_0x0154:
            com.google.android.exoplayer2.extractor.i r2 = r0.f31698h
            r2.a()
            com.google.android.exoplayer2.g.r r2 = r0.f31694d
            int r2 = r2.i()
            int r2 = r2 - r5
            int r2 = r2 + r7
            r0.l = r2
            r0.f31699i = r6
            r8 = 1
        L_0x0166:
            if (r8 != 0) goto L_0x0004
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.b.b.a(com.google.android.exoplayer2.extractor.h, com.google.android.exoplayer2.extractor.n):int");
    }

    private r b(h hVar) throws IOException, InterruptedException {
        if (this.n > this.f31696f.f32566a.length) {
            r rVar = this.f31696f;
            rVar.a(new byte[Math.max(rVar.f32566a.length * 2, this.n)], 0);
        } else {
            this.f31696f.c(0);
        }
        this.f31696f.b(this.n);
        hVar.b(this.f31696f.f32566a, 0, this.n);
        return this.f31696f;
    }

    private void a() {
        if (!this.p) {
            this.f31698h.a(new o.b(-9223372036854775807L));
            this.p = true;
        }
    }
}
