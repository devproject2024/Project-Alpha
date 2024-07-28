package com.alipay.mobile.nebulacore.data;

import android.os.Bundle;
import com.alipay.mobile.nebula.util.H5Log;
import java.util.HashMap;
import java.util.Map;

public class H5ParamHolder {
    private static final boolean DEBUG = false;
    public static final String TAG = "H5ParamHolder";
    private static Map<String, PageParams> sPageParams = new HashMap();

    public interface PageParamListener {
        void onPageParam(Bundle bundle);
    }

    public static synchronized void addPageParam(String str) {
        synchronized (H5ParamHolder.class) {
            sPageParams.put(str, new PageParams());
        }
    }

    public static synchronized boolean hasPageParam(String str) {
        boolean containsKey;
        synchronized (H5ParamHolder.class) {
            containsKey = sPageParams.containsKey(str);
        }
        return containsKey;
    }

    public static synchronized void deliveryPageParam(String str, Bundle bundle) {
        synchronized (H5ParamHolder.class) {
            PageParams pageParams = sPageParams.get(str);
            if (pageParams == null) {
                H5Log.e(TAG, "!!! pageParams == null");
            } else if (pageParams.listener != null) {
                sPageParams.remove(str);
                pageParams.listener.onPageParam(bundle);
            } else {
                pageParams.bundle = bundle;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0040, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void retrievePageParam(java.lang.String r4, com.alipay.mobile.nebulacore.data.H5ParamHolder.PageParamListener r5) {
        /*
            java.lang.Class<com.alipay.mobile.nebulacore.data.H5ParamHolder> r0 = com.alipay.mobile.nebulacore.data.H5ParamHolder.class
            monitor-enter(r0)
            java.lang.String r1 = "H5ParamHolder"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0041 }
            java.lang.String r3 = "retrievePageParam "
            r2.<init>(r3)     // Catch:{ all -> 0x0041 }
            r2.append(r4)     // Catch:{ all -> 0x0041 }
            java.lang.String r3 = " "
            r2.append(r3)     // Catch:{ all -> 0x0041 }
            r2.append(r5)     // Catch:{ all -> 0x0041 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0041 }
            com.alipay.mobile.nebula.util.H5Log.d(r1, r2)     // Catch:{ all -> 0x0041 }
            java.util.Map<java.lang.String, com.alipay.mobile.nebulacore.data.H5ParamHolder$PageParams> r1 = sPageParams     // Catch:{ all -> 0x0041 }
            java.lang.Object r1 = r1.get(r4)     // Catch:{ all -> 0x0041 }
            com.alipay.mobile.nebulacore.data.H5ParamHolder$PageParams r1 = (com.alipay.mobile.nebulacore.data.H5ParamHolder.PageParams) r1     // Catch:{ all -> 0x0041 }
            if (r1 == 0) goto L_0x003f
            if (r5 != 0) goto L_0x002b
            goto L_0x003f
        L_0x002b:
            android.os.Bundle r2 = r1.bundle     // Catch:{ all -> 0x0041 }
            if (r2 != 0) goto L_0x0033
            r1.listener = r5     // Catch:{ all -> 0x0041 }
            monitor-exit(r0)
            return
        L_0x0033:
            java.util.Map<java.lang.String, com.alipay.mobile.nebulacore.data.H5ParamHolder$PageParams> r2 = sPageParams     // Catch:{ all -> 0x0041 }
            r2.remove(r4)     // Catch:{ all -> 0x0041 }
            android.os.Bundle r4 = r1.bundle     // Catch:{ all -> 0x0041 }
            r5.onPageParam(r4)     // Catch:{ all -> 0x0041 }
            monitor-exit(r0)
            return
        L_0x003f:
            monitor-exit(r0)
            return
        L_0x0041:
            r4 = move-exception
            monitor-exit(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.nebulacore.data.H5ParamHolder.retrievePageParam(java.lang.String, com.alipay.mobile.nebulacore.data.H5ParamHolder$PageParamListener):void");
    }

    static class PageParams {
        public Bundle bundle;
        public PageParamListener listener;
        public long time;

        private PageParams() {
        }
    }
}
