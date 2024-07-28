package com.google.android.play.core.d;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import com.google.android.play.core.b.b;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class aw {

    /* renamed from: a  reason: collision with root package name */
    private static final b f37364a = new b("SplitInstallInfoProvider");

    /* renamed from: b  reason: collision with root package name */
    private final Context f37365b;

    /* renamed from: c  reason: collision with root package name */
    private final String f37366c;

    public aw(Context context, String str) {
        this.f37365b = context;
        this.f37366c = str;
    }

    public static boolean a(String str) {
        return str.startsWith("config.");
    }

    private final Bundle d() {
        try {
            ApplicationInfo applicationInfo = this.f37365b.getPackageManager().getApplicationInfo(this.f37366c, 128);
            if (applicationInfo != null && applicationInfo.metaData != null) {
                return applicationInfo.metaData;
            }
            f37364a.a("App has no applicationInfo or metaData", new Object[0]);
            return null;
        } catch (PackageManager.NameNotFoundException unused) {
            f37364a.e("App is not found in PackageManager", new Object[0]);
            return null;
        }
    }

    public final Set<String> a() {
        HashSet hashSet = new HashSet();
        for (String next : c()) {
            if (!b(next)) {
                hashSet.add(next);
            }
        }
        return hashSet;
    }

    public final ag b() {
        Bundle d2 = d();
        if (d2 == null) {
            f37364a.e("No metadata found in Context.", new Object[0]);
            return null;
        }
        int i2 = d2.getInt("com.android.vending.splits");
        if (i2 == 0) {
            f37364a.e("No metadata found in AndroidManifest.", new Object[0]);
            return null;
        }
        try {
            ag a2 = new ac(this.f37365b.getResources().getXml(i2)).a();
            if (a2 == null) {
                f37364a.e("Can't parse languages metadata.", new Object[0]);
            }
            return a2;
        } catch (Resources.NotFoundException unused) {
            f37364a.e("Resource with languages metadata doesn't exist.", new Object[0]);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final Set<String> c() {
        HashSet hashSet = new HashSet();
        Bundle d2 = d();
        if (d2 != null) {
            String string = d2.getString("com.android.dynamic.apk.fused.modules");
            if (string == null || string.isEmpty()) {
                f37364a.a("App has no fused modules.", new Object[0]);
            } else {
                Collections.addAll(hashSet, string.split(AppConstants.COMMA, -1));
                hashSet.remove("");
                hashSet.remove("base");
            }
        }
        if (Build.VERSION.SDK_INT >= 21) {
            String[] strArr = null;
            try {
                PackageInfo packageInfo = this.f37365b.getPackageManager().getPackageInfo(this.f37366c, 0);
                if (packageInfo != null) {
                    strArr = packageInfo.splitNames;
                }
            } catch (PackageManager.NameNotFoundException unused) {
                f37364a.e("App is not found in PackageManager", new Object[0]);
            }
            if (strArr != null) {
                f37364a.a("Adding splits from package manager: %s", Arrays.toString(strArr));
                Collections.addAll(hashSet, strArr);
            } else {
                f37364a.a("No splits are found or app cannot be found in package manager.", new Object[0]);
            }
            au a2 = av.a();
            if (a2 != null) {
                hashSet.addAll(a2.a());
            }
        }
        return hashSet;
    }

    public static boolean b(String str) {
        return str.startsWith("config.") || str.contains(".config.");
    }
}
