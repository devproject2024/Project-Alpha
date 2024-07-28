package com.paytm.utility;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import androidx.core.app.a;

public abstract class s {
    public static boolean a(int[] iArr) {
        if (iArr.length <= 0) {
            return false;
        }
        for (int i2 : iArr) {
            if (i2 != 0) {
                return false;
            }
        }
        return true;
    }

    public static int a(String[] strArr, int[] iArr, String str, Activity activity) {
        int length = strArr.length;
        int i2 = 0;
        while (i2 < length) {
            String str2 = strArr[i2];
            if (iArr[i2] != -1) {
                i2++;
            } else if (!a.a(activity, str2)) {
                return 0;
            } else {
                if (str.equals(str2)) {
                    return 1;
                }
                return -1;
            }
        }
        return -1;
    }

    public static boolean a() {
        return Build.VERSION.SDK_INT >= 23;
    }

    public static boolean b() {
        return Build.VERSION.SDK_INT > 23;
    }

    public static boolean a(Context context) {
        return a.a(context, "android.permission.READ_PHONE_STATE") == 0;
    }

    public static boolean a(Activity activity) {
        return a.a((Context) activity, "android.permission.CAMERA") == 0;
    }

    public static void b(Context context) {
        Intent intent = new Intent();
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", context.getPackageName(), (String) null));
        context.startActivity(intent);
    }

    public static boolean c(Context context) {
        return a.a(context, "android.permission.READ_CONTACTS") == 0;
    }

    public static void b(Activity activity) {
        a.a(activity, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 56);
    }

    public static boolean c(Activity activity) {
        return a.a((Context) activity, "android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }

    public static boolean d(Context context) {
        return a.a(context, "android.permission.READ_SMS") == 0;
    }

    public static void d(Activity activity) {
        a.a(activity, new String[]{"android.permission.ACCESS_FINE_LOCATION"}, 57);
    }

    public static boolean e(Context context) {
        return a.a(context, "android.permission.ACCESS_FINE_LOCATION") == 0;
    }

    public static boolean e(Activity activity) {
        return a.a((Context) activity, "android.permission.WRITE_CONTACTS") == 0;
    }
}
