package com.google.android.gms.internal.p001firebaseperf;

import android.content.Context;
import android.content.res.Resources;
import java.net.URI;

/* renamed from: com.google.android.gms.internal.firebase-perf.aj  reason: invalid package */
public final class aj {

    /* renamed from: a  reason: collision with root package name */
    private static String[] f9495a;

    public static boolean a(URI uri, Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("firebase_performance_whitelisted_domains", "array", context.getPackageName());
        if (identifier <= 0) {
            return true;
        }
        if (f9495a == null) {
            f9495a = resources.getStringArray(identifier);
        }
        for (String str : f9495a) {
            String host = uri.getHost();
            if (host == null || host.contains(str)) {
                return true;
            }
        }
        return false;
    }
}
