package net.one97.paytm.nativesdk.paymethods.views.fragments;

import com.google.android.material.bottomsheet.b;
import net.one97.paytm.nativesdk.app.PaytmSDKRequestClient;

final class InstrumentsSheet$showOrderDetails$1 implements PaytmSDKRequestClient.ShowOrderInfoFragment {
    final /* synthetic */ InstrumentsSheet this$0;

    InstrumentsSheet$showOrderDetails$1(InstrumentsSheet instrumentsSheet) {
        this.this$0 = instrumentsSheet;
    }

    public final void showFragment(b bVar) {
        if (bVar != null) {
            bVar.show(this.this$0.getChildFragmentManager(), "ORDER_DETAIL_TAG");
        }
    }
}
