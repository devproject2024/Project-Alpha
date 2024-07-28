package net.one97.paytm.nativesdk.paymethods.views.fragments;

import android.view.View;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.Utils.SDKUtility;

final class InstrumentsSheet$fetchAllPaymentOffers$2 implements View.OnClickListener {
    final /* synthetic */ InstrumentsSheet this$0;

    InstrumentsSheet$fetchAllPaymentOffers$2(InstrumentsSheet instrumentsSheet) {
        this.this$0 = instrumentsSheet;
    }

    public final void onClick(View view) {
        InstrumentsSheet.access$getMIvShowOfferArrow$p(this.this$0).performClick();
        if (SDKUtility.isAppInvokeFlow()) {
            SDKUtility.sendGaEvents(SDKUtility.getAllInOneEventParamsBO(SDKConstants.AI_BO_STRIP_CLICKED, ""));
        }
    }
}
