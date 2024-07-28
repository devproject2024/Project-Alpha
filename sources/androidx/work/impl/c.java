package androidx.work.impl;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.y;
import androidx.work.o;

public final class c implements o {

    /* renamed from: c  reason: collision with root package name */
    private final y<o.a> f5296c = new y<>();

    /* renamed from: d  reason: collision with root package name */
    private final androidx.work.impl.utils.a.c<o.a.c> f5297d = androidx.work.impl.utils.a.c.a();

    public c() {
        a(o.f5508b);
    }

    public final LiveData<o.a> a() {
        return this.f5296c;
    }

    public final void a(o.a aVar) {
        this.f5296c.postValue(aVar);
        if (aVar instanceof o.a.c) {
            this.f5297d.a((o.a.c) aVar);
        } else if (aVar instanceof o.a.C0079a) {
            this.f5297d.a(((o.a.C0079a) aVar).f5509a);
        }
    }
}
