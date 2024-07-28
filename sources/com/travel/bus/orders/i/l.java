package com.travel.bus.orders.i;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.paytm.utility.q;
import com.travel.bus.R;
import com.travel.bus.orders.activity.BusOrderSummary;
import com.travel.bus.orders.c.c;
import com.travel.bus.orders.e.a;
import com.travel.bus.orders.h.b;
import com.travel.bus.pojo.busticket.CJRBusOrderSummary;
import com.travel.cdn.ResourceUtils;
import com.travel.utils.n;
import java.util.Iterator;
import net.one97.paytm.common.entity.busticket.CJRBusOrderedCart;

public final class l extends a {

    /* renamed from: a  reason: collision with root package name */
    private CJRBusOrderSummary f22750a;

    /* renamed from: b  reason: collision with root package name */
    private Context f22751b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f22752c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f22753d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f22754e;

    /* renamed from: f  reason: collision with root package name */
    private AppCompatImageView f22755f;

    /* renamed from: g  reason: collision with root package name */
    private BusOrderSummary.a f22756g;

    public l(View view, CJRBusOrderSummary cJRBusOrderSummary, BusOrderSummary.a aVar) {
        super(view);
        this.f22751b = view.getContext();
        this.f22756g = aVar;
        this.f22755f = (AppCompatImageView) view.findViewById(R.id.cashback_img);
        ResourceUtils.loadBusImagesFromCDN(this.f22755f, "cashback.png", false, false, n.a.V1);
        this.f22752c = (TextView) view.findViewById(R.id.cashback_value);
        this.f22754e = (TextView) view.findViewById(R.id.cashback_text);
        this.f22753d = (TextView) view.findViewById(R.id.cashback_desc);
        this.f22750a = cJRBusOrderSummary;
    }

    public final void a(c.b bVar) {
        if (this.f22750a != null) {
            try {
                if (this.f22756g == BusOrderSummary.a.BUS && this.f22750a != null) {
                    String str = null;
                    double d2 = 0.0d;
                    Iterator<CJRBusOrderedCart> it2 = this.f22750a.getOrderedCartList().iterator();
                    while (it2.hasNext()) {
                        CJRBusOrderedCart next = it2.next();
                        if (b.b(next)) {
                            if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(next.getPromoCode())) {
                                str = next.getPromoCode().toUpperCase();
                            }
                            d2 += next.getTotalCashBack();
                        }
                    }
                    if (bVar == c.b.PAYMENT_FAILED) {
                        if (!TextUtils.isEmpty(str)) {
                            this.f22753d.setText(String.format("%s %s", new Object[]{str.toUpperCase(), this.f22751b.getString(R.string.promocode_unused)}));
                            this.f22752c.setText(String.format("%s %s", new Object[]{str.toUpperCase(), this.f22751b.getString(R.string.promocode)}));
                            this.f22754e.setVisibility(8);
                            return;
                        }
                    }
                    this.f22752c.setText(String.format("%s %s", new Object[]{this.f22751b.getString(R.string.rs_symbol), String.valueOf((int) d2)}));
                    SpannableString valueOf = SpannableString.valueOf(str + " " + this.f22751b.getString(R.string.promo_text_bus));
                    valueOf.setSpan(new StyleSpan(1), 0, str.length(), 33);
                    this.f22753d.setText(valueOf);
                }
            } catch (Exception e2) {
                q.c(e2.getMessage());
            }
        }
    }
}
