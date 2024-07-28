package net.one97.paytm.nativesdk.paymethods.views.fragments;

import android.view.View;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.instruments.InstrumentActivity;

final class InstrumentsSheet$onCreateView$2 implements View.OnClickListener {
    final /* synthetic */ InstrumentsSheet this$0;

    InstrumentsSheet$onCreateView$2(InstrumentsSheet instrumentsSheet) {
        this.this$0 = instrumentsSheet;
    }

    public final void onClick(View view) {
        InstrumentActivity instrumentActivity = (InstrumentActivity) this.this$0.getActivity();
        if (instrumentActivity == null) {
            k.a();
        }
        instrumentActivity.onBackPressed();
    }
}
