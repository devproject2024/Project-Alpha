package net.one97.paytm.prime.d;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.f;
import net.one97.paytm.common.entity.shopping.CJROrderSummary;
import net.one97.paytm.common.entity.shopping.CJROrderedCart;
import net.one97.paytm.prime.R;
import net.one97.paytm.prime.activity.PrimeLoaderActivity;
import net.one97.paytm.prime.b.a;
import net.one97.paytm.prime.e.c;
import net.one97.paytm.upi.util.UpiConstants;

public class b extends a implements c {

    /* renamed from: a  reason: collision with root package name */
    private net.one97.paytm.prime.c.c f59776a;

    /* renamed from: b  reason: collision with root package name */
    private net.one97.paytm.prime.g.b f59777b;

    /* renamed from: c  reason: collision with root package name */
    private PrimeLoaderActivity f59778c;

    /* renamed from: d  reason: collision with root package name */
    private CJROrderSummary f59779d;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f59776a = (net.one97.paytm.prime.c.c) f.a(layoutInflater, R.layout.fragment_lyt_prime_subscription_failure, viewGroup, false);
        if (getArguments() != null) {
            this.f59779d = (CJROrderSummary) getArguments().getSerializable(net.one97.paytm.prime.f.b.f59790b);
            CJROrderSummary cJROrderSummary = this.f59779d;
            if (cJROrderSummary != null) {
                this.f59777b = new net.one97.paytm.prime.g.b(cJROrderSummary, this);
                this.f59776a.a(this.f59777b);
            }
        }
        return this.f59776a.getRoot();
    }

    public final void a() {
        this.f59778c.finish();
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        this.f59778c = (PrimeLoaderActivity) context;
    }

    public final void b() {
        CJROrderSummary cJROrderSummary = this.f59779d;
        if (cJROrderSummary == null || cJROrderSummary.getOrderedCartList() == null || this.f59779d.getOrderedCartList().size() <= 0) {
            a.a().b(this.f59778c);
            return;
        }
        Bundle bundle = new Bundle();
        CJROrderedCart cJROrderedCart = this.f59779d.getOrderedCartList().get(0);
        cJROrderedCart.setOrderId(this.f59779d.getId());
        cJROrderedCart.setCreatedAt(this.f59779d.getCreatedAt());
        bundle.putSerializable(UpiConstants.INTENT_EXTRA_CST_ORDER_ITEM, cJROrderedCart);
        bundle.putLong("intent_flag", 67108864);
        a.a().a((Activity) this.f59778c, bundle);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a.a().a("/prime/failure", net.one97.paytm.prime.f.b.f59791c, (Activity) this.f59778c);
    }
}
