package net.one97.paytm.dynamic.module.h5sdk;

import android.content.Context;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.play.core.splitcompat.a;
import net.one97.paytm.deeplink.u;

public class H5InitActivity extends AppCompatActivity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String str = (String) getIntent().getSerializableExtra(u.f50376h);
        new H5CommunicatorImpl();
        PhoenixManagerImpl.INSTANCE.init(getApplication(), u.f50369a);
        PaytmH5ManagerImpl.INSTANCE.init(getApplication(), u.f50369a);
        if (u.b.INITIALIZE_LOAD.name().equalsIgnoreCase(str) || u.b.DOWNLOAD_INITIALIZE_LOAD.name().equalsIgnoreCase(str)) {
            Bundle bundleExtra = getIntent().getBundleExtra(u.f50370b);
            String stringExtra = getIntent().getStringExtra(u.f50371c);
            String stringExtra2 = getIntent().getStringExtra(u.f50372d);
            String stringExtra3 = getIntent().getStringExtra(u.f50373e);
            String stringExtra4 = getIntent().getStringExtra(u.f50374f);
            boolean booleanExtra = getIntent().getBooleanExtra(u.f50375g, false);
            if (!(stringExtra3 == null || stringExtra2 == null)) {
                H5ManagerHelper.loadPage(stringExtra4, stringExtra3, stringExtra2, bundleExtra, stringExtra, booleanExtra, this);
            }
        } else if (u.b.DOWNLOAD_INITIALIZE_DEEPLINK.name().equalsIgnoreCase(str)) {
            String stringExtra5 = getIntent().getStringExtra(u.f50371c);
            if (stringExtra5 != null) {
                H5InternalDeeplinkHandler.handleDeeplink(this, stringExtra5);
            }
        } else if (u.b.CLEAR_CACHE.name().equalsIgnoreCase(str)) {
            PhoenixManagerImpl.INSTANCE.clearCache(this);
            PhoenixManagerImpl.INSTANCE.init(getApplication(), u.f50369a);
            PaytmH5ManagerImpl.INSTANCE.clearCache(this);
            PaytmH5ManagerImpl.INSTANCE.init(getApplication(), u.f50369a);
        }
        finish();
    }

    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        a.a((Context) this);
    }
}
