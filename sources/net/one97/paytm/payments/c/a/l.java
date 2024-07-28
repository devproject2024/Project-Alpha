package net.one97.paytm.payments.c.a;

import android.app.Activity;
import com.business.merchant_payments.common.utility.AppConstants;
import kotlin.g.b.k;
import net.one97.paytm.phoenix.api.H5Event;
import net.one97.paytm.phoenix.api.b;
import net.one97.paytm.phoenix.core.a;

public final class l extends a {
    public l() {
        super("getProfileImageUrl");
    }

    public final boolean a(H5Event h5Event, b bVar) {
        k.c(h5Event, AppConstants.NOTIFICATION_DETAILS.EVENT);
        k.c(bVar, "bridgeContext");
        super.a(h5Event, bVar);
        b(h5Event, bVar);
        Activity activity = h5Event.getActivity();
        if (activity == null) {
            return false;
        }
        a.a(this, h5Event, com.paytm.utility.b.al(activity), false, 4);
        return true;
    }
}
