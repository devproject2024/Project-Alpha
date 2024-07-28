package com.paytm.notification.data.datasource;

import android.content.Context;
import android.content.SharedPreferences;
import com.paytm.notification.b.e;
import com.paytm.notification.g;
import kotlin.g.b.k;
import kotlin.x;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f43089a = new b();

    /* renamed from: b  reason: collision with root package name */
    private static final String f43090b = f43090b;

    /* renamed from: c  reason: collision with root package name */
    private static final String f43091c = "notification_id";

    /* renamed from: d  reason: collision with root package name */
    private static SharedPreferences f43092d;

    private b() {
    }

    private final SharedPreferences b() {
        if (f43092d == null) {
            synchronized (this) {
                if (f43092d == null) {
                    g.c cVar = g.f43191a;
                    if (g.f43192h == null) {
                        e.f43014a.d("PaytmNotifications.appContext == null", new Object[0]);
                    }
                    g.c cVar2 = g.f43191a;
                    Context d2 = g.f43192h;
                    f43092d = d2 != null ? d2.getSharedPreferences(f43090b, 0) : null;
                }
                x xVar = x.f47997a;
            }
        }
        SharedPreferences sharedPreferences = f43092d;
        if (sharedPreferences == null) {
            k.a();
        }
        return sharedPreferences;
    }

    public final synchronized int a() {
        int i2;
        SharedPreferences b2 = b();
        i2 = b2.getInt(f43091c, 0) + 1;
        b2.edit().putInt(f43091c, i2).apply();
        return i2 + 5000;
    }
}
