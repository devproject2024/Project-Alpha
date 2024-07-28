package net.one97.paytm.nativesdk.paymethods.views.fragments;

import android.view.View;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.nativesdk.Utils.SDKUtility;
import net.one97.paytm.nativesdk.common.view.BankOffersBottomSheet;

final class InstrumentsSheet$fetchAllPaymentOffers$1 implements View.OnClickListener {
    final /* synthetic */ InstrumentsSheet this$0;

    InstrumentsSheet$fetchAllPaymentOffers$1(InstrumentsSheet instrumentsSheet) {
        this.this$0 = instrumentsSheet;
    }

    public final void onClick(View view) {
        BankOffersBottomSheet access$getBankOffersBottomSheet$p;
        BankOffersBottomSheet access$getBankOffersBottomSheet$p2 = this.this$0.bankOffersBottomSheet;
        if (!(access$getBankOffersBottomSheet$p2 == null || !access$getBankOffersBottomSheet$p2.isAdded() || (access$getBankOffersBottomSheet$p = this.this$0.bankOffersBottomSheet) == null)) {
            access$getBankOffersBottomSheet$p.dismissAllowingStateLoss();
        }
        BankOffersBottomSheet access$getBankOffersBottomSheet$p3 = this.this$0.bankOffersBottomSheet;
        if (access$getBankOffersBottomSheet$p3 != null) {
            access$getBankOffersBottomSheet$p3.show(this.this$0.getChildFragmentManager(), "BankOffersSheet");
        }
        if (SDKUtility.isAppInvokeFlow()) {
            SDKUtility.sendGaEvents(SDKUtility.getAllInOneEventParamsBO(SDKConstants.AI_BO_STRIP_CLICKED, ""));
        }
    }
}
