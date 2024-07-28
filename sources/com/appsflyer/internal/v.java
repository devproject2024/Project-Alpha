package com.appsflyer.internal;

import android.content.ContentResolver;
import android.os.Build;
import android.provider.Settings;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.internal.w;

public final class v {
    v() {
    }

    /* renamed from: Ι  reason: contains not printable characters */
    public static w m203(ContentResolver contentResolver) {
        String str;
        if (contentResolver == null || AppsFlyerProperties.getInstance().getString("amazon_aid") != null || !"Amazon".equals(Build.MANUFACTURER)) {
            return null;
        }
        int i2 = Settings.Secure.getInt(contentResolver, "limit_ad_tracking", 2);
        if (i2 == 0) {
            String string = Settings.Secure.getString(contentResolver, "advertising_id");
            w.e eVar = w.e.AMAZON;
            return new w(string, false);
        } else if (i2 == 2) {
            return null;
        } else {
            try {
                str = Settings.Secure.getString(contentResolver, "advertising_id");
            } catch (Throwable th) {
                AFLogger.afErrorLog("Couldn't fetch Amazon Advertising ID (Ad-Tracking is limited!)", th);
                str = "";
            }
            w.e eVar2 = w.e.AMAZON;
            return new w(str, true);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0041, code lost:
        if (r8.length() == 0) goto L_0x0043;
     */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0088 A[SYNTHETIC, Splitter:B:34:0x0088] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00f3  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x010e  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0129 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:59:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* renamed from: ι  reason: contains not printable characters */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void m204(android.content.Context r12, java.util.Map<java.lang.String, java.lang.Object> r13) {
        /*
            java.lang.String r0 = "advertiserIdEnabled"
            java.lang.String r1 = "advertiserId"
            java.lang.String r2 = "Trying to fetch GAID.."
            com.appsflyer.AFLogger.afInfoLog(r2)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            com.google.android.gms.common.c r3 = com.google.android.gms.common.c.a()     // Catch:{ all -> 0x0017 }
            int r3 = r3.a((android.content.Context) r12)     // Catch:{ all -> 0x0017 }
            goto L_0x0020
        L_0x0017:
            r3 = move-exception
            java.lang.String r4 = r3.getMessage()
            com.appsflyer.AFLogger.afErrorLog(r4, r3)
            r3 = -1
        L_0x0020:
            r4 = 0
            r5 = 0
            r6 = 1
            java.lang.String r7 = "com.google.android.gms.ads.identifier.AdvertisingIdClient"
            java.lang.Class.forName(r7)     // Catch:{ all -> 0x005d }
            com.google.android.gms.ads.identifier.AdvertisingIdClient$a r7 = com.google.android.gms.ads.identifier.AdvertisingIdClient.a((android.content.Context) r12)     // Catch:{ all -> 0x005d }
            if (r7 == 0) goto L_0x0050
            java.lang.String r8 = r7.f8043a     // Catch:{ all -> 0x005d }
            boolean r7 = r7.f8044b     // Catch:{ all -> 0x004e }
            if (r7 != 0) goto L_0x0036
            r7 = 1
            goto L_0x0037
        L_0x0036:
            r7 = 0
        L_0x0037:
            java.lang.String r4 = java.lang.Boolean.toString(r7)     // Catch:{ all -> 0x004e }
            if (r8 == 0) goto L_0x0043
            int r7 = r8.length()     // Catch:{ all -> 0x004b }
            if (r7 != 0) goto L_0x0048
        L_0x0043:
            java.lang.String r7 = "emptyOrNull |"
            r2.append(r7)     // Catch:{ all -> 0x004b }
        L_0x0048:
            r9 = 1
            goto L_0x00e3
        L_0x004b:
            r7 = move-exception
            r9 = 1
            goto L_0x0060
        L_0x004e:
            r7 = move-exception
            goto L_0x005f
        L_0x0050:
            java.lang.String r7 = "gpsAdInfo-null |"
            r2.append(r7)     // Catch:{ all -> 0x005d }
            com.appsflyer.internal.v$a r7 = new com.appsflyer.internal.v$a     // Catch:{ all -> 0x005d }
            java.lang.String r8 = "GpsAdIndo is null"
            r7.<init>(r8)     // Catch:{ all -> 0x005d }
            throw r7     // Catch:{ all -> 0x005d }
        L_0x005d:
            r7 = move-exception
            r8 = r4
        L_0x005f:
            r9 = 0
        L_0x0060:
            java.lang.String r10 = r7.getMessage()
            com.appsflyer.AFLogger.afErrorLog(r10, r7)
            java.lang.Class r7 = r7.getClass()
            java.lang.String r7 = r7.getSimpleName()
            r2.append(r7)
            java.lang.String r7 = " |"
            r2.append(r7)
            java.lang.String r10 = "WARNING: Google Play Services is missing."
            com.appsflyer.AFLogger.afInfoLog(r10)
            com.appsflyer.AppsFlyerProperties r10 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r11 = "enableGpsFallback"
            boolean r10 = r10.getBoolean(r11, r6)
            if (r10 == 0) goto L_0x00e3
            com.appsflyer.internal.u$b r4 = com.appsflyer.internal.u.m199(r12)     // Catch:{ all -> 0x00a7 }
            java.lang.String r8 = r4.f298     // Catch:{ all -> 0x00a7 }
            boolean r4 = r4.m200()     // Catch:{ all -> 0x00a7 }
            if (r4 != 0) goto L_0x0095
            r5 = 1
        L_0x0095:
            java.lang.String r4 = java.lang.Boolean.toString(r5)     // Catch:{ all -> 0x00a7 }
            if (r8 == 0) goto L_0x00a1
            int r5 = r8.length()     // Catch:{ all -> 0x00a7 }
            if (r5 != 0) goto L_0x00e3
        L_0x00a1:
            java.lang.String r5 = "emptyOrNull (bypass) |"
            r2.append(r5)     // Catch:{ all -> 0x00a7 }
            goto L_0x00e3
        L_0x00a7:
            r4 = move-exception
            java.lang.String r5 = r4.getMessage()
            com.appsflyer.AFLogger.afErrorLog(r5, r4)
            java.lang.Class r5 = r4.getClass()
            java.lang.String r5 = r5.getSimpleName()
            r2.append(r5)
            r2.append(r7)
            com.appsflyer.AppsFlyerProperties r5 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r8 = r5.getString(r1)
            com.appsflyer.AppsFlyerProperties r5 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r5 = r5.getString(r0)
            java.lang.String r6 = r4.getLocalizedMessage()
            if (r6 == 0) goto L_0x00db
            java.lang.String r4 = r4.getLocalizedMessage()
            com.appsflyer.AFLogger.afInfoLog(r4)
            goto L_0x00e2
        L_0x00db:
            java.lang.String r4 = r4.toString()
            com.appsflyer.AFLogger.afInfoLog(r4)
        L_0x00e2:
            r4 = r5
        L_0x00e3:
            java.lang.Class r12 = r12.getClass()
            java.lang.String r12 = r12.getName()
            java.lang.String r5 = "android.app.ReceiverRestrictedContext"
            boolean r12 = r12.equals(r5)
            if (r12 == 0) goto L_0x0108
            com.appsflyer.AppsFlyerProperties r12 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r8 = r12.getString(r1)
            com.appsflyer.AppsFlyerProperties r12 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r4 = r12.getString(r0)
            java.lang.String r12 = "context = android.app.ReceiverRestrictedContext |"
            r2.append(r12)
        L_0x0108:
            int r12 = r2.length()
            if (r12 <= 0) goto L_0x0127
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            r12.append(r3)
            java.lang.String r3 = ": "
            r12.append(r3)
            r12.append(r2)
            java.lang.String r12 = r12.toString()
            java.lang.String r2 = "gaidError"
            r13.put(r2, r12)
        L_0x0127:
            if (r8 == 0) goto L_0x0148
            if (r4 == 0) goto L_0x0148
            r13.put(r1, r8)
            r13.put(r0, r4)
            com.appsflyer.AppsFlyerProperties r12 = com.appsflyer.AppsFlyerProperties.getInstance()
            r12.set((java.lang.String) r1, (java.lang.String) r8)
            com.appsflyer.AppsFlyerProperties r12 = com.appsflyer.AppsFlyerProperties.getInstance()
            r12.set((java.lang.String) r0, (java.lang.String) r4)
            java.lang.String r12 = java.lang.String.valueOf(r9)
            java.lang.String r0 = "isGaidWithGps"
            r13.put(r0, r12)
        L_0x0148:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.v.m204(android.content.Context, java.util.Map):void");
    }

    static class a extends IllegalStateException {
        a(String str) {
            super(str);
        }
    }
}
