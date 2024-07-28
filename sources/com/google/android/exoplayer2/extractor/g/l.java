package com.google.android.exoplayer2.extractor.g;

import android.util.SparseArray;
import com.google.android.exoplayer2.extractor.g.ac;
import com.google.android.exoplayer2.extractor.i;
import com.google.android.exoplayer2.extractor.q;
import com.google.android.exoplayer2.g.p;
import com.google.android.exoplayer2.g.r;
import com.google.android.exoplayer2.g.s;

public final class l implements j {

    /* renamed from: a  reason: collision with root package name */
    private final x f32002a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f32003b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f32004c;

    /* renamed from: d  reason: collision with root package name */
    private final q f32005d = new q(7);

    /* renamed from: e  reason: collision with root package name */
    private final q f32006e = new q(8);

    /* renamed from: f  reason: collision with root package name */
    private final q f32007f = new q(6);

    /* renamed from: g  reason: collision with root package name */
    private long f32008g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean[] f32009h = new boolean[3];

    /* renamed from: i  reason: collision with root package name */
    private String f32010i;
    private q j;
    private a k;
    private boolean l;
    private long m;
    private boolean n;
    private final r o = new r();

    public final void b() {
    }

    public l(x xVar, boolean z, boolean z2) {
        this.f32002a = xVar;
        this.f32003b = z;
        this.f32004c = z2;
    }

    public final void a() {
        p.a(this.f32009h);
        this.f32005d.a();
        this.f32006e.a();
        this.f32007f.a();
        this.k.a();
        this.f32008g = 0;
        this.n = false;
    }

    public final void a(i iVar, ac.d dVar) {
        dVar.a();
        this.f32010i = dVar.c();
        this.j = iVar.a(dVar.b(), 2);
        this.k = new a(this.j, this.f32003b, this.f32004c);
        this.f32002a.a(iVar, dVar);
    }

    public final void a(long j2, int i2) {
        this.m = j2;
        this.n |= (i2 & 2) != 0;
    }

    private void a(byte[] bArr, int i2, int i3) {
        if (!this.l || this.k.f32013c) {
            this.f32005d.a(bArr, i2, i3);
            this.f32006e.a(bArr, i2, i3);
        }
        this.f32007f.a(bArr, i2, i3);
        this.k.a(bArr, i2, i3);
    }

    static final class a {

        /* renamed from: a  reason: collision with root package name */
        final q f32011a;

        /* renamed from: b  reason: collision with root package name */
        final boolean f32012b;

        /* renamed from: c  reason: collision with root package name */
        final boolean f32013c;

        /* renamed from: d  reason: collision with root package name */
        int f32014d;

        /* renamed from: e  reason: collision with root package name */
        int f32015e;

        /* renamed from: f  reason: collision with root package name */
        long f32016f;

        /* renamed from: g  reason: collision with root package name */
        boolean f32017g;

        /* renamed from: h  reason: collision with root package name */
        long f32018h;

        /* renamed from: i  reason: collision with root package name */
        C0541a f32019i = new C0541a((byte) 0);
        C0541a j = new C0541a((byte) 0);
        boolean k;
        long l;
        long m;
        boolean n;
        private final SparseArray<p.b> o = new SparseArray<>();
        private final SparseArray<p.a> p = new SparseArray<>();
        private final s q = new s(this.r, 0, 0);
        private byte[] r = new byte[128];

        public a(q qVar, boolean z, boolean z2) {
            this.f32011a = qVar;
            this.f32012b = z;
            this.f32013c = z2;
            a();
        }

        public final void a(p.b bVar) {
            this.o.append(bVar.f32556d, bVar);
        }

        public final void a(p.a aVar) {
            this.p.append(aVar.f32550a, aVar);
        }

        public final void a() {
            this.f32017g = false;
            this.k = false;
            this.j.a();
        }

        /* JADX WARNING: Removed duplicated region for block: B:51:0x0101  */
        /* JADX WARNING: Removed duplicated region for block: B:52:0x0104  */
        /* JADX WARNING: Removed duplicated region for block: B:54:0x0108  */
        /* JADX WARNING: Removed duplicated region for block: B:58:0x011a  */
        /* JADX WARNING: Removed duplicated region for block: B:61:0x0120  */
        /* JADX WARNING: Removed duplicated region for block: B:72:0x0150  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a(byte[] r24, int r25, int r26) {
            /*
                r23 = this;
                r0 = r23
                r1 = r25
                boolean r2 = r0.f32017g
                if (r2 != 0) goto L_0x0009
                return
            L_0x0009:
                int r2 = r26 - r1
                byte[] r3 = r0.r
                int r4 = r3.length
                int r5 = r0.f32014d
                int r6 = r5 + r2
                r7 = 2
                if (r4 >= r6) goto L_0x001e
                int r5 = r5 + r2
                int r5 = r5 * 2
                byte[] r3 = java.util.Arrays.copyOf(r3, r5)
                r0.r = r3
            L_0x001e:
                byte[] r3 = r0.r
                int r4 = r0.f32014d
                r5 = r24
                java.lang.System.arraycopy(r5, r1, r3, r4, r2)
                int r1 = r0.f32014d
                int r1 = r1 + r2
                r0.f32014d = r1
                com.google.android.exoplayer2.g.s r1 = r0.q
                byte[] r2 = r0.r
                int r3 = r0.f32014d
                r4 = 0
                r1.a(r2, r4, r3)
                com.google.android.exoplayer2.g.s r1 = r0.q
                r2 = 8
                boolean r1 = r1.b(r2)
                if (r1 != 0) goto L_0x0041
                return
            L_0x0041:
                com.google.android.exoplayer2.g.s r1 = r0.q
                r1.a()
                com.google.android.exoplayer2.g.s r1 = r0.q
                int r10 = r1.c(r7)
                com.google.android.exoplayer2.g.s r1 = r0.q
                r2 = 5
                r1.a(r2)
                com.google.android.exoplayer2.g.s r1 = r0.q
                boolean r1 = r1.c()
                if (r1 != 0) goto L_0x005b
                return
            L_0x005b:
                com.google.android.exoplayer2.g.s r1 = r0.q
                r1.e()
                com.google.android.exoplayer2.g.s r1 = r0.q
                boolean r1 = r1.c()
                if (r1 != 0) goto L_0x0069
                return
            L_0x0069:
                com.google.android.exoplayer2.g.s r1 = r0.q
                int r11 = r1.e()
                boolean r1 = r0.f32013c
                if (r1 != 0) goto L_0x007b
                r0.f32017g = r4
                com.google.android.exoplayer2.extractor.g.l$a$a r1 = r0.j
                r1.a(r11)
                return
            L_0x007b:
                com.google.android.exoplayer2.g.s r1 = r0.q
                boolean r1 = r1.c()
                if (r1 != 0) goto L_0x0084
                return
            L_0x0084:
                com.google.android.exoplayer2.g.s r1 = r0.q
                int r13 = r1.e()
                android.util.SparseArray<com.google.android.exoplayer2.g.p$a> r1 = r0.p
                int r1 = r1.indexOfKey(r13)
                if (r1 >= 0) goto L_0x0095
                r0.f32017g = r4
                return
            L_0x0095:
                android.util.SparseArray<com.google.android.exoplayer2.g.p$a> r1 = r0.p
                java.lang.Object r1 = r1.get(r13)
                com.google.android.exoplayer2.g.p$a r1 = (com.google.android.exoplayer2.g.p.a) r1
                android.util.SparseArray<com.google.android.exoplayer2.g.p$b> r3 = r0.o
                int r5 = r1.f32551b
                java.lang.Object r3 = r3.get(r5)
                r9 = r3
                com.google.android.exoplayer2.g.p$b r9 = (com.google.android.exoplayer2.g.p.b) r9
                boolean r3 = r9.f32560h
                if (r3 == 0) goto L_0x00ba
                com.google.android.exoplayer2.g.s r3 = r0.q
                boolean r3 = r3.b(r7)
                if (r3 != 0) goto L_0x00b5
                return
            L_0x00b5:
                com.google.android.exoplayer2.g.s r3 = r0.q
                r3.a(r7)
            L_0x00ba:
                com.google.android.exoplayer2.g.s r3 = r0.q
                int r5 = r9.j
                boolean r3 = r3.b(r5)
                if (r3 != 0) goto L_0x00c5
                return
            L_0x00c5:
                com.google.android.exoplayer2.g.s r3 = r0.q
                int r5 = r9.j
                int r12 = r3.c(r5)
                boolean r3 = r9.f32561i
                r5 = 1
                if (r3 != 0) goto L_0x00f9
                com.google.android.exoplayer2.g.s r3 = r0.q
                boolean r3 = r3.b(r5)
                if (r3 != 0) goto L_0x00db
                return
            L_0x00db:
                com.google.android.exoplayer2.g.s r3 = r0.q
                boolean r3 = r3.b()
                if (r3 == 0) goto L_0x00f7
                com.google.android.exoplayer2.g.s r6 = r0.q
                boolean r6 = r6.b(r5)
                if (r6 != 0) goto L_0x00ec
                return
            L_0x00ec:
                com.google.android.exoplayer2.g.s r6 = r0.q
                boolean r6 = r6.b()
                r14 = r3
                r16 = r6
                r15 = 1
                goto L_0x00fd
            L_0x00f7:
                r14 = r3
                goto L_0x00fa
            L_0x00f9:
                r14 = 0
            L_0x00fa:
                r15 = 0
                r16 = 0
            L_0x00fd:
                int r3 = r0.f32015e
                if (r3 != r2) goto L_0x0104
                r17 = 1
                goto L_0x0106
            L_0x0104:
                r17 = 0
            L_0x0106:
                if (r17 == 0) goto L_0x011a
                com.google.android.exoplayer2.g.s r2 = r0.q
                boolean r2 = r2.c()
                if (r2 != 0) goto L_0x0111
                return
            L_0x0111:
                com.google.android.exoplayer2.g.s r2 = r0.q
                int r2 = r2.e()
                r18 = r2
                goto L_0x011c
            L_0x011a:
                r18 = 0
            L_0x011c:
                int r2 = r9.k
                if (r2 != 0) goto L_0x0150
                com.google.android.exoplayer2.g.s r2 = r0.q
                int r3 = r9.l
                boolean r2 = r2.b(r3)
                if (r2 != 0) goto L_0x012b
                return
            L_0x012b:
                com.google.android.exoplayer2.g.s r2 = r0.q
                int r3 = r9.l
                int r2 = r2.c(r3)
                boolean r1 = r1.f32552c
                if (r1 == 0) goto L_0x014d
                if (r14 != 0) goto L_0x014d
                com.google.android.exoplayer2.g.s r1 = r0.q
                boolean r1 = r1.c()
                if (r1 != 0) goto L_0x0142
                return
            L_0x0142:
                com.google.android.exoplayer2.g.s r1 = r0.q
                int r1 = r1.d()
                r20 = r1
                r19 = r2
                goto L_0x0190
            L_0x014d:
                r19 = r2
                goto L_0x018e
            L_0x0150:
                int r2 = r9.k
                if (r2 != r5) goto L_0x018c
                boolean r2 = r9.m
                if (r2 != 0) goto L_0x018c
                com.google.android.exoplayer2.g.s r2 = r0.q
                boolean r2 = r2.c()
                if (r2 != 0) goto L_0x0161
                return
            L_0x0161:
                com.google.android.exoplayer2.g.s r2 = r0.q
                int r2 = r2.d()
                boolean r1 = r1.f32552c
                if (r1 == 0) goto L_0x0185
                if (r14 != 0) goto L_0x0185
                com.google.android.exoplayer2.g.s r1 = r0.q
                boolean r1 = r1.c()
                if (r1 != 0) goto L_0x0176
                return
            L_0x0176:
                com.google.android.exoplayer2.g.s r1 = r0.q
                int r1 = r1.d()
                r22 = r1
                r21 = r2
                r19 = 0
                r20 = 0
                goto L_0x0194
            L_0x0185:
                r21 = r2
                r19 = 0
                r20 = 0
                goto L_0x0192
            L_0x018c:
                r19 = 0
            L_0x018e:
                r20 = 0
            L_0x0190:
                r21 = 0
            L_0x0192:
                r22 = 0
            L_0x0194:
                com.google.android.exoplayer2.extractor.g.l$a$a r8 = r0.j
                r8.a(r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
                r0.f32017g = r4
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.g.l.a.a(byte[], int, int):void");
        }

        /* renamed from: com.google.android.exoplayer2.extractor.g.l$a$a  reason: collision with other inner class name */
        static final class C0541a {

            /* renamed from: a  reason: collision with root package name */
            boolean f32020a;

            /* renamed from: b  reason: collision with root package name */
            boolean f32021b;

            /* renamed from: c  reason: collision with root package name */
            p.b f32022c;

            /* renamed from: d  reason: collision with root package name */
            int f32023d;

            /* renamed from: e  reason: collision with root package name */
            int f32024e;

            /* renamed from: f  reason: collision with root package name */
            int f32025f;

            /* renamed from: g  reason: collision with root package name */
            int f32026g;

            /* renamed from: h  reason: collision with root package name */
            boolean f32027h;

            /* renamed from: i  reason: collision with root package name */
            boolean f32028i;
            boolean j;
            boolean k;
            int l;
            int m;
            int n;
            int o;
            int p;

            private C0541a() {
            }

            /* synthetic */ C0541a(byte b2) {
                this();
            }

            public final void a() {
                this.f32021b = false;
                this.f32020a = false;
            }

            public final void a(int i2) {
                this.f32024e = i2;
                this.f32021b = true;
            }

            public final void a(p.b bVar, int i2, int i3, int i4, int i5, boolean z, boolean z2, boolean z3, boolean z4, int i6, int i7, int i8, int i9, int i10) {
                this.f32022c = bVar;
                this.f32023d = i2;
                this.f32024e = i3;
                this.f32025f = i4;
                this.f32026g = i5;
                this.f32027h = z;
                this.f32028i = z2;
                this.j = z3;
                this.k = z4;
                this.l = i6;
                this.m = i7;
                this.n = i8;
                this.o = i9;
                this.p = i10;
                this.f32020a = true;
                this.f32021b = true;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:119:0x027b, code lost:
        if (r4.f32015e != 1) goto L_0x027f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x01f0, code lost:
        if ((r4.f32020a && !(r6.f32020a && r4.f32025f == r6.f32025f && r4.f32026g == r6.f32026g && r4.f32027h == r6.f32027h && ((!r4.f32028i || !r6.f32028i || r4.j == r6.j) && ((r4.f32023d == r6.f32023d || (r4.f32023d != 0 && r6.f32023d != 0)) && ((r4.f32022c.k != 0 || r6.f32022c.k != 0 || (r4.m == r6.m && r4.n == r6.n)) && ((r4.f32022c.k != 1 || r6.f32022c.k != 1 || (r4.o == r6.o && r4.p == r6.p)) && r4.k == r6.k && (!r4.k || !r6.k || r4.l == r6.l))))))) != false) goto L_0x01f2;
     */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x023c A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x024e  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x0278  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x027e  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x0283  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x02a2 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x013c  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x016a  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0223  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.google.android.exoplayer2.g.r r26) {
        /*
            r25 = this;
            r0 = r25
            r1 = r26
            int r2 = r1.f32567b
            int r3 = r1.f32568c
            byte[] r4 = r1.f32566a
            long r5 = r0.f32008g
            int r7 = r26.b()
            long r7 = (long) r7
            long r5 = r5 + r7
            r0.f32008g = r5
            com.google.android.exoplayer2.extractor.q r5 = r0.j
            int r6 = r26.b()
            r5.a(r1, r6)
        L_0x001d:
            boolean[] r1 = r0.f32009h
            int r1 = com.google.android.exoplayer2.g.p.a(r4, r2, r3, r1)
            if (r1 != r3) goto L_0x0029
            r0.a(r4, r2, r3)
            return
        L_0x0029:
            int r5 = com.google.android.exoplayer2.g.p.b(r4, r1)
            int r6 = r1 - r2
            if (r6 <= 0) goto L_0x0034
            r0.a(r4, r2, r1)
        L_0x0034:
            int r2 = r3 - r1
            long r7 = r0.f32008g
            long r9 = (long) r2
            long r7 = r7 - r9
            if (r6 >= 0) goto L_0x003e
            int r6 = -r6
            goto L_0x003f
        L_0x003e:
            r6 = 0
        L_0x003f:
            long r10 = r0.m
            boolean r12 = r0.l
            if (r12 == 0) goto L_0x0054
            com.google.android.exoplayer2.extractor.g.l$a r12 = r0.k
            boolean r12 = r12.f32013c
            if (r12 == 0) goto L_0x004c
            goto L_0x0054
        L_0x004c:
            r24 = r1
            r22 = r3
            r23 = r4
            goto L_0x0134
        L_0x0054:
            com.google.android.exoplayer2.extractor.g.q r12 = r0.f32005d
            r12.b(r6)
            com.google.android.exoplayer2.extractor.g.q r12 = r0.f32006e
            r12.b(r6)
            boolean r12 = r0.l
            r14 = 3
            if (r12 != 0) goto L_0x00f5
            com.google.android.exoplayer2.extractor.g.q r12 = r0.f32005d
            boolean r12 = r12.f32071a
            if (r12 == 0) goto L_0x004c
            com.google.android.exoplayer2.extractor.g.q r12 = r0.f32006e
            boolean r12 = r12.f32071a
            if (r12 == 0) goto L_0x004c
            java.util.ArrayList r12 = new java.util.ArrayList
            r12.<init>()
            com.google.android.exoplayer2.extractor.g.q r15 = r0.f32005d
            byte[] r15 = r15.f32072b
            com.google.android.exoplayer2.extractor.g.q r9 = r0.f32005d
            int r9 = r9.f32073c
            byte[] r9 = java.util.Arrays.copyOf(r15, r9)
            r12.add(r9)
            com.google.android.exoplayer2.extractor.g.q r9 = r0.f32006e
            byte[] r9 = r9.f32072b
            com.google.android.exoplayer2.extractor.g.q r15 = r0.f32006e
            int r15 = r15.f32073c
            byte[] r9 = java.util.Arrays.copyOf(r9, r15)
            r12.add(r9)
            com.google.android.exoplayer2.extractor.g.q r9 = r0.f32005d
            byte[] r9 = r9.f32072b
            com.google.android.exoplayer2.extractor.g.q r15 = r0.f32005d
            int r15 = r15.f32073c
            com.google.android.exoplayer2.g.p$b r9 = com.google.android.exoplayer2.g.p.a(r9, r14, r15)
            com.google.android.exoplayer2.extractor.g.q r14 = r0.f32006e
            byte[] r14 = r14.f32072b
            com.google.android.exoplayer2.extractor.g.q r15 = r0.f32006e
            int r15 = r15.f32073c
            com.google.android.exoplayer2.g.p$a r14 = com.google.android.exoplayer2.g.p.d(r14, r15)
            com.google.android.exoplayer2.extractor.q r15 = r0.j
            java.lang.String r13 = r0.f32010i
            r22 = r3
            int r3 = r9.f32553a
            r23 = r4
            int r4 = r9.f32554b
            r16 = r15
            int r15 = r9.f32555c
            java.lang.String r17 = com.google.android.exoplayer2.g.c.b(r3, r4, r15)
            int r3 = r9.f32557e
            int r4 = r9.f32558f
            float r15 = r9.f32559g
            java.lang.String r18 = "video/avc"
            r24 = r1
            r21 = r15
            r1 = r16
            r15 = r13
            r16 = r18
            r18 = r3
            r19 = r4
            r20 = r12
            com.google.android.exoplayer2.Format r3 = com.google.android.exoplayer2.Format.a(r15, r16, r17, r18, r19, r20, r21)
            r1.a(r3)
            r1 = 1
            r0.l = r1
            com.google.android.exoplayer2.extractor.g.l$a r1 = r0.k
            r1.a((com.google.android.exoplayer2.g.p.b) r9)
            com.google.android.exoplayer2.extractor.g.l$a r1 = r0.k
            r1.a((com.google.android.exoplayer2.g.p.a) r14)
            com.google.android.exoplayer2.extractor.g.q r1 = r0.f32005d
            r1.a()
            com.google.android.exoplayer2.extractor.g.q r1 = r0.f32006e
            r1.a()
            goto L_0x0134
        L_0x00f5:
            r24 = r1
            r22 = r3
            r23 = r4
            com.google.android.exoplayer2.extractor.g.q r1 = r0.f32005d
            boolean r1 = r1.f32071a
            if (r1 == 0) goto L_0x0118
            com.google.android.exoplayer2.extractor.g.q r1 = r0.f32005d
            byte[] r1 = r1.f32072b
            com.google.android.exoplayer2.extractor.g.q r3 = r0.f32005d
            int r3 = r3.f32073c
            com.google.android.exoplayer2.g.p$b r1 = com.google.android.exoplayer2.g.p.a(r1, r14, r3)
            com.google.android.exoplayer2.extractor.g.l$a r3 = r0.k
            r3.a((com.google.android.exoplayer2.g.p.b) r1)
            com.google.android.exoplayer2.extractor.g.q r1 = r0.f32005d
            r1.a()
            goto L_0x0134
        L_0x0118:
            com.google.android.exoplayer2.extractor.g.q r1 = r0.f32006e
            boolean r1 = r1.f32071a
            if (r1 == 0) goto L_0x0134
            com.google.android.exoplayer2.extractor.g.q r1 = r0.f32006e
            byte[] r1 = r1.f32072b
            com.google.android.exoplayer2.extractor.g.q r3 = r0.f32006e
            int r3 = r3.f32073c
            com.google.android.exoplayer2.g.p$a r1 = com.google.android.exoplayer2.g.p.d(r1, r3)
            com.google.android.exoplayer2.extractor.g.l$a r3 = r0.k
            r3.a((com.google.android.exoplayer2.g.p.a) r1)
            com.google.android.exoplayer2.extractor.g.q r1 = r0.f32006e
            r1.a()
        L_0x0134:
            com.google.android.exoplayer2.extractor.g.q r1 = r0.f32007f
            boolean r1 = r1.b(r6)
            if (r1 == 0) goto L_0x015e
            com.google.android.exoplayer2.extractor.g.q r1 = r0.f32007f
            byte[] r1 = r1.f32072b
            com.google.android.exoplayer2.extractor.g.q r3 = r0.f32007f
            int r3 = r3.f32073c
            int r1 = com.google.android.exoplayer2.g.p.a((byte[]) r1, (int) r3)
            com.google.android.exoplayer2.g.r r3 = r0.o
            com.google.android.exoplayer2.extractor.g.q r4 = r0.f32007f
            byte[] r4 = r4.f32072b
            r3.a((byte[]) r4, (int) r1)
            com.google.android.exoplayer2.g.r r1 = r0.o
            r3 = 4
            r1.c(r3)
            com.google.android.exoplayer2.extractor.g.x r1 = r0.f32002a
            com.google.android.exoplayer2.g.r r3 = r0.o
            r1.a((long) r10, (com.google.android.exoplayer2.g.r) r3)
        L_0x015e:
            com.google.android.exoplayer2.extractor.g.l$a r1 = r0.k
            boolean r3 = r0.l
            boolean r9 = r0.n
            int r4 = r1.f32015e
            r6 = 9
            if (r4 == r6) goto L_0x01f2
            boolean r4 = r1.f32013c
            if (r4 == 0) goto L_0x021e
            com.google.android.exoplayer2.extractor.g.l$a$a r4 = r1.j
            com.google.android.exoplayer2.extractor.g.l$a$a r6 = r1.f32019i
            boolean r10 = r4.f32020a
            if (r10 == 0) goto L_0x01ef
            boolean r10 = r6.f32020a
            if (r10 == 0) goto L_0x01ed
            int r10 = r4.f32025f
            int r11 = r6.f32025f
            if (r10 != r11) goto L_0x01ed
            int r10 = r4.f32026g
            int r11 = r6.f32026g
            if (r10 != r11) goto L_0x01ed
            boolean r10 = r4.f32027h
            boolean r11 = r6.f32027h
            if (r10 != r11) goto L_0x01ed
            boolean r10 = r4.f32028i
            if (r10 == 0) goto L_0x019a
            boolean r10 = r6.f32028i
            if (r10 == 0) goto L_0x019a
            boolean r10 = r4.j
            boolean r11 = r6.j
            if (r10 != r11) goto L_0x01ed
        L_0x019a:
            int r10 = r4.f32023d
            int r11 = r6.f32023d
            if (r10 == r11) goto L_0x01a8
            int r10 = r4.f32023d
            if (r10 == 0) goto L_0x01ed
            int r10 = r6.f32023d
            if (r10 == 0) goto L_0x01ed
        L_0x01a8:
            com.google.android.exoplayer2.g.p$b r10 = r4.f32022c
            int r10 = r10.k
            if (r10 != 0) goto L_0x01c0
            com.google.android.exoplayer2.g.p$b r10 = r6.f32022c
            int r10 = r10.k
            if (r10 != 0) goto L_0x01c0
            int r10 = r4.m
            int r11 = r6.m
            if (r10 != r11) goto L_0x01ed
            int r10 = r4.n
            int r11 = r6.n
            if (r10 != r11) goto L_0x01ed
        L_0x01c0:
            com.google.android.exoplayer2.g.p$b r10 = r4.f32022c
            int r10 = r10.k
            r11 = 1
            if (r10 != r11) goto L_0x01d9
            com.google.android.exoplayer2.g.p$b r10 = r6.f32022c
            int r10 = r10.k
            if (r10 != r11) goto L_0x01d9
            int r10 = r4.o
            int r11 = r6.o
            if (r10 != r11) goto L_0x01ed
            int r10 = r4.p
            int r11 = r6.p
            if (r10 != r11) goto L_0x01ed
        L_0x01d9:
            boolean r10 = r4.k
            boolean r11 = r6.k
            if (r10 != r11) goto L_0x01ed
            boolean r10 = r4.k
            if (r10 == 0) goto L_0x01ef
            boolean r10 = r6.k
            if (r10 == 0) goto L_0x01ef
            int r4 = r4.l
            int r6 = r6.l
            if (r4 == r6) goto L_0x01ef
        L_0x01ed:
            r4 = 1
            goto L_0x01f0
        L_0x01ef:
            r4 = 0
        L_0x01f0:
            if (r4 == 0) goto L_0x021e
        L_0x01f2:
            if (r3 == 0) goto L_0x0210
            boolean r3 = r1.k
            if (r3 == 0) goto L_0x0210
            long r3 = r1.f32016f
            long r3 = r7 - r3
            int r4 = (int) r3
            int r15 = r2 + r4
            boolean r13 = r1.n
            long r2 = r1.f32016f
            long r10 = r1.l
            long r2 = r2 - r10
            int r14 = (int) r2
            com.google.android.exoplayer2.extractor.q r10 = r1.f32011a
            long r11 = r1.m
            r16 = 0
            r10.a(r11, r13, r14, r15, r16)
        L_0x0210:
            long r2 = r1.f32016f
            r1.l = r2
            long r2 = r1.f32018h
            r1.m = r2
            r2 = 0
            r1.n = r2
            r2 = 1
            r1.k = r2
        L_0x021e:
            boolean r2 = r1.f32012b
            r3 = 2
            if (r2 == 0) goto L_0x0235
            com.google.android.exoplayer2.extractor.g.l$a$a r2 = r1.j
            boolean r4 = r2.f32021b
            if (r4 == 0) goto L_0x0234
            int r4 = r2.f32024e
            r6 = 7
            if (r4 == r6) goto L_0x0232
            int r2 = r2.f32024e
            if (r2 != r3) goto L_0x0234
        L_0x0232:
            r9 = 1
            goto L_0x0235
        L_0x0234:
            r9 = 0
        L_0x0235:
            boolean r2 = r1.n
            int r4 = r1.f32015e
            r6 = 5
            if (r4 == r6) goto L_0x0246
            if (r9 == 0) goto L_0x0244
            int r4 = r1.f32015e
            r9 = 1
            if (r4 != r9) goto L_0x0244
            goto L_0x0246
        L_0x0244:
            r4 = 0
            goto L_0x0247
        L_0x0246:
            r4 = 1
        L_0x0247:
            r2 = r2 | r4
            r1.n = r2
            boolean r1 = r1.n
            if (r1 == 0) goto L_0x0251
            r1 = 0
            r0.n = r1
        L_0x0251:
            long r1 = r0.m
            boolean r4 = r0.l
            if (r4 == 0) goto L_0x025d
            com.google.android.exoplayer2.extractor.g.l$a r4 = r0.k
            boolean r4 = r4.f32013c
            if (r4 == 0) goto L_0x0267
        L_0x025d:
            com.google.android.exoplayer2.extractor.g.q r4 = r0.f32005d
            r4.a(r5)
            com.google.android.exoplayer2.extractor.g.q r4 = r0.f32006e
            r4.a(r5)
        L_0x0267:
            com.google.android.exoplayer2.extractor.g.q r4 = r0.f32007f
            r4.a(r5)
            com.google.android.exoplayer2.extractor.g.l$a r4 = r0.k
            r4.f32015e = r5
            r4.f32018h = r1
            r4.f32016f = r7
            boolean r1 = r4.f32012b
            if (r1 == 0) goto L_0x027e
            int r1 = r4.f32015e
            r2 = 1
            if (r1 == r2) goto L_0x028f
            goto L_0x027f
        L_0x027e:
            r2 = 1
        L_0x027f:
            boolean r1 = r4.f32013c
            if (r1 == 0) goto L_0x02a2
            int r1 = r4.f32015e
            if (r1 == r6) goto L_0x028f
            int r1 = r4.f32015e
            if (r1 == r2) goto L_0x028f
            int r1 = r4.f32015e
            if (r1 != r3) goto L_0x02a2
        L_0x028f:
            com.google.android.exoplayer2.extractor.g.l$a$a r1 = r4.f32019i
            com.google.android.exoplayer2.extractor.g.l$a$a r2 = r4.j
            r4.f32019i = r2
            r4.j = r1
            com.google.android.exoplayer2.extractor.g.l$a$a r1 = r4.j
            r1.a()
            r1 = 0
            r4.f32014d = r1
            r1 = 1
            r4.f32017g = r1
        L_0x02a2:
            int r2 = r24 + 3
            r3 = r22
            r4 = r23
            goto L_0x001d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.g.l.a(com.google.android.exoplayer2.g.r):void");
    }
}
