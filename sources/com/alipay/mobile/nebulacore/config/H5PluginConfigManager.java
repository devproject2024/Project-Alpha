package com.alipay.mobile.nebulacore.config;

import com.alipay.mobile.nebula.config.H5PluginConfig;
import java.util.ArrayList;
import java.util.List;

public class H5PluginConfigManager {
    public static final String TAG = "H5PluginConfigManager";
    private static H5PluginConfigManager instance;
    private List<H5PluginConfig> pluginsConfig = new ArrayList();

    private H5PluginConfigManager() {
    }

    public static synchronized H5PluginConfigManager getInstance() {
        H5PluginConfigManager h5PluginConfigManager;
        synchronized (H5PluginConfigManager.class) {
            if (instance == null) {
                instance = new H5PluginConfigManager();
            }
            h5PluginConfigManager = instance;
        }
        return h5PluginConfigManager;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0042, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void addConfig(com.alipay.mobile.nebula.config.H5PluginConfig r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            if (r4 == 0) goto L_0x0041
            boolean r0 = r4.configInvalid()     // Catch:{ all -> 0x003e }
            if (r0 == 0) goto L_0x000a
            goto L_0x0041
        L_0x000a:
            java.lang.String r0 = "H5PluginConfigManager"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x003e }
            java.lang.String r2 = "addConfig "
            r1.<init>(r2)     // Catch:{ all -> 0x003e }
            java.lang.String r2 = r4.bundleName     // Catch:{ all -> 0x003e }
            r1.append(r2)     // Catch:{ all -> 0x003e }
            java.lang.String r2 = "/"
            r1.append(r2)     // Catch:{ all -> 0x003e }
            java.lang.String r2 = r4.className     // Catch:{ all -> 0x003e }
            r1.append(r2)     // Catch:{ all -> 0x003e }
            java.lang.String r2 = "/"
            r1.append(r2)     // Catch:{ all -> 0x003e }
            java.util.List<java.lang.String> r2 = r4.eventList     // Catch:{ all -> 0x003e }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x003e }
            r1.append(r2)     // Catch:{ all -> 0x003e }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x003e }
            com.alipay.mobile.nebula.util.H5Log.debug(r0, r1)     // Catch:{ all -> 0x003e }
            java.util.List<com.alipay.mobile.nebula.config.H5PluginConfig> r0 = r3.pluginsConfig     // Catch:{ all -> 0x003e }
            r0.add(r4)     // Catch:{ all -> 0x003e }
            monitor-exit(r3)
            return
        L_0x003e:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        L_0x0041:
            monitor-exit(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.nebulacore.config.H5PluginConfigManager.addConfig(com.alipay.mobile.nebula.config.H5PluginConfig):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0015, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void addH5PluginConfigList(java.util.List<com.alipay.mobile.nebula.config.H5PluginConfig> r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            if (r2 == 0) goto L_0x0014
            boolean r0 = r2.isEmpty()     // Catch:{ all -> 0x0011 }
            if (r0 == 0) goto L_0x000a
            goto L_0x0014
        L_0x000a:
            java.util.List<com.alipay.mobile.nebula.config.H5PluginConfig> r0 = r1.pluginsConfig     // Catch:{ all -> 0x0011 }
            r0.addAll(r2)     // Catch:{ all -> 0x0011 }
            monitor-exit(r1)
            return
        L_0x0011:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        L_0x0014:
            monitor-exit(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.nebulacore.config.H5PluginConfigManager.addH5PluginConfigList(java.util.List):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0068, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized com.alipay.mobile.h5container.api.H5Plugin createPlugin(java.lang.String r8, com.alipay.mobile.h5container.api.H5PluginManager r9) {
        /*
            r7 = this;
            monitor-enter(r7)
            java.util.List<com.alipay.mobile.nebula.config.H5PluginConfig> r0 = r7.pluginsConfig     // Catch:{ all -> 0x0069 }
            r1 = 0
            if (r0 == 0) goto L_0x0067
            java.util.List<com.alipay.mobile.nebula.config.H5PluginConfig> r0 = r7.pluginsConfig     // Catch:{ all -> 0x0069 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0069 }
            if (r0 != 0) goto L_0x0067
            if (r9 != 0) goto L_0x0011
            goto L_0x0067
        L_0x0011:
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0069 }
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x0069 }
            r0.<init>()     // Catch:{ all -> 0x0069 }
            java.util.List<com.alipay.mobile.nebula.config.H5PluginConfig> r4 = r7.pluginsConfig     // Catch:{ all -> 0x0069 }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ all -> 0x0069 }
        L_0x0020:
            boolean r5 = r4.hasNext()     // Catch:{ all -> 0x0069 }
            if (r5 == 0) goto L_0x0038
            java.lang.Object r5 = r4.next()     // Catch:{ all -> 0x0069 }
            com.alipay.mobile.nebula.config.H5PluginConfig r5 = (com.alipay.mobile.nebula.config.H5PluginConfig) r5     // Catch:{ all -> 0x0069 }
            java.lang.String r6 = r5.scope     // Catch:{ all -> 0x0069 }
            boolean r6 = r8.equals(r6)     // Catch:{ all -> 0x0069 }
            if (r6 == 0) goto L_0x0020
            r0.add(r5)     // Catch:{ all -> 0x0069 }
            goto L_0x0020
        L_0x0038:
            boolean r4 = r0.isEmpty()     // Catch:{ all -> 0x0069 }
            if (r4 == 0) goto L_0x0040
            monitor-exit(r7)
            return r1
        L_0x0040:
            com.alipay.mobile.nebulacore.config.H5PluginProxy r1 = new com.alipay.mobile.nebulacore.config.H5PluginProxy     // Catch:{ all -> 0x0069 }
            r1.<init>(r0, r9)     // Catch:{ all -> 0x0069 }
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0069 }
            long r4 = r4 - r2
            java.lang.String r9 = "H5PluginConfigManager"
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0069 }
            java.lang.String r2 = "createPlugin "
            r0.<init>(r2)     // Catch:{ all -> 0x0069 }
            r0.append(r8)     // Catch:{ all -> 0x0069 }
            java.lang.String r8 = " elapse "
            r0.append(r8)     // Catch:{ all -> 0x0069 }
            r0.append(r4)     // Catch:{ all -> 0x0069 }
            java.lang.String r8 = r0.toString()     // Catch:{ all -> 0x0069 }
            com.alipay.mobile.nebula.util.H5Log.d(r9, r8)     // Catch:{ all -> 0x0069 }
            monitor-exit(r7)
            return r1
        L_0x0067:
            monitor-exit(r7)
            return r1
        L_0x0069:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.nebulacore.config.H5PluginConfigManager.createPlugin(java.lang.String, com.alipay.mobile.h5container.api.H5PluginManager):com.alipay.mobile.h5container.api.H5Plugin");
    }
}
