package com.bumptech.glide.load.b.b;

import com.bumptech.glide.load.b.b.h;
import com.bumptech.glide.load.b.v;

public final class g extends com.bumptech.glide.g.g<com.bumptech.glide.load.g, v<?>> implements h {

    /* renamed from: a  reason: collision with root package name */
    private h.a f6788a;

    public final /* synthetic */ int a(Object obj) {
        v vVar = (v) obj;
        if (vVar == null) {
            return super.a(null);
        }
        return vVar.c();
    }

    public final /* synthetic */ v a(com.bumptech.glide.load.g gVar) {
        return (v) super.c(gVar);
    }

    public final /* synthetic */ v a(com.bumptech.glide.load.g gVar, v vVar) {
        return (v) super.b(gVar, vVar);
    }

    public final /* synthetic */ void a(Object obj, Object obj2) {
        v vVar = (v) obj2;
        h.a aVar = this.f6788a;
        if (aVar != null && vVar != null) {
            aVar.b(vVar);
        }
    }

    public g(long j) {
        super(j);
    }

    public final void a(h.a aVar) {
        this.f6788a = aVar;
    }

    public final void a(int i2) {
        if (i2 >= 40) {
            a();
        } else if (i2 >= 20 || i2 == 15) {
            a(b() / 2);
        }
    }
}
