package net.one97.paytm.phoenix.provider;

import android.app.Activity;
import android.view.View;
import net.one97.paytm.phoenix.ui.PhoenixActivity;

final class PhoenixTitleLoadingProviderImpl$showTitleLoading$$inlined$let$lambda$1 implements Runnable {
    final /* synthetic */ Activity $activity$inlined;

    PhoenixTitleLoadingProviderImpl$showTitleLoading$$inlined$let$lambda$1(Activity activity) {
        this.$activity$inlined = activity;
    }

    public final void run() {
        View c2;
        Activity activity = this.$activity$inlined;
        if ((activity instanceof PhoenixActivity) && (c2 = ((PhoenixActivity) activity).c()) != null) {
            c2.setVisibility(0);
        }
    }
}
