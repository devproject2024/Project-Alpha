package net.one97.paytm.recharge.legacy.catalog.fragment;

import java.util.HashMap;
import java.util.Map;
import kotlin.x;
import net.one97.paytm.recharge.widgets.c.b;

@Deprecated
public abstract class a extends b {
    /* access modifiers changed from: protected */
    public abstract String q();

    /* access modifiers changed from: protected */
    public void p() {
        b.a(new kotlin.g.a.a() {
            public final Object invoke() {
                return a.this.a();
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ x a() {
        HashMap hashMap = new HashMap();
        hashMap.put("recharge_utilities_service_type", q());
        hashMap.put("user_id", com.paytm.utility.b.n(getContext()));
        hashMap.put("service_type", q());
        net.one97.paytm.recharge.di.helper.b bVar = net.one97.paytm.recharge.di.helper.b.f62652a;
        net.one97.paytm.recharge.di.helper.b.a("automatic_bill_payment_top_strip_clicked", (Map<String, ? extends Object>) hashMap, getContext());
        return null;
    }
}
