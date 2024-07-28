package com.google.android.exoplayer2.extractor.g;

import com.google.android.exoplayer2.extractor.g.ac;
import com.google.android.exoplayer2.extractor.i;
import com.google.android.exoplayer2.g.ab;
import com.google.android.exoplayer2.g.ae;
import com.google.android.exoplayer2.g.r;

public final class w implements ac {

    /* renamed from: a  reason: collision with root package name */
    private final v f32112a;

    /* renamed from: b  reason: collision with root package name */
    private final r f32113b = new r(32);

    /* renamed from: c  reason: collision with root package name */
    private int f32114c;

    /* renamed from: d  reason: collision with root package name */
    private int f32115d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f32116e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f32117f;

    public w(v vVar) {
        this.f32112a = vVar;
    }

    public final void a(ab abVar, i iVar, ac.d dVar) {
        this.f32112a.a(abVar, iVar, dVar);
        this.f32117f = true;
    }

    public final void a() {
        this.f32117f = true;
    }

    public final void a(r rVar, int i2) {
        boolean z = (i2 & 1) != 0;
        int c2 = z ? rVar.c() + rVar.f32567b : 0;
        if (this.f32117f) {
            if (z) {
                this.f32117f = false;
                rVar.c(c2);
                this.f32115d = 0;
            } else {
                return;
            }
        }
        while (rVar.b() > 0) {
            int i3 = this.f32115d;
            if (i3 < 3) {
                if (i3 == 0) {
                    int c3 = rVar.c();
                    rVar.c(rVar.f32567b - 1);
                    if (c3 == 255) {
                        this.f32117f = true;
                        return;
                    }
                }
                int min = Math.min(rVar.b(), 3 - this.f32115d);
                rVar.a(this.f32113b.f32566a, this.f32115d, min);
                this.f32115d += min;
                if (this.f32115d == 3) {
                    this.f32113b.a(3);
                    this.f32113b.d(1);
                    int c4 = this.f32113b.c();
                    int c5 = this.f32113b.c();
                    this.f32116e = (c4 & 128) != 0;
                    this.f32114c = (((c4 & 15) << 8) | c5) + 3;
                    if (this.f32113b.f32566a.length < this.f32114c) {
                        byte[] bArr = this.f32113b.f32566a;
                        this.f32113b.a(Math.min(4098, Math.max(this.f32114c, bArr.length * 2)));
                        System.arraycopy(bArr, 0, this.f32113b.f32566a, 0, 3);
                    }
                }
            } else {
                int min2 = Math.min(rVar.b(), this.f32114c - this.f32115d);
                rVar.a(this.f32113b.f32566a, this.f32115d, min2);
                this.f32115d += min2;
                int i4 = this.f32115d;
                int i5 = this.f32114c;
                if (i4 != i5) {
                    continue;
                } else {
                    if (!this.f32116e) {
                        this.f32113b.a(i5);
                    } else if (ae.b(this.f32113b.f32566a, this.f32114c, -1) != 0) {
                        this.f32117f = true;
                        return;
                    } else {
                        this.f32113b.a(this.f32114c - 4);
                    }
                    this.f32112a.a(this.f32113b);
                    this.f32115d = 0;
                }
            }
        }
    }
}
