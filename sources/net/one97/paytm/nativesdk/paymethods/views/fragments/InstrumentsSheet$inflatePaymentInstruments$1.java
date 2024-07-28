package net.one97.paytm.nativesdk.paymethods.views.fragments;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import kotlin.g.b.k;

final class InstrumentsSheet$inflatePaymentInstruments$1 implements Runnable {
    final /* synthetic */ InstrumentsSheet this$0;

    InstrumentsSheet$inflatePaymentInstruments$1(InstrumentsSheet instrumentsSheet) {
        this.this$0 = instrumentsSheet;
    }

    public final void run() {
        new Runnable(this) {
            final /* synthetic */ InstrumentsSheet$inflatePaymentInstruments$1 this$0;

            {
                this.this$0 = r1;
            }

            public final void run() {
                Resources system = Resources.getSystem();
                k.a((Object) system, "Resources.getSystem()");
                float f2 = ((float) system.getDisplayMetrics().heightPixels) - (Resources.getSystem().getDisplayMetrics().density * 26.0f);
                LinearLayout linearLayout = InstrumentsSheet.access$getMCashierSheetBinding$p(this.this$0.this$0).instrumentsContainer;
                k.a((Object) linearLayout, "mCashierSheetBinding.instrumentsContainer");
                if (((float) linearLayout.getHeight()) < f2) {
                    ViewGroup.LayoutParams layoutParams = InstrumentsSheet.access$getMCashierSheetBinding$p(this.this$0.this$0).vEmptyView.getLayoutParams();
                    LinearLayout linearLayout2 = InstrumentsSheet.access$getMCashierSheetBinding$p(this.this$0.this$0).instrumentsContainer;
                    k.a((Object) linearLayout2, "mCashierSheetBinding.instrumentsContainer");
                    float height = f2 - ((float) linearLayout2.getHeight());
                    LinearLayout linearLayout3 = InstrumentsSheet.access$getMCashierSheetBinding$p(this.this$0.this$0).lytBottomLines;
                    k.a((Object) linearLayout3, "mCashierSheetBinding.lytBottomLines");
                    layoutParams.height = (int) (height - ((float) linearLayout3.getHeight()));
                    View view = InstrumentsSheet.access$getMCashierSheetBinding$p(this.this$0.this$0).vEmptyView;
                    k.a((Object) view, "mCashierSheetBinding.vEmptyView");
                    view.setLayoutParams(layoutParams);
                }
            }
        }.run();
    }
}
