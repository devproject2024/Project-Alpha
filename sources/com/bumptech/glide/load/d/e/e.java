package com.bumptech.glide.load.d.e;

import com.bumptech.glide.e.a.j;
import com.bumptech.glide.load.b.r;
import com.bumptech.glide.load.d.c.b;

public final class e extends b<c> implements r {
    public e(c cVar) {
        super(cVar);
    }

    public final Class<c> a() {
        return c.class;
    }

    public final int c() {
        g gVar = ((c) this.f7202a).f7214a.f7223a;
        return gVar.f7225a.g() + gVar.j;
    }

    public final void d() {
        ((c) this.f7202a).stop();
        c cVar = (c) this.f7202a;
        cVar.f7215b = true;
        g gVar = cVar.f7214a.f7223a;
        gVar.f7226b.clear();
        gVar.b();
        gVar.f7228d = false;
        if (gVar.f7229e != null) {
            gVar.f7227c.a((j<?>) gVar.f7229e);
            gVar.f7229e = null;
        }
        if (gVar.f7231g != null) {
            gVar.f7227c.a((j<?>) gVar.f7231g);
            gVar.f7231g = null;
        }
        if (gVar.f7233i != null) {
            gVar.f7227c.a((j<?>) gVar.f7233i);
            gVar.f7233i = null;
        }
        gVar.f7225a.i();
        gVar.f7230f = true;
    }

    public final void e() {
        ((c) this.f7202a).a().prepareToDraw();
    }
}
