package net.one97.paytm.prime.g;

import android.content.Context;
import androidx.databinding.i;
import net.one97.paytm.common.entity.shopping.CJROrderSummary;
import net.one97.paytm.common.entity.shopping.CJROrderedCart;
import net.one97.paytm.prime.R;
import net.one97.paytm.prime.e.c;

public final class b extends a {

    /* renamed from: a  reason: collision with root package name */
    public c f59798a;

    /* renamed from: b  reason: collision with root package name */
    public i<String> f59799b;

    /* renamed from: c  reason: collision with root package name */
    public i<String> f59800c;

    /* renamed from: d  reason: collision with root package name */
    public i<String> f59801d;

    /* renamed from: e  reason: collision with root package name */
    public i<String> f59802e;

    /* renamed from: f  reason: collision with root package name */
    public i<String> f59803f;

    /* renamed from: g  reason: collision with root package name */
    private Context f59804g = a();

    public b(CJROrderSummary cJROrderSummary, c cVar) {
        this.f59798a = cVar;
        this.f59801d = new i<>();
        this.f59800c = new i<>();
        this.f59799b = new i<>();
        this.f59802e = new i<>();
        this.f59803f = new i<>();
        if (cJROrderSummary.getOrderedCartList() != null && cJROrderSummary.getOrderedCartList().size() > 0) {
            CJROrderedCart cJROrderedCart = cJROrderSummary.getOrderedCartList().get(0);
            this.f59801d.set(cJROrderedCart.getStatusText());
            this.f59799b.set(this.f59804g.getString(R.string.prime_rs, new Object[]{String.valueOf(cJROrderedCart.getPrice())}));
            this.f59803f.set(cJROrderedCart.getName());
        }
        this.f59800c.set(this.f59804g.getString(R.string.prime_order_id, new Object[]{cJROrderSummary.getId()}));
    }
}
