package com.google.android.exoplayer2.extractor.e;

import com.google.android.exoplayer2.extractor.g;
import com.google.android.exoplayer2.extractor.h;
import com.google.android.exoplayer2.extractor.i;
import com.google.android.exoplayer2.extractor.j;
import com.google.android.exoplayer2.extractor.n;
import com.google.android.exoplayer2.extractor.q;
import com.google.android.exoplayer2.g.r;
import com.google.android.exoplayer2.v;
import java.io.IOException;

public final class c implements g {

    /* renamed from: a  reason: collision with root package name */
    public static final j f31809a = $$Lambda$c$6Zp0Wzk_7RAAYsXzbk1rPVhL9xI.INSTANCE;

    /* renamed from: b  reason: collision with root package name */
    private i f31810b;

    /* renamed from: c  reason: collision with root package name */
    private h f31811c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f31812d;

    /* access modifiers changed from: private */
    public static /* synthetic */ g[] a() {
        return new g[]{new c()};
    }

    public final boolean a(h hVar) throws IOException, InterruptedException {
        try {
            return b(hVar);
        } catch (v unused) {
            return false;
        }
    }

    public final void a(i iVar) {
        this.f31810b = iVar;
    }

    public final void a(long j, long j2) {
        h hVar = this.f31811c;
        if (hVar != null) {
            hVar.a(j, j2);
        }
    }

    public final int a(h hVar, n nVar) throws IOException, InterruptedException {
        if (this.f31811c == null) {
            if (b(hVar)) {
                hVar.a();
            } else {
                throw new v("Failed to determine bitstream type");
            }
        }
        if (!this.f31812d) {
            q a2 = this.f31810b.a(0, 1);
            this.f31810b.a();
            this.f31811c.a(this.f31810b, a2);
            this.f31812d = true;
        }
        h hVar2 = this.f31811c;
        int i2 = hVar2.f31832c;
        if (i2 == 0) {
            return hVar2.a(hVar);
        }
        if (i2 == 1) {
            hVar.b((int) hVar2.f31831b);
            hVar2.f31832c = 2;
            return 0;
        } else if (i2 == 2) {
            return hVar2.a(hVar, nVar);
        } else {
            throw new IllegalStateException();
        }
    }

    private boolean b(h hVar) throws IOException, InterruptedException {
        e eVar = new e();
        if (eVar.a(hVar, true) && (eVar.f31819b & 2) == 2) {
            int min = Math.min(eVar.f31826i, 8);
            r rVar = new r(min);
            hVar.c(rVar.f32566a, 0, min);
            rVar.c(0);
            if (b.a(rVar)) {
                this.f31811c = new b();
            } else {
                rVar.c(0);
                if (j.a(rVar)) {
                    this.f31811c = new j();
                } else {
                    rVar.c(0);
                    if (g.a(rVar)) {
                        this.f31811c = new g();
                    }
                }
            }
            return true;
        }
        return false;
    }
}
