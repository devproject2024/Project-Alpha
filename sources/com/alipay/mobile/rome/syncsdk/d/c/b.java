package com.alipay.mobile.rome.syncsdk.d.c;

import com.alipay.mobile.rome.syncsdk.d.b.a;
import com.alipay.mobile.rome.syncsdk.e.h;
import com.alipay.mobile.rome.syncsdk.service.c;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class b implements a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f15032a = b.class.getSimpleName();

    /* renamed from: d  reason: collision with root package name */
    private static ExecutorService f15033d;

    /* renamed from: b  reason: collision with root package name */
    private final c f15034b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<Object, a> f15035c = new ConcurrentHashMap();

    public final boolean b(a aVar) {
        return aVar != null;
    }

    public b(c cVar) {
        this.f15034b = cVar;
        e eVar = new e(this.f15034b);
        f fVar = new f(this.f15034b);
        g gVar = new g(this.f15034b);
        h hVar = new h(this.f15034b);
        i iVar = new i(this.f15034b);
        j jVar = new j(this.f15034b);
        this.f15035c.put(eVar, eVar);
        this.f15035c.put(fVar, fVar);
        this.f15035c.put(gVar, gVar);
        this.f15035c.put(hVar, hVar);
        this.f15035c.put(iVar, iVar);
        this.f15035c.put(jVar, jVar);
    }

    public final void a(a aVar) {
        for (a next : this.f15035c.values()) {
            if (next.b(aVar)) {
                a((Runnable) new d(this, next, aVar));
            }
        }
    }

    private synchronized void a(Runnable runnable) {
        h.b(f15032a, "submit ");
        if (f15033d == null || f15033d.isTerminated() || f15033d.isShutdown()) {
            h.c(f15032a, "submit:[ newSingleThreadExecutor restart]");
            f15033d = Executors.newSingleThreadExecutor(new c(this));
        }
        f15033d.submit(runnable);
    }
}
