package net.one97.paytm.phoenix.provider;

import android.view.View;
import android.widget.ProgressBar;
import java.lang.ref.WeakReference;

final class SplashIconViewProviderImpl$hideSplashView$1 implements Runnable {
    final /* synthetic */ SplashIconViewProviderImpl this$0;

    SplashIconViewProviderImpl$hideSplashView$1(SplashIconViewProviderImpl splashIconViewProviderImpl) {
        this.this$0 = splashIconViewProviderImpl;
    }

    public final void run() {
        ProgressBar access$getView$p;
        View view;
        WeakReference access$getInflatedView$p = this.this$0.inflatedView;
        if (access$getInflatedView$p != null) {
            access$getInflatedView$p.get();
        }
        WeakReference access$getInflatedView$p2 = this.this$0.inflatedView;
        if (!(access$getInflatedView$p2 == null || (view = (View) access$getInflatedView$p2.get()) == null)) {
            view.setVisibility(8);
        }
        if (this.this$0.view != null && (access$getView$p = this.this$0.view) != null) {
            access$getView$p.setVisibility(8);
        }
    }
}
