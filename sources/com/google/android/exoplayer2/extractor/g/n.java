package com.google.android.exoplayer2.extractor.g;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.g.ac;
import com.google.android.exoplayer2.extractor.i;
import com.google.android.exoplayer2.extractor.q;
import com.google.android.exoplayer2.g.l;
import com.google.android.exoplayer2.g.r;

public final class n implements j {

    /* renamed from: a  reason: collision with root package name */
    private final r f32047a = new r(10);

    /* renamed from: b  reason: collision with root package name */
    private q f32048b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f32049c;

    /* renamed from: d  reason: collision with root package name */
    private long f32050d;

    /* renamed from: e  reason: collision with root package name */
    private int f32051e;

    /* renamed from: f  reason: collision with root package name */
    private int f32052f;

    public final void a() {
        this.f32049c = false;
    }

    public final void a(i iVar, ac.d dVar) {
        dVar.a();
        this.f32048b = iVar.a(dVar.b(), 4);
        this.f32048b.a(Format.a(dVar.c(), "application/id3"));
    }

    public final void a(long j, int i2) {
        if ((i2 & 4) != 0) {
            this.f32049c = true;
            this.f32050d = j;
            this.f32051e = 0;
            this.f32052f = 0;
        }
    }

    public final void a(r rVar) {
        if (this.f32049c) {
            int b2 = rVar.b();
            int i2 = this.f32052f;
            if (i2 < 10) {
                int min = Math.min(b2, 10 - i2);
                System.arraycopy(rVar.f32566a, rVar.f32567b, this.f32047a.f32566a, this.f32052f, min);
                if (this.f32052f + min == 10) {
                    this.f32047a.c(0);
                    if (73 == this.f32047a.c() && 68 == this.f32047a.c() && 51 == this.f32047a.c()) {
                        this.f32047a.d(3);
                        this.f32051e = this.f32047a.m() + 10;
                    } else {
                        l.c();
                        this.f32049c = false;
                        return;
                    }
                }
            }
            int min2 = Math.min(b2, this.f32051e - this.f32052f);
            this.f32048b.a(rVar, min2);
            this.f32052f += min2;
        }
    }

    public final void b() {
        int i2;
        if (this.f32049c && (i2 = this.f32051e) != 0 && this.f32052f == i2) {
            this.f32048b.a(this.f32050d, 1, i2, 0, (q.a) null);
            this.f32049c = false;
        }
    }
}
