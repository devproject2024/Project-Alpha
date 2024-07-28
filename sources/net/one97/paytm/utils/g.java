package net.one97.paytm.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import com.paytm.notification.g;
import com.paytm.utility.q;

public final class g {
    public static void a(Context context, boolean z) {
        try {
            Intent intent = new Intent("android.intent.action.BADGE_COUNT_UPDATE");
            if (z) {
                intent.putExtra("badge_count", 0);
            } else {
                intent.putExtra("badge_count", a());
            }
            intent.putExtra("badge_count_package_name", context.getPackageName());
            intent.putExtra("badge_count_class_name", a(context));
            context.sendBroadcast(intent);
        } catch (Exception unused) {
        }
    }

    private static int a() {
        try {
            g.c cVar = com.paytm.notification.g.f43191a;
            return 0 + g.c.a();
        } catch (Exception e2) {
            q.b(e2.getMessage());
            return 0;
        }
    }

    private static String a(Context context) {
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.LAUNCHER");
        for (ResolveInfo next : packageManager.queryIntentActivities(intent, 0)) {
            if (next.activityInfo.applicationInfo.packageName.equalsIgnoreCase(context.getPackageName())) {
                return next.activityInfo.name;
            }
        }
        return null;
    }
}
