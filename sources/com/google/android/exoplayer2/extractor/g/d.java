package com.google.android.exoplayer2.extractor.g;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.b.b;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.g.ac;
import com.google.android.exoplayer2.extractor.i;
import com.google.android.exoplayer2.extractor.q;
import com.google.android.exoplayer2.g.q;
import com.google.android.exoplayer2.g.r;
import java.util.List;

public final class d implements j {

    /* renamed from: a  reason: collision with root package name */
    long f31944a;

    /* renamed from: b  reason: collision with root package name */
    private final q f31945b;

    /* renamed from: c  reason: collision with root package name */
    private final r f31946c;

    /* renamed from: d  reason: collision with root package name */
    private final String f31947d;

    /* renamed from: e  reason: collision with root package name */
    private String f31948e;

    /* renamed from: f  reason: collision with root package name */
    private com.google.android.exoplayer2.extractor.q f31949f;

    /* renamed from: g  reason: collision with root package name */
    private int f31950g;

    /* renamed from: h  reason: collision with root package name */
    private int f31951h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f31952i;
    private boolean j;
    private long k;
    private Format l;
    private int m;

    public final void b() {
    }

    public d() {
        this((String) null);
    }

    public d(String str) {
        this.f31945b = new q(new byte[16]);
        this.f31946c = new r(this.f31945b.f32562a);
        this.f31950g = 0;
        this.f31951h = 0;
        this.f31952i = false;
        this.j = false;
        this.f31947d = str;
    }

    public final void a() {
        this.f31950g = 0;
        this.f31951h = 0;
        this.f31952i = false;
        this.j = false;
    }

    public final void a(i iVar, ac.d dVar) {
        dVar.a();
        this.f31948e = dVar.c();
        this.f31949f = iVar.a(dVar.b(), 1);
    }

    public final void a(long j2, int i2) {
        this.f31944a = j2;
    }

    public final void a(r rVar) {
        while (rVar.b() > 0) {
            int i2 = this.f31950g;
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 == 2) {
                        int min = Math.min(rVar.b(), this.m - this.f31951h);
                        this.f31949f.a(rVar, min);
                        this.f31951h += min;
                        int i3 = this.f31951h;
                        int i4 = this.m;
                        if (i3 == i4) {
                            this.f31949f.a(this.f31944a, 1, i4, 0, (q.a) null);
                            this.f31944a += this.k;
                            this.f31950g = 0;
                        }
                    }
                } else if (a(rVar, this.f31946c.f32566a)) {
                    c();
                    this.f31946c.c(0);
                    this.f31949f.a(this.f31946c, 16);
                    this.f31950g = 2;
                }
            } else if (b(rVar)) {
                this.f31950g = 1;
                this.f31946c.f32566a[0] = -84;
                this.f31946c.f32566a[1] = (byte) (this.j ? 65 : 64);
                this.f31951h = 2;
            }
        }
    }

    private boolean a(r rVar, byte[] bArr) {
        int min = Math.min(rVar.b(), 16 - this.f31951h);
        rVar.a(bArr, this.f31951h, min);
        this.f31951h += min;
        return this.f31951h == 16;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x002d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean b(com.google.android.exoplayer2.g.r r6) {
        /*
            r5 = this;
        L_0x0000:
            int r0 = r6.b()
            r1 = 0
            if (r0 <= 0) goto L_0x0031
            boolean r0 = r5.f31952i
            r2 = 172(0xac, float:2.41E-43)
            r3 = 1
            if (r0 != 0) goto L_0x0018
            int r0 = r6.c()
            if (r0 != r2) goto L_0x0015
            r1 = 1
        L_0x0015:
            r5.f31952i = r1
            goto L_0x0000
        L_0x0018:
            int r0 = r6.c()
            if (r0 != r2) goto L_0x0020
            r2 = 1
            goto L_0x0021
        L_0x0020:
            r2 = 0
        L_0x0021:
            r5.f31952i = r2
            r2 = 64
            r4 = 65
            if (r0 == r2) goto L_0x002b
            if (r0 != r4) goto L_0x0000
        L_0x002b:
            if (r0 != r4) goto L_0x002e
            r1 = 1
        L_0x002e:
            r5.j = r1
            return r3
        L_0x0031:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.g.d.b(com.google.android.exoplayer2.g.r):boolean");
    }

    private void c() {
        this.f31945b.a(0);
        b.a a2 = b.a(this.f31945b);
        if (this.l == null || a2.f31162c != this.l.v || a2.f31161b != this.l.w || !"audio/ac4".equals(this.l.f31069i)) {
            this.l = Format.a(this.f31948e, "audio/ac4", -1, -1, a2.f31162c, a2.f31161b, (List<byte[]>) null, (DrmInitData) null, this.f31947d);
            this.f31949f.a(this.l);
        }
        this.m = a2.f31163d;
        this.k = (((long) a2.f31164e) * 1000000) / ((long) this.l.w);
    }
}
