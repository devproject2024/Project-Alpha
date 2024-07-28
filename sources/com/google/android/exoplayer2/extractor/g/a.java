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

public final class a implements g {

    /* renamed from: a  reason: collision with root package name */
    public static final j f31885a = $$Lambda$a$iR1wkTFVnvzSSOH_yOgf0cNbo.INSTANCE;

    /* renamed from: b  reason: collision with root package name */
    private static final int f31886b = ae.h("ID3");

    /* renamed from: c  reason: collision with root package name */
    private final long f31887c;

    /* renamed from: d  reason: collision with root package name */
    private final b f31888d;

    /* renamed from: e  reason: collision with root package name */
    private final r f31889e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f31890f;

    /* access modifiers changed from: private */
    public static /* synthetic */ g[] a() {
        return new g[]{new a()};
    }

    public a() {
        this((byte) 0);
    }

    private a(byte b2) {
        this.f31887c = 0;
        this.f31888d = new b();
        this.f31889e = new r(2786);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x004c, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0041, code lost:
        r8.a();
        r4 = r4 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x004a, code lost:
        if ((r4 - r3) < 8192) goto L_0x004d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(com.google.android.exoplayer2.extractor.h r8) throws java.io.IOException, java.lang.InterruptedException {
        /*
            r7 = this;
            com.google.android.exoplayer2.g.r r0 = new com.google.android.exoplayer2.g.r
            r1 = 10
            r0.<init>((int) r1)
            r2 = 0
            r3 = 0
        L_0x0009:
            byte[] r4 = r0.f32566a
            r8.c(r4, r2, r1)
            r0.c(r2)
            int r4 = r0.f()
            int r5 = f31886b
            if (r4 != r5) goto L_0x0028
            r4 = 3
            r0.d(r4)
            int r4 = r0.m()
            int r5 = r4 + 10
            int r3 = r3 + r5
            r8.c(r4)
            goto L_0x0009
        L_0x0028:
            r8.a()
            r8.c(r3)
            r4 = r3
        L_0x002f:
            r1 = 0
        L_0x0030:
            byte[] r5 = r0.f32566a
            r6 = 6
            r8.c(r5, r2, r6)
            r0.c(r2)
            int r5 = r0.d()
            r6 = 2935(0xb77, float:4.113E-42)
            if (r5 == r6) goto L_0x0051
            r8.a()
            int r4 = r4 + 1
            int r1 = r4 - r3
            r5 = 8192(0x2000, float:1.14794E-41)
            if (r1 < r5) goto L_0x004d
            return r2
        L_0x004d:
            r8.c(r4)
            goto L_0x002f
        L_0x0051:
            r5 = 1
            int r1 = r1 + r5
            r6 = 4
            if (r1 < r6) goto L_0x0057
            return r5
        L_0x0057:
            byte[] r5 = r0.f32566a
            int r5 = com.google.android.exoplayer2.b.a.a((byte[]) r5)
            r6 = -1
            if (r5 != r6) goto L_0x0061
            return r2
        L_0x0061:
            int r5 = r5 + -6
            r8.c(r5)
            goto L_0x0030
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.g.a.a(com.google.android.exoplayer2.extractor.h):boolean");
    }

    public final void a(i iVar) {
        this.f31888d.a(iVar, new ac.d(0, 1));
        iVar.a();
        iVar.a(new o.b(-9223372036854775807L));
    }

    public final void a(long j, long j2) {
        this.f31890f = false;
        this.f31888d.a();
    }

    public final int a(h hVar, n nVar) throws IOException, InterruptedException {
        int a2 = hVar.a(this.f31889e.f32566a, 0, 2786);
        if (a2 == -1) {
            return -1;
        }
        this.f31889e.c(0);
        this.f31889e.b(a2);
        if (!this.f31890f) {
            this.f31888d.f31929a = this.f31887c;
            this.f31890f = true;
        }
        this.f31888d.a(this.f31889e);
        return 0;
    }
}
