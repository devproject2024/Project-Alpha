package com.travel.utils;

import android.content.Context;
import com.google.android.play.core.splitcompat.a;
import java.lang.reflect.Method;

public final class q {

    /* renamed from: a  reason: collision with root package name */
    private static String f28550a = "TravelCoreUtils";

    public static void a(Context context) {
        a.a(context);
        a.b(context);
    }

    public static void b(Context context) {
        a.a(context);
    }

    public static com.travel.common.a.a a() {
        com.travel.common.a.a aVar;
        int i2 = 0;
        try {
            String[] strArr = new String[0];
            Method[] declaredMethods = Class.forName("net.one97.paytm.dynamic.flight.TravelDependencyProvider").getDeclaredMethods();
            int length = declaredMethods.length;
            aVar = null;
            while (i2 < length) {
                try {
                    Method method = declaredMethods[i2];
                    if (method.getName().equalsIgnoreCase("getInstance")) {
                        Object invoke = method.invoke((Object) null, strArr);
                        if (invoke instanceof com.travel.common.a.a) {
                            aVar = (com.travel.common.a.a) invoke;
                        }
                    }
                    i2++;
                } catch (Exception e2) {
                    e = e2;
                    com.paytm.utility.q.c(e.getMessage());
                    return aVar;
                }
            }
        } catch (Exception e3) {
            e = e3;
            aVar = null;
            com.paytm.utility.q.c(e.getMessage());
            return aVar;
        }
        return aVar;
    }

    public static void c(Context context) {
        a.a(context);
    }
}
