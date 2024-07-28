package net.one97.paytm.nativesdk.paymethods.views.fragments;

import androidx.lifecycle.z;
import java.util.List;
import net.one97.paytm.nativesdk.paymethods.model.PaymentInstrumentView;

final class InstrumentsSheet$onCreateView$10<T> implements z<List<? extends PaymentInstrumentView>> {
    final /* synthetic */ InstrumentsSheet this$0;

    InstrumentsSheet$onCreateView$10(InstrumentsSheet instrumentsSheet) {
        this.this$0 = instrumentsSheet;
    }

    public final void onChanged(List<? extends PaymentInstrumentView> list) {
        if (list != null) {
            this.this$0.inflatePaymentInstruments(list);
        }
    }
}
