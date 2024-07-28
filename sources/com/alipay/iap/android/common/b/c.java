package com.alipay.iap.android.common.b;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import com.business.merchant_payments.common.utility.AppUtility;
import java.util.Locale;

public class c {

    /* renamed from: a  reason: collision with root package name */
    public static String f14684a = "LoggerWrapper";

    /* renamed from: b  reason: collision with root package name */
    private static boolean f14685b = false;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f14686c = false;

    /* renamed from: d  reason: collision with root package name */
    private static a f14687d = new a() {
        public final boolean a() {
            return Log.isLoggable(c.f14684a, 2);
        }
    };

    public static void b() {
    }

    public static void c() {
    }

    public static void d() {
    }

    public static void e() {
    }

    public static void f() {
    }

    public static void g() {
    }

    public static void h() {
    }

    public static void i() {
    }

    public static void j() {
    }

    private c() {
    }

    public static void a(Context context) {
        f14686c = b(context) | f14686c;
    }

    private static boolean b(Context context) {
        if (f14685b) {
            return f14687d.a();
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            return (applicationInfo == null || (applicationInfo.flags & 2) == 0) ? false : true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public static boolean a() {
        return f14686c;
    }

    public static void a(a aVar) {
        f14687d = aVar;
        f14685b = true;
        f14686c = aVar.a();
    }

    public static String a(String str, Object... objArr) {
        String str2;
        String format = String.format(Locale.US, str, objArr);
        StackTraceElement[] stackTrace = new Throwable().fillInStackTrace().getStackTrace();
        int i2 = 2;
        while (true) {
            if (i2 >= stackTrace.length) {
                str2 = "<unknown>";
                break;
            } else if (!stackTrace[i2].getClass().equals(c.class)) {
                String className = stackTrace[i2].getClassName();
                String substring = className.substring(className.lastIndexOf(46) + 1);
                str2 = substring.substring(substring.lastIndexOf(36) + 1) + AppUtility.CENTER_DOT + stackTrace[i2].getMethodName();
                break;
            } else {
                i2++;
            }
        }
        return String.format(Locale.US, "[%d] %s: %s", new Object[]{Long.valueOf(Thread.currentThread().getId()), str2, format});
    }
}
