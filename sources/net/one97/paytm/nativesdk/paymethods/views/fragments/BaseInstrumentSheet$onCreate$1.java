package net.one97.paytm.nativesdk.paymethods.views.fragments;

import net.one97.paytm.nativesdk.instruments.InstrumentCallback;
import net.one97.paytm.nativesdk.instruments.PaytmBaseView;

public final class BaseInstrumentSheet$onCreate$1 implements InstrumentCallback {
    final /* synthetic */ BaseInstrumentSheet this$0;

    BaseInstrumentSheet$onCreate$1(BaseInstrumentSheet baseInstrumentSheet) {
        this.this$0 = baseInstrumentSheet;
    }

    public final void instrumentSelected(PaytmBaseView paytmBaseView) {
        if (!this.this$0.isAdded()) {
            return;
        }
        if (paytmBaseView != null) {
            paytmBaseView.openAutoInstrument();
        } else {
            this.this$0.showHiddenInstruments();
        }
    }
}
