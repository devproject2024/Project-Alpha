package net.one97.paytm.recharge.coupons.e;

import androidx.lifecycle.ai;
import androidx.lifecycle.y;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.shopping.CJRGridProduct;

public final class b extends ai {

    /* renamed from: a  reason: collision with root package name */
    public y<c<CJRGridProduct>> f62289a = new y<>();

    /* renamed from: b  reason: collision with root package name */
    public y<CJRGridProduct> f62290b = new y<>();

    /* renamed from: c  reason: collision with root package name */
    public y<CJRGridProduct> f62291c = new y<>();

    /* renamed from: d  reason: collision with root package name */
    public boolean f62292d;

    public final void a(c<CJRGridProduct> cVar) {
        k.c(cVar, "dealsModel");
        this.f62289a.setValue(cVar);
    }

    public final void a(CJRGridProduct cJRGridProduct) {
        k.c(cJRGridProduct, "dealsModel");
        this.f62290b.setValue(cJRGridProduct);
    }
}
