package com.alipay.mobile.nebulacore.appcenter;

import android.content.Intent;
import android.os.Bundle;
import com.alipay.mobile.framework.app.b;
import com.alipay.mobile.framework.app.e;
import com.alipay.mobile.nebula.provider.H5AppProvider;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5ThreadType;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebulacore.ui.H5NebulaAppActivity;

public class H5IApplicationInstallerImpl implements e {
    public static String NEBULA_FALLBACK_APP_ID = "NebulaFallBackAppId";
    private static final String TAG = "H5IApplicationInstallerImpl";

    public void installApplication(final String str, final e.a aVar, final Bundle bundle) {
        H5Utils.getExecutor(H5ThreadType.URGENT_DISPLAY).execute(new Runnable() {
            public void run() {
                Bundle bundle = bundle;
                H5AppProvider h5AppProvider = (H5AppProvider) H5Utils.getProvider(H5AppProvider.class.getName());
                if (h5AppProvider == null) {
                    return;
                }
                if (h5AppProvider.getAppInfo(str) != null) {
                    H5Log.d(H5IApplicationInstallerImpl.TAG, " appId " + str + " is install");
                    H5IApplicationInstallerImpl.this.setEngineType(str);
                    return;
                }
                Intent intent = new Intent(H5Utils.getContext(), H5NebulaAppActivity.class);
                if (bundle == null) {
                    bundle = new Bundle();
                }
                bundle.putString(H5IApplicationInstallerImpl.NEBULA_FALLBACK_APP_ID, str);
                intent.putExtras(bundle);
                H5Utils.getContext().startActivity(intent);
            }
        });
    }

    /* access modifiers changed from: private */
    public void setEngineType(String str) {
        new b();
        com.alipay.mobile.framework.b.a();
    }
}
