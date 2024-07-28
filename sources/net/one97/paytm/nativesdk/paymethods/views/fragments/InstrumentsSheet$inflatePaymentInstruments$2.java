package net.one97.paytm.nativesdk.paymethods.views.fragments;

import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.instruments.PaytmBaseView;

public final class InstrumentsSheet$inflatePaymentInstruments$2 implements ViewTreeObserver.OnGlobalLayoutListener {
    final /* synthetic */ InstrumentsSheet this$0;

    InstrumentsSheet$inflatePaymentInstruments$2(InstrumentsSheet instrumentsSheet) {
        this.this$0 = instrumentsSheet;
    }

    public final void onGlobalLayout() {
        PaytmBaseView walletView = this.this$0.getWalletView();
        if (walletView != null) {
            View view = walletView.getView();
            k.a((Object) view, "it.view");
            int top = view.getTop();
            LinearLayout linearLayout = InstrumentsSheet.access$getMCashierSheetBinding$p(this.this$0).logoToolbar;
            k.a((Object) linearLayout, "mCashierSheetBinding.logoToolbar");
            this.this$0.setScrollViewToolbarVisibility(top + linearLayout.getHeight());
            LinearLayout linearLayout2 = InstrumentsSheet.access$getMCashierSheetBinding$p(this.this$0).instrumentsContainer;
            k.a((Object) linearLayout2, "mCashierSheetBinding.instrumentsContainer");
            linearLayout2.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
    }
}
