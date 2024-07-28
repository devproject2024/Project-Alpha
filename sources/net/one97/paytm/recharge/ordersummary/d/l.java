package net.one97.paytm.recharge.ordersummary.d;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.shopping.CJROrderedCart;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.ordersummary.b.a;

public final class l extends d {

    /* renamed from: h  reason: collision with root package name */
    private HashMap f64168h;

    public final View a(int i2) {
        if (this.f64168h == null) {
            this.f64168h = new HashMap();
        }
        View view = (View) this.f64168h.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f64168h.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void d() {
        HashMap hashMap = this.f64168h;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        d();
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.content_order_details_my_pay, viewGroup, false);
    }

    /* access modifiers changed from: protected */
    public final void a(View view, Bundle bundle) {
        k.c(view, "view");
        super.a(view, bundle);
        TextView textView = (TextView) view.findViewById(R.id.recharge_amount);
        k.a((Object) textView, "rechargeAmount");
        a e2 = e();
        Context context = view.getContext();
        k.a((Object) context, "view.context");
        CJROrderedCart u = e().u();
        if (u == null) {
            k.a();
        }
        textView.setText(e2.g(context, u));
        b();
    }

    /* access modifiers changed from: protected */
    public final void c() {
        b();
    }
}
