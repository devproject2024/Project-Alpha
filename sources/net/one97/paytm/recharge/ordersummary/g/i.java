package net.one97.paytm.recharge.ordersummary.g;

import kotlin.g.b.k;
import net.one97.paytm.recharge.ordersummary.d.n;
import net.one97.paytm.recharge.ordersummary.f.c;
import net.one97.paytm.recharge.ordersummary.f.m;

public final class i extends d {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public i(c cVar, m mVar) {
        super(cVar, mVar);
        k.c(cVar, "textRepository");
        k.c(mVar, "gtmEventListener");
    }

    public final String h() {
        String name = net.one97.paytm.recharge.ordersummary.d.m.class.getName();
        k.a((Object) name, "FJROTTOrderDetailsFragment::class.java.name");
        return name;
    }

    public final String f() {
        String name = n.class.getName();
        k.a((Object) name, "FJROTTStoreFrontFragment::class.java.name");
        return name;
    }
}
