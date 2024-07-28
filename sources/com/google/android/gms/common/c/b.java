package com.google.android.gms.common.c;

import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.Process;
import com.google.android.gms.common.util.n;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final Context f8654a;

    public b(Context context) {
        this.f8654a = context;
    }

    public final ApplicationInfo a(String str, int i2) throws PackageManager.NameNotFoundException {
        return this.f8654a.getPackageManager().getApplicationInfo(str, i2);
    }

    public final PackageInfo b(String str, int i2) throws PackageManager.NameNotFoundException {
        return this.f8654a.getPackageManager().getPackageInfo(str, i2);
    }

    public final boolean a(int i2, String str) {
        if (n.b()) {
            try {
                ((AppOpsManager) this.f8654a.getSystemService("appops")).checkPackage(i2, str);
                return true;
            } catch (SecurityException unused) {
                return false;
            }
        } else {
            String[] packagesForUid = this.f8654a.getPackageManager().getPackagesForUid(i2);
            if (!(str == null || packagesForUid == null)) {
                for (String equals : packagesForUid) {
                    if (str.equals(equals)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public final int a(String str) {
        return this.f8654a.checkCallingOrSelfPermission(str);
    }

    public final CharSequence b(String str) throws PackageManager.NameNotFoundException {
        return this.f8654a.getPackageManager().getApplicationLabel(this.f8654a.getPackageManager().getApplicationInfo(str, 0));
    }

    public final boolean a() {
        String nameForUid;
        if (Binder.getCallingUid() == Process.myUid()) {
            return a.a(this.f8654a);
        }
        if (!n.f() || (nameForUid = this.f8654a.getPackageManager().getNameForUid(Binder.getCallingUid())) == null) {
            return false;
        }
        return this.f8654a.getPackageManager().isInstantApp(nameForUid);
    }
}
