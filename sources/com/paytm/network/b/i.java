package com.paytm.network.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.lifecycle.ab;
import androidx.localbroadcastmanager.a.a;
import com.paytm.network.j;
import com.paytm.network.listener.CJRLifecycleListener;
import com.paytm.network.model.NetworkResponse;
import com.paytm.utility.q;
import com.paytm.utility.x;

public final class i {

    /* renamed from: a  reason: collision with root package name */
    static String f42890a = null;

    /* renamed from: b  reason: collision with root package name */
    static String f42891b = null;

    /* renamed from: c  reason: collision with root package name */
    static String f42892c = null;

    /* renamed from: d  reason: collision with root package name */
    static j f42893d = null;

    /* renamed from: e  reason: collision with root package name */
    static boolean f42894e = true;

    /* renamed from: f  reason: collision with root package name */
    static double f42895f = 0.0d;

    /* renamed from: g  reason: collision with root package name */
    private static String f42896g = null;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public static a f42897h = null;

    /* renamed from: i  reason: collision with root package name */
    private static int f42898i = 8;
    private static boolean j = true;

    public static void a(Context context, String str, String str2, String str3, j jVar) {
        f42890a = str;
        f42891b = str2;
        f42892c = str3;
        f42893d = jVar;
        a a2 = a.a(context);
        f42897h = a2;
        a2.a(new BroadcastReceiver() {
            public final void onReceive(Context context, Intent intent) {
                d.a();
                i.f42897h.a((BroadcastReceiver) this);
            }
        }, new IntentFilter("ACTION_ON_APP_FOREGROUND"));
        x.j = false;
    }

    public static void a(String str, String str2, String str3) {
        f42890a = str;
        f42891b = str2;
        f42892c = str3;
        f42893d = null;
        ab.a().getLifecycle().a(new CJRLifecycleListener());
        x.j = false;
    }

    public static void a(String str) {
        f42896g = str;
    }

    public static String a() {
        return f42896g;
    }

    public static void b() {
        f42894e = true;
    }

    public static int c() {
        return f42898i;
    }

    public static void a(int i2) {
        f42898i = i2;
    }

    public static boolean d() {
        return j;
    }

    public static void a(boolean z) {
        j = z;
    }

    public static boolean e() {
        return f42894e;
    }

    public static NetworkResponse a(com.android.volley.NetworkResponse networkResponse) {
        return new NetworkResponse(networkResponse.statusCode, networkResponse.data, networkResponse.notModified, networkResponse.networkTimeMs, networkResponse.headers, c.a(networkResponse.allHeaders));
    }

    public static j f() {
        return f42893d;
    }

    public static double g() {
        return f42895f;
    }

    public static void a(double d2) {
        f42895f = d2;
        q.d("network speed : " + d2 + " (Kbps)");
    }
}
