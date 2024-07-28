package com.paytm.notification.c;

import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.paytm.notification.b.e;
import com.paytm.notification.models.request.DeviceDetails;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.upi.util.UpiContract;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static DeviceDetails f43022a;

    /* renamed from: b  reason: collision with root package name */
    public static final b f43023b = new b();

    /* renamed from: c  reason: collision with root package name */
    private static String f43024c;

    private b() {
    }

    public static String a(Context context) {
        try {
            String string = Settings.Secure.getString(context.getContentResolver(), UpiContract.DeviceInfoColumns.ANDROID_ID);
            f43024c = string;
            if (!TextUtils.isEmpty(string)) {
                return f43024c;
            }
            return null;
        } catch (Exception e2) {
            e.f43014a.b(e2, "Device id not found  ", new Object[0]);
            return null;
        }
    }

    public static String b(Context context) {
        try {
            DisplayMetrics c2 = c(context);
            if (c2 != null) {
                if (Math.sqrt(Math.pow(((double) c2.widthPixels) / ((double) c2.densityDpi), 2.0d) + Math.pow(((double) c2.heightPixels) / ((double) c2.densityDpi), 2.0d)) >= 7.0d) {
                    return "tablet";
                }
                return "mobile";
            }
        } catch (Exception e2) {
            e.f43014a.b(e2, "Device category calculation failed", new Object[0]);
        }
        return "mobile";
    }

    public static DisplayMetrics c(Context context) {
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            Object systemService = context.getSystemService("window");
            if (systemService != null) {
                ((WindowManager) systemService).getDefaultDisplay().getMetrics(displayMetrics);
                return displayMetrics;
            }
            throw new u("null cannot be cast to non-null type android.view.WindowManager");
        } catch (Exception e2) {
            e.f43014a.b(e2, "Device display calculation failed", new Object[0]);
            return null;
        }
    }

    public static String d(Context context) {
        k.c(context, "incontext");
        return a(context);
    }
}
