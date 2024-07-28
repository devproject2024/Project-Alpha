package net.one97.paytm.dynamic.module.transport.iocl;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.play.core.splitcompat.a;
import net.one97.paytm.deeplink.DeepLinkData;
import net.one97.paytm.transport.iocl.activity.AJRIOCLHomeActivity;

public class IoclInitActivity extends AppCompatActivity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        IOCLDataProvider.initIOCLTransport(getApplication());
        checkForDeepLinkIntent(getIntent(), this);
        finish();
    }

    public void reInitialized() {
        IOCLDataProvider.initIOCLTransport(getApplication());
    }

    private void checkForDeepLinkIntent(Intent intent, Context context) {
        if (intent.getExtras().containsKey("EXTRA_DEEP_LINK_DATA")) {
            DeepLinkData deepLinkData = (DeepLinkData) intent.getExtras().get("EXTRA_DEEP_LINK_DATA");
            if (deepLinkData.f50284b.equals("iocl-pointsv2")) {
                intent.setClass(context, AJRIOCLHomeActivity.class);
                startActivity(intent);
            } else if (deepLinkData.f50284b.equals("iocl-points")) {
                intent.setClass(context, net.one97.paytm.transport.iocl_v1.activity.AJRIOCLHomeActivity.class);
                startActivity(intent);
            }
        }
    }

    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        a.a((Context) this);
    }
}
