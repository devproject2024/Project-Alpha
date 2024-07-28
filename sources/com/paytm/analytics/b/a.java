package com.paytm.analytics.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import com.paytm.analytics.c.b;
import com.paytm.analytics.data.c;
import com.paytm.analytics.models.Config;
import com.paytm.analytics.models.CustomDimension;
import com.sendbird.android.constant.StringSet;
import easypay.manager.Constants;
import java.nio.charset.Charset;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.m.d;
import kotlin.u;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public Config f40920a;

    /* renamed from: b  reason: collision with root package name */
    private final c f40921b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f40922c;

    public a(c cVar, Context context) {
        k.c(cVar, "configPreferenceStore");
        k.c(context, "context");
        this.f40921b = cVar;
        this.f40922c = context;
        Config b2 = this.f40921b.b();
        this.f40920a = b2 == null ? new Config.Builder().build() : b2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x001c  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x002d  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00e5  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00f4  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0103  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0112  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0121  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0130  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x013f  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x014e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(com.paytm.analytics.models.Config r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            java.lang.String r0 = "newConfig"
            kotlin.g.b.k.c(r5, r0)     // Catch:{ all -> 0x0159 }
            java.lang.String r0 = r5.getServerEndPoints()     // Catch:{ all -> 0x0159 }
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch:{ all -> 0x0159 }
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x0019
            int r0 = r0.length()     // Catch:{ all -> 0x0159 }
            if (r0 != 0) goto L_0x0017
            goto L_0x0019
        L_0x0017:
            r0 = 0
            goto L_0x001a
        L_0x0019:
            r0 = 1
        L_0x001a:
            if (r0 != 0) goto L_0x0025
            com.paytm.analytics.models.Config r0 = r4.f40920a     // Catch:{ all -> 0x0159 }
            java.lang.String r3 = r5.getServerEndPoints()     // Catch:{ all -> 0x0159 }
            r0.setServerEndPoints(r3)     // Catch:{ all -> 0x0159 }
        L_0x0025:
            java.lang.String r0 = r5.getClientName()     // Catch:{ all -> 0x0159 }
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch:{ all -> 0x0159 }
            if (r0 == 0) goto L_0x0036
            int r0 = r0.length()     // Catch:{ all -> 0x0159 }
            if (r0 != 0) goto L_0x0034
            goto L_0x0036
        L_0x0034:
            r0 = 0
            goto L_0x0037
        L_0x0036:
            r0 = 1
        L_0x0037:
            if (r0 != 0) goto L_0x0042
            com.paytm.analytics.models.Config r0 = r4.f40920a     // Catch:{ all -> 0x0159 }
            java.lang.String r3 = r5.getClientName()     // Catch:{ all -> 0x0159 }
            r0.setClientName(r3)     // Catch:{ all -> 0x0159 }
        L_0x0042:
            java.lang.String r0 = r5.getAppVersion()     // Catch:{ all -> 0x0159 }
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch:{ all -> 0x0159 }
            if (r0 == 0) goto L_0x0053
            int r0 = r0.length()     // Catch:{ all -> 0x0159 }
            if (r0 != 0) goto L_0x0051
            goto L_0x0053
        L_0x0051:
            r0 = 0
            goto L_0x0054
        L_0x0053:
            r0 = 1
        L_0x0054:
            if (r0 != 0) goto L_0x005f
            com.paytm.analytics.models.Config r0 = r4.f40920a     // Catch:{ all -> 0x0159 }
            java.lang.String r3 = r5.getAppVersion()     // Catch:{ all -> 0x0159 }
            r0.setAppVersion(r3)     // Catch:{ all -> 0x0159 }
        L_0x005f:
            java.lang.String r0 = r5.getSecret()     // Catch:{ all -> 0x0159 }
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch:{ all -> 0x0159 }
            if (r0 == 0) goto L_0x0070
            int r0 = r0.length()     // Catch:{ all -> 0x0159 }
            if (r0 != 0) goto L_0x006e
            goto L_0x0070
        L_0x006e:
            r0 = 0
            goto L_0x0071
        L_0x0070:
            r0 = 1
        L_0x0071:
            if (r0 != 0) goto L_0x007c
            com.paytm.analytics.models.Config r0 = r4.f40920a     // Catch:{ all -> 0x0159 }
            java.lang.String r3 = r5.getSecret()     // Catch:{ all -> 0x0159 }
            r0.setSecret(r3)     // Catch:{ all -> 0x0159 }
        L_0x007c:
            java.lang.String r0 = r5.getSecretRequesterID()     // Catch:{ all -> 0x0159 }
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch:{ all -> 0x0159 }
            if (r0 == 0) goto L_0x008a
            int r0 = r0.length()     // Catch:{ all -> 0x0159 }
            if (r0 != 0) goto L_0x008b
        L_0x008a:
            r1 = 1
        L_0x008b:
            if (r1 != 0) goto L_0x0096
            com.paytm.analytics.models.Config r0 = r4.f40920a     // Catch:{ all -> 0x0159 }
            java.lang.String r1 = r5.getSecretRequesterID()     // Catch:{ all -> 0x0159 }
            r0.setSecretRequesterID(r1)     // Catch:{ all -> 0x0159 }
        L_0x0096:
            java.lang.Integer r0 = r5.getMessageVersion()     // Catch:{ all -> 0x0159 }
            if (r0 == 0) goto L_0x00a5
            com.paytm.analytics.models.Config r0 = r4.f40920a     // Catch:{ all -> 0x0159 }
            java.lang.Integer r1 = r5.getMessageVersion()     // Catch:{ all -> 0x0159 }
            r0.setMessageVersion(r1)     // Catch:{ all -> 0x0159 }
        L_0x00a5:
            java.lang.String r0 = r5.getDeviceId()     // Catch:{ all -> 0x0159 }
            if (r0 == 0) goto L_0x00b5
            com.paytm.analytics.models.Config r0 = r4.f40920a     // Catch:{ all -> 0x0159 }
            java.lang.String r1 = r5.getDeviceId()     // Catch:{ all -> 0x0159 }
            r0.setDeviceId(r1)     // Catch:{ all -> 0x0159 }
            goto L_0x00d0
        L_0x00b5:
            java.lang.String r0 = r5.getDeviceId()     // Catch:{ all -> 0x0159 }
            if (r0 != 0) goto L_0x00d0
            com.paytm.analytics.models.Config r0 = r4.f40920a     // Catch:{ all -> 0x0159 }
            java.lang.String r0 = r0.getDeviceId()     // Catch:{ all -> 0x0159 }
            if (r0 != 0) goto L_0x00d0
            com.paytm.analytics.models.Config r0 = r4.f40920a     // Catch:{ all -> 0x0159 }
            com.paytm.analytics.c.c r1 = com.paytm.analytics.c.c.f40947a     // Catch:{ all -> 0x0159 }
            android.content.Context r1 = r4.f40922c     // Catch:{ all -> 0x0159 }
            java.lang.String r1 = com.paytm.analytics.c.c.b(r1)     // Catch:{ all -> 0x0159 }
            r0.setDeviceId(r1)     // Catch:{ all -> 0x0159 }
        L_0x00d0:
            java.lang.String r0 = r5.getAppLanguage()     // Catch:{ all -> 0x0159 }
            if (r0 == 0) goto L_0x00df
            com.paytm.analytics.models.Config r0 = r4.f40920a     // Catch:{ all -> 0x0159 }
            java.lang.String r1 = r5.getAppLanguage()     // Catch:{ all -> 0x0159 }
            r0.setAppLanguage(r1)     // Catch:{ all -> 0x0159 }
        L_0x00df:
            java.lang.Integer r0 = r5.getUploadFrequency()     // Catch:{ all -> 0x0159 }
            if (r0 == 0) goto L_0x00ee
            com.paytm.analytics.models.Config r0 = r4.f40920a     // Catch:{ all -> 0x0159 }
            java.lang.Integer r1 = r5.getUploadFrequency()     // Catch:{ all -> 0x0159 }
            r0.setUploadFrequency(r1)     // Catch:{ all -> 0x0159 }
        L_0x00ee:
            java.lang.Boolean r0 = r5.isLocationEnable()     // Catch:{ all -> 0x0159 }
            if (r0 == 0) goto L_0x00fd
            com.paytm.analytics.models.Config r0 = r4.f40920a     // Catch:{ all -> 0x0159 }
            java.lang.Boolean r1 = r5.isLocationEnable()     // Catch:{ all -> 0x0159 }
            r0.setLocationEnable(r1)     // Catch:{ all -> 0x0159 }
        L_0x00fd:
            java.lang.Integer r0 = r5.getLocationNightModeStartHour()     // Catch:{ all -> 0x0159 }
            if (r0 == 0) goto L_0x010c
            com.paytm.analytics.models.Config r0 = r4.f40920a     // Catch:{ all -> 0x0159 }
            java.lang.Integer r1 = r5.getLocationNightModeStartHour()     // Catch:{ all -> 0x0159 }
            r0.setLocationNightModeStartHour(r1)     // Catch:{ all -> 0x0159 }
        L_0x010c:
            java.lang.Integer r0 = r5.getLocationNightModeEndHour()     // Catch:{ all -> 0x0159 }
            if (r0 == 0) goto L_0x011b
            com.paytm.analytics.models.Config r0 = r4.f40920a     // Catch:{ all -> 0x0159 }
            java.lang.Integer r1 = r5.getLocationNightModeEndHour()     // Catch:{ all -> 0x0159 }
            r0.setLocationNightModeEndHour(r1)     // Catch:{ all -> 0x0159 }
        L_0x011b:
            java.lang.Integer r0 = r5.getSameLocationThreshold()     // Catch:{ all -> 0x0159 }
            if (r0 == 0) goto L_0x012a
            com.paytm.analytics.models.Config r0 = r4.f40920a     // Catch:{ all -> 0x0159 }
            java.lang.Integer r1 = r5.getSameLocationThreshold()     // Catch:{ all -> 0x0159 }
            r0.setSameLocationThreshold(r1)     // Catch:{ all -> 0x0159 }
        L_0x012a:
            java.lang.Integer r0 = r5.getLocationSchedulingTime()     // Catch:{ all -> 0x0159 }
            if (r0 == 0) goto L_0x0139
            com.paytm.analytics.models.Config r0 = r4.f40920a     // Catch:{ all -> 0x0159 }
            java.lang.Integer r1 = r5.getLocationSchedulingTime()     // Catch:{ all -> 0x0159 }
            r0.setLocationSchedulingTime(r1)     // Catch:{ all -> 0x0159 }
        L_0x0139:
            java.lang.Integer r0 = r5.getTimeSyncFrequency()     // Catch:{ all -> 0x0159 }
            if (r0 == 0) goto L_0x0148
            com.paytm.analytics.models.Config r0 = r4.f40920a     // Catch:{ all -> 0x0159 }
            java.lang.Integer r1 = r5.getTimeSyncFrequency()     // Catch:{ all -> 0x0159 }
            r0.setTimeSyncFrequency(r1)     // Catch:{ all -> 0x0159 }
        L_0x0148:
            java.util.Map r0 = r5.getCustomDimension()     // Catch:{ all -> 0x0159 }
            if (r0 == 0) goto L_0x0157
            com.paytm.analytics.models.Config r0 = r4.f40920a     // Catch:{ all -> 0x0159 }
            java.util.Map r5 = r5.getCustomDimension()     // Catch:{ all -> 0x0159 }
            r0.setCustomDimension(r5)     // Catch:{ all -> 0x0159 }
        L_0x0157:
            monitor-exit(r4)
            return
        L_0x0159:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.analytics.b.a.a(com.paytm.analytics.models.Config):void");
    }

    private synchronized void b(Context context) {
        k.c(context, "context");
        Config config = this.f40920a;
        com.paytm.analytics.c.c cVar = com.paytm.analytics.c.c.f40947a;
        config.setIp$paytmanalytics_release(com.paytm.analytics.c.c.a());
        Config config2 = this.f40920a;
        com.paytm.analytics.c.c cVar2 = com.paytm.analytics.c.c.f40947a;
        config2.setCarrier$paytmanalytics_release(com.paytm.analytics.c.c.a(context));
        Config config3 = this.f40920a;
        b bVar = b.f40946a;
        config3.setConnectionType$paytmanalytics_release(b.a(context));
    }

    public final synchronized void a() {
        boolean z;
        String str;
        c cVar = this.f40921b;
        Config config = this.f40920a;
        k.c(config, Constants.EASY_PAY_CONFIG_PREF_KEY);
        SharedPreferences.Editor edit = cVar.a().edit();
        edit.putString("server_end_points", config.getServerEndPoints());
        edit.putString("client_name", config.getClientName());
        edit.putString("app_version", config.getAppVersion());
        String secret = config.getSecret();
        if (!TextUtils.isEmpty(secret)) {
            if (secret == null) {
                k.a();
            }
            Charset charset = d.f47971a;
            if (secret != null) {
                byte[] bytes = secret.getBytes(charset);
                k.a((Object) bytes, "(this as java.lang.String).getBytes(charset)");
                byte[] encode = Base64.encode(bytes, 0);
                k.a((Object) encode, "Base64.encode(secret!!.t…eArray(), Base64.DEFAULT)");
                secret = new String(encode, d.f47971a);
                z = true;
            } else {
                throw new u("null cannot be cast to non-null type java.lang.String");
            }
        } else {
            z = false;
        }
        edit.putString("secret", secret);
        edit.putString("secret_requester_id", config.getSecretRequesterID());
        edit.putBoolean("secret_encoded", z);
        Integer messageVersion = config.getMessageVersion();
        if ((messageVersion != null ? messageVersion.intValue() : 0) > 0) {
            Integer messageVersion2 = config.getMessageVersion();
            edit.putInt("message_version", messageVersion2 != null ? messageVersion2.intValue() : 0);
        }
        edit.putString("device_id", config.getDeviceId());
        if (config.getAppLanguage() != null) {
            edit.putString("app_language", config.getAppLanguage());
        }
        Integer uploadFrequency = config.getUploadFrequency();
        if ((uploadFrequency != null ? uploadFrequency.intValue() : 0) > 0) {
            Integer uploadFrequency2 = config.getUploadFrequency();
            edit.putInt("signal_batch_frequency", uploadFrequency2 != null ? uploadFrequency2.intValue() : 0);
        }
        Boolean isLocationEnable = config.isLocationEnable();
        edit.putBoolean("location_enable", isLocationEnable != null ? isLocationEnable.booleanValue() : false);
        Integer locationNightModeStartHour = config.getLocationNightModeStartHour();
        if ((locationNightModeStartHour != null ? locationNightModeStartHour.intValue() : 0) > 0) {
            Integer locationNightModeStartHour2 = config.getLocationNightModeStartHour();
            edit.putInt(StringSet.start_hour, locationNightModeStartHour2 != null ? locationNightModeStartHour2.intValue() : 0);
        }
        Integer locationNightModeEndHour = config.getLocationNightModeEndHour();
        if ((locationNightModeEndHour != null ? locationNightModeEndHour.intValue() : 0) > 0) {
            Integer locationNightModeEndHour2 = config.getLocationNightModeEndHour();
            edit.putInt(StringSet.end_hour, locationNightModeEndHour2 != null ? locationNightModeEndHour2.intValue() : 0);
        }
        Integer sameLocationThreshold = config.getSameLocationThreshold();
        if ((sameLocationThreshold != null ? sameLocationThreshold.intValue() : 0) > 0) {
            Integer sameLocationThreshold2 = config.getSameLocationThreshold();
            edit.putInt("same_location", sameLocationThreshold2 != null ? sameLocationThreshold2.intValue() : 0);
        }
        Integer locationSchedulingTime = config.getLocationSchedulingTime();
        if ((locationSchedulingTime != null ? locationSchedulingTime.intValue() : 0) > 0) {
            Integer locationSchedulingTime2 = config.getLocationSchedulingTime();
            edit.putInt("location_scheduling", locationSchedulingTime2 != null ? locationSchedulingTime2.intValue() : 0);
        }
        Integer timeSyncFrequency = config.getTimeSyncFrequency();
        if ((timeSyncFrequency != null ? timeSyncFrequency.intValue() : 0) > 0) {
            Integer timeSyncFrequency2 = config.getTimeSyncFrequency();
            edit.putInt("time_sync_frequency", timeSyncFrequency2 != null ? timeSyncFrequency2.intValue() : 0);
        }
        Map<String, String> customDimension = config.getCustomDimension();
        if (customDimension == null) {
            str = null;
        } else {
            str = cVar.f40961a.b(new CustomDimension(customDimension));
        }
        edit.putString("custom_dimension", str);
        Boolean showDebugLogs$paytmanalytics_release = config.getShowDebugLogs$paytmanalytics_release();
        edit.putBoolean("is_enable_log", showDebugLogs$paytmanalytics_release != null ? showDebugLogs$paytmanalytics_release.booleanValue() : false);
        edit.apply();
        com.paytm.a.a.b.f40832a.a("User saved to prefernces", new Object[0]);
    }

    public final synchronized void a(String str) {
        this.f40920a.setUserId$paytmanalytics_release(str);
        SharedPreferences.Editor edit = this.f40921b.a().edit();
        edit.putString("user_id", str);
        edit.apply();
    }

    public final synchronized void b() {
        this.f40920a.setUserId$paytmanalytics_release((String) null);
        SharedPreferences.Editor edit = this.f40921b.a().edit();
        edit.putString("user_id", (String) null);
        edit.apply();
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x003e A[Catch:{ e -> 0x00d5, f -> 0x00ba, Exception -> 0x009f }] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x004d A[Catch:{ e -> 0x00d5, f -> 0x00ba, Exception -> 0x009f }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x005c A[Catch:{ e -> 0x00d5, f -> 0x00ba, Exception -> 0x009f }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x006e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(android.content.Context r7) {
        /*
            r6 = this;
            monitor-enter(r6)
            java.lang.String r0 = "context"
            kotlin.g.b.k.c(r7, r0)     // Catch:{ all -> 0x010a }
            com.paytm.analytics.models.Config r0 = r6.f40920a     // Catch:{ all -> 0x010a }
            com.paytm.analytics.models.Config r1 = r6.f40920a     // Catch:{ all -> 0x010a }
            java.lang.Long r1 = r1.getLastAppOpenDate$paytmanalytics_release()     // Catch:{ all -> 0x010a }
            if (r1 == 0) goto L_0x002b
            com.paytm.analytics.models.Config r1 = r6.f40920a     // Catch:{ all -> 0x010a }
            java.lang.Long r1 = r1.getLastAppOpenDate$paytmanalytics_release()     // Catch:{ all -> 0x010a }
            if (r1 != 0) goto L_0x0019
            goto L_0x0024
        L_0x0019:
            long r1 = r1.longValue()     // Catch:{ all -> 0x010a }
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 != 0) goto L_0x0024
            goto L_0x002b
        L_0x0024:
            com.paytm.analytics.models.Config r1 = r6.f40920a     // Catch:{ all -> 0x010a }
            java.lang.Long r1 = r1.getLastAppOpenDate$paytmanalytics_release()     // Catch:{ all -> 0x010a }
            goto L_0x0033
        L_0x002b:
            long r1 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x010a }
            java.lang.Long r1 = java.lang.Long.valueOf(r1)     // Catch:{ all -> 0x010a }
        L_0x0033:
            r0.setLastAppOpenDate$paytmanalytics_release(r1)     // Catch:{ all -> 0x010a }
            com.paytm.analytics.models.Config r0 = r6.f40920a     // Catch:{ all -> 0x010a }
            java.lang.String r0 = r0.getOsVersion$paytmanalytics_release()     // Catch:{ all -> 0x010a }
            if (r0 != 0) goto L_0x0045
            com.paytm.analytics.models.Config r0 = r6.f40920a     // Catch:{ all -> 0x010a }
            java.lang.String r1 = android.os.Build.VERSION.RELEASE     // Catch:{ all -> 0x010a }
            r0.setOsVersion$paytmanalytics_release(r1)     // Catch:{ all -> 0x010a }
        L_0x0045:
            com.paytm.analytics.models.Config r0 = r6.f40920a     // Catch:{ all -> 0x010a }
            java.lang.String r0 = r0.getModel$paytmanalytics_release()     // Catch:{ all -> 0x010a }
            if (r0 != 0) goto L_0x0054
            com.paytm.analytics.models.Config r0 = r6.f40920a     // Catch:{ all -> 0x010a }
            java.lang.String r1 = android.os.Build.MODEL     // Catch:{ all -> 0x010a }
            r0.setModel$paytmanalytics_release(r1)     // Catch:{ all -> 0x010a }
        L_0x0054:
            com.paytm.analytics.models.Config r0 = r6.f40920a     // Catch:{ all -> 0x010a }
            java.lang.String r0 = r0.getBrand$paytmanalytics_release()     // Catch:{ all -> 0x010a }
            if (r0 != 0) goto L_0x0063
            com.paytm.analytics.models.Config r0 = r6.f40920a     // Catch:{ all -> 0x010a }
            java.lang.String r1 = android.os.Build.MANUFACTURER     // Catch:{ all -> 0x010a }
            r0.setBrand$paytmanalytics_release(r1)     // Catch:{ all -> 0x010a }
        L_0x0063:
            r6.b(r7)     // Catch:{ all -> 0x010a }
            com.paytm.analytics.models.Config r0 = r6.f40920a     // Catch:{ all -> 0x010a }
            java.lang.String r0 = r0.getAdvertisementId$paytmanalytics_release()     // Catch:{ all -> 0x010a }
            if (r0 != 0) goto L_0x0108
            r0 = 0
            r1 = 0
            com.google.android.gms.ads.identifier.AdvertisingIdClient$a r7 = com.google.android.gms.ads.identifier.AdvertisingIdClient.a((android.content.Context) r7)     // Catch:{ e -> 0x00d5, f -> 0x00ba, Exception -> 0x009f }
            if (r7 == 0) goto L_0x007b
            java.lang.String r2 = r7.a()     // Catch:{ e -> 0x00d5, f -> 0x00ba, Exception -> 0x009f }
            goto L_0x007c
        L_0x007b:
            r2 = r0
        L_0x007c:
            if (r2 == 0) goto L_0x00ef
            com.paytm.analytics.models.Config r2 = r6.f40920a     // Catch:{ e -> 0x00d5, f -> 0x00ba, Exception -> 0x009f }
            java.lang.String r3 = r7.a()     // Catch:{ e -> 0x00d5, f -> 0x00ba, Exception -> 0x009f }
            r2.setAdvertisementId$paytmanalytics_release(r3)     // Catch:{ e -> 0x00d5, f -> 0x00ba, Exception -> 0x009f }
            com.paytm.analytics.data.c r2 = r6.f40921b     // Catch:{ e -> 0x00d5, f -> 0x00ba, Exception -> 0x009f }
            java.lang.String r7 = r7.a()     // Catch:{ e -> 0x00d5, f -> 0x00ba, Exception -> 0x009f }
            android.content.SharedPreferences r2 = r2.a()     // Catch:{ e -> 0x00d5, f -> 0x00ba, Exception -> 0x009f }
            android.content.SharedPreferences$Editor r2 = r2.edit()     // Catch:{ e -> 0x00d5, f -> 0x00ba, Exception -> 0x009f }
            java.lang.String r3 = "ad_id"
            android.content.SharedPreferences$Editor r7 = r2.putString(r3, r7)     // Catch:{ e -> 0x00d5, f -> 0x00ba, Exception -> 0x009f }
            r7.apply()     // Catch:{ e -> 0x00d5, f -> 0x00ba, Exception -> 0x009f }
            goto L_0x00ef
        L_0x009f:
            r7 = move-exception
            com.paytm.a.a.b$b r2 = com.paytm.a.a.b.f40832a     // Catch:{ all -> 0x010a }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x010a }
            java.lang.String r4 = "getAdvertisementId(): "
            r3.<init>(r4)     // Catch:{ all -> 0x010a }
            java.lang.String r7 = r7.getLocalizedMessage()     // Catch:{ all -> 0x010a }
            r3.append(r7)     // Catch:{ all -> 0x010a }
            java.lang.String r7 = r3.toString()     // Catch:{ all -> 0x010a }
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ all -> 0x010a }
            r2.d(r7, r1)     // Catch:{ all -> 0x010a }
            goto L_0x00ef
        L_0x00ba:
            r7 = move-exception
            com.paytm.a.a.b$b r2 = com.paytm.a.a.b.f40832a     // Catch:{ all -> 0x010a }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x010a }
            java.lang.String r4 = "GooglePlayServicesRepairableException "
            r3.<init>(r4)     // Catch:{ all -> 0x010a }
            java.lang.String r7 = r7.getLocalizedMessage()     // Catch:{ all -> 0x010a }
            r3.append(r7)     // Catch:{ all -> 0x010a }
            java.lang.String r7 = r3.toString()     // Catch:{ all -> 0x010a }
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ all -> 0x010a }
            r2.c(r7, r1)     // Catch:{ all -> 0x010a }
            goto L_0x00ef
        L_0x00d5:
            r7 = move-exception
            com.paytm.a.a.b$b r2 = com.paytm.a.a.b.f40832a     // Catch:{ all -> 0x010a }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x010a }
            java.lang.String r4 = "GooglePlayServicesNotAvailableException "
            r3.<init>(r4)     // Catch:{ all -> 0x010a }
            java.lang.String r7 = r7.getLocalizedMessage()     // Catch:{ all -> 0x010a }
            r3.append(r7)     // Catch:{ all -> 0x010a }
            java.lang.String r7 = r3.toString()     // Catch:{ all -> 0x010a }
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ all -> 0x010a }
            r2.c(r7, r1)     // Catch:{ all -> 0x010a }
        L_0x00ef:
            com.paytm.analytics.models.Config r7 = r6.f40920a     // Catch:{ all -> 0x010a }
            java.lang.String r7 = r7.getAdvertisementId$paytmanalytics_release()     // Catch:{ all -> 0x010a }
            if (r7 != 0) goto L_0x0108
            com.paytm.analytics.models.Config r7 = r6.f40920a     // Catch:{ all -> 0x010a }
            com.paytm.analytics.data.c r1 = r6.f40921b     // Catch:{ all -> 0x010a }
            android.content.SharedPreferences r1 = r1.a()     // Catch:{ all -> 0x010a }
            java.lang.String r2 = "ad_id"
            java.lang.String r0 = r1.getString(r2, r0)     // Catch:{ all -> 0x010a }
            r7.setAdvertisementId$paytmanalytics_release(r0)     // Catch:{ all -> 0x010a }
        L_0x0108:
            monitor-exit(r6)
            return
        L_0x010a:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.analytics.b.a.a(android.content.Context):void");
    }
}
