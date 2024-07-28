package com.paytm.signal.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import com.google.gson.f;
import com.paytm.signal.models.Config;
import com.paytm.signal.models.CustomDimension;
import com.sendbird.android.constant.StringSet;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.m.d;
import kotlin.x;

public final class c {

    /* renamed from: b  reason: collision with root package name */
    public static final a f43643b = new a((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    public final f f43644a = new f();

    /* renamed from: c  reason: collision with root package name */
    private SharedPreferences f43645c;

    /* renamed from: d  reason: collision with root package name */
    private final Context f43646d;

    public c(Context context) {
        k.c(context, "context");
        this.f43646d = context;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final SharedPreferences a() {
        if (this.f43645c == null) {
            synchronized (this) {
                if (this.f43645c == null) {
                    this.f43645c = this.f43646d.getSharedPreferences("com.paytm.android_analytics", 0);
                }
                x xVar = x.f47997a;
            }
        }
        SharedPreferences sharedPreferences = this.f43645c;
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
        return new Config.Builder().serverEndPoints(string).clientName(string2).appVersion(string3).secret(string4).secretRequesterID(a2.getString("secret_requester_id", (String) null)).messageVersion(Integer.valueOf(a2.getInt("message_version", 0))).userId$paytmnotification_paytmRelease(a2.getString("user_id", (String) null)).deviceId(a2.getString("device_id", (String) null)).appLanguage(a2.getString("app_language", (String) null)).uploadFrequency(Integer.valueOf(a2.getInt("signal_batch_frequency", 0))).isLocationEnable(Boolean.valueOf(a2.getBoolean("location_enable", false))).locationNightModeStartHour(Integer.valueOf(a2.getInt(StringSet.start_hour, 0))).locationNightModeEndHour(Integer.valueOf(a2.getInt(StringSet.end_hour, 0))).locationSchedulingTime(Integer.valueOf(a2.getInt("location_scheduling", 0))).sameLocationThreshold(Integer.valueOf(a2.getInt("same_location", 0))).timeSyncFrequency(Integer.valueOf(a2.getInt("time_sync_frequency", 0))).customDimension(d()).isEnableLogs$paytmnotification_paytmRelease(Boolean.valueOf(a2.getBoolean("is_enable_log", false))).build();
    }

    private Map<String, String> d() {
        String string = a().getString("custom_dimension", (String) null);
        if (string != null) {
            return ((CustomDimension) this.f43644a.a(string, CustomDimension.class)).getCustomDimension$paytmnotification_paytmRelease();
        }
        return null;
    }

    public final long c() {
        return a().getLong("server_device_time_delta", 0);
    }
}
