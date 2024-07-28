package com.travel.bus.orders.g;

import android.content.Context;
import com.paytm.network.model.IJRPaytmDataModel;
import com.travel.bus.a.d;
import com.travel.bus.orders.f.c;
import com.travel.bus.pojo.common.entity.shopping.CJRBusImageData;
import com.travel.bus.pojo.common.entity.shopping.CJRBusOrderSummaryCancellation;

public final class b implements d, com.travel.bus.orders.f.b {

    /* renamed from: a  reason: collision with root package name */
    private final Context f22641a;

    /* renamed from: b  reason: collision with root package name */
    private c f22642b;

    public b(Context context) {
        this.f22641a = context;
    }

    public final void a(c cVar) {
        this.f22642b = cVar;
    }

    public final void b() {
        this.f22642b = null;
    }

    public final void a(IJRPaytmDataModel iJRPaytmDataModel) {
        c cVar = this.f22642b;
        if (cVar != null) {
            if (iJRPaytmDataModel instanceof CJRBusImageData) {
                ((CJRBusImageData) iJRPaytmDataModel).getBody();
            } else if (iJRPaytmDataModel instanceof CJRBusOrderSummaryCancellation) {
                cVar.a((CJRBusOrderSummaryCancellation) iJRPaytmDataModel);
            }
        }
    }

    public final void a() {
        this.f22642b.f();
    }
}
