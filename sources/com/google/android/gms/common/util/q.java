package com.google.android.gms.common.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import com.google.android.gms.common.c.c;
import com.google.android.gms.common.h;
import com.google.android.gms.common.i;

public final class q {
    public static boolean a(Context context, int i2) {
        if (!a(context, i2, "com.google.android.gms")) {
            return false;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.google.android.gms", 64);
            i a2 = i.a(context);
            if (packageInfo != null) {
                if (i.a(packageInfo, false)) {
                    return true;
                }
                if (!i.a(packageInfo, true) || !h.f(a2.f8695a)) {
                    return false;
                }
                return true;
            }
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
            Log.isLoggable("UidVerifier", 3);
            return false;
        }
    }

    public static boolean a(Context context, int i2, String str) {
        return c.a(context).a(i2, str);
    }
}
