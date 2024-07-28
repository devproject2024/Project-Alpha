package net.one97.paytm.payments.c.a;

import android.os.Bundle;
import com.business.merchant_payments.common.utility.AppConstants;
import com.paytm.utility.q;
import kotlin.g.b.k;
import net.one97.paytm.paymentsBank.utils.l;
import net.one97.paytm.paymentsBank.utils.o;
import net.one97.paytm.phoenix.api.H5Event;
import net.one97.paytm.phoenix.core.a;
import org.json.JSONObject;

public final class b extends a implements net.one97.paytm.payments.c.c.a {

    /* renamed from: a  reason: collision with root package name */
    private H5Event f17210a;

    public b() {
        super("bankAddMoney");
    }

    public final boolean a(H5Event h5Event, net.one97.paytm.phoenix.api.b bVar) {
        k.c(h5Event, AppConstants.NOTIFICATION_DETAILS.EVENT);
        k.c(bVar, "bridgeContext");
        super.a(h5Event, bVar);
        b(h5Event, bVar);
        this.f17210a = h5Event;
        JSONObject params = h5Event.getParams();
        String str = "paytmmp://cash_wallet?featuretype=bank_landing&amount=" + (params != null ? params.getString("amount") : null) + "&hide_isa_fd=true";
        l a2 = l.a();
        k.a((Object) a2, "PDCSingletonHolder.getInstance()");
        a2.a((net.one97.paytm.payments.c.c.a) this);
        o.a().checkDeepLink(h5Event.getActivity(), str);
        return true;
    }

    public final void a(Bundle bundle) {
        l a2 = l.a();
        k.a((Object) a2, "PDCSingletonHolder.getInstance()");
        a2.a((net.one97.paytm.payments.c.c.a) null);
        int i2 = bundle.getInt("status");
        q.d("bankAddMoneyPlugin ".concat(String.valueOf(i2)));
        a("status", (Object) Integer.valueOf(i2));
        H5Event h5Event = this.f17210a;
        if (h5Event == null) {
            k.a("ev");
        }
        a.a(this, h5Event, (Object) null, false, 6);
    }
}
