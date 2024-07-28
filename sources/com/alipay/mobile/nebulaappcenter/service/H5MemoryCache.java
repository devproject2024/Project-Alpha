package com.alipay.mobile.nebulaappcenter.service;

import com.alipay.mobile.nebula.appcenter.model.AppInfo;
import com.alipay.mobile.nebula.provider.H5ConfigProvider;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5Utils;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class H5MemoryCache {
    private static final int MAX_CACHE_SIZE = 10;
    private static final String TAG = "H5MemoryCache";
    private static final Map<String, Map<String, AppInfo>> apps = new H5LruCache(10);
    private static H5MemoryCache instance;
    private Boolean useCache = null;

    public static synchronized H5MemoryCache getInstance() {
        H5MemoryCache h5MemoryCache;
        synchronized (H5MemoryCache.class) {
            if (instance == null) {
                instance = new H5MemoryCache();
            }
            h5MemoryCache = instance;
        }
        return h5MemoryCache;
    }

    public void saveAppInfoToMemory(AppInfo appInfo) {
        if (appInfo != null) {
            try {
                synchronized (apps) {
                    if (apps.get(appInfo.app_id) != null) {
                        apps.get(appInfo.app_id).put(appInfo.version, appInfo);
                    } else {
                        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                        concurrentHashMap.put(appInfo.version, appInfo);
                        apps.put(appInfo.app_id, concurrentHashMap);
                    }
                }
            } catch (Exception e2) {
                H5Log.e(TAG, (Throwable) e2);
            }
        }
    }

    private boolean enableUseCache() {
        H5ConfigProvider h5ConfigProvider;
        if (this.useCache != null || (h5ConfigProvider = (H5ConfigProvider) H5Utils.getProvider(H5ConfigProvider.class.getName())) == null || !"no".equalsIgnoreCase(h5ConfigProvider.getConfig("h5_use_appCache"))) {
            this.useCache = Boolean.TRUE;
            return true;
        }
        this.useCache = Boolean.FALSE;
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0063, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.alipay.mobile.nebula.appcenter.model.AppInfo getAppInfoFromMemory(java.lang.String r6, java.lang.String r7) {
        /*
            r5 = this;
            r0 = 0
            boolean r1 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x0069 }
            if (r1 == 0) goto L_0x0008
            return r0
        L_0x0008:
            java.util.Map<java.lang.String, java.util.Map<java.lang.String, com.alipay.mobile.nebula.appcenter.model.AppInfo>> r1 = apps     // Catch:{ all -> 0x0069 }
            monitor-enter(r1)     // Catch:{ all -> 0x0069 }
            java.util.Map<java.lang.String, java.util.Map<java.lang.String, com.alipay.mobile.nebula.appcenter.model.AppInfo>> r2 = apps     // Catch:{ all -> 0x0066 }
            java.lang.Object r2 = r2.get(r6)     // Catch:{ all -> 0x0066 }
            if (r2 == 0) goto L_0x0064
            java.util.Map<java.lang.String, java.util.Map<java.lang.String, com.alipay.mobile.nebula.appcenter.model.AppInfo>> r2 = apps     // Catch:{ all -> 0x0066 }
            java.lang.Object r2 = r2.get(r6)     // Catch:{ all -> 0x0066 }
            java.util.Map r2 = (java.util.Map) r2     // Catch:{ all -> 0x0066 }
            if (r2 == 0) goto L_0x0062
            boolean r3 = r2.isEmpty()     // Catch:{ all -> 0x0066 }
            if (r3 == 0) goto L_0x0024
            goto L_0x0062
        L_0x0024:
            boolean r3 = r5.enableUseCache()     // Catch:{ all -> 0x0066 }
            if (r3 != 0) goto L_0x0033
            java.lang.String r6 = "H5MemoryCache"
            java.lang.String r7 = " can not use cache config is close"
            com.alipay.mobile.nebula.util.H5Log.e((java.lang.String) r6, (java.lang.String) r7)     // Catch:{ all -> 0x0066 }
            monitor-exit(r1)     // Catch:{ all -> 0x0066 }
            return r0
        L_0x0033:
            boolean r3 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x0066 }
            if (r3 != 0) goto L_0x0064
            java.lang.String r3 = "*"
            boolean r3 = r7.contains(r3)     // Catch:{ all -> 0x0066 }
            if (r3 != 0) goto L_0x0064
            java.lang.String r3 = "H5MemoryCache"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0066 }
            r4.<init>()     // Catch:{ all -> 0x0066 }
            r4.append(r6)     // Catch:{ all -> 0x0066 }
            java.lang.String r6 = " getNebulaAppInfo from H5MemoryCache "
            r4.append(r6)     // Catch:{ all -> 0x0066 }
            r4.append(r7)     // Catch:{ all -> 0x0066 }
            java.lang.String r6 = r4.toString()     // Catch:{ all -> 0x0066 }
            com.alipay.mobile.nebula.util.H5Log.debug(r3, r6)     // Catch:{ all -> 0x0066 }
            java.lang.Object r6 = r2.get(r7)     // Catch:{ all -> 0x0066 }
            com.alipay.mobile.nebula.appcenter.model.AppInfo r6 = (com.alipay.mobile.nebula.appcenter.model.AppInfo) r6     // Catch:{ all -> 0x0066 }
            monitor-exit(r1)     // Catch:{ all -> 0x0066 }
            return r6
        L_0x0062:
            monitor-exit(r1)     // Catch:{ all -> 0x0066 }
            return r0
        L_0x0064:
            monitor-exit(r1)     // Catch:{ all -> 0x0066 }
            goto L_0x006f
        L_0x0066:
            r6 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0066 }
            throw r6     // Catch:{ all -> 0x0069 }
        L_0x0069:
            r6 = move-exception
            java.lang.String r7 = "H5MemoryCache"
            com.alipay.mobile.nebula.util.H5Log.e((java.lang.String) r7, (java.lang.Throwable) r6)
        L_0x006f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.nebulaappcenter.service.H5MemoryCache.getAppInfoFromMemory(java.lang.String, java.lang.String):com.alipay.mobile.nebula.appcenter.model.AppInfo");
    }

    public void deleteAppInfoFromMemory(String str, String str2) {
        try {
            synchronized (apps) {
                Map map = apps.get(str);
                if (map != null && !map.isEmpty()) {
                    map.remove(str2);
                }
            }
        } catch (Exception e2) {
            H5Log.e(TAG, (Throwable) e2);
        }
    }

    public void clearMemory() {
        try {
            apps.clear();
        } catch (Exception e2) {
            H5Log.e(TAG, (Throwable) e2);
        }
    }

    static class H5LruCache<K, V> extends LinkedHashMap<K, V> {
        private final int MAX_CACHE_SIZE;

        H5LruCache(int i2) {
            super(((int) Math.ceil(((double) i2) / 0.75d)) + 1, 0.75f, true);
            this.MAX_CACHE_SIZE = i2;
        }

        /* access modifiers changed from: protected */
        public boolean removeEldestEntry(Map.Entry entry) {
            return size() > this.MAX_CACHE_SIZE;
        }
    }
}
