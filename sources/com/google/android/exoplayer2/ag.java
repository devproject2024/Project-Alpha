package com.google.android.exoplayer2;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import com.google.android.exoplayer2.a.a;
import com.google.android.exoplayer2.aa;
import com.google.android.exoplayer2.b.c;
import com.google.android.exoplayer2.b.e;
import com.google.android.exoplayer2.b.f;
import com.google.android.exoplayer2.e.b;
import com.google.android.exoplayer2.e.k;
import com.google.android.exoplayer2.g.l;
import com.google.android.exoplayer2.g.u;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.d;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.o;
import com.google.android.exoplayer2.source.p;
import com.google.android.exoplayer2.trackselection.i;
import com.google.android.exoplayer2.video.e;
import com.google.android.exoplayer2.video.g;
import com.google.android.exoplayer2.video.h;
import com.google.android.exoplayer2.z;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

public final class ag extends a implements j, z.b, z.c {
    private int A;
    private SurfaceHolder B;
    private TextureView C;
    private int D;
    private int E;
    private c F;
    private e G;
    private com.google.android.exoplayer2.video.a.a H;
    private boolean I;

    /* renamed from: b  reason: collision with root package name */
    protected final ab[] f31113b;

    /* renamed from: c  reason: collision with root package name */
    public final l f31114c;

    /* renamed from: d  reason: collision with root package name */
    final CopyOnWriteArraySet<g> f31115d;

    /* renamed from: e  reason: collision with root package name */
    public final CopyOnWriteArraySet<f> f31116e;

    /* renamed from: f  reason: collision with root package name */
    final CopyOnWriteArraySet<k> f31117f;

    /* renamed from: g  reason: collision with root package name */
    final CopyOnWriteArraySet<d> f31118g;

    /* renamed from: h  reason: collision with root package name */
    final CopyOnWriteArraySet<h> f31119h;

    /* renamed from: i  reason: collision with root package name */
    final CopyOnWriteArraySet<com.google.android.exoplayer2.b.h> f31120i;
    public final com.google.android.exoplayer2.a.a j;
    public final com.google.android.exoplayer2.b.e k;
    Format l;
    Format m;
    Surface n;
    com.google.android.exoplayer2.c.d o;
    com.google.android.exoplayer2.c.d p;
    int q;
    public float r;
    public o s;
    public List<b> t;
    u u;
    boolean v;
    private final Handler w;
    private final a x;
    private final com.google.android.exoplayer2.f.d y;
    private boolean z;

    public final z.c h() {
        return this;
    }

    public final z.b i() {
        return this;
    }

    protected ag(Context context, ae aeVar, i iVar, q qVar, com.google.android.exoplayer2.drm.e<com.google.android.exoplayer2.drm.i> eVar, com.google.android.exoplayer2.f.d dVar, Looper looper) {
        this(context, aeVar, iVar, qVar, eVar, dVar, com.google.android.exoplayer2.g.b.f32508a, looper);
    }

    private ag(Context context, ae aeVar, i iVar, q qVar, com.google.android.exoplayer2.drm.e<com.google.android.exoplayer2.drm.i> eVar, com.google.android.exoplayer2.f.d dVar, com.google.android.exoplayer2.g.b bVar, Looper looper) {
        com.google.android.exoplayer2.drm.e<com.google.android.exoplayer2.drm.i> eVar2 = eVar;
        com.google.android.exoplayer2.f.d dVar2 = dVar;
        this.y = dVar2;
        this.x = new a(this, (byte) 0);
        this.f31115d = new CopyOnWriteArraySet<>();
        this.f31116e = new CopyOnWriteArraySet<>();
        this.f31117f = new CopyOnWriteArraySet<>();
        this.f31118g = new CopyOnWriteArraySet<>();
        this.f31119h = new CopyOnWriteArraySet<>();
        this.f31120i = new CopyOnWriteArraySet<>();
        this.w = new Handler(looper);
        Handler handler = this.w;
        a aVar = this.x;
        this.f31113b = aeVar.a(handler, aVar, aVar, aVar, aVar, eVar);
        this.r = 1.0f;
        this.q = 0;
        this.F = c.f31165a;
        this.A = 1;
        this.t = Collections.emptyList();
        this.f31114c = new l(this.f31113b, iVar, qVar, dVar, bVar, looper);
        this.j = a.C0529a.a(this.f31114c, bVar);
        a((z.a) this.j);
        a((z.a) this.x);
        this.f31119h.add(this.j);
        this.f31115d.add(this.j);
        this.f31120i.add(this.j);
        this.f31116e.add(this.j);
        this.f31118g.add(this.j);
        dVar2.a(this.w, this.j);
        if (eVar2 instanceof com.google.android.exoplayer2.drm.c) {
            ((com.google.android.exoplayer2.drm.c) eVar2).f31374a.a(this.w, this.j);
        }
        Context context2 = context;
        this.k = new com.google.android.exoplayer2.b.e(context, this.x);
    }

    public final void a(Surface surface) {
        F();
        if (surface != null && surface == this.n) {
            b((Surface) null);
        }
    }

    public final void b(Surface surface) {
        F();
        G();
        int i2 = 0;
        a(surface, false);
        if (surface != null) {
            i2 = -1;
        }
        a(i2, i2);
    }

    private void a(SurfaceHolder surfaceHolder) {
        F();
        G();
        this.B = surfaceHolder;
        if (surfaceHolder != null) {
            surfaceHolder.addCallback(this.x);
            Surface surface = surfaceHolder.getSurface();
            if (surface != null && surface.isValid()) {
                a(surface, false);
                Rect surfaceFrame = surfaceHolder.getSurfaceFrame();
                a(surfaceFrame.width(), surfaceFrame.height());
                return;
            }
        }
        a((Surface) null, false);
        a(0, 0);
    }

    public final void a(SurfaceView surfaceView) {
        a(surfaceView == null ? null : surfaceView.getHolder());
    }

    public final void b(SurfaceView surfaceView) {
        SurfaceHolder holder = surfaceView == null ? null : surfaceView.getHolder();
        F();
        if (holder != null && holder == this.B) {
            a((SurfaceHolder) null);
        }
    }

    public final void a(TextureView textureView) {
        F();
        G();
        this.C = textureView;
        if (textureView == null) {
            a((Surface) null, true);
            a(0, 0);
            return;
        }
        if (textureView.getSurfaceTextureListener() != null) {
            l.c();
        }
        textureView.setSurfaceTextureListener(this.x);
        SurfaceTexture surfaceTexture = textureView.isAvailable() ? textureView.getSurfaceTexture() : null;
        if (surfaceTexture == null) {
            a((Surface) null, true);
            a(0, 0);
            return;
        }
        a(new Surface(surfaceTexture), true);
        a(textureView.getWidth(), textureView.getHeight());
    }

    public final void b(TextureView textureView) {
        F();
        if (textureView != null && textureView == this.C) {
            a((TextureView) null);
        }
    }

    public final void a(g gVar) {
        this.f31115d.add(gVar);
    }

    public final void b(g gVar) {
        this.f31115d.remove(gVar);
    }

    public final void a(e eVar) {
        F();
        this.G = eVar;
        for (ab abVar : this.f31113b) {
            if (abVar.a() == 2) {
                this.f31114c.a((aa.b) abVar).a(6).a((Object) eVar).a();
            }
        }
    }

    public final void b(e eVar) {
        F();
        if (this.G == eVar) {
            for (ab abVar : this.f31113b) {
                if (abVar.a() == 2) {
                    this.f31114c.a((aa.b) abVar).a(6).a((Object) null).a();
                }
            }
        }
    }

    public final void a(com.google.android.exoplayer2.video.a.a aVar) {
        F();
        this.H = aVar;
        for (ab abVar : this.f31113b) {
            if (abVar.a() == 5) {
                this.f31114c.a((aa.b) abVar).a(7).a((Object) aVar).a();
            }
        }
    }

    public final void b(com.google.android.exoplayer2.video.a.a aVar) {
        F();
        if (this.H == aVar) {
            for (ab abVar : this.f31113b) {
                if (abVar.a() == 5) {
                    this.f31114c.a((aa.b) abVar).a(7).a((Object) null).a();
                }
            }
        }
    }

    public final void a(k kVar) {
        if (!this.t.isEmpty()) {
            kVar.a(this.t);
        }
        this.f31117f.add(kVar);
    }

    public final void b(k kVar) {
        this.f31117f.remove(kVar);
    }

    public final Looper j() {
        return this.f31114c.f32604c.getLooper();
    }

    public final void a(z.a aVar) {
        F();
        this.f31114c.a(aVar);
    }

    public final void b(z.a aVar) {
        F();
        this.f31114c.b(aVar);
    }

    public final int k() {
        F();
        return this.f31114c.m.f33722f;
    }

    public final int l() {
        F();
        return this.f31114c.f32608g;
    }

    public final i m() {
        F();
        return this.f31114c.l;
    }

    public final void a(o oVar, boolean z2, boolean z3) {
        F();
        o oVar2 = this.s;
        if (oVar2 != null) {
            oVar2.a((p) this.j);
            this.j.g();
        }
        this.s = oVar;
        oVar.a(this.w, (p) this.j);
        a(n(), this.k.a(n()));
        this.f31114c.a(oVar, z2, z3);
    }

    public final void a(boolean z2) {
        F();
        a(z2, this.k.a(z2, k()));
    }

    public final boolean n() {
        F();
        return this.f31114c.f32607f;
    }

    public final int o() {
        F();
        return this.f31114c.f32609h;
    }

    public final void a(int i2) {
        F();
        this.f31114c.a(i2);
    }

    public final void b(boolean z2) {
        F();
        this.f31114c.b(z2);
    }

    public final boolean p() {
        F();
        return this.f31114c.f32610i;
    }

    public final void a(int i2, long j2) {
        F();
        com.google.android.exoplayer2.a.a aVar = this.j;
        if (!aVar.f31074b.f31087g) {
            aVar.q();
            aVar.f31074b.f31087g = true;
            Iterator<com.google.android.exoplayer2.a.b> it2 = aVar.f31073a.iterator();
            while (it2.hasNext()) {
                it2.next();
            }
        }
        this.f31114c.a(i2, j2);
    }

    public final x q() {
        F();
        return this.f31114c.k;
    }

    public final void r() {
        F();
        this.k.b(true);
        this.f31114c.r();
        G();
        Surface surface = this.n;
        if (surface != null) {
            if (this.z) {
                surface.release();
            }
            this.n = null;
        }
        o oVar = this.s;
        if (oVar != null) {
            oVar.a((p) this.j);
            this.s = null;
        }
        if (this.v) {
            ((u) com.google.android.exoplayer2.g.a.a(this.u)).a();
            this.v = false;
        }
        this.y.a(this.j);
        this.t = Collections.emptyList();
    }

    public final int b(int i2) {
        F();
        return this.f31114c.b(i2);
    }

    public final TrackGroupArray B() {
        F();
        return this.f31114c.m.f33724h;
    }

    public final com.google.android.exoplayer2.trackselection.g C() {
        F();
        return this.f31114c.C();
    }

    public final ah D() {
        F();
        return this.f31114c.m.f33717a;
    }

    public final int s() {
        F();
        return this.f31114c.s();
    }

    public final long t() {
        F();
        return this.f31114c.t();
    }

    public final long u() {
        F();
        return this.f31114c.u();
    }

    public final long v() {
        F();
        return this.f31114c.v();
    }

    public final boolean w() {
        F();
        return this.f31114c.w();
    }

    public final int x() {
        F();
        return this.f31114c.x();
    }

    public final int y() {
        F();
        return this.f31114c.y();
    }

    public final long z() {
        F();
        return this.f31114c.z();
    }

    public final long A() {
        F();
        return this.f31114c.A();
    }

    private void G() {
        TextureView textureView = this.C;
        if (textureView != null) {
            if (textureView.getSurfaceTextureListener() != this.x) {
                l.c();
            } else {
                this.C.setSurfaceTextureListener((TextureView.SurfaceTextureListener) null);
            }
            this.C = null;
        }
        SurfaceHolder surfaceHolder = this.B;
        if (surfaceHolder != null) {
            surfaceHolder.removeCallback(this.x);
            this.B = null;
        }
    }

    /* access modifiers changed from: private */
    public void a(Surface surface, boolean z2) {
        ArrayList<aa> arrayList = new ArrayList<>();
        for (ab abVar : this.f31113b) {
            if (abVar.a() == 2) {
                arrayList.add(this.f31114c.a((aa.b) abVar).a(1).a((Object) surface).a());
            }
        }
        Surface surface2 = this.n;
        if (!(surface2 == null || surface2 == surface)) {
            try {
                for (aa c2 : arrayList) {
                    c2.c();
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
            if (this.z) {
                this.n.release();
            }
        }
        this.n = surface;
        this.z = z2;
    }

    /* access modifiers changed from: package-private */
    public final void a(int i2, int i3) {
        if (i2 != this.D || i3 != this.E) {
            this.D = i2;
            this.E = i3;
            Iterator<g> it2 = this.f31115d.iterator();
            while (it2.hasNext()) {
                it2.next().j();
            }
        }
    }

    public final void E() {
        float f2 = this.r * this.k.f31179c;
        for (ab abVar : this.f31113b) {
            if (abVar.a() == 1) {
                this.f31114c.a((aa.b) abVar).a(2).a((Object) Float.valueOf(f2)).a();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(boolean z2, int i2) {
        boolean z3 = false;
        int i3 = i2 == 1 ? 0 : 1;
        l lVar = this.f31114c;
        if (z2 && i2 != -1) {
            z3 = true;
        }
        lVar.a(z3, i3);
    }

    public final void F() {
        if (Looper.myLooper() != j()) {
            l.a("Player is accessed on the wrong thread. See https://exoplayer.dev/issues/player-accessed-on-wrong-thread", this.I ? null : new IllegalStateException());
            this.I = true;
        }
    }

    final class a implements SurfaceHolder.Callback, TextureView.SurfaceTextureListener, e.b, com.google.android.exoplayer2.b.h, k, d, h, z.a {
        public /* synthetic */ void a() {
            z.a.CC.$default$a(this);
        }

        public /* synthetic */ void a(int i2) {
            z.a.CC.$default$a((z.a) this, i2);
        }

        public /* synthetic */ void a(ah ahVar) {
            z.a.CC.$default$a((z.a) this, ahVar);
        }

        public /* synthetic */ void a(i iVar) {
            z.a.CC.$default$a((z.a) this, iVar);
        }

        public /* synthetic */ void b() {
            z.a.CC.$default$b(this);
        }

        public /* synthetic */ void b(boolean z) {
            z.a.CC.$default$b(this, z);
        }

        public /* synthetic */ void c() {
            z.a.CC.$default$c(this);
        }

        public /* synthetic */ void d() {
            z.a.CC.$default$d(this);
        }

        public /* synthetic */ void e() {
            z.a.CC.$default$e(this);
        }

        public /* synthetic */ void f() {
            z.a.CC.$default$f(this);
        }

        public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        private a() {
        }

        /* synthetic */ a(ag agVar, byte b2) {
            this();
        }

        public final void a(com.google.android.exoplayer2.c.d dVar) {
            ag agVar = ag.this;
            agVar.o = dVar;
            Iterator<h> it2 = agVar.f31119h.iterator();
            while (it2.hasNext()) {
                it2.next().a(dVar);
            }
        }

        public final void a(String str, long j, long j2) {
            Iterator<h> it2 = ag.this.f31119h.iterator();
            while (it2.hasNext()) {
                it2.next().a(str, j, j2);
            }
        }

        public final void a(Format format) {
            ag agVar = ag.this;
            agVar.l = format;
            Iterator<h> it2 = agVar.f31119h.iterator();
            while (it2.hasNext()) {
                it2.next().a(format);
            }
        }

        public final void a(int i2, long j) {
            Iterator<h> it2 = ag.this.f31119h.iterator();
            while (it2.hasNext()) {
                it2.next().a(i2, j);
            }
        }

        public final void a(int i2, int i3, int i4, float f2) {
            Iterator<g> it2 = ag.this.f31115d.iterator();
            while (it2.hasNext()) {
                g next = it2.next();
                if (!ag.this.f31119h.contains(next)) {
                    next.a(i2, i3, i4, f2);
                }
            }
            Iterator<h> it3 = ag.this.f31119h.iterator();
            while (it3.hasNext()) {
                it3.next().a(i2, i3, i4, f2);
            }
        }

        public final void a(Surface surface) {
            if (ag.this.n == surface) {
                Iterator<g> it2 = ag.this.f31115d.iterator();
                while (it2.hasNext()) {
                    it2.next().i();
                }
            }
            Iterator<h> it3 = ag.this.f31119h.iterator();
            while (it3.hasNext()) {
                it3.next().a(surface);
            }
        }

        public final void b(com.google.android.exoplayer2.c.d dVar) {
            Iterator<h> it2 = ag.this.f31119h.iterator();
            while (it2.hasNext()) {
                it2.next().b(dVar);
            }
            ag agVar = ag.this;
            agVar.l = null;
            agVar.o = null;
        }

        public final void c(com.google.android.exoplayer2.c.d dVar) {
            ag agVar = ag.this;
            agVar.p = dVar;
            Iterator<com.google.android.exoplayer2.b.h> it2 = agVar.f31120i.iterator();
            while (it2.hasNext()) {
                it2.next().c(dVar);
            }
        }

        public final void b(int i2) {
            if (ag.this.q != i2) {
                ag agVar = ag.this;
                agVar.q = i2;
                Iterator<f> it2 = agVar.f31116e.iterator();
                while (it2.hasNext()) {
                    f next = it2.next();
                    if (!ag.this.f31120i.contains(next)) {
                        next.b(i2);
                    }
                }
                Iterator<com.google.android.exoplayer2.b.h> it3 = ag.this.f31120i.iterator();
                while (it3.hasNext()) {
                    it3.next().b(i2);
                }
            }
        }

        public final void b(String str, long j, long j2) {
            Iterator<com.google.android.exoplayer2.b.h> it2 = ag.this.f31120i.iterator();
            while (it2.hasNext()) {
                it2.next().b(str, j, j2);
            }
        }

        public final void b(Format format) {
            ag agVar = ag.this;
            agVar.m = format;
            Iterator<com.google.android.exoplayer2.b.h> it2 = agVar.f31120i.iterator();
            while (it2.hasNext()) {
                it2.next().b(format);
            }
        }

        public final void a(int i2, long j, long j2) {
            Iterator<com.google.android.exoplayer2.b.h> it2 = ag.this.f31120i.iterator();
            while (it2.hasNext()) {
                it2.next().a(i2, j, j2);
            }
        }

        public final void d(com.google.android.exoplayer2.c.d dVar) {
            Iterator<com.google.android.exoplayer2.b.h> it2 = ag.this.f31120i.iterator();
            while (it2.hasNext()) {
                it2.next().d(dVar);
            }
            ag agVar = ag.this;
            agVar.m = null;
            agVar.p = null;
            agVar.q = 0;
        }

        public final void a(List<b> list) {
            ag agVar = ag.this;
            agVar.t = list;
            Iterator<k> it2 = agVar.f31117f.iterator();
            while (it2.hasNext()) {
                it2.next().a(list);
            }
        }

        public final void a(Metadata metadata) {
            Iterator<d> it2 = ag.this.f31118g.iterator();
            while (it2.hasNext()) {
                it2.next().a(metadata);
            }
        }

        public final void surfaceCreated(SurfaceHolder surfaceHolder) {
            ag.this.a(surfaceHolder.getSurface(), false);
        }

        public final void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
            ag.this.a(i3, i4);
        }

        public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            ag.this.a((Surface) null, false);
            ag.this.a(0, 0);
        }

        public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
            ag.this.a(new Surface(surfaceTexture), true);
            ag.this.a(i2, i3);
        }

        public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
            ag.this.a(i2, i3);
        }

        public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            ag.this.a((Surface) null, true);
            ag.this.a(0, 0);
            return true;
        }

        public final void g() {
            ag.this.E();
        }

        public final void c(int i2) {
            ag agVar = ag.this;
            agVar.a(agVar.n(), i2);
        }

        public final void a(boolean z) {
            if (ag.this.u == null) {
                return;
            }
            if (z && !ag.this.v) {
                u uVar = ag.this.u;
                synchronized (uVar.f32573a) {
                    uVar.f32574b.add(0);
                    uVar.f32575c = Math.max(uVar.f32575c, 0);
                }
                ag.this.v = true;
            } else if (!z && ag.this.v) {
                ag.this.u.a();
                ag.this.v = false;
            }
        }
    }
}
