package net.one97.paytm.nativesdk.paymethods.views.fragments;

import android.view.View;
import kotlin.g.a.b;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.x;
import net.one97.paytm.nativesdk.instruments.InstrumentActivity;

final class InstrumentsSheet$onCreateView$9 extends l implements b<View, x> {
    final /* synthetic */ InstrumentsSheet this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InstrumentsSheet$onCreateView$9(InstrumentsSheet instrumentsSheet) {
        super(1);
        this.this$0 = instrumentsSheet;
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((View) obj);
        return x.f47997a;
    }

    public final void invoke(View view) {
        k.c(view, "it");
        InstrumentActivity instrumentActivity = (InstrumentActivity) this.this$0.getActivity();
        if (instrumentActivity == null) {
            k.a();
        }
        instrumentActivity.onBackPressed();
    }
}
