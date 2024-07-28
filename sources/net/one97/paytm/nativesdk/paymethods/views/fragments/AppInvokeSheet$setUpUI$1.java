package net.one97.paytm.nativesdk.paymethods.views.fragments;

import android.view.View;
import java.util.Collection;
import java.util.List;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.Utils.SDKUtility;

final class AppInvokeSheet$setUpUI$1 implements View.OnClickListener {
    final /* synthetic */ AppInvokeSheet this$0;

    AppInvokeSheet$setUpUI$1(AppInvokeSheet appInvokeSheet) {
        this.this$0 = appInvokeSheet;
    }

    public final void onClick(View view) {
        Collection access$getOtherInstruments$p = this.this$0.otherInstruments;
        if (access$getOtherInstruments$p != null && (!access$getOtherInstruments$p.isEmpty())) {
            List list = (List) access$getOtherInstruments$p;
            if (SDKUtility.isAppInvokeFlow()) {
                SDKUtility.sendGaEvents(SDKUtility.getAllInOneEventParams(SDKConstants.AI_OTHER_PAYMODE_SELECTED, ""));
            }
            this.this$0.allInstrumentsVisible = true;
            View access$getOtherPayments$p = this.this$0.otherPayments;
            if (access$getOtherPayments$p != null) {
                access$getOtherPayments$p.setVisibility(8);
            }
            this.this$0.inflatePaymentInstruments(list);
        }
    }
}
