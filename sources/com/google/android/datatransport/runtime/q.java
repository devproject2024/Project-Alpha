package com.google.android.datatransport.runtime;

import android.content.Context;
import com.google.android.datatransport.b;
import com.google.android.datatransport.g;
import com.google.android.datatransport.runtime.d.a;
import com.google.android.datatransport.runtime.scheduling.e;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.h;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.o;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.p;
import java.util.Collections;
import java.util.Set;

public class q implements p {

    /* renamed from: b  reason: collision with root package name */
    private static volatile s f7800b;

    /* renamed from: a  reason: collision with root package name */
    public final h f7801a;

    /* renamed from: c  reason: collision with root package name */
    private final a f7802c;

    /* renamed from: d  reason: collision with root package name */
    private final a f7803d;

    /* renamed from: e  reason: collision with root package name */
    private final e f7804e;

    q(a aVar, a aVar2, e eVar, h hVar, o oVar) {
        this.f7802c = aVar;
        this.f7803d = aVar2;
        this.f7804e = eVar;
        this.f7801a = hVar;
        oVar.f7946a.execute(p.a(oVar));
    }

    public static void a(Context context) {
        if (f7800b == null) {
            synchronized (q.class) {
                if (f7800b == null) {
                    f7800b = d.a().a(context).a();
                }
            }
        }
    }

    public static q a() {
        s sVar = f7800b;
        if (sVar != null) {
            return sVar.b();
        }
        throw new IllegalStateException("Not initialized!");
    }

    public final g a(e eVar) {
        Set<T> set;
        if (eVar instanceof f) {
            set = Collections.unmodifiableSet(((f) eVar).c());
        } else {
            set = Collections.singleton(b.a("proto"));
        }
        return new m(set, l.d().a(eVar.a()).a(eVar.b()).a(), this);
    }

    public final void a(k kVar, com.google.android.datatransport.h hVar) {
        e eVar = this.f7804e;
        l a2 = kVar.a();
        eVar.a(l.d().a(a2.a()).a(kVar.c().c()).a(a2.b()).a(), h.i().a(this.f7802c.a()).b(this.f7803d.a()).a(kVar.b()).a(new g(kVar.e(), kVar.d().a(kVar.c().b()))).a(kVar.c().a()).b(), hVar);
    }
}
