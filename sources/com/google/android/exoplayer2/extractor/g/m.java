package com.google.android.exoplayer2.extractor.g;

import com.google.android.exoplayer2.extractor.g.ac;
import com.google.android.exoplayer2.extractor.i;
import com.google.android.exoplayer2.extractor.q;
import com.google.android.exoplayer2.g.p;
import com.google.android.exoplayer2.g.r;

public final class m implements j {

    /* renamed from: a  reason: collision with root package name */
    private final x f32029a;

    /* renamed from: b  reason: collision with root package name */
    private String f32030b;

    /* renamed from: c  reason: collision with root package name */
    private q f32031c;

    /* renamed from: d  reason: collision with root package name */
    private a f32032d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f32033e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean[] f32034f = new boolean[3];

    /* renamed from: g  reason: collision with root package name */
    private final q f32035g = new q(32);

    /* renamed from: h  reason: collision with root package name */
    private final q f32036h = new q(33);

    /* renamed from: i  reason: collision with root package name */
    private final q f32037i = new q(34);
    private final q j = new q(39);
    private final q k = new q(40);
    private long l;
    private long m;
    private final r n = new r();

    public final void b() {
    }

    public m(x xVar) {
        this.f32029a = xVar;
    }

    public final void a() {
        p.a(this.f32034f);
        this.f32035g.a();
        this.f32036h.a();
        this.f32037i.a();
        this.j.a();
        this.k.a();
        a aVar = this.f32032d;
        aVar.f32042e = false;
        aVar.f32043f = false;
        aVar.f32044g = false;
        aVar.f32045h = false;
        aVar.f32046i = false;
        this.l = 0;
    }

    public final void a(i iVar, ac.d dVar) {
        dVar.a();
        this.f32030b = dVar.c();
        this.f32031c = iVar.a(dVar.b(), 2);
        this.f32032d = new a(this.f32031c);
        this.f32029a.a(iVar, dVar);
    }

    public final void a(long j2, int i2) {
        this.m = j2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:143:0x02ef  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x0313  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x031d  */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x0344  */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x0378  */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x037a  */
    /* JADX WARNING: Removed duplicated region for block: B:173:0x038a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.google.android.exoplayer2.g.r r29) {
        /*
            r28 = this;
            r0 = r28
        L_0x0002:
            r1 = r29
            int r2 = r29.b()
            if (r2 <= 0) goto L_0x03ad
            int r2 = r1.f32567b
            int r3 = r1.f32568c
            byte[] r4 = r1.f32566a
            long r5 = r0.l
            int r7 = r29.b()
            long r7 = (long) r7
            long r5 = r5 + r7
            r0.l = r5
            com.google.android.exoplayer2.extractor.q r5 = r0.f32031c
            int r6 = r29.b()
            r5.a(r1, r6)
        L_0x0023:
            if (r2 >= r3) goto L_0x0002
            boolean[] r5 = r0.f32034f
            int r5 = com.google.android.exoplayer2.g.p.a(r4, r2, r3, r5)
            if (r5 != r3) goto L_0x0031
            r0.a(r4, r2, r3)
            return
        L_0x0031:
            int r6 = com.google.android.exoplayer2.g.p.c(r4, r5)
            int r7 = r5 - r2
            if (r7 <= 0) goto L_0x003c
            r0.a(r4, r2, r5)
        L_0x003c:
            int r2 = r3 - r5
            long r8 = r0.l
            long r10 = (long) r2
            long r8 = r8 - r10
            r10 = 0
            if (r7 >= 0) goto L_0x0047
            int r7 = -r7
            goto L_0x0048
        L_0x0047:
            r7 = 0
        L_0x0048:
            long r11 = r0.m
            boolean r13 = r0.f32033e
            r15 = 1
            if (r13 == 0) goto L_0x0095
            com.google.android.exoplayer2.extractor.g.m$a r13 = r0.f32032d
            boolean r14 = r13.f32046i
            if (r14 == 0) goto L_0x0069
            boolean r14 = r13.f32043f
            if (r14 == 0) goto L_0x0069
            boolean r14 = r13.f32039b
            r13.l = r14
            r13.f32046i = r10
            r25 = r3
            r26 = r4
            r27 = r5
            r16 = r11
            goto L_0x02e6
        L_0x0069:
            boolean r14 = r13.f32044g
            if (r14 != 0) goto L_0x0076
            boolean r14 = r13.f32043f
            if (r14 == 0) goto L_0x0072
            goto L_0x0076
        L_0x0072:
            r16 = r11
            goto L_0x02e0
        L_0x0076:
            boolean r14 = r13.f32045h
            r16 = r11
            if (r14 == 0) goto L_0x0085
            long r10 = r13.f32038a
            long r10 = r8 - r10
            int r11 = (int) r10
            int r11 = r11 + r2
            r13.a(r11)
        L_0x0085:
            long r10 = r13.f32038a
            r13.j = r10
            long r10 = r13.f32041d
            r13.k = r10
            r13.f32045h = r15
            boolean r10 = r13.f32039b
            r13.l = r10
            goto L_0x02e0
        L_0x0095:
            r16 = r11
            com.google.android.exoplayer2.extractor.g.q r10 = r0.f32035g
            r10.b(r7)
            com.google.android.exoplayer2.extractor.g.q r10 = r0.f32036h
            r10.b(r7)
            com.google.android.exoplayer2.extractor.g.q r10 = r0.f32037i
            r10.b(r7)
            com.google.android.exoplayer2.extractor.g.q r10 = r0.f32035g
            boolean r10 = r10.f32071a
            if (r10 == 0) goto L_0x02e0
            com.google.android.exoplayer2.extractor.g.q r10 = r0.f32036h
            boolean r10 = r10.f32071a
            if (r10 == 0) goto L_0x02e0
            com.google.android.exoplayer2.extractor.g.q r10 = r0.f32037i
            boolean r10 = r10.f32071a
            if (r10 == 0) goto L_0x02e0
            com.google.android.exoplayer2.extractor.q r10 = r0.f32031c
            java.lang.String r11 = r0.f32030b
            com.google.android.exoplayer2.extractor.g.q r12 = r0.f32035g
            com.google.android.exoplayer2.extractor.g.q r13 = r0.f32036h
            com.google.android.exoplayer2.extractor.g.q r14 = r0.f32037i
            int r15 = r12.f32073c
            int r1 = r13.f32073c
            int r15 = r15 + r1
            int r1 = r14.f32073c
            int r15 = r15 + r1
            byte[] r1 = new byte[r15]
            byte[] r15 = r12.f32072b
            r25 = r3
            int r3 = r12.f32073c
            r26 = r4
            r4 = 0
            java.lang.System.arraycopy(r15, r4, r1, r4, r3)
            byte[] r3 = r13.f32072b
            int r15 = r12.f32073c
            r27 = r5
            int r5 = r13.f32073c
            java.lang.System.arraycopy(r3, r4, r1, r15, r5)
            byte[] r3 = r14.f32072b
            int r5 = r12.f32073c
            int r12 = r13.f32073c
            int r5 = r5 + r12
            int r12 = r14.f32073c
            java.lang.System.arraycopy(r3, r4, r1, r5, r12)
            com.google.android.exoplayer2.g.s r3 = new com.google.android.exoplayer2.g.s
            byte[] r5 = r13.f32072b
            int r12 = r13.f32073c
            r3.<init>(r5, r4, r12)
            r4 = 44
            r3.a(r4)
            r15 = 3
            int r4 = r3.c(r15)
            r3.a()
            r5 = 88
            r3.a(r5)
            r5 = 8
            r3.a(r5)
            r12 = 0
            r13 = 0
        L_0x0111:
            if (r12 >= r4) goto L_0x0126
            boolean r18 = r3.b()
            if (r18 == 0) goto L_0x011b
            int r13 = r13 + 89
        L_0x011b:
            boolean r18 = r3.b()
            if (r18 == 0) goto L_0x0123
            int r13 = r13 + 8
        L_0x0123:
            int r12 = r12 + 1
            goto L_0x0111
        L_0x0126:
            r3.a(r13)
            r12 = 2
            if (r4 <= 0) goto L_0x0133
            int r13 = 8 - r4
            int r13 = r13 * 2
            r3.a(r13)
        L_0x0133:
            r3.e()
            int r13 = r3.e()
            if (r13 != r15) goto L_0x013f
            r3.a()
        L_0x013f:
            int r18 = r3.e()
            int r19 = r3.e()
            boolean r20 = r3.b()
            if (r20 == 0) goto L_0x0179
            int r20 = r3.e()
            int r21 = r3.e()
            int r22 = r3.e()
            int r23 = r3.e()
            r14 = 1
            if (r13 == r14) goto L_0x0166
            if (r13 != r12) goto L_0x0163
            goto L_0x0166
        L_0x0163:
            r24 = 1
            goto L_0x0168
        L_0x0166:
            r24 = 2
        L_0x0168:
            if (r13 != r14) goto L_0x016c
            r13 = 2
            goto L_0x016d
        L_0x016c:
            r13 = 1
        L_0x016d:
            int r20 = r20 + r21
            int r24 = r24 * r20
            int r18 = r18 - r24
            int r22 = r22 + r23
            int r13 = r13 * r22
            int r19 = r19 - r13
        L_0x0179:
            r21 = r18
            r22 = r19
            r3.e()
            r3.e()
            int r13 = r3.e()
            boolean r14 = r3.b()
            if (r14 == 0) goto L_0x018f
            r14 = 0
            goto L_0x0190
        L_0x018f:
            r14 = r4
        L_0x0190:
            if (r14 > r4) goto L_0x019e
            r3.e()
            r3.e()
            r3.e()
            int r14 = r14 + 1
            goto L_0x0190
        L_0x019e:
            r3.e()
            r3.e()
            r3.e()
            r3.e()
            r3.e()
            r3.e()
            boolean r4 = r3.b()
            r14 = 4
            if (r4 == 0) goto L_0x01fc
            boolean r4 = r3.b()
            if (r4 == 0) goto L_0x01fc
            r4 = 0
        L_0x01be:
            if (r4 >= r14) goto L_0x01fc
            r5 = 0
        L_0x01c1:
            r12 = 6
            if (r5 >= r12) goto L_0x01f3
            boolean r12 = r3.b()
            if (r12 != 0) goto L_0x01cf
            r3.e()
        L_0x01cd:
            r12 = 3
            goto L_0x01ea
        L_0x01cf:
            r12 = 64
            int r20 = r4 << 1
            int r20 = r20 + 4
            r14 = 1
            int r15 = r14 << r20
            int r12 = java.lang.Math.min(r12, r15)
            if (r4 <= r14) goto L_0x01e1
            r3.d()
        L_0x01e1:
            r14 = 0
        L_0x01e2:
            if (r14 >= r12) goto L_0x01cd
            r3.d()
            int r14 = r14 + 1
            goto L_0x01e2
        L_0x01ea:
            if (r4 != r12) goto L_0x01ee
            r14 = 3
            goto L_0x01ef
        L_0x01ee:
            r14 = 1
        L_0x01ef:
            int r5 = r5 + r14
            r14 = 4
            r15 = 3
            goto L_0x01c1
        L_0x01f3:
            r12 = 3
            int r4 = r4 + 1
            r5 = 8
            r12 = 2
            r14 = 4
            r15 = 3
            goto L_0x01be
        L_0x01fc:
            r4 = 2
            r3.a(r4)
            boolean r4 = r3.b()
            if (r4 == 0) goto L_0x0214
            r4 = 8
            r3.a(r4)
            r3.e()
            r3.e()
            r3.a()
        L_0x0214:
            int r4 = r3.e()
            r5 = 0
            r12 = 0
            r14 = 0
        L_0x021b:
            if (r5 >= r4) goto L_0x0268
            if (r5 == 0) goto L_0x0223
            boolean r12 = r3.b()
        L_0x0223:
            if (r12 == 0) goto L_0x023d
            r3.a()
            r3.e()
            r15 = 0
        L_0x022c:
            if (r15 > r14) goto L_0x023a
            boolean r20 = r3.b()
            if (r20 == 0) goto L_0x0237
            r3.a()
        L_0x0237:
            int r15 = r15 + 1
            goto L_0x022c
        L_0x023a:
            r24 = r4
            goto L_0x0263
        L_0x023d:
            int r14 = r3.e()
            int r15 = r3.e()
            int r20 = r14 + r15
            r24 = r4
            r4 = 0
        L_0x024a:
            if (r4 >= r14) goto L_0x0255
            r3.e()
            r3.a()
            int r4 = r4 + 1
            goto L_0x024a
        L_0x0255:
            r4 = 0
        L_0x0256:
            if (r4 >= r15) goto L_0x0261
            r3.e()
            r3.a()
            int r4 = r4 + 1
            goto L_0x0256
        L_0x0261:
            r14 = r20
        L_0x0263:
            int r5 = r5 + 1
            r4 = r24
            goto L_0x021b
        L_0x0268:
            boolean r4 = r3.b()
            if (r4 == 0) goto L_0x0280
            r4 = 0
        L_0x026f:
            int r5 = r3.e()
            if (r4 >= r5) goto L_0x0280
            r5 = 4
            int r14 = r13 + 4
            r12 = 1
            int r14 = r14 + r12
            r3.a(r14)
            int r4 = r4 + 1
            goto L_0x026f
        L_0x0280:
            r4 = 2
            r3.a(r4)
            r4 = 1065353216(0x3f800000, float:1.0)
            boolean r5 = r3.b()
            if (r5 == 0) goto L_0x02c8
            boolean r5 = r3.b()
            if (r5 == 0) goto L_0x02c8
            r5 = 8
            int r5 = r3.c(r5)
            r12 = 255(0xff, float:3.57E-43)
            if (r5 != r12) goto L_0x02b0
            r12 = 16
            int r5 = r3.c(r12)
            int r3 = r3.c(r12)
            if (r5 == 0) goto L_0x02ad
            if (r3 == 0) goto L_0x02ad
            float r4 = (float) r5
            float r3 = (float) r3
            float r4 = r4 / r3
        L_0x02ad:
            r24 = r4
            goto L_0x02ca
        L_0x02b0:
            float[] r3 = com.google.android.exoplayer2.g.p.f32547b
            int r3 = r3.length
            if (r5 >= r3) goto L_0x02bc
            float[] r3 = com.google.android.exoplayer2.g.p.f32547b
            r3 = r3[r5]
            r24 = r3
            goto L_0x02ca
        L_0x02bc:
            java.lang.String r3 = java.lang.String.valueOf(r5)
            java.lang.String r5 = "Unexpected aspect_ratio_idc value: "
            r5.concat(r3)
            com.google.android.exoplayer2.g.l.c()
        L_0x02c8:
            r24 = 1065353216(0x3f800000, float:1.0)
        L_0x02ca:
            r20 = 0
            java.util.List r23 = java.util.Collections.singletonList(r1)
            java.lang.String r19 = "video/hevc"
            r18 = r11
            com.google.android.exoplayer2.Format r1 = com.google.android.exoplayer2.Format.a(r18, r19, r20, r21, r22, r23, r24)
            r10.a(r1)
            r1 = 1
            r0.f32033e = r1
            goto L_0x02e6
        L_0x02e0:
            r25 = r3
            r26 = r4
            r27 = r5
        L_0x02e6:
            com.google.android.exoplayer2.extractor.g.q r1 = r0.j
            boolean r1 = r1.b(r7)
            r3 = 5
            if (r1 == 0) goto L_0x0313
            com.google.android.exoplayer2.extractor.g.q r1 = r0.j
            byte[] r1 = r1.f32072b
            com.google.android.exoplayer2.extractor.g.q r4 = r0.j
            int r4 = r4.f32073c
            int r1 = com.google.android.exoplayer2.g.p.a((byte[]) r1, (int) r4)
            com.google.android.exoplayer2.g.r r4 = r0.n
            com.google.android.exoplayer2.extractor.g.q r5 = r0.j
            byte[] r5 = r5.f32072b
            r4.a((byte[]) r5, (int) r1)
            com.google.android.exoplayer2.g.r r1 = r0.n
            r1.d(r3)
            com.google.android.exoplayer2.extractor.g.x r1 = r0.f32029a
            com.google.android.exoplayer2.g.r r4 = r0.n
            r10 = r16
            r1.a((long) r10, (com.google.android.exoplayer2.g.r) r4)
            goto L_0x0315
        L_0x0313:
            r10 = r16
        L_0x0315:
            com.google.android.exoplayer2.extractor.g.q r1 = r0.k
            boolean r1 = r1.b(r7)
            if (r1 == 0) goto L_0x033e
            com.google.android.exoplayer2.extractor.g.q r1 = r0.k
            byte[] r1 = r1.f32072b
            com.google.android.exoplayer2.extractor.g.q r4 = r0.k
            int r4 = r4.f32073c
            int r1 = com.google.android.exoplayer2.g.p.a((byte[]) r1, (int) r4)
            com.google.android.exoplayer2.g.r r4 = r0.n
            com.google.android.exoplayer2.extractor.g.q r5 = r0.k
            byte[] r5 = r5.f32072b
            r4.a((byte[]) r5, (int) r1)
            com.google.android.exoplayer2.g.r r1 = r0.n
            r1.d(r3)
            com.google.android.exoplayer2.extractor.g.x r1 = r0.f32029a
            com.google.android.exoplayer2.g.r r3 = r0.n
            r1.a((long) r10, (com.google.android.exoplayer2.g.r) r3)
        L_0x033e:
            long r3 = r0.m
            boolean r1 = r0.f32033e
            if (r1 == 0) goto L_0x038a
            com.google.android.exoplayer2.extractor.g.m$a r1 = r0.f32032d
            r5 = 0
            r1.f32043f = r5
            r1.f32044g = r5
            r1.f32041d = r3
            r1.f32040c = r5
            r1.f32038a = r8
            r3 = 32
            if (r6 < r3) goto L_0x036f
            boolean r3 = r1.f32046i
            if (r3 != 0) goto L_0x0362
            boolean r3 = r1.f32045h
            if (r3 == 0) goto L_0x0362
            r1.a(r2)
            r1.f32045h = r5
        L_0x0362:
            r2 = 34
            if (r6 > r2) goto L_0x036f
            boolean r2 = r1.f32046i
            r4 = 1
            r2 = r2 ^ r4
            r1.f32044g = r2
            r1.f32046i = r4
            goto L_0x0370
        L_0x036f:
            r4 = 1
        L_0x0370:
            r2 = 16
            if (r6 < r2) goto L_0x037a
            r2 = 21
            if (r6 > r2) goto L_0x037a
            r2 = 1
            goto L_0x037b
        L_0x037a:
            r2 = 0
        L_0x037b:
            r1.f32039b = r2
            boolean r2 = r1.f32039b
            if (r2 != 0) goto L_0x0387
            r2 = 9
            if (r6 > r2) goto L_0x0386
            goto L_0x0387
        L_0x0386:
            r4 = 0
        L_0x0387:
            r1.f32042e = r4
            goto L_0x0399
        L_0x038a:
            com.google.android.exoplayer2.extractor.g.q r1 = r0.f32035g
            r1.a(r6)
            com.google.android.exoplayer2.extractor.g.q r1 = r0.f32036h
            r1.a(r6)
            com.google.android.exoplayer2.extractor.g.q r1 = r0.f32037i
            r1.a(r6)
        L_0x0399:
            com.google.android.exoplayer2.extractor.g.q r1 = r0.j
            r1.a(r6)
            com.google.android.exoplayer2.extractor.g.q r1 = r0.k
            r1.a(r6)
            int r2 = r27 + 3
            r1 = r29
            r3 = r25
            r4 = r26
            goto L_0x0023
        L_0x03ad:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.g.m.a(com.google.android.exoplayer2.g.r):void");
    }

    private void a(byte[] bArr, int i2, int i3) {
        if (this.f32033e) {
            this.f32032d.a(bArr, i2, i3);
        } else {
            this.f32035g.a(bArr, i2, i3);
            this.f32036h.a(bArr, i2, i3);
            this.f32037i.a(bArr, i2, i3);
        }
        this.j.a(bArr, i2, i3);
        this.k.a(bArr, i2, i3);
    }

    static final class a {

        /* renamed from: a  reason: collision with root package name */
        long f32038a;

        /* renamed from: b  reason: collision with root package name */
        boolean f32039b;

        /* renamed from: c  reason: collision with root package name */
        int f32040c;

        /* renamed from: d  reason: collision with root package name */
        long f32041d;

        /* renamed from: e  reason: collision with root package name */
        boolean f32042e;

        /* renamed from: f  reason: collision with root package name */
        boolean f32043f;

        /* renamed from: g  reason: collision with root package name */
        boolean f32044g;

        /* renamed from: h  reason: collision with root package name */
        boolean f32045h;

        /* renamed from: i  reason: collision with root package name */
        boolean f32046i;
        long j;
        long k;
        boolean l;
        private final q m;

        public a(q qVar) {
            this.m = qVar;
        }

        public final void a(byte[] bArr, int i2, int i3) {
            if (this.f32042e) {
                int i4 = this.f32040c;
                int i5 = (i2 + 2) - i4;
                if (i5 < i3) {
                    this.f32043f = (bArr[i5] & 128) != 0;
                    this.f32042e = false;
                    return;
                }
                this.f32040c = i4 + (i3 - i2);
            }
        }

        /* access modifiers changed from: package-private */
        public final void a(int i2) {
            boolean z = this.l;
            int i3 = (int) (this.f32038a - this.j);
            this.m.a(this.k, z ? 1 : 0, i3, i2, (q.a) null);
        }
    }
}
