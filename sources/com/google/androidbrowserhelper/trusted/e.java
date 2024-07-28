package com.google.androidbrowserhelper.trusted;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    private static String f37674a;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f37675a;

        /* renamed from: b  reason: collision with root package name */
        public final String f37676b;

        public a(int i2, String str) {
            this.f37675a = i2;
            this.f37676b = str;
        }
    }

    public static a a(PackageManager packageManager) {
        Intent data = new Intent().setAction("android.intent.action.VIEW").addCategory("android.intent.category.BROWSABLE").setData(Uri.parse("http://"));
        String str = f37674a;
        if (str != null) {
            data.setPackage(str);
        }
        List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(data, 65536);
        if (Build.VERSION.SDK_INT >= 23) {
            queryIntentActivities.addAll(packageManager.queryIntentActivities(data, 131072));
        }
        Map<String, Integer> b2 = b(packageManager);
        String str2 = null;
        String str3 = null;
        for (ResolveInfo resolveInfo : queryIntentActivities) {
            String str4 = resolveInfo.activityInfo.packageName;
            int intValue = b2.containsKey(str4) ? b2.get(str4).intValue() : 2;
            if (intValue == 0) {
                return new a(0, str4);
            }
            if (intValue != 1) {
                if (intValue == 2 && str3 == null) {
                    str3 = str4;
                }
            } else if (str2 == null) {
                str2 = str4;
            }
        }
        if (str2 != null) {
            return new a(1, str2);
        }
        return new a(2, str3);
    }

    private static Map<String, Integer> b(PackageManager packageManager) {
        List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(new Intent("android.support.customtabs.action.CustomTabsService"), 64);
        HashMap hashMap = new HashMap();
        for (ResolveInfo next : queryIntentServices) {
            String str = next.serviceInfo.packageName;
            int i2 = 0;
            if (a.b(packageManager, str)) {
                hashMap.put(str, 0);
            } else {
                if (next.filter != null && next.filter.hasCategory("androidx.browser.trusted.category.TrustedWebActivities")) {
                    i2 = 1;
                }
                hashMap.put(str, Integer.valueOf(i2 ^ 1));
            }
        }
        return hashMap;
    }
}
