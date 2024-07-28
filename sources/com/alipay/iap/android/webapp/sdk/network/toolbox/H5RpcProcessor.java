package com.alipay.iap.android.webapp.sdk.network.toolbox;

import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.a.e;
import com.alipay.mobile.b.b.a;
import com.alipay.mobile.framework.b.c.b;
import com.alipay.mobile.nebula.appcenter.util.H5AppUtil;
import com.alipay.mobile.nebula.provider.H5AppProvider;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5Utils;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class H5RpcProcessor {
    public static final String RPC_HEADER_APP_ID = "nbappid";
    public static final String RPC_HEADER_VERSION = "nbversion";
    private static final String TAG = "H5RpcProcessor";

    public static String rpcCall(String str, String str2, String str3, boolean z, e eVar, boolean z2, Bundle bundle, int i2) throws ExecutionException, InterruptedException, a {
        H5AppProvider h5AppProvider;
        b bVar = (b) com.alipay.iap.android.common.c.a.a(b.class);
        Map<String, String> headers = getHeaders(eVar);
        if (bundle != null) {
            String string = H5Utils.getString(bundle, "appId");
            String string2 = H5Utils.getString(bundle, "appVersion");
            if (!TextUtils.isEmpty(string) && (h5AppProvider = (H5AppProvider) H5Utils.getProvider(H5AppProvider.class.getName())) != null && h5AppProvider.hasPackage(string, string2)) {
                if (!TextUtils.isEmpty(string) && !headers.containsKey(RPC_HEADER_APP_ID)) {
                    headers.put(RPC_HEADER_APP_ID, string);
                }
                String checkLogVersion = H5AppUtil.checkLogVersion(string, string2);
                H5Log.d(TAG, "uploadVersion ".concat(String.valueOf(checkLogVersion)));
                if (!TextUtils.isEmpty(string2) && !headers.containsKey("nbversion")) {
                    headers.put("nbversion", checkLogVersion);
                }
                H5Log.d(TAG, "appId:" + string + " version:" + string2);
            }
        }
        if (headers != null) {
            headers.isEmpty();
        }
        TextUtils.isEmpty(str2);
        String a2 = bVar.a();
        long id = Thread.currentThread().getId();
        H5Log.d(TAG, "threadId " + id + " rpc response " + a2);
        return a2;
    }

    private static Map<String, String> getHeaders(e eVar) {
        HashMap hashMap = new HashMap();
        if (eVar != null && !eVar.isEmpty()) {
            for (String next : eVar.keySet()) {
                String string = H5Utils.getString(eVar, next);
                if (!TextUtils.isEmpty(string)) {
                    H5Log.d(TAG, "add rpc header " + next + "=" + string);
                    hashMap.put(next, string);
                }
            }
        }
        return hashMap;
    }
}
