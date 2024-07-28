package net.one97.paytm.nativesdk.paymethods.views.fragments;

import android.view.View;
import android.view.ViewTreeObserver;
import kotlin.g.b.k;
import net.one97.paytm.nativesdk.instruments.PaytmBaseView;

public final class AppInvokeSheet$inflatePaymentInstruments$1 implements ViewTreeObserver.OnGlobalLayoutListener {
    final /* synthetic */ AppInvokeSheet this$0;

    AppInvokeSheet$inflatePaymentInstruments$1(AppInvokeSheet appInvokeSheet) {
        this.this$0 = appInvokeSheet;
    }

    public final void onGlobalLayout() {
        PaytmBaseView walletView = this.this$0.getWalletView();
        if (walletView != null) {
            View view = walletView.getView();
            k.a((Object) view, "it.view");
            this.this$0.setScrollViewToolbarVisibility(view.getTop() + this.this$0.getMainToolbar().getHeight());
            this.this$0.getInstrumentViews().getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
    }
}
