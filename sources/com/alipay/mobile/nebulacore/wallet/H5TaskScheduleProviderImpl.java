package com.alipay.mobile.nebulacore.wallet;

import com.alipay.mobile.framework.b.b.a;
import com.alipay.mobile.nebula.provider.H5TaskScheduleProvider;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5Utils;

public class H5TaskScheduleProviderImpl implements H5TaskScheduleProvider {
    public static final String TAG = "H5TaskScheduleProviderImpl";

    public boolean addIdleTask(Runnable runnable, String str, int i2) {
        if (((a) H5Utils.findServiceByInterface(a.class.getName())) == null) {
            H5Log.e(TAG, "taskService==null");
            return false;
        }
        H5Log.d(TAG, "get taskService add addIdleTask");
        return a.a(runnable);
    }
}
