package com.alipay.mobile.nebulacore.wallet;

import com.alipay.mobile.framework.app.d;
import com.alipay.mobile.framework.app.f;
import com.alipay.mobile.nebula.util.H5Log;

public class H5Engine implements d {
    public static final String TAG = "H5Engine";

    public f createApplication() {
        H5Log.d(TAG, "createApplication");
        return new H5Application();
    }
}
