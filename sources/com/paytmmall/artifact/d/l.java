package com.paytmmall.artifact.d;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public final class l {

    /* renamed from: a  reason: collision with root package name */
    public static int f15726a = 2;

    public static String a(Context context) {
        return u.a(context.getApplicationContext()).b("sso_token=", "", true);
    }

    public static Map<String, String> a() {
        Context applicationContext = t.e().getApplicationContext();
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", "application/json");
        hashMap.put("Accept", "application/json");
        hashMap.put("client_id", d.a());
        hashMap.put("client_secret", d.b());
        hashMap.put("session_token", a(applicationContext));
        hashMap.put("Authorization", d.c());
        if (b() != null) {
            hashMap.put("cart_id", b());
        }
        return hashMap;
    }

    public static String b() {
        return u.a(t.e().getApplicationContext()).b("cart_id", "", true);
    }

    public static int c() {
        return u.a(t.e().getApplicationContext()).b("cart_item_qty", 0, true);
    }

    public static void a(String str) {
        u.a(t.e().getApplicationContext()).a("cart_id", str, true);
    }

    public static void a(int i2) {
        u.a(t.e().getApplicationContext()).a("cart_item_qty", i2, true);
    }

    public static void b(String str) {
        u.a(t.e().getApplicationContext()).a("order_total", str, true);
    }

    public static void c(String str) {
        u.a(t.e().getApplicationContext()).a("cart_applied_promo", str, true);
    }

    public static boolean b(Context context) {
        return !TextUtils.isEmpty(a(context));
    }
}
