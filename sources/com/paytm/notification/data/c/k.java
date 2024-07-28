package com.paytm.notification.data.c;

import com.paytm.notification.data.datasource.dao.j;
import com.paytm.notification.data.datasource.dao.l;
import java.util.List;

public final class k implements j {

    /* renamed from: a  reason: collision with root package name */
    private final j f43079a;

    public k(j jVar) {
        kotlin.g.b.k.c(jVar, "pushDao");
        this.f43079a = jVar;
    }

    public final void a(l lVar) {
        kotlin.g.b.k.c(lVar, "pushData");
        this.f43079a.a(lVar);
    }

    public final List<l> a() {
        return this.f43079a.a();
    }

    public final void a(long j) {
        this.f43079a.a(j);
    }
}
