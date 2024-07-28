package com.paytm.notification.e;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import kotlin.g.b.k;

public final class a {
    public static ActivityInfo a(Class<?> cls, Context context) {
        k.c(cls, "activity");
        k.c(context, "context");
        Context applicationContext = context.getApplicationContext();
        k.a((Object) applicationContext, "context.applicationContext");
        String packageName = applicationContext.getPackageName();
        k.a((Object) packageName, "context.applicationContext.packageName");
        ComponentName componentName = new ComponentName(packageName, cls.getCanonicalName());
        try {
            PackageManager packageManager = context.getApplicationContext().getPackageManager();
            k.a((Object) packageManager, "context.getApplicationCo…ext().getPackageManager()");
            return packageManager.getActivityInfo(componentName, 128);
        } catch (Exception unused) {
            return null;
        }
    }
}
