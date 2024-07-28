package com.alipay.mobile.h5container.api;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

public class H5PageCount {
    private static long sRamSize = -100;
    private static List<String> urls = new ArrayList();

    public static void addUrl(String str) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (urls) {
                urls.add(str);
            }
        }
    }

    public static void removeUrl(String str) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (urls) {
                urls.remove(str);
            }
        }
    }

    public static String getAll() {
        StringBuilder sb = new StringBuilder();
        synchronized (urls) {
            for (int i2 = 0; i2 < urls.size(); i2++) {
                if (i2 != 0) {
                    sb.append("->");
                }
                sb.append(urls.get(i2));
            }
        }
        return sb.toString();
    }

    public static String totalRamMemorySize(Context context) {
        return String.valueOf(getTotalMemory(context) / 1048576);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        sRamSize = -1;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0030 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static long getTotalMemory(android.content.Context r7) {
        /*
            long r0 = sRamSize
            r2 = -1
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L_0x0009
            return r0
        L_0x0009:
            r4 = -100
            int r6 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r6 != 0) goto L_0x0037
            java.lang.Class<com.alipay.mobile.h5container.api.H5PageCount> r0 = com.alipay.mobile.h5container.api.H5PageCount.class
            monitor-enter(r0)
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0030 }
            r4 = 16
            if (r1 < r4) goto L_0x002d
            android.app.ActivityManager$MemoryInfo r1 = new android.app.ActivityManager$MemoryInfo     // Catch:{ all -> 0x0030 }
            r1.<init>()     // Catch:{ all -> 0x0030 }
            java.lang.String r4 = "activity"
            java.lang.Object r7 = r7.getSystemService(r4)     // Catch:{ all -> 0x0030 }
            android.app.ActivityManager r7 = (android.app.ActivityManager) r7     // Catch:{ all -> 0x0030 }
            r7.getMemoryInfo(r1)     // Catch:{ all -> 0x0030 }
            long r4 = r1.totalMem     // Catch:{ all -> 0x0030 }
            sRamSize = r4     // Catch:{ all -> 0x0030 }
            goto L_0x0032
        L_0x002d:
            sRamSize = r2     // Catch:{ all -> 0x0030 }
            goto L_0x0032
        L_0x0030:
            sRamSize = r2     // Catch:{ all -> 0x0034 }
        L_0x0032:
            monitor-exit(r0)     // Catch:{ all -> 0x0034 }
            goto L_0x0037
        L_0x0034:
            r7 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0034 }
            throw r7
        L_0x0037:
            long r0 = sRamSize
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.h5container.api.H5PageCount.getTotalMemory(android.content.Context):long");
    }
}
