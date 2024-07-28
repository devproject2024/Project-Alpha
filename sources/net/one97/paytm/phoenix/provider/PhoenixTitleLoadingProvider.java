package net.one97.paytm.phoenix.provider;

import android.app.Activity;

public interface PhoenixTitleLoadingProvider {
    boolean hideTitleLoading(Activity activity);

    boolean showTitleLoading(Activity activity);
}
