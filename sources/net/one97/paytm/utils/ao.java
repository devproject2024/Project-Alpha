package net.one97.paytm.utils;

import com.google.firebase.crashlytics.c;

public final class ao {
    public static void a(Class cls, String str) {
        if (cls != null) {
            try {
                c.a().a(cls.getName().concat(str));
            } catch (Exception unused) {
            }
        }
    }
}
