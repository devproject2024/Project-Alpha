package com.alipay.mobile.nebulacore.web;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.a.b;
import com.alibaba.a.e;
import com.alipay.mobile.nebula.appcenter.apphandler.H5AppHandler;
import com.alipay.mobile.nebula.provider.H5ConfigProvider;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebulacore.Nebula;
import com.alipay.mobile.nebulacore.env.H5Environment;

public class H5HardwarePolicy {
    private static final String TAG = "H5HardwarePolicy";
    private static boolean disableHWACByHWInfo = false;
    private static boolean hasParseDisableHWACByHardwareInfo = false;

    public static boolean isAbove14Level() {
        return Build.VERSION.SDK_INT >= 14;
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x006d A[Catch:{ all -> 0x01b1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0089 A[Catch:{ all -> 0x01b1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0158 A[Catch:{ all -> 0x01b1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0160 A[Catch:{ all -> 0x01b1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0199 A[Catch:{ all -> 0x01b1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x01a6 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static synchronized boolean disableHWACByHardwareInfo() {
        /*
            java.lang.Class<com.alipay.mobile.nebulacore.web.H5HardwarePolicy> r1 = com.alipay.mobile.nebulacore.web.H5HardwarePolicy.class
            monitor-enter(r1)
            boolean r0 = hasParseDisableHWACByHardwareInfo     // Catch:{ all -> 0x01bd }
            if (r0 == 0) goto L_0x000b
            boolean r0 = disableHWACByHWInfo     // Catch:{ all -> 0x01bd }
            monitor-exit(r1)
            return r0
        L_0x000b:
            r0 = 1
            hasParseDisableHWACByHardwareInfo = r0     // Catch:{ all -> 0x01bd }
            java.lang.Class<com.alipay.mobile.nebula.provider.H5ConfigProvider> r2 = com.alipay.mobile.nebula.provider.H5ConfigProvider.class
            java.lang.String r2 = r2.getName()     // Catch:{ all -> 0x01b1 }
            java.lang.Object r2 = com.alipay.mobile.nebula.util.H5Utils.getProvider(r2)     // Catch:{ all -> 0x01b1 }
            com.alipay.mobile.nebula.provider.H5ConfigProvider r2 = (com.alipay.mobile.nebula.provider.H5ConfigProvider) r2     // Catch:{ all -> 0x01b1 }
            if (r2 == 0) goto L_0x01b9
            java.lang.String r3 = "h5_disableHWACByHardwareInfo"
            java.lang.String r2 = r2.getConfig(r3)     // Catch:{ all -> 0x01b1 }
            java.lang.String r3 = "H5HardwarePolicy"
            java.lang.String r4 = "disableHWACByHardwareInfo:"
            java.lang.String r5 = java.lang.String.valueOf(r2)     // Catch:{ all -> 0x01b1 }
            java.lang.String r4 = r4.concat(r5)     // Catch:{ all -> 0x01b1 }
            com.alipay.mobile.nebula.util.H5Log.d(r3, r4)     // Catch:{ all -> 0x01b1 }
            com.alibaba.a.b r2 = com.alipay.mobile.nebula.util.H5Utils.parseArray(r2)     // Catch:{ all -> 0x01b1 }
            r3 = 0
            if (r2 != 0) goto L_0x003a
            monitor-exit(r1)
            return r3
        L_0x003a:
            int r4 = r2.size()     // Catch:{ all -> 0x01b1 }
            r5 = 0
        L_0x003f:
            if (r5 >= r4) goto L_0x01b9
            com.alibaba.a.e r6 = r2.getJSONObject(r5)     // Catch:{ all -> 0x01b1 }
            java.lang.String r7 = "sdkLevelRange"
            r8 = 0
            com.alibaba.a.e r7 = com.alipay.mobile.nebula.util.H5Utils.getJSONObject(r6, r7, r8)     // Catch:{ all -> 0x01b1 }
            r9 = -2147483648(0xffffffff80000000, float:-0.0)
            r10 = 2147483647(0x7fffffff, float:NaN)
            if (r7 == 0) goto L_0x006a
            java.lang.String r11 = "max"
            int r11 = com.alipay.mobile.nebula.util.H5Utils.getInt((com.alibaba.a.e) r7, (java.lang.String) r11, (int) r10)     // Catch:{ all -> 0x01b1 }
            java.lang.String r12 = "min"
            int r7 = com.alipay.mobile.nebula.util.H5Utils.getInt((com.alibaba.a.e) r7, (java.lang.String) r12, (int) r9)     // Catch:{ all -> 0x01b1 }
            int r12 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x01b1 }
            if (r12 < r7) goto L_0x0068
            int r7 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x01b1 }
            if (r7 > r11) goto L_0x0068
            goto L_0x006a
        L_0x0068:
            r7 = 0
            goto L_0x006b
        L_0x006a:
            r7 = 1
        L_0x006b:
            if (r7 != 0) goto L_0x0089
            java.lang.String r6 = "H5HardwarePolicy"
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x01b1 }
            java.lang.String r8 = "disableHWACByHardwareInfo sdk "
            r7.<init>(r8)     // Catch:{ all -> 0x01b1 }
            int r8 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x01b1 }
            r7.append(r8)     // Catch:{ all -> 0x01b1 }
            java.lang.String r8 = " not match"
            r7.append(r8)     // Catch:{ all -> 0x01b1 }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x01b1 }
            com.alipay.mobile.nebula.util.H5Log.d(r6, r7)     // Catch:{ all -> 0x01b1 }
            goto L_0x01a0
        L_0x0089:
            java.lang.String r7 = "models"
            com.alibaba.a.b r7 = com.alipay.mobile.nebula.util.H5Utils.getJSONArray(r6, r7, r8)     // Catch:{ all -> 0x01b1 }
            if (r7 == 0) goto L_0x00be
            int r11 = r7.size()     // Catch:{ all -> 0x01b1 }
            r12 = 0
            r13 = 1
        L_0x0097:
            if (r12 >= r11) goto L_0x00bf
            java.lang.String r13 = r7.getString(r12)     // Catch:{ all -> 0x01b1 }
            java.lang.String r14 = "H5HardwarePolicy"
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ all -> 0x01b1 }
            java.lang.String r3 = "disableHWACByHardwareInfo model "
            r15.<init>(r3)     // Catch:{ all -> 0x01b1 }
            java.lang.String r3 = android.os.Build.MODEL     // Catch:{ all -> 0x01b1 }
            r15.append(r3)     // Catch:{ all -> 0x01b1 }
            java.lang.String r3 = r15.toString()     // Catch:{ all -> 0x01b1 }
            com.alipay.mobile.nebula.util.H5Log.d(r14, r3)     // Catch:{ all -> 0x01b1 }
            java.lang.String r3 = android.os.Build.MODEL     // Catch:{ all -> 0x01b1 }
            boolean r13 = r3.equalsIgnoreCase(r13)     // Catch:{ all -> 0x01b1 }
            if (r13 != 0) goto L_0x00bf
            int r12 = r12 + 1
            r3 = 0
            goto L_0x0097
        L_0x00be:
            r13 = 1
        L_0x00bf:
            if (r13 != 0) goto L_0x00ca
            java.lang.String r3 = "H5HardwarePolicy"
            java.lang.String r6 = "disableHWACByHardwareInfo model not match"
            com.alipay.mobile.nebula.util.H5Log.d(r3, r6)     // Catch:{ all -> 0x01b1 }
            goto L_0x01a0
        L_0x00ca:
            java.lang.String r3 = "boards"
            com.alibaba.a.b r3 = com.alipay.mobile.nebula.util.H5Utils.getJSONArray(r6, r3, r8)     // Catch:{ all -> 0x01b1 }
            if (r3 == 0) goto L_0x0113
            int r7 = r3.size()     // Catch:{ all -> 0x01b1 }
            r11 = 0
            r12 = 1
        L_0x00d8:
            if (r11 >= r7) goto L_0x0114
            java.lang.String r13 = r3.getString(r11)     // Catch:{ all -> 0x01b1 }
            java.lang.String r14 = com.alipay.mobile.nebula.util.H5DeviceHelper.getCpuHardware()     // Catch:{ all -> 0x01b1 }
            java.lang.String r15 = "H5HardwarePolicy"
            java.lang.String r0 = "disableHWACByHardwareInfo cpuHardWare "
            java.lang.String r9 = java.lang.String.valueOf(r14)     // Catch:{ all -> 0x01b1 }
            java.lang.String r0 = r0.concat(r9)     // Catch:{ all -> 0x01b1 }
            com.alipay.mobile.nebula.util.H5Log.d(r15, r0)     // Catch:{ all -> 0x01b1 }
            if (r14 == 0) goto L_0x010b
            java.lang.String r0 = "\\s+"
            java.lang.String r9 = ""
            java.lang.String r0 = r14.replaceAll(r0, r9)     // Catch:{ all -> 0x01b1 }
            boolean r9 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x01b1 }
            if (r9 != 0) goto L_0x0109
            boolean r0 = r0.contains(r13)     // Catch:{ all -> 0x01b1 }
            if (r0 == 0) goto L_0x0109
            r0 = 1
            goto L_0x010a
        L_0x0109:
            r0 = 0
        L_0x010a:
            r12 = r0
        L_0x010b:
            if (r12 != 0) goto L_0x0114
            int r11 = r11 + 1
            r0 = 1
            r9 = -2147483648(0xffffffff80000000, float:-0.0)
            goto L_0x00d8
        L_0x0113:
            r12 = 1
        L_0x0114:
            if (r12 != 0) goto L_0x011f
            java.lang.String r0 = "H5HardwarePolicy"
            java.lang.String r3 = "disableHWACByHardwareInfo board not match"
            com.alipay.mobile.nebula.util.H5Log.d(r0, r3)     // Catch:{ all -> 0x01b1 }
            goto L_0x01a0
        L_0x011f:
            java.lang.String r0 = "screenHeightRange"
            com.alibaba.a.e r0 = com.alipay.mobile.nebula.util.H5Utils.getJSONObject(r6, r0, r8)     // Catch:{ all -> 0x01b1 }
            if (r0 == 0) goto L_0x0155
            java.lang.String r3 = "max"
            int r3 = com.alipay.mobile.nebula.util.H5Utils.getInt((com.alibaba.a.e) r0, (java.lang.String) r3, (int) r10)     // Catch:{ all -> 0x01b1 }
            java.lang.String r7 = "min"
            r9 = -2147483648(0xffffffff80000000, float:-0.0)
            int r0 = com.alipay.mobile.nebula.util.H5Utils.getInt((com.alibaba.a.e) r0, (java.lang.String) r7, (int) r9)     // Catch:{ all -> 0x01b1 }
            android.content.Context r7 = com.alipay.mobile.nebula.util.H5Utils.getContext()     // Catch:{ all -> 0x01b1 }
            if (r7 == 0) goto L_0x0155
            int r7 = com.alipay.mobile.nebula.util.H5DimensionUtil.getScreenHeight(r7)     // Catch:{ all -> 0x01b1 }
            java.lang.String r9 = "H5HardwarePolicy"
            java.lang.String r11 = "disableHWACByHardwareInfo screenHeight "
            java.lang.String r12 = java.lang.String.valueOf(r7)     // Catch:{ all -> 0x01b1 }
            java.lang.String r11 = r11.concat(r12)     // Catch:{ all -> 0x01b1 }
            com.alipay.mobile.nebula.util.H5Log.d(r9, r11)     // Catch:{ all -> 0x01b1 }
            if (r7 < r0) goto L_0x0153
            if (r7 > r3) goto L_0x0153
            goto L_0x0155
        L_0x0153:
            r0 = 0
            goto L_0x0156
        L_0x0155:
            r0 = 1
        L_0x0156:
            if (r0 != 0) goto L_0x0160
            java.lang.String r0 = "H5HardwarePolicy"
            java.lang.String r3 = "disableHWACByHardwareInfo screenHeight not match"
            com.alipay.mobile.nebula.util.H5Log.d(r0, r3)     // Catch:{ all -> 0x01b1 }
            goto L_0x01a0
        L_0x0160:
            java.lang.String r0 = "screenWidthRange"
            com.alibaba.a.e r0 = com.alipay.mobile.nebula.util.H5Utils.getJSONObject(r6, r0, r8)     // Catch:{ all -> 0x01b1 }
            if (r0 == 0) goto L_0x0196
            java.lang.String r3 = "max"
            int r3 = com.alipay.mobile.nebula.util.H5Utils.getInt((com.alibaba.a.e) r0, (java.lang.String) r3, (int) r10)     // Catch:{ all -> 0x01b1 }
            java.lang.String r6 = "min"
            r7 = -2147483648(0xffffffff80000000, float:-0.0)
            int r0 = com.alipay.mobile.nebula.util.H5Utils.getInt((com.alibaba.a.e) r0, (java.lang.String) r6, (int) r7)     // Catch:{ all -> 0x01b1 }
            android.content.Context r6 = com.alipay.mobile.nebula.util.H5Utils.getContext()     // Catch:{ all -> 0x01b1 }
            if (r6 == 0) goto L_0x0196
            int r6 = com.alipay.mobile.nebula.util.H5DimensionUtil.getScreenWidth(r6)     // Catch:{ all -> 0x01b1 }
            java.lang.String r7 = "H5HardwarePolicy"
            java.lang.String r8 = "disableHWACByHardwareInfo screenWidth "
            java.lang.String r9 = java.lang.String.valueOf(r6)     // Catch:{ all -> 0x01b1 }
            java.lang.String r8 = r8.concat(r9)     // Catch:{ all -> 0x01b1 }
            com.alipay.mobile.nebula.util.H5Log.d(r7, r8)     // Catch:{ all -> 0x01b1 }
            if (r6 < r0) goto L_0x0194
            if (r6 > r3) goto L_0x0194
            goto L_0x0196
        L_0x0194:
            r0 = 0
            goto L_0x0197
        L_0x0196:
            r0 = 1
        L_0x0197:
            if (r0 != 0) goto L_0x01a6
            java.lang.String r0 = "H5HardwarePolicy"
            java.lang.String r3 = "disableHWACByHardwareInfo screenWidth not match"
            com.alipay.mobile.nebula.util.H5Log.d(r0, r3)     // Catch:{ all -> 0x01b1 }
        L_0x01a0:
            int r5 = r5 + 1
            r0 = 1
            r3 = 0
            goto L_0x003f
        L_0x01a6:
            java.lang.String r0 = "H5HardwarePolicy"
            java.lang.String r2 = "disableHWACByHardwareInfo gocha!"
            com.alipay.mobile.nebula.util.H5Log.d(r0, r2)     // Catch:{ all -> 0x01b1 }
            r0 = 1
            disableHWACByHWInfo = r0     // Catch:{ all -> 0x01b1 }
            goto L_0x01b9
        L_0x01b1:
            r0 = move-exception
            java.lang.String r2 = "H5HardwarePolicy"
            java.lang.String r3 = "parseDisableHWACByHardwareInfo error"
            com.alipay.mobile.nebula.util.H5Log.e(r2, r3, r0)     // Catch:{ all -> 0x01bd }
        L_0x01b9:
            boolean r0 = disableHWACByHWInfo     // Catch:{ all -> 0x01bd }
            monitor-exit(r1)
            return r0
        L_0x01bd:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.nebulacore.web.H5HardwarePolicy.disableHWACByHardwareInfo():boolean");
    }

    public static boolean disableHardwareAccelerate(Bundle bundle, String str) {
        b parseArray;
        if (H5Utils.isUCM57() && disableHWACByHardwareInfo()) {
            return true;
        }
        if (H5AppHandler.CHECK_VALUE.equalsIgnoreCase(H5Utils.getString(bundle, "forceHardAccelerate"))) {
            return false;
        }
        H5ConfigProvider h5ConfigProvider = (H5ConfigProvider) Nebula.getProviderManager().getProvider(H5ConfigProvider.class.getName());
        if (h5ConfigProvider != null && (parseArray = H5Utils.parseArray(h5ConfigProvider.getConfig("h5_interceptCrashAnalyzerBizType"))) != null && !parseArray.isEmpty() && parseArray.contains(str)) {
            return false;
        }
        b parseArray2 = H5Utils.parseArray(H5Environment.getConfig("h5_interceptCrashAnalyzer"));
        if (parseArray2 != null && !parseArray2.isEmpty()) {
            for (int i2 = 0; i2 < parseArray2.size(); i2++) {
                e jSONObject = parseArray2.getJSONObject(i2);
                String string = jSONObject.getString("ma");
                String string2 = jSONObject.getString("mo");
                int intValue = jSONObject.getIntValue("sdk_int");
                if (TextUtils.equals(string, Build.MANUFACTURER) && TextUtils.equals(string2, Build.MODEL)) {
                    if (intValue != 0) {
                        if (intValue == Build.VERSION.SDK_INT) {
                            H5Log.d(TAG, "prevent CrashAnalyzer");
                        }
                    }
                    return false;
                }
            }
        }
        if (Nebula.getH5LogHandler() != null) {
            return Nebula.getH5LogHandler().disableHardwareAccelerate();
        }
        return false;
    }
}
