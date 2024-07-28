package net.one97.paytm.h;

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
    static final /* synthetic */ i[] f50528a;

    /* renamed from: b  reason: collision with root package name */
    public static final d f50529b = new d();

    /* renamed from: c  reason: collision with root package name */
    private static c f50530c;

    /* renamed from: d  reason: collision with root package name */
    private static final g f50531d = h.a(b.INSTANCE);

    /* renamed from: e  reason: collision with root package name */
    private static final g f50532e = h.a(a.INSTANCE);

    static {
        Class<d> cls = d.class;
        f50528a = new i[]{y.a((v) new w(y.b(cls), "mGTMLoader", "getMGTMLoader()Lnet/one97/paytm/di/IJRGTMHelper;")), y.a((v) new w(y.b(cls), "mActivityHelper", "getMActivityHelper()Lnet/one97/paytm/di/IJRActivityNavigationHelper;"))};
    }

    private d() {
    }

    public static final /* synthetic */ c c() {
        c cVar = f50530c;
        if (cVar == null) {
            k.a("mIJRDependencyHelper");
        }
        return cVar;
    }

    static final class b extends l implements kotlin.g.a.a<b> {
        public static final b INSTANCE = new b();

        b() {
            super(0);
        }

        public final b invoke() {
            d dVar = d.f50529b;
            c c2 = d.c();
            if (c2 != null) {
                return c2;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.di.IJRGTMHelper");
        }
    }

    static final class a extends l implements kotlin.g.a.a<a> {
        public static final a INSTANCE = new a();

        a() {
            super(0);
        }

        public final a invoke() {
            d dVar = d.f50529b;
            c c2 = d.c();
            if (c2 != null) {
                return c2;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.di.IJRActivityNavigationHelper");
        }
    }

    public static void a(c cVar) {
        k.c(cVar, "mIJRDependencyHelper");
        f50530c = cVar;
    }

    public static final b a() {
        return (b) f50531d.getValue();
    }

    public static final a b() {
        return (a) f50532e.getValue();
    }
}
