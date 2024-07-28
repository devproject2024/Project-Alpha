package com.alipay.mobile.nebula.activity;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.mobile.framework.app.ui.BaseFragmentActivity;
import com.alipay.mobile.framework.b;
import com.alipay.mobile.nebula.provider.H5ReplaceResourceProvider;
import com.alipay.mobile.nebula.providermanager.H5BaseProviderInfo;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5SplitCompatUtils;
import com.alipay.mobile.nebula.util.H5Utils;

public class H5BaseActivity extends BaseFragmentActivity {
    public static final String TAG = "H5BaseActivity";

    public void replaceResources(Context context) {
        H5Log.d(TAG, "replaceResources");
        b.a().b();
        H5ReplaceResourceProvider h5ReplaceResourceProvider = (H5ReplaceResourceProvider) H5Utils.getProvider(H5ReplaceResourceProvider.class.getName());
        String replaceResourcesBundleName = h5ReplaceResourceProvider != null ? h5ReplaceResourceProvider.getReplaceResourcesBundleName() : null;
        if (TextUtils.isEmpty(replaceResourcesBundleName)) {
            getClass().getName();
            new String[]{H5BaseProviderInfo.nebulabiz, H5BaseProviderInfo.nebulauc, "android-phone-wallet-nebula"};
            return;
        }
        getClass().getName();
        String[] strArr = {H5BaseProviderInfo.nebulabiz, H5BaseProviderInfo.nebulauc, "android-phone-wallet-nebula", replaceResourcesBundleName};
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        H5SplitCompatUtils.doInstall(this);
    }
}
