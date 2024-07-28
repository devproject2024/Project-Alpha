package net.one97.paytm.phoenix.provider;

import android.view.View;
import com.airbnb.lottie.LottieAnimationView;
import java.lang.ref.WeakReference;
import net.one97.paytm.common.widgets.a;

final class LoadingViewProvider$hideLoadingView$1 implements Runnable {
    final /* synthetic */ LoadingViewProvider this$0;

    LoadingViewProvider$hideLoadingView$1(LoadingViewProvider loadingViewProvider) {
        this.this$0 = loadingViewProvider;
    }

    public final void run() {
        LottieAnimationView lottieAnimationView;
        View view;
        WeakReference access$getInflatedView$p = this.this$0.inflatedView;
        if (!(access$getInflatedView$p == null || (view = (View) access$getInflatedView$p.get()) == null)) {
            view.post(new LoadingViewProvider$hideLoadingView$1$1$1(view));
        }
        WeakReference access$getView$p = this.this$0.view;
        if (access$getView$p != null && (lottieAnimationView = (LottieAnimationView) access$getView$p.get()) != null) {
            a.b(lottieAnimationView);
        }
    }
}
