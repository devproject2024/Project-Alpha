package com.google.android.gms.internal.clearcut;

import android.content.Context;
import android.os.Build;
import android.os.UserManager;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private static volatile UserManager f9175a;

    /* renamed from: b  reason: collision with root package name */
    private static volatile boolean f9176b = (!a());

    private b() {
    }

    private static boolean a() {
        return Build.VERSION.SDK_INT >= 24;
    }

    public static boolean a(Context context) {
        return a() && !b(context);
    }

    private static boolean b(Context context) {
        boolean z = f9176b;
        if (!z) {
            UserManager userManager = f9175a;
            if (userManager == null) {
                synchronized (b.class) {
                    userManager = f9175a;
                    if (userManager == null) {
                        UserManager userManager2 = (UserManager) context.getSystemService(UserManager.class);
                        f9175a = userManager2;
                        if (userManager2 == null) {
                            f9176b = true;
                            return true;
                        }
                        userManager = userManager2;
                    }
                }
            }
            z = userManager.isUserUnlocked();
            f9176b = z;
            if (z) {
                f9175a = null;
            }
        }
        return z;
    }
}
