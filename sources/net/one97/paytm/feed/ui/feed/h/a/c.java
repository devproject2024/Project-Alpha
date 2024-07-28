package net.one97.paytm.feed.ui.feed.h.a;

import android.view.View;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.k;
import net.one97.paytm.feed.a;
import net.one97.paytm.feed.b.aq;
import net.one97.paytm.feed.repository.models.merchantdeal.FeedMerchant;
import net.one97.paytm.feed.ui.base.b;

public final class c extends b<aq, FeedMerchant, a> {

    /* renamed from: b  reason: collision with root package name */
    private b f35065b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(View view) {
        super(view);
        k.c(view, "view");
    }

    public final void a(a aVar, int i2) {
        k.c(aVar, "viewModel");
        aq aqVar = (aq) this.f34872a;
        aqVar.setVariable(a.f33777d, aVar);
        aqVar.setVariable(a.f33780g, aVar.f34253c);
        aqVar.setVariable(a.f33778e, Integer.valueOf(i2));
        aqVar.setVariable(a.m, 0);
        if (this.f35065b == null) {
            this.f35065b = new b();
            aqVar.setVariable(a.f33775b, this.f35065b);
        }
        for (Map.Entry entry : new HashMap().entrySet()) {
            aqVar.setVariable(((Number) entry.getKey()).intValue(), entry.getValue());
        }
        ((aq) this.f34872a).executePendingBindings();
    }
}
