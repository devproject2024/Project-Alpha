package net.one97.paytm.dynamic.module.h5sdk;

import android.app.Activity;
import net.one97.paytm.h5paytmsdk.PaytmH5Manager;

final class PaytmH5ManagerImpl$clearCache$1$1 implements Runnable {
    final /* synthetic */ Activity $it;

    PaytmH5ManagerImpl$clearCache$1$1(Activity activity) {
        this.$it = activity;
    }

    public final void run() {
        PaytmH5Manager.INSTANCE.clearCache(this.$it);
    }
}
