package com.alipay.mobile.nebula.appcenter.res;

import com.alipay.mobile.nebula.util.H5Utils;
import java.util.HashMap;
import java.util.Map;

public class H5ResourceManager {
    public static final String TAG = "H5ResourceManager";
    private static final Map<Integer, String> resMap = new HashMap();

    public static synchronized String getRaw(int i2) {
        String str;
        synchronized (H5ResourceManager.class) {
            if (!resMap.containsKey(Integer.valueOf(i2))) {
                resMap.put(Integer.valueOf(i2), readRaw(i2));
            }
            str = resMap.get(Integer.valueOf(i2));
        }
        return str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0049 A[SYNTHETIC, Splitter:B:20:0x0049] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String readRawFromResource(int r7, android.content.res.Resources r8) {
        /*
            java.lang.String r0 = "exception detail"
            java.lang.String r1 = "H5ResourceManager"
            long r2 = java.lang.System.currentTimeMillis()
            r4 = 0
            java.io.InputStream r7 = r8.openRawResource(r7)     // Catch:{ all -> 0x0040 }
            java.io.InputStreamReader r8 = new java.io.InputStreamReader     // Catch:{ all -> 0x003e }
            r8.<init>(r7)     // Catch:{ all -> 0x003e }
            java.io.BufferedReader r5 = new java.io.BufferedReader     // Catch:{ all -> 0x003e }
            r5.<init>(r8)     // Catch:{ all -> 0x003e }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x003e }
            r8.<init>()     // Catch:{ all -> 0x003e }
            java.lang.String r6 = r5.readLine()     // Catch:{ all -> 0x003e }
        L_0x0020:
            if (r6 == 0) goto L_0x002f
            r8.append(r6)     // Catch:{ all -> 0x003e }
            r6 = 10
            r8.append(r6)     // Catch:{ all -> 0x003e }
            java.lang.String r6 = r5.readLine()     // Catch:{ all -> 0x003e }
            goto L_0x0020
        L_0x002f:
            java.lang.String r4 = r8.toString()     // Catch:{ all -> 0x003e }
            if (r7 == 0) goto L_0x004c
            r7.close()     // Catch:{ all -> 0x0039 }
            goto L_0x004c
        L_0x0039:
            r7 = move-exception
            com.alipay.mobile.nebula.util.H5Log.e(r1, r0, r7)
            goto L_0x004c
        L_0x003e:
            r8 = move-exception
            goto L_0x0042
        L_0x0040:
            r8 = move-exception
            r7 = r4
        L_0x0042:
            java.lang.String r5 = "Exception"
            com.alipay.mobile.nebula.util.H5Log.e(r1, r5, r8)     // Catch:{ all -> 0x0063 }
            if (r7 == 0) goto L_0x004c
            r7.close()     // Catch:{ all -> 0x0039 }
        L_0x004c:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "readRaw elapse "
            r7.<init>(r8)
            long r5 = java.lang.System.currentTimeMillis()
            long r5 = r5 - r2
            r7.append(r5)
            java.lang.String r7 = r7.toString()
            com.alipay.mobile.nebula.util.H5Log.d(r1, r7)
            return r4
        L_0x0063:
            r8 = move-exception
            if (r7 == 0) goto L_0x006e
            r7.close()     // Catch:{ all -> 0x006a }
            goto L_0x006e
        L_0x006a:
            r7 = move-exception
            com.alipay.mobile.nebula.util.H5Log.e(r1, r0, r7)
        L_0x006e:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.nebula.appcenter.res.H5ResourceManager.readRawFromResource(int, android.content.res.Resources):java.lang.String");
    }

    public static String readRaw(int i2) {
        return readRawFromResource(i2, H5Utils.getNebulaCoreResources());
    }
}
