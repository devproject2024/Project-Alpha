package com.alipay.mobile.nebula.startParam;

import android.os.Bundle;
import android.text.TextUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class H5AppStartParam {
    private static H5AppStartParam instance;
    private Map<String, Bundle> appStartParam = new ConcurrentHashMap();

    public static synchronized H5AppStartParam getInstance() {
        H5AppStartParam h5AppStartParam;
        synchronized (H5AppStartParam.class) {
            if (instance == null) {
                instance = new H5AppStartParam();
            }
            h5AppStartParam = instance;
        }
        return h5AppStartParam;
    }

    private H5AppStartParam() {
    }

    public void put(String str, Bundle bundle) {
        if (!TextUtils.isEmpty(str)) {
            this.appStartParam.put(str, bundle);
        }
    }

    public void remove(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.appStartParam.remove(str);
        }
    }

    public Bundle get(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.appStartParam.get(str);
    }
}
