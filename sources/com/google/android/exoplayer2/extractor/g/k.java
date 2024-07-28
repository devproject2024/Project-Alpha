package com.google.android.exoplayer2.extractor.g;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.g.ac;
import com.google.android.exoplayer2.extractor.i;
import com.google.android.exoplayer2.extractor.q;
import com.google.android.exoplayer2.g.p;
import com.google.android.exoplayer2.g.r;
import java.util.Arrays;

public final class k implements j {

    /* renamed from: c  reason: collision with root package name */
    private static final double[] f31988c = {23.976023976023978d, 24.0d, 25.0d, 29.97002997002997d, 30.0d, 50.0d, 59.94005994005994d, 60.0d};

    /* renamed from: a  reason: collision with root package name */
    private String f31989a;

    /* renamed from: b  reason: collision with root package name */
    private q f31990b;

    /* renamed from: d  reason: collision with root package name */
    private boolean f31991d;

    /* renamed from: e  reason: collision with root package name */
    private long f31992e;

    /* renamed from: f  reason: collision with root package name */
    private final ae f31993f;

    /* renamed from: g  reason: collision with root package name */
    private final r f31994g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean[] f31995h;

    /* renamed from: i  reason: collision with root package name */
    private final a f31996i;
    private final q j;
    private long k;
    private boolean l;
    private long m;
    private long n;
    private long o;
    private boolean p;
    private boolean q;

    public final void b() {
    }

    public k() {
        this((ae) null);
    }

    public k(ae aeVar) {
        this.f31993f = aeVar;
        this.f31995h = new boolean[4];
        this.f31996i = new a();
        if (aeVar != null) {
            this.j = new q(178);
            this.f31994g = new r();
            return;
        }
        this.j = null;
        this.f31994g = null;
    }

    public final void a() {
        p.a(this.f31995h);
        a aVar = this.f31996i;
        aVar.f31998b = false;
        aVar.f31999c = 0;
        aVar.f32000d = 0;
        if (this.f31993f != null) {
            this.j.a();
        }
        this.k = 0;
        this.l = false;
    }

    public final void a(i iVar, ac.d dVar) {
        i iVar2 = iVar;
        dVar.a();
        this.f31989a = dVar.c();
        this.f31990b = iVar2.a(dVar.b(), 2);
        ae aeVar = this.f31993f;
        if (aeVar != null) {
            for (int i2 = 0; i2 < aeVar.f31928b.length; i2++) {
                dVar.a();
                q a2 = iVar2.a(dVar.b(), 3);
                Format format = aeVar.f31927a.get(i2);
                String str = format.f31069i;
                com.google.android.exoplayer2.g.a.a("application/cea-608".equals(str) || "application/cea-708".equals(str), (Object) "Invalid closed caption mime type provided: ".concat(String.valueOf(str)));
                a2.a(Format.a(dVar.c(), str, format.f31063c, format.A, format.B, (DrmInitData) null, Long.MAX_VALUE, format.k));
                aeVar.f31928b[i2] = a2;
            }
        }
    }

    public final void a(long j2, int i2) {
        this.m = j2;
    }

    static final class a {

        /* renamed from: a  reason: collision with root package name */
        static final byte[] f31997a = {0, 0, 1};

        /* renamed from: b  reason: collision with root package name */
        boolean f31998b;

        /* renamed from: c  reason: collision with root package name */
        public int f31999c;

        /* renamed from: d  reason: collision with root package name */
        public int f32000d;

        /* renamed from: e  reason: collision with root package name */
        public byte[] f32001e = new byte[128];

        public final void a(byte[] bArr, int i2, int i3) {
            if (this.f31998b) {
                int i4 = i3 - i2;
                byte[] bArr2 = this.f32001e;
                int length = bArr2.length;
                int i5 = this.f31999c;
                if (length < i5 + i4) {
                    this.f32001e = Arrays.copyOf(bArr2, (i5 + i4) * 2);
                }
                System.arraycopy(bArr, i2, this.f32001e, this.f31999c, i4);
                this.f31999c += i4;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0143  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x01a9  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x01b2  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x01ba  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.google.android.exoplayer2.g.r r25) {
        /*
            r24 = this;
            r0 = r24
            r1 = r25
            int r2 = r1.f32567b
            int r3 = r1.f32568c
            byte[] r4 = r1.f32566a
            long r5 = r0.k
            int r7 = r25.b()
            long r7 = (long) r7
            long r5 = r5 + r7
            r0.k = r5
            com.google.android.exoplayer2.extractor.q r5 = r0.f31990b
            int r6 = r25.b()
            r5.a(r1, r6)
        L_0x001d:
            boolean[] r5 = r0.f31995h
            int r5 = com.google.android.exoplayer2.g.p.a(r4, r2, r3, r5)
            if (r5 != r3) goto L_0x0038
            boolean r1 = r0.f31991d
            if (r1 != 0) goto L_0x002e
            com.google.android.exoplayer2.extractor.g.k$a r1 = r0.f31996i
            r1.a(r4, r2, r3)
        L_0x002e:
            com.google.android.exoplayer2.extractor.g.ae r1 = r0.f31993f
            if (r1 == 0) goto L_0x0037
            com.google.android.exoplayer2.extractor.g.q r1 = r0.j
            r1.a(r4, r2, r3)
        L_0x0037:
            return
        L_0x0038:
            byte[] r6 = r1.f32566a
            int r7 = r5 + 3
            byte r6 = r6[r7]
            r6 = r6 & 255(0xff, float:3.57E-43)
            int r8 = r5 - r2
            boolean r9 = r0.f31991d
            r12 = 179(0xb3, float:2.51E-43)
            r15 = 0
            r10 = 1
            if (r9 != 0) goto L_0x013c
            if (r8 <= 0) goto L_0x0051
            com.google.android.exoplayer2.extractor.g.k$a r9 = r0.f31996i
            r9.a(r4, r2, r5)
        L_0x0051:
            if (r8 >= 0) goto L_0x0055
            int r9 = -r8
            goto L_0x0056
        L_0x0055:
            r9 = 0
        L_0x0056:
            com.google.android.exoplayer2.extractor.g.k$a r11 = r0.f31996i
            boolean r13 = r11.f31998b
            if (r13 == 0) goto L_0x0072
            int r13 = r11.f31999c
            int r13 = r13 - r9
            r11.f31999c = r13
            int r9 = r11.f32000d
            if (r9 != 0) goto L_0x006e
            r9 = 181(0xb5, float:2.54E-43)
            if (r6 != r9) goto L_0x006e
            int r9 = r11.f31999c
            r11.f32000d = r9
            goto L_0x0076
        L_0x006e:
            r11.f31998b = r15
            r9 = 1
            goto L_0x007f
        L_0x0072:
            if (r6 != r12) goto L_0x0076
            r11.f31998b = r10
        L_0x0076:
            byte[] r9 = com.google.android.exoplayer2.extractor.g.k.a.f31997a
            byte[] r13 = com.google.android.exoplayer2.extractor.g.k.a.f31997a
            int r13 = r13.length
            r11.a(r9, r15, r13)
            r9 = 0
        L_0x007f:
            if (r9 == 0) goto L_0x013c
            com.google.android.exoplayer2.extractor.g.k$a r9 = r0.f31996i
            java.lang.String r11 = r0.f31989a
            byte[] r13 = r9.f32001e
            int r15 = r9.f31999c
            byte[] r13 = java.util.Arrays.copyOf(r13, r15)
            r15 = 4
            byte r12 = r13[r15]
            r12 = r12 & 255(0xff, float:3.57E-43)
            r23 = 5
            byte r10 = r13[r23]
            r10 = r10 & 255(0xff, float:3.57E-43)
            r16 = 6
            byte r14 = r13[r16]
            r14 = r14 & 255(0xff, float:3.57E-43)
            int r12 = r12 << r15
            int r16 = r10 >> 4
            r19 = r12 | r16
            r10 = r10 & 15
            int r10 = r10 << 8
            r20 = r10 | r14
            r12 = 7
            byte r14 = r13[r12]
            r14 = r14 & 240(0xf0, float:3.36E-43)
            int r14 = r14 >> r15
            r10 = 2
            if (r14 == r10) goto L_0x00c6
            r10 = 3
            if (r14 == r10) goto L_0x00c0
            if (r14 == r15) goto L_0x00ba
            r22 = 1065353216(0x3f800000, float:1.0)
            goto L_0x00cf
        L_0x00ba:
            int r10 = r20 * 121
            float r10 = (float) r10
            int r14 = r19 * 100
            goto L_0x00cb
        L_0x00c0:
            int r10 = r20 * 16
            float r10 = (float) r10
            int r14 = r19 * 9
            goto L_0x00cb
        L_0x00c6:
            int r10 = r20 * 4
            float r10 = (float) r10
            int r14 = r19 * 3
        L_0x00cb:
            float r14 = (float) r14
            float r10 = r10 / r14
            r22 = r10
        L_0x00cf:
            r18 = 0
            java.util.List r21 = java.util.Collections.singletonList(r13)
            java.lang.String r17 = "video/mpeg2"
            r16 = r11
            com.google.android.exoplayer2.Format r10 = com.google.android.exoplayer2.Format.a(r16, r17, r18, r19, r20, r21, r22)
            byte r11 = r13[r12]
            r11 = r11 & 15
            r12 = 1
            int r11 = r11 - r12
            if (r11 < 0) goto L_0x0118
            double[] r12 = f31988c
            int r14 = r12.length
            if (r11 >= r14) goto L_0x0118
            r11 = r12[r11]
            int r9 = r9.f32000d
            r14 = 9
            int r9 = r9 + r14
            byte r14 = r13[r9]
            r14 = r14 & 96
            int r14 = r14 >> 5
            byte r9 = r13[r9]
            r9 = r9 & 31
            if (r14 == r9) goto L_0x010d
            double r13 = (double) r14
            r16 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            double r13 = r13 + r16
            int r9 = r9 + 1
            r16 = r6
            r15 = r7
            double r6 = (double) r9
            double r13 = r13 / r6
            double r11 = r11 * r13
            goto L_0x0110
        L_0x010d:
            r16 = r6
            r15 = r7
        L_0x0110:
            r6 = 4696837146684686336(0x412e848000000000, double:1000000.0)
            double r6 = r6 / r11
            long r6 = (long) r6
            goto L_0x011d
        L_0x0118:
            r16 = r6
            r15 = r7
            r6 = 0
        L_0x011d:
            java.lang.Long r6 = java.lang.Long.valueOf(r6)
            android.util.Pair r6 = android.util.Pair.create(r10, r6)
            com.google.android.exoplayer2.extractor.q r7 = r0.f31990b
            java.lang.Object r9 = r6.first
            com.google.android.exoplayer2.Format r9 = (com.google.android.exoplayer2.Format) r9
            r7.a(r9)
            java.lang.Object r6 = r6.second
            java.lang.Long r6 = (java.lang.Long) r6
            long r6 = r6.longValue()
            r0.f31992e = r6
            r6 = 1
            r0.f31991d = r6
            goto L_0x013f
        L_0x013c:
            r16 = r6
            r15 = r7
        L_0x013f:
            com.google.android.exoplayer2.extractor.g.ae r6 = r0.f31993f
            if (r6 == 0) goto L_0x01a9
            if (r8 <= 0) goto L_0x014c
            com.google.android.exoplayer2.extractor.g.q r6 = r0.j
            r6.a(r4, r2, r5)
            r2 = 0
            goto L_0x014d
        L_0x014c:
            int r2 = -r8
        L_0x014d:
            com.google.android.exoplayer2.extractor.g.q r6 = r0.j
            boolean r2 = r6.b(r2)
            if (r2 == 0) goto L_0x0194
            com.google.android.exoplayer2.extractor.g.q r2 = r0.j
            byte[] r2 = r2.f32072b
            com.google.android.exoplayer2.extractor.g.q r6 = r0.j
            int r6 = r6.f32073c
            int r2 = com.google.android.exoplayer2.g.p.a((byte[]) r2, (int) r6)
            com.google.android.exoplayer2.g.r r6 = r0.f31994g
            com.google.android.exoplayer2.extractor.g.q r7 = r0.j
            byte[] r7 = r7.f32072b
            r6.a((byte[]) r7, (int) r2)
            com.google.android.exoplayer2.extractor.g.ae r2 = r0.f31993f
            long r6 = r0.o
            com.google.android.exoplayer2.g.r r8 = r0.f31994g
            int r9 = r8.b()
            r10 = 9
            if (r9 < r10) goto L_0x0194
            int r9 = r8.i()
            int r10 = r8.i()
            int r11 = r8.c()
            r12 = 434(0x1b2, float:6.08E-43)
            if (r9 != r12) goto L_0x0194
            int r9 = com.google.android.exoplayer2.e.a.f.f31444a
            if (r10 != r9) goto L_0x0194
            r9 = 3
            if (r11 != r9) goto L_0x0194
            com.google.android.exoplayer2.extractor.q[] r2 = r2.f31928b
            com.google.android.exoplayer2.e.a.f.b(r6, r8, r2)
        L_0x0194:
            r2 = 178(0xb2, float:2.5E-43)
            r6 = r16
            if (r6 != r2) goto L_0x01ab
            byte[] r2 = r1.f32566a
            int r7 = r5 + 2
            byte r2 = r2[r7]
            r7 = 1
            if (r2 != r7) goto L_0x01ab
            com.google.android.exoplayer2.extractor.g.q r2 = r0.j
            r2.a(r6)
            goto L_0x01ab
        L_0x01a9:
            r6 = r16
        L_0x01ab:
            if (r6 == 0) goto L_0x01ba
            r2 = 179(0xb3, float:2.51E-43)
            if (r6 != r2) goto L_0x01b2
            goto L_0x01ba
        L_0x01b2:
            r2 = 184(0xb8, float:2.58E-43)
            if (r6 != r2) goto L_0x0215
            r2 = 1
            r0.p = r2
            goto L_0x0215
        L_0x01ba:
            int r2 = r3 - r5
            boolean r5 = r0.l
            if (r5 == 0) goto L_0x01db
            boolean r5 = r0.q
            if (r5 == 0) goto L_0x01db
            boolean r5 = r0.f31991d
            if (r5 == 0) goto L_0x01db
            boolean r10 = r0.p
            long r7 = r0.k
            long r11 = r0.n
            long r7 = r7 - r11
            int r5 = (int) r7
            int r11 = r5 - r2
            com.google.android.exoplayer2.extractor.q r7 = r0.f31990b
            long r8 = r0.o
            r13 = 0
            r12 = r2
            r7.a(r8, r10, r11, r12, r13)
        L_0x01db:
            boolean r5 = r0.l
            if (r5 == 0) goto L_0x01e7
            boolean r5 = r0.q
            if (r5 == 0) goto L_0x01e4
            goto L_0x01e7
        L_0x01e4:
            r2 = 0
            r12 = 1
            goto L_0x0210
        L_0x01e7:
            long r7 = r0.k
            long r9 = (long) r2
            long r7 = r7 - r9
            r0.n = r7
            long r10 = r0.m
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r2 = (r10 > r7 ? 1 : (r10 == r7 ? 0 : -1))
            if (r2 == 0) goto L_0x01f9
            goto L_0x0206
        L_0x01f9:
            boolean r2 = r0.l
            if (r2 == 0) goto L_0x0204
            long r9 = r0.o
            long r11 = r0.f31992e
            long r10 = r9 + r11
            goto L_0x0206
        L_0x0204:
            r10 = 0
        L_0x0206:
            r0.o = r10
            r2 = 0
            r0.p = r2
            r0.m = r7
            r12 = 1
            r0.l = r12
        L_0x0210:
            if (r6 != 0) goto L_0x0213
            r2 = 1
        L_0x0213:
            r0.q = r2
        L_0x0215:
            r2 = r15
            goto L_0x001d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.g.k.a(com.google.android.exoplayer2.g.r):void");
    }
}
