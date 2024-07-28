package com.google.android.exoplayer2.extractor.f;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.g;
import com.google.android.exoplayer2.extractor.h;
import com.google.android.exoplayer2.extractor.i;
import com.google.android.exoplayer2.extractor.o;
import com.google.android.exoplayer2.extractor.q;
import com.google.android.exoplayer2.g.ae;
import com.google.android.exoplayer2.g.r;
import java.io.IOException;

public final class a implements g {

    /* renamed from: a  reason: collision with root package name */
    private static final int f31876a = ae.h("RCC\u0001");

    /* renamed from: b  reason: collision with root package name */
    private final Format f31877b;

    /* renamed from: c  reason: collision with root package name */
    private final r f31878c = new r(9);

    /* renamed from: d  reason: collision with root package name */
    private q f31879d;

    /* renamed from: e  reason: collision with root package name */
    private int f31880e = 0;

    /* renamed from: f  reason: collision with root package name */
    private int f31881f;

    /* renamed from: g  reason: collision with root package name */
    private long f31882g;

    /* renamed from: h  reason: collision with root package name */
    private int f31883h;

    /* renamed from: i  reason: collision with root package name */
    private int f31884i;

    public a(Format format) {
        this.f31877b = format;
    }

    public final void a(i iVar) {
        iVar.a(new o.b(-9223372036854775807L));
        this.f31879d = iVar.a(0, 3);
        iVar.a();
        this.f31879d.a(this.f31877b);
    }

    public final boolean a(h hVar) throws IOException, InterruptedException {
        this.f31878c.a();
        hVar.c(this.f31878c.f32566a, 0, 8);
        if (this.f31878c.i() == f31876a) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0064 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int a(com.google.android.exoplayer2.extractor.h r9, com.google.android.exoplayer2.extractor.n r10) throws java.io.IOException, java.lang.InterruptedException {
        /*
            r8 = this;
        L_0x0000:
            int r10 = r8.f31880e
            r0 = -1
            r1 = 0
            r2 = 1
            if (r10 == 0) goto L_0x007d
            r3 = 2
            if (r10 == r2) goto L_0x0018
            if (r10 != r3) goto L_0x0012
            r8.b(r9)
            r8.f31880e = r2
            return r1
        L_0x0012:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            r9.<init>()
            throw r9
        L_0x0018:
            com.google.android.exoplayer2.g.r r10 = r8.f31878c
            r10.a()
            int r10 = r8.f31881f
            if (r10 != 0) goto L_0x003e
            com.google.android.exoplayer2.g.r r10 = r8.f31878c
            byte[] r10 = r10.f32566a
            r4 = 5
            boolean r10 = r9.a(r10, r1, r4, r2)
            if (r10 != 0) goto L_0x002e
        L_0x002c:
            r2 = 0
            goto L_0x005f
        L_0x002e:
            com.google.android.exoplayer2.g.r r10 = r8.f31878c
            long r4 = r10.g()
            r6 = 1000(0x3e8, double:4.94E-321)
            long r4 = r4 * r6
            r6 = 45
            long r4 = r4 / r6
            r8.f31882g = r4
            goto L_0x0055
        L_0x003e:
            if (r10 != r2) goto L_0x0067
            com.google.android.exoplayer2.g.r r10 = r8.f31878c
            byte[] r10 = r10.f32566a
            r4 = 9
            boolean r10 = r9.a(r10, r1, r4, r2)
            if (r10 != 0) goto L_0x004d
            goto L_0x002c
        L_0x004d:
            com.google.android.exoplayer2.g.r r10 = r8.f31878c
            long r4 = r10.k()
            r8.f31882g = r4
        L_0x0055:
            com.google.android.exoplayer2.g.r r10 = r8.f31878c
            int r10 = r10.c()
            r8.f31883h = r10
            r8.f31884i = r1
        L_0x005f:
            if (r2 == 0) goto L_0x0064
            r8.f31880e = r3
            goto L_0x0000
        L_0x0064:
            r8.f31880e = r1
            return r0
        L_0x0067:
            com.google.android.exoplayer2.v r9 = new com.google.android.exoplayer2.v
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            java.lang.String r0 = "Unsupported version number: "
            r10.<init>(r0)
            int r0 = r8.f31881f
            r10.append(r0)
            java.lang.String r10 = r10.toString()
            r9.<init>((java.lang.String) r10)
            throw r9
        L_0x007d:
            com.google.android.exoplayer2.g.r r10 = r8.f31878c
            r10.a()
            com.google.android.exoplayer2.g.r r10 = r8.f31878c
            byte[] r10 = r10.f32566a
            r3 = 8
            boolean r10 = r9.a(r10, r1, r3, r2)
            if (r10 == 0) goto L_0x00aa
            com.google.android.exoplayer2.g.r r10 = r8.f31878c
            int r10 = r10.i()
            int r1 = f31876a
            if (r10 != r1) goto L_0x00a2
            com.google.android.exoplayer2.g.r r10 = r8.f31878c
            int r10 = r10.c()
            r8.f31881f = r10
            r1 = 1
            goto L_0x00aa
        L_0x00a2:
            java.io.IOException r9 = new java.io.IOException
            java.lang.String r10 = "Input not RawCC"
            r9.<init>(r10)
            throw r9
        L_0x00aa:
            if (r1 == 0) goto L_0x00b0
            r8.f31880e = r2
            goto L_0x0000
        L_0x00b0:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.f.a.a(com.google.android.exoplayer2.extractor.h, com.google.android.exoplayer2.extractor.n):int");
    }

    public final void a(long j, long j2) {
        this.f31880e = 0;
    }

    private void b(h hVar) throws IOException, InterruptedException {
        while (this.f31883h > 0) {
            this.f31878c.a();
            hVar.b(this.f31878c.f32566a, 0, 3);
            this.f31879d.a(this.f31878c, 3);
            this.f31884i += 3;
            this.f31883h--;
        }
        int i2 = this.f31884i;
        if (i2 > 0) {
            this.f31879d.a(this.f31882g, 1, i2, 0, (q.a) null);
        }
    }
}
