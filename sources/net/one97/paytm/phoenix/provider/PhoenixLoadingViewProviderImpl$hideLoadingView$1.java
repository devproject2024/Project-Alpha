package net.one97.paytm.phoenix.provider;

import android.view.View;
import android.widget.ProgressBar;
import java.lang.ref.WeakReference;

final class PhoenixLoadingViewProviderImpl$hideLoadingView$1 implements Runnable {
    final /* synthetic */ PhoenixLoadingViewProviderImpl this$0;

    PhoenixLoadingViewProviderImpl$hideLoadingView$1(PhoenixLoadingViewProviderImpl phoenixLoadingViewProviderImpl) {
        this.this$0 = phoenixLoadingViewProviderImpl;
    }

    public final void run() {
        ProgressBar access$getView$p;
        View view;
        WeakReference access$getInflatedView$p = this.this$0.inflatedView;
        if (!(access$getInflatedView$p == null || (view = (View) access$getInflatedView$p.get()) == null)) {
            view.setVisibility(8);
        }
        if (this.this$0.view != null && (access$getView$p = this.this$0.view) != null) {
            access$getView$p.setVisibility(8);
        }
    }
}
