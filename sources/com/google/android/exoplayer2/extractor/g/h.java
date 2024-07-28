package com.google.android.exoplayer2.extractor.g;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.b.p;
import com.google.android.exoplayer2.extractor.g.ac;
import com.google.android.exoplayer2.extractor.i;
import com.google.android.exoplayer2.extractor.q;
import com.google.android.exoplayer2.g.r;
import com.paytmmall.clpartifact.customViews.PriceRangeSeekBar;

public final class h implements j {

    /* renamed from: a  reason: collision with root package name */
    private final r f31973a = new r(new byte[18]);

    /* renamed from: b  reason: collision with root package name */
    private final String f31974b;

    /* renamed from: c  reason: collision with root package name */
    private String f31975c;

    /* renamed from: d  reason: collision with root package name */
    private q f31976d;

    /* renamed from: e  reason: collision with root package name */
    private int f31977e = 0;

    /* renamed from: f  reason: collision with root package name */
    private int f31978f;

    /* renamed from: g  reason: collision with root package name */
    private int f31979g;

    /* renamed from: h  reason: collision with root package name */
    private long f31980h;

    /* renamed from: i  reason: collision with root package name */
    private Format f31981i;
    private int j;
    private long k;

    public final void b() {
    }

    public h(String str) {
        this.f31974b = str;
    }

    public final void a() {
        this.f31977e = 0;
        this.f31978f = 0;
        this.f31979g = 0;
    }

    public final void a(i iVar, ac.d dVar) {
        dVar.a();
        this.f31975c = dVar.c();
        this.f31976d = iVar.a(dVar.b(), 1);
    }

    public final void a(long j2, int i2) {
        this.k = j2;
    }

    public final void a(r rVar) {
        while (rVar.b() > 0) {
            int i2 = this.f31977e;
            boolean z = true;
            boolean z2 = false;
            if (i2 == 0) {
                while (true) {
                    if (rVar.b() <= 0) {
                        break;
                    }
                    this.f31979g <<= 8;
                    this.f31979g |= rVar.c();
                    if (p.a(this.f31979g)) {
                        this.f31973a.f32566a[0] = (byte) ((this.f31979g >> 24) & PriceRangeSeekBar.INVALID_POINTER_ID);
                        this.f31973a.f32566a[1] = (byte) ((this.f31979g >> 16) & PriceRangeSeekBar.INVALID_POINTER_ID);
                        this.f31973a.f32566a[2] = (byte) ((this.f31979g >> 8) & PriceRangeSeekBar.INVALID_POINTER_ID);
                        this.f31973a.f32566a[3] = (byte) (this.f31979g & PriceRangeSeekBar.INVALID_POINTER_ID);
                        this.f31978f = 4;
                        this.f31979g = 0;
                        z2 = true;
                        break;
                    }
                }
                if (z2) {
                    this.f31977e = 1;
                }
            } else if (i2 == 1) {
                byte[] bArr = this.f31973a.f32566a;
                int min = Math.min(rVar.b(), 18 - this.f31978f);
                rVar.a(bArr, this.f31978f, min);
                this.f31978f += min;
                if (this.f31978f != 18) {
                    z = false;
                }
                if (z) {
                    byte[] bArr2 = this.f31973a.f32566a;
                    if (this.f31981i == null) {
                        this.f31981i = p.a(bArr2, this.f31975c, this.f31974b);
                        this.f31976d.a(this.f31981i);
                    }
                    this.j = p.b(bArr2);
                    this.f31980h = (long) ((int) ((((long) p.a(bArr2)) * 1000000) / ((long) this.f31981i.w)));
                    this.f31973a.c(0);
                    this.f31976d.a(this.f31973a, 18);
                    this.f31977e = 2;
                }
            } else if (i2 == 2) {
                int min2 = Math.min(rVar.b(), this.j - this.f31978f);
                this.f31976d.a(rVar, min2);
                this.f31978f += min2;
                int i3 = this.f31978f;
                int i4 = this.j;
                if (i3 == i4) {
                    this.f31976d.a(this.k, 1, i4, 0, (q.a) null);
                    this.k += this.f31980h;
                    this.f31977e = 0;
                }
            } else {
                throw new IllegalStateException();
            }
        }
    }
}
