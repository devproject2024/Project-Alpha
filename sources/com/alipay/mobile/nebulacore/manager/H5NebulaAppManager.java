package com.alipay.mobile.nebulacore.manager;

import com.alipay.mobile.nebula.appcenter.listen.NebulaAppCallback;
import com.alipay.mobile.nebula.appcenter.listen.NebulaAppManager;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebulacore.Nebula;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class H5NebulaAppManager implements NebulaAppManager {
    private static final String TAG = "H5NebulaAppManager";
    private List<NebulaAppCallback> nebulaAppCallbackList = Collections.synchronizedList(new ArrayList());

    public synchronized void registerNebulaAppCallback(NebulaAppCallback nebulaAppCallback) {
        if (Nebula.DEBUG) {
            H5Log.d(TAG, "registerNebulaAppCallback " + H5Utils.getClassName(nebulaAppCallback));
        }
        this.nebulaAppCallbackList.add(nebulaAppCallback);
    }

    public synchronized void unregisterNebulaAppCallback(NebulaAppCallback nebulaAppCallback) {
        if (Nebula.DEBUG) {
            H5Log.d(TAG, "unregisterNebulaAppCallback " + H5Utils.getClassName(nebulaAppCallback));
        }
        this.nebulaAppCallbackList.remove(nebulaAppCallback);
    }

    public synchronized List<NebulaAppCallback> getNebulaAppCallbackList() {
        if (Nebula.DEBUG) {
            String str = "";
            for (NebulaAppCallback className : this.nebulaAppCallbackList) {
                str = str + " " + H5Utils.getClassName(className);
            }
            H5Log.d(TAG, "getNebulaAppCallbackList ".concat(String.valueOf(str)));
        }
        return this.nebulaAppCallbackList;
    }
}
