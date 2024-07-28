package net.one97.paytm.phoenix.provider;

import android.app.Activity;

public interface PhoenixLoadingViewProvider {
    boolean hideLoadingView(Activity activity);

    boolean showLoadingView(Activity activity);

    void updateProgress(int i2);
}
