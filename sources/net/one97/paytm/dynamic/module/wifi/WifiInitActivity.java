package net.one97.paytm.dynamic.module.wifi;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.play.core.splitcompat.a;
import net.one97.paytm.wifi.ui.WiFiHomeActivity;

public class WifiInitActivity extends AppCompatActivity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        WifiDataProvider.initWifiModule(this);
        checkForDeepLinkIntent(getIntent(), this);
        finish();
    }

    private void checkForDeepLinkIntent(Intent intent, Context context) {
        intent.setClass(context, WiFiHomeActivity.class);
        startActivity(intent);
    }

    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        a.a((Context) this);
    }

    public void reInitialized() {
        WifiDataProvider.initWifiModule(this);
    }
}
