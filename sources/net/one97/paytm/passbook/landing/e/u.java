package net.one97.paytm.passbook.landing.e;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import kotlin.g.b.k;
import net.one97.paytm.passbook.d;
import net.one97.paytm.passbook.mapping.f;
import net.one97.paytm.passbook.utility.q;

public final class u extends a {

    public static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ net.one97.paytm.passbook.landing.f.a f57694a;

        public a(net.one97.paytm.passbook.landing.f.a aVar) {
            this.f57694a = aVar;
        }

        public final void onClick(View view) {
            k.a((Object) view, "it");
            q.a(view.getContext(), "uth_passbook", "postpaid_clicked", "open_account", (String) null, "/uth_passbook_myaccounts", "PASSBOOK");
            f b2 = d.b();
            Context context = this.f57694a.s().getContext();
            if (context != null) {
                b2.a("paytmmp://paytm-postpaid?url=landing", (Activity) context);
                return;
            }
            throw new kotlin.u("null cannot be cast to non-null type android.app.Activity");
        }
    }
}
