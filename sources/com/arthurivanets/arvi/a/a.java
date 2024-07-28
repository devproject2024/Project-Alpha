package com.arthurivanets.arvi.a;

import android.content.Context;
import com.arthurivanets.arvi.a.b;
import com.arthurivanets.arvi.a.b.e;
import com.arthurivanets.arvi.a.b.f;
import com.arthurivanets.arvi.b.b.c;
import com.google.android.exoplayer2.a.a;
import com.google.android.exoplayer2.ae;
import com.google.android.exoplayer2.ag;
import com.google.android.exoplayer2.f.d;
import com.google.android.exoplayer2.k;
import com.google.android.exoplayer2.l;
import com.google.android.exoplayer2.q;
import com.google.android.exoplayer2.source.m;
import com.google.android.exoplayer2.source.o;
import com.google.android.exoplayer2.source.p;
import com.google.android.exoplayer2.trackselection.i;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.z;
import java.util.Collections;

public final class a implements b {

    /* renamed from: a  reason: collision with root package name */
    private final Context f30964a;

    /* renamed from: b  reason: collision with root package name */
    private e f30965b = new e();

    /* renamed from: c  reason: collision with root package name */
    private ae f30966c;

    /* renamed from: d  reason: collision with root package name */
    private i f30967d;

    /* renamed from: e  reason: collision with root package name */
    private q f30968e;

    /* renamed from: f  reason: collision with root package name */
    private d f30969f;

    /* renamed from: g  reason: collision with root package name */
    private com.google.android.exoplayer2.drm.e<com.google.android.exoplayer2.drm.i> f30970g;

    /* renamed from: h  reason: collision with root package name */
    private o f30971h;

    /* renamed from: i  reason: collision with root package name */
    private ag f30972i;
    private f j;
    private b.a k;

    public a(Context context, ae aeVar, i iVar, q qVar, d dVar, com.google.android.exoplayer2.drm.e<com.google.android.exoplayer2.drm.i> eVar) {
        c.a((Object) context);
        this.f30964a = context.getApplicationContext();
        c.a((Object) aeVar);
        this.f30966c = aeVar;
        c.a((Object) iVar);
        this.f30967d = iVar;
        c.a((Object) qVar);
        this.f30968e = qVar;
        this.f30969f = dVar;
        this.f30970g = eVar;
    }

    public final void a() {
        if (!m()) {
            Context context = this.f30964a;
            ae aeVar = this.f30966c;
            i iVar = this.f30967d;
            q qVar = this.f30968e;
            com.google.android.exoplayer2.drm.e<com.google.android.exoplayer2.drm.i> eVar = this.f30970g;
            d dVar = this.f30969f;
            new a.C0529a();
            this.f30972i = k.a(context, aeVar, iVar, qVar, eVar, dVar, com.google.android.exoplayer2.g.ae.a());
            this.f30972i.a((z.a) this.f30965b);
            this.j = new com.arthurivanets.arvi.a.b.b(this.f30972i);
        }
    }

    public final void b() {
        l();
        o oVar = this.f30971h;
        if (oVar != null) {
            this.f30972i.a(oVar, false, false);
            return;
        }
        throw new IllegalStateException("The Media Source is required.");
    }

    public final void c() {
        l();
        this.f30972i.a(true);
    }

    public final void d() {
        l();
        this.f30972i.a(false);
    }

    public final void a(boolean z) {
        l();
        ag agVar = this.f30972i;
        agVar.F();
        l lVar = agVar.f31114c;
        if (z) {
            lVar.l = null;
            lVar.f32606e = null;
        }
        w a2 = lVar.a(z, z, 1);
        lVar.j++;
        lVar.f32605d.f32621a.a(6, z ? 1 : 0).sendToTarget();
        lVar.a(a2, false, 4, 1, false);
        if (agVar.s != null) {
            agVar.s.a((p) agVar.j);
            agVar.j.g();
            if (z) {
                agVar.s = null;
            }
        }
        agVar.k.b(true);
        agVar.t = Collections.emptyList();
    }

    public final void a(long j2) {
        l();
        ag agVar = this.f30972i;
        agVar.a(agVar.s(), j2);
    }

    public final void a(PlayerView playerView) {
        c.a((Object) playerView);
        l();
        playerView.setPlayer(this.f30972i);
    }

    public final void b(PlayerView playerView) {
        c.a((Object) playerView);
        l();
        playerView.setPlayer((z) null);
    }

    public final void e() {
        b.a aVar = this.k;
        if (aVar != null) {
            aVar.a(this);
        }
    }

    private void l() {
        if (!m()) {
            throw new IllegalStateException("The Player must be initialized first.");
        }
    }

    public final void a(b.a aVar) {
        this.k = aVar;
    }

    public final void a(b.C0527b bVar) {
        c.a((Object) bVar);
        e eVar = this.f30965b;
        c.a((Object) bVar);
        eVar.f30989a.add(bVar);
    }

    public final void b(b.C0527b bVar) {
        c.a((Object) bVar);
        e eVar = this.f30965b;
        c.a((Object) bVar);
        eVar.f30989a.remove(bVar);
    }

    public final void f() {
        this.f30965b.f30989a.clear();
    }

    public final f g() {
        l();
        return this.j;
    }

    public final int h() {
        if (m()) {
            return this.f30972i.k();
        }
        return 1;
    }

    public final long i() {
        if (m()) {
            return this.f30972i.u();
        }
        return 0;
    }

    private boolean m() {
        return this.f30972i != null;
    }

    public final boolean j() {
        int h2 = h();
        if (!m() || !this.f30972i.n() || h2 == 1) {
            return false;
        }
        if (h2 != 4 || (this.f30971h instanceof m)) {
            return true;
        }
        return false;
    }

    public final boolean c(PlayerView playerView) {
        c.a((Object) playerView);
        return playerView.getPlayer() != null && playerView.getPlayer() == this.f30972i;
    }

    public final boolean k() {
        b.a aVar = this.k;
        return aVar != null && aVar.b(this);
    }

    public final void a(o oVar) {
        c.a((Object) oVar);
        this.f30971h = oVar;
    }
}
