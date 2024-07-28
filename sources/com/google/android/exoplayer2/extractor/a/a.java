package com.google.android.exoplayer2.extractor.a;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.c;
import com.google.android.exoplayer2.extractor.g;
import com.google.android.exoplayer2.extractor.h;
import com.google.android.exoplayer2.extractor.i;
import com.google.android.exoplayer2.extractor.j;
import com.google.android.exoplayer2.extractor.n;
import com.google.android.exoplayer2.extractor.o;
import com.google.android.exoplayer2.extractor.q;
import com.google.android.exoplayer2.g.ae;
import com.google.android.exoplayer2.v;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public final class a implements g {

    /* renamed from: a  reason: collision with root package name */
    public static final j f31660a = $$Lambda$a$YH9ypGJahdH7scVmiMiob0O4cI.INSTANCE;

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f31661b = {13, 14, 16, 18, 20, 21, 27, 32, 6, 7, 6, 6, 1, 1, 1, 1};

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f31662c = {18, 24, 33, 37, 41, 47, 51, 59, 61, 6, 1, 1, 1, 1, 1, 1};

    /* renamed from: d  reason: collision with root package name */
    private static final byte[] f31663d = ae.c("#!AMR\n");

    /* renamed from: e  reason: collision with root package name */
    private static final byte[] f31664e = ae.c("#!AMR-WB\n");

    /* renamed from: f  reason: collision with root package name */
    private static final int f31665f = f31662c[8];

    /* renamed from: g  reason: collision with root package name */
    private final byte[] f31666g;

    /* renamed from: h  reason: collision with root package name */
    private final int f31667h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f31668i;
    private long j;
    private int k;
    private int l;
    private boolean m;
    private long n;
    private int o;
    private int p;
    private long q;
    private i r;
    private q s;
    private o t;
    private boolean u;

    /* access modifiers changed from: private */
    public static /* synthetic */ g[] a() {
        return new g[]{new a()};
    }

    public a() {
        this(0);
    }

    public a(int i2) {
        this.f31667h = i2;
        this.f31666g = new byte[1];
        this.o = -1;
    }

    public final boolean a(h hVar) throws IOException, InterruptedException {
        return b(hVar);
    }

    public final void a(i iVar) {
        this.r = iVar;
        this.s = iVar.a(0, 1);
        iVar.a();
    }

    public final int a(h hVar, n nVar) throws IOException, InterruptedException {
        int i2;
        if (hVar.c() != 0 || b(hVar)) {
            if (!this.u) {
                this.u = true;
                this.s.a(Format.a((String) null, this.f31668i ? "audio/amr-wb" : "audio/3gpp", -1, f31665f, 1, this.f31668i ? 16000 : 8000, -1, (List<byte[]>) null, (DrmInitData) null, 0, (String) null));
            }
            int c2 = c(hVar);
            long d2 = hVar.d();
            if (!this.m) {
                if ((this.f31667h & 1) == 0 || d2 == -1 || !((i2 = this.o) == -1 || i2 == this.k)) {
                    this.t = new o.b(-9223372036854775807L);
                    this.r.a(this.t);
                    this.m = true;
                } else if (this.p >= 20 || c2 == -1) {
                    int i3 = this.o;
                    this.t = new c(d2, this.n, (int) ((((long) (i3 * 8)) * 1000000) / 20000), i3);
                    this.r.a(this.t);
                    this.m = true;
                }
            }
            return c2;
        }
        throw new v("Could not find AMR header.");
    }

    public final void a(long j2, long j3) {
        this.j = 0;
        this.k = 0;
        this.l = 0;
        if (j2 != 0) {
            o oVar = this.t;
            if (oVar instanceof c) {
                this.q = ((c) oVar).b(j2);
                return;
            }
        }
        this.q = 0;
    }

    private boolean b(h hVar) throws IOException, InterruptedException {
        if (a(hVar, f31663d)) {
            this.f31668i = false;
            hVar.b(f31663d.length);
            return true;
        } else if (!a(hVar, f31664e)) {
            return false;
        } else {
            this.f31668i = true;
            hVar.b(f31664e.length);
            return true;
        }
    }

    private static boolean a(h hVar, byte[] bArr) throws IOException, InterruptedException {
        hVar.a();
        byte[] bArr2 = new byte[bArr.length];
        hVar.c(bArr2, 0, bArr.length);
        return Arrays.equals(bArr2, bArr);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0040, code lost:
        if ((!r11.f31668i && (r0 < 12 || r0 > 14)) != false) goto L_0x0042;
     */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0047 A[Catch:{ EOFException -> 0x00a9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006c A[Catch:{ EOFException -> 0x00a9 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int c(com.google.android.exoplayer2.extractor.h r12) throws java.io.IOException, java.lang.InterruptedException {
        /*
            r11 = this;
            int r0 = r11.l
            r1 = -1
            r2 = 1
            r3 = 0
            if (r0 != 0) goto L_0x00aa
            r12.a()     // Catch:{ EOFException -> 0x00a9 }
            byte[] r0 = r11.f31666g     // Catch:{ EOFException -> 0x00a9 }
            r12.c(r0, r3, r2)     // Catch:{ EOFException -> 0x00a9 }
            byte[] r0 = r11.f31666g     // Catch:{ EOFException -> 0x00a9 }
            byte r0 = r0[r3]     // Catch:{ EOFException -> 0x00a9 }
            r4 = r0 & 131(0x83, float:1.84E-43)
            if (r4 > 0) goto L_0x0099
            int r0 = r0 >> 3
            r4 = 15
            r0 = r0 & r4
            if (r0 < 0) goto L_0x0044
            if (r0 > r4) goto L_0x0044
            boolean r4 = r11.f31668i     // Catch:{ EOFException -> 0x00a9 }
            if (r4 == 0) goto L_0x002e
            r4 = 10
            if (r0 < r4) goto L_0x002c
            r4 = 13
            if (r0 <= r4) goto L_0x002e
        L_0x002c:
            r4 = 1
            goto L_0x002f
        L_0x002e:
            r4 = 0
        L_0x002f:
            if (r4 != 0) goto L_0x0042
            boolean r4 = r11.f31668i     // Catch:{ EOFException -> 0x00a9 }
            if (r4 != 0) goto L_0x003f
            r4 = 12
            if (r0 < r4) goto L_0x003d
            r4 = 14
            if (r0 <= r4) goto L_0x003f
        L_0x003d:
            r4 = 1
            goto L_0x0040
        L_0x003f:
            r4 = 0
        L_0x0040:
            if (r4 == 0) goto L_0x0044
        L_0x0042:
            r4 = 1
            goto L_0x0045
        L_0x0044:
            r4 = 0
        L_0x0045:
            if (r4 != 0) goto L_0x006c
            com.google.android.exoplayer2.v r12 = new com.google.android.exoplayer2.v     // Catch:{ EOFException -> 0x00a9 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ EOFException -> 0x00a9 }
            java.lang.String r3 = "Illegal AMR "
            r2.<init>(r3)     // Catch:{ EOFException -> 0x00a9 }
            boolean r3 = r11.f31668i     // Catch:{ EOFException -> 0x00a9 }
            if (r3 == 0) goto L_0x0057
            java.lang.String r3 = "WB"
            goto L_0x0059
        L_0x0057:
            java.lang.String r3 = "NB"
        L_0x0059:
            r2.append(r3)     // Catch:{ EOFException -> 0x00a9 }
            java.lang.String r3 = " frame type "
            r2.append(r3)     // Catch:{ EOFException -> 0x00a9 }
            r2.append(r0)     // Catch:{ EOFException -> 0x00a9 }
            java.lang.String r0 = r2.toString()     // Catch:{ EOFException -> 0x00a9 }
            r12.<init>((java.lang.String) r0)     // Catch:{ EOFException -> 0x00a9 }
            throw r12     // Catch:{ EOFException -> 0x00a9 }
        L_0x006c:
            boolean r4 = r11.f31668i     // Catch:{ EOFException -> 0x00a9 }
            if (r4 == 0) goto L_0x0075
            int[] r4 = f31662c     // Catch:{ EOFException -> 0x00a9 }
            r0 = r4[r0]     // Catch:{ EOFException -> 0x00a9 }
            goto L_0x0079
        L_0x0075:
            int[] r4 = f31661b     // Catch:{ EOFException -> 0x00a9 }
            r0 = r4[r0]     // Catch:{ EOFException -> 0x00a9 }
        L_0x0079:
            r11.k = r0     // Catch:{ EOFException -> 0x00a9 }
            int r0 = r11.k
            r11.l = r0
            int r0 = r11.o
            if (r0 != r1) goto L_0x008d
            long r4 = r12.c()
            r11.n = r4
            int r0 = r11.k
            r11.o = r0
        L_0x008d:
            int r0 = r11.o
            int r4 = r11.k
            if (r0 != r4) goto L_0x00aa
            int r0 = r11.p
            int r0 = r0 + r2
            r11.p = r0
            goto L_0x00aa
        L_0x0099:
            com.google.android.exoplayer2.v r12 = new com.google.android.exoplayer2.v     // Catch:{ EOFException -> 0x00a9 }
            java.lang.String r2 = "Invalid padding bits for frame header "
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ EOFException -> 0x00a9 }
            java.lang.String r0 = r2.concat(r0)     // Catch:{ EOFException -> 0x00a9 }
            r12.<init>((java.lang.String) r0)     // Catch:{ EOFException -> 0x00a9 }
            throw r12     // Catch:{ EOFException -> 0x00a9 }
        L_0x00a9:
            return r1
        L_0x00aa:
            com.google.android.exoplayer2.extractor.q r0 = r11.s
            int r4 = r11.l
            int r12 = r0.a(r12, r4, r2)
            if (r12 != r1) goto L_0x00b5
            return r1
        L_0x00b5:
            int r0 = r11.l
            int r0 = r0 - r12
            r11.l = r0
            int r12 = r11.l
            if (r12 <= 0) goto L_0x00bf
            return r3
        L_0x00bf:
            com.google.android.exoplayer2.extractor.q r4 = r11.s
            long r0 = r11.q
            long r5 = r11.j
            long r5 = r5 + r0
            r7 = 1
            int r8 = r11.k
            r9 = 0
            r10 = 0
            r4.a(r5, r7, r8, r9, r10)
            long r0 = r11.j
            r4 = 20000(0x4e20, double:9.8813E-320)
            long r0 = r0 + r4
            r11.j = r0
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.a.a.c(com.google.android.exoplayer2.extractor.h):int");
    }
}
