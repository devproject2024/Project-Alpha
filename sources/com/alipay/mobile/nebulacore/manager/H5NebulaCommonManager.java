package com.alipay.mobile.nebulacore.manager;

import com.alipay.mobile.nebula.appcenter.common.NebulaCommonInfo;
import com.alipay.mobile.nebula.appcenter.common.NebulaCommonManager;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebulacore.Nebula;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class H5NebulaCommonManager implements NebulaCommonManager {
    private static final String TAG = "H5NebulaCommonManager";
    private List<NebulaCommonInfo> nebulaCommonInfoList = Collections.synchronizedList(new ArrayList());

    public synchronized void registerNebulaCommonInfo(NebulaCommonInfo nebulaCommonInfo) {
        if (Nebula.DEBUG && nebulaCommonInfo != null) {
            String str = "";
            for (String str2 : nebulaCommonInfo.getAppIdList()) {
                str = str2 + " " + str;
            }
            H5Log.d(TAG, "registerNebulaCommonInfo ".concat(String.valueOf(str)));
        }
        this.nebulaCommonInfoList.add(nebulaCommonInfo);
    }

    public synchronized void unregisterNebulaCommonInfo(NebulaCommonInfo nebulaCommonInfo) {
        this.nebulaCommonInfoList.remove(nebulaCommonInfo);
    }

    public synchronized List<NebulaCommonInfo> getNebulaAppCallbackList() {
        if (Nebula.DEBUG) {
            String str = "";
            for (NebulaCommonInfo appIdList : this.nebulaCommonInfoList) {
                for (String str2 : appIdList.getAppIdList()) {
                    str = str2 + " " + str;
                }
            }
            H5Log.d(TAG, "getNebulaAppCallbackList ".concat(String.valueOf(str)));
        }
        return this.nebulaCommonInfoList;
    }
}
