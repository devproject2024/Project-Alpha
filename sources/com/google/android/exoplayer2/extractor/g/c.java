package com.google.android.exoplayer2.extractor.g;

import com.google.android.exoplayer2.extractor.g;
import com.google.android.exoplayer2.extractor.g.ac;
import com.google.android.exoplayer2.extractor.h;
import com.google.android.exoplayer2.extractor.i;
import com.google.android.exoplayer2.extractor.j;
import com.google.android.exoplayer2.extractor.n;
import com.google.android.exoplayer2.extractor.o;
import com.google.android.exoplayer2.g.ae;
import com.google.android.exoplayer2.g.r;
import java.io.IOException;

public final class c implements g {

    /* renamed from: a  reason: collision with root package name */
    public static final j f31938a = $$Lambda$c$7VWasK0H4Iw7AzotptunY1j87zQ.INSTANCE;

    /* renamed from: b  reason: collision with root package name */
    private static final int f31939b = ae.h("ID3");

    /* renamed from: c  reason: collision with root package name */
    private final long f31940c;

    /* renamed from: d  reason: collision with root package name */
    private final d f31941d;

    /* renamed from: e  reason: collision with root package name */
    private final r f31942e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f31943f;

    /* access modifiers changed from: private */
    public static /* synthetic */ g[] a() {
        return new g[]{new c()};
    }

    public c() {
        this((byte) 0);
    }

    private c(byte b2) {
        this.f31940c = 0;
        this.f31941d = new d();
        this.f31942e = new r(16384);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0047, code lost:
        r9.a();
        r4 = r4 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0050, code lost:
        if ((r4 - r3) < 8192) goto L_0x0053;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0052, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(com.google.android.exoplayer2.extractor.h r9) throws java.io.IOException, java.lang.InterruptedException {
        /*
            r8 = this;
            com.google.android.exoplayer2.g.r r0 = new com.google.android.exoplayer2.g.r
            r1 = 10
            r0.<init>((int) r1)
            r2 = 0
            r3 = 0
        L_0x0009:
            byte[] r4 = r0.f32566a
            r9.c(r4, r2, r1)
            r0.c(r2)
            int r4 = r0.f()
            int r5 = f31939b
            if (r4 != r5) goto L_0x0028
            r4 = 3
            r0.d(r4)
            int r4 = r0.m()
            int r5 = r4 + 10
            int r3 = r3 + r5
            r9.c(r4)
            goto L_0x0009
        L_0x0028:
            r9.a()
            r9.c(r3)
            r4 = r3
        L_0x002f:
            r1 = 0
        L_0x0030:
            byte[] r5 = r0.f32566a
            r6 = 7
            r9.c(r5, r2, r6)
            r0.c(r2)
            int r5 = r0.d()
            r6 = 44096(0xac40, float:6.1792E-41)
            if (r5 == r6) goto L_0x0057
            r6 = 44097(0xac41, float:6.1793E-41)
            if (r5 == r6) goto L_0x0057
            r9.a()
            int r4 = r4 + 1
            int r1 = r4 - r3
            r5 = 8192(0x2000, float:1.14794E-41)
            if (r1 < r5) goto L_0x0053
            return r2
        L_0x0053:
            r9.c(r4)
            goto L_0x002f
        L_0x0057:
            r6 = 1
            int r1 = r1 + r6
            r7 = 4
            if (r1 < r7) goto L_0x005d
            return r6
        L_0x005d:
            byte[] r6 = r0.f32566a
            int r5 = com.google.android.exoplayer2.b.b.a((byte[]) r6, (int) r5)
            r6 = -1
            if (r5 != r6) goto L_0x0067
            return r2
        L_0x0067:
            int r5 = r5 + -7
            r9.c(r5)
            goto L_0x0030
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.g.c.a(com.google.android.exoplayer2.extractor.h):boolean");
    }

    public final void a(i iVar) {
        this.f31941d.a(iVar, new ac.d(0, 1));
        iVar.a();
        iVar.a(new o.b(-9223372036854775807L));
    }

    public final void a(long j, long j2) {
        this.f31943f = false;
        this.f31941d.a();
    }

    public final int a(h hVar, n nVar) throws IOException, InterruptedException {
        int a2 = hVar.a(this.f31942e.f32566a, 0, 16384);
        if (a2 == -1) {
            return -1;
        }
        this.f31942e.c(0);
        this.f31942e.b(a2);
        if (!this.f31943f) {
            this.f31941d.f31944a = this.f31940c;
            this.f31943f = true;
        }
        this.f31941d.a(this.f31942e);
        return 0;
    }
}
