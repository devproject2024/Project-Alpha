package net.one97.paytm.phoenix.provider;

import android.app.Activity;
import android.view.View;
import com.airbnb.lottie.LottieAnimationView;
import java.lang.ref.WeakReference;
import kotlin.g.b.k;

public final class LoadingViewProvider implements PhoenixLoadingViewProvider {
    /* access modifiers changed from: private */
    public WeakReference<View> inflatedView;
    /* access modifiers changed from: private */
    public String lastActivityInstance;
    /* access modifiers changed from: private */
    public WeakReference<LottieAnimationView> view;

    public final void updateProgress(int i2) {
    }

    public final boolean showLoadingView(Activity activity) {
        k.c(activity, "activity");
        activity.runOnUiThread(new LoadingViewProvider$showLoadingView$1(this, activity));
        return true;
    }

    public final boolean hideLoadingView(Activity activity) {
        k.c(activity, "activity");
        activity.runOnUiThread(new LoadingViewProvider$hideLoadingView$1(this));
        return true;
    }
}
