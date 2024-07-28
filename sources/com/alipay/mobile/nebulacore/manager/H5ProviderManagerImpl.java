package com.alipay.mobile.nebulacore.manager;

import com.alipay.mobile.h5container.service.H5ConfigService;
import com.alipay.mobile.nebula.provider.H5ProviderManager;
import com.alipay.mobile.nebula.providermanager.H5BaseProviderInfo;
import com.alipay.mobile.nebula.providermanager.H5ProviderConfig;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5Utils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class H5ProviderManagerImpl extends H5ProviderManager {
    public static final String TAG = "H5ProviderManagerImpl";
    private static H5ProviderManagerImpl instance;
    private boolean configInited;
    private H5ConfigService h5ConfigService;
    private Map<String, H5ProviderConfig> providerInfoMap;
    private Map<String, Object> providerMap = new ConcurrentHashMap();

    private H5ProviderManagerImpl() {
        initProviderConfig();
    }

    public static synchronized H5ProviderManagerImpl getInstance() {
        H5ProviderManagerImpl h5ProviderManagerImpl;
        synchronized (H5ProviderManagerImpl.class) {
            if (instance == null) {
                instance = new H5ProviderManagerImpl();
            }
            h5ProviderManagerImpl = instance;
        }
        return h5ProviderManagerImpl;
    }

    private H5ConfigService getH5ConfigService() {
        if (this.h5ConfigService == null) {
            this.h5ConfigService = (H5ConfigService) H5Utils.findServiceByInterface(H5ConfigService.class.getName());
        }
        return this.h5ConfigService;
    }

    private void initProviderConfig() {
        try {
            H5Log.d(TAG, "initProviderConfig");
            this.configInited = true;
            long currentTimeMillis = System.currentTimeMillis();
            this.providerInfoMap = new ConcurrentHashMap();
            if (getH5ConfigService() == null || getH5ConfigService().getProviderInfoMap() == null) {
                this.providerInfoMap = H5BaseProviderInfo.providerInfoMap;
            } else {
                this.providerInfoMap = getH5ConfigService().getProviderInfoMap();
                H5Log.d(TAG, "use getH5ConfigService().getProviderInfoMap()");
            }
            H5Log.d(TAG, "Nebula cost time initProviderConfig delta ".concat(String.valueOf(System.currentTimeMillis() - currentTimeMillis)));
        } catch (Throwable th) {
            this.configInited = false;
            H5Log.e(TAG, "parse h5 external provider configuration exception.", th);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001f, code lost:
        r8 = r6.providerInfoMap.get(r7);
        r3 = r8.bundleName;
        r8 = r8.className;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void initProvider(java.lang.String r7, boolean r8) {
        /*
            r6 = this;
            java.lang.String r0 = "H5ProviderManagerImpl"
            java.util.Map<java.lang.String, com.alipay.mobile.nebula.providermanager.H5ProviderConfig> r1 = r6.providerInfoMap
            if (r1 != 0) goto L_0x0007
            return
        L_0x0007:
            long r1 = java.lang.System.currentTimeMillis()
            if (r8 == 0) goto L_0x0016
            java.util.Map<java.lang.String, java.lang.Object> r8 = r6.providerMap
            boolean r8 = r8.containsKey(r7)
            if (r8 == 0) goto L_0x0016
            return
        L_0x0016:
            java.util.Map<java.lang.String, com.alipay.mobile.nebula.providermanager.H5ProviderConfig> r8 = r6.providerInfoMap
            boolean r8 = r8.containsKey(r7)
            if (r8 != 0) goto L_0x001f
            return
        L_0x001f:
            java.util.Map<java.lang.String, com.alipay.mobile.nebula.providermanager.H5ProviderConfig> r8 = r6.providerInfoMap
            java.lang.Object r8 = r8.get(r7)
            com.alipay.mobile.nebula.providermanager.H5ProviderConfig r8 = (com.alipay.mobile.nebula.providermanager.H5ProviderConfig) r8
            java.lang.String r3 = r8.bundleName
            java.lang.String r8 = r8.className
            java.lang.Class r3 = com.alipay.mobile.nebulacore.env.H5Environment.getClass(r3, r8)
            if (r3 != 0) goto L_0x0032
            return
        L_0x0032:
            r4 = 0
            java.lang.Object r4 = r3.newInstance()     // Catch:{ all -> 0x0048 }
            if (r4 != 0) goto L_0x003a
            return
        L_0x003a:
            java.lang.String r3 = "initialize ext provider "
            java.lang.String r5 = java.lang.String.valueOf(r8)     // Catch:{ all -> 0x0048 }
            java.lang.String r3 = r3.concat(r5)     // Catch:{ all -> 0x0048 }
            com.alipay.mobile.nebula.util.H5Log.d(r0, r3)     // Catch:{ all -> 0x0048 }
            goto L_0x0056
        L_0x0048:
            r3 = move-exception
            java.lang.String r8 = java.lang.String.valueOf(r8)
            java.lang.String r5 = "failed to initialize provider "
            java.lang.String r8 = r5.concat(r8)
            com.alipay.mobile.nebula.util.H5Log.e(r0, r8, r3)
        L_0x0056:
            java.util.Map<java.lang.String, java.lang.Object> r8 = r6.providerMap
            r8.put(r7, r4)
            boolean r8 = com.alipay.mobile.nebulacore.Nebula.DEBUG
            if (r8 == 0) goto L_0x0083
            long r3 = java.lang.System.currentTimeMillis()
            long r3 = r3 - r1
            r1 = 10
            int r8 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r8 <= 0) goto L_0x0083
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r1 = "Nebula cost time initProviderConfig delta "
            r8.<init>(r1)
            r8.append(r3)
            java.lang.String r1 = " "
            r8.append(r1)
            r8.append(r7)
            java.lang.String r7 = r8.toString()
            com.alipay.mobile.nebula.util.H5Log.d(r0, r7)
        L_0x0083:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.nebulacore.manager.H5ProviderManagerImpl.initProvider(java.lang.String, boolean):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0031, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void setProvider(java.lang.String r4, java.lang.Object r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            if (r5 == 0) goto L_0x0030
            boolean r0 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x002d }
            if (r0 == 0) goto L_0x000a
            goto L_0x0030
        L_0x000a:
            java.lang.String r0 = "H5ProviderManagerImpl"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x002d }
            java.lang.String r2 = "setProvider:"
            r1.<init>(r2)     // Catch:{ all -> 0x002d }
            r1.append(r4)     // Catch:{ all -> 0x002d }
            java.lang.String r2 = " object"
            r1.append(r2)     // Catch:{ all -> 0x002d }
            r1.append(r5)     // Catch:{ all -> 0x002d }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x002d }
            com.alipay.mobile.nebula.util.H5Log.d(r0, r1)     // Catch:{ all -> 0x002d }
            java.util.Map<java.lang.String, java.lang.Object> r0 = r3.providerMap     // Catch:{ all -> 0x002d }
            r0.put(r4, r5)     // Catch:{ all -> 0x002d }
            monitor-exit(r3)
            return
        L_0x002d:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        L_0x0030:
            monitor-exit(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.nebulacore.manager.H5ProviderManagerImpl.setProvider(java.lang.String, java.lang.Object):void");
    }

    public final synchronized <T> T getProvider(String str) {
        return getProviderUseCache(str, true);
    }

    public final synchronized <T> T getProviderUseCache(String str, boolean z) {
        if (!this.configInited) {
            initProviderConfig();
        }
        if (this.providerInfoMap != null && this.providerInfoMap.containsKey(str)) {
            initProvider(str, z);
        }
        if (!this.providerMap.containsKey(str)) {
            return null;
        }
        return this.providerMap.get(str);
    }

    public final synchronized boolean removeProvider(String str) {
        H5Log.d(TAG, "removeProvider:".concat(String.valueOf(str)));
        return this.providerMap.remove(str) != null;
    }
}
