package com.google.android.gms.common.util;

import android.content.Context;
import android.content.pm.PackageManager;
import com.google.android.gms.common.c.c;

public final class d {
    public static boolean a(Context context, String str) {
        "com.google.android.gms".equals(str);
        try {
            if ((c.a(context).a(str, 0).flags & 2097152) != 0) {
                return true;
            }
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }
}
