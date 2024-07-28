package com.google.androidbrowserhelper.trusted;

import android.content.pm.PackageManager;
import android.os.Build;
import java.util.Arrays;
import java.util.List;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    static final List<String> f37628a = Arrays.asList(new String[]{"com.chrome.beta", "com.android.chrome"});

    /* renamed from: b  reason: collision with root package name */
    private static final List<String> f37629b = Arrays.asList(new String[]{"com.google.android.apps.chrome", "org.chromium.chrome", "com.chrome.canary", "com.chrome.dev", "com.chrome.beta", "com.android.chrome"});

    /* renamed from: c  reason: collision with root package name */
    private static final List<String> f37630c = Arrays.asList(new String[]{"com.google.android.apps.chrome", "org.chromium.chrome"});

    public static boolean a(String str) {
        return f37629b.contains(str);
    }

    public static boolean a(PackageManager packageManager, String str) {
        if (!f37629b.contains(str)) {
            return false;
        }
        return a(packageManager, str, 380900000);
    }

    public static boolean b(PackageManager packageManager, String str) {
        if (!f37629b.contains(str)) {
            return false;
        }
        return a(packageManager, str, 362600000);
    }

    public static boolean c(PackageManager packageManager, String str) {
        if (!f37629b.contains(str)) {
            return true;
        }
        return a(packageManager, str, 368300000);
    }

    public static boolean d(PackageManager packageManager, String str) {
        if (!f37629b.contains(str)) {
            return false;
        }
        return a(packageManager, str, 389000000);
    }

    private static boolean a(PackageManager packageManager, String str, int i2) {
        if (!f37630c.contains(str) && e(packageManager, str) < i2) {
            return false;
        }
        return true;
    }

    static int e(PackageManager packageManager, String str) {
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                return (int) packageManager.getPackageInfo(str, 0).getLongVersionCode();
            }
            return packageManager.getPackageInfo(str, 0).versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            return 0;
        }
    }
}
