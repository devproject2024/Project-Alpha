package com.google.android.gms.common.util;

import android.content.Context;
import android.content.pm.PackageManager;

public final class i {

    /* renamed from: a  reason: collision with root package name */
    public static Boolean f8977a;

    /* renamed from: b  reason: collision with root package name */
    private static Boolean f8978b;

    /* renamed from: c  reason: collision with root package name */
    private static Boolean f8979c;

    public static boolean a(PackageManager packageManager) {
        if (f8978b == null) {
            f8978b = Boolean.valueOf(n.c() && packageManager.hasSystemFeature("android.hardware.type.watch"));
        }
        return f8978b.booleanValue();
    }

    private static boolean b(Context context) {
        if (f8979c == null) {
            f8979c = Boolean.valueOf(n.d() && context.getPackageManager().hasSystemFeature("cn.google"));
        }
        return f8979c.booleanValue();
    }

    public static boolean a(Context context) {
        if (!a(context.getPackageManager())) {
            return false;
        }
        if (n.e()) {
            return b(context) && !n.f();
        }
        return true;
    }
}
