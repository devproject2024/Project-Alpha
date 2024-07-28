package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.c.c;

public final class ay {

    /* renamed from: a  reason: collision with root package name */
    private static Object f8788a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static boolean f8789b;

    /* renamed from: c  reason: collision with root package name */
    private static String f8790c;

    /* renamed from: d  reason: collision with root package name */
    private static int f8791d;

    public static String a(Context context) {
        c(context);
        return f8790c;
    }

    public static int b(Context context) {
        c(context);
        return f8791d;
    }

    private static void c(Context context) {
        synchronized (f8788a) {
            if (!f8789b) {
                f8789b = true;
                try {
                    Bundle bundle = c.a(context).a(context.getPackageName(), 128).metaData;
                    if (bundle != null) {
                        f8790c = bundle.getString("com.google.app.id");
                        f8791d = bundle.getInt("com.google.android.gms.version");
                    }
                } catch (PackageManager.NameNotFoundException e2) {
                    Log.wtf("MetadataValueReader", "This should never happen.", e2);
                }
            }
        }
    }
}
