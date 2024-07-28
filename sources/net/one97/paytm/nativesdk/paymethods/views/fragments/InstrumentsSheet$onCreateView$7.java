package net.one97.paytm.nativesdk.paymethods.views.fragments;

import android.view.View;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.DirectPaymentBL;

final class InstrumentsSheet$onCreateView$7 implements View.OnClickListener {
    final /* synthetic */ InstrumentsSheet this$0;

    InstrumentsSheet$onCreateView$7(InstrumentsSheet instrumentsSheet) {
        this.this$0 = instrumentsSheet;
    }

    public final void onClick(View view) {
        DirectPaymentBL instance = DirectPaymentBL.getInstance();
        k.a((Object) instance, "DirectPaymentBL.getInstance()");
        if (instance.isSubsCriptionFlow()) {
            this.this$0.inflatesubsDetailSheet();
        } else {
            this.this$0.showOrderDetails();
        }
    }
}
