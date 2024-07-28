package net.one97.paytm.nativesdk.paymethods.views.fragments;

import androidx.lifecycle.z;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.paymethods.model.PaymentInstrumentView;

final class AppInvokeSheet$onViewCreated$2<T> implements z<List<? extends PaymentInstrumentView>> {
    final /* synthetic */ AppInvokeSheet this$0;

    AppInvokeSheet$onViewCreated$2(AppInvokeSheet appInvokeSheet) {
        this.this$0 = appInvokeSheet;
    }

    public final void onChanged(List<? extends PaymentInstrumentView> list) {
        AppInvokeSheet appInvokeSheet = this.this$0;
        if (list == null) {
            k.a();
        }
        appInvokeSheet.inflatePaymentInstruments(list);
    }
}
