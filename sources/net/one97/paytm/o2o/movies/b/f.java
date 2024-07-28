package net.one97.paytm.o2o.movies.b;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ProgressBar;
import net.one97.paytm.common.entity.shopping.CJROrderSummary;
import net.one97.paytm.common.entity.shopping.CJROrderedCart;
import net.one97.paytm.m;
import net.one97.paytm.o2o.movies.common.c.b;
import net.one97.paytm.upi.util.UpiConstants;

public final class f implements m {

    /* renamed from: a  reason: collision with root package name */
    private Activity f74937a;

    /* renamed from: b  reason: collision with root package name */
    private ProgressBar f74938b;

    /* renamed from: c  reason: collision with root package name */
    private CJROrderSummary f74939c;

    public f(Activity activity, ProgressBar progressBar) {
        this.f74937a = activity;
        this.f74938b = progressBar;
    }

    public final void a(CJROrderSummary cJROrderSummary) {
        this.f74939c = cJROrderSummary;
        CJROrderSummary cJROrderSummary2 = this.f74939c;
        if (cJROrderSummary2 != null) {
            CJROrderedCart cJROrderedCart = cJROrderSummary2.getOrderedCartList().get(0);
            cJROrderedCart.setOrderId(this.f74939c.getId());
            Bundle bundle = new Bundle();
            bundle.putSerializable(UpiConstants.INTENT_EXTRA_CST_ORDER_ITEM, cJROrderedCart);
            b.f75032a.f75033b.openCSTscreen(this.f74937a, bundle, this);
        }
    }

    public final void show() {
        ProgressBar progressBar = this.f74938b;
        if (progressBar != null) {
            progressBar.setVisibility(0);
        }
    }

    public final void dismiss() {
        ProgressBar progressBar = this.f74938b;
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
    }
}
