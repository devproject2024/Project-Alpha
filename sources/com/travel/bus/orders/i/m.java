package com.travel.bus.orders.i;

import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.paytm.utility.q;
import com.travel.bus.R;
import com.travel.bus.orders.activity.BusOrderSummary;
import com.travel.bus.orders.c.c;
import com.travel.bus.orders.d.b;
import com.travel.bus.orders.e.a;
import com.travel.bus.pojo.busticket.CJRBusOrderSummary;

public final class m extends a {

    /* renamed from: a  reason: collision with root package name */
    public boolean f22757a = false;

    /* renamed from: b  reason: collision with root package name */
    BusOrderSummary.a f22758b;

    /* renamed from: c  reason: collision with root package name */
    private CJRBusOrderSummary f22759c;

    /* renamed from: d  reason: collision with root package name */
    private com.travel.bus.orders.f.a f22760d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f22761e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f22762f;

    /* renamed from: g  reason: collision with root package name */
    private RelativeLayout f22763g;

    /* renamed from: h  reason: collision with root package name */
    private b f22764h;

    /* renamed from: i  reason: collision with root package name */
    private c.b f22765i;
    private net.one97.paytm.m j;

    public m(View view, CJRBusOrderSummary cJRBusOrderSummary, com.travel.bus.orders.f.a aVar, BusOrderSummary.a aVar2, net.one97.paytm.m mVar) {
        super(view);
        this.f22758b = aVar2;
        this.f22761e = (TextView) view.findViewById(R.id.paytm_trust_text);
        this.f22762f = (TextView) view.findViewById(R.id.paytm_contact_us);
        this.f22759c = cJRBusOrderSummary;
        this.f22760d = aVar;
        this.f22763g = (RelativeLayout) view.findViewById(R.id.contact_us_layout);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f22763g.getLayoutParams();
        int applyDimension = (int) TypedValue.applyDimension(1, 5.0f, this.f22760d.c().getResources().getDisplayMetrics());
        layoutParams.setMarginStart(applyDimension);
        layoutParams.setMarginEnd(applyDimension);
        this.f22763g.setLayoutParams(layoutParams);
        this.j = mVar;
    }

    public final void a(c.b bVar) {
        if (this.f22759c != null) {
            this.f22765i = bVar;
            try {
                this.f22761e.setText(R.string.paytm_trust_text);
                if (this.f22758b == BusOrderSummary.a.BUS) {
                    String string = this.f22762f.getContext().getString(R.string.contact_us_24_7_text_bus);
                    this.f22762f.setTextSize(0, this.f22762f.getContext().getResources().getDimension(R.dimen.dimen_13sp));
                    this.f22762f.setText(string);
                }
                this.f22762f.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        m.this.a(view);
                    }
                });
            } catch (Exception e2) {
                q.c(e2.getMessage());
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        if (!this.f22757a) {
            this.f22757a = true;
            this.f22764h = new b(this.itemView.getContext(), this.f22759c, this.f22765i, this.j);
            this.f22764h.a();
            CJRBusOrderSummary cJRBusOrderSummary = this.f22759c;
            if (cJRBusOrderSummary != null && cJRBusOrderSummary.getOrderedCartList() != null && this.f22759c.getOrderedCartList().size() > 1) {
                this.f22757a = false;
            }
        }
    }
}
