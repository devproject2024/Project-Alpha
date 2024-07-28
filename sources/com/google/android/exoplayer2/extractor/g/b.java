package com.google.android.exoplayer2.extractor.g;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.b.a;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.g.ac;
import com.google.android.exoplayer2.extractor.i;
import com.google.android.exoplayer2.extractor.q;
import com.google.android.exoplayer2.g.q;
import com.google.android.exoplayer2.g.r;
import java.util.List;

public final class b implements j {

    /* renamed from: a  reason: collision with root package name */
    long f31929a;

    /* renamed from: b  reason: collision with root package name */
    private final q f31930b;

    /* renamed from: c  reason: collision with root package name */
    private final r f31931c;

    /* renamed from: d  reason: collision with root package name */
    private final String f31932d;

    /* renamed from: e  reason: collision with root package name */
    private String f31933e;

    /* renamed from: f  reason: collision with root package name */
    private com.google.android.exoplayer2.extractor.q f31934f;

    /* renamed from: g  reason: collision with root package name */
    private int f31935g;

    /* renamed from: h  reason: collision with root package name */
    private int f31936h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f31937i;
    private long j;
    private Format k;
    private int l;

    public final void b() {
    }

    public b() {
        this((String) null);
    }

    public b(String str) {
        this.f31930b = new q(new byte[128]);
        this.f31931c = new r(this.f31930b.f32562a);
        this.f31935g = 0;
        this.f31932d = str;
    }

    public final void a() {
        this.f31935g = 0;
        this.f31936h = 0;
        this.f31937i = false;
    }

    public final void a(i iVar, ac.d dVar) {
        dVar.a();
        this.f31933e = dVar.c();
        this.f31934f = iVar.a(dVar.b(), 1);
    }

    public final void a(long j2, int i2) {
        this.f31929a = j2;
    }

    public final void a(r rVar) {
        while (rVar.b() > 0) {
            int i2 = this.f31935g;
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 == 2) {
                        int min = Math.min(rVar.b(), this.l - this.f31936h);
                        this.f31934f.a(rVar, min);
                        this.f31936h += min;
                        int i3 = this.f31936h;
                        int i4 = this.l;
                        if (i3 == i4) {
                            this.f31934f.a(this.f31929a, 1, i4, 0, (q.a) null);
                            this.f31929a += this.j;
                            this.f31935g = 0;
                        }
                    }
                } else if (a(rVar, this.f31931c.f32566a)) {
                    c();
                    this.f31931c.c(0);
                    this.f31934f.a(this.f31931c, 128);
                    this.f31935g = 2;
                }
            } else if (b(rVar)) {
                this.f31935g = 1;
                this.f31931c.f32566a[0] = 11;
                this.f31931c.f32566a[1] = 119;
                this.f31936h = 2;
            }
        }
    }

    private boolean a(r rVar, byte[] bArr) {
        int min = Math.min(rVar.b(), 128 - this.f31936h);
        rVar.a(bArr, this.f31936h, min);
        this.f31936h += min;
        return this.f31936h == 128;
    }

    private boolean b(r rVar) {
        while (true) {
            boolean z = false;
            if (rVar.b() <= 0) {
                return false;
            }
            if (!this.f31937i) {
                if (rVar.c() == 11) {
                    z = true;
                }
                this.f31937i = z;
            } else {
                int c2 = rVar.c();
                if (c2 == 119) {
                    this.f31937i = false;
                    return true;
                }
                if (c2 == 11) {
                    z = true;
                }
                this.f31937i = z;
            }
        }
    }

    private void c() {
        this.f31930b.a(0);
        a.C0530a a2 = a.a(this.f31930b);
        if (!(this.k != null && a2.f31156d == this.k.v && a2.f31155c == this.k.w && a2.f31153a == this.k.f31069i)) {
            this.k = Format.a(this.f31933e, a2.f31153a, -1, -1, a2.f31156d, a2.f31155c, (List<byte[]>) null, (DrmInitData) null, this.f31932d);
            this.f31934f.a(this.k);
        }
        this.l = a2.f31157e;
        this.j = (((long) a2.f31158f) * 1000000) / ((long) this.k.w);
    }
}
