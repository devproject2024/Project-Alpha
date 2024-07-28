package com.alipay.mobile.b.a;

import android.content.Context;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f14947a;

    public static boolean a(Context context) {
        try {
            if ((context.getApplicationInfo().flags & 2) != 0) {
                return true;
            }
            return false;
        } catch (Exception unused) {
        }
    }
}
