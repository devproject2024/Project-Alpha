package net.one97.paytm.phoenix.provider;

import android.view.View;
import com.airbnb.lottie.LottieAnimationView;
import java.lang.ref.WeakReference;
import net.one97.paytm.common.widgets.a;

final class SplashLoadingViewProvider$hideSplashView$1 implements Runnable {
    final /* synthetic */ SplashLoadingViewProvider this$0;

    SplashLoadingViewProvider$hideSplashView$1(SplashLoadingViewProvider splashLoadingViewProvider) {
        this.this$0 = splashLoadingViewProvider;
    }

    public final void run() {
        View view;
        WeakReference access$getInflatedView$p = this.this$0.inflatedView;
        if (!(access$getInflatedView$p == null || (view = (View) access$getInflatedView$p.get()) == null)) {
            view.post(new SplashLoadingViewProvider$hideSplashView$1$1$1(view));
        }
        LottieAnimationView access$getView$p = this.this$0.view;
        if (access$getView$p != null) {
            a.b(access$getView$p);
        }
    }
}
