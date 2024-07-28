package net.one97.paytm.phoenix.provider;

import android.app.Activity;
import android.view.View;
import android.widget.ProgressBar;
import java.lang.ref.WeakReference;
import kotlin.g.b.k;

public final class PhoenixLoadingViewProviderImpl implements PhoenixLoadingViewProvider {
    /* access modifiers changed from: private */
    public WeakReference<View> inflatedView;
    /* access modifiers changed from: private */
    public ProgressBar view;

    public final boolean showLoadingView(Activity activity) {
        k.c(activity, "activity");
        activity.runOnUiThread(new PhoenixLoadingViewProviderImpl$showLoadingView$1(this, activity));
        return true;
    }

    public final boolean hideLoadingView(Activity activity) {
        k.c(activity, "activity");
        activity.runOnUiThread(new PhoenixLoadingViewProviderImpl$hideLoadingView$1(this));
        return true;
    }

    public final void updateProgress(int i2) {
        ProgressBar progressBar = this.view;
        if (progressBar != null && progressBar != null) {
            progressBar.setProgress(i2);
        }
    }
}
