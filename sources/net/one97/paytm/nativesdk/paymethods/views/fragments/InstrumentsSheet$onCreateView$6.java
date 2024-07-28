package net.one97.paytm.nativesdk.paymethods.views.fragments;

import android.view.View;
import kotlin.g.a.b;
import kotlin.g.b.k;
import kotlin.g.b.l;
import kotlin.x;
import net.one97.paytm.nativesdk.DirectPaymentBL;

final class InstrumentsSheet$onCreateView$6 extends l implements b<View, x> {
    final /* synthetic */ InstrumentsSheet this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InstrumentsSheet$onCreateView$6(InstrumentsSheet instrumentsSheet) {
        super(1);
        this.this$0 = instrumentsSheet;
    }

    public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((View) obj);
        return x.f47997a;
    }

    public final void invoke(View view) {
        k.c(view, "it");
        DirectPaymentBL instance = DirectPaymentBL.getInstance();
        k.a((Object) instance, "DirectPaymentBL.getInstance()");
        if (instance.isSubsCriptionFlow()) {
            this.this$0.inflatesubsDetailSheet();
        } else {
            this.this$0.showOrderDetails();
        }
    }
}
