package com.travel.utils;

import android.content.Context;

public final class b {
    public static String a(Context context) {
        return r.a(context.getApplicationContext()).b("sso_token=", "", true);
    }

    public static void a(Context context, int i2) {
        r.a(context.getApplicationContext()).a("cart_item_qty", i2, true);
    }

    public static void a(Context context, String str) {
        r.a(context.getApplicationContext()).a("order_total", str, true);
    }
}
