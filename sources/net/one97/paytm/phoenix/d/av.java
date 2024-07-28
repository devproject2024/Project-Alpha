package net.one97.paytm.phoenix.d;

import android.app.Activity;
import com.alipay.mobile.h5container.api.H5Plugin;
import com.business.merchant_payments.common.utility.AppConstants;
import kotlin.g.b.k;
import net.one97.paytm.phoenix.api.H5Event;
import net.one97.paytm.phoenix.api.b;
import net.one97.paytm.phoenix.core.a;
import net.one97.paytm.phoenix.ui.PhoenixActivity;
import net.one97.paytm.phoenix.util.j;

public final class av extends a {
    public av() {
        super(H5Plugin.CommonEvents.POP_WINDOW);
    }

    public final boolean a(H5Event h5Event, b bVar) {
        k.c(h5Event, AppConstants.NOTIFICATION_DETAILS.EVENT);
        k.c(bVar, "bridgeContext");
        super.a(h5Event, bVar);
        j jVar = j.f59646a;
        j.a("PhoenixPopWindowPlugin", "handleEvent");
        Activity activity = h5Event.getActivity();
        if (activity == null || !(activity instanceof PhoenixActivity)) {
            return true;
        }
        a("success", (Object) Boolean.TRUE);
        a.a(this, h5Event, (Object) null, false, 6);
        activity.finish();
        return true;
    }
}
