package com.business.common_module.utilities;

import android.app.Activity;
import android.content.Context;
import androidx.core.app.a;

public final class b {
    public static boolean a(Activity activity) {
        return androidx.core.content.b.a((Context) activity, "android.permission.WRITE_EXTERNAL_STORAGE") == 0 && androidx.core.content.b.a((Context) activity, "android.permission.READ_EXTERNAL_STORAGE") == 0;
    }

    public static void b(Activity activity) {
        a(activity, 102);
    }

    public static void a(Activity activity, int i2) {
        a.a(activity, new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}, i2);
    }

    public static boolean c(Activity activity) {
        return a.a((Context) activity, "android.permission.CAMERA") == 0;
    }

    public static void d(Activity activity) {
        a.a(activity, new String[]{"android.permission.CAMERA"}, 2);
    }
}
