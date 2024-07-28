package com.google.android.exoplayer2.extractor.mp4;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.h;
import com.google.android.exoplayer2.extractor.i;
import com.google.android.exoplayer2.extractor.j;
import com.google.android.exoplayer2.extractor.k;
import com.google.android.exoplayer2.extractor.mp4.a;
import com.google.android.exoplayer2.extractor.o;
import com.google.android.exoplayer2.extractor.q;
import com.google.android.exoplayer2.g.ae;
import com.google.android.exoplayer2.g.p;
import com.google.android.exoplayer2.g.r;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.v;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;

public final class g implements com.google.android.exoplayer2.extractor.g, o {

    /* renamed from: a  reason: collision with root package name */
    public static final j f32240a = $$Lambda$g$QujSFxu2JI1Xb6Dw7MCecDMOVs.INSTANCE;

    /* renamed from: b  reason: collision with root package name */
    private static final int f32241b = ae.h("qt  ");

    /* renamed from: c  reason: collision with root package name */
    private final int f32242c;

    /* renamed from: d  reason: collision with root package name */
    private final r f32243d;

    /* renamed from: e  reason: collision with root package name */
    private final r f32244e;

    /* renamed from: f  reason: collision with root package name */
    private final r f32245f;

    /* renamed from: g  reason: collision with root package name */
    private final r f32246g;

    /* renamed from: h  reason: collision with root package name */
    private final ArrayDeque<a.C0542a> f32247h;

    /* renamed from: i  reason: collision with root package name */
    private int f32248i;
    private int j;
    private long k;
    private int l;
    private r m;
    private int n;
    private int o;
    private int p;
    private boolean q;
    private i r;
    private a[] s;
    private long[][] t;
    private int u;
    private long v;
    private boolean w;

    public final boolean h_() {
        return true;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ com.google.android.exoplayer2.extractor.g[] d() {
        return new com.google.android.exoplayer2.extractor.g[]{new g()};
    }

    public g() {
        this(0);
    }

    public g(int i2) {
        this.f32242c = i2;
        this.f32246g = new r(16);
        this.f32247h = new ArrayDeque<>();
        this.f32243d = new r(p.f32546a);
        this.f32244e = new r(4);
        this.f32245f = new r();
        this.n = -1;
    }

    public final boolean a(h hVar) throws IOException, InterruptedException {
        return i.b(hVar);
    }

    public final void a(i iVar) {
        this.r = iVar;
    }

    public final void a(long j2, long j3) {
        this.f32247h.clear();
        this.l = 0;
        this.n = -1;
        this.o = 0;
        this.p = 0;
        this.q = false;
        if (j2 == 0) {
            c();
            return;
        }
        a[] aVarArr = this.s;
        if (aVarArr != null) {
            for (a aVar : aVarArr) {
                m mVar = aVar.f32250b;
                int a2 = mVar.a(j3);
                if (a2 == -1) {
                    a2 = mVar.b(j3);
                }
                aVar.f32252d = a2;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x022b  */
    /* JADX WARNING: Removed duplicated region for block: B:207:0x022f A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:209:0x03b3 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:210:0x0006 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:211:0x0006 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0166  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0228  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int a(com.google.android.exoplayer2.extractor.h r32, com.google.android.exoplayer2.extractor.n r33) throws java.io.IOException, java.lang.InterruptedException {
        /*
            r31 = this;
            r0 = r31
            r1 = r32
            r2 = r33
        L_0x0006:
            int r3 = r0.f32248i
            r4 = 0
            r7 = -1
            r8 = 8
            r9 = 1
            if (r3 == 0) goto L_0x0231
            r11 = 262144(0x40000, double:1.295163E-318)
            r13 = 2
            if (r3 == r9) goto L_0x01a9
            if (r3 != r13) goto L_0x01a3
            long r14 = r32.c()
            int r3 = r0.n
            if (r3 != r7) goto L_0x00a7
            r16 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r18 = r16
            r20 = r18
            r24 = r20
            r3 = 0
            r6 = 1
            r8 = 1
            r22 = -1
            r23 = -1
        L_0x0032:
            com.google.android.exoplayer2.extractor.mp4.g$a[] r13 = r0.s
            int r10 = r13.length
            if (r3 >= r10) goto L_0x0079
            r10 = r13[r3]
            int r13 = r10.f32252d
            com.google.android.exoplayer2.extractor.mp4.m r9 = r10.f32250b
            int r9 = r9.f32281b
            if (r13 == r9) goto L_0x0075
            com.google.android.exoplayer2.extractor.mp4.m r9 = r10.f32250b
            long[] r9 = r9.f32282c
            r27 = r9[r13]
            long[][] r9 = r0.t
            r9 = r9[r3]
            r29 = r9[r13]
            long r9 = r27 - r14
            int r13 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r13 < 0) goto L_0x005a
            int r13 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r13 < 0) goto L_0x0058
            goto L_0x005a
        L_0x0058:
            r13 = 0
            goto L_0x005b
        L_0x005a:
            r13 = 1
        L_0x005b:
            if (r13 != 0) goto L_0x005f
            if (r6 != 0) goto L_0x0065
        L_0x005f:
            if (r13 != r6) goto L_0x006c
            int r27 = (r9 > r24 ? 1 : (r9 == r24 ? 0 : -1))
            if (r27 >= 0) goto L_0x006c
        L_0x0065:
            r23 = r3
            r24 = r9
            r6 = r13
            r20 = r29
        L_0x006c:
            int r9 = (r29 > r18 ? 1 : (r29 == r18 ? 0 : -1))
            if (r9 >= 0) goto L_0x0075
            r22 = r3
            r8 = r13
            r18 = r29
        L_0x0075:
            int r3 = r3 + 1
            r9 = 1
            goto L_0x0032
        L_0x0079:
            int r3 = (r18 > r16 ? 1 : (r18 == r16 ? 0 : -1))
            if (r3 == 0) goto L_0x008c
            if (r8 == 0) goto L_0x008c
            r8 = 10485760(0xa00000, double:5.180654E-317)
            long r18 = r18 + r8
            int r3 = (r20 > r18 ? 1 : (r20 == r18 ? 0 : -1))
            if (r3 >= 0) goto L_0x0089
            goto L_0x008c
        L_0x0089:
            r3 = r22
            goto L_0x008e
        L_0x008c:
            r3 = r23
        L_0x008e:
            r0.n = r3
            int r3 = r0.n
            if (r3 != r7) goto L_0x0095
            return r7
        L_0x0095:
            com.google.android.exoplayer2.extractor.mp4.g$a[] r6 = r0.s
            r3 = r6[r3]
            com.google.android.exoplayer2.extractor.mp4.j r3 = r3.f32249a
            com.google.android.exoplayer2.Format r3 = r3.f32262f
            java.lang.String r3 = r3.f31069i
            java.lang.String r6 = "audio/ac4"
            boolean r3 = r6.equals(r3)
            r0.q = r3
        L_0x00a7:
            com.google.android.exoplayer2.extractor.mp4.g$a[] r3 = r0.s
            int r6 = r0.n
            r3 = r3[r6]
            com.google.android.exoplayer2.extractor.q r6 = r3.f32251c
            int r8 = r3.f32252d
            com.google.android.exoplayer2.extractor.mp4.m r9 = r3.f32250b
            long[] r9 = r9.f32282c
            r11 = r9[r8]
            com.google.android.exoplayer2.extractor.mp4.m r9 = r3.f32250b
            int[] r9 = r9.f32283d
            r9 = r9[r8]
            long r13 = r11 - r14
            int r10 = r0.o
            r18 = r8
            long r7 = (long) r10
            long r13 = r13 + r7
            int r7 = (r13 > r4 ? 1 : (r13 == r4 ? 0 : -1))
            if (r7 < 0) goto L_0x019f
            r4 = 262144(0x40000, double:1.295163E-318)
            int r7 = (r13 > r4 ? 1 : (r13 == r4 ? 0 : -1))
            if (r7 < 0) goto L_0x00d2
            goto L_0x019f
        L_0x00d2:
            com.google.android.exoplayer2.extractor.mp4.j r2 = r3.f32249a
            int r2 = r2.f32263g
            r4 = 1
            if (r2 != r4) goto L_0x00de
            r4 = 8
            long r13 = r13 + r4
            int r9 = r9 + -8
        L_0x00de:
            int r2 = (int) r13
            r1.b(r2)
            com.google.android.exoplayer2.extractor.mp4.j r2 = r3.f32249a
            int r2 = r2.j
            if (r2 == 0) goto L_0x0145
            com.google.android.exoplayer2.g.r r2 = r0.f32244e
            byte[] r2 = r2.f32566a
            r4 = 0
            r2[r4] = r4
            r5 = 1
            r2[r5] = r4
            r5 = 2
            r2[r5] = r4
            com.google.android.exoplayer2.extractor.mp4.j r4 = r3.f32249a
            int r4 = r4.j
            com.google.android.exoplayer2.extractor.mp4.j r5 = r3.f32249a
            int r5 = r5.j
            r7 = 4
            int r5 = 4 - r5
        L_0x0100:
            int r7 = r0.o
            if (r7 >= r9) goto L_0x0177
            int r7 = r0.p
            if (r7 != 0) goto L_0x0135
            r1.b(r2, r5, r4)
            com.google.android.exoplayer2.g.r r7 = r0.f32244e
            r8 = 0
            r7.c(r8)
            com.google.android.exoplayer2.g.r r7 = r0.f32244e
            int r7 = r7.i()
            if (r7 < 0) goto L_0x012d
            r0.p = r7
            com.google.android.exoplayer2.g.r r7 = r0.f32243d
            r7.c(r8)
            com.google.android.exoplayer2.g.r r7 = r0.f32243d
            r8 = 4
            r6.a(r7, r8)
            int r7 = r0.o
            int r7 = r7 + r8
            r0.o = r7
            int r9 = r9 + r5
            goto L_0x0100
        L_0x012d:
            com.google.android.exoplayer2.v r1 = new com.google.android.exoplayer2.v
            java.lang.String r2 = "Invalid NAL length"
            r1.<init>((java.lang.String) r2)
            throw r1
        L_0x0135:
            r8 = 0
            int r7 = r6.a(r1, r7, r8)
            int r8 = r0.o
            int r8 = r8 + r7
            r0.o = r8
            int r8 = r0.p
            int r8 = r8 - r7
            r0.p = r8
            goto L_0x0100
        L_0x0145:
            boolean r2 = r0.q
            if (r2 == 0) goto L_0x0161
            com.google.android.exoplayer2.g.r r2 = r0.f32245f
            com.google.android.exoplayer2.b.b.a((int) r9, (com.google.android.exoplayer2.g.r) r2)
            com.google.android.exoplayer2.g.r r2 = r0.f32245f
            int r2 = r2.f32568c
            com.google.android.exoplayer2.g.r r4 = r0.f32245f
            r6.a(r4, r2)
            int r9 = r9 + r2
            int r4 = r0.o
            int r4 = r4 + r2
            r0.o = r4
            r2 = 0
            r0.q = r2
            goto L_0x0162
        L_0x0161:
            r2 = 0
        L_0x0162:
            int r4 = r0.o
            if (r4 >= r9) goto L_0x0177
            int r4 = r9 - r4
            int r4 = r6.a(r1, r4, r2)
            int r2 = r0.o
            int r2 = r2 + r4
            r0.o = r2
            int r2 = r0.p
            int r2 = r2 - r4
            r0.p = r2
            goto L_0x0161
        L_0x0177:
            r20 = r9
            com.google.android.exoplayer2.extractor.mp4.m r1 = r3.f32250b
            long[] r1 = r1.f32285f
            r4 = r1[r18]
            com.google.android.exoplayer2.extractor.mp4.m r1 = r3.f32250b
            int[] r1 = r1.f32286g
            r19 = r1[r18]
            r21 = 0
            r22 = 0
            r16 = r6
            r17 = r4
            r16.a(r17, r19, r20, r21, r22)
            int r1 = r3.f32252d
            r4 = 1
            int r1 = r1 + r4
            r3.f32252d = r1
            r1 = -1
            r0.n = r1
            r1 = 0
            r0.o = r1
            r0.p = r1
            return r1
        L_0x019f:
            r4 = 1
            r2.f32288a = r11
            return r4
        L_0x01a3:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            r1.<init>()
            throw r1
        L_0x01a9:
            long r3 = r0.k
            int r5 = r0.l
            long r5 = (long) r5
            long r3 = r3 - r5
            long r5 = r32.c()
            long r5 = r5 + r3
            com.google.android.exoplayer2.g.r r7 = r0.m
            if (r7 == 0) goto L_0x0209
            byte[] r7 = r7.f32566a
            int r9 = r0.l
            int r4 = (int) r3
            r1.b(r7, r9, r4)
            int r3 = r0.j
            int r4 = com.google.android.exoplayer2.extractor.mp4.a.f32159a
            if (r3 != r4) goto L_0x01ec
            com.google.android.exoplayer2.g.r r3 = r0.m
            r3.c(r8)
            int r4 = r3.i()
            int r7 = f32241b
            if (r4 != r7) goto L_0x01d5
        L_0x01d3:
            r3 = 1
            goto L_0x01e9
        L_0x01d5:
            r4 = 4
            r3.d(r4)
        L_0x01d9:
            int r4 = r3.b()
            if (r4 <= 0) goto L_0x01e8
            int r4 = r3.i()
            int r7 = f32241b
            if (r4 != r7) goto L_0x01d9
            goto L_0x01d3
        L_0x01e8:
            r3 = 0
        L_0x01e9:
            r0.w = r3
            goto L_0x0214
        L_0x01ec:
            java.util.ArrayDeque<com.google.android.exoplayer2.extractor.mp4.a$a> r3 = r0.f32247h
            boolean r3 = r3.isEmpty()
            if (r3 != 0) goto L_0x0214
            java.util.ArrayDeque<com.google.android.exoplayer2.extractor.mp4.a$a> r3 = r0.f32247h
            java.lang.Object r3 = r3.peek()
            com.google.android.exoplayer2.extractor.mp4.a$a r3 = (com.google.android.exoplayer2.extractor.mp4.a.C0542a) r3
            com.google.android.exoplayer2.extractor.mp4.a$b r4 = new com.google.android.exoplayer2.extractor.mp4.a$b
            int r7 = r0.j
            com.google.android.exoplayer2.g.r r8 = r0.m
            r4.<init>(r7, r8)
            r3.a((com.google.android.exoplayer2.extractor.mp4.a.b) r4)
            goto L_0x0214
        L_0x0209:
            r7 = 262144(0x40000, double:1.295163E-318)
            int r9 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r9 >= 0) goto L_0x0216
            int r4 = (int) r3
            r1.b(r4)
        L_0x0214:
            r3 = 0
            goto L_0x021e
        L_0x0216:
            long r7 = r32.c()
            long r7 = r7 + r3
            r2.f32288a = r7
            r3 = 1
        L_0x021e:
            r0.b(r5)
            if (r3 == 0) goto L_0x022b
            int r3 = r0.f32248i
            r4 = 2
            if (r3 == r4) goto L_0x022b
            r26 = 1
            goto L_0x022d
        L_0x022b:
            r26 = 0
        L_0x022d:
            if (r26 == 0) goto L_0x0006
            r3 = 1
            return r3
        L_0x0231:
            r3 = 1
            int r6 = r0.l
            if (r6 != 0) goto L_0x025b
            com.google.android.exoplayer2.g.r r6 = r0.f32246g
            byte[] r6 = r6.f32566a
            r7 = 0
            boolean r6 = r1.a(r6, r7, r8, r3)
            if (r6 != 0) goto L_0x0244
            r4 = 0
            goto L_0x03b1
        L_0x0244:
            r0.l = r8
            com.google.android.exoplayer2.g.r r3 = r0.f32246g
            r3.c(r7)
            com.google.android.exoplayer2.g.r r3 = r0.f32246g
            long r6 = r3.g()
            r0.k = r6
            com.google.android.exoplayer2.g.r r3 = r0.f32246g
            int r3 = r3.i()
            r0.j = r3
        L_0x025b:
            long r6 = r0.k
            r9 = 1
            int r3 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r3 != 0) goto L_0x0278
            com.google.android.exoplayer2.g.r r3 = r0.f32246g
            byte[] r3 = r3.f32566a
            r1.b(r3, r8, r8)
            int r3 = r0.l
            int r3 = r3 + r8
            r0.l = r3
            com.google.android.exoplayer2.g.r r3 = r0.f32246g
            long r3 = r3.p()
            r0.k = r3
            goto L_0x02a7
        L_0x0278:
            int r3 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r3 != 0) goto L_0x02a7
            long r3 = r32.d()
            r5 = -1
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 != 0) goto L_0x0298
            java.util.ArrayDeque<com.google.android.exoplayer2.extractor.mp4.a$a> r7 = r0.f32247h
            boolean r7 = r7.isEmpty()
            if (r7 != 0) goto L_0x0298
            java.util.ArrayDeque<com.google.android.exoplayer2.extractor.mp4.a$a> r3 = r0.f32247h
            java.lang.Object r3 = r3.peek()
            com.google.android.exoplayer2.extractor.mp4.a$a r3 = (com.google.android.exoplayer2.extractor.mp4.a.C0542a) r3
            long r3 = r3.bh
        L_0x0298:
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 == 0) goto L_0x02a7
            long r5 = r32.c()
            long r3 = r3 - r5
            int r5 = r0.l
            long r5 = (long) r5
            long r3 = r3 + r5
            r0.k = r3
        L_0x02a7:
            long r3 = r0.k
            int r5 = r0.l
            long r5 = (long) r5
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 < 0) goto L_0x03b5
            int r3 = r0.j
            int r4 = com.google.android.exoplayer2.extractor.mp4.a.Q
            if (r3 == r4) goto L_0x02d1
            int r4 = com.google.android.exoplayer2.extractor.mp4.a.S
            if (r3 == r4) goto L_0x02d1
            int r4 = com.google.android.exoplayer2.extractor.mp4.a.T
            if (r3 == r4) goto L_0x02d1
            int r4 = com.google.android.exoplayer2.extractor.mp4.a.U
            if (r3 == r4) goto L_0x02d1
            int r4 = com.google.android.exoplayer2.extractor.mp4.a.V
            if (r3 == r4) goto L_0x02d1
            int r4 = com.google.android.exoplayer2.extractor.mp4.a.ac
            if (r3 == r4) goto L_0x02d1
            int r4 = com.google.android.exoplayer2.extractor.mp4.a.aO
            if (r3 != r4) goto L_0x02cf
            goto L_0x02d1
        L_0x02cf:
            r3 = 0
            goto L_0x02d2
        L_0x02d1:
            r3 = 1
        L_0x02d2:
            if (r3 == 0) goto L_0x0328
            long r3 = r32.c()
            long r5 = r0.k
            long r3 = r3 + r5
            int r5 = r0.l
            long r5 = (long) r5
            long r3 = r3 - r5
            java.util.ArrayDeque<com.google.android.exoplayer2.extractor.mp4.a$a> r5 = r0.f32247h
            com.google.android.exoplayer2.extractor.mp4.a$a r6 = new com.google.android.exoplayer2.extractor.mp4.a$a
            int r7 = r0.j
            r6.<init>(r7, r3)
            r5.push(r6)
            long r5 = r0.k
            int r7 = r0.l
            long r9 = (long) r7
            int r7 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r7 != 0) goto L_0x02fa
            r0.b(r3)
        L_0x02f7:
            r4 = 1
            goto L_0x03b1
        L_0x02fa:
            int r3 = r0.j
            int r4 = com.google.android.exoplayer2.extractor.mp4.a.aO
            if (r3 != r4) goto L_0x0324
            com.google.android.exoplayer2.g.r r3 = r0.f32245f
            r3.a(r8)
            com.google.android.exoplayer2.g.r r3 = r0.f32245f
            byte[] r3 = r3.f32566a
            r4 = 0
            r1.c(r3, r4, r8)
            com.google.android.exoplayer2.g.r r3 = r0.f32245f
            r4 = 4
            r3.d(r4)
            com.google.android.exoplayer2.g.r r3 = r0.f32245f
            int r3 = r3.i()
            int r5 = com.google.android.exoplayer2.extractor.mp4.a.af
            if (r3 != r5) goto L_0x0321
            r32.a()
            goto L_0x0324
        L_0x0321:
            r1.b(r4)
        L_0x0324:
            r31.c()
            goto L_0x02f7
        L_0x0328:
            int r3 = r0.j
            int r4 = com.google.android.exoplayer2.extractor.mp4.a.ae
            if (r3 == r4) goto L_0x0375
            int r4 = com.google.android.exoplayer2.extractor.mp4.a.R
            if (r3 == r4) goto L_0x0375
            int r4 = com.google.android.exoplayer2.extractor.mp4.a.af
            if (r3 == r4) goto L_0x0375
            int r4 = com.google.android.exoplayer2.extractor.mp4.a.ag
            if (r3 == r4) goto L_0x0375
            int r4 = com.google.android.exoplayer2.extractor.mp4.a.az
            if (r3 == r4) goto L_0x0375
            int r4 = com.google.android.exoplayer2.extractor.mp4.a.aA
            if (r3 == r4) goto L_0x0375
            int r4 = com.google.android.exoplayer2.extractor.mp4.a.aB
            if (r3 == r4) goto L_0x0375
            int r4 = com.google.android.exoplayer2.extractor.mp4.a.ad
            if (r3 == r4) goto L_0x0375
            int r4 = com.google.android.exoplayer2.extractor.mp4.a.aC
            if (r3 == r4) goto L_0x0375
            int r4 = com.google.android.exoplayer2.extractor.mp4.a.aD
            if (r3 == r4) goto L_0x0375
            int r4 = com.google.android.exoplayer2.extractor.mp4.a.aE
            if (r3 == r4) goto L_0x0375
            int r4 = com.google.android.exoplayer2.extractor.mp4.a.aF
            if (r3 == r4) goto L_0x0375
            int r4 = com.google.android.exoplayer2.extractor.mp4.a.aG
            if (r3 == r4) goto L_0x0375
            int r4 = com.google.android.exoplayer2.extractor.mp4.a.ab
            if (r3 == r4) goto L_0x0375
            int r4 = com.google.android.exoplayer2.extractor.mp4.a.f32159a
            if (r3 == r4) goto L_0x0375
            int r4 = com.google.android.exoplayer2.extractor.mp4.a.aN
            if (r3 == r4) goto L_0x0375
            int r4 = com.google.android.exoplayer2.extractor.mp4.a.aP
            if (r3 == r4) goto L_0x0375
            int r4 = com.google.android.exoplayer2.extractor.mp4.a.aQ
            if (r3 != r4) goto L_0x0373
            goto L_0x0375
        L_0x0373:
            r3 = 0
            goto L_0x0376
        L_0x0375:
            r3 = 1
        L_0x0376:
            if (r3 == 0) goto L_0x03ab
            int r3 = r0.l
            if (r3 != r8) goto L_0x037e
            r3 = 1
            goto L_0x037f
        L_0x037e:
            r3 = 0
        L_0x037f:
            com.google.android.exoplayer2.g.a.b(r3)
            long r3 = r0.k
            r5 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 > 0) goto L_0x038d
            r3 = 1
            goto L_0x038e
        L_0x038d:
            r3 = 0
        L_0x038e:
            com.google.android.exoplayer2.g.a.b(r3)
            com.google.android.exoplayer2.g.r r3 = new com.google.android.exoplayer2.g.r
            long r4 = r0.k
            int r5 = (int) r4
            r3.<init>((int) r5)
            r0.m = r3
            com.google.android.exoplayer2.g.r r3 = r0.f32246g
            byte[] r3 = r3.f32566a
            com.google.android.exoplayer2.g.r r4 = r0.m
            byte[] r4 = r4.f32566a
            r5 = 0
            java.lang.System.arraycopy(r3, r5, r4, r5, r8)
            r4 = 1
            r0.f32248i = r4
            goto L_0x03b1
        L_0x03ab:
            r4 = 1
            r3 = 0
            r0.m = r3
            r0.f32248i = r4
        L_0x03b1:
            if (r4 != 0) goto L_0x0006
            r3 = -1
            return r3
        L_0x03b5:
            com.google.android.exoplayer2.v r1 = new com.google.android.exoplayer2.v
            java.lang.String r2 = "Atom size less than header length (unsupported)."
            r1.<init>((java.lang.String) r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.mp4.g.a(com.google.android.exoplayer2.extractor.h, com.google.android.exoplayer2.extractor.n):int");
    }

    public final long b() {
        return this.v;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0073 A[EDGE_INSN: B:35:0x0073->B:29:0x0073 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.exoplayer2.extractor.o.a a(long r13) {
        /*
            r12 = this;
            com.google.android.exoplayer2.extractor.mp4.g$a[] r0 = r12.s
            int r1 = r0.length
            if (r1 != 0) goto L_0x000d
            com.google.android.exoplayer2.extractor.o$a r13 = new com.google.android.exoplayer2.extractor.o$a
            com.google.android.exoplayer2.extractor.p r14 = com.google.android.exoplayer2.extractor.p.f32293a
            r13.<init>(r14)
            return r13
        L_0x000d:
            r1 = -1
            int r3 = r12.u
            r4 = -1
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r3 == r4) goto L_0x004e
            r0 = r0[r3]
            com.google.android.exoplayer2.extractor.mp4.m r0 = r0.f32250b
            int r3 = a((com.google.android.exoplayer2.extractor.mp4.m) r0, (long) r13)
            if (r3 != r4) goto L_0x002b
            com.google.android.exoplayer2.extractor.o$a r13 = new com.google.android.exoplayer2.extractor.o$a
            com.google.android.exoplayer2.extractor.p r14 = com.google.android.exoplayer2.extractor.p.f32293a
            r13.<init>(r14)
            return r13
        L_0x002b:
            long[] r7 = r0.f32285f
            r8 = r7[r3]
            long[] r7 = r0.f32282c
            r10 = r7[r3]
            int r7 = (r8 > r13 ? 1 : (r8 == r13 ? 0 : -1))
            if (r7 >= 0) goto L_0x0054
            int r7 = r0.f32281b
            int r7 = r7 + -1
            if (r3 >= r7) goto L_0x0054
            int r13 = r0.b(r13)
            if (r13 == r4) goto L_0x0054
            if (r13 == r3) goto L_0x0054
            long[] r14 = r0.f32285f
            r1 = r14[r13]
            long[] r14 = r0.f32282c
            r13 = r14[r13]
            goto L_0x0056
        L_0x004e:
            r10 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r8 = r13
        L_0x0054:
            r13 = r1
            r1 = r5
        L_0x0056:
            r0 = 0
        L_0x0057:
            com.google.android.exoplayer2.extractor.mp4.g$a[] r3 = r12.s
            int r4 = r3.length
            if (r0 >= r4) goto L_0x0073
            int r4 = r12.u
            if (r0 == r4) goto L_0x0070
            r3 = r3[r0]
            com.google.android.exoplayer2.extractor.mp4.m r3 = r3.f32250b
            long r10 = a((com.google.android.exoplayer2.extractor.mp4.m) r3, (long) r8, (long) r10)
            int r4 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r4 == 0) goto L_0x0070
            long r13 = a((com.google.android.exoplayer2.extractor.mp4.m) r3, (long) r1, (long) r13)
        L_0x0070:
            int r0 = r0 + 1
            goto L_0x0057
        L_0x0073:
            com.google.android.exoplayer2.extractor.p r0 = new com.google.android.exoplayer2.extractor.p
            r0.<init>(r8, r10)
            int r3 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r3 != 0) goto L_0x0082
            com.google.android.exoplayer2.extractor.o$a r13 = new com.google.android.exoplayer2.extractor.o$a
            r13.<init>(r0)
            return r13
        L_0x0082:
            com.google.android.exoplayer2.extractor.p r3 = new com.google.android.exoplayer2.extractor.p
            r3.<init>(r1, r13)
            com.google.android.exoplayer2.extractor.o$a r13 = new com.google.android.exoplayer2.extractor.o$a
            r13.<init>(r0, r3)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.mp4.g.a(long):com.google.android.exoplayer2.extractor.o$a");
    }

    private void c() {
        this.f32248i = 0;
        this.l = 0;
    }

    private void b(long j2) throws v {
        while (!this.f32247h.isEmpty() && this.f32247h.peek().bh == j2) {
            a.C0542a pop = this.f32247h.pop();
            if (pop.bg == a.Q) {
                a(pop);
                this.f32247h.clear();
                this.f32248i = 2;
            } else if (!this.f32247h.isEmpty()) {
                this.f32247h.peek().a(pop);
            }
        }
        if (this.f32248i != 2) {
            c();
        }
    }

    private void a(a.C0542a aVar) throws v {
        Metadata metadata;
        long j2;
        m mVar;
        a.C0542a aVar2 = aVar;
        ArrayList arrayList = new ArrayList();
        k kVar = new k();
        a.b d2 = aVar2.d(a.aN);
        Metadata metadata2 = null;
        if (d2 != null) {
            metadata = b.a(d2, this.w);
            if (metadata != null) {
                kVar.a(metadata);
            }
        } else {
            metadata = null;
        }
        a.C0542a e2 = aVar2.e(a.aO);
        if (e2 != null) {
            metadata2 = b.a(e2);
        }
        ArrayList<m> a2 = a(aVar2, kVar, (this.f32242c & 1) != 0);
        int size = a2.size();
        long j3 = -9223372036854775807L;
        long j4 = -9223372036854775807L;
        int i2 = 0;
        int i3 = -1;
        while (i2 < size) {
            m mVar2 = a2.get(i2);
            j jVar = mVar2.f32280a;
            m mVar3 = mVar2;
            if (jVar.f32261e != j3) {
                j2 = jVar.f32261e;
                mVar = mVar3;
            } else {
                mVar = mVar3;
                j2 = mVar.f32287h;
            }
            long max = Math.max(j4, j2);
            ArrayList<m> arrayList2 = a2;
            int i4 = size;
            a aVar3 = new a(jVar, mVar, this.r.a(i2, jVar.f32258b));
            Format a3 = jVar.f32262f.a(mVar.f32284e + 30);
            long j5 = max;
            if (jVar.f32258b == 2 && j2 > 0) {
                if (mVar.f32281b > 1) {
                    a3 = a3.a(((float) mVar.f32281b) / (((float) j2) / 1000000.0f));
                }
            }
            aVar3.f32251c.a(f.a(jVar.f32258b, a3, metadata, metadata2, kVar));
            if (jVar.f32258b == 2) {
                if (i3 == -1) {
                    i3 = arrayList.size();
                }
            }
            arrayList.add(aVar3);
            i2++;
            a2 = arrayList2;
            size = i4;
            j4 = j5;
            j3 = -9223372036854775807L;
        }
        this.u = i3;
        this.v = j4;
        this.s = (a[]) arrayList.toArray(new a[0]);
        this.t = a(this.s);
        this.r.a();
        this.r.a(this);
    }

    private ArrayList<m> a(a.C0542a aVar, k kVar, boolean z) throws v {
        j a2;
        ArrayList<m> arrayList = new ArrayList<>();
        for (int i2 = 0; i2 < aVar.bj.size(); i2++) {
            a.C0542a aVar2 = aVar.bj.get(i2);
            if (aVar2.bg == a.S && (a2 = b.a(aVar2, aVar.d(a.R), -9223372036854775807L, (DrmInitData) null, z, this.w)) != null) {
                m a3 = b.a(a2, aVar2.e(a.T).e(a.U).e(a.V), kVar);
                if (a3.f32281b != 0) {
                    arrayList.add(a3);
                }
            }
        }
        return arrayList;
    }

    private static long[][] a(a[] aVarArr) {
        long[][] jArr = new long[aVarArr.length][];
        int[] iArr = new int[aVarArr.length];
        long[] jArr2 = new long[aVarArr.length];
        boolean[] zArr = new boolean[aVarArr.length];
        for (int i2 = 0; i2 < aVarArr.length; i2++) {
            jArr[i2] = new long[aVarArr[i2].f32250b.f32281b];
            jArr2[i2] = aVarArr[i2].f32250b.f32285f[0];
        }
        long j2 = 0;
        int i3 = 0;
        while (i3 < aVarArr.length) {
            int i4 = -1;
            long j3 = Long.MAX_VALUE;
            for (int i5 = 0; i5 < aVarArr.length; i5++) {
                if (!zArr[i5] && jArr2[i5] <= j3) {
                    j3 = jArr2[i5];
                    i4 = i5;
                }
            }
            int i6 = iArr[i4];
            jArr[i4][i6] = j2;
            j2 += (long) aVarArr[i4].f32250b.f32283d[i6];
            int i7 = i6 + 1;
            iArr[i4] = i7;
            if (i7 < jArr[i4].length) {
                jArr2[i4] = aVarArr[i4].f32250b.f32285f[i7];
            } else {
                zArr[i4] = true;
                i3++;
            }
        }
        return jArr;
    }

    private static long a(m mVar, long j2, long j3) {
        int a2 = a(mVar, j2);
        if (a2 == -1) {
            return j3;
        }
        return Math.min(mVar.f32282c[a2], j3);
    }

    private static int a(m mVar, long j2) {
        int a2 = mVar.a(j2);
        return a2 == -1 ? mVar.b(j2) : a2;
    }

    static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final j f32249a;

        /* renamed from: b  reason: collision with root package name */
        public final m f32250b;

        /* renamed from: c  reason: collision with root package name */
        public final q f32251c;

        /* renamed from: d  reason: collision with root package name */
        public int f32252d;

        public a(j jVar, m mVar, q qVar) {
            this.f32249a = jVar;
            this.f32250b = mVar;
            this.f32251c = qVar;
        }
    }
}
