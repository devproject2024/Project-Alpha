package net.one97.paytm.prime.g;

import android.content.Context;
import android.text.TextUtils;
import androidx.databinding.i;
import net.one97.paytm.common.entity.shopping.CJROrderSummary;
import net.one97.paytm.common.entity.shopping.CJROrderedCart;
import net.one97.paytm.prime.R;
import net.one97.paytm.prime.e.d;

public final class c extends a {

    /* renamed from: a  reason: collision with root package name */
    public d f59805a;

    /* renamed from: b  reason: collision with root package name */
    public i<String> f59806b;

    /* renamed from: c  reason: collision with root package name */
    public i<String> f59807c;

    /* renamed from: d  reason: collision with root package name */
    public i<String> f59808d;

    /* renamed from: e  reason: collision with root package name */
    public i<String> f59809e;

    /* renamed from: f  reason: collision with root package name */
    public i<String> f59810f;

    /* renamed from: g  reason: collision with root package name */
    private Context f59811g = a();

    public c(CJROrderSummary cJROrderSummary, d dVar) {
        this.f59805a = dVar;
        this.f59808d = new i<>();
        this.f59807c = new i<>();
        this.f59806b = new i<>();
        this.f59809e = new i<>();
        this.f59810f = new i<>();
        if (cJROrderSummary.getOrderedCartList() != null && cJROrderSummary.getOrderedCartList().size() > 0) {
            CJROrderedCart cJROrderedCart = cJROrderSummary.getOrderedCartList().get(0);
            this.f59808d.set(TextUtils.isEmpty(cJROrderedCart.getStatus()) ? cJROrderedCart.getStatusText() : cJROrderedCart.getStatus());
            this.f59806b.set(this.f59811g.getString(R.string.prime_rs, new Object[]{String.valueOf(cJROrderedCart.getPrice())}));
            this.f59810f.set(cJROrderedCart.getName());
        }
        this.f59807c.set(cJROrderSummary.getId());
        this.f59807c.set(this.f59811g.getString(R.string.prime_order_id, new Object[]{cJROrderSummary.getId()}));
    }
}
