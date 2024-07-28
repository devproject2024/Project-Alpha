package com.google.android.gms.common;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.google.android.gms.common.c.c;
import com.google.android.gms.common.internal.ap;
import com.google.android.gms.common.util.i;

public class d {

    /* renamed from: a  reason: collision with root package name */
    private static final d f8657a = new d();

    /* renamed from: b  reason: collision with root package name */
    public static final int f8658b = h.f8688b;

    public static d b() {
        return f8657a;
    }

    d() {
    }

    public int a(Context context) {
        return a(context, f8658b);
    }

    public int a(Context context, int i2) {
        int a2 = h.a(context, i2);
        if (h.b(context, a2)) {
            return 18;
        }
        return a2;
    }

    public static void b(Context context) throws f, e {
        h.e(context);
    }

    public boolean a(int i2) {
        return h.b(i2);
    }

    public Intent a(Context context, int i2, String str) {
        if (i2 == 1 || i2 == 2) {
            if (context == null || !i.a(context)) {
                return ap.a("com.google.android.gms", a(context, str));
            }
            return ap.a();
        } else if (i2 != 3) {
            return null;
        } else {
            return ap.a("com.google.android.gms");
        }
    }

    public PendingIntent a(Context context, int i2, int i3) {
        return a(context, i2, i3, (String) null);
    }

    public final PendingIntent a(Context context, int i2, int i3, String str) {
        Intent a2 = a(context, i2, str);
        if (a2 == null) {
            return null;
        }
        return PendingIntent.getActivity(context, i3, a2, 134217728);
    }

    public static void c(Context context) {
        h.g(context);
    }

    public static int d(Context context) {
        return h.j(context);
    }

    public static boolean b(Context context, int i2) {
        return h.b(context, i2);
    }

    public String b(int i2) {
        return h.a(i2);
    }

    private static String a(Context context, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("gcore_");
        sb.append(f8658b);
        sb.append("-");
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
        }
        sb.append("-");
        if (context != null) {
            sb.append(context.getPackageName());
        }
        sb.append("-");
        if (context != null) {
            try {
                sb.append(c.a(context).b(context.getPackageName(), 0).versionCode);
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return sb.toString();
    }
}
