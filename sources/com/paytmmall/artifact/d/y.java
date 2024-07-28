package com.paytmmall.artifact.d;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import androidx.core.app.a;

public abstract class y {
    public static boolean a() {
        return Build.VERSION.SDK_INT >= 23;
    }

    public static void a(Activity activity) {
        a.a(activity, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 56);
    }

    public static boolean b(Activity activity) {
        return a.a((Context) activity, "android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }
}
