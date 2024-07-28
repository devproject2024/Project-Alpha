package net.one97.paytm.payments.c.a;

import android.content.Context;
import com.business.merchant_payments.common.utility.AppConstants;
import kotlin.g.b.k;
import net.one97.paytm.paymentsBank.forgotpasscode.ForgotPasscodeChallengesActivity;
import net.one97.paytm.phoenix.api.H5Event;
import net.one97.paytm.phoenix.api.b;
import net.one97.paytm.phoenix.core.a;

public final class g extends a {
    public g() {
        super("openforgotPasscodeFlow");
    }

    public final boolean a(H5Event h5Event, b bVar) {
        k.c(h5Event, AppConstants.NOTIFICATION_DETAILS.EVENT);
        k.c(bVar, "bridgeContext");
        super.a(h5Event, bVar);
        b(h5Event, bVar);
        ForgotPasscodeChallengesActivity.a((Context) h5Event.getActivity());
        return true;
    }
}
