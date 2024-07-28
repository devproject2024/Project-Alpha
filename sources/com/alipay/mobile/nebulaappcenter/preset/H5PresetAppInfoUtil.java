package com.alipay.mobile.nebulaappcenter.preset;

import com.alipay.mobile.nebula.appcenter.model.AppInfo;
import java.util.concurrent.ConcurrentHashMap;

public class H5PresetAppInfoUtil {
    private static final String TAG = "H5PresetAppInfoUtil";
    /* access modifiers changed from: private */
    public static ConcurrentHashMap<String, AppInfo> sAppInfoMap = new ConcurrentHashMap<>();

    /* JADX WARNING: Removed duplicated region for block: B:36:0x00bd A[Catch:{ Exception -> 0x010d }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00c3 A[Catch:{ Exception -> 0x010d }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.alipay.mobile.nebula.appcenter.model.AppInfo getPresetAppInfo(java.lang.String r9) {
        /*
            java.lang.String r0 = "H5PresetAppInfoUtil"
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.alipay.mobile.nebula.appcenter.model.AppInfo> r1 = sAppInfoMap
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x0113
            java.lang.Class<com.alipay.mobile.nebula.provider.H5AppCenterPresetProvider> r1 = com.alipay.mobile.nebula.provider.H5AppCenterPresetProvider.class
            java.lang.String r1 = r1.getName()
            java.lang.Object r1 = com.alipay.mobile.nebula.util.H5Utils.getProvider(r1)
            com.alipay.mobile.nebula.provider.H5AppCenterPresetProvider r1 = (com.alipay.mobile.nebula.provider.H5AppCenterPresetProvider) r1
            if (r1 == 0) goto L_0x0113
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x010d }
            java.io.InputStream r4 = r1.getPresetAppInfoObject()     // Catch:{ Exception -> 0x010d }
            if (r4 == 0) goto L_0x0061
            java.io.ObjectInputStream r5 = new java.io.ObjectInputStream     // Catch:{ Exception -> 0x010d }
            r5.<init>(r4)     // Catch:{ Exception -> 0x010d }
            java.lang.Object r6 = r5.readObject()     // Catch:{ EOFException -> 0x0030 }
            java.util.concurrent.ConcurrentHashMap r6 = (java.util.concurrent.ConcurrentHashMap) r6     // Catch:{ EOFException -> 0x0030 }
            sAppInfoMap = r6     // Catch:{ EOFException -> 0x0030 }
            goto L_0x0034
        L_0x0030:
            r6 = move-exception
            com.alipay.mobile.nebula.util.H5Log.e((java.lang.String) r0, (java.lang.Throwable) r6)     // Catch:{ Exception -> 0x010d }
        L_0x0034:
            r5.close()     // Catch:{ Exception -> 0x010d }
            r4.close()     // Catch:{ Exception -> 0x010d }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x010d }
            java.lang.String r5 = "getPresetAppInfoObject cost "
            r4.<init>(r5)     // Catch:{ Exception -> 0x010d }
            long r5 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x010d }
            long r5 = r5 - r2
            r4.append(r5)     // Catch:{ Exception -> 0x010d }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x010d }
            com.alipay.mobile.nebula.util.H5Log.d(r0, r4)     // Catch:{ Exception -> 0x010d }
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.alipay.mobile.nebula.appcenter.model.AppInfo> r4 = sAppInfoMap     // Catch:{ Exception -> 0x010d }
            boolean r4 = r4.isEmpty()     // Catch:{ Exception -> 0x010d }
            if (r4 != 0) goto L_0x0061
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.alipay.mobile.nebula.appcenter.model.AppInfo> r1 = sAppInfoMap     // Catch:{ Exception -> 0x010d }
            java.lang.Object r1 = r1.get(r9)     // Catch:{ Exception -> 0x010d }
            com.alipay.mobile.nebula.appcenter.model.AppInfo r1 = (com.alipay.mobile.nebula.appcenter.model.AppInfo) r1     // Catch:{ Exception -> 0x010d }
            return r1
        L_0x0061:
            java.io.InputStream r1 = r1.getPresetAppInfo()     // Catch:{ Exception -> 0x010d }
            if (r1 == 0) goto L_0x0113
            java.lang.String r4 = com.alipay.mobile.nebulaappcenter.util.H5AppGlobal.getFromAssets(r1)     // Catch:{ Exception -> 0x010d }
            r1.close()     // Catch:{ Exception -> 0x010d }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x010d }
            java.lang.String r5 = "h5PresetFroMemory loadPresetApp len: "
            r1.<init>(r5)     // Catch:{ Exception -> 0x010d }
            int r5 = r4.length()     // Catch:{ Exception -> 0x010d }
            r1.append(r5)     // Catch:{ Exception -> 0x010d }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x010d }
            com.alipay.mobile.nebula.util.H5Log.d(r0, r1)     // Catch:{ Exception -> 0x010d }
            com.alibaba.a.e r1 = com.alipay.mobile.nebula.util.H5Utils.parseObject(r4)     // Catch:{ Exception -> 0x010d }
            java.lang.String r4 = "data"
            r5 = 0
            com.alibaba.a.b r1 = com.alipay.mobile.nebula.util.H5Utils.getJSONArray(r1, r4, r5)     // Catch:{ Exception -> 0x010d }
            if (r1 != 0) goto L_0x0096
            java.lang.String r1 = "dataList == null return"
            com.alipay.mobile.nebula.util.H5Log.e((java.lang.String) r0, (java.lang.String) r1)     // Catch:{ Exception -> 0x010d }
            return r5
        L_0x0096:
            r4 = 0
        L_0x0097:
            int r6 = r1.size()     // Catch:{ Exception -> 0x010d }
            if (r4 >= r6) goto L_0x00e0
            java.lang.Object r6 = r1.get(r4)     // Catch:{ Exception -> 0x00b6 }
            boolean r6 = r6 instanceof com.alibaba.a.e     // Catch:{ Exception -> 0x00b6 }
            if (r6 == 0) goto L_0x00b0
            java.lang.Object r6 = r1.get(r4)     // Catch:{ Exception -> 0x00b6 }
            com.alibaba.a.e r6 = (com.alibaba.a.e) r6     // Catch:{ Exception -> 0x00b6 }
            com.alipay.mobile.nebula.appcenter.model.AppInfo r6 = com.alipay.mobile.nebula.appcenter.util.H5AppUtil.toAppInfo(r6)     // Catch:{ Exception -> 0x00b6 }
            goto L_0x00bb
        L_0x00b0:
            java.lang.String r6 = "dataList.get(index) is not JSONObject"
            com.alipay.mobile.nebula.util.H5Log.d(r0, r6)     // Catch:{ Exception -> 0x00b6 }
            goto L_0x00ba
        L_0x00b6:
            r6 = move-exception
            com.alipay.mobile.nebula.util.H5Log.e((java.lang.String) r0, (java.lang.Throwable) r6)     // Catch:{ Exception -> 0x010d }
        L_0x00ba:
            r6 = r5
        L_0x00bb:
            if (r6 != 0) goto L_0x00c3
            java.lang.String r6 = "appInfo == null continue "
            com.alipay.mobile.nebula.util.H5Log.d(r0, r6)     // Catch:{ Exception -> 0x010d }
            goto L_0x00dd
        L_0x00c3:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x010d }
            java.lang.String r8 = "preset appId:"
            r7.<init>(r8)     // Catch:{ Exception -> 0x010d }
            java.lang.String r8 = r6.app_id     // Catch:{ Exception -> 0x010d }
            r7.append(r8)     // Catch:{ Exception -> 0x010d }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x010d }
            com.alipay.mobile.nebula.util.H5Log.d(r0, r7)     // Catch:{ Exception -> 0x010d }
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.alipay.mobile.nebula.appcenter.model.AppInfo> r7 = sAppInfoMap     // Catch:{ Exception -> 0x010d }
            java.lang.String r8 = r6.app_id     // Catch:{ Exception -> 0x010d }
            r7.put(r8, r6)     // Catch:{ Exception -> 0x010d }
        L_0x00dd:
            int r4 = r4 + 1
            goto L_0x0097
        L_0x00e0:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x010d }
            java.lang.String r4 = "h5PresetFroMemory cost "
            r1.<init>(r4)     // Catch:{ Exception -> 0x010d }
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x010d }
            long r4 = r4 - r2
            r1.append(r4)     // Catch:{ Exception -> 0x010d }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x010d }
            com.alipay.mobile.nebula.util.H5Log.d(r0, r1)     // Catch:{ Exception -> 0x010d }
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.alipay.mobile.nebula.appcenter.model.AppInfo> r1 = sAppInfoMap     // Catch:{ Exception -> 0x010d }
            boolean r1 = r1.isEmpty()     // Catch:{ Exception -> 0x010d }
            if (r1 != 0) goto L_0x0113
            java.lang.String r1 = "IO"
            java.util.concurrent.ThreadPoolExecutor r1 = com.alipay.mobile.nebula.util.H5Utils.getExecutor(r1)     // Catch:{ Exception -> 0x010d }
            com.alipay.mobile.nebulaappcenter.preset.H5PresetAppInfoUtil$1 r4 = new com.alipay.mobile.nebulaappcenter.preset.H5PresetAppInfoUtil$1     // Catch:{ Exception -> 0x010d }
            r4.<init>(r2)     // Catch:{ Exception -> 0x010d }
            r1.execute(r4)     // Catch:{ Exception -> 0x010d }
            goto L_0x0113
        L_0x010d:
            r1 = move-exception
            java.lang.String r2 = "Exception:"
            com.alipay.mobile.nebula.util.H5Log.e(r0, r2, r1)
        L_0x0113:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.alipay.mobile.nebula.appcenter.model.AppInfo> r0 = sAppInfoMap
            java.lang.Object r9 = r0.get(r9)
            com.alipay.mobile.nebula.appcenter.model.AppInfo r9 = (com.alipay.mobile.nebula.appcenter.model.AppInfo) r9
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.nebulaappcenter.preset.H5PresetAppInfoUtil.getPresetAppInfo(java.lang.String):com.alipay.mobile.nebula.appcenter.model.AppInfo");
    }

    public static void clearPresetMemory() {
        sAppInfoMap.clear();
    }
}
