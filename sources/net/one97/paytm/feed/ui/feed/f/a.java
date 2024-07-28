package net.one97.paytm.feed.ui.feed.f;

import android.view.View;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.o;
import net.one97.paytm.feed.b.ae;
import net.one97.paytm.feed.repository.models.generic.FeedGeneric;
import net.one97.paytm.feed.ui.base.b;

public final class a extends b<ae, FeedGeneric, net.one97.paytm.feed.ui.feed.d.a> {

    /* renamed from: b  reason: collision with root package name */
    private net.one97.paytm.feed.ui.feed.a f35050b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(View view) {
        super(view);
        k.c(view, "view");
    }

    public final void a(FeedGeneric feedGeneric, int i2) {
        k.c(feedGeneric, "data");
        ae aeVar = (ae) this.f34872a;
        aeVar.setVariable(net.one97.paytm.feed.a.f33780g, feedGeneric);
        aeVar.setVariable(net.one97.paytm.feed.a.f33778e, Integer.valueOf(i2));
        if (this.f35050b == null) {
            this.f35050b = new net.one97.paytm.feed.ui.feed.a();
            aeVar.setVariable(net.one97.paytm.feed.a.f33775b, this.f35050b);
        }
        Integer valueOf = Integer.valueOf(net.one97.paytm.feed.a.t);
        net.one97.paytm.feed.e.b bVar = net.one97.paytm.feed.e.b.f34268c;
        for (Map.Entry entry : kotlin.a.ae.c(new o(valueOf, Boolean.valueOf(net.one97.paytm.feed.e.b.u()))).entrySet()) {
            aeVar.setVariable(((Number) entry.getKey()).intValue(), entry.getValue());
        }
        ((ae) this.f34872a).executePendingBindings();
    }
}
