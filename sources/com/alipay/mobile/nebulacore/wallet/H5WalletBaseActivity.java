package com.alipay.mobile.nebulacore.wallet;

import android.content.Context;
import android.os.Bundle;
import com.alipay.mobile.framework.app.ui.BaseActivity;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5SplitCompatUtils;

public class H5WalletBaseActivity extends BaseActivity {
    public static final String TAG = "H5WalletBaseActivity";

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        H5Log.d(TAG, "onCreate");
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        H5SplitCompatUtils.doInstall(this);
    }
}
