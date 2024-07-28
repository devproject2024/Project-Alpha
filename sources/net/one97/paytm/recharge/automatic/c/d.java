package net.one97.paytm.recharge.automatic.c;

import android.content.Context;
import kotlin.g;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.g.b.v;
import kotlin.g.b.w;
import kotlin.g.b.y;
import kotlin.h;
import kotlin.k.i;
import kotlin.u;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ i[] f60260a = {y.a((v) new w(y.b(d.class), "mGTMLoader", "getMGTMLoader()Lnet/one97/paytm/recharge/automatic/di/IJRAutomaticRechargeGTMHelper;"))};

    /* renamed from: b  reason: collision with root package name */
    public static final g f60261b = h.a(a.INSTANCE);

    /* renamed from: c  reason: collision with root package name */
    public static final d f60262c = new d();

    /* renamed from: d  reason: collision with root package name */
    private static c f60263d;

    private d() {
    }

    public static final /* synthetic */ c c() {
        c cVar = f60263d;
        if (cVar == null) {
            k.a("mIJRAutomaticDependency");
        }
        return cVar;
    }

    static final class a extends l implements kotlin.g.a.a<b> {
        public static final a INSTANCE = new a();

        a() {
            super(0);
        }

        public final b invoke() {
            d dVar = d.f60262c;
            c c2 = d.c();
            if (c2 != null) {
                return (b) c2;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.automatic.di.IJRAutomaticRechargeGTMHelper");
        }
    }

    public static void a(a aVar) {
        k.c(aVar, "ijrAutomaticComponent");
        f60263d = aVar;
        b();
    }

    public static c a() {
        c cVar = f60263d;
        if (cVar == null) {
            k.a("mIJRAutomaticDependency");
        }
        return cVar;
    }

    public static Context b() {
        c cVar = f60263d;
        if (cVar == null) {
            k.a("mIJRAutomaticDependency");
        }
        return cVar.a();
    }
}
