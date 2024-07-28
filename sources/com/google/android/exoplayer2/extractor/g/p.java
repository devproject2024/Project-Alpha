package com.google.android.exoplayer2.extractor.g;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.g.ac;
import com.google.android.exoplayer2.extractor.i;
import com.google.android.exoplayer2.extractor.m;
import com.google.android.exoplayer2.extractor.q;
import com.google.android.exoplayer2.g.r;
import java.util.List;

public final class p implements j {

    /* renamed from: a  reason: collision with root package name */
    private final r f32062a;

    /* renamed from: b  reason: collision with root package name */
    private final m f32063b;

    /* renamed from: c  reason: collision with root package name */
    private final String f32064c;

    /* renamed from: d  reason: collision with root package name */
    private String f32065d;

    /* renamed from: e  reason: collision with root package name */
    private q f32066e;

    /* renamed from: f  reason: collision with root package name */
    private int f32067f;

    /* renamed from: g  reason: collision with root package name */
    private int f32068g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f32069h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f32070i;
    private long j;
    private int k;
    private long l;

    public final void b() {
    }

    public p() {
        this((String) null);
    }

    public p(String str) {
        this.f32067f = 0;
        this.f32062a = new r(4);
        this.f32062a.f32566a[0] = -1;
        this.f32063b = new m();
        this.f32064c = str;
    }

    public final void a() {
        this.f32067f = 0;
        this.f32068g = 0;
        this.f32070i = false;
    }

    public final void a(i iVar, ac.d dVar) {
        dVar.a();
        this.f32065d = dVar.c();
        this.f32066e = iVar.a(dVar.b(), 1);
    }

    public final void a(long j2, int i2) {
        this.l = j2;
    }

    public final void a(r rVar) {
        r rVar2 = rVar;
        while (rVar.b() > 0) {
            int i2 = this.f32067f;
            if (i2 == 0) {
                byte[] bArr = rVar2.f32566a;
                int i3 = rVar2.f32567b;
                int i4 = rVar2.f32568c;
                while (true) {
                    if (i3 >= i4) {
                        rVar2.c(i4);
                        break;
                    }
                    boolean z = (bArr[i3] & 255) == 255;
                    boolean z2 = this.f32070i && (bArr[i3] & 224) == 224;
                    this.f32070i = z;
                    if (z2) {
                        rVar2.c(i3 + 1);
                        this.f32070i = false;
                        this.f32062a.f32566a[1] = bArr[i3];
                        this.f32068g = 2;
                        this.f32067f = 1;
                        break;
                    }
                    i3++;
                }
            } else if (i2 == 1) {
                int min = Math.min(rVar.b(), 4 - this.f32068g);
                rVar2.a(this.f32062a.f32566a, this.f32068g, min);
                this.f32068g += min;
                if (this.f32068g >= 4) {
                    this.f32062a.c(0);
                    if (!m.a(this.f32062a.i(), this.f32063b)) {
                        this.f32068g = 0;
                        this.f32067f = 1;
                    } else {
                        this.k = this.f32063b.f32150c;
                        if (!this.f32069h) {
                            this.j = (((long) this.f32063b.f32154g) * 1000000) / ((long) this.f32063b.f32151d);
                            this.f32066e.a(Format.a(this.f32065d, this.f32063b.f32149b, -1, 4096, this.f32063b.f32152e, this.f32063b.f32151d, (List<byte[]>) null, (DrmInitData) null, this.f32064c));
                            this.f32069h = true;
                        }
                        this.f32062a.c(0);
                        this.f32066e.a(this.f32062a, 4);
                        this.f32067f = 2;
                    }
                }
            } else if (i2 == 2) {
                int min2 = Math.min(rVar.b(), this.k - this.f32068g);
                this.f32066e.a(rVar2, min2);
                this.f32068g += min2;
                int i5 = this.f32068g;
                int i6 = this.k;
                if (i5 >= i6) {
                    this.f32066e.a(this.l, 1, i6, 0, (q.a) null);
                    this.l += this.j;
                    this.f32068g = 0;
                    this.f32067f = 0;
                }
            } else {
                throw new IllegalStateException();
            }
        }
    }
}
