package net.one97.paytm.paymentsBank.utils.photocrop.photoview;

import android.os.Build;
import android.view.View;

public final class a {
    public static void a(View view, Runnable runnable) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.postOnAnimation(runnable);
        } else {
            view.postDelayed(runnable, 16);
        }
    }
}
