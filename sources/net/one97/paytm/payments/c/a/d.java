package net.one97.paytm.payments.c.a;

import com.business.merchant_payments.common.utility.AppConstants;
import kotlin.g.b.k;
import net.one97.paytm.phoenix.api.H5Event;
import net.one97.paytm.phoenix.api.b;
import net.one97.paytm.phoenix.core.a;
import org.json.JSONObject;

public final class d extends a {
    public d() {
        super("bankRSAencrypt");
    }

    public final boolean a(H5Event h5Event, b bVar) {
        k.c(h5Event, AppConstants.NOTIFICATION_DETAILS.EVENT);
        k.c(bVar, "bridgeContext");
        super.a(h5Event, bVar);
        b(h5Event, bVar);
        JSONObject params = h5Event.getParams();
        String string = params != null ? params.getString("payLoad") : null;
        net.one97.paytm.bankCommon.utils.d.b();
        a.a(this, h5Event, com.paytm.e.a.b.a(net.one97.paytm.bankCommon.utils.d.N(), string), false, 4);
        return true;
    }
}
