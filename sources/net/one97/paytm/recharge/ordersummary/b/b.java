package net.one97.paytm.recharge.ordersummary.b;

import androidx.lifecycle.ai;
import androidx.lifecycle.al;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.CJRRechargeCart;
import net.one97.paytm.recharge.ordersummary.f.j;

public final class b implements al.b {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f64015a;

    /* renamed from: b  reason: collision with root package name */
    private final CJRRechargeCart f64016b;

    /* renamed from: c  reason: collision with root package name */
    private final net.one97.paytm.recharge.ordersummary.b.a.b f64017c;

    /* renamed from: d  reason: collision with root package name */
    private final j f64018d;

    public b(boolean z, CJRRechargeCart cJRRechargeCart, net.one97.paytm.recharge.ordersummary.b.a.b bVar, j jVar) {
        k.c(bVar, "dataRepository");
        k.c(jVar, "layoutRespository");
        this.f64015a = z;
        this.f64016b = cJRRechargeCart;
        this.f64017c = bVar;
        this.f64018d = jVar;
    }

    public final <T extends ai> T create(Class<T> cls) {
        k.c(cls, "modelClass");
        return (ai) new a(this.f64015a, this.f64016b, this.f64017c, this.f64018d);
    }
}
