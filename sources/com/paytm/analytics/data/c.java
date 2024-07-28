package com.paytm.analytics.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import com.google.gson.f;
import com.paytm.analytics.models.Config;
import com.paytm.analytics.models.CustomDimension;
import com.sendbird.android.constant.StringSet;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.m.d;
import kotlin.x;

public final class c {

    /* renamed from: b  reason: collision with root package name */
    public static final a f40960b = new a((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    public final f f40961a = new f();

    /* renamed from: c  reason: collision with root package name */
    private SharedPreferences f40962c;

    /* renamed from: d  reason: collision with root package name */
    private final Context f40963d;

    public c(Context context) {
        k.c(context, "context");
        this.f40963d = context;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final SharedPreferences a() {
        if (this.f40962c == null) {
            synchronized (this) {
                if (this.f40962c == null) {
                    this.f40962c = this.f40963d.getSharedPreferences("com.paytm.android_analytics", 0);
                }
                x xVar = x.f47997a;
            }
        }
        SharedPreferences sharedPreferences = this.f40962c;
        if (sharedPreferences == null) {
            k.a();
        }
        return sharedPreferences;
    }

    public final Config b() {
        SharedPreferences a2 = a();
        String string = a2.getString("server_end_points", (String) null);
        String string2 = a2.getString("client_name", (String) null);
        String string3 = a2.getString("app_version", (String) null);
        String string4 = a2.getString("secret", (String) null);
        if (a2.getBoolean("secret_encoded", false) && !TextUtils.isEmpty(string4)) {
            byte[] decode = Base64.decode(string4, 0);
            k.a((Object) decode, "Base64.decode(secret, Base64.DEFAULT)");
            string4 = new String(decode, d.f47971a);
        }
        return new Config.Builder().serverEndPoints(string).clientName(string2).appVersion(string3).secret(string4).secretRequesterID(a2.getString("secret_requester_id", (String) null)).messageVersion(Integer.valueOf(a2.getInt("message_version", 0))).userId$paytmanalytics_release(a2.getString("user_id", (String) null)).deviceId(a2.getString("device_id", (String) null)).appLanguage(a2.getString("app_language", (String) null)).uploadFrequency(Integer.valueOf(a2.getInt("signal_batch_frequency", 0))).isLocationEnable(Boolean.valueOf(a2.getBoolean("location_enable", false))).locationNightModeStartHour(Integer.valueOf(a2.getInt(StringSet.start_hour, 0))).locationNightModeEndHour(Integer.valueOf(a2.getInt(StringSet.end_hour, 0))).locationSchedulingTime(Integer.valueOf(a2.getInt("location_scheduling", 0))).sameLocationThreshold(Integer.valueOf(a2.getInt("same_location", 0))).timeSyncFrequency(Integer.valueOf(a2.getInt("time_sync_frequency", 0))).customDimension(d()).isEnableLogs$paytmanalytics_release(Boolean.valueOf(a2.getBoolean("is_enable_log", false))).build();
    }

    private Map<String, String> d() {
        String string = a().getString("custom_dimension", (String) null);
        if (string != null) {
            return ((CustomDimension) this.f40961a.a(string, CustomDimension.class)).getCustomDimension$paytmanalytics_release();
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000b, code lost:
        r2 = r6.getLatitude();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.paytm.analytics.models.PaytmLocation r6) {
        /*
            r5 = this;
            android.content.SharedPreferences r0 = r5.a()
            android.content.SharedPreferences$Editor r0 = r0.edit()
            r1 = 0
            if (r6 == 0) goto L_0x0016
            java.lang.Float r2 = r6.getLatitude()
            if (r2 == 0) goto L_0x0016
            float r2 = r2.floatValue()
            goto L_0x0017
        L_0x0016:
            r2 = 0
        L_0x0017:
            java.lang.String r3 = "last_latitude"
            r0.putFloat(r3, r2)
            if (r6 == 0) goto L_0x0029
            java.lang.Float r2 = r6.getLongitude()
            if (r2 == 0) goto L_0x0029
            float r2 = r2.floatValue()
            goto L_0x002a
        L_0x0029:
            r2 = 0
        L_0x002a:
            java.lang.String r3 = "last_longitude"
            r0.putFloat(r3, r2)
            if (r6 == 0) goto L_0x003c
            java.lang.Long r2 = r6.getTime()
            if (r2 == 0) goto L_0x003c
            long r2 = r2.longValue()
            goto L_0x003e
        L_0x003c:
            r2 = 0
        L_0x003e:
            java.lang.String r4 = "location_time"
            r0.putLong(r4, r2)
            if (r6 == 0) goto L_0x004f
            java.lang.Float r2 = r6.getLastDistanceDelta()
            if (r2 == 0) goto L_0x004f
            float r1 = r2.floatValue()
        L_0x004f:
            java.lang.String r2 = "last_distance_delta"
            r0.putFloat(r2, r1)
            if (r6 == 0) goto L_0x0061
            java.lang.Boolean r6 = r6.getGpslastState()
            if (r6 == 0) goto L_0x0061
            boolean r6 = r6.booleanValue()
            goto L_0x0062
        L_0x0061:
            r6 = 0
        L_0x0062:
            java.lang.String r1 = "gps_last_state"
            r0.putBoolean(r1, r6)
            r0.apply()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.analytics.data.c.a(com.paytm.analytics.models.PaytmLocation):void");
    }

    public final long c() {
        return a().getLong("server_device_time_delta", 0);
    }
}
