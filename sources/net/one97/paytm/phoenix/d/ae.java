package net.one97.paytm.phoenix.d;

import android.app.Activity;
import com.alipay.mobile.h5container.api.H5Param;
import com.business.merchant_payments.common.utility.AppConstants;
import kotlin.g.b.k;
import net.one97.paytm.phoenix.api.H5Event;
import net.one97.paytm.phoenix.api.b;
import net.one97.paytm.phoenix.core.a;
import net.one97.paytm.phoenix.ui.PhoenixActivity;
import net.one97.paytm.phoenix.util.j;

public final class ae extends a {
    public ae() {
        super(H5Param.DEFAULT_LONG_BACK_BEHAVIOR);
    }

    public final boolean a(H5Event h5Event, b bVar) {
        k.c(h5Event, AppConstants.NOTIFICATION_DETAILS.EVENT);
        k.c(bVar, "bridgeContext");
        super.a(h5Event, bVar);
        j jVar = j.f59646a;
        j.a("PhoenixErrorBackPlugin", "handleEvent");
        Activity activity = h5Event.getActivity();
        if (activity == null || !(activity instanceof PhoenixActivity)) {
            return true;
        }
        b bVar2 = new b(h5Event.getCallbackId(), k.a((Object) "subscribe", (Object) h5Event.getMsgType()));
        k.c(bVar2, "errorCallback");
        ((PhoenixActivity) activity).f59603a = bVar2;
        return true;
    }
}
