package net.one97.paytm.phoenix.provider;

import android.app.Activity;
import android.widget.FrameLayout;
import java.lang.ref.WeakReference;

public interface SplashIconViewProvider {
    void hideSplashView();

    void showSplashView(WeakReference<Activity> weakReference, FrameLayout frameLayout);

    void updateProgress(int i2);
}
