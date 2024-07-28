package com.alipay.mobile.nebula.webview;

import android.text.TextUtils;
import com.alibaba.a.e;
import com.alipay.mobile.h5container.api.H5Param;
import com.alipay.mobile.nebula.provider.H5ConfigProvider;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5Utils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class H5ResContentList {
    private static final String DEFAULT_CACHE_TIME = "604800";
    private static final String TAG = "H5ResContentList";
    private static H5ResContentList instance;
    private static Boolean isEnable;
    private Map<String, byte[]> resourceMap = new ConcurrentHashMap();

    private H5ResContentList() {
    }

    public static synchronized H5ResContentList getInstance() {
        H5ResContentList h5ResContentList;
        synchronized (H5ResContentList.class) {
            if (instance == null) {
                instance = new H5ResContentList();
            }
            h5ResContentList = instance;
        }
        return h5ResContentList;
    }

    public synchronized void add(String str, byte[] bArr) {
        if (!TextUtils.isEmpty(str)) {
            H5Log.d(TAG, "add resource : ".concat(String.valueOf(str)));
            this.resourceMap.put(str, bArr);
        }
    }

    public synchronized byte[] get(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.resourceMap.get(str);
    }

    public synchronized void remove(String str) {
        if (!TextUtils.isEmpty(str)) {
            H5Log.d(TAG, "remove resource : ".concat(String.valueOf(str)));
            this.resourceMap.remove(str);
        }
    }

    public synchronized boolean contains(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.resourceMap.containsKey(str);
    }

    public synchronized void clear() {
        this.resourceMap.clear();
    }

    public static boolean enableResHttpCache() {
        H5ConfigProvider h5ConfigProvider = (H5ConfigProvider) H5Utils.getProvider(H5ConfigProvider.class.getName());
        if (h5ConfigProvider == null) {
            return false;
        }
        String configWithProcessCache = h5ConfigProvider.getConfigWithProcessCache("h5_enableResHttpCache");
        if (TextUtils.isEmpty(configWithProcessCache)) {
            return false;
        }
        Boolean bool = isEnable;
        if (bool != null) {
            return bool.booleanValue();
        }
        e parseObject = H5Utils.parseObject(configWithProcessCache);
        if (parseObject == null || parseObject.isEmpty()) {
            isEnable = Boolean.FALSE;
            return false;
        } else if (!H5Param.DEFAULT_LONG_PRESSO_LOGIN.equalsIgnoreCase(H5Utils.getString(parseObject, "enable")) || !isUC()) {
            isEnable = Boolean.FALSE;
            return false;
        } else {
            isEnable = Boolean.TRUE;
            return true;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0011, code lost:
        r0 = r0.getTopH5Page();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean isUC() {
        /*
            com.alipay.mobile.framework.b.a()
            java.lang.Class<com.alipay.mobile.h5container.service.H5Service> r0 = com.alipay.mobile.h5container.service.H5Service.class
            java.lang.String r0 = r0.getName()
            java.lang.Object r0 = com.alipay.mobile.framework.c.a(r0)
            com.alipay.mobile.h5container.service.H5Service r0 = (com.alipay.mobile.h5container.service.H5Service) r0
            if (r0 == 0) goto L_0x002b
            com.alipay.mobile.h5container.api.H5Page r0 = r0.getTopH5Page()
            if (r0 == 0) goto L_0x002b
            com.alipay.mobile.nebula.webview.APWebView r1 = r0.getWebView()
            if (r1 == 0) goto L_0x002b
            com.alipay.mobile.nebula.webview.APWebView r0 = r0.getWebView()
            com.alipay.mobile.nebula.webview.WebViewType r0 = r0.getType()
            com.alipay.mobile.nebula.webview.WebViewType r1 = com.alipay.mobile.nebula.webview.WebViewType.THIRD_PARTY
            if (r0 != r1) goto L_0x002b
            r0 = 1
            return r0
        L_0x002b:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.nebula.webview.H5ResContentList.isUC():boolean");
    }

    public static String getCacheTime() {
        e parseObject;
        H5ConfigProvider h5ConfigProvider = (H5ConfigProvider) H5Utils.getProvider(H5ConfigProvider.class.getName());
        if (h5ConfigProvider == null) {
            return DEFAULT_CACHE_TIME;
        }
        String configWithProcessCache = h5ConfigProvider.getConfigWithProcessCache("h5_enableResHttpCache");
        if (!TextUtils.isEmpty(configWithProcessCache) && (parseObject = H5Utils.parseObject(configWithProcessCache)) != null && !parseObject.isEmpty()) {
            String string = H5Utils.getString(parseObject, "cacheTime");
            if (!TextUtils.isEmpty(string)) {
                return string;
            }
        }
        return DEFAULT_CACHE_TIME;
    }
}
