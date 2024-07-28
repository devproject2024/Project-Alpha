package com.alipay.mobile.nebulacore.embedview;

import com.alipay.mobile.nebula.config.H5EmbedViewConfig;
import com.alipay.mobile.nebula.util.H5Log;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class H5EmbededViewConfigManager {
    public static final String TAG = "H5EmbededViewConfigManager";
    private static H5EmbededViewConfigManager sInstance;
    private Map<String, H5EmbedViewConfig> viewsConfig = new ConcurrentHashMap();

    private H5EmbededViewConfigManager() {
    }

    public static H5EmbededViewConfigManager getInstance() {
        if (sInstance == null) {
            synchronized (H5EmbededViewConfigManager.class) {
                if (sInstance == null) {
                    sInstance = new H5EmbededViewConfigManager();
                }
            }
        }
        return sInstance;
    }

    public synchronized void addTypeConfig(H5EmbedViewConfig h5EmbedViewConfig) {
        if (h5EmbedViewConfig != null) {
            String type = h5EmbedViewConfig.getType();
            String bundleName = h5EmbedViewConfig.getBundleName();
            String className = h5EmbedViewConfig.getClassName();
            H5Log.debug(TAG, "addType " + bundleName + "/" + className + "/" + type);
            if (this.viewsConfig.containsKey(type)) {
                H5Log.d(TAG, "addType repeated type ".concat(String.valueOf(type)));
            } else {
                this.viewsConfig.put(type, h5EmbedViewConfig);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0024, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void addTypeConfigs(java.util.List<com.alipay.mobile.nebula.config.H5EmbedViewConfig> r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            if (r2 == 0) goto L_0x0023
            boolean r0 = r2.isEmpty()     // Catch:{ all -> 0x0020 }
            if (r0 == 0) goto L_0x000a
            goto L_0x0023
        L_0x000a:
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x0020 }
        L_0x000e:
            boolean r0 = r2.hasNext()     // Catch:{ all -> 0x0020 }
            if (r0 == 0) goto L_0x001e
            java.lang.Object r0 = r2.next()     // Catch:{ all -> 0x0020 }
            com.alipay.mobile.nebula.config.H5EmbedViewConfig r0 = (com.alipay.mobile.nebula.config.H5EmbedViewConfig) r0     // Catch:{ all -> 0x0020 }
            r1.addTypeConfig(r0)     // Catch:{ all -> 0x0020 }
            goto L_0x000e
        L_0x001e:
            monitor-exit(r1)
            return
        L_0x0020:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        L_0x0023:
            monitor-exit(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.nebulacore.embedview.H5EmbededViewConfigManager.addTypeConfigs(java.util.List):void");
    }

    public H5EmbedViewConfig getConfig(String str) {
        return this.viewsConfig.get(str);
    }
}
