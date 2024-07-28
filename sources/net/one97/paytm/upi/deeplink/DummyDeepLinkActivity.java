package net.one97.paytm.upi.deeplink;

import android.os.Build;
import android.os.Bundle;
import net.one97.paytm.activity.PaytmActivity;

public final class DummyDeepLinkActivity extends PaytmActivity {
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 21) {
            finishAndRemoveTask();
        } else {
            finish();
        }
    }
}
