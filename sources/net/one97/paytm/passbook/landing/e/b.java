package net.one97.paytm.passbook.landing.e;

import android.text.TextUtils;
import android.view.View;
import kotlin.g.b.k;
import net.one97.paytm.passbook.d;
import net.one97.paytm.passbook.utility.q;

public final class b extends a {

    public static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public static final a f57637a = new a();

        a() {
        }

        public final void onClick(View view) {
            k.a((Object) view, "it");
            q.a(view.getContext(), "uth_passbook", "loyalty_rewards_clicked", (String) null, (String) null, "/uth_passbook_myaccounts", "PASSBOOK");
            String a2 = d.b().a("pass2LoyaltyH5URL");
            if (!TextUtils.isEmpty(a2)) {
                d.b().d(a2);
            }
        }
    }
}
