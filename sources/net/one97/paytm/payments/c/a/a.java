package net.one97.paytm.payments.c.a;

import android.os.Bundle;
import com.business.merchant_payments.common.utility.AppConstants;
import kotlin.g.b.k;
import net.one97.paytm.paymentsBank.utils.l;
import net.one97.paytm.paymentsBank.utils.o;
import net.one97.paytm.phoenix.api.H5Event;
import net.one97.paytm.phoenix.api.b;

public final class a extends net.one97.paytm.phoenix.core.a implements net.one97.paytm.payments.c.c.a {

    /* renamed from: a  reason: collision with root package name */
    private H5Event f17209a;

    public a() {
        super("activateATM");
    }

    public final boolean a(H5Event h5Event, b bVar) {
        k.c(h5Event, AppConstants.NOTIFICATION_DETAILS.EVENT);
        k.c(bVar, "bridgeContext");
        super.a(h5Event, bVar);
        this.f17209a = h5Event;
        b(h5Event, bVar);
        l a2 = l.a();
        k.a((Object) a2, "PDCSingletonHolder.getInstance()");
        a2.a((net.one97.paytm.payments.c.c.a) this);
        o.a().openPaySendActivityForActivatingPDC(h5Event.getActivity());
        return true;
    }

    public final void a(Bundle bundle) {
        l a2 = l.a();
        k.a((Object) a2, "PDCSingletonHolder.getInstance()");
        a2.a((net.one97.paytm.payments.c.c.a) null);
        H5Event h5Event = this.f17209a;
        if (h5Event == null) {
            k.a("ev");
        }
        net.one97.paytm.phoenix.core.a.a(this, h5Event, (Object) null, false, 6);
    }
}
