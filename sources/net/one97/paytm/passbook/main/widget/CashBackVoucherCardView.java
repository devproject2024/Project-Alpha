package net.one97.paytm.passbook.main.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.passbook.R;

public final class CashBackVoucherCardView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    public View f57832a;

    /* renamed from: b  reason: collision with root package name */
    private HashMap f57833b;

    public final View a(int i2) {
        if (this.f57833b == null) {
            this.f57833b = new HashMap();
        }
        View view = (View) this.f57833b.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f57833b.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final View getMView() {
        View view = this.f57832a;
        if (view == null) {
            k.a("mView");
        }
        return view;
    }

    public final void setMView(View view) {
        k.c(view, "<set-?>");
        this.f57832a = view;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CashBackVoucherCardView(Context context) {
        super(context, (AttributeSet) null);
        k.c(context, "context");
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.pass_cb_voucher_card_view, this, false);
        k.a((Object) inflate, "LayoutInflater.from(cont…late(layout, this, false)");
        this.f57832a = inflate;
        removeAllViews();
        View view = this.f57832a;
        if (view == null) {
            k.a("mView");
        }
        addView(view);
    }
}
