package com.appsflyer.internal;

import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.ServerParameters;
import com.paytm.notification.data.datasource.a;
import com.paytmmall.clpartifact.utils.CLPConstants;
import com.sendbird.android.constant.StringSet;
import java.text.SimpleDateFormat;
import java.util.Locale;
import net.one97.paytm.upi.util.UpiContract;
import org.json.JSONArray;
import org.json.JSONObject;

public final class ai {

    /* renamed from: ɩ  reason: contains not printable characters */
    public static ai f183;

    /* renamed from: ı  reason: contains not printable characters */
    private JSONArray f184;

    /* renamed from: ǃ  reason: contains not printable characters */
    private JSONObject f185;

    /* renamed from: ɹ  reason: contains not printable characters */
    private int f186;

    /* renamed from: Ι  reason: contains not printable characters */
    private boolean f187;

    /* renamed from: ι  reason: contains not printable characters */
    public boolean f188;

    /* renamed from: І  reason: contains not printable characters */
    private boolean f189;

    /* renamed from: і  reason: contains not printable characters */
    private boolean f190;

    /* renamed from: Ӏ  reason: contains not printable characters */
    private String f191;

    public ai() {
        this.f187 = true;
        this.f186 = 0;
        this.f191 = H5BridgeContext.INVALID_ID;
        this.f189 = AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.DPM, false);
        this.f188 = true ^ this.f189;
        this.f184 = new JSONArray();
        this.f186 = 0;
        this.f190 = false;
    }

    /* renamed from: ɩ  reason: contains not printable characters */
    public final synchronized void m147(String str) {
        this.f191 = str;
    }

    /* renamed from: ǃ  reason: contains not printable characters */
    public final synchronized void m145() {
        this.f190 = true;
        m144("r_debugging_on", new SimpleDateFormat("yyyy-MM-dd HH:mm:ssZ", Locale.ENGLISH).format(Long.valueOf(System.currentTimeMillis())), new String[0]);
    }

    /* renamed from: ι  reason: contains not printable characters */
    public final synchronized void m150() {
        m144("r_debugging_off", new SimpleDateFormat("yyyy-MM-dd HH:mm:ssZ", Locale.ENGLISH).format(Long.valueOf(System.currentTimeMillis())), new String[0]);
        this.f190 = false;
        this.f187 = false;
    }

    /* renamed from: ɩ  reason: contains not printable characters */
    public final synchronized void m146() {
        this.f185 = null;
        this.f184 = null;
        f183 = null;
    }

    /* renamed from: ɹ  reason: contains not printable characters */
    private boolean m140() {
        if (this.f188) {
            return this.f187 || this.f190;
        }
        return false;
    }

    /* renamed from: ι  reason: contains not printable characters */
    private synchronized void m141(String str, String str2, String str3, String str4, String str5, String str6) {
        try {
            this.f185.put(CLPConstants.BRAND_PARAMS, str);
            this.f185.put("model", str2);
            this.f185.put("platform", StringSet.Android);
            this.f185.put("platform_version", str3);
            if (str4 != null && str4.length() > 0) {
                this.f185.put(ServerParameters.ADVERTISING_ID_PARAM, str4);
            }
            if (str5 != null && str5.length() > 0) {
                this.f185.put("imei", str5);
            }
            if (str6 != null && str6.length() > 0) {
                this.f185.put(UpiContract.DeviceInfoColumns.ANDROID_ID, str6);
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: ǃ  reason: contains not printable characters */
    private synchronized void m138(String str, String str2, String str3, String str4) {
        try {
            this.f185.put(a.f43086g, str);
            if (str2 != null && str2.length() > 0) {
                this.f185.put("devkey", str2);
            }
            if (str3 != null && str3.length() > 0) {
                this.f185.put("originalAppsFlyerId", str3);
            }
            if (str4 != null && str4.length() > 0) {
                this.f185.put("uid", str4);
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: ɩ  reason: contains not printable characters */
    private synchronized void m139(String str, String str2, String str3, String str4) {
        if (str != null) {
            try {
                if (str.length() > 0) {
                    this.f185.put("app_id", str);
                }
            } catch (Throwable unused) {
                return;
            }
        }
        if (str2 != null && str2.length() > 0) {
            this.f185.put("app_version", str2);
        }
        if (str3 != null && str3.length() > 0) {
            this.f185.put("channel", str3);
        }
        if (str4 != null && str4.length() > 0) {
            this.f185.put("preInstall", str4);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00a9, code lost:
        return;
     */
    /* renamed from: ı  reason: contains not printable characters */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void m144(java.lang.String r12, java.lang.String r13, java.lang.String... r14) {
        /*
            r11 = this;
            monitor-enter(r11)
            boolean r0 = r11.m140()     // Catch:{ all -> 0x00aa }
            if (r0 == 0) goto L_0x00a8
            int r0 = r11.f186     // Catch:{ all -> 0x00aa }
            r1 = 98304(0x18000, float:1.37753E-40)
            if (r0 < r1) goto L_0x0010
            goto L_0x00a8
        L_0x0010:
            long r0 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x00a6 }
            java.lang.String r2 = ""
            int r3 = r14.length     // Catch:{ all -> 0x00a6 }
            r4 = 0
            r5 = 1
            if (r3 <= 0) goto L_0x003a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a6 }
            r2.<init>()     // Catch:{ all -> 0x00a6 }
            int r3 = r14.length     // Catch:{ all -> 0x00a6 }
            int r3 = r3 - r5
        L_0x0022:
            if (r3 <= 0) goto L_0x0031
            r6 = r14[r3]     // Catch:{ all -> 0x00a6 }
            r2.append(r6)     // Catch:{ all -> 0x00a6 }
            java.lang.String r6 = ", "
            r2.append(r6)     // Catch:{ all -> 0x00a6 }
            int r3 = r3 + -1
            goto L_0x0022
        L_0x0031:
            r14 = r14[r4]     // Catch:{ all -> 0x00a6 }
            r2.append(r14)     // Catch:{ all -> 0x00a6 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x00a6 }
        L_0x003a:
            java.text.SimpleDateFormat r14 = new java.text.SimpleDateFormat     // Catch:{ all -> 0x00a6 }
            java.lang.String r3 = "MM-dd HH:mm:ss.SSS"
            java.util.Locale r6 = java.util.Locale.ENGLISH     // Catch:{ all -> 0x00a6 }
            r14.<init>(r3, r6)     // Catch:{ all -> 0x00a6 }
            java.lang.Long r0 = java.lang.Long.valueOf(r0)     // Catch:{ all -> 0x00a6 }
            java.lang.String r14 = r14.format(r0)     // Catch:{ all -> 0x00a6 }
            r0 = 4
            r1 = 3
            r3 = 2
            r6 = 5
            if (r12 == 0) goto L_0x0075
            java.lang.String r7 = "%18s %5s _/%s [%s] %s %s"
            r8 = 6
            java.lang.Object[] r8 = new java.lang.Object[r8]     // Catch:{ all -> 0x00a6 }
            r8[r4] = r14     // Catch:{ all -> 0x00a6 }
            java.lang.Thread r14 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x00a6 }
            long r9 = r14.getId()     // Catch:{ all -> 0x00a6 }
            java.lang.Long r14 = java.lang.Long.valueOf(r9)     // Catch:{ all -> 0x00a6 }
            r8[r5] = r14     // Catch:{ all -> 0x00a6 }
            java.lang.String r14 = "AppsFlyer_5.4.0"
            r8[r3] = r14     // Catch:{ all -> 0x00a6 }
            r8[r1] = r12     // Catch:{ all -> 0x00a6 }
            r8[r0] = r13     // Catch:{ all -> 0x00a6 }
            r8[r6] = r2     // Catch:{ all -> 0x00a6 }
            java.lang.String r12 = java.lang.String.format(r7, r8)     // Catch:{ all -> 0x00a6 }
            goto L_0x0095
        L_0x0075:
            java.lang.String r12 = "%18s %5s %s/%s %s"
            java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch:{ all -> 0x00a6 }
            r6[r4] = r14     // Catch:{ all -> 0x00a6 }
            java.lang.Thread r14 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x00a6 }
            long r7 = r14.getId()     // Catch:{ all -> 0x00a6 }
            java.lang.Long r14 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x00a6 }
            r6[r5] = r14     // Catch:{ all -> 0x00a6 }
            r6[r3] = r13     // Catch:{ all -> 0x00a6 }
            java.lang.String r13 = "AppsFlyer_5.4.0"
            r6[r1] = r13     // Catch:{ all -> 0x00a6 }
            r6[r0] = r2     // Catch:{ all -> 0x00a6 }
            java.lang.String r12 = java.lang.String.format(r12, r6)     // Catch:{ all -> 0x00a6 }
        L_0x0095:
            org.json.JSONArray r13 = r11.f184     // Catch:{ all -> 0x00a6 }
            r13.put(r12)     // Catch:{ all -> 0x00a6 }
            int r13 = r11.f186     // Catch:{ all -> 0x00a6 }
            byte[] r12 = r12.getBytes()     // Catch:{ all -> 0x00a6 }
            int r12 = r12.length     // Catch:{ all -> 0x00a6 }
            int r13 = r13 + r12
            r11.f186 = r13     // Catch:{ all -> 0x00a6 }
            monitor-exit(r11)
            return
        L_0x00a6:
            monitor-exit(r11)
            return
        L_0x00a8:
            monitor-exit(r11)
            return
        L_0x00aa:
            r12 = move-exception
            monitor-exit(r11)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.ai.m144(java.lang.String, java.lang.String, java.lang.String[]):void");
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* renamed from: Ι  reason: contains not printable characters */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized java.lang.String m148() {
        /*
            r4 = this;
            monitor-enter(r4)
            r0 = 0
            org.json.JSONObject r1 = r4.f185     // Catch:{ JSONException -> 0x0018, all -> 0x0015 }
            java.lang.String r2 = "data"
            org.json.JSONArray r3 = r4.f184     // Catch:{ JSONException -> 0x0018, all -> 0x0015 }
            r1.put(r2, r3)     // Catch:{ JSONException -> 0x0018, all -> 0x0015 }
            org.json.JSONObject r1 = r4.f185     // Catch:{ JSONException -> 0x0018, all -> 0x0015 }
            java.lang.String r0 = r1.toString()     // Catch:{ JSONException -> 0x0018, all -> 0x0015 }
            r4.m142()     // Catch:{ JSONException -> 0x0018, all -> 0x0015 }
            goto L_0x0018
        L_0x0015:
            r0 = move-exception
            monitor-exit(r4)
            throw r0
        L_0x0018:
            monitor-exit(r4)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.ai.m148():java.lang.String");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:1|2|(2:4|5)(8:6|7|8|9|10|11|13|14)|15|16|17) */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x008a, code lost:
        r11 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        r11.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x008f, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x007f */
    /* renamed from: Ι  reason: contains not printable characters */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void m149(java.lang.String r11, android.content.pm.PackageManager r12) {
        /*
            r10 = this;
            monitor-enter(r10)
            com.appsflyer.AppsFlyerProperties r0 = com.appsflyer.AppsFlyerProperties.getInstance()     // Catch:{ all -> 0x0090 }
            com.appsflyer.AppsFlyerLibCore r1 = com.appsflyer.AppsFlyerLibCore.getInstance()     // Catch:{ all -> 0x0090 }
            java.lang.String r2 = "remote_debug_static_data"
            java.lang.String r2 = r0.getString(r2)     // Catch:{ all -> 0x0090 }
            if (r2 == 0) goto L_0x0019
            org.json.JSONObject r11 = new org.json.JSONObject     // Catch:{ all -> 0x007f }
            r11.<init>(r2)     // Catch:{ all -> 0x007f }
            r10.f185 = r11     // Catch:{ all -> 0x007f }
            goto L_0x007f
        L_0x0019:
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ all -> 0x0090 }
            r2.<init>()     // Catch:{ all -> 0x0090 }
            r10.f185 = r2     // Catch:{ all -> 0x0090 }
            java.lang.String r4 = android.os.Build.BRAND     // Catch:{ all -> 0x0090 }
            java.lang.String r5 = android.os.Build.MODEL     // Catch:{ all -> 0x0090 }
            java.lang.String r6 = android.os.Build.VERSION.RELEASE     // Catch:{ all -> 0x0090 }
            java.lang.String r2 = "advertiserId"
            java.lang.String r7 = r0.getString(r2)     // Catch:{ all -> 0x0090 }
            java.lang.String r8 = r1.f85     // Catch:{ all -> 0x0090 }
            java.lang.String r9 = r1.f86     // Catch:{ all -> 0x0090 }
            r3 = r10
            r3.m141(r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x0090 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0090 }
            java.lang.String r2 = "5.4.0."
            r1.<init>(r2)     // Catch:{ all -> 0x0090 }
            java.lang.String r2 = com.appsflyer.AppsFlyerLibCore.f61     // Catch:{ all -> 0x0090 }
            r1.append(r2)     // Catch:{ all -> 0x0090 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0090 }
            java.lang.String r2 = "AppsFlyerKey"
            java.lang.String r2 = r0.getString(r2)     // Catch:{ all -> 0x0090 }
            java.lang.String r3 = "KSAppsFlyerId"
            java.lang.String r3 = r0.getString(r3)     // Catch:{ all -> 0x0090 }
            java.lang.String r4 = "uid"
            java.lang.String r4 = r0.getString(r4)     // Catch:{ all -> 0x0090 }
            r10.m138(r1, r2, r3, r4)     // Catch:{ all -> 0x0090 }
            r1 = 0
            android.content.pm.PackageInfo r12 = r12.getPackageInfo(r11, r1)     // Catch:{ all -> 0x0074 }
            int r12 = r12.versionCode     // Catch:{ all -> 0x0074 }
            java.lang.String r1 = "channel"
            java.lang.String r1 = r0.getString(r1)     // Catch:{ all -> 0x0074 }
            java.lang.String r2 = "preInstallName"
            java.lang.String r2 = r0.getString(r2)     // Catch:{ all -> 0x0074 }
            java.lang.String r12 = java.lang.String.valueOf(r12)     // Catch:{ all -> 0x0074 }
            r10.m139(r11, r12, r1, r2)     // Catch:{ all -> 0x0074 }
        L_0x0074:
            java.lang.String r11 = "remote_debug_static_data"
            org.json.JSONObject r12 = r10.f185     // Catch:{ all -> 0x0090 }
            java.lang.String r12 = r12.toString()     // Catch:{ all -> 0x0090 }
            r0.set((java.lang.String) r11, (java.lang.String) r12)     // Catch:{ all -> 0x0090 }
        L_0x007f:
            org.json.JSONObject r11 = r10.f185     // Catch:{ JSONException -> 0x008a }
            java.lang.String r12 = "launch_counter"
            java.lang.String r0 = r10.f191     // Catch:{ JSONException -> 0x008a }
            r11.put(r12, r0)     // Catch:{ JSONException -> 0x008a }
            monitor-exit(r10)
            return
        L_0x008a:
            r11 = move-exception
            r11.printStackTrace()     // Catch:{ all -> 0x0090 }
            monitor-exit(r10)
            return
        L_0x0090:
            r11 = move-exception
            monitor-exit(r10)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.ai.m149(java.lang.String, android.content.pm.PackageManager):void");
    }

    /* renamed from: і  reason: contains not printable characters */
    private synchronized void m142() {
        this.f184 = null;
        this.f184 = new JSONArray();
        this.f186 = 0;
    }

    /* renamed from: ı  reason: contains not printable characters */
    public final synchronized void m143() {
        this.f187 = false;
        m142();
    }

    /* renamed from: І  reason: contains not printable characters */
    public final boolean m151() {
        return this.f190;
    }
}
