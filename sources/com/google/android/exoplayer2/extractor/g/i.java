package com.google.android.exoplayer2.extractor.g;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.g.ac;
import com.google.android.exoplayer2.extractor.q;
import com.google.android.exoplayer2.g.r;
import java.util.Collections;
import java.util.List;

public final class i implements j {

    /* renamed from: a  reason: collision with root package name */
    private final List<ac.a> f31982a;

    /* renamed from: b  reason: collision with root package name */
    private final q[] f31983b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f31984c;

    /* renamed from: d  reason: collision with root package name */
    private int f31985d;

    /* renamed from: e  reason: collision with root package name */
    private int f31986e;

    /* renamed from: f  reason: collision with root package name */
    private long f31987f;

    public i(List<ac.a> list) {
        this.f31982a = list;
        this.f31983b = new q[list.size()];
    }

    public final void a() {
        this.f31984c = false;
    }

    public final void a(com.google.android.exoplayer2.extractor.i iVar, ac.d dVar) {
        for (int i2 = 0; i2 < this.f31983b.length; i2++) {
            ac.a aVar = this.f31982a.get(i2);
            dVar.a();
            q a2 = iVar.a(dVar.b(), 3);
            a2.a(Format.a(dVar.c(), "application/dvbsubs", 0, Collections.singletonList(aVar.f31917c), aVar.f31915a, (DrmInitData) null));
            this.f31983b[i2] = a2;
        }
    }

    public final void a(long j, int i2) {
        if ((i2 & 4) != 0) {
            this.f31984c = true;
            this.f31987f = j;
            this.f31986e = 0;
            this.f31985d = 2;
        }
    }

    public final void b() {
        if (this.f31984c) {
            for (q a2 : this.f31983b) {
                a2.a(this.f31987f, 1, this.f31986e, 0, (q.a) null);
            }
            this.f31984c = false;
        }
    }

    public final void a(r rVar) {
        if (!this.f31984c) {
            return;
        }
        if (this.f31985d != 2 || a(rVar, 32)) {
            if (this.f31985d != 1 || a(rVar, 0)) {
                int i2 = rVar.f32567b;
                int b2 = rVar.b();
                for (q a2 : this.f31983b) {
                    rVar.c(i2);
                    a2.a(rVar, b2);
                }
                this.f31986e += b2;
            }
        }
    }

    private boolean a(r rVar, int i2) {
        if (rVar.b() == 0) {
            return false;
        }
        if (rVar.c() != i2) {
            this.f31984c = false;
        }
        this.f31985d--;
        return this.f31984c;
    }
}
