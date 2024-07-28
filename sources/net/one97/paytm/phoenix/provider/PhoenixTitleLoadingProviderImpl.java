package net.one97.paytm.phoenix.provider;

import android.app.Activity;

public final class PhoenixTitleLoadingProviderImpl implements PhoenixTitleLoadingProvider {
    public final boolean showTitleLoading(Activity activity) {
        if (activity == null) {
            return false;
        }
        activity.runOnUiThread(new PhoenixTitleLoadingProviderImpl$showTitleLoading$$inlined$let$lambda$1(activity));
        return false;
    }

    public final boolean hideTitleLoading(Activity activity) {
        if (activity == null) {
            return false;
        }
        activity.runOnUiThread(new PhoenixTitleLoadingProviderImpl$hideTitleLoading$$inlined$let$lambda$1(activity));
        return false;
    }
}
