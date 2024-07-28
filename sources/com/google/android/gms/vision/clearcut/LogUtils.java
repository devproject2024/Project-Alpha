package com.google.android.gms.vision.clearcut;

import android.content.Context;
import android.content.pm.PackageManager;
import com.google.android.gms.common.c.c;
import com.google.android.gms.internal.vision.bt;
import com.google.android.gms.internal.vision.ej;

public class LogUtils {
    public static bt.a zza(Context context) {
        bt.a.C0158a a2 = bt.a.a().a(context.getPackageName());
        String zzb = zzb(context);
        if (zzb != null) {
            a2.b(zzb);
        }
        return (bt.a) ((ej) a2.d());
    }

    private static String zzb(Context context) {
        try {
            return c.a(context).b(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e2) {
            com.google.android.gms.vision.c.a(e2, "Unable to find calling package info for %s", context.getPackageName());
            return null;
        }
    }
}
