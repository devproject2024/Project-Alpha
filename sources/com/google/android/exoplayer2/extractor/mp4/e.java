package com.google.android.exoplayer2.extractor.mp4;

import android.util.Pair;
import android.util.SparseArray;
import com.alipay.mobile.nebula.util.tar.TarConstants;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.g;
import com.google.android.exoplayer2.extractor.h;
import com.google.android.exoplayer2.extractor.i;
import com.google.android.exoplayer2.extractor.j;
import com.google.android.exoplayer2.extractor.mp4.a;
import com.google.android.exoplayer2.extractor.q;
import com.google.android.exoplayer2.g.ab;
import com.google.android.exoplayer2.g.ae;
import com.google.android.exoplayer2.g.l;
import com.google.android.exoplayer2.g.p;
import com.google.android.exoplayer2.g.r;
import com.google.android.exoplayer2.v;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import net.one97.paytm.nativesdk.emiSubvention.utils.EmiUtil;
import net.one97.paytm.upi.util.UpiConstants;

public final class e implements g {

    /* renamed from: a  reason: collision with root package name */
    public static final j f32211a = $$Lambda$e$3v30Bi5JvODpbaEixcgmEeprOE.INSTANCE;

    /* renamed from: b  reason: collision with root package name */
    private static final int f32212b = ae.h("seig");

    /* renamed from: c  reason: collision with root package name */
    private static final byte[] f32213c = {-94, 57, 79, 82, 90, -101, 79, 20, -94, 68, 108, 66, 124, 100, -115, -12};

    /* renamed from: d  reason: collision with root package name */
    private static final Format f32214d = Format.b((String) null, "application/x-emsg", Long.MAX_VALUE);
    private int A;
    private long B;
    private long C;
    private long D;
    private b E;
    private int F;
    private int G;
    private int H;
    private boolean I;
    private boolean J;
    private i K;
    private q[] L;
    private q[] M;
    private boolean N;

    /* renamed from: e  reason: collision with root package name */
    private final int f32215e;

    /* renamed from: f  reason: collision with root package name */
    private final j f32216f;

    /* renamed from: g  reason: collision with root package name */
    private final List<Format> f32217g;

    /* renamed from: h  reason: collision with root package name */
    private final DrmInitData f32218h;

    /* renamed from: i  reason: collision with root package name */
    private final SparseArray<b> f32219i;
    private final r j;
    private final r k;
    private final r l;
    private final byte[] m;
    private final r n;
    private final ab o;
    private final com.google.android.exoplayer2.metadata.emsg.b p;
    private final r q;
    private final ArrayDeque<a.C0542a> r;
    private final ArrayDeque<a> s;
    private final q t;
    private int u;
    private int v;
    private long w;
    private int x;
    private r y;
    private long z;

    /* access modifiers changed from: private */
    public static /* synthetic */ g[] c() {
        return new g[]{new e()};
    }

    public e() {
        this(0);
    }

    public e(int i2) {
        this(i2, (byte) 0);
    }

    private e(int i2, byte b2) {
        this(i2, (j) null);
    }

    public e(int i2, j jVar) {
        this(i2, (ab) null, jVar, (DrmInitData) null, Collections.emptyList());
    }

    public e(int i2, ab abVar, j jVar, DrmInitData drmInitData, List<Format> list) {
        this(i2, abVar, jVar, drmInitData, list, (q) null);
    }

    public e(int i2, ab abVar, j jVar, DrmInitData drmInitData, List<Format> list, q qVar) {
        this.f32215e = i2 | (jVar != null ? 8 : 0);
        this.o = abVar;
        this.f32216f = jVar;
        this.f32218h = drmInitData;
        this.f32217g = Collections.unmodifiableList(list);
        this.t = qVar;
        this.p = new com.google.android.exoplayer2.metadata.emsg.b();
        this.q = new r(16);
        this.j = new r(p.f32546a);
        this.k = new r(5);
        this.l = new r();
        this.m = new byte[16];
        this.n = new r(this.m);
        this.r = new ArrayDeque<>();
        this.s = new ArrayDeque<>();
        this.f32219i = new SparseArray<>();
        this.C = -9223372036854775807L;
        this.B = -9223372036854775807L;
        this.D = -9223372036854775807L;
        a();
    }

    public final boolean a(h hVar) throws IOException, InterruptedException {
        return i.a(hVar);
    }

    public final void a(i iVar) {
        this.K = iVar;
        j jVar = this.f32216f;
        if (jVar != null) {
            b bVar = new b(iVar.a(0, jVar.f32258b));
            bVar.a(this.f32216f, new c(0, 0, 0, 0));
            this.f32219i.put(0, bVar);
            b();
            this.K.a();
        }
    }

    public final void a(long j2, long j3) {
        int size = this.f32219i.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f32219i.valueAt(i2).a();
        }
        this.s.clear();
        this.A = 0;
        this.B = j3;
        this.r.clear();
        this.J = false;
        a();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v13, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v3, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:303:0x02f9 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:308:0x0752 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:311:0x0004 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0278  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int a(com.google.android.exoplayer2.extractor.h r27, com.google.android.exoplayer2.extractor.n r28) throws java.io.IOException, java.lang.InterruptedException {
        /*
            r26 = this;
            r0 = r26
            r1 = r27
        L_0x0004:
            int r2 = r0.u
            r3 = 2
            r4 = 0
            r5 = 8
            r6 = 1
            r7 = 0
            if (r2 == 0) goto L_0x0590
            if (r2 == r6) goto L_0x0357
            r9 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r11 = 3
            if (r2 == r3) goto L_0x02fb
            if (r2 != r11) goto L_0x0166
            com.google.android.exoplayer2.extractor.mp4.e$b r2 = r0.E
            if (r2 != 0) goto L_0x0080
            android.util.SparseArray<com.google.android.exoplayer2.extractor.mp4.e$b> r2 = r0.f32219i
            int r12 = r2.size()
            r13 = r9
            r9 = 0
            r10 = r4
        L_0x0027:
            if (r9 >= r12) goto L_0x004a
            java.lang.Object r15 = r2.valueAt(r9)
            com.google.android.exoplayer2.extractor.mp4.e$b r15 = (com.google.android.exoplayer2.extractor.mp4.e.b) r15
            int r8 = r15.f32228g
            com.google.android.exoplayer2.extractor.mp4.l r3 = r15.f32223b
            int r3 = r3.f32275e
            if (r8 == r3) goto L_0x0046
            com.google.android.exoplayer2.extractor.mp4.l r3 = r15.f32223b
            long[] r3 = r3.f32277g
            int r8 = r15.f32228g
            r17 = r3[r8]
            int r3 = (r17 > r13 ? 1 : (r17 == r13 ? 0 : -1))
            if (r3 >= 0) goto L_0x0046
            r10 = r15
            r13 = r17
        L_0x0046:
            int r9 = r9 + 1
            r3 = 2
            goto L_0x0027
        L_0x004a:
            if (r10 != 0) goto L_0x0067
            long r2 = r0.z
            long r4 = r27.c()
            long r2 = r2 - r4
            int r3 = (int) r2
            if (r3 < 0) goto L_0x005f
            r1.b(r3)
            r26.a()
            r6 = 0
            goto L_0x02f7
        L_0x005f:
            com.google.android.exoplayer2.v r1 = new com.google.android.exoplayer2.v
            java.lang.String r2 = "Offset to end of mdat was negative."
            r1.<init>((java.lang.String) r2)
            throw r1
        L_0x0067:
            com.google.android.exoplayer2.extractor.mp4.l r2 = r10.f32223b
            long[] r2 = r2.f32277g
            int r3 = r10.f32228g
            r8 = r2[r3]
            long r2 = r27.c()
            long r8 = r8 - r2
            int r2 = (int) r8
            if (r2 >= 0) goto L_0x007b
            com.google.android.exoplayer2.g.l.c()
            r2 = 0
        L_0x007b:
            r1.b(r2)
            r0.E = r10
        L_0x0080:
            com.google.android.exoplayer2.extractor.mp4.e$b r2 = r0.E
            com.google.android.exoplayer2.extractor.mp4.l r2 = r2.f32223b
            int[] r2 = r2.f32279i
            com.google.android.exoplayer2.extractor.mp4.e$b r3 = r0.E
            int r3 = r3.f32226e
            r2 = r2[r3]
            r0.F = r2
            com.google.android.exoplayer2.extractor.mp4.e$b r2 = r0.E
            int r2 = r2.f32226e
            com.google.android.exoplayer2.extractor.mp4.e$b r3 = r0.E
            int r3 = r3.f32229h
            if (r2 >= r3) goto L_0x00d3
            int r2 = r0.F
            r1.b(r2)
            com.google.android.exoplayer2.extractor.mp4.e$b r2 = r0.E
            com.google.android.exoplayer2.extractor.mp4.k r3 = r2.c()
            if (r3 == 0) goto L_0x00c5
            com.google.android.exoplayer2.extractor.mp4.l r5 = r2.f32223b
            com.google.android.exoplayer2.g.r r5 = r5.q
            int r8 = r3.f32269d
            if (r8 == 0) goto L_0x00b2
            int r3 = r3.f32269d
            r5.d(r3)
        L_0x00b2:
            com.google.android.exoplayer2.extractor.mp4.l r3 = r2.f32223b
            int r2 = r2.f32226e
            boolean r2 = r3.c(r2)
            if (r2 == 0) goto L_0x00c5
            int r2 = r5.d()
            int r2 = r2 * 6
            r5.d(r2)
        L_0x00c5:
            com.google.android.exoplayer2.extractor.mp4.e$b r2 = r0.E
            boolean r2 = r2.b()
            if (r2 != 0) goto L_0x00cf
            r0.E = r4
        L_0x00cf:
            r0.u = r11
            goto L_0x02f7
        L_0x00d3:
            com.google.android.exoplayer2.extractor.mp4.e$b r2 = r0.E
            com.google.android.exoplayer2.extractor.mp4.j r2 = r2.f32224c
            int r2 = r2.f32263g
            if (r2 != r6) goto L_0x00e3
            int r2 = r0.F
            int r2 = r2 - r5
            r0.F = r2
            r1.b(r5)
        L_0x00e3:
            com.google.android.exoplayer2.extractor.mp4.e$b r2 = r0.E
            com.google.android.exoplayer2.extractor.mp4.k r3 = r2.c()
            if (r3 != 0) goto L_0x00ed
            r2 = 0
            goto L_0x0148
        L_0x00ed:
            int r5 = r3.f32269d
            if (r5 == 0) goto L_0x00f8
            com.google.android.exoplayer2.extractor.mp4.l r5 = r2.f32223b
            com.google.android.exoplayer2.g.r r5 = r5.q
            int r3 = r3.f32269d
            goto L_0x0103
        L_0x00f8:
            byte[] r3 = r3.f32270e
            com.google.android.exoplayer2.g.r r5 = r2.j
            int r8 = r3.length
            r5.a((byte[]) r3, (int) r8)
            com.google.android.exoplayer2.g.r r5 = r2.j
            int r3 = r3.length
        L_0x0103:
            com.google.android.exoplayer2.extractor.mp4.l r8 = r2.f32223b
            int r9 = r2.f32226e
            boolean r8 = r8.c(r9)
            com.google.android.exoplayer2.g.r r9 = r2.f32230i
            byte[] r9 = r9.f32566a
            if (r8 == 0) goto L_0x0114
            r10 = 128(0x80, float:1.794E-43)
            goto L_0x0115
        L_0x0114:
            r10 = 0
        L_0x0115:
            r10 = r10 | r3
            byte r10 = (byte) r10
            r9[r7] = r10
            com.google.android.exoplayer2.g.r r9 = r2.f32230i
            r9.c(r7)
            com.google.android.exoplayer2.extractor.q r9 = r2.f32222a
            com.google.android.exoplayer2.g.r r10 = r2.f32230i
            r9.a(r10, r6)
            com.google.android.exoplayer2.extractor.q r9 = r2.f32222a
            r9.a(r5, r3)
            if (r8 != 0) goto L_0x012f
            int r2 = r3 + 1
            goto L_0x0148
        L_0x012f:
            com.google.android.exoplayer2.extractor.mp4.l r5 = r2.f32223b
            com.google.android.exoplayer2.g.r r5 = r5.q
            int r8 = r5.d()
            r9 = -2
            r5.d(r9)
            int r8 = r8 * 6
            r9 = 2
            int r8 = r8 + r9
            com.google.android.exoplayer2.extractor.q r2 = r2.f32222a
            r2.a(r5, r8)
            int r3 = r3 + 1
            int r2 = r3 + r8
        L_0x0148:
            r0.G = r2
            int r2 = r0.F
            int r3 = r0.G
            int r2 = r2 + r3
            r0.F = r2
            r2 = 4
            r0.u = r2
            r0.H = r7
            com.google.android.exoplayer2.extractor.mp4.e$b r2 = r0.E
            com.google.android.exoplayer2.extractor.mp4.j r2 = r2.f32224c
            com.google.android.exoplayer2.Format r2 = r2.f32262f
            java.lang.String r2 = r2.f31069i
            java.lang.String r3 = "audio/ac4"
            boolean r2 = r3.equals(r2)
            r0.J = r2
        L_0x0166:
            com.google.android.exoplayer2.extractor.mp4.e$b r2 = r0.E
            com.google.android.exoplayer2.extractor.mp4.l r2 = r2.f32223b
            com.google.android.exoplayer2.extractor.mp4.e$b r3 = r0.E
            com.google.android.exoplayer2.extractor.mp4.j r3 = r3.f32224c
            com.google.android.exoplayer2.extractor.mp4.e$b r5 = r0.E
            com.google.android.exoplayer2.extractor.q r5 = r5.f32222a
            com.google.android.exoplayer2.extractor.mp4.e$b r8 = r0.E
            int r8 = r8.f32226e
            long r9 = r2.b(r8)
            r12 = 1000(0x3e8, double:4.94E-321)
            long r9 = r9 * r12
            com.google.android.exoplayer2.g.ab r12 = r0.o
            if (r12 == 0) goto L_0x0186
            long r9 = r12.c(r9)
        L_0x0186:
            int r12 = r3.j
            if (r12 == 0) goto L_0x024f
            com.google.android.exoplayer2.g.r r12 = r0.k
            byte[] r12 = r12.f32566a
            r12[r7] = r7
            r12[r6] = r7
            r13 = 2
            r12[r13] = r7
            int r13 = r3.j
            int r13 = r13 + r6
            int r14 = r3.j
            r15 = 4
            int r14 = 4 - r14
        L_0x019d:
            int r15 = r0.G
            int r11 = r0.F
            if (r15 >= r11) goto L_0x0283
            int r11 = r0.H
            if (r11 != 0) goto L_0x01f6
            r1.b(r12, r14, r13)
            com.google.android.exoplayer2.g.r r11 = r0.k
            r11.c(r7)
            com.google.android.exoplayer2.g.r r11 = r0.k
            int r11 = r11.i()
            if (r11 <= 0) goto L_0x01ee
            int r11 = r11 + -1
            r0.H = r11
            com.google.android.exoplayer2.g.r r11 = r0.j
            r11.c(r7)
            com.google.android.exoplayer2.g.r r11 = r0.j
            r15 = 4
            r5.a(r11, r15)
            com.google.android.exoplayer2.g.r r11 = r0.k
            r5.a(r11, r6)
            com.google.android.exoplayer2.extractor.q[] r11 = r0.M
            int r11 = r11.length
            if (r11 <= 0) goto L_0x01de
            com.google.android.exoplayer2.Format r11 = r3.f32262f
            java.lang.String r11 = r11.f31069i
            byte r6 = r12[r15]
            boolean r6 = com.google.android.exoplayer2.g.p.a((java.lang.String) r11, (byte) r6)
            if (r6 == 0) goto L_0x01de
            r6 = 1
            goto L_0x01df
        L_0x01de:
            r6 = 0
        L_0x01df:
            r0.I = r6
            int r6 = r0.G
            int r6 = r6 + 5
            r0.G = r6
            int r6 = r0.F
            int r6 = r6 + r14
            r0.F = r6
            r6 = 1
            goto L_0x024c
        L_0x01ee:
            com.google.android.exoplayer2.v r1 = new com.google.android.exoplayer2.v
            java.lang.String r2 = "Invalid NAL length"
            r1.<init>((java.lang.String) r2)
            throw r1
        L_0x01f6:
            boolean r6 = r0.I
            if (r6 == 0) goto L_0x023a
            com.google.android.exoplayer2.g.r r6 = r0.l
            r6.a(r11)
            com.google.android.exoplayer2.g.r r6 = r0.l
            byte[] r6 = r6.f32566a
            int r11 = r0.H
            r1.b(r6, r7, r11)
            com.google.android.exoplayer2.g.r r6 = r0.l
            int r11 = r0.H
            r5.a(r6, r11)
            int r6 = r0.H
            com.google.android.exoplayer2.g.r r11 = r0.l
            byte[] r11 = r11.f32566a
            com.google.android.exoplayer2.g.r r15 = r0.l
            int r15 = r15.f32568c
            int r11 = com.google.android.exoplayer2.g.p.a((byte[]) r11, (int) r15)
            com.google.android.exoplayer2.g.r r15 = r0.l
            com.google.android.exoplayer2.Format r4 = r3.f32262f
            java.lang.String r4 = r4.f31069i
            java.lang.String r7 = "video/hevc"
            boolean r4 = r7.equals(r4)
            r15.c(r4)
            com.google.android.exoplayer2.g.r r4 = r0.l
            r4.b(r11)
            com.google.android.exoplayer2.g.r r4 = r0.l
            com.google.android.exoplayer2.extractor.q[] r7 = r0.M
            com.google.android.exoplayer2.e.a.f.a(r9, r4, r7)
            goto L_0x023f
        L_0x023a:
            r4 = 0
            int r6 = r5.a(r1, r11, r4)
        L_0x023f:
            int r4 = r0.G
            int r4 = r4 + r6
            r0.G = r4
            int r4 = r0.H
            int r4 = r4 - r6
            r0.H = r4
            r4 = 0
            r6 = 1
            r7 = 0
        L_0x024c:
            r11 = 3
            goto L_0x019d
        L_0x024f:
            boolean r3 = r0.J
            if (r3 == 0) goto L_0x0271
            int r3 = r0.F
            com.google.android.exoplayer2.g.r r4 = r0.n
            com.google.android.exoplayer2.b.b.a((int) r3, (com.google.android.exoplayer2.g.r) r4)
            com.google.android.exoplayer2.g.r r3 = r0.n
            int r3 = r3.f32568c
            com.google.android.exoplayer2.g.r r4 = r0.n
            r5.a(r4, r3)
            int r4 = r0.F
            int r4 = r4 + r3
            r0.F = r4
            int r4 = r0.G
            int r4 = r4 + r3
            r0.G = r4
            r3 = 0
            r0.J = r3
            goto L_0x0272
        L_0x0271:
            r3 = 0
        L_0x0272:
            int r4 = r0.G
            int r6 = r0.F
            if (r4 >= r6) goto L_0x0283
            int r6 = r6 - r4
            int r4 = r5.a(r1, r6, r3)
            int r3 = r0.G
            int r3 = r3 + r4
            r0.G = r3
            goto L_0x0271
        L_0x0283:
            boolean[] r2 = r2.l
            boolean r2 = r2[r8]
            com.google.android.exoplayer2.extractor.mp4.e$b r3 = r0.E
            com.google.android.exoplayer2.extractor.mp4.k r3 = r3.c()
            if (r3 == 0) goto L_0x0299
            r4 = 1073741824(0x40000000, float:2.0)
            r2 = r2 | r4
            com.google.android.exoplayer2.extractor.q$a r4 = r3.f32268c
            r20 = r2
            r23 = r4
            goto L_0x029d
        L_0x0299:
            r20 = r2
            r23 = 0
        L_0x029d:
            int r2 = r0.F
            r22 = 0
            r17 = r5
            r18 = r9
            r21 = r2
            r17.a(r18, r20, r21, r22, r23)
        L_0x02aa:
            java.util.ArrayDeque<com.google.android.exoplayer2.extractor.mp4.e$a> r2 = r0.s
            boolean r2 = r2.isEmpty()
            if (r2 != 0) goto L_0x02e8
            java.util.ArrayDeque<com.google.android.exoplayer2.extractor.mp4.e$a> r2 = r0.s
            java.lang.Object r2 = r2.removeFirst()
            com.google.android.exoplayer2.extractor.mp4.e$a r2 = (com.google.android.exoplayer2.extractor.mp4.e.a) r2
            int r3 = r0.A
            int r4 = r2.f32221b
            int r3 = r3 - r4
            r0.A = r3
            long r3 = r2.f32220a
            long r3 = r3 + r9
            com.google.android.exoplayer2.g.ab r5 = r0.o
            if (r5 == 0) goto L_0x02cc
            long r3 = r5.c(r3)
        L_0x02cc:
            com.google.android.exoplayer2.extractor.q[] r5 = r0.L
            int r6 = r5.length
            r7 = 0
        L_0x02d0:
            if (r7 >= r6) goto L_0x02aa
            r17 = r5[r7]
            r20 = 1
            int r8 = r2.f32221b
            int r11 = r0.A
            r23 = 0
            r18 = r3
            r21 = r8
            r22 = r11
            r17.a(r18, r20, r21, r22, r23)
            int r7 = r7 + 1
            goto L_0x02d0
        L_0x02e8:
            com.google.android.exoplayer2.extractor.mp4.e$b r2 = r0.E
            boolean r2 = r2.b()
            if (r2 != 0) goto L_0x02f3
            r2 = 0
            r0.E = r2
        L_0x02f3:
            r2 = 3
            r0.u = r2
            r6 = 1
        L_0x02f7:
            if (r6 == 0) goto L_0x0004
            r2 = 0
            return r2
        L_0x02fb:
            android.util.SparseArray<com.google.android.exoplayer2.extractor.mp4.e$b> r2 = r0.f32219i
            int r2 = r2.size()
            r3 = 0
            r4 = 0
        L_0x0303:
            if (r3 >= r2) goto L_0x0328
            android.util.SparseArray<com.google.android.exoplayer2.extractor.mp4.e$b> r5 = r0.f32219i
            java.lang.Object r5 = r5.valueAt(r3)
            com.google.android.exoplayer2.extractor.mp4.e$b r5 = (com.google.android.exoplayer2.extractor.mp4.e.b) r5
            com.google.android.exoplayer2.extractor.mp4.l r5 = r5.f32223b
            boolean r6 = r5.r
            if (r6 == 0) goto L_0x0325
            long r6 = r5.f32274d
            int r8 = (r6 > r9 ? 1 : (r6 == r9 ? 0 : -1))
            if (r8 >= 0) goto L_0x0325
            long r4 = r5.f32274d
            android.util.SparseArray<com.google.android.exoplayer2.extractor.mp4.e$b> r6 = r0.f32219i
            java.lang.Object r6 = r6.valueAt(r3)
            com.google.android.exoplayer2.extractor.mp4.e$b r6 = (com.google.android.exoplayer2.extractor.mp4.e.b) r6
            r9 = r4
            r4 = r6
        L_0x0325:
            int r3 = r3 + 1
            goto L_0x0303
        L_0x0328:
            if (r4 != 0) goto L_0x032f
            r2 = 3
            r0.u = r2
            goto L_0x0004
        L_0x032f:
            long r2 = r27.c()
            long r9 = r9 - r2
            int r2 = (int) r9
            if (r2 < 0) goto L_0x034f
            r1.b(r2)
            com.google.android.exoplayer2.extractor.mp4.l r2 = r4.f32223b
            com.google.android.exoplayer2.g.r r3 = r2.q
            byte[] r3 = r3.f32566a
            int r4 = r2.p
            r5 = 0
            r1.b(r3, r5, r4)
            com.google.android.exoplayer2.g.r r3 = r2.q
            r3.c(r5)
            r2.r = r5
            goto L_0x0004
        L_0x034f:
            com.google.android.exoplayer2.v r1 = new com.google.android.exoplayer2.v
            java.lang.String r2 = "Offset to encryption data was negative."
            r1.<init>((java.lang.String) r2)
            throw r1
        L_0x0357:
            long r2 = r0.w
            int r3 = (int) r2
            int r2 = r0.x
            int r3 = r3 - r2
            com.google.android.exoplayer2.g.r r2 = r0.y
            if (r2 == 0) goto L_0x0580
            byte[] r2 = r2.f32566a
            r1.b(r2, r5, r3)
            com.google.android.exoplayer2.extractor.mp4.a$b r2 = new com.google.android.exoplayer2.extractor.mp4.a$b
            int r3 = r0.v
            com.google.android.exoplayer2.g.r r4 = r0.y
            r2.<init>(r3, r4)
            long r3 = r27.c()
            java.util.ArrayDeque<com.google.android.exoplayer2.extractor.mp4.a$a> r6 = r0.r
            boolean r6 = r6.isEmpty()
            if (r6 != 0) goto L_0x038a
            java.util.ArrayDeque<com.google.android.exoplayer2.extractor.mp4.a$a> r3 = r0.r
            java.lang.Object r3 = r3.peek()
            com.google.android.exoplayer2.extractor.mp4.a$a r3 = (com.google.android.exoplayer2.extractor.mp4.a.C0542a) r3
            r3.a((com.google.android.exoplayer2.extractor.mp4.a.b) r2)
            r4 = r0
            r0 = r1
            goto L_0x0585
        L_0x038a:
            int r6 = r2.bg
            int r7 = com.google.android.exoplayer2.extractor.mp4.a.P
            if (r6 != r7) goto L_0x0456
            com.google.android.exoplayer2.g.r r2 = r2.bh
            r2.c(r5)
            int r5 = r2.i()
            int r5 = com.google.android.exoplayer2.extractor.mp4.a.a(r5)
            r6 = 4
            r2.d(r6)
            long r13 = r2.g()
            if (r5 != 0) goto L_0x03b0
            long r5 = r2.g()
            long r7 = r2.g()
            goto L_0x03b8
        L_0x03b0:
            long r5 = r2.p()
            long r7 = r2.p()
        L_0x03b8:
            long r3 = r3 + r7
            r9 = 1000000(0xf4240, double:4.940656E-318)
            r7 = r5
            r11 = r13
            long r17 = com.google.android.exoplayer2.g.ae.b((long) r7, (long) r9, (long) r11)
            r7 = 2
            r2.d(r7)
            int r15 = r2.d()
            int[] r11 = new int[r15]
            long[] r12 = new long[r15]
            long[] r9 = new long[r15]
            long[] r10 = new long[r15]
            r19 = r5
            r6 = r17
            r4 = r3
            r3 = 0
        L_0x03d8:
            if (r3 >= r15) goto L_0x042b
            int r8 = r2.i()
            r16 = -2147483648(0xffffffff80000000, float:-0.0)
            r16 = r8 & r16
            if (r16 != 0) goto L_0x0423
            long r21 = r2.g()
            r16 = 2147483647(0x7fffffff, float:NaN)
            r8 = r8 & r16
            r11[r3] = r8
            r12[r3] = r4
            r10[r3] = r6
            long r19 = r19 + r21
            r21 = 1000000(0xf4240, double:4.940656E-318)
            r7 = r19
            r6 = r9
            r16 = r15
            r15 = r10
            r9 = r21
            r1 = r11
            r0 = r12
            r11 = r13
            long r7 = com.google.android.exoplayer2.g.ae.b((long) r7, (long) r9, (long) r11)
            r9 = r15[r3]
            long r9 = r7 - r9
            r6[r3] = r9
            r9 = 4
            r2.d(r9)
            r10 = r1[r3]
            long r10 = (long) r10
            long r4 = r4 + r10
            int r3 = r3 + 1
            r12 = r0
            r11 = r1
            r9 = r6
            r6 = r7
            r10 = r15
            r15 = r16
            r0 = r26
            r1 = r27
            goto L_0x03d8
        L_0x0423:
            com.google.android.exoplayer2.v r0 = new com.google.android.exoplayer2.v
            java.lang.String r1 = "Unhandled indirect reference"
            r0.<init>((java.lang.String) r1)
            throw r0
        L_0x042b:
            r6 = r9
            r15 = r10
            r1 = r11
            r0 = r12
            java.lang.Long r2 = java.lang.Long.valueOf(r17)
            com.google.android.exoplayer2.extractor.b r3 = new com.google.android.exoplayer2.extractor.b
            r3.<init>(r1, r0, r6, r15)
            android.util.Pair r0 = android.util.Pair.create(r2, r3)
            java.lang.Object r1 = r0.first
            java.lang.Long r1 = (java.lang.Long) r1
            long r1 = r1.longValue()
            r4 = r26
            r4.D = r1
            com.google.android.exoplayer2.extractor.i r1 = r4.K
            java.lang.Object r0 = r0.second
            com.google.android.exoplayer2.extractor.o r0 = (com.google.android.exoplayer2.extractor.o) r0
            r1.a(r0)
            r0 = 1
            r4.N = r0
            goto L_0x057d
        L_0x0456:
            r4 = r0
            int r0 = r2.bg
            int r1 = com.google.android.exoplayer2.extractor.mp4.a.aU
            if (r0 != r1) goto L_0x057d
            com.google.android.exoplayer2.g.r r0 = r2.bh
            com.google.android.exoplayer2.extractor.q[] r1 = r4.L
            if (r1 == 0) goto L_0x057d
            int r1 = r1.length
            if (r1 != 0) goto L_0x0468
            goto L_0x057d
        L_0x0468:
            r0.c(r5)
            int r1 = r0.i()
            int r1 = com.google.android.exoplayer2.extractor.mp4.a.a(r1)
            r2 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r1 == 0) goto L_0x04c7
            r5 = 1
            if (r1 == r5) goto L_0x048b
            java.lang.String r0 = java.lang.String.valueOf(r1)
            java.lang.String r1 = "Skipping unsupported emsg version: "
            r1.concat(r0)
            com.google.android.exoplayer2.g.l.c()
            goto L_0x057d
        L_0x048b:
            long r11 = r0.g()
            long r5 = r0.p()
            r7 = 1000000(0xf4240, double:4.940656E-318)
            r9 = r11
            long r13 = com.google.android.exoplayer2.g.ae.b((long) r5, (long) r7, (long) r9)
            long r5 = r0.g()
            r7 = 1000(0x3e8, double:4.94E-321)
            long r5 = com.google.android.exoplayer2.g.ae.b((long) r5, (long) r7, (long) r9)
            long r7 = r0.g()
            java.lang.String r1 = r0.q()
            java.lang.Object r1 = com.google.android.exoplayer2.g.a.a(r1)
            java.lang.String r1 = (java.lang.String) r1
            java.lang.String r9 = r0.q()
            java.lang.Object r9 = com.google.android.exoplayer2.g.a.a(r9)
            java.lang.String r9 = (java.lang.String) r9
            r19 = r1
            r21 = r5
            r23 = r7
            r20 = r9
            r7 = r2
            goto L_0x0511
        L_0x04c7:
            java.lang.String r1 = r0.q()
            java.lang.Object r1 = com.google.android.exoplayer2.g.a.a(r1)
            java.lang.String r1 = (java.lang.String) r1
            java.lang.String r5 = r0.q()
            java.lang.Object r5 = com.google.android.exoplayer2.g.a.a(r5)
            r9 = r5
            java.lang.String r9 = (java.lang.String) r9
            long r5 = r0.g()
            long r10 = r0.g()
            r12 = 1000000(0xf4240, double:4.940656E-318)
            r14 = r5
            long r7 = com.google.android.exoplayer2.g.ae.b((long) r10, (long) r12, (long) r14)
            long r10 = r4.D
            int r12 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r12 == 0) goto L_0x04f6
            long r10 = r10 + r7
            r16 = r10
            goto L_0x04f8
        L_0x04f6:
            r16 = r2
        L_0x04f8:
            long r10 = r0.g()
            r12 = 1000(0x3e8, double:4.94E-321)
            r14 = r5
            long r5 = com.google.android.exoplayer2.g.ae.b((long) r10, (long) r12, (long) r14)
            long r10 = r0.g()
            r19 = r1
            r21 = r5
            r20 = r9
            r23 = r10
            r13 = r16
        L_0x0511:
            int r1 = r0.b()
            byte[] r1 = new byte[r1]
            int r5 = r0.b()
            r6 = 0
            r0.a(r1, r6, r5)
            com.google.android.exoplayer2.metadata.emsg.EventMessage r0 = new com.google.android.exoplayer2.metadata.emsg.EventMessage
            r18 = r0
            r25 = r1
            r18.<init>(r19, r20, r21, r23, r25)
            com.google.android.exoplayer2.g.r r1 = new com.google.android.exoplayer2.g.r
            com.google.android.exoplayer2.metadata.emsg.b r5 = r4.p
            byte[] r0 = r5.a(r0)
            r1.<init>((byte[]) r0)
            int r0 = r1.b()
            com.google.android.exoplayer2.extractor.q[] r5 = r4.L
            int r6 = r5.length
            r9 = 0
        L_0x053b:
            if (r9 >= r6) goto L_0x0549
            r10 = r5[r9]
            r11 = 0
            r1.c(r11)
            r10.a(r1, r0)
            int r9 = r9 + 1
            goto L_0x053b
        L_0x0549:
            int r1 = (r13 > r2 ? 1 : (r13 == r2 ? 0 : -1))
            if (r1 != 0) goto L_0x055d
            java.util.ArrayDeque<com.google.android.exoplayer2.extractor.mp4.e$a> r1 = r4.s
            com.google.android.exoplayer2.extractor.mp4.e$a r2 = new com.google.android.exoplayer2.extractor.mp4.e$a
            r2.<init>(r7, r0)
            r1.addLast(r2)
            int r1 = r4.A
            int r1 = r1 + r0
            r4.A = r1
            goto L_0x057d
        L_0x055d:
            com.google.android.exoplayer2.g.ab r1 = r4.o
            if (r1 == 0) goto L_0x0565
            long r13 = r1.c(r13)
        L_0x0565:
            com.google.android.exoplayer2.extractor.q[] r1 = r4.L
            int r2 = r1.length
            r3 = 0
        L_0x0569:
            if (r3 >= r2) goto L_0x057d
            r15 = r1[r3]
            r18 = 1
            r20 = 0
            r21 = 0
            r16 = r13
            r19 = r0
            r15.a(r16, r18, r19, r20, r21)
            int r3 = r3 + 1
            goto L_0x0569
        L_0x057d:
            r0 = r27
            goto L_0x0585
        L_0x0580:
            r4 = r0
            r0 = r1
            r0.b(r3)
        L_0x0585:
            long r1 = r27.c()
            r4.a((long) r1)
        L_0x058c:
            r1 = r0
            r0 = r4
            goto L_0x0004
        L_0x0590:
            r4 = r0
            r0 = r1
            int r1 = r4.x
            if (r1 != 0) goto L_0x05bc
            com.google.android.exoplayer2.g.r r1 = r4.q
            byte[] r1 = r1.f32566a
            r2 = 1
            r3 = 0
            boolean r1 = r0.a(r1, r3, r5, r2)
            if (r1 != 0) goto L_0x05a5
            r1 = 0
            goto L_0x0750
        L_0x05a5:
            r4.x = r5
            com.google.android.exoplayer2.g.r r1 = r4.q
            r1.c(r3)
            com.google.android.exoplayer2.g.r r1 = r4.q
            long r1 = r1.g()
            r4.w = r1
            com.google.android.exoplayer2.g.r r1 = r4.q
            int r1 = r1.i()
            r4.v = r1
        L_0x05bc:
            long r1 = r4.w
            r6 = 1
            int r3 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r3 != 0) goto L_0x05d9
            com.google.android.exoplayer2.g.r r1 = r4.q
            byte[] r1 = r1.f32566a
            r0.b(r1, r5, r5)
            int r1 = r4.x
            int r1 = r1 + r5
            r4.x = r1
            com.google.android.exoplayer2.g.r r1 = r4.q
            long r1 = r1.p()
            r4.w = r1
            goto L_0x060a
        L_0x05d9:
            r6 = 0
            int r3 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r3 != 0) goto L_0x060a
            long r1 = r27.d()
            r6 = -1
            int r3 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r3 != 0) goto L_0x05fb
            java.util.ArrayDeque<com.google.android.exoplayer2.extractor.mp4.a$a> r3 = r4.r
            boolean r3 = r3.isEmpty()
            if (r3 != 0) goto L_0x05fb
            java.util.ArrayDeque<com.google.android.exoplayer2.extractor.mp4.a$a> r1 = r4.r
            java.lang.Object r1 = r1.peek()
            com.google.android.exoplayer2.extractor.mp4.a$a r1 = (com.google.android.exoplayer2.extractor.mp4.a.C0542a) r1
            long r1 = r1.bh
        L_0x05fb:
            int r3 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r3 == 0) goto L_0x060a
            long r6 = r27.c()
            long r1 = r1 - r6
            int r3 = r4.x
            long r6 = (long) r3
            long r1 = r1 + r6
            r4.w = r1
        L_0x060a:
            long r1 = r4.w
            int r3 = r4.x
            long r6 = (long) r3
            int r3 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r3 < 0) goto L_0x075c
            long r1 = r27.c()
            int r3 = r4.x
            long r6 = (long) r3
            long r1 = r1 - r6
            int r3 = r4.v
            int r6 = com.google.android.exoplayer2.extractor.mp4.a.X
            if (r3 != r6) goto L_0x063d
            android.util.SparseArray<com.google.android.exoplayer2.extractor.mp4.e$b> r3 = r4.f32219i
            int r3 = r3.size()
            r6 = 0
        L_0x0628:
            if (r6 >= r3) goto L_0x063d
            android.util.SparseArray<com.google.android.exoplayer2.extractor.mp4.e$b> r7 = r4.f32219i
            java.lang.Object r7 = r7.valueAt(r6)
            com.google.android.exoplayer2.extractor.mp4.e$b r7 = (com.google.android.exoplayer2.extractor.mp4.e.b) r7
            com.google.android.exoplayer2.extractor.mp4.l r7 = r7.f32223b
            r7.f32272b = r1
            r7.f32274d = r1
            r7.f32273c = r1
            int r6 = r6 + 1
            goto L_0x0628
        L_0x063d:
            int r3 = r4.v
            int r6 = com.google.android.exoplayer2.extractor.mp4.a.u
            if (r3 != r6) goto L_0x0664
            r3 = 0
            r4.E = r3
            long r5 = r4.w
            long r5 = r5 + r1
            r4.z = r5
            boolean r3 = r4.N
            if (r3 != 0) goto L_0x065e
            com.google.android.exoplayer2.extractor.i r3 = r4.K
            com.google.android.exoplayer2.extractor.o$b r5 = new com.google.android.exoplayer2.extractor.o$b
            long r6 = r4.C
            r5.<init>(r6, r1)
            r3.a(r5)
            r1 = 1
            r4.N = r1
        L_0x065e:
            r1 = 2
            r4.u = r1
        L_0x0661:
            r1 = 1
            goto L_0x0750
        L_0x0664:
            int r1 = r4.v
            int r2 = com.google.android.exoplayer2.extractor.mp4.a.Q
            if (r1 == r2) goto L_0x068d
            int r2 = com.google.android.exoplayer2.extractor.mp4.a.S
            if (r1 == r2) goto L_0x068d
            int r2 = com.google.android.exoplayer2.extractor.mp4.a.T
            if (r1 == r2) goto L_0x068d
            int r2 = com.google.android.exoplayer2.extractor.mp4.a.U
            if (r1 == r2) goto L_0x068d
            int r2 = com.google.android.exoplayer2.extractor.mp4.a.V
            if (r1 == r2) goto L_0x068d
            int r2 = com.google.android.exoplayer2.extractor.mp4.a.X
            if (r1 == r2) goto L_0x068d
            int r2 = com.google.android.exoplayer2.extractor.mp4.a.Y
            if (r1 == r2) goto L_0x068d
            int r2 = com.google.android.exoplayer2.extractor.mp4.a.Z
            if (r1 == r2) goto L_0x068d
            int r2 = com.google.android.exoplayer2.extractor.mp4.a.ac
            if (r1 != r2) goto L_0x068b
            goto L_0x068d
        L_0x068b:
            r1 = 0
            goto L_0x068e
        L_0x068d:
            r1 = 1
        L_0x068e:
            if (r1 == 0) goto L_0x06b7
            long r1 = r27.c()
            long r5 = r4.w
            long r1 = r1 + r5
            r5 = 8
            long r1 = r1 - r5
            java.util.ArrayDeque<com.google.android.exoplayer2.extractor.mp4.a$a> r3 = r4.r
            com.google.android.exoplayer2.extractor.mp4.a$a r5 = new com.google.android.exoplayer2.extractor.mp4.a$a
            int r6 = r4.v
            r5.<init>(r6, r1)
            r3.push(r5)
            long r5 = r4.w
            int r3 = r4.x
            long r7 = (long) r3
            int r3 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r3 != 0) goto L_0x06b3
            r4.a((long) r1)
            goto L_0x0661
        L_0x06b3:
            r26.a()
            goto L_0x0661
        L_0x06b7:
            int r1 = r4.v
            int r2 = com.google.android.exoplayer2.extractor.mp4.a.af
            if (r1 == r2) goto L_0x070c
            int r2 = com.google.android.exoplayer2.extractor.mp4.a.ae
            if (r1 == r2) goto L_0x070c
            int r2 = com.google.android.exoplayer2.extractor.mp4.a.R
            if (r1 == r2) goto L_0x070c
            int r2 = com.google.android.exoplayer2.extractor.mp4.a.P
            if (r1 == r2) goto L_0x070c
            int r2 = com.google.android.exoplayer2.extractor.mp4.a.ag
            if (r1 == r2) goto L_0x070c
            int r2 = com.google.android.exoplayer2.extractor.mp4.a.L
            if (r1 == r2) goto L_0x070c
            int r2 = com.google.android.exoplayer2.extractor.mp4.a.M
            if (r1 == r2) goto L_0x070c
            int r2 = com.google.android.exoplayer2.extractor.mp4.a.ab
            if (r1 == r2) goto L_0x070c
            int r2 = com.google.android.exoplayer2.extractor.mp4.a.N
            if (r1 == r2) goto L_0x070c
            int r2 = com.google.android.exoplayer2.extractor.mp4.a.O
            if (r1 == r2) goto L_0x070c
            int r2 = com.google.android.exoplayer2.extractor.mp4.a.ah
            if (r1 == r2) goto L_0x070c
            int r2 = com.google.android.exoplayer2.extractor.mp4.a.ap
            if (r1 == r2) goto L_0x070c
            int r2 = com.google.android.exoplayer2.extractor.mp4.a.aq
            if (r1 == r2) goto L_0x070c
            int r2 = com.google.android.exoplayer2.extractor.mp4.a.au
            if (r1 == r2) goto L_0x070c
            int r2 = com.google.android.exoplayer2.extractor.mp4.a.at
            if (r1 == r2) goto L_0x070c
            int r2 = com.google.android.exoplayer2.extractor.mp4.a.ar
            if (r1 == r2) goto L_0x070c
            int r2 = com.google.android.exoplayer2.extractor.mp4.a.as
            if (r1 == r2) goto L_0x070c
            int r2 = com.google.android.exoplayer2.extractor.mp4.a.ad
            if (r1 == r2) goto L_0x070c
            int r2 = com.google.android.exoplayer2.extractor.mp4.a.aa
            if (r1 == r2) goto L_0x070c
            int r2 = com.google.android.exoplayer2.extractor.mp4.a.aU
            if (r1 != r2) goto L_0x070a
            goto L_0x070c
        L_0x070a:
            r1 = 0
            goto L_0x070d
        L_0x070c:
            r1 = 1
        L_0x070d:
            r2 = 2147483647(0x7fffffff, double:1.060997895E-314)
            if (r1 == 0) goto L_0x0744
            int r1 = r4.x
            if (r1 != r5) goto L_0x073c
            long r6 = r4.w
            int r1 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r1 > 0) goto L_0x0734
            com.google.android.exoplayer2.g.r r1 = new com.google.android.exoplayer2.g.r
            int r2 = (int) r6
            r1.<init>((int) r2)
            r4.y = r1
            com.google.android.exoplayer2.g.r r1 = r4.q
            byte[] r1 = r1.f32566a
            com.google.android.exoplayer2.g.r r2 = r4.y
            byte[] r2 = r2.f32566a
            r3 = 0
            java.lang.System.arraycopy(r1, r3, r2, r3, r5)
            r1 = 1
            r4.u = r1
            goto L_0x0750
        L_0x0734:
            com.google.android.exoplayer2.v r0 = new com.google.android.exoplayer2.v
            java.lang.String r1 = "Leaf atom with length > 2147483647 (unsupported)."
            r0.<init>((java.lang.String) r1)
            throw r0
        L_0x073c:
            com.google.android.exoplayer2.v r0 = new com.google.android.exoplayer2.v
            java.lang.String r1 = "Leaf atom defines extended atom size (unsupported)."
            r0.<init>((java.lang.String) r1)
            throw r0
        L_0x0744:
            long r5 = r4.w
            int r1 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r1 > 0) goto L_0x0754
            r1 = 0
            r4.y = r1
            r1 = 1
            r4.u = r1
        L_0x0750:
            if (r1 != 0) goto L_0x058c
            r0 = -1
            return r0
        L_0x0754:
            com.google.android.exoplayer2.v r0 = new com.google.android.exoplayer2.v
            java.lang.String r1 = "Skipping atom with length > 2147483647 (unsupported)."
            r0.<init>((java.lang.String) r1)
            throw r0
        L_0x075c:
            com.google.android.exoplayer2.v r0 = new com.google.android.exoplayer2.v
            java.lang.String r1 = "Atom size less than header length (unsupported)."
            r0.<init>((java.lang.String) r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.mp4.e.a(com.google.android.exoplayer2.extractor.h, com.google.android.exoplayer2.extractor.n):int");
    }

    private void a() {
        this.u = 0;
        this.x = 0;
    }

    private void a(long j2) throws v {
        while (!this.r.isEmpty() && this.r.peek().bh == j2) {
            a(this.r.pop());
        }
        a();
    }

    private void a(a.C0542a aVar) throws v {
        if (aVar.bg == a.Q) {
            b(aVar);
        } else if (aVar.bg == a.X) {
            c(aVar);
        } else if (!this.r.isEmpty()) {
            this.r.peek().a(aVar);
        }
    }

    private void b(a.C0542a aVar) throws v {
        int i2;
        int i3;
        a.C0542a aVar2 = aVar;
        boolean z2 = true;
        int i4 = 0;
        com.google.android.exoplayer2.g.a.b(this.f32216f == null, "Unexpected moov box.");
        DrmInitData drmInitData = this.f32218h;
        if (drmInitData == null) {
            drmInitData = a(aVar2.bi);
        }
        a.C0542a e2 = aVar2.e(a.Z);
        SparseArray sparseArray = new SparseArray();
        int size = e2.bi.size();
        long j2 = -9223372036854775807L;
        for (int i5 = 0; i5 < size; i5++) {
            a.b bVar = e2.bi.get(i5);
            if (bVar.bg == a.N) {
                Pair<Integer, c> a2 = a(bVar.bh);
                sparseArray.put(((Integer) a2.first).intValue(), a2.second);
            } else if (bVar.bg == a.aa) {
                j2 = b(bVar.bh);
            }
        }
        SparseArray sparseArray2 = new SparseArray();
        int size2 = aVar2.bj.size();
        int i6 = 0;
        while (i6 < size2) {
            a.C0542a aVar3 = aVar2.bj.get(i6);
            if (aVar3.bg == a.S) {
                i2 = i6;
                i3 = size2;
                j a3 = b.a(aVar3, aVar2.d(a.R), j2, drmInitData, (this.f32215e & 16) != 0, false);
                if (a3 != null) {
                    sparseArray2.put(a3.f32257a, a3);
                }
            } else {
                i2 = i6;
                i3 = size2;
            }
            i6 = i2 + 1;
            size2 = i3;
        }
        int size3 = sparseArray2.size();
        if (this.f32219i.size() == 0) {
            while (i4 < size3) {
                j jVar = (j) sparseArray2.valueAt(i4);
                b bVar2 = new b(this.K.a(i4, jVar.f32258b));
                bVar2.a(jVar, a((SparseArray<c>) sparseArray, jVar.f32257a));
                this.f32219i.put(jVar.f32257a, bVar2);
                this.C = Math.max(this.C, jVar.f32261e);
                i4++;
            }
            b();
            this.K.a();
            return;
        }
        if (this.f32219i.size() != size3) {
            z2 = false;
        }
        com.google.android.exoplayer2.g.a.b(z2);
        while (i4 < size3) {
            j jVar2 = (j) sparseArray2.valueAt(i4);
            this.f32219i.get(jVar2.f32257a).a(jVar2, a((SparseArray<c>) sparseArray, jVar2.f32257a));
            i4++;
        }
    }

    private static c a(SparseArray<c> sparseArray, int i2) {
        if (sparseArray.size() == 1) {
            return sparseArray.valueAt(0);
        }
        return (c) com.google.android.exoplayer2.g.a.a(sparseArray.get(i2));
    }

    private void c(a.C0542a aVar) throws v {
        DrmInitData drmInitData;
        a(aVar, this.f32219i, this.f32215e, this.m);
        if (this.f32218h != null) {
            drmInitData = null;
        } else {
            drmInitData = a(aVar.bi);
        }
        if (drmInitData != null) {
            int size = this.f32219i.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f32219i.valueAt(i2).a(drmInitData);
            }
        }
        if (this.B != -9223372036854775807L) {
            int size2 = this.f32219i.size();
            for (int i3 = 0; i3 < size2; i3++) {
                this.f32219i.valueAt(i3).a(this.B);
            }
            this.B = -9223372036854775807L;
        }
    }

    private void b() {
        int i2;
        if (this.L == null) {
            this.L = new q[2];
            q qVar = this.t;
            if (qVar != null) {
                this.L[0] = qVar;
                i2 = 1;
            } else {
                i2 = 0;
            }
            if ((this.f32215e & 4) != 0) {
                this.L[i2] = this.K.a(this.f32219i.size(), 4);
                i2++;
            }
            this.L = (q[]) Arrays.copyOf(this.L, i2);
            for (q a2 : this.L) {
                a2.a(f32214d);
            }
        }
        if (this.M == null) {
            this.M = new q[this.f32217g.size()];
            for (int i3 = 0; i3 < this.M.length; i3++) {
                q a3 = this.K.a(this.f32219i.size() + 1 + i3, 3);
                a3.a(this.f32217g.get(i3));
                this.M[i3] = a3;
            }
        }
    }

    private static Pair<Integer, c> a(r rVar) {
        rVar.c(12);
        return Pair.create(Integer.valueOf(rVar.i()), new c(rVar.n() - 1, rVar.n(), rVar.n(), rVar.i()));
    }

    private static long b(r rVar) {
        rVar.c(8);
        return a.a(rVar.i()) == 0 ? rVar.g() : rVar.p();
    }

    private static void a(a.C0542a aVar, SparseArray<b> sparseArray, int i2, byte[] bArr) throws v {
        int size = aVar.bj.size();
        for (int i3 = 0; i3 < size; i3++) {
            a.C0542a aVar2 = aVar.bj.get(i3);
            if (aVar2.bg == a.Y) {
                b(aVar2, sparseArray, i2, bArr);
            }
        }
    }

    private static void b(a.C0542a aVar, SparseArray<b> sparseArray, int i2, byte[] bArr) throws v {
        b a2 = a(aVar.d(a.M).bh, sparseArray);
        if (a2 != null) {
            l lVar = a2.f32223b;
            long j2 = lVar.s;
            a2.a();
            if (aVar.d(a.L) != null && (i2 & 2) == 0) {
                j2 = c(aVar.d(a.L).bh);
            }
            a(aVar, a2, j2, i2);
            k a3 = a2.f32224c.a(lVar.f32271a.f32201a);
            a.b d2 = aVar.d(a.ap);
            if (d2 != null) {
                a(a3, d2.bh, lVar);
            }
            a.b d3 = aVar.d(a.aq);
            if (d3 != null) {
                a(d3.bh, lVar);
            }
            a.b d4 = aVar.d(a.au);
            if (d4 != null) {
                a(d4.bh, 0, lVar);
            }
            a.b d5 = aVar.d(a.ar);
            a.b d6 = aVar.d(a.as);
            if (!(d5 == null || d6 == null)) {
                a(d5.bh, d6.bh, a3 != null ? a3.f32267b : null, lVar);
            }
            int size = aVar.bi.size();
            for (int i3 = 0; i3 < size; i3++) {
                a.b bVar = aVar.bi.get(i3);
                if (bVar.bg == a.at) {
                    a(bVar.bh, lVar, bArr);
                }
            }
        }
    }

    private static void a(a.C0542a aVar, b bVar, long j2, int i2) {
        List<a.b> list = aVar.bi;
        int size = list.size();
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            a.b bVar2 = list.get(i5);
            if (bVar2.bg == a.O) {
                r rVar = bVar2.bh;
                rVar.c(12);
                int n2 = rVar.n();
                if (n2 > 0) {
                    i4 += n2;
                    i3++;
                }
            }
        }
        bVar.f32228g = 0;
        bVar.f32227f = 0;
        bVar.f32226e = 0;
        bVar.f32223b.a(i3, i4);
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < size; i8++) {
            a.b bVar3 = list.get(i8);
            if (bVar3.bg == a.O) {
                i7 = a(bVar, i6, j2, i2, bVar3.bh, i7);
                i6++;
            }
        }
    }

    private static void a(k kVar, r rVar, l lVar) throws v {
        int i2;
        int i3 = kVar.f32269d;
        rVar.c(8);
        boolean z2 = true;
        if ((a.b(rVar.i()) & 1) == 1) {
            rVar.d(8);
        }
        int c2 = rVar.c();
        int n2 = rVar.n();
        if (n2 == lVar.f32276f) {
            if (c2 == 0) {
                boolean[] zArr = lVar.n;
                i2 = 0;
                for (int i4 = 0; i4 < n2; i4++) {
                    int c3 = rVar.c();
                    i2 += c3;
                    zArr[i4] = c3 > i3;
                }
            } else {
                if (c2 <= i3) {
                    z2 = false;
                }
                i2 = (c2 * n2) + 0;
                Arrays.fill(lVar.n, 0, n2, z2);
            }
            lVar.a(i2);
            return;
        }
        throw new v("Length mismatch: " + n2 + ", " + lVar.f32276f);
    }

    private static void a(r rVar, l lVar) throws v {
        long j2;
        rVar.c(8);
        int i2 = rVar.i();
        if ((a.b(i2) & 1) == 1) {
            rVar.d(8);
        }
        int n2 = rVar.n();
        if (n2 == 1) {
            int a2 = a.a(i2);
            long j3 = lVar.f32274d;
            if (a2 == 0) {
                j2 = rVar.g();
            } else {
                j2 = rVar.p();
            }
            lVar.f32274d = j3 + j2;
            return;
        }
        throw new v("Unexpected saio entry count: ".concat(String.valueOf(n2)));
    }

    private static b a(r rVar, SparseArray<b> sparseArray) {
        rVar.c(8);
        int b2 = a.b(rVar.i());
        b b3 = b(sparseArray, rVar.i());
        if (b3 == null) {
            return null;
        }
        if ((b2 & 1) != 0) {
            long p2 = rVar.p();
            b3.f32223b.f32273c = p2;
            b3.f32223b.f32274d = p2;
        }
        c cVar = b3.f32225d;
        b3.f32223b.f32271a = new c((b2 & 2) != 0 ? rVar.n() - 1 : cVar.f32201a, (b2 & 8) != 0 ? rVar.n() : cVar.f32202b, (b2 & 16) != 0 ? rVar.n() : cVar.f32203c, (b2 & 32) != 0 ? rVar.n() : cVar.f32204d);
        return b3;
    }

    private static b b(SparseArray<b> sparseArray, int i2) {
        if (sparseArray.size() == 1) {
            return sparseArray.valueAt(0);
        }
        return sparseArray.get(i2);
    }

    private static long c(r rVar) {
        rVar.c(8);
        return a.a(rVar.i()) == 1 ? rVar.p() : rVar.g();
    }

    private static int a(b bVar, int i2, long j2, int i3, r rVar, int i4) {
        boolean z2;
        int i5;
        boolean z3;
        int i6;
        boolean z4;
        boolean z5;
        boolean z6;
        b bVar2 = bVar;
        rVar.c(8);
        int b2 = a.b(rVar.i());
        j jVar = bVar2.f32224c;
        l lVar = bVar2.f32223b;
        c cVar = lVar.f32271a;
        lVar.f32278h[i2] = rVar.n();
        lVar.f32277g[i2] = lVar.f32273c;
        if ((b2 & 1) != 0) {
            long[] jArr = lVar.f32277g;
            jArr[i2] = jArr[i2] + ((long) rVar.i());
        }
        boolean z7 = (b2 & 4) != 0;
        int i7 = cVar.f32204d;
        if (z7) {
            i7 = rVar.n();
        }
        boolean z8 = (b2 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0;
        boolean z9 = (b2 & 512) != 0;
        boolean z10 = (b2 & TarConstants.EOF_BLOCK) != 0;
        boolean z11 = (b2 & EmiUtil.EMI_PLAN_REQUEST_CODE) != 0;
        long j3 = 0;
        if (jVar.f32264h != null && jVar.f32264h.length == 1 && jVar.f32264h[0] == 0) {
            j3 = ae.b(jVar.f32265i[0], 1000, jVar.f32259c);
        }
        int[] iArr = lVar.f32279i;
        int[] iArr2 = lVar.j;
        long[] jArr2 = lVar.k;
        boolean[] zArr = lVar.l;
        int i8 = i7;
        boolean z12 = jVar.f32258b == 2 && (i3 & 1) != 0;
        int i9 = i4 + lVar.f32278h[i2];
        long j4 = j3;
        boolean[] zArr2 = zArr;
        long j5 = jVar.f32259c;
        boolean[] zArr3 = zArr2;
        long[] jArr3 = jArr2;
        long j6 = i2 > 0 ? lVar.s : j2;
        int i10 = i4;
        while (i10 < i9) {
            int n2 = z8 ? rVar.n() : cVar.f32202b;
            if (z9) {
                z2 = z8;
                i5 = rVar.n();
            } else {
                z2 = z8;
                i5 = cVar.f32203c;
            }
            if (i10 == 0 && z7) {
                z3 = z7;
                i6 = i8;
            } else if (z10) {
                z3 = z7;
                i6 = rVar.i();
            } else {
                z3 = z7;
                i6 = cVar.f32204d;
            }
            if (z11) {
                z6 = z11;
                z5 = z9;
                z4 = z10;
                iArr2[i10] = (int) ((((long) rVar.i()) * 1000) / j5);
            } else {
                z6 = z11;
                z5 = z9;
                z4 = z10;
                iArr2[i10] = 0;
            }
            jArr3[i10] = ae.b(j6, 1000, j5) - j4;
            iArr[i10] = i5;
            zArr3[i10] = ((i6 >> 16) & 1) == 0 && (!z12 || i10 == 0);
            i10++;
            j6 += (long) n2;
            z8 = z2;
            z7 = z3;
            z11 = z6;
            z9 = z5;
            z10 = z4;
            i9 = i9;
        }
        int i11 = i9;
        lVar.s = j6;
        return i11;
    }

    private static void a(r rVar, l lVar, byte[] bArr) throws v {
        rVar.c(8);
        rVar.a(bArr, 0, 16);
        if (Arrays.equals(bArr, f32213c)) {
            a(rVar, 16, lVar);
        }
    }

    private static void a(r rVar, int i2, l lVar) throws v {
        rVar.c(i2 + 8);
        int b2 = a.b(rVar.i());
        if ((b2 & 1) == 0) {
            boolean z2 = (b2 & 2) != 0;
            int n2 = rVar.n();
            if (n2 == lVar.f32276f) {
                Arrays.fill(lVar.n, 0, n2, z2);
                lVar.a(rVar.b());
                lVar.a(rVar);
                return;
            }
            throw new v("Length mismatch: " + n2 + ", " + lVar.f32276f);
        }
        throw new v("Overriding TrackEncryptionBox parameters is unsupported.");
    }

    private static void a(r rVar, r rVar2, String str, l lVar) throws v {
        byte[] bArr;
        rVar.c(8);
        int i2 = rVar.i();
        if (rVar.i() == f32212b) {
            if (a.a(i2) == 1) {
                rVar.d(4);
            }
            if (rVar.i() == 1) {
                rVar2.c(8);
                int i3 = rVar2.i();
                if (rVar2.i() == f32212b) {
                    int a2 = a.a(i3);
                    if (a2 == 1) {
                        if (rVar2.g() == 0) {
                            throw new v("Variable length description in sgpd found (unsupported)");
                        }
                    } else if (a2 >= 2) {
                        rVar2.d(4);
                    }
                    if (rVar2.g() == 1) {
                        rVar2.d(1);
                        int c2 = rVar2.c();
                        int i4 = (c2 & 240) >> 4;
                        int i5 = c2 & 15;
                        if (rVar2.c() == 1) {
                            int c3 = rVar2.c();
                            byte[] bArr2 = new byte[16];
                            rVar2.a(bArr2, 0, 16);
                            if (c3 == 0) {
                                int c4 = rVar2.c();
                                byte[] bArr3 = new byte[c4];
                                rVar2.a(bArr3, 0, c4);
                                bArr = bArr3;
                            } else {
                                bArr = null;
                            }
                            lVar.m = true;
                            lVar.o = new k(true, str, c3, bArr2, i4, i5, bArr);
                            return;
                        }
                        return;
                    }
                    throw new v("Entry count in sgpd != 1 (unsupported).");
                }
                return;
            }
            throw new v("Entry count in sbgp != 1 (unsupported).");
        }
    }

    private static DrmInitData a(List<a.b> list) {
        int size = list.size();
        ArrayList arrayList = null;
        for (int i2 = 0; i2 < size; i2++) {
            a.b bVar = list.get(i2);
            if (bVar.bg == a.ah) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                byte[] bArr = bVar.bh.f32566a;
                UUID a2 = h.a(bArr);
                if (a2 == null) {
                    l.c();
                } else {
                    arrayList.add(new DrmInitData.SchemeData(a2, "video/mp4", bArr));
                }
            }
        }
        if (arrayList == null) {
            return null;
        }
        return new DrmInitData((List<DrmInitData.SchemeData>) arrayList);
    }

    static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final long f32220a;

        /* renamed from: b  reason: collision with root package name */
        public final int f32221b;

        public a(long j, int i2) {
            this.f32220a = j;
            this.f32221b = i2;
        }
    }

    static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final q f32222a;

        /* renamed from: b  reason: collision with root package name */
        public final l f32223b = new l();

        /* renamed from: c  reason: collision with root package name */
        public j f32224c;

        /* renamed from: d  reason: collision with root package name */
        public c f32225d;

        /* renamed from: e  reason: collision with root package name */
        public int f32226e;

        /* renamed from: f  reason: collision with root package name */
        public int f32227f;

        /* renamed from: g  reason: collision with root package name */
        public int f32228g;

        /* renamed from: h  reason: collision with root package name */
        public int f32229h;

        /* renamed from: i  reason: collision with root package name */
        final r f32230i = new r(1);
        final r j = new r();

        public b(q qVar) {
            this.f32222a = qVar;
        }

        public final void a(j jVar, c cVar) {
            this.f32224c = (j) com.google.android.exoplayer2.g.a.a(jVar);
            this.f32225d = (c) com.google.android.exoplayer2.g.a.a(cVar);
            this.f32222a.a(jVar.f32262f);
            a();
        }

        public final void a(DrmInitData drmInitData) {
            k a2 = this.f32224c.a(this.f32223b.f32271a.f32201a);
            this.f32222a.a(this.f32224c.f32262f.a(drmInitData.a(a2 != null ? a2.f32267b : null)));
        }

        public final void a() {
            this.f32223b.a();
            this.f32226e = 0;
            this.f32228g = 0;
            this.f32227f = 0;
            this.f32229h = 0;
        }

        public final void a(long j2) {
            long a2 = c.a(j2);
            int i2 = this.f32226e;
            while (i2 < this.f32223b.f32276f && this.f32223b.b(i2) < a2) {
                if (this.f32223b.l[i2]) {
                    this.f32229h = i2;
                }
                i2++;
            }
        }

        public final boolean b() {
            this.f32226e++;
            this.f32227f++;
            int i2 = this.f32227f;
            int[] iArr = this.f32223b.f32278h;
            int i3 = this.f32228g;
            if (i2 != iArr[i3]) {
                return true;
            }
            this.f32228g = i3 + 1;
            this.f32227f = 0;
            return false;
        }

        /* access modifiers changed from: package-private */
        public final k c() {
            k kVar;
            int i2 = this.f32223b.f32271a.f32201a;
            if (this.f32223b.o != null) {
                kVar = this.f32223b.o;
            } else {
                kVar = this.f32224c.a(i2);
            }
            if (kVar == null || !kVar.f32266a) {
                return null;
            }
            return kVar;
        }
    }
}
