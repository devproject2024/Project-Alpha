package com.paytm.notification.data.c;

import android.content.SharedPreferences;
import com.paytm.notification.b.e;
import com.paytm.notification.data.b.b;
import com.paytm.notification.data.datasource.a;
import com.paytm.notification.models.NotificationProjectConfig;
import com.paytm.notification.models.NotificationUserConfig;
import com.paytm.notification.models.request.TokenRegisterRequest;
import com.paytm.pai.network.model.EventResponse;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.k;

public final class i implements h {

    /* renamed from: a  reason: collision with root package name */
    private NotificationProjectConfig f43077a;

    /* renamed from: b  reason: collision with root package name */
    private final b f43078b;

    public i(b bVar) {
        k.c(bVar, "eventRestApi");
        this.f43078b = bVar;
    }

    public final NotificationUserConfig a() {
        return a.f43088i.b();
    }

    public final String b() {
        return a.f43088i.a().getString(a.f43082c, (String) null);
    }

    public final long c() {
        return a.f43088i.a().getLong(a.f43083d, -1);
    }

    public final boolean d() {
        return a.f43088i.a().getBoolean(a.f43081b, false);
    }

    public final boolean e() {
        return a.f43088i.a().getBoolean(a.f43084e, false);
    }

    public final String f() {
        return a.f43088i.a().getString(a.f43085f, (String) null);
    }

    public final String j() {
        try {
            a aVar = a.f43088i;
            return a.c();
        } catch (Exception e2) {
            e.f43014a.b(e2, "Key secret not found", new Object[0]);
            return null;
        }
    }

    public final void c(String str) {
        a.f43088i.a(str);
    }

    public final NotificationProjectConfig g() {
        return this.f43077a;
    }

    public final NotificationProjectConfig a(NotificationProjectConfig notificationProjectConfig) throws Exception {
        if (this.f43077a == null) {
            if (notificationProjectConfig == null) {
                throw new Exception("Initialization fail: config is null");
            } else if (notificationProjectConfig.getAppId$paytmnotification_paytmRelease() == null) {
                throw new Exception("Initialization fail: FCM appId is null. Please initialize with NotificationProjectConfig.Builder().setAppId()");
            } else if (notificationProjectConfig.getAppKey$paytmnotification_paytmRelease() == null) {
                throw new Exception("Initialization fail: FCM appKey is null. Please initialize with NotificationProjectConfig.Builder().setAppKey()");
            } else if (notificationProjectConfig.getSenderId$paytmnotification_paytmRelease() == null) {
                throw new Exception("Initialization fail: FCM senderId is null. Please initialize with NotificationProjectConfig.Builder().setSenderId()");
            } else if (notificationProjectConfig.getApiKey$paytmnotification_paytmRelease() != null) {
                this.f43077a = notificationProjectConfig;
            } else {
                throw new Exception("Initialization fail: FCM apiKey is null. Please initialize with NotificationProjectConfig.Builder().setApiKey()");
            }
        }
        return this.f43077a;
    }

    public final void h() {
        SharedPreferences.Editor edit = a.f43088i.a().edit();
        edit.putString(a.f43080a, (String) null);
        edit.putBoolean(a.f43081b, false);
        edit.putBoolean(a.f43084e, false);
        edit.putString(a.f43080a, (String) null);
        edit.apply();
        a.f43087h = null;
    }

    public final EventResponse<?> a(TokenRegisterRequest tokenRegisterRequest, String str, String str2, String str3, String str4) throws com.paytm.notification.data.a.a, MalformedURLException {
        k.c(tokenRegisterRequest, "request");
        k.c(str, "endpoints");
        k.c(str2, "channelId");
        k.c(str3, "secret");
        k.c(str4, "clientId");
        return this.f43078b.a(tokenRegisterRequest, str, str2, str3, str4);
    }

    public final EventResponse<Map<String, String>> a(TokenRegisterRequest tokenRegisterRequest, String str, String str2, String str3) throws com.paytm.notification.data.a.a, MalformedURLException {
        k.c(tokenRegisterRequest, "request");
        k.c(str, "endpoints");
        k.c(str2, "secret");
        k.c(str3, "clientId");
        return this.f43078b.a(tokenRegisterRequest, str, str2, str3);
    }

    public final void a(boolean z) {
        SharedPreferences.Editor edit = a.f43088i.a().edit();
        edit.putBoolean(a.f43081b, true);
        edit.putBoolean(a.f43084e, z);
        edit.apply();
    }

    public final void i() {
        SharedPreferences.Editor edit = a.f43088i.a().edit();
        edit.putBoolean(a.f43084e, false);
        edit.apply();
    }

    public final void a(String str) {
        k.c(str, "channelId");
        a aVar = a.f43088i;
        k.c(str, "channeldId");
        aVar.a().edit().putString(a.f43085f, str).apply();
    }

    public final void b(String str) {
        SharedPreferences.Editor edit = a.f43088i.a().edit();
        edit.putString(a.f43082c, str);
        edit.putLong(a.f43083d, System.currentTimeMillis());
        edit.putBoolean(a.f43081b, false);
        edit.putBoolean(a.f43084e, false);
        edit.apply();
        e.f43014a.a("User saved to preferences", new Object[0]);
    }

    public final void a(NotificationUserConfig notificationUserConfig) {
        k.c(notificationUserConfig, "notificationUserConfig");
        a.f43088i.a(notificationUserConfig);
    }

    public final EventResponse<HashMap<String, String>> a(String str, String str2, String str3) {
        k.c(str, "endpoints");
        k.c(str2, "secret");
        k.c(str3, "clientId");
        return this.f43078b.a(str, str2, str3);
    }
}
