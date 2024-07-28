package com.travel.bus.orders.i;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.paytm.utility.b.b;
import com.travel.bus.R;
import com.travel.bus.orders.activity.BusOrderSummary;
import com.travel.bus.orders.c.c;
import com.travel.bus.orders.e.a;
import com.travel.bus.pojo.CJROfferItems;
import net.one97.paytm.common.entity.shopping.CJROrderSummaryAction;

public final class k extends a {

    /* renamed from: a  reason: collision with root package name */
    CJROfferItems f22745a;

    /* renamed from: b  reason: collision with root package name */
    BusOrderSummary.a f22746b;

    /* renamed from: c  reason: collision with root package name */
    ImageView f22747c;

    /* renamed from: d  reason: collision with root package name */
    private Context f22748d;

    /* renamed from: e  reason: collision with root package name */
    private com.travel.bus.orders.f.a f22749e;

    public k(Context context, View view, BusOrderSummary.a aVar, com.travel.bus.orders.f.a aVar2, CJROfferItems cJROfferItems) {
        super(view);
        this.f22748d = context;
        this.f22747c = (ImageView) view.findViewById(R.id.img_travel_buddy);
        this.f22745a = cJROfferItems;
        this.f22746b = aVar;
        this.f22749e = aVar2;
        this.f22747c.setVisibility(8);
    }

    public final void a(c.b bVar) {
        CJROfferItems cJROfferItems = this.f22745a;
        if (cJROfferItems != null && cJROfferItems.getmImageUrl() != null && !this.f22745a.getmImageUrl().isEmpty()) {
            b.a.C0750a a2 = b.a(this.f22748d);
            a2.f43753a = this.f22745a.getmImageUrl();
            b.a.C0750a b2 = a2.a((Object) Integer.valueOf(R.drawable.travel_res_bus_placeholder_icon)).b(Integer.valueOf(R.drawable.travel_res_bus_placeholder_icon));
            b2.m = true;
            b2.o = true;
            b.a.C0750a.a(b2, this.f22747c, (com.paytm.utility.b.b.b) null, 2);
            this.f22747c.setVisibility(0);
            this.f22747c.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    k.this.a(view);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        this.f22749e.a(com.travel.bus.orders.b.a.TRAVEL_BUDDY_BANNER_CLICK, (CJROrderSummaryAction) null);
    }
}
