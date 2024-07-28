package net.one97.paytm.nativesdk.paymethods.views.fragments;

import android.view.View;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.Utils.SDKUtility;

final class AppInvokeSheet$fetchAllPaymentOffers$2 implements View.OnClickListener {
    final /* synthetic */ AppInvokeSheet this$0;

    AppInvokeSheet$fetchAllPaymentOffers$2(AppInvokeSheet appInvokeSheet) {
        this.this$0 = appInvokeSheet;
    }

    public final void onClick(View view) {
        AppInvokeSheet.access$getMIvShowOfferArrow$p(this.this$0).performClick();
        if (SDKUtility.isAppInvokeFlow()) {
            SDKUtility.sendGaEvents(SDKUtility.getAllInOneEventParamsBO(SDKConstants.AI_BO_STRIP_CLICKED, ""));
        }
    }
}
