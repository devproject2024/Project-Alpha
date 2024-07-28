package com.arthurivanets.arvi.a.b;

import com.arthurivanets.arvi.b.b.c;
import com.google.android.exoplayer2.ag;
import com.google.android.exoplayer2.b.f;
import com.google.android.exoplayer2.g.ae;
import java.util.Iterator;

public final class b implements f {

    /* renamed from: a  reason: collision with root package name */
    private final ag f30984a;

    /* renamed from: b  reason: collision with root package name */
    private float f30985b = this.f30984a.r;

    public b(ag agVar) {
        c.a((Object) agVar);
        this.f30984a = agVar;
    }

    public final void a(float f2) {
        ag agVar = this.f30984a;
        agVar.F();
        float a2 = ae.a(f2, 0.0f, 1.0f);
        if (agVar.r != a2) {
            agVar.r = a2;
            agVar.E();
            Iterator<f> it2 = agVar.f31116e.iterator();
            while (it2.hasNext()) {
                it2.next().h();
            }
        }
    }

    public final void a(boolean z) {
        if (z) {
            if (!a()) {
                this.f30985b = this.f30984a.r;
                a(0.0f);
            }
        } else if (a()) {
            a(this.f30985b);
        }
    }

    public final boolean a() {
        return this.f30984a.r <= 0.0f;
    }
}
